package com.anjian.enterprise.ui.main;


import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.CacheService;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityWelcomeBinding;
import com.anjian.enterprise.model.UserModel;
import com.anjian.enterprise.model.main.LoginModel;
import com.anjian.enterprise.model.request.LoginRequset;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;

public class WelcomeActivity extends BaseActivity<BasePresenter, ActivityWelcomeBinding> {

    @Override
    protected void initData() {
        super.initData();
        if (CacheService.getIntance().isLogin()) {
            Api.getApi().login(getRequestBody(new LoginRequset(CacheService.getIntance().getUser().getUser(), CacheService.getIntance().getUser().getPassword())))
                    .compose(callbackOnIOToMainThread())
                    .subscribe(new BaseNetListener<LoginModel>(this, false) {
                        @Override
                        public void onSuccess(LoginModel baseBean) {
                            if ("2".equals(baseBean.getData().getUserType())) {
                                MyApplication.getInstance().setToken(baseBean.getData().getToken());
                                MyApplication.getInstance().setId(baseBean.getData().getPlaceId());
                                MyApplication.getInstance().setAreaId(baseBean.getData().getAreaId());
                                new Thread() {
                                    @Override
                                    public void run() {
                                        super.run();
                                        try {
                                            sleep(1500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        startActivity(MainActivity.class);
                                        finish();
                                    }
                                }.start();
                            } else {
                                showToast("该用户不是企业用户，无法登陆！");
                                toLogin();
                            }

                        }

                        @Override
                        public void onFail(String errMsg) {
                            toLogin();
                        }
                    });
        } else {
            toLogin();
        }


    }

    private void toLogin() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startActivity(LoginActivity.class);
                finish();
            }
        }.start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected boolean isTitleBar() {
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}
