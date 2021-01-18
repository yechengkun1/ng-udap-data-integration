package com.newland.bd.component.common.tuple.parse;

import com.newland.bd.component.common.exception.ComponentCommonError;
import com.newland.bd.component.common.exception.ComponentException;
import com.newland.bd.component.common.ext.date.dateparser.AutoDateParserUtils;
import com.newland.bd.component.common.tuple.ColumnType;
import com.newland.bd.component.common.tuple.format.FieldInfo;
import com.newland.bd.component.common.tuple.format.ITupleFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 截取和替换字符串中的某列时间格式..将所有date格式的数据转换成标准格式
 * 采用高效StringBuilder替换
 * User: YECK
 * Date: 2019/11/18
 */
public class DateColumnFomratUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateColumnFomratUtils.class);
    private final ITupleFormat inputFormat;
    private final List<Integer> dateColumns;  //哪些字段是date类型
    private final String separator;

    public DateColumnFomratUtils(ITupleFormat inputFormat) {
        this.inputFormat = inputFormat;
        separator = this.inputFormat.getFieldDelimiter();
        dateColumns = new ArrayList<>();
        int i = 0;
        //如果有存在组件需要做格式format的场景,则需要重组字段.为了标准化date字段值
        for (FieldInfo info : inputFormat.getFields()) {
            if (ColumnType.DATE.name().equals(info.getType().toUpperCase())) {
                dateColumns.add(i);
            }
            i++;
        }
        logger.info("替换时间列{}", this.dateColumns);
    }

    /**
     * 比原始String用正则替换方式效率高2倍
     *
     * @param sb
     * @return
     */
    public StringBuilder formatDateColumn(StringBuilder sb) {
        int separatorLength = this.separator.length();
        int currentColumnIndex = 0; //当前遍历到哪个字段了
        int columnStart = 0; //当前字段开始
        int columnEnd = 0;
        int dateColumnIteratorId = 0;
        int nextDateColumnIndex = dateColumns.get(dateColumnIteratorId);
        try {

            do {
                columnEnd = sb.indexOf(this.separator, columnStart);
                //当前字段是否是时间格式字段
                if (nextDateColumnIndex == currentColumnIndex) {
                    if (columnEnd < 0) {
                        columnEnd = sb.length();
                    }
                    //这个值需要替换.
                    String dateValue = sb.substring(columnStart, columnEnd);

                    //这里如果有需要,可以增加手动指定format支持
                    String newDate = formatDate(dateValue);
                    //替换这个时间内容
                    sb.replace(columnStart, columnEnd, newDate);
                    columnEnd += newDate.length() - dateValue.length(); //重新设置当前字段结束位置
                    dateColumnIteratorId++;
                    //如果已经是最后一个date字段了,可以直接推出
                    if (dateColumnIteratorId >= dateColumns.size()) {
                        nextDateColumnIndex = -1;
                        break;
                    } else //设置下一个要匹配的列
                    {
                        nextDateColumnIndex = dateColumns.get(dateColumnIteratorId);
                    }
                }
                //指针移动到下一行
                currentColumnIndex++;
                columnStart = columnEnd + separatorLength;
            } while (nextDateColumnIndex > 0);
        } catch (Exception e) {
            logger.error("输入格式:{},  时间字段位置{}.分隔符[{}]   ", inputFormat.getFields(), this.dateColumns, this.inputFormat.getFieldDelimiter());
            String reason = null;
            String[] column = sb.toString().split(this.separator);
            if (column.length < inputFormat.getFields().size()) {
                reason = String.format("记录字段数不足.字段数[%s]少于要求个数[%s].记录内容[%s]", column.length, inputFormat.getFields().size(), sb.toString());
            } else {
                String errorColumn = column[currentColumnIndex];
                logger.error("出错字段值{},当前记录split成字段数{},字段列表{}", errorColumn, column.length, Arrays.toString(column));
                reason = String.format("转换原始数据[%s].的第[%s]个字段值[%s]发生错误,字段分隔符[%s]",
                                       sb,
                                       String.valueOf(currentColumnIndex + 1),
                                       errorColumn,
                                       this.separator);
            }
            throw new ComponentException(ComponentCommonError.C_COMMON_00003, reason);
        }
        return sb;
    }

    /**
     * 转换时间字段格式
     *
     * @param dateValue
     * @return
     */
    private String formatDate(String dateValue) {
        String newDate = AutoDateParserUtils.parseStandardTime(dateValue);
        return newDate;
    }
}