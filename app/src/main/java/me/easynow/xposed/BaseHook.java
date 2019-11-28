package me.easynow.xposed;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class BaseHook implements IHook {
    protected LoadPackageParam _loadPackageParam;

    @Override
    public void loadPackage(LoadPackageParam loadPackageParam) {
        _loadPackageParam = loadPackageParam;
        hook();
    }

    protected void hook(){

    }

    protected void hookMethod(String className, final String methodName){
        XposedHelpers.findAndHookMethod(className, _loadPackageParam.getClassLoader(), methodName, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                try {
                    XposedHelpers.callMethod(this, "before_" + methodName, new me.easynow.xposed.MethodHookParam(param));
                }catch (Exception e){

                }
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                try {
                    XposedHelpers.callMethod(this, "after_" + methodName, new me.easynow.xposed.MethodHookParam(param));
                }catch (Exception e){

                }
            }
        });
    }
}
