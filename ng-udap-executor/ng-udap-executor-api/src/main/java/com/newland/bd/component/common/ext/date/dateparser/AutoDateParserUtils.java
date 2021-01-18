package com.newland.bd.component.common.ext.date.dateparser;

import com.newland.bd.component.common.exception.ComponentCommonError;
import com.newland.bd.component.common.exception.ComponentException;
import com.newland.bd.component.common.ext.date.retree.ReMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * 文本转时间工具类..
 * User: YECK
 * Date: 2019/11/14
 */
public final class AutoDateParserUtils {
    private static final Logger logger = LoggerFactory.getLogger(AutoDateParserUtils.class);
    //解决多线程问题
    private static final ThreadLocal<AutoDateParserUtils> dateParser = new ThreadLocal<AutoDateParserUtils>() {
        @Override
        protected AutoDateParserUtils initialValue() {
            return new AutoDateParserUtils(DateParserConstant.PATTERNS);
        }
    };

    /**
     * 转换时间格式
     *
     * 如果遇到NULL 或者 null 或者 "" 或者 " " 这四种情况直接返回不处理
     * @param str 待转换的时间字符串
     * @return
     */
    public static String parseStandardTime(String str) {
        if (str != null && !str.isEmpty()) {
            if (str.equals("NULL") || str.equals("null") || str.equals(" ")) {
                return str;
            } else {
                return dateParser.get().parserDateInfo(str).getStandardTime();
            }
        }
        return "";
    }

    /**
     * 转换时间格式
     */
    public static Date parseDate(String str) {
        return dateParser.get().parserDateInfo(str).getDate();
    }

    private final ReMatcher matcher;
    private final DateInfo dateInfo = new DateInfo();
    private final List<String> rules;
    private String input;

    AutoDateParserUtils(List<String> rules) {
        this.rules = rules;
        this.matcher = new ReMatcher(this.rules.toArray(new String[0]));
    }

//    /**
//     * 转换时间
//     */
//    public Date parser(String str) {
//        return parserDateInfo(str).getDate();
//    }

    /**
     * 转换时间
     */
    public DateInfo parserDateInfo(String str) {
        try {
            this.dateInfo.reset();
            this.input = str;
            this.parse(str);
        } catch (Exception e) {
            logger.error("时间转换失败,无法转换字符{}", str, e);
            throw e;
        }
        return dateInfo;
    }

    private void parse(String str) {
        matcher.reset(str);
        final char[] input = str.toCharArray();
        int offset = 0;
        int oldEnd = -1;
        while (matcher.find(offset)) {
            if (oldEnd == matcher.end()) {
                throw error(offset, "empty matching at " + offset);
            }

            this.parseStandard(input, offset);

            offset = matcher.end();
            oldEnd = offset;
        }
        if (offset != input.length) {
            throw error(offset);
        }
    }

