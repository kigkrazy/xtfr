package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/21.
 */

public class com_nearme_log_b__LogServiceImpl implements IXClazzMgr {
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.setStaticBooleanField(XposedHelpers.findClass("com.nearme.log.b", lpparam.classLoader), "c", true);
    }
}
