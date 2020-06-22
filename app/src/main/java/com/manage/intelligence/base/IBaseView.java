package com.manage.intelligence.base;

import android.app.Activity;
import android.content.Context;

import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * View层接口基类
 *
 * @author: XuChi
 */
public interface IBaseView {
    /**
     * 获取上下文对象
     *
     * @return
     */
    Context getContext();

    /**
     * 显示进度条
     *
     * @param flag    是否可取消
     * @param message 要显示的信息
     */
    void showProgress(boolean flag, String message);

    /**
     * 显示可取消的进度条
     *
     * @param message 要显示的信息
     */
    void showProgress(String message);

    /**
     * 显示可取消的进度条
     *
     * @param strRes
     */
    void showProgress(int strRes);

    /**
     * 隐藏进度条
     */
    void hideProgress();

    /**
     * 延迟隐藏进度条
     */
    void hideProgressDelay();

    void setTempImg(String url);

//    /**
//     * 设置取消进度条监听
//     *
//     * @param onCancelListener
//     */
//    void setProgressCancelListener(DialogInterface.OnCancelListener onCancelListener);

    /**
     * 根据字符串弹出toast
     *
     * @param msg 提示内容
     */
    void showToast(String msg);

    /**
     * 根据字符串资源弹出toast
     *
     * @param res
     */
    void showToast(int res);

    /**
     * 关闭当前页面
     */
    void close();

    /**
     * 开始执行一个延时任务
     *
     * @param delay
     * @param unit
     * @param observer
     */
    void startDelayAsync(long delay, TimeUnit unit, Observer<Long> observer);

    /**
     * 开始执行一个定时任务
     *
     * @param period
     * @param unit
     * @param observer
     */
    void startIntervalAsync(long period, TimeUnit unit, Observer<Long> observer);

    /**
     * 执行一个基于rxjava的异步任务
     *
     * @param observable
     */
    <T> void startAsync(Observable<T> observable, Observer<T> observer);

//    /**
//     * 清除当前登录用户,并跳转到登录界面
//     */
//    void clearUser();

    /**
     * 关联RxLifecycle
     *
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bind();


}
