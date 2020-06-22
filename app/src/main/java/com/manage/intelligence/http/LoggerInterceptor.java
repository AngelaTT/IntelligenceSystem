package com.manage.intelligence.http;

import android.content.Context;
import android.text.TextUtils;

import com.manage.intelligence.utils.Constants;
import com.manage.intelligence.utils.SPUtils;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @author: XuChi
 * @version: V1.0
 * @project: xcf_user_new
 * @package: io.cxc.user.http
 * @description: http拦截器（打印日志以及拦截header里的token）
 * @date: 2019/8/14
 * @time: 10:26
 */
public class LoggerInterceptor implements Interceptor {


    private Context mContext;
    private final Charset UTF8 = Charset.forName("UTF-8");

    public LoggerInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody requestBody = request.body();
        String body = null;

        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            body = buffer.readString(charset);
        }

        Logger.i("发送请求\nmethod：%s\nurl：%s\nheaders: %sbody：%s",
                request.method(), request.url(), request.headers(), body);

        long startNs = System.nanoTime();
        Response response = chain.proceed(request);
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        ResponseBody responseBody = response.body();
        String rBody = null;

        if (response.body() != null) {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(UTF8);
                } catch (UnsupportedCharsetException e) {
                    e.printStackTrace();
                }
            }
            rBody = buffer.clone().readString(charset);
        }

        Logger.i("收到响应 %s%s %ss\n请求url：%s\n请求body：%s\n响应body：%s",
                response.code(), response.message(), tookMs, response.request().url(), body, rBody);
//        Log.d("响应body", rBody);
        String token = response.header("Token");
//        Log.e("txh","Token:"+token);
        if (token != null && !token.isEmpty()) {
            SPUtils.put(mContext, Constants.ASS_TOKEN, token);
        }

//        FileUtil instance = FileUtil.getInstance();
//        instance.init(mContext);
//        instance.writeLogtoFile("log","请求时间",("收到响应 \n " +tookMs+"ms"+"请求url：\n"+tookMs+response.request().url()));

        return response;

    }

    /**
     * 打印请求日志
     *
     * @param originalRequest
     * @return
     * @throws IOException
     */
    private void printRequestLog(Request originalRequest) throws IOException {
        FormBody.Builder formBuilder = new FormBody.Builder();
        String msg = originalRequest.url() + "";

//        if (MyApplication.get(mContext).getGlobalVariable().getUser() != null) {
//            msg += "&userId=" + MyApplication.get(mContext).getGlobalVariable().getUser().getUserId() + "&token=" + MyApplication.get(mContext).getGlobalVariable().getUser().getToken() + "\n";
//        } else {
//            msg += "\n";
//        }
        RequestBody oidBody = originalRequest.body();
        if (oidBody instanceof FormBody) {
            FormBody formBody = (FormBody) oidBody;
            for (int i = 0; i < formBody.size(); i++) {
                String name = URLDecoder.decode(formBody.encodedName(i), "utf-8");
                String value = URLDecoder.decode(formBody.encodedValue(i), "utf-8");
                if (!TextUtils.isEmpty(value)) {
                    formBuilder.add(name, value);
                    msg += name + "  =  " + value;
                }
            }
        }

        Logger.i(msg);
    }

    /**
     * 打印返回日志
     *
     * @param response
     * @throws IOException
     */
    private void printResult(Response response) throws IOException {
        ResponseBody responseBody = response.body();
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset UTF8 = Charset.forName("UTF-8");
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            UTF8 = contentType.charset(UTF8);
        }
        String a = buffer.clone().readString(UTF8);
        Logger.i(a);
    }

}


