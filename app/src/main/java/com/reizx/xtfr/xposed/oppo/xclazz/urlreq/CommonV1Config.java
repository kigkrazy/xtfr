package com.reizx.xtfr.xposed.oppo.xclazz.urlreq;

import android.content.Context;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.XposedEntry;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import org.joor.Reflect;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 连接示例：https://istore.oppomobile.com/common/v1/config?imei=354782061824384&model=SM-N9108V&osVersion=19&romVersion=0
 *
 * Created by kig on 2017/11/21.
 */

public class CommonV1Config implements IXClazzMgr {
    @Override
    public void exec(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("a.a.a.lk", lpparam.classLoader, "a", Context.class, boolean.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                //KxLog.d("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                try{
                    Object objectReq = Reflect.on("a.a.a.lm", lpparam.classLoader).create(param.args[0], Reflect.on(param.thisObject).get("d")).get();
                    String url = Reflect.on(objectReq).call("generateRequestBody").get();
                    KxLog.d("/common/v1/config url : " + url);
                }catch (Exception e){
                    KxLog.d(e.toString());
                }
            }
        });

        XposedHelpers.findAndHookMethod("a.a.a.lk$a", lpparam.classLoader, "onTransactionSucess",
                int.class, int.class,  int.class, Object.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                KxLog.d("/common/v1/config response : " + param.args[3].toString());
            }
        });
    }
}
