package com.anjian.enterprise.ui.manage;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;


import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityQiyeCheckInfoBinding;
import com.anjian.enterprise.model.manage.QiYeCheckListModel;
import com.anjian.enterprise.model.request.UpdateQiYeCheckRequest;
import com.anjian.enterprise.ui.common.PhotoActivity;
import com.anjian.enterprise.ui.common.PhotoPreviewActivity;
import com.anjian.enterprise.utils.DemoUtils;
import com.anjian.enterprise.widget.popuwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.model.BaseBean;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

public class QiYeCheckInfoActivity extends PhotoActivity<BasePresenter, ActivityQiyeCheckInfoBinding> {

    private String mImgPath = "";
    private QiYeCheckListModel.DataBean mDataBean = null;

    private String mImgPath1 = "";
    private String mImgPath2 = "";
    private String mImgPath3 = "";

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_qiye_check_info;
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
        mTitleBarLayout.setTitle("隐患排查");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(aty)
                        .setTitle("提示")
                        .setMessage("是否添加签名？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                submitMessage();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(aty, AutographActivity.class);
                                intent.putExtra("type", 1);
                                startActivityForResult(intent, 100);
                                dialog.dismiss();
                            }
                        })
                        .create().show();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mDataBean = (QiYeCheckListModel.DataBean) getIntent().getSerializableExtra("data");
        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getLocaleImg())).into(mBinding.img);
        mBinding.tvName.setText(mDataBean.getDangerDesc());
        mBinding.tvNum.setText(DemoUtils.getTime(mDataBean.getCreateTime()));

        if (mDataBean.getModifyStatus() == 1) {
            mBinding.tvAddTimg.setVisibility(View.GONE);
            mBinding.imgZheng.setVisibility(View.VISIBLE);
            Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getModifyImg())).into(mBinding.imgZheng);
            mBinding.flyZhengImg.setEnabled(false);

            mBinding.imgZheng.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(aty, PhotoPreviewActivity.class);
                    intent.putExtra("url", DemoUtils.getUrl(mDataBean.getModifyImg()));
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.flyZhengImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

            }
        });
        mBinding.llyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, AddQiyeCheckActivity.class);
                intent.putExtra("data", mDataBean);
                startActivity(intent);
            }
        });
    }

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
            mImgPath = path;
            mBinding.tvAddTimg.setVisibility(View.GONE);
            mBinding.imgZheng.setVisibility(View.VISIBLE);
            Glide.with(aty).load(file).into(mBinding.imgZheng);
        }
    }

    @Override
    public void photoFaild() {
        showToast("图片加载失败!");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == 200) {
            mImgPath1 = data.getStringExtra("img_path1");
            mImgPath2 = data.getStringExtra("img_path2");
            mImgPath3 = data.getStringExtra("img_path3");
            submitMessage();
        }
    }

    private void submitMessage() {


        UpdateQiYeCheckRequest updateQiYeCheckRequest = new UpdateQiYeCheckRequest();
        updateQiYeCheckRequest.setId(mDataBean.getId());


        updateQiYeCheckRequest.setModifyImg(DemoUtils.imageToBase64(mImgPath));
        if (!TextUtils.isEmpty(mImgPath1)) {
            updateQiYeCheckRequest.setSaferSign(DemoUtils.imageToBase64(mImgPath1));
        }

        if (!TextUtils.isEmpty(mImgPath2)) {
            updateQiYeCheckRequest.setBusinesserSign(DemoUtils.imageToBase64(mImgPath2));
        }
        if (!TextUtils.isEmpty(mImgPath3)) {
            updateQiYeCheckRequest.setWitherSign(DemoUtils.imageToBase64(mImgPath3));
        }

        updateQiYeCheckRequest.setEnterpriseId(mDataBean.getEnterpriseId());
        Api.getApi().updateQiYeCheck(getRequestBody(updateQiYeCheckRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                showToast(baseBean.getMessage());
                EventBus.getDefault().post("刷新");
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1500);
                            finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}
