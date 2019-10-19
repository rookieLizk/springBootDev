package com.mould.boot.exception;

/**
 * @author lizk
 * @date 2019-08-24 14:57
 * @since
 **/
public class BaseException extends RuntimeException {

    private String errorKey;

    private Object[] values;

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    public BaseException(String errorKey, Object... values) {
        this.errorKey = errorKey;
        this.values = values;
    }
}
