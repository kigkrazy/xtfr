package com.reizx.xtfr.xposed;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IBasicEntry;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Xposed入口
 * Created by kig on 2017/11/13.
 */

public class XposedEntry implements IXposedHookLoadPackage {
    static {
        KxLog.setLogTag("xtfr");
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        IBasicEntry basicEntry = new EntryFactory().create(lpparam);
        if (basicEntry != null){
            basicEntry.execHook();
            return;
        }
        KxLog.d(lpparam.packageName + " isn't effective package");
//        if (lpparam.packageName.equals("com.reizx.xtfr")){
//            KxLog.d("xtfr start...");
//            XposedHelpers.findAndHookMethod(Toast.class.getName(), lpparam.classLoader, "makeText", Context.class, CharSequence.class, int.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    super.beforeHookedMethod(param);
//                    param.args[1] = "hook success";
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                }
//            });
//        }
    }
}
