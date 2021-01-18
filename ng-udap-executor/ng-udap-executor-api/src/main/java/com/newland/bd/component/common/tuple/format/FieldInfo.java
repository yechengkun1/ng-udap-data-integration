package com.newland.bd.component.common.tuple.format;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 单个字段格式定义
 * User: YECK
 * Date: 2019/9/17
 */
public class FieldInfo {
    private String code; //字段英文code
    private String name; //字段中文名
    private String type; //字段类型
    private String expression; //字段表达式
    private String format; //数据格式
    private String alias; //字段别名

    private FieldInfo() {

    }

    public FieldInfo(String code, String name, String type, String expression, String format, String alias) {
        this.code = code;
        this.name = name;
        this.type = type.toUpperCase();
        this.expression = expression;
        this.format = format;
        this.alias = alias;
    }

    public FieldInfo(String code, String name, String type, String expression, String format) {
        this.code = code;
        this.name = name;
        this.type = type.toUpperCase();
        this.expression = expression;
        this.format = format;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.toUpperCase();
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        FieldInfo fieldInfo = (FieldInfo) o;

        return new EqualsBuilder().append(code, fieldInfo.code)
                                  .append(name, fieldInfo.name)
                                  .append(type, fieldInfo.type)
                                  .append(expression, fieldInfo.expression)
                                  .append(format, fieldInfo.format)
                                  .append(alias, fieldInfo.alias)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(code).append(name).append(type).append(expression).append(format).append(alias).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code)
                                        .append("name", name)
                                        .append("type", type)
                                        .append("expression", expression)
                                        .append("format", format)
                                        .append("alias", alias)
                                        .toString();
    }
}