package com.anjian.enterprise.ui.home;


import com.anjian.enterprise.R;
import com.anjian.enterprise.databinding.FragmentPersonManageBinding;
import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;

/**
 * Created by LiMing on 2018/6/25.
 */

public class PersonMessageFragment extends BaseFragment<BaseFragmentPresenter,FragmentPersonManageBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_person_manage;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }
}
