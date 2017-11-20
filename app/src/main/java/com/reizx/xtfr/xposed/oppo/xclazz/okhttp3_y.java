package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import java.io.InputStream;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 代表OkHttp3的Response
 * Created by kig on 2017/11/15.
 */

public class okhttp3_y implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        /**
         * okhttp3.y.e ====> 对应的okhttp3h.Response::body()
         * 即HTTP3中的返回结果存放的结构体
         */
        XposedHelpers.findAndHookMethod("okhttp3.y", lpparam.classLoader, "e", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                //KxLog.d("okhttp3.y.e before in");
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                //KxLog.d("okhttp3.y.e after in");
                //InputStream ins = Reflect.on(param.getResult()).call("b").get();
                //KxLog.d("okhttp3.y.e after body content : " + inputStream2String(ins));
            }
        });
    }

    public String inputStream2String(InputStream inputStream){
        try {
            StringBuffer   out   =   new   StringBuffer();
            byte[]   b   =   new   byte[4096];
            for   (int   n;   (n   =   inputStream.read(b))   !=   -1;)   {
                out.append(new   String(b,   0,   n));
            }
            return   out.toString();
        }catch (Exception e){
            return null;
        }
    }
}
