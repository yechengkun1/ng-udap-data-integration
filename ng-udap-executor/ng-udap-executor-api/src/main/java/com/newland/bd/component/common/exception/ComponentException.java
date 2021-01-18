package com.newland.bd.component.common.exception;

import com.newland.bd.ngudap.exception.base.BaseRuntimeException;
import com.newland.bd.ngudap.exception.base.ErrorCode;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 定义错误类型
 */
public class ComponentException extends BaseRuntimeException {

    public ComponentException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    private ComponentException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public static ComponentException asComponentException(ErrorCode errorCode, String message) {
        return new ComponentException(errorCode, message);
    }

    public static ComponentException asComponentException(ErrorCode errorCode, String message, Throwable cause) {
        if (cause instanceof ComponentException) {
            return (ComponentException) cause;
        }
        return new ComponentException(errorCode, message, getCaseException(cause));
    }

    public static ComponentException asComponentException(ErrorCode errorCode, Throwable cause) {
        if (cause instanceof ComponentException) {
            return (ComponentException) cause;
        }
        return new ComponentException(errorCode, ErrorMessageParser.getErrorMessage(cause), getCaseException(cause));
    }

    public ErrorCode getErrorCode() {
        return super.getCode();
    }

    /**
     * 将异常类转成new RuntimeException(String),原生异常类跨classloader传递,会有包问题.
     *
     * @param caseException
     * @return
     */
    public static RuntimeException getCaseException(Throwable caseException) {
        if (caseException == null) {
            return null;
        }
        StringWriter str = new StringWriter();
        PrintWriter pw = new PrintWriter(str);
        ((Throwable) caseException).printStackTrace(pw);
        return new RuntimeException(str.toString());
    }
}
