package com.manage.intelligence.bean;



import java.io.Serializable;
import java.util.List;

/**
 *

 * @description: 返回数据基类

 *
 */
public class BaseResponseBean<T> implements Serializable {

    public String result;
    public List<T> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponseBean{" +
                "result='" + result + '\'' +
                ", data=" + data +
                '}';
    }
}

