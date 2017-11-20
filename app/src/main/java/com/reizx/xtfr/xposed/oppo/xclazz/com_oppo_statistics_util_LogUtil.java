package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/14.
 */

public class com_oppo_statistics_util_LogUtil implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        KxLog.d("com_oppo_statistics_util_LogUtil exec");
        XposedHelpers.setStaticBooleanField(XposedHelpers.findClass("com.oppo.statistics.util.LogUtil", lpparam.classLoader), "isDebug", true);

//        XposedHelpers.findAndHookMethod("com.oppo.statistics.util.LogUtil", lpparam.classLoader, "d", String.class, String.class, new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//                KxLog.d("com_oppo_statistics_util_LogUtil::d in ");
//                Boolean isDebug = XposedHelpers.getStaticBooleanField(XposedHelpers.findClass("com.oppo.statistics.util.LogUtil", lpparam.classLoader), "isDebug");
//                KxLog.d("com_oppo_statistics_util_LogUtil isDebug : " + isDebug);
//                KxLog.d("com_oppo_statistics_util_LogUtil::d arg[0] : " + (String)param.args[0]);
//                KxLog.d("com_oppo_statistics_util_LogUtil::d arg[1] : " + (String)param.args[1]);
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//            }
//        });
//
//        XposedHelpers.findAndHookMethod("com.oppo.statistics.util.LogUtil", lpparam.classLoader, "getDebug", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//                KxLog.d("com_oppo_statistics_util_LogUtil::getDebug in ");
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//            }
//        });
    }
}
