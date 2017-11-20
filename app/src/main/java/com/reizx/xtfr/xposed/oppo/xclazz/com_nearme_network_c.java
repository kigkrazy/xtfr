package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.GsonUtils;
import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import org.joor.Reflect;

import java.util.HashMap;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * com.nearme.network.c_NetRequestEngine 网络请求引擎
 * Created by kig on 2017/11/17.
 */

public class com_nearme_network_c implements IXClazzMgr {
    @Override
    public void exec(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.nearme.network.c", lpparam.classLoader, "a",
                XposedHelpers.findClass("com.nearme.transaction.ITagable", lpparam.classLoader),
                XposedHelpers.findClass("com.nearme.network.request.IRequest", lpparam.classLoader),
                HashMap.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
//                        Object request = param.args[1];
//                        String method = "GET";
//
//
//                        //判断是否是POST请求
//                        Class postRequestClazz = XposedHelpers.findClass("com.nearme.network.request.PostRequest", lpparam.classLoader);
//                        if (postRequestClazz.isInstance(request)){
//                            method = "POST";
//                        }
//
//                        KxLog.d("===============================");
//                        KxLog.d("method : " + method);
//                        KxLog.d("url : " + Reflect.on(method).call("getUrl").as(String.class));
//                        //KxLog.d("post body : " + );
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Object protoResult = param.getResult();
                        KxLog.d("begin===============================");
                        KxLog.d("ProtoRequst: ");
                        KxLog.d("class : " + Reflect.on(protoResult).get("mClazz"));
                        KxLog.d("header : " + Reflect.on(protoResult).field("mHeader").get());
                        KxLog.d("method : " + ((int)Reflect.on(protoResult).field("mMethod").get() == 1 ? "POST" : "GET"));
                        KxLog.d("url : " + Reflect.on(protoResult).get("mUrl"));
                        KxLog.d("OringinUrl : " + Reflect.on(protoResult).get("mOringinUrl"));
                        KxLog.d("mTag : " + Reflect.on(protoResult).get("mTag"));
                        KxLog.d("mStaticTag : " + Reflect.on(protoResult).get("mStaticTag"));
                        KxLog.d("mIsNeedGzip : " + Reflect.on(protoResult).get("mIsNeedGzip"));
                        KxLog.d("mVersionCode : " + Reflect.on(protoResult).get("mVersionCode"));
                        KxLog.d("mVersionName : " + Reflect.on(protoResult).get("mVersionName"));
                        KxLog.d("end===============================");
                    }
                }
        );
    }
}
