package com.anjian.enterprise.ui.manage;

import android.content.Intent;
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
import java.util.ArrayList;

public class AddRiskActivity extends PhotoActivity<BasePresenter, ActivityAddRiskBinding> {
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
        mBinding.tvName.setOnClickListener(this);
        mBinding.tvDan.setOnClickListener(this);
        mBinding.tvShigu.setOnClickListener(this);
        mBinding.tvMaybe.setOnClickListener(this);
        mBinding.tvRate.setOnClickListener(this);
        mBinding.tvAftermath.setOnClickListener(this);
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
            case R.id.tv_name:
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "风险点名称");
                startActivityForResult(intent, 1001);
                break;
            case R.id.tv_dan:
                Intent intent1 = new Intent(aty, SelectActivity.class);
                ArrayList<String> data = new ArrayList<>();
                data.add("生活单元");
                data.add("管理单元");
                data.add("动力单元");
                data.add("仓储单元");
                data.add("辅助生产单元");
                data.add("生产单元");
                intent1.putExtra("title", "单元类别");
                intent1.putExtra("data", data);
                startActivityForResult(intent1, 1002);
                break;
            case R.id.tv_shigu:
                Intent intent2 = new Intent(aty, SelectActivity.class);
                ArrayList<String> data1 = new ArrayList<>();
                data1.add("其他伤害");
                data1.add("物体打击");
                data1.add("车辆伤害");
                data1.add("机械伤害");
                data1.add("起重伤害");
                data1.add("触电");
                data1.add("淹溺");
                data1.add("灼烫");
                data1.add("火灾");
                data1.add("高处坠落");
                data1.add("坍塌");
                data1.add("冒顶片帮");
                intent2.putExtra("title", "可能发生的事故类型");
                intent2.putExtra("data", data1);
                startActivityForResult(intent2, 1003);
                break;
            case R.id.tv_maybe:
                Intent intent3 = new Intent(aty, SelectActivity.class);
                ArrayList<String> data2 = new ArrayList<>();
                data2.add("实际不可能");
                data2.add("极不可能");
                data2.add("很不可能，可以设想");
                data2.add("可能性小，完全意外");
                data2.add("可能，但不经常");
                data2.add("相当可能");
                data2.add("完全可能预料");
                intent3.putExtra("title", "事故发生的可能性");
                intent3.putExtra("data", data2);
                startActivityForResult(intent3, 1004);
                break;
            case R.id.tv_rate:
                Intent intent4 = new Intent(aty, SelectActivity.class);
                ArrayList<String> data3 = new ArrayList<>();
                data3.add("非常罕见的暴露");
                data3.add("每年几次暴露");
                data3.add("每月一次暴露");
                data3.add("每天工作时间暴露");
                data3.add("每周一次暴露");
                data3.add("连续暴露");
                intent4.putExtra("title", "暴露于危险环境的频率");
                intent4.putExtra("data", data3);
                startActivityForResult(intent4, 1005);
                break;
            case R.id.tv_aftermath:
                Intent intent5 = new Intent(aty, SelectActivity.class);
                ArrayList<String> data4 = new ArrayList<>();
                data4.add("轻微，仅需救护/职业性多发病");
                data4.add("重大，致残/职业病（一人）");
                data4.add("严重，重伤/职业病（多人）");
                data4.add("非常严重，一人死亡");
                data4.add("灾难，数人死亡  ");
                data4.add("大灾难");
                intent5.putExtra("title", "事故后果严重程度");
                intent5.putExtra("data", data4);
                startActivityForResult(intent5, 1006);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            switch (requestCode) {
                case 1001://名称
                    mBinding.tvName.setText(result);
                    break;
                case 1002://
                    mBinding.tvDan.setText(result);
                    break;
                case 1003://
                    mBinding.tvShigu.setText(result);
                    break;
                case 1004://
                    mBinding.tvMaybe.setText(result);
                    break;
                case 1005://
                    mBinding.tvRate.setText(result);
                    break;
                case 1006://
                    mBinding.tvAftermath.setText(result);
                    break;
            }
        }
    }
}
