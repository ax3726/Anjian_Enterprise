package com.anjian.enterprise.ui.manage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.CacheService;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityStandardBinding;
import com.anjian.enterprise.model.manage.StandardModel;
import com.anjian.enterprise.model.request.AddListRequest;
import com.anjian.enterprise.ui.common.FileDisplayActivity;
import com.anjian.enterprise.ui.main.MainActivity;
import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.model.BaseBean;
import com.lm.lib_common.utils.CacheUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StandardActivity extends BaseActivity<BasePresenter, ActivityStandardBinding> {

    private List<StandardModel.DataBean> mDataList = new ArrayList<>();
    private List<StandardModel.DataBean> mDataListCount;
    private CommonAdapter<StandardModel.DataBean> mAdapter;
    private int mPosition = 1;
    private int mSize = 10;

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("安全标准化");
        mTitleBarLayout.setRightImg(R.drawable.record_search_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "搜索关键字");
                startActivityForResult(intent, 1001);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_standard;
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

        mAdapter = new CommonAdapter<StandardModel.DataBean>(aty, R.layout.item_standard_layout, mDataList) {
            @Override
            protected void convert(ViewHolder holder, StandardModel.DataBean item, int position) {
                holder.setText(R.id.tv_name, item.getFileName());
                holder.setText(R.id.tv_time, item.getLastModified().split(" ")[0]);
                holder.setOnClickListener(R.id.lly_item, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FileDisplayActivity.show(aty, item.getKey());
                    }
                });
            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mAdapter);
        mBinding.srlBody.setOnRefreshListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPosition++;
                getDataList();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPosition = 1;
                mBinding.srlBody.resetNoMoreData();
                getDataList();
            }
        });
        getDataList();
    }

    private void finishRefersh() {
        mBinding.srlBody.finishLoadmore();
        mBinding.srlBody.finishRefresh();
    }

    private void getDataList() {
        AddListRequest addListRequest = new AddListRequest();
        addListRequest.setCurrent(mPosition);
        addListRequest.setSize(mSize);
//        addListRequest.getCondition().setId("1019771090000818177");
        addListRequest.getCondition().setId(MyApplication.getInstance().getId());
        Api.getApi().getListFilePage(getRequestBody(addListRequest), MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<StandardModel>(this, true) {
                    @Override
                    public void onSuccess(StandardModel baseBean) {
                        finishRefersh();
                        if (mPosition == 1) {
                            mDataList.clear();
                        }
                        List<StandardModel.DataBean> data = baseBean.getData();
                        if (data != null & data.size() > 0) {
                            mDataList.addAll(data);
                            if (data.size() < mSize) {
                                mBinding.srlBody.finishLoadmoreWithNoMoreData();
                            }
                        }
                        if (mPosition == 1 && mDataList.size() == 0) {
                            mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                        } else {
                            mBinding.rcBody.setBackground(null);
                        }
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(String errMsg) {
                        finishRefersh();
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            switch (requestCode) {
                case 1001://搜索关键字
                    List<StandardModel.DataBean> search = search(result, mDataList);

                    if (search.size() == 0) {
                        mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                    } else {
                        mBinding.rcBody.setBackground(null);
                    }
                    mDataList.clear();
                    mDataList.addAll(search);
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    public List<StandardModel.DataBean> search(String name, List<StandardModel.DataBean> list) {
        List<StandardModel.DataBean> results = new ArrayList();
        Pattern pattern = Pattern.compile(name);
        for (int i = 0; i < list.size(); i++) {
            Matcher matcher = pattern.matcher((list.get(i)).getFileName());
            if (matcher.find()) {
                results.add(list.get(i));
            }
        }
        return results;
    }
}
