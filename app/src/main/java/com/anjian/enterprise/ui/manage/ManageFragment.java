package com.anjian.enterprise.ui.manage;


import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.databinding.FragmentManageBinding;
import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;

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

                break;
            case R.id.tv_hidden://隐患排查

                break;
            case R.id.tv_standard://安全标准化
                startActivity(StandardActivity.class);
                break;
            case R.id.tv_train://培训考试

                break;
            case R.id.tv_message://在线咨询

                break;
        }
    }
}
