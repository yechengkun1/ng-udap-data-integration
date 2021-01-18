package com.newland.bd.component.common.ext.date.retree;

/**
 * This node supports one single char, like 'A'
 *
 * @author sulin
 */
public final class CharSingleNode extends CharNode {

    final int ch;

    public CharSingleNode(int c) {
        super(true);
        this.ch = c;
    }

    @Override
    public String toString() {
        return String.valueOf((char) ch);
    }

    @Override
    protected boolean isMatch(int ch) {
        return (ch == this.ch);
    }

    @Override
    public boolean alike(Node node) {
        return node instanceof CharSingleNode
                && ch == ((CharSingleNode) node).ch
                && matched == ((CharSingleNode) node).matched;
    }
}