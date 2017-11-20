package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.GsonUtils;
import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Http请求引擎
 * Created by kig on 2017/11/20.
 */

public class com_nearme_network_a__BaseHttpEngine implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        /**
         * 此处是一种请求方式
         */
        XposedHelpers.findAndHookMethod("com.nearme.network.a", lpparam.classLoader, "a",
                XposedHelpers.findClass("com.nearme.network.internal.BaseRequest", lpparam.classLoader),
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Object baseRequest = param.args[0];
                        KxLog.d("com.nearme.network.a : \n BaseRequest : " + GsonUtils.toJsonString(baseRequest));
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
    }
}
