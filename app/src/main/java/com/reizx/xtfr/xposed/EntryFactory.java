package com.reizx.xtfr.xposed;

import com.reizx.xtfr.util.RrxLog;
import com.reizx.xtfr.xposed.oppo.OppoEntry;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/13.
 */

public class EntryFactory {
    public IBasicEntry create(XC_LoadPackage.LoadPackageParam lpparam){
        IBasicEntry basicEntry = null;
        switch (lpparam.packageName){
            case "com.oppo.market"://oppo市场
                RrxLog.d("Creaet oppo entry");
                basicEntry = new OppoEntry(lpparam);
                break;
            default:
                break;
        }
        return basicEntry;
    }
}
