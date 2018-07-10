package cn.itbat.docker.tools.exception;

import org.apache.commons.lang.StringUtils;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-09 上午9:42
 **/
public class BaseException extends Exception {
    private static final long serialVersionUID = -238091758285157331L;
    private int errCode = 100;
    private String errMsg;

    public BaseException() {
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.errMsg = message;
    }

    public BaseException(String message) {
        super(message);
        this.errMsg = message;
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(int errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BaseException(int errCode, String errMsg, Throwable cause) {
        super(errCode + ":" + errMsg, cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
