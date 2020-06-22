package com.manage.intelligence.utils;

/**
 * 全局变量存储类
 *
 */
public class Constants {
    public static final String ASS_TOKEN = "ASS_TOKEN";
    public static final String BUGLY_ID = "581c367738";
    public static final String PHONE = "PHONE";
    public static final String PASSWORD = "PASSWORD";
    public static final String GET_PHONE_NUMBER = "GET_PHONE_NUMBER";
    public static final String INPUT_PHONE = "INPUT_PHONE";
    public static final String INPUT_PASSWORD = "INPUT_PASSWORD";
    public static final String TAG_BIND_FROME = "TAG_BIND_FROME";
    public static final String TAG_FORGET_FROME = "TAG_FORGET_FROME";

    public static final int BIND_PHONE = 1;//微信绑定手机号到输入手机
    public static final int BIND_FORGET_PHONE = 2;//忘记密码到输入手机界面
    public static final int BIND_FORGET_PAY_PHONE = 3;//忘记支付密码到输入手机界面

    public static final int TAG_FORGET = 1;//验证码登录到验证码界面
    public static final int TAG_FORGET_CODE = 2;//忘记密码到验证码界面
    public static final int TAG_BIND_PHONE_CODE = 3;//微信绑定手机号到验证码界面
    public static final int TAG_BIND_PHONE_PAY_CODE = 4;//忘记支付密码到验证码界面

    //1-账号密码登录、2-默认登录方式-验证码登录、3-微信登录、4-忘记密码
    public static final int PASSWORD_LOGIN = 1;
    public static final int MSM_CODE_LOGIN = 2;
    public static final int WEIXIN_LOGIN = 3;
    public static final int FORGET_PASSWORD = 4;

    public static final String IS_REALNAME = "is_realname";
    public static final String USER_ID = "USER_ID";
    public static final String SUCCEED = "SUCCEED";

    public static final String IS_FIRSH_INTO_APP = "IS_FIRSH_INTO_APP";
    /**
     * 城市
     */
    public static final String CITY = "city";
    /**
     * 地图中心点纬度
     */
    public static final String MAP_LATITUDE = "map_latitude";
    /**
     * 地图中心点经度
     */
    public static final String MAP_LONGITUDE = "map_longitude";
    /**
     * 真实定位纬度
     */
    public static final String REALITY_LATITUDE = "reality_latitude";
    /**
     * 真实定位经度
     */
    public static final String REALITY_LONGITUDE = "reality_longitude";

    public static final String RED_ID_INTENT = "red_packet_id_intent";
    public static final String RED_OSN_INTENT = "red_packet_osn_intent";
    public static final String COUNT_DOWN_INTENT = "count_down_intent";

    public static final String NICKNAME = "NICKNAME";

    public static final String ADDRESS_INTENT = "address_intent";

    public static final String STORE_NAME = "STORE_NAME";
    public static final String STORE_PAY_MONEY = "STORE_PAY_MONEY";

    public static final int FROM_COMPLAINT = 1;//从投诉界面过来
    public static final int FROM_SCAN_PAY = 2;//从扫一扫支付界面过来
    public static final int FROM_WITHDRAWAL = 3;//从提现界面过来

    public static final String LATITUDE = "LATITUDE";
    public static final String LONGITUDE = "LONGITUDE";

    public static final String SEARCH = "SEARCH";

    public static final String NEED_HOME_ZHIDAO = "NEED_HOME_ZHIDAO";
    public static final String NEED_BILL_ZHIDAO = "NEED_BILL_ZHIDAO";
    public static final String MER_TYPE = "MER_TYPE";
    public static final String PICTURE_FILE = "PictureFile";
}