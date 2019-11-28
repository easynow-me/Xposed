package me.easynow.xposed;

import android.os.Bundle;

import java.lang.reflect.Member;

public class MethodHookParam {

    private de.robv.android.xposed.XC_MethodHook.MethodHookParam _methodHookParam;

    public MethodHookParam(de.robv.android.xposed.XC_MethodHook.MethodHookParam methodHookParam){
        _methodHookParam=methodHookParam;
    }

    public Member getMethod() {
        return _methodHookParam.method;
    }

    public Object getThisObject() {
        return _methodHookParam.thisObject;
    }

    public Object[] getArgs() {
        return _methodHookParam.args;
    }

    public Object getResult() {
        return _methodHookParam.getResult();
    }

    public void setResult(Object result) {
        _methodHookParam.setResult(result);
    }

    public Throwable getThrowable() {
        return _methodHookParam.getThrowable();
    }

    public boolean hasThrowable() {
        return _methodHookParam.hasThrowable();
    }

    public void setThrowable(Throwable throwable) {
        _methodHookParam.setThrowable(throwable);
    }

    public Object getResultOrThrowable() throws Throwable {
        return _methodHookParam.getResultOrThrowable();
    }

    public synchronized Bundle getExtra() {
        return _methodHookParam.getExtra();
    }

    public Object getObjectExtra(String key) {
        return _methodHookParam.getObjectExtra(key);
    }

    public void setObjectExtra(String key, Object o) {
        _methodHookParam.setObjectExtra(key,o);
    }
}