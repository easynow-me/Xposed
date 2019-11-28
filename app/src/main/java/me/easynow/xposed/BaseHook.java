package me.easynow.xposed;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class BaseHook implements IHook {
    protected LoadPackageParam _loadPackageParam;

    @Override
    public void loadPackage(LoadPackageParam loadPackageParam) {
        _loadPackageParam = loadPackageParam;
    }

    protected void hookMethod(String className, final String methodName){
        XposedHelpers.findAndHookMethod(className, _loadPackageParam.classLoader, methodName, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedHelpers.findAndHookMethod(this.getClass(),"before_"+methodName);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {

            }
        });
    }
}
