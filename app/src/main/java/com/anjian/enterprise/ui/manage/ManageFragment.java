package com.anjian.enterprise.ui.manage;


import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.FragmentManageBinding;
import com.anjian.enterprise.model.manage.OnlineModel;
import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.model.BaseBean;

/**
 * Created by LiMing on 2018/6/25.
 */

public class ManageFragment extends BaseFragment<BaseFragmentPresenter, FragmentManageBinding> implements View.OnClickListener {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_manage;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setLeftShow(false);
        mTitleBarLayout.setTitle("信息管理");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvRisk.setOnClickListener(this);
        mBinding.tvHidden.setOnClickListener(this);
        mBinding.tvStandard.setOnClickListener(this);
        mBinding.tvTrain.setOnClickListener(this);
        mBinding.tvMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_risk://风险管控
                startActivity(RiskActivity.class);
                break;
            case R.id.tv_hidden://隐患排查
                startActivity(QiYeCheckActivity.class, MyApplication.getInstance().getId());
                break;
            case R.id.tv_standard://安全标准化
                startActivity(StandardActivity.class);
                break;
            case R.id.tv_train://培训考试

                break;
            case R.id.tv_message://在线咨询
                getOnline();
                break;
        }
    }

    private void getOnline() {
        Api.getApi().online(MyApplication.getInstance().getAreaId(), MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<OnlineModel>(this, true) {
                    @Override
                    public void onSuccess(OnlineModel baseBean) {
                        String contactPhone = baseBean.getData().getContactPhone();
                        if (!TextUtils.isEmpty(contactPhone)) {
                            call(contactPhone);
                        } else {
                            showToast("数据有误!");
                        }
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }


    /**
     * 调用拨号界面
     *
     * @param phone 电话号码
     */
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}