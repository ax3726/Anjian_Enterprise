package com.anjian.enterprise.ui.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.anjian.enterprise.R;
import com.anjian.enterprise.common.Api;
import com.anjian.enterprise.common.Constant;
import com.anjian.enterprise.common.MyApplication;
import com.anjian.enterprise.model.DocPathModel;
import com.anjian.enterprise.ui.file.Md5Tool;
import com.anjian.enterprise.ui.file.SuperFileView2;
import com.anjian.enterprise.ui.file.TLog;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.utils.CacheUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FileDisplayActivity extends BaseActivity {


    private String TAG = "FileDisplayActivity";
    SuperFileView2 mSuperFileView;
    String filePath;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_file_display;
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
        mTitleBarLayout.setTitle("查看文档");
    }

    @Override
    protected void initData() {
        super.initData();
        init();
    }

    public void init() {
        mSuperFileView = (SuperFileView2) findViewById(R.id.mSuperFileView);
        mSuperFileView.setOnGetFilePathListener(new SuperFileView2.OnGetFilePathListener() {
            @Override
            public void onGetFilePath(SuperFileView2 mSuperFileView2) {
                getFilePathAndShowFile(mSuperFileView2);
            }
        });

        Intent intent = this.getIntent();
        String path = (String) intent.getSerializableExtra("path");

        if (!TextUtils.isEmpty(path)) {
            TLog.d(TAG, "文件path:" + path);
            setFilePath(path);
        }
        mSuperFileView.show();

    }


    private void getFilePathAndShowFile(SuperFileView2 mSuperFileView2) {


        /*if (getFilePath().contains("http")) {//网络地址要先下载

            downLoadFromNet(getFilePath(), mSuperFileView2);

        } */
      /*  else {
            mSuperFileView2.displayFile(new File(getFilePath()));
        }*/
        List<DocPathModel> dataList = (List<DocPathModel>) CacheUtils.getInstance().loadCache(Constant.DOC_PATH);
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        DocPathModel data = null;
        for (DocPathModel model : dataList) {
            if (model.getUrl().equals(getFilePath())) {
                data = model;
                break;
            }
        }
        if (data == null) {//本地没有缓存
            downLoadFromNet(getFilePath(), mSuperFileView2);
        } else {
            mSuperFileView2.displayFile(new File(data.getLocal_path()));

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        TLog.d("FileDisplayActivity-->onDestroy");
        if (mSuperFileView != null) {
            mSuperFileView.onStopDisplay();
        }
    }


    public static void show(Context context, String url) {
        Intent intent = new Intent(context, FileDisplayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("path", url);
        intent.putExtras(bundle);
        context.startActivity(intent);

    }

    /**
     * 保存数据
     *
     * @param url
     * @param path
     */
    private void savePath(String url, String path) {
        List<DocPathModel> dataList = (List<DocPathModel>) CacheUtils.getInstance().loadCache(Constant.DOC_PATH);
        if (dataList == null) {
            dataList = new ArrayList<>();
        }

        DocPathModel model = new DocPathModel();
        model.setLocal_path(path);
        model.setUrl(url);
        dataList.add(model);
        CacheUtils.getInstance().saveCache(Constant.DOC_PATH, dataList);
    }

    public void setFilePath(String fileUrl) {
        this.filePath = fileUrl;
    }

    private String getFilePath() {
        return filePath;
    }

    private void downLoadFromNet(final String url, final SuperFileView2 mSuperFileView2) {

        //1.网络下载、存储路径、
        File cacheFile = getCacheFile(url);
        if (cacheFile.exists()) {
            if (cacheFile.length() <= 0) {
                TLog.d(TAG, "删除空文件！！");
                cacheFile.delete();
                return;
            }
        }

        Api.getApi().downloadFile(url).subscribeOn(Schedulers.io()).subscribe(new BaseNetListener<ResponseBody>(this, true) {
            @Override
            public void onSuccess(ResponseBody responseBody) {
                TLog.d(TAG, "下载文件-->onResponse");
                boolean flag;
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    is = responseBody.byteStream();
                    long total = responseBody.contentLength();


                    //fileN : /storage/emulated/0/pdf/kauibao20170821040512.pdf
                    File fileN = getCacheFile(url);//new File(getCacheDir(url), getFileName(url))

                    TLog.d(TAG, "创建缓存文件： " + fileN.toString());
                    if (!fileN.exists()) {
                        boolean mkdir = fileN.createNewFile();
                    }
                    fos = new FileOutputStream(fileN);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        TLog.d(TAG, "写入缓存文件" + fileN.getName() + "进度: " + progress);
                    }
                    fos.flush();
                    TLog.d(TAG, "文件下载成功,准备展示文件。");
                    savePath(url, fileN.getAbsolutePath());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //2.ACache记录文件的有效期
                            mSuperFileView2.displayFile(fileN);
                        }
                    });

                } catch (Exception e) {
                    TLog.d(TAG, "文件下载异常 = " + e.toString());
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                TLog.d(TAG, "文件下载失败");
                File file = getCacheFile(url);
                if (!file.exists()) {
                    TLog.d(TAG, "删除下载失败文件");
                    file.delete();
                }
            }
        });


    }

    /***
     * 获取缓存目录
     *
     * @param url
     * @return
     */
    private File getCacheDir(String url) {

        return new File(MyApplication.getBase_Path() + "/");

    }

    /***
     * 绝对路径获取缓存文件
     *
     * @param url
     * @return
     */
    private File getCacheFile(String url) {
        File cacheFile = new File(MyApplication.getBase_Path() + "/"
                + System.currentTimeMillis() + getFileName(url));
        TLog.d(TAG, "缓存文件 = " + cacheFile.toString());
        return cacheFile;
    }

    /***
     * 根据链接获取文件名（带类型的），具有唯一性
     *
     * @param url
     * @return
     */
    private String getFileName(String url) {
        String fileName = Md5Tool.hashKey(url) + "." + getFileType(url);
        return fileName;
    }

    /***
     * 获取文件类型
     *
     * @param paramString
     * @return
     */
    private String getFileType(String paramString) {
        String str = "";

        if (TextUtils.isEmpty(paramString)) {
            TLog.d(TAG, "paramString---->null");
            return str;
        }
        TLog.d(TAG, "paramString:" + paramString);
        int i = paramString.lastIndexOf('.');
        if (i <= -1) {
            TLog.d(TAG, "i <= -1");
            return str;
        }


        str = paramString.substring(i + 1);
        TLog.d(TAG, "paramString.substring(i + 1)------>" + str);
        return str;
    }


    @Override
    public void onClick(View v) {

    }
}
