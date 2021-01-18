package com.newland.bd.component.common.ext.date.retree;

/**
 * This node support single char like [a-z]
 *
 * @author sulin
 */
public final class CharRangeNode extends CharNode {

    private final int lower;
    private final int upper;

    public CharRangeNode(final int lower, final int upper) {
        super(true);
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    protected boolean isMatch(int ch) {
        return (lower <= ch && ch <= upper);
    }

    @Override
    public boolean alike(Node node) {
        return node instanceof CharRangeNode
                && lower == ((CharRangeNode) node).lower
                && upper == ((CharRangeNode) node).upper
                && matched == ((CharRangeNode) node).matched;
    }
}