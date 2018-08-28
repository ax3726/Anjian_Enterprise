package com.anjian.enterprise.ui.home;

import android.view.View;


import com.anjian.enterprise.R;
import com.anjian.enterprise.databinding.FragmentHomeBinding;
import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by LiMing on 2018/6/25.
 */

public class HomeFragment extends BaseFragment<BaseFragmentPresenter, FragmentHomeBinding> {

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
        return R.layout.fragment_home;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("安评信息");
        mTitleBarLayout.setLeftImg(R.drawable.record_search_icon);
        mTitleBarLayout.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(DocumentActivity.class);
            }
        });
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightImg(R.drawable.home_message_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MessageActivity.class);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.home1);
        list.add(R.drawable.home2);
        list.add(R.drawable.home3);
        list.add(R.drawable.home4);
        mBinding.fbHead.setImages(list);

    }
}
