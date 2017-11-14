package com.reizx.xtfr.xposed.oppo;

import com.reizx.xtfr.xposed.oppo.v1.OppoV1Mgr;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/14.
 */

public class OppoMgrFactory {
    public static IOppoMgr craete(XC_LoadPackage.LoadPackageParam lpparam){
        return new OppoV1Mgr(lpparam);
    }
}
