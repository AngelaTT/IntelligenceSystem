package com.manage.intelligence.exception;

/**
 * @author: XuChi
 * @version: V1.0
 * @project: xcf_user_new
 * @package: io.cxc.user.exception
 * @description: 自定义异常
 * @date: 2019/8/13
 * @time: 17:43
 */
public class CommonException extends RuntimeException {
    private String mErrorMsg;

    public CommonException(String errorMsg) {
        mErrorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return mErrorMsg;
    }

}

