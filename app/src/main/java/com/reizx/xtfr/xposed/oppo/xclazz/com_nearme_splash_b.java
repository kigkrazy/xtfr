package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.xposed.oppo.xclazz.inf.IXClazzMgr;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 初步判断是网络库的log，和调试的总的环境变量
 * Created by kig on 2017/11/16.
 */

public class com_nearme_splash_b implements IXClazzMgr{
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.setStaticBooleanField(XposedHelpers.findClass("com.nearme.splash.b", lpparam.classLoader), "a", true);
    }
}
