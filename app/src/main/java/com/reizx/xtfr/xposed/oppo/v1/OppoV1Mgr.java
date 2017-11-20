package com.reizx.xtfr.xposed.oppo.v1;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.oppo.IOppoMgr;
import com.reizx.xtfr.xposed.oppo.xclazz.com_nearme_network_proto_a;
import com.reizx.xtfr.xposed.oppo.xclazz.com_nearme_splash_b;
import com.reizx.xtfr.xposed.oppo.xclazz.com_oppo_statistics_util_LogUtil;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;
import com.reizx.xtfr.xposed.oppo.xclazz.okhttp3_v;
import com.reizx.xtfr.xposed.oppo.xclazz.okhttp3_y;
import com.reizx.xtfr.xposed.oppo.xclazz.okio_c;
import com.reizx.xtfr.xposed.oppo.xclazz.okio_k;

import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by kig on 2017/11/14.
 */

public class OppoV1Mgr implements IOppoMgr {
    private XC_LoadPackage.LoadPackageParam lpparam;
    private List<IXClazzMgr> clazzMgrs = new ArrayList<IXClazzMgr>();

    public OppoV1Mgr(XC_LoadPackage.LoadPackageParam lpparam) {
        this.lpparam = lpparam;
    }

    @Override
    public void startService() {
        KxLog.d("OppoV1Mgr start service");
        clazzMgrs.add(new com_oppo_statistics_util_LogUtil());
        //clazzMgrs.add(new a_a_a_wm_url_manager());
        //clazzMgrs.add(new okhttp3_HttpUrl());
        clazzMgrs.add(new okhttp3_y());
        clazzMgrs.add(new okhttp3_v());
        clazzMgrs.add(new okio_c());
        clazzMgrs.add(new okio_k());
        clazzMgrs.add(new com_nearme_splash_b());
        clazzMgrs.add(new com_nearme_network_proto_a());
        startAll();
    }

    public void startAll(){
        for (IXClazzMgr clazzMgr : clazzMgrs){
            clazzMgr.exec(lpparam);
        }
    }
}
