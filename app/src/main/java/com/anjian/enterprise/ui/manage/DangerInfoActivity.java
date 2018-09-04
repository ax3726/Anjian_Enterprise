package com.anjian.enterprise.ui.manage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityDangerInfoBinding;
import com.anjian.enterprise.model.manage.RiskModel;
import com.anjian.enterprise.model.request.AddDangerRecordRequest;
import com.anjian.enterprise.ui.common.PhotoPreviewActivity;
import com.anjian.enterprise.utils.DemoUtils;
import com.bumptech.glide.Glide;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.model.BaseBean;

import java.io.Serializable;

public class DangerInfoActivity extends BaseActivity<BasePresenter, ActivityDangerInfoBinding> {

    private RiskModel.DataBean.LowBean mDataBean = null;


    private int mType = 0;//1 有  2 无

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("今日待办");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_danger_info;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvHave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mType = 1;
                startActivityForResult(AutographActivity.class, 100);
            }
        });
        mBinding.tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mType = 2;

                startActivityForResult(AutographActivity.class, 100);
            }
        });
        mBinding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataBean == null) {
                    return;
                }
                Intent intent = new Intent(aty, PhotoPreviewActivity.class);
                intent.putExtra("url", DemoUtils.getUrl(mDataBean.getLocaleImg()));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        mDataBean = (RiskModel.DataBean.LowBean) getIntent().getSerializableExtra("data");
        if (mDataBean == null) {
            return;
        }
        int type = getIntent().getIntExtra("type", 0);
        if (type == 0) {
            mTitleBarLayout.setTitle("今日待办");
        } else {
            mTitleBarLayout.setTitle(mDataBean.getDangerName());
        }
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getLocaleImg())).into(mBinding.img);
        mBinding.tvName.setText(mDataBean.getDangerName());
        mBinding.tvLevel.setText(mDataBean.getLevelText());
        mBinding.tvTime.setText(mDataBean.getUpdateTime().split(" ")[0]);
        checkState(mDataBean.getId());
    }

    private void checkState(String id) {
        Api.getApi().checkStatus(id, MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<BaseBean>(this, true) {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        if ("1".equals(baseBean.getData())) {//不需要检查
                            mBinding.llyDanger.setVisibility(View.GONE);
                        } else {
                            mBinding.llyDanger.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == 200) {
            String img_path = data.getStringExtra("img_path");
            addRecord(img_path);
        }
    }

    private void addRecord(String img_path) {
        if (mDataBean == null) {
            return;
        }

        AddDangerRecordRequest addDangerRecordRequest = new AddDangerRecordRequest();
        addDangerRecordRequest.setDangerIdentificationId(mDataBean.getId());
        addDangerRecordRequest.setSignImg(DemoUtils.imageToBase64(img_path));
        addDangerRecordRequest.setIsDanger(mType == 1 ? 1 : 0);
        Api.getApi().addDangerIdentificationRecord(getRequestBody(addDangerRecordRequest), MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<BaseBean>(this, true) {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        showToast(baseBean.getMessage());
                        mBinding.llyDanger.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

}
