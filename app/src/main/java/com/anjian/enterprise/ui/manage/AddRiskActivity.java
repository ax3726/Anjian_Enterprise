package com.anjian.enterprise.ui.manage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.databinding.ActivityAddRiskBinding;
import com.anjian.enterprise.ui.common.PhotoActivity;
import com.anjian.enterprise.widget.popuwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;

import java.io.File;

public class AddRiskActivity extends PhotoActivity<BasePresenter,ActivityAddRiskBinding> {
    private String mImgPath = "";//图片路径
    @Override
    public int getLayoutId() {
        return R.layout.activity_add_risk;
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
        mTitleBarLayout.setTitle("新增风险");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.flyImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fly_img:
                SelectPhotopopuwindow selectPhotopopuwindow = new SelectPhotopopuwindow(aty);
                selectPhotopopuwindow.setSelectPhotoListener(new SelectPhotopopuwindow.SelectPhotoListener() {
                    @Override
                    public void onAlbum() {
                        pickphoto();
                    }

                    @Override
                    public void onCamera() {
                        doPhoto();
                    }
                });
                selectPhotopopuwindow.showPopupWindow();
                break;
        }
    }

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
            mImgPath = path;
            mBinding.tvAddTimg.setVisibility(View.GONE);
            mBinding.img.setVisibility(View.VISIBLE);
            Glide.with(aty).load(file).into(mBinding.img);
        }
    }

    @Override
    public void photoFaild() {
        showToast("图片加载失败!");
    }
}
