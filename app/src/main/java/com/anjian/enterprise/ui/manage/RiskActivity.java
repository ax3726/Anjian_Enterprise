package com.anjian.enterprise.ui.manage;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityRiskBinding;
import com.anjian.enterprise.model.manage.StandardModel;
import com.anjian.enterprise.model.request.AddListRequest;
import com.anjian.enterprise.ui.common.FileDisplayActivity;
import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

public class RiskActivity extends BaseActivity<BasePresenter, ActivityRiskBinding> {

    private List<String> mDataList = new ArrayList<>();
    private CommonAdapter<String> mAdapter;
    private int mPosition = 1;
    private int mSize = 10;

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("安全生产风险辨识");
        mTitleBarLayout.setRightImg(R.drawable.record_add_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddRiskActivity.class);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_risk;
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
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mAdapter = new CommonAdapter<String>(aty, R.layout.item_risk_layout, mDataList) {
            @Override
            protected void convert(ViewHolder holder, String item, int position) {
                View view_state = holder.getView(R.id.view_state);
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                RecyclerView rc_item = holder.getView(R.id.rc_item);
                if (position == 0) {
                    view_state.setBackgroundColor(Color.parseColor("#FF0000"));
                } else if (position == 1) {
                    view_state.setBackgroundColor(Color.parseColor("#FF7F00"));
                } else if (position == 2) {
                    view_state.setBackgroundColor(Color.parseColor("#FFF717"));
                } else if (position == 3) {
                    view_state.setBackgroundColor(Color.parseColor("#5896ff"));
                }
                List<String> datalist = new ArrayList<>();
                datalist.add("");
                datalist.add("");
                CommonAdapter<String> adapter =new CommonAdapter<String>(aty,R.layout.item_risk_child_layout,datalist) {
                    @Override
                    protected void convert(ViewHolder holder, String s, int position) {



                    }
                };
                rc_item.setLayoutManager(new LinearLayoutManager(aty));
                rc_item.setAdapter(adapter);
                rc_item.setNestedScrollingEnabled(false);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mAdapter);
        mBinding.rcBody.setNestedScrollingEnabled(false);
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
        addListRequest.getCondition().setId("1019771090000818177");
        Api.getApi().getListFilePage(getRequestBody(addListRequest), MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<StandardModel>(this, true) {
                    @Override
                    public void onSuccess(StandardModel baseBean) {
                        finishRefersh();
                      /*  if (mPosition==1) {
                            mDataList.clear();
                        }
                        List<String> data = baseBean.getData();
                        if (data!=null&data.size()>0) {
                            mDataList.addAll(data);
                            if (data.size()<mSize) {
                                mBinding.srlBody.finishLoadmoreWithNoMoreData();
                            }
                        }
                        if (mPosition == 1 && mDataList.size() == 0) {
                            mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                        } else {
                            mBinding.rcBody.setBackground(null);
                        }
                        mAdapter.notifyDataSetChanged();*/
                    }

                    @Override
                    public void onFail(String errMsg) {
                        finishRefersh();
                    }
                });
    }
}
