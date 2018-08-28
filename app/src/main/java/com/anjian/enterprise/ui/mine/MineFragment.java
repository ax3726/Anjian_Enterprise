package com.anjian.enterprise.ui.mine;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;


import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.CacheService;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.FragmentMineBinding;
import com.anjian.enterprise.model.main.UserInfoModel;
import com.anjian.enterprise.ui.main.LoginActivity;
import com.anjian.enterprise.utils.DemoUtils;
import com.bumptech.glide.Glide;
import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.utils.glide.GlideCircleTransform;


/**
 * Created by LiMing on 2018/6/25.
 */

public class MineFragment extends BaseFragment<BaseFragmentPresenter, FragmentMineBinding> {

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mBinding.btnTui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(aty)
                        .setTitle("提示")
                        .setMessage("退出登陆？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                CacheService.getIntance().clearUser();
                                startActivity(LoginActivity.class);
                                aty.finish();
                            }
                        })
                        .create().show();


            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        getUserInfo();
    }

    private void getUserInfo() {
        Api.getApi().getUserInfo(MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<UserInfoModel>(this, true) {
                    @Override
                    public void onSuccess(UserInfoModel baseBean) {
                        setView(baseBean.getData());
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

    private void setView(UserInfoModel.DataBean dataBean) {
        if (dataBean == null) {
            return;
        }
        Glide.with(aty).load(DemoUtils.getUrl(dataBean.getAvatar())).transform(new GlideCircleTransform(aty)).placeholder(R.drawable.mine_head_icon).into(mBinding.imgHead);
        mBinding.tvName.setText(dataBean.getUserName());

    }
}
