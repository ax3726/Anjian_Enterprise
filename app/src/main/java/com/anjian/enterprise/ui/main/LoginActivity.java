package com.anjian.enterprise.ui.main;

import android.text.TextUtils;
import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.CacheService;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityLoginBinding;
import com.anjian.enterprise.model.UserModel;
import com.anjian.enterprise.model.main.LoginModel;
import com.anjian.enterprise.model.request.LoginRequset;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;


public class LoginActivity extends BaseActivity<BasePresenter, ActivityLoginBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        mBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });
    }
    private void checkLogin() {
        String phone = mBinding.etPhone.getText().toString().trim();
        String password = mBinding.etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            showToast("用户名不能为空!");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("密码不能为空!");
            return;
        }

        Api.getApi().login(getRequestBody(new LoginRequset(phone, password))).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<LoginModel>(this, true) {
            @Override
            public void onSuccess(LoginModel baseBean) {
                MyApplication.getInstance().setToken(baseBean.getData());
                CacheService.getIntance().setUser(new UserModel(phone,password));
                startActivity(MainActivity.class);
                finish();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}


