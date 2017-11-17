package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.oppo.xclazz.inf.IXClazzMgr;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * okio.c
 * Created by kig on 2017/11/16.
 */

public class okio_c implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("okio.c", lpparam.classLoader, "c", byte[].class, int.class, int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                byte[] requestBodyByte = (byte[])param.args[0];
                if (requestBodyByte == null){
                    KxLog.d("okio.c ==> requestBodyByte is null .");
                    return;
                }
                KxLog.d("okio.c ==> requestBodyByte length : " + requestBodyByte.length);
                KxLog.d("okio.k ==> requestBodyByte info : " + requestBodyByte.toString());
                String requestBodyStr = new String(requestBodyByte, "UTF-8");
                KxLog.d("okio.c ==> requestBodyStr is : " + requestBodyStr);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
    }
}
