package com.newland.bd.submitter.common.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 基础BEAM类.
 */
public class BaseBean implements Serializable {

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, false);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}