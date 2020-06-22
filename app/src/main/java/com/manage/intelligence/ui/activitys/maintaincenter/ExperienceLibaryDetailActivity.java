package com.manage.intelligence.ui.activitys.maintaincenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.manage.intelligence.R;
import com.manage.intelligence.base.BaseActivity;
import com.manage.intelligence.bean.ExperienceLibraryBean;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
*作者:libao
*添加时间:2020/5/31 23:03
*修改人和时间: 2020/5/31 23:03
*说明:经验库详情页面
*/
public class ExperienceLibaryDetailActivity extends BaseActivity {



    @Override
    protected String getContentTitle() {
        return "经验库详情";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_experience_libary_detail;
    }

    @Override
    public void initView() {




        TextView commitTv = findViewById(R.id.commit_tv);
        commitTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExperienceLibraryBean experienceLibraryBean = new ExperienceLibraryBean();
                experienceLibraryBean.setNumber(1);
                experienceLibraryBean.setDescription("描述");
                experienceLibraryBean.setMethod("处理方法");
                experienceLibraryBean.setOption("对策");

                Intent intent = new Intent();
                intent.putExtra("experience_bean",experienceLibraryBean);
                setResult(RESULT_OK,intent);
                finish();

            }
        });

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