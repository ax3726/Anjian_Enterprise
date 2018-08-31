package com.anjian.enterprise.ui.manage;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;


import com.anjian.enterprise.R;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityAutographBinding;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutographActivity extends BaseActivity<BasePresenter, ActivityAutographBinding> {

    private int mType = 0;//0 本人签名   1 三方签名（本人签名，经营者签名 ，陪同人员签名）

    private String mImgPath1="";
    private String mImgPath2="";
    private String mImgPath3="";

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_autograph;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected void initData() {
        super.initData();
        mType=getIntent().getIntExtra("type",0);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void save(View view) {
        if (mBinding.lvBody.getTouched()) {
            try {
                SimpleDateFormat t = new SimpleDateFormat("yyyyMMddssSSS");
                String filename = "QM" + (t.format(new Date())) + ".jpg";
                mBinding.lvBody.save(MyApplication.getBase_Path() + "/" + filename, true, 10);
                mBinding.lvBody.clear();

                if (mType == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("img_path", MyApplication.getBase_Path() + "/" + filename);
                    setResult(200, intent);
                    finish();
                } else {
                    if (TextUtils.isEmpty(mImgPath1)) {
                        mImgPath1=MyApplication.getBase_Path() + "/" + filename;
                        mBinding.tvTitle.setText("经营者签名");
                    } else if (TextUtils.isEmpty(mImgPath2)) {
                        mImgPath2=MyApplication.getBase_Path() + "/" + filename;
                        mBinding.tvTitle.setText("陪同人员签名");
                    } else if (TextUtils.isEmpty(mImgPath3)) {
                        mImgPath3=MyApplication.getBase_Path() + "/" + filename;
                        Intent intent = new Intent();
                        intent.putExtra("img_path1", mImgPath1);
                        intent.putExtra("img_path2", mImgPath2);
                        intent.putExtra("img_path3", mImgPath3);
                        setResult(200, intent);
                        finish();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showToast("您没有签名~");
        }
    }

    public void clear(View view) {
        mBinding.lvBody.clear();
    }

    @Override
    public void onClick(View v) {

    }
}
