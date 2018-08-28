package com.anjian.enterprise.ui.main;

import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityMainBinding;
import com.anjian.enterprise.ui.common.FileDisplayActivity;
import com.anjian.enterprise.ui.file.Md5Tool;
import com.anjian.enterprise.ui.file.TLog;
import com.anjian.enterprise.ui.home.HomeFragment;
import com.anjian.enterprise.ui.manage.ManageFragment;
import com.anjian.enterprise.ui.mine.MineFragment;
import com.anjian.enterprise.utils.DemoUtils;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.utils.DoubleClickExitHelper;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MainActivity extends BaseActivity <BasePresenter,ActivityMainBinding>{

    private HomeFragment mHomeFragment;
    private ManageFragment mManageFragment;
    private MineFragment mMineFragment;
    private FragmentManager mFm;
    private FragmentTransaction mTransaction;
    private List<Fragment> mFragments = new ArrayList<>();
    private DoubleClickExitHelper mDoubleClickExit;//

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initData() {
        super.initData();

        mBinding.rgButtom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_message:
                        if (currentFragmentPosition != 0) {
                            changeFragment(0);
                        }
                        break;

                    case R.id.rb_manage:
                        if (currentFragmentPosition != 1) {
                            changeFragment(1);
                        }
                        break;
                    case R.id.rb_mine:
                        if (currentFragmentPosition != 2) {
                            changeFragment(2);
                        }
                        break;
                }
            }
        });

        initFragment();
      //  DemoUtils.getLocation(aty);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mDoubleClickExit = new DoubleClickExitHelper(this);
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mManageFragment = new ManageFragment();
        mMineFragment = new MineFragment();

        mFragments.add(mHomeFragment);
        mFragments.add(mManageFragment);
        mFragments.add(mMineFragment);

        mFm = getSupportFragmentManager();
        mTransaction = mFm.beginTransaction();
        mTransaction.add(R.id.fly_contain, mHomeFragment);
        mTransaction.show(mFragments.get(0));
        mTransaction.commitAllowingStateLoss();
    }

    private int currentFragmentPosition = 0;

    public void changeFragment(final int position) {
        mFm = getSupportFragmentManager();
        mTransaction = mFm.beginTransaction();
        if (position != currentFragmentPosition) {
            mTransaction.hide(mFragments.get(currentFragmentPosition));
            if (!mFragments.get(position).isAdded()) {
                mTransaction.add(R.id.fly_contain, mFragments.get(position));
            }
            mTransaction.show(mFragments.get(position));
            mTransaction.commitAllowingStateLoss();
        }
        currentFragmentPosition = position;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return mDoubleClickExit.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public
    void onClick(View view) {

    }

    public void test(View view) {
       // String url = "https://github.com/ax3726/Anjian/raw/master/app/doc/%E9%BB%8E%E6%98%8E.doc";
        String url = "https://security-files.oss-cn-shenzhen.aliyuncs.com/1019771090000818177/2018/8/27/1019771090000818177-标杆企业双机制建设汇报材料.doc";
        FileDisplayActivity.show(MainActivity.this, url);

    }


}

