package com.anjian.enterprise.ui.manage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.anjian.enterprise.R;
import com.anjian.enterprise.databinding.ActivitySelectBinding;
import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends BaseActivity<BasePresenter, ActivitySelectBinding> {

    private List<String> mDataList = new ArrayList<>();
    private CommonAdapter<String> mAdapter;
    private int mIndex = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void initData() {
        super.initData();
        String title = getIntent().getStringExtra("title");
        mTitleBarLayout.setTitle(title);
        ArrayList<String> data = getIntent().getStringArrayListExtra("data");
        if (data == null) {
            data = new ArrayList<>();
        }
        mDataList.addAll(data);
        mAdapter = new CommonAdapter<String>(aty, R.layout.item_select_layout, mDataList) {
            @Override
            protected void convert(ViewHolder holder, String item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                ImageView img_select = holder.getView(R.id.img_select);
                holder.setText(R.id.tv_name, item);
                img_select.setSelected(position == mIndex);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mIndex = position;
                        notifyDataSetChanged();
                        Intent intent = new Intent();
                        intent.putExtra("result", item);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mAdapter);
    }
}
