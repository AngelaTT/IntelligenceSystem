package com.manage.intelligence.base;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import okhttp3.OkHttpClient;

public class MyApplication extends Application {

    private static  MyApplication mInstance;
//    private AppDatabase appDB;
    @Override
    public void onCreate() {
        super.onCreate();



        //初始化网络框架
        AndroidNetworking.initialize(getApplicationContext());
        //初始化网络框架二
//        OkGo.getInstance().init(this);
        mInstance = this;
//        appDB = Room.databaseBuilder(this,AppDatabase.class,"user_info")
//                .addMigrations()
//                .allowMainThreadQueries()
//                .build();

        ZXingLibrary.initDisplayOpinion(this);
    }

    public static MyApplication getInstance(){
        return mInstance;
    }

//    public AppDatabase getAppDB(){
//        return appDB;
//    }

}
