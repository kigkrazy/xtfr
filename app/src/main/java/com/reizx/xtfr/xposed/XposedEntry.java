package com.reizx.xtfr.xposed;

import android.content.Context;
import android.widget.Toast;

import com.reizx.xtfr.util.RrxLog;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Xposed入口
 * Created by kig on 2017/11/13.
 */

public class XposedEntry implements IXposedHookLoadPackage {
    static {
        RrxLog.setLogTag("xtfr");
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.reizx.xtfr")){
            RrxLog.d("xtfr start...");
            XposedHelpers.findAndHookMethod(Toast.class.getName(), lpparam.classLoader, "makeText", Context.class, CharSequence.class, int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    param.args[1] = "hook success";
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                }
            });
        }
    }
}
