package com.anjian.enterprise.ui.manage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.databinding.ActivityTodayNeedBinding;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;

public class TodayNeedActivity extends BaseActivity<BasePresenter, ActivityTodayNeedBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_today_need;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void initData() {
        super.initData();

    }
}
