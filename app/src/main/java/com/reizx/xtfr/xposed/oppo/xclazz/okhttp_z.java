package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.xposed.IXClazzMgr;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/17.
 */

public class okhttp_z implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        /**
         * okhttp3.z::b ====> 对应的okhttp3h.Response::body()
         * 即HTTP3中的返回结果存放的结构体
         */
        XposedHelpers.findAndHookMethod("okhttp.z", lpparam.classLoader, "b", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
    }
}
