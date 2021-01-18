package com.newland.bd.component.common.ext.date.retree;

import java.util.Arrays;

/**
 * This node supports [abcde], only supports Latin-1 char.
 *
 * @author sulin
 */
public final class CharSetNode extends CharNode {

    private final boolean[] bits = new boolean[256];

    public CharSetNode() {
        super(true);
    }

    @Override
    protected boolean isMatch(int ch) {
        return (ch < 256 && bits[ch]);
    }

    @Override
    public boolean alike(Node node) {
        return node instanceof CharSetNode
                && Arrays.equals(bits, ((CharSetNode) node).bits)
                && matched == ((CharSetNode) node).matched;
    }

    public CharSetNode add(int c) {
        bits[c] = true;
        return this;
    }

}