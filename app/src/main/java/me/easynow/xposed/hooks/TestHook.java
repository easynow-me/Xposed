package me.easynow.xposed.hooks;

import android.widget.TextView;
import me.easynow.xposed.BaseHook;
import me.easynow.xposed.LoadPackageParam;
import me.easynow.xposed.MethodHookParam;

public class TestHook extends BaseHook {

    @Override
    protected void hook(LoadPackageParam loadPackageParam) {
        super.hook(loadPackageParam);
        hookMethod(TextView.class.getName(),"setText",CharSequence.class);
    }

    private void before_setText(MethodHookParam param){
        param.getArgs()[0]="哈哈哈";
    }
}