package com.manage.intelligence.bean;



import java.io.Serializable;

/**
 *

 * @description: 返回数据基类

 *
 */
public class BaseRequestBean implements Serializable {

    public int code;
    public String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

