package com.anjian.enterprise.ui.manage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.databinding.ActivityTodayNeedBinding;
import com.anjian.enterprise.model.manage.RiskListModel;
import com.anjian.enterprise.model.manage.RiskModel;
import com.anjian.enterprise.utils.DemoUtils;
import com.bumptech.glide.Glide;
import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.model.BaseBean;
import com.lm.lib_common.utils.glide.GlideRoundTransform;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class TodayNeedActivity extends BaseActivity<BasePresenter, ActivityTodayNeedBinding> {

    private List<RiskModel.DataBean.LowBean> mDataList=new ArrayList<>();
    private CommonAdapter<RiskModel.DataBean.LowBean> mAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_today_need;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

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
    protected void initData() {
        super.initData();
        getData();
        mAdapter=new CommonAdapter<RiskModel.DataBean.LowBean>(aty,R.layout.item_todayneed_layout,mDataList) {
            @Override
            protected void convert(ViewHolder holder, RiskModel.DataBean.LowBean bean, int position) {
                ImageView img = holder.getView(R.id.img);
                TextView tv_title = holder.getView(R.id.tv_title);
                TextView tv_time = holder.getView(R.id.tv_time);
                Glide.with(aty).load(DemoUtils.getUrl(bean.getLocaleImg()))
                        .bitmapTransform(new GlideRoundTransform(aty, 4))
                        .into(img);
                tv_title.setText(bean.getDangerName()+"\n"+bean.getLevelText());
                tv_time.setText(bean.getUpdateTime().split(" ")[0]);
                holder.setOnClickListener(R.id.lly_item, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(aty, DangerInfoActivity.class);
                        intent.putExtra("data", bean);
                        intent.putExtra("type", 0);
                        startActivity(intent);
                    }
                });
            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mAdapter);

        mBinding.srlBody.setEnableLoadmore(false);
        mBinding.srlBody.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getData();
            }
        });

    }

    private void finishRefersh() {
        mBinding.srlBody.finishLoadmore();
        mBinding.srlBody.finishRefresh();
    }
    private void getData() {
        Api.getApi().getToDayList(MyApplication.getInstance().getId(), MyApplication.getInstance().getToken())
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
                            mDataList.addAll( hight);
                        }
                        if (moreHight != null && moreHight.size() > 0) {
                            mDataList.addAll( moreHight);
                        }

                        if (normal != null && normal.size() > 0) {
                            mDataList.addAll( normal);
                        }

                        if (low != null && low.size() > 0) {
                            mDataList.addAll( low);
                        }

                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(String errMsg) {
                        finishRefersh();
                    }
                });
    }
}