    void parseStandard(char[] input, int offset) {
        for (int index = 1; index <= matcher.groupCount(); index++) {
            final String groupName = matcher.groupName(index);
            final int startOff = matcher.start(index);
            final int endOff = matcher.end(index);
            if (groupName == null) {
                throw error(offset, "Hit invalid standard rule: " + matcher.re());
            }
            if (startOff == -1 && endOff == -1) {
                continue;
            }

            switch (groupName) {
                case "year":
                    dateInfo.year = parseYear(input, startOff, endOff);
                    break;
                case "month":
                    dateInfo.month = parseMonth(input, startOff, endOff);
                    if (dateInfo.month <= 0 || dateInfo.month > 12) {
                        throw error(startOff, "Invalid month at " + startOff);
                    }
                    break;
                case "day":
                    dateInfo.day = parseNum(input, startOff, endOff);
                    if (dateInfo.day <= 0 || dateInfo.day > 31) {
                        throw error(startOff, "Invalid day at " + startOff);
                    }
                    break;
                case "hour":
                    dateInfo.hour = parseNum(input, startOff, endOff);
                    if (dateInfo.hour >= 24) {
                        throw error(startOff, "Invalid hour at " + startOff);
                    }
                    break;
                case "minute":
                    dateInfo.minute = parseNum(input, startOff, endOff);
                    if (dateInfo.minute >= 60) {
                        throw error(startOff, "Invalid minute at " + startOff);
                    }
                    break;
                case "second":
                    dateInfo.second = parseNum(input, startOff, endOff);
                    if (dateInfo.second >= 60) {
                        throw error(startOff, "Invalid second at " + startOff);
                    }
                    break;
                case "SSS":
                    dateInfo.ssss = parseNum(input, startOff, endOff);
                    break;
                case "dayOrMonth":
                    parseDayOrMonth(input, startOff, endOff);
                    break;
                case "yyyyMMddhh":
                    int year = parseNum(input, startOff, startOff + 4);
                    int month = parseNum(input, startOff + 4, startOff + 6);
                    int day = parseNum(input, startOff + 6, startOff + 8);
                    int hour = parseNum(input, startOff + 8, startOff + 10);
                    //20xx年,认为是yyyyMMddhh. warn:这条规则并不严谨.在2033年后,会有小概率出现转换错误.基于业务场景,我们认为yyyyMMddHH的时间格式是更优先的
                    if (year >= 20 && (month <= 12) && (day <= 31) && (hour < 24)) {
                        dateInfo.year = year;
                        dateInfo.month = month;
                        dateInfo.day = day;
                        dateInfo.hour = hour;
                    } else {
                        dateInfo.millisecond = parseNum(input, startOff, startOff + 10) * 1000l;
                    }
                    break;
                case "millisecond":
                    dateInfo.millisecond = parseLong(input, startOff, endOff);
                    break;
                default:
                    throw error(offset, "Hit invalid standard rule: " + matcher.re());
            }
        }
    }

    void parseDayOrMonth(char[] input, int from, int to) {
        char next = input[from + 1];
        int a, b;
        if (next < '0' || next > '9') {
            a = parseNum(input, from, from + 1);
            b = parseNum(input, from + 2, to);
        } else {
            a = parseNum(input, from, from + 2);
            b = parseNum(input, from + 3, to);
        }
        if (a > 31 || b > 31 || a == 0 || b == 0 || (a > 12 && b > 12)) {
            throw error(from, "Invalid DayOrMonth at " + from);
        }
        // 默认将日期放前面.
        if (b > 12) {
            dateInfo.month = a;
            dateInfo.day = b;
        } else {
            dateInfo.day = a;
            dateInfo.month = b;
        }
    }

    int parseYear(char[] input, int from, int to) {
        switch (to - from) {
            case 4:
                return parseNum(input, from, to);
            case 2:
                int num = parseNum(input, from, to);
                return (num > 50 ? 1900 : 2000) + num;
            case 0:
                return 0;
            default:
                throw error(from, "Invalid year at " + from);
        }
    }

    int parseZoneOffset(char[] input, int from, int to) {
        boolean neg = input[from] == '-';
        int hour = parseNum(input, from + 1, from + 3);
        int minute = 0;
        switch (to - from) {
            case 5:
                minute = parseNum(input, from + 3, from + 5);
                break;
            case 6:
                minute = parseNum(input, from + 4, from + 6);
        }
        return (hour * 60 + minute) * (neg ? -1 : 1);
    }

    int parseMonth(char[] input, int from, int to) {
        if (to - from <= 2) {
            return parseNum(input, from, to);
        }

        throw error(from, "Invalid month at " + from);
    }

    private ComponentException error(int offset) {
        return error(offset, String.format("Text %s cannot parse at %d", input, offset));
    }

    private ComponentException error(int offset, String msg) {
        return new ComponentException(ComponentCommonError.C_COMMON_00003, "无法转换时间[" + input + "]." + msg);
    }

    static int parseNum(char[] input, int from, int to) {
        int num = 0;
        for (int i = from; i < to; i++) {
            num = num * 10 + (input[i] - '0');
        }
        return num;
    }

    static long parseLong(char[] input, int from, int to) {
        long num = 0;
        for (int i = from; i < to; i++) {
            num = num * 10l + (input[i] - '0');
        }
        return num;
    }
}
