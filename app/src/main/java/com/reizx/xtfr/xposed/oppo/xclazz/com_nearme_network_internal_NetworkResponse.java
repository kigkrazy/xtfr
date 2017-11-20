package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/20.
 */

public class com_nearme_network_internal_NetworkResponse implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.nearme.network.internal.NetworkResponse", lpparam.classLoader, "getData", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                KxLog.d("com.nearme.network.internal.NetworkResponse#getData in");
            }
        });
    }
}
