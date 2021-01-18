package com.newland.bd.component.common.ext.date.retree;

/**
 * This node support '^' and '\A'
 *
 * @author sulin
 */
public final class AnchorStartNode extends Node {

    @Override
    public boolean match(ReMatcher matcher, CharSequence input, int cursor) {
        if (cursor != matcher.from) {
            return false;
        }
        return next.match(matcher, input, cursor);
    }

    @Override
    public boolean alike(Node node) {
        return node instanceof AnchorStartNode;
    }

}
