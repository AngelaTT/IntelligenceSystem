package com.manage.intelligence.http;

import android.util.Log;

import com.manage.intelligence.R;
import com.manage.intelligence.base.IBaseView;
import com.manage.intelligence.exception.DataResultException;
import com.manage.intelligence.exception.LoginFailException;
import com.manage.intelligence.exception.NoNetworkException;

import java.net.SocketTimeoutException;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @author: XuChi
 * @version: V1.0
 * @project: xcf_user_new
 * @package: io.cxc.user.rx
 * @description: RxJava 自定义Subscriber
 * @date: 2019/8/14
 * @time: 9:39
 */
public abstract class ResponseObserver<T> implements Observer<T> {
    private static final String TAG = "ResponseObserver";
    private IBaseView mBaseView;
    private Disposable disposable;

    public ResponseObserver(IBaseView baseView) {
        mBaseView = baseView;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        this.disposable = disposable;
//        mBaseView.showProgress(R.string.loading);
    }

    @Override
    public void onError(Throwable e) {
        if (e.getMessage() != null) {
            Log.e("ThrowableMsg", e.getMessage());
        }
        mBaseView.hideProgress();
//        Log.e("ResponseThrowable", e.getMessage());
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case 401:
//                    mBaseView.showToast(R.string.system_error);
                    break;
                case 500:
//                    mBaseView.showToast(R.string.system_error);
                    break;
                case 404:
//                    mBaseView.showToast(R.string.system_error);
                    break;
                default:
//                    mBaseView.showToast(R.string.account_error);
                    break;
            }
        } else if (e instanceof SocketTimeoutException) {
//            mBaseView.showToast(R.string.system_error);
        } else if (e instanceof DataResultException) {
            mBaseView.showToast(((DataResultException) e).getData());
        } else if (e instanceof NoNetworkException) {
//            mBaseView.showToast(R.string.net_error);
        } else if (e instanceof LoginFailException) {
        } else {
//            mBaseView.showToast(R.string.system_error);
//            startActivity(new Intent(BaseActivity.this, LoginActivity.class));
            //   toastUtil.showShortToast(ExceptionHandle.handleException(e).message);
        }
    }

    @Override
    public void onComplete() {
//        mBaseView.hideProgress();
    }
}
