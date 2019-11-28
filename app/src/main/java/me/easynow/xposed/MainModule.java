package me.easynow.xposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.easynow.xposed.hooks.TestHook;

public class MainModule implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        LoadPackageParam param= new LoadPackageParam(lpparam);
        for (IHook hook : hooks()) {
            hook.loadPackage(param);
        }
    }

    private IHook[] hooks(){
        return new IHook[]{
                new TestHook()
        };
    }
}
