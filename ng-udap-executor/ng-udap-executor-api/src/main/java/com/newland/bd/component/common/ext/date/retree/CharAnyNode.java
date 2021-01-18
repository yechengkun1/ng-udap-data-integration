package com.newland.bd.component.common.ext.date.retree;

/**
 * This CharNode supports '.', which means any char excludes whitespace.
 *
 * @author sulin
 */
public final class CharAnyNode extends CharNode {

    public CharAnyNode() {
        super(true);
    }

    @Override
    protected boolean isMatch(int ch) {
        return (ch != '\n' && ch != '\r' && (ch | 1) != '\u2029' && ch != '\u0085');
    }

    @Override
    public boolean alike(Node node) {
        return node instanceof CharAnyNode
                && matched == ((CharAnyNode) node).matched;
    }

    @Override
    public String toString() {
        return ".";
    }

}
