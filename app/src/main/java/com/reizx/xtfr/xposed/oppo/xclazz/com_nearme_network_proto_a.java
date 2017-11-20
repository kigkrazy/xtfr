package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.GsonUtils;
import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/17.
 */

public class com_nearme_network_proto_a implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        /**
         * com.nearme.network.proto::a ==>com.nearme.network.proto::a__RequestBodyImpl
         * 一个post请求的body实现类
         *
         */
        XposedHelpers.findAndHookConstructor("com.nearme.network.proto.a", lpparam.classLoader, Object.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                //这个类直接在构造函数中将Obj直接转为byte
                KxLog.d("com.nearme.network.proto::a__RequestBodyImpl in ... ");
                Object requestBody = param.args[0];
                KxLog.d("com.nearme.network.proto::a__RequestBodyImpl requestBody : " + GsonUtils.toJsonString(requestBody));
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
    }
}
