package com.reizx.xtfr.xposed.oppo.xclazz.urlreq;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import org.joor.Reflect;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * a.a.a.vi.CardStoreMgr
 * 请求： https://istore.oppomobile.com/card/store/v1/struct
 * 连接说明：
 * Created by kig on 2017/11/21.
 */

public class a_a_a_vi__CardStoreMgr implements IXClazzMgr {

    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("a.a.a.vi", lpparam.classLoader, "b", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                KxLog.d("/card/store/v1/struct ObjUrl : " + Reflect.on(param.thisObject).field("f").call("getUrl").get());
                KxLog.d("/card/store/v1/struct result : " + param.getResult().toString());
            }
        });
    }
}
