package com.manage.intelligence.service;

import com.manage.intelligence.bean.login.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * @author: XuChi
 * @version: V1.0
 * @project: xcf_user_new
 * @package: io.cxc.user.service
 * @description: description
 * @date: 2019/8/13
 * @time: 17:52
 */
public interface HttpService {


//
//    /**
//     * 获取 添加购物车或者删减商品(有规格)
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("v3/useraddGoodshopcart")
//    Observable<RequestSucceedBean> getUseraddGoodsshopcar(@Field("mer_gid") String mer_gid, @Field("spec_id") int spec_id,
//                                                          @Field("mer_id") String mer_id, @Field("attr_sel") String attr_sel, @Field("num") int num);
//
//

    @FormUrlEncoded
    @POST("APPService.asmx/Login")
    Observable<LoginBean> getLogingData(@Field("json") String value);
//

}
