package com.reizx.xtfr.xposed.oppo;

import com.reizx.xtfr.util.RrxLog;
import com.reizx.xtfr.xposed.IBasicEntry;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/13.
 */

public class OppoEntry implements IBasicEntry {
    private XC_LoadPackage.LoadPackageParam lpparam;

    public OppoEntry(XC_LoadPackage.LoadPackageParam lpparam) {
        this.lpparam = lpparam;
    }

    @Override
    public void execHook() {
        RrxLog.d("OppoEntry execHook entry...");
    }
}
