package com.manage.intelligence.ui.login;

import android.Manifest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.StringRes;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.manage.intelligence.R;
import com.manage.intelligence.base.BaseActivity;
import com.manage.intelligence.bean.login.LoginBean;
import com.manage.intelligence.bean.login.LoginParam;
import com.manage.intelligence.http.ResponseObserver;
import com.manage.intelligence.service.HttpService;
import com.manage.intelligence.ui.main.MainActivity;
import com.manage.intelligence.utils.SharedPrefsUtil;
import com.trello.rxlifecycle2.LifecycleTransformer;


import java.io.Serializable;
import java.util.List;

import io.reactivex.disposables.Disposable;
import pub.devrel.easypermissions.EasyPermissions;

public class LoginActivity extends BaseActivity {

    private static final int INTERNET = 1;
//    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
//
//        AppDatabase appDB = MyApplication.getInstance().getAppDB();
//        List<User> allUser = appDB.userDao().getAllUser();
//        if (allUser != null && allUser.size() > 0){
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//            finish();
//        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
//                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final CheckBox rememberCheckBox = findViewById(R.id.remember_password_cb);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        String username = SharedPrefsUtil.getString("remember_password", "username");
        String password = SharedPrefsUtil.getString("remember_password", "password");
        if (!TextUtils.isEmpty(username)) {
            usernameEditText.setText(username);
        }
        if (!TextUtils.isEmpty(password)) {
            passwordEditText.setText(password);
            rememberCheckBox.setChecked(true);
        } else {
            rememberCheckBox.setChecked(false);
        }

//
//        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
//            @Override
//            public void onChanged(@Nullable LoginFormState loginFormState) {
//                if (loginFormState == null) {
//                    return;
//                }
//                loginButton.setEnabled(loginFormState.isDataValid());
//                if (loginFormState.getUsernameError() != null) {
//                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
//                }
//                if (loginFormState.getPasswordError() != null) {
//                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
//                }
//            }
//        });

//        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
//            @Override
//            public void onChanged(@Nullable LoginResult loginResult) {
//                if (loginResult == null) {
//                    return;
//                }
//                loadingProgressBar.setVisibility(View.GONE);
//                if (loginResult.getError() != null) {
//                    showLoginFailed(loginResult.getError());
//                }
//                if (loginResult.getSuccess() != null) {
//                    updateUiWithUser(loginResult.getSuccess());
//                }
//                setResult(Activity.RESULT_OK);
//
//                //Complete and destroy login activity once successful
////                finish();
//            }
//        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
//                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {//软键盘的完成按钮
////                    LiveData<LoginFormState> loginFormState = loginViewModel.getLoginFormState();
////                    LoginFormState value = loginFormState.getValue();
////                    if (value.isDataValid()){
////                        if (rememberCheckBox.isChecked()){//是否记住密码
////                            SharedPrefsUtil.set("remember_password","remember_password",true);
////                        }else {
////                            SharedPrefsUtil.set("remember_password","remember_password",false);
////                        }
////
////                        loginViewModel.login(usernameEditText.getText().toString(),
////                                passwordEditText.getText().toString());
////                    }else {
////                        ToastUtil.show(LoginActivity.this,"请输入正确的账号密码");
////                    }
////
//
//                }
//                return false;
//            }
//        });

        //登录
        loginButton.setEnabled(true);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable text = usernameEditText.getText();
                System.out.println(text);

                String[] perms = {Manifest.permission.INTERNET};
                EasyPermissions.requestPermissions(LoginActivity.this, "获取网络权限", INTERNET, perms);


                if (EasyPermissions.hasPermissions(LoginActivity.this, perms)) {
                    // Already have permission, do the thing

                    //
                    //                    loginViewModel.login(usernameEditText.getText().toString(),
                    //                            passwordEditText.getText().toString());

                    LoginParam loginParam = new LoginParam();
                    loginParam.setSecuritycode("09E4247EFB290F801B848F85630BCF6E");
                    LoginParam.DataBean dataBean = new LoginParam.DataBean();
                    dataBean.setACCOUNT(usernameEditText.getText().toString());
                    dataBean.setPASSWORD(passwordEditText.getText().toString());
                    loginParam.setData(dataBean);

                    Gson gson = new Gson();
                    String loginJson = gson.toJson(loginParam);


                                        //网络请求
                                        startAsync(((HttpService) getService(HttpService.class, LoginActivity.this)).getLogingData(loginJson), new ResponseObserver<LoginBean>(LoginActivity.this) {
                                            @Override
                                            public void onSubscribe(Disposable disposable) {
                                                //显示加载loding
                                                loadingProgressBar.setVisibility(View.VISIBLE);
                                            }

                                            @Override
                                            public void onComplete() {
                                                //隐藏loding
                                                loadingProgressBar.setVisibility(View.INVISIBLE);
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                                loadingProgressBar.setVisibility(View.INVISIBLE);
                                            }

                                            @Override
                                            public void onNext(LoginBean bean) {

                                                if (rememberCheckBox.isChecked()){//是否记住密码
                                                    SharedPrefsUtil.set("remember_password","username",usernameEditText.getText().toString());
                                                    SharedPrefsUtil.set("remember_password","password",passwordEditText.getText().toString());
                                                }else {
                                                    SharedPrefsUtil.set("remember_password","username",usernameEditText.getText().toString());
                                                    SharedPrefsUtil.remove(LoginActivity.this,"remember_password","password");
                                                }

                                                //请求成功返回数据处理
                                                List<LoginBean.Data> dataList = bean.getData();
                                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                intent.putExtra("login_data",(Serializable)dataList);
                                                startActivity(intent);
                                            }
                                        });

                } else {
                    // Do not have permissions, request them now
                    EasyPermissions.requestPermissions(LoginActivity.this, "获取网络权限", INTERNET, perms);
                }


            }
        });
    }


    @Override
    protected String getContentTitle() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    private void updateUiWithUser(LoggedInUserView model) {

        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent);

    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
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
