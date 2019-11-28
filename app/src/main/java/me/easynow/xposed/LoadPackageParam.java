package me.easynow.xposed;

import android.content.pm.ApplicationInfo;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class LoadPackageParam {

    XC_LoadPackage.LoadPackageParam _loadPackageParam;

    public LoadPackageParam(XC_LoadPackage.LoadPackageParam loadPackageParam){
        _loadPackageParam=loadPackageParam;
        packageName = _loadPackageParam.packageName;
        processName=_loadPackageParam.processName;
        classLoader=_loadPackageParam.classLoader;
        appInfo=_loadPackageParam.appInfo;
        isFirstApplication=_loadPackageParam.isFirstApplication;
    }

    public String packageName;

    public String processName;

    public ClassLoader classLoader;

    public ApplicationInfo appInfo;

    public boolean isFirstApplication;
}
