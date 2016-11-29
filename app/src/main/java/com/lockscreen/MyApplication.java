package com.lockscreen;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName componentName = new ComponentName(this, MyAdmin.class);
        if (devicePolicyManager.isAdminActive(componentName)) {
            devicePolicyManager.lockNow();
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}
