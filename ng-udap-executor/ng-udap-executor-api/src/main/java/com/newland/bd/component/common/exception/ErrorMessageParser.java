package com.newland.bd.component.common.exception;

/**
 * Create by zhouxinhai on 2020/2/17
 */
public final class ErrorMessageParser {
    private ErrorMessageParser(){
    }

    /**
     * 将异常转换成外部需要的异常.
     *
     * @param e 异常
     */
    public static String getErrorMessage(Throwable e) {
        if (e.getMessage() == null || e.getMessage().isEmpty()) {
            if (e.getCause() == null) {
                return e.toString(); //e信息就是未空
            } else {
                return getErrorMessage(e.getCause());
            }
        } else {
            return e.getMessage();
        }
    }
}
