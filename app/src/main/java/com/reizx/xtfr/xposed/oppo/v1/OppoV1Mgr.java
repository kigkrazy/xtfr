package com.reizx.xtfr.xposed.oppo.v1;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.oppo.IOppoMgr;
import com.reizx.xtfr.xposed.oppo.xclazz.com_nearme_network_a__BaseHttpEngine;
import com.reizx.xtfr.xposed.oppo.xclazz.com_nearme_network_c;
import com.reizx.xtfr.xposed.oppo.xclazz.com_nearme_network_internal_NetworkResponse;
import com.reizx.xtfr.xposed.oppo.xclazz.com_nearme_network_proto_ProtoRequst;
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
        clazzMgrs.add(new com_oppo_statistics_util_LogUtil());//Log打印类
        //clazzMgrs.add(new a_a_a_wm_url_manager());
        //clazzMgrs.add(new okhttp3_HttpUrl());
        //clazzMgrs.add(new okhttp3_y());//okhttp3h.Response
        clazzMgrs.add(new okhttp3_v());//Okhttp3的Request类
        //clazzMgrs.add(new okio_c());//RequestBody
        //clazzMgrs.add(new okio_k());//OKhttp3的请求Body
        //clazzMgrs.add(new com_nearme_splash_b());//初步判断是网络库的log，和调试的总的环境变量
        clazzMgrs.add(new com_nearme_network_proto_a());//a__RequestBodyImpl
        //clazzMgrs.add(new com_nearme_network_a__BaseHttpEngine());
        clazzMgrs.add(new com_nearme_network_c());
        clazzMgrs.add(new com_nearme_network_proto_ProtoRequst());
        clazzMgrs.add(new com_nearme_network_internal_NetworkResponse());
        startAll();
    }

    public void startAll(){
        for (IXClazzMgr clazzMgr : clazzMgrs){
            clazzMgr.exec(lpparam);
        }
    }
}
