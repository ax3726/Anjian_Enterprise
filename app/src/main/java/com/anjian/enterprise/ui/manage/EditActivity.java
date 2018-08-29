package com.anjian.enterprise.ui.manage;

import android.content.Intent;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.databinding.ActivityEditBinding;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;


public class EditActivity extends BaseActivity<BasePresenter, ActivityEditBinding> {


    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }


    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        String txt = getIntent().getStringExtra("txt");
        if ("数量".equals(txt)) {
            mBinding.etBody.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        }
        mTitleBarLayout.setTitle(txt);
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = mBinding.etBody.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    Intent intent = new Intent();
                    intent.putExtra("result",trim);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    showToast("请输入内容!");
                }

            }
        });
        mBinding.etBody.setHint("请输入" + txt);
    }

    @Override
    public void onClick(View v) {

    }
}
