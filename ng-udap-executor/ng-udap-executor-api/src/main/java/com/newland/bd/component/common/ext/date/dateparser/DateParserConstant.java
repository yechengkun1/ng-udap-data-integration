package com.newland.bd.component.common.ext.date.dateparser;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认规则库
 */
public final class DateParserConstant {
    static final List<String> PATTERNS = new ArrayList<>();

    static {
//        yyyy-MM-dd, yyyy/MM/dd...
        PATTERNS.add("(?<year>\\d{4})\\W{1}(?<month>\\d{1,2})\\W{1}(?<day>\\d{1,2})[^\\d]?");
        // yyyy-MM, yyyy/MM...
        PATTERNS.add("^(?<year>\\d{4})\\W{1}(?<month>\\d{1,2})$");
        // yyyy-MM, yyyy/MM...
        PATTERNS.add("^(?<month>\\d{1,2})\\W{1}(?<year>\\d{4})$");
        // dd/MM/yyyy
        PATTERNS.add("(?<dayOrMonth>\\d{1,2}\\W{1}\\d{1,2})\\W{1}(?<year>\\d{4})[^\\d]?");
        // yyyy
        PATTERNS.add("(?<year>\\d{4})$");
        // yyyyMM
        PATTERNS.add("^(?<year>\\d{4})(?<month>\\d{2})$");
        // yyyyMMddhh(10),这个时间和1970到现在的秒数一样10位. 我们优先匹配yyyyMMdd,匹配不上的,使用秒数解析. 这个格式可能会和hive出来的秒Timsap格式冲突
        PATTERNS.add("^(?<yyyyMMddhh>\\d{10})$");
        // yyyyMMddhhmm
        PATTERNS.add("^(?<year>\\d{4})(?<month>\\d{2})(?<day>\\d{2})(?<hour>\\d{2})(?<minute>\\d{2})$");
        // yyyyMMddhhmmss
        PATTERNS.add("^(?<year>\\d{4})(?<month>\\d{2})(?<day>\\d{2})(?<hour>\\d{2})(?<minute>\\d{2})(?<second>\\d{2})$");
        PATTERNS.add("^(?<year>\\d{4})(?<month>\\d{2})(?<day>\\d{2})(?<hour>\\d{2})(?<minute>\\d{2})(?<second>\\d{2})$");
        // dd/MM/yy, MM/dd/yy
        PATTERNS.add("(?<dayOrMonth>\\d{1,2}[./]\\d{1,2})[./](?<year>\\d{2})$");
        PATTERNS.add("(?<dayOrMonth>\\d{1,2}[./]\\d{1,2})[./](?<year>\\d{2})[^:\\d]");
//        // millisecond(13)
        PATTERNS.add("^(?<millisecond>\\d{13})$");
//        // yyyyMMdd
        PATTERNS.add("^(?<year>\\d{4})(?<month>\\d{2})(?<day>\\d{2})$");
        // at hh:mm:ss.SSS
        PATTERNS.add("\\W*(?:at )?(?<hour>\\d{1,2}):(?<minute>\\d{1,2})(?::(?<second>\\d{1,2}))?(?:[.,](?<SSS>\\d{1,3}))?");
    }
}
