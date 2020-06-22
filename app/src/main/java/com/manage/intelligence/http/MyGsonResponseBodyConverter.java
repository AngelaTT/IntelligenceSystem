package com.manage.intelligence.http;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;


import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author: XuChi
 * @version: V1.0
 * @project: xcf_user_new
 * @package: io.cxc.user.http
 * @description: description
 * @date: 2019/8/14
 * @time: 11:48
 */
public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private Gson gson;
    private Type type;

    public MyGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        Log.e("txh",response);
        try {
            return gson.fromJson(response, type);
           /* BaseResponseBean baseBean = gson.fromJson(response, type);

            if (baseBean.getResult().equals("OK")) {
                Log.e("OK","登录成功");
                return gson.fromJson(response, type);
                //throw new DataResultException(baseBean.getData(), baseBean.getResult());
            } else if(baseBean.getResult().equals("NG") ){
                throw new DataResultException(baseBean.getData().toString(), baseBean.getResult());
            }else {
                throw new LoginFailException();
            }*/
        } finally {
            value.close();
        }
    }
}
