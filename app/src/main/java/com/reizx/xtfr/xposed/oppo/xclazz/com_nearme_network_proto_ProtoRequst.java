package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.GsonUtils;
import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/20.
 */

public class com_nearme_network_proto_ProtoRequst implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.nearme.network.proto.ProtoRequst", lpparam.classLoader, "parseNetworkResponse",
                XposedHelpers.findClass("com.nearme.network.internal.NetworkResponse", lpparam.classLoader),
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        KxLog.d("the response : " + GsonUtils.toJsonString(param.getResult()));
                    }
                });
    }
}
