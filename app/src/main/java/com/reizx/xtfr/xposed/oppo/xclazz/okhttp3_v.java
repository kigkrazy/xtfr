package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import org.joor.Reflect;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * okhttp3.v==>okhttp3.RealCall的钩子函数
 * Created by kig on 2017/11/15.
 */

public class okhttp3_v implements IXClazzMgr{
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        KxLog.d("okhttp3.v==>okhttp3.RealCall:: constructor in");
        XposedHelpers.findAndHookConstructor("okhttp3.v", lpparam.classLoader,
                XposedHelpers.findClass("okhttp3.u", lpparam.classLoader),
                XposedHelpers.findClass("okhttp3.w", lpparam.classLoader),
                boolean.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        KxLog.d("okhttp3.v==>okhttp3.RealCall Constructor before in");
                        Object request = param.args[1];
                        String requestToString = (String) Reflect.on(request).call("toString").get();
                        String headerString = (String) Reflect.on(request).field("c").call("toString").get();
                        KxLog.d("headerString : " + headerString);
                        KxLog.d("requestToString : " + requestToString);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        // okhttp3.v::a() ===> 相当与 okhttp3.RealCall::execute()
        XposedHelpers.findAndHookMethod("okhttp3.v", lpparam.classLoader, "a", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
//                Object respon = param.getResult();
//                String responStr = Reflect.on(respon).call("e").call("");
//                KxLog.d();
            }
        });
    }
}
