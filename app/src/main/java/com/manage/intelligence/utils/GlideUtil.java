package com.manage.intelligence.utils;

import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.manage.intelligence.R;


/**
*作者:libao
*添加时间:2020/6/7 10:49
*修改人和时间: 2020/6/7 10:49
*说明:Glide 工具类
*/
public class GlideUtil {

    /**
    *作者:libao
    *添加时间:2020/6/7 10:56
    *修改人和时间: 2020/6/7 10:56
    * @param corners 圆角度
    * @param errRes 加载失败的图片
    * @param loadingRes 加载中的图片
    */
    public static RequestOptions getGlideOptions(int corners,int errRes,int loadingRes){
        MultiTransformation multi = new MultiTransformation(
                new RoundedCorners(corners == -1 ? 5 : corners) //设置图片圆角角度
        );
        RequestOptions options = new RequestOptions()
                .placeholder(loadingRes == 0 ? R.mipmap.ic_loading : loadingRes)
                .error(errRes == 0 ? R.mipmap.ic_default_picture : errRes)
                .bitmapTransform(multi);
        return options;
    }

    /**
     *作者:libao
     *添加时间:2020/6/7 10:56
     *修改人和时间: 2020/6/7 10:56
     */
    public static RequestOptions getGlideOptions(){
        RequestOptions options = getGlideOptions(-1, 0, 0);
        return options;
    }


}
