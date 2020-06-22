package com.manage.intelligence.exception;

import java.io.IOException;

/**
 * @author: XuChi
 * @version: V1.0
 * @project: xcf_user_new
 * @package: io.cxc.user.exception
 * @description: 请求错误信息异常
 * @date: 2019/8/14
 * @time: 9:58
 */
public class DataResultException extends IOException {
    private String result;
    private String data;

    public DataResultException(String result, String data) {
        this.result = result;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
