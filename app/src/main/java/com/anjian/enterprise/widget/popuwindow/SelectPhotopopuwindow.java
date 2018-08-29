package com.anjian.enterprise.widget.popuwindow;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.anjian.enterprise.R;
import com.anjian.enterprise.databinding.PopupwindowSelectPhotoBinding;


/**
 * Created by Administrator on 2018/6/12.
 */

public class SelectPhotopopuwindow extends PopupWindow {
    private SelectPhotoListener mSelectPhotoListener;
    private Activity aty;
    private PopupwindowSelectPhotoBinding mBinding;

    public SelectPhotopopuwindow(Activity activity) {
        aty = activity;
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.popupwindow_select_photo, null, false);

        // 设置SelectPicPopupWindow的View
        this.setContentView(mBinding.getRoot());

        // 设置Popupwindow弹出窗体的宽
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        //设置Popupwindow弹出窗体的高
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);

        this.setFocusable(true);
        this.setOutsideTouchable(true);
        //点击空白处时，隐藏掉pop窗口

        this.setBackgroundDrawable(new BitmapDrawable());
        backgroundAlpha(0.7f);
        //添加pop窗口关闭事件
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                dismiss();
                backgroundAlpha(1f);
            }
        });
        initView();
    }

    private void initView() {
        mBinding.btnPopAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSelectPhotoListener != null) {
                    mSelectPhotoListener.onAlbum();
                }
                dismiss();
            }
        });
        mBinding.btnPopCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSelectPhotoListener != null) {
                    mSelectPhotoListener.onCamera();
                }
                dismiss();
            }
        });
        mBinding.btnPopCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
    }

    /**
     * 显示popupWindow
     */
    public void showPopupWindow() {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAtLocation(getRootView(), Gravity.BOTTOM, 0, 0);

        } else {
            // this.dismiss();
        }
    }


    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = aty.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        aty.getWindow().setAttributes(lp);
    }

    private View getRootView() {
        return ((ViewGroup) aty.findViewById(android.R.id.content)).getChildAt(0);
    }

    public void setSelectPhotoListener(SelectPhotoListener mSelectPhotoListener) {
        this.mSelectPhotoListener = mSelectPhotoListener;
    }

    public interface SelectPhotoListener {
        void onAlbum();

        void onCamera();
    }

}
