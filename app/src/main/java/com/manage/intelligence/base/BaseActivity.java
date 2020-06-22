package com.manage.intelligence.base;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.manage.intelligence.R;
import com.manage.intelligence.http.ServiceManager;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseActivity extends RxAppCompatActivity implements IBaseView {

    private View rootView;
    private View content;
    private ImageView mBack;
    private TextView mTitle;
    private FrameLayout flContent;

    public <T> T getService(Class<T> clazz, Context context) {
        ServiceManager serviceManager = ServiceManager.getInstance();
        return serviceManager.getService(clazz, context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addContent();
        setContentView(rootView);
        initView();
    }

    private void addContent() {
        rootView = View.inflate(this, R.layout.activity_base, null);
//        content = View.inflate(this, getLayoutId(), null);
        mBack = (ImageView) rootView.findViewById(R.id.back_iv);
        mTitle = (TextView) rootView.findViewById(R.id.title_tv);
        flContent = (FrameLayout) rootView.findViewById(R.id.base_fl);
        mTitle.setText(getContentTitle() == null ? "" : getContentTitle());
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (content != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            flContent.addView(content,params);
        }
    }


    /**
     * title赋值
     * @return
     */
    protected abstract String getContentTitle();

    /**
     * 获取布局ID
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化布局
     */
    public abstract void initView();


    /**
     * 开始执行一个延时任务
     *
     * @param delay
     * @param unit
     * @param observer
     */
    @Override
    public void startDelayAsync(long delay, TimeUnit unit, Observer<Long> observer) {
        startAsync(Observable.timer(delay, unit), observer);
    }

    /**
     * 开始执行一个定时任务
     *
     * @param period
     * @param unit
     * @param observer
     */
    @Override
    public void startIntervalAsync(long period, TimeUnit unit, Observer<Long> observer) {
        startAsync(Observable.interval(period, unit), observer);
    }

    /**
     * 开始执行一个异步任务
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    @Override
    public <T> void startAsync(Observable<T> observable, Observer<T> observer) {
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<T>bindUntilEvent(ActivityEvent.PAUSE))
                .subscribe(observer);
    }
}
