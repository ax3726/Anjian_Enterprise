package com.anjian.enterprise.ui.manage;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityRiskBinding;
import com.anjian.enterprise.model.manage.RiskListModel;
import com.anjian.enterprise.model.manage.RiskModel;
import com.anjian.enterprise.model.manage.StandardModel;
import com.anjian.enterprise.model.request.AddListRequest;
import com.anjian.enterprise.ui.common.FileDisplayActivity;
import com.anjian.enterprise.utils.DemoUtils;
import com.bumptech.glide.Glide;
import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.model.BaseBean;
import com.lm.lib_common.utils.Utils;
import com.lm.lib_common.utils.glide.GlideRoundTransform;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class RiskActivity extends BaseActivity<BasePresenter, ActivityRiskBinding> {

    private List<RiskListModel> mDataList = new ArrayList<>();
    private CommonAdapter<RiskListModel> mAdapter;


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
        EventBus.getDefault().register(this);
        mAdapter = new CommonAdapter<RiskListModel>(aty, R.layout.item_risk_layout, mDataList) {
            @Override
            protected void convert(ViewHolder holder, RiskListModel item, int position) {
                View view_state = holder.getView(R.id.view_state);
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                RecyclerView rc_item = holder.getView(R.id.rc_item);
                TextView tv_time1 = holder.getView(R.id.tv_time1);
                TextView tv_name = holder.getView(R.id.tv_name);
                if (item.getType() == 1) {
                    tv_name.setText("高风险隐患" + item.getData().size() + "处");
                    view_state.setBackgroundColor(Color.parseColor("#FF0000"));
                } else if (item.getType() == 2) {
                    tv_name.setText("较高风险隐患" + item.getData().size() + "处");
                    view_state.setBackgroundColor(Color.parseColor("#FF7F00"));
                } else if (item.getType() == 3) {
                    tv_name.setText("一般风险隐患" + item.getData().size() + "处");
                    view_state.setBackgroundColor(Color.parseColor("#FFF717"));
                } else if (item.getType() == 4) {
                    tv_name.setText("低风险隐患" + item.getData().size() + "处");
                    view_state.setBackgroundColor(Color.parseColor("#5896ff"));
                }
                tv_time1.setText(item.getData().get(item.getData().size() - 1).getUpdateTime().split(" ")[0]);
                CommonAdapter<RiskModel.DataBean.LowBean> adapter = new CommonAdapter<RiskModel.DataBean.LowBean>(aty, R.layout.item_risk_child_layout, item.getData()) {
                    @Override
                    protected void convert(ViewHolder holder, RiskModel.DataBean.LowBean bean, int position) {
                        ImageView img = holder.getView(R.id.img);
                        TextView tv_title = holder.getView(R.id.tv_title);
                        TextView tv_time = holder.getView(R.id.tv_time);
                        Glide.with(aty).load(DemoUtils.getUrl(bean.getLocaleImg()))
                                .bitmapTransform(new GlideRoundTransform(aty, 4))
                                .into(img);
                        tv_title.setText(bean.getDangerName());
                        tv_time.setText(bean.getUpdateTime().split(" ")[0]);
                        holder.setOnClickListener(R.id.lly_item, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(aty, DangerInfoActivity.class);
                                intent.putExtra("data", bean);
                                intent.putExtra("type", 1);
                                startActivity(intent);
                            }
                        });
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
        mBinding.srlBody.setEnableLoadmore(false);
        mBinding.srlBody.setOnRefreshListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {


            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

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
      /*  AddListRequest addListRequest = new AddListRequest();
        addListRequest.setCurrent(mPosition);
        addListRequest.setSize(mSize);
        addListRequest.getCondition().setId("1019771090000818177");*/
        Api.getApi().getDangerIdentificationList(MyApplication.getInstance().getId(), MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<RiskModel>(this, true) {
                    @Override
                    public void onSuccess(RiskModel baseBean) {
                        finishRefersh();
                        mDataList.clear();
                        RiskModel.DataBean data = baseBean.getData();

                        List<RiskModel.DataBean.LowBean> low = data.getLow();
                        List<RiskModel.DataBean.LowBean> normal = data.getNormal();
                        List<RiskModel.DataBean.LowBean> hight = data.getHight();
                        List<RiskModel.DataBean.LowBean> moreHight = data.getMoreHight();


                        if (hight != null && hight.size() > 0) {
                            mDataList.add(new RiskListModel(1, hight));
                        }
                        if (moreHight != null && moreHight.size() > 0) {
                            mDataList.add(new RiskListModel(2, moreHight));
                        }

                        if (normal != null && normal.size() > 0) {
                            mDataList.add(new RiskListModel(3, normal));
                        }

                        if (low != null && low.size() > 0) {
                            mDataList.add(new RiskListModel(4, low));
                        }

                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(String errMsg) {
                        finishRefersh();
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refersh(String messageEvent) {
        if ("刷新".equals(messageEvent)) {

            getDataList();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
