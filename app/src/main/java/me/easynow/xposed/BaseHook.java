package me.easynow.xposed;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class BaseHook implements IHook {

    private final ThreadLocal<LoadPackageParam> loading = new ThreadLocal<>();

    @Override
    public void loadPackage(LoadPackageParam loadPackageParam) {
        loading.set(loadPackageParam);
        try{
            hook(loadPackageParam);
        }finally {
            loading.remove();
        }
    }

    protected void hook(LoadPackageParam loadPackageParam){

    }

    protected void hookMethod(String className, final String methodName, Object...types){
        Object[] buf = new Object[types == null ? 1 : types.length + 1];
        if (types != null) {
            System.arraycopy(types, 0, buf, 0, buf.length - 1);
        }

        buf[buf.length - 1] = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                try {
                    XposedHelpers.callMethod(this, "before_" + param.method.getName(), new me.easynow.xposed.MethodHookParam(param));
                }catch (NoSuchMethodError ignored){

                }
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                try {
                    XposedHelpers.callMethod(this, "after_" + param.method.getName(), new me.easynow.xposed.MethodHookParam(param));
                }catch (NoSuchMethodError ignored){

                }
            }
        };

        XposedHelpers.findAndHookMethod(className, loading.get().getClassLoader(), methodName, buf);
    }
}
