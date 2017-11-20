package com.reizx.xtfr.xposed.oppo.xclazz;

import com.reizx.xtfr.xposed.IXClazzMgr;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 网络请求引擎
 * com.nearme.network.a ==> com.nearme.network.a__BaseHttpEngine
 * Created by kig on 2017/11/20.
 */

public class com_nearme_network_a implements IXClazzMgr{
    @Override
    public void exec(XC_LoadPackage.LoadPackageParam lpparam) {
        //XposedHelpers.findAndHookMethod("com.nearme.network.a", lpparam.classLoader, "")
    }
}
