package com.hua;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

/***
 * 启动页面
 * 1.显示logo
 * 2.判断是否有网
 * 3.检查更新
 * 4.显示版本号
 */
public class SplashActivity extends Activity {

    private TextView tvVersionName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        assignViews();
        show();
    }

    private void show() {
        // 显示版本号
        String versionName = getVersionName();
        tvVersionName.setText("版本号:" + versionName);
    }

    /**
     * 获取版本号
     * @return
     */
    private String getVersionName() {
        PackageManager pm = getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);
            String versionName = packageInfo.versionName;
            return versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 获取控件
     */
    private void assignViews() {
        tvVersionName = ( TextView) findViewById(R.id.tv_version_name);
    }


}
