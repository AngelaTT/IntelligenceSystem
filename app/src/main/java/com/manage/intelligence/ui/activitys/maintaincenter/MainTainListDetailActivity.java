package com.manage.intelligence.ui.activitys.maintaincenter;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.manage.intelligence.R;
import com.manage.intelligence.base.BaseActivity;
import com.manage.intelligence.utils.ToastUtil;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
*作者:libao
*添加时间:2020/5/31 9:28
*修改人和时间: 2020/5/31 9:28
*说明:待接单详情页面
*/
public class MainTainListDetailActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected String getContentTitle() {
        return "待接单详情";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_tain_list_detail;
    }

    @Override
    public void initView() {

        Button dispatchingBtn = findViewById(R.id.dispatching_btn);
        Button orderBtn = findViewById(R.id.order_btn);
        dispatchingBtn.setOnClickListener(this);
        orderBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent mIntent = null;
        switch (v.getId()){
            case R.id.dispatching_btn:
                ToastUtil.show(this,"主管权限才会有派工哦...");
                mIntent = new Intent(this,MainTainDispatchingActivity.class);
                break;

            case R.id.order_btn:
                ToastUtil.show(this,"接单");
                break;
        }

        if (mIntent != null){
            startActivity(mIntent);
        }

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showProgress(boolean flag, String message) {

    }

    @Override
    public void showProgress(String message) {

    }

    @Override
    public void showProgress(int strRes) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void hideProgressDelay() {

    }

    @Override
    public void setTempImg(String url) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showToast(int res) {

    }

    @Override
    public void close() {

    }

    @Override
    public <T> LifecycleTransformer<T> bind() {
        return null;
    }
}
