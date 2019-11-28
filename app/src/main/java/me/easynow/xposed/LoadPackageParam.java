package me.easynow.xposed;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class LoadPackageParam {
    XC_LoadPackage.LoadPackageParam _loadPackageParam;
    public LoadPackageParam(XC_LoadPackage.LoadPackageParam loadPackageParam){
        _loadPackageParam=loadPackageParam;
    }

    public String getPackageName() {
        return _loadPackageParam.packageName;
    }

    public String getProcessName() {
        return _loadPackageParam.processName;
    }

    public ClassLoader getClassLoader() {
        return _loadPackageParam.classLoader;
    }

    public ApplicationInfo getAppInfo() {
        return _loadPackageParam.appInfo;
    }

    public boolean isFirstApplication() {
        return _loadPackageParam.isFirstApplication;
    }

    public synchronized Bundle getExtra() {
        return _loadPackageParam.getExtra();
    }

    public Object getObjectExtra(String key) {
        return _loadPackageParam.getObjectExtra(key);
    }

    public void setObjectExtra(String key, Object o) {
        _loadPackageParam.setObjectExtra(key,o);
    }
}
