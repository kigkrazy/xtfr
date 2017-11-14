package com.reizx.xtfr.xposed.oppo.v1;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.oppo.IOppoMgr;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/14.
 */

public class OppoV1Mgr implements IOppoMgr {
    XC_LoadPackage.LoadPackageParam lpparam;

    public OppoV1Mgr(XC_LoadPackage.LoadPackageParam lpparam) {
        this.lpparam = lpparam;
    }

    @Override
    public void startService() {
        KxLog.d("OppoV1Mgr start service");
    }
}
