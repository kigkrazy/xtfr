package com.reizx.xtfr.xposed.oppo.xclazz.urlreq;

import android.content.Context;

import com.reizx.xtfr.util.KxLog;
import com.reizx.xtfr.xposed.inf.IXClazzMgr;

import org.joor.Reflect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * https://api.cdo.oppomobile.com/whoops/v1/upgrade 的请求
 * 请求说明：post请求，上传手机安装的插件类表，猜测是热更新之类的讯息
 * Created by kig on 2017/11/21.
 */

public class WhoopsV1Upgrade implements IXClazzMgr{
    @Override
    public void exec(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("a.a.a.mw", lpparam.classLoader, "a",
                String .class, Map.class, XposedHelpers.findClass("a.a.a.mv", lpparam.classLoader),
                new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                //由于源RequestBody不好抓，因此照抄代码创建一个RequestBody然后打印
                /**
                 * 源代码如下：
                 * UpgradeReq v3_1__RequestBody = new UpgradeReq();
                 * v3_1__RequestBody.setAppType(v1);
                 * v3_1__RequestBody.setApks(((List)v2));
                 * this.a__log(v3_1__RequestBody);
                 * AppUtil.getAppContext().getNetRequestEngine().request(v4__ITagable, new my__upgrade_post(v3_1__RequestBody, arg6__host), ((HashMap)v4__ITagable), this.c__TransactionListener);
                 */
                ArrayList apkList = new ArrayList();
                String isMarket = Reflect.on(param.thisObject).call("a").get() ? "app_store" : "game_center";
                Iterator it = ((Map)param.args[1]).values().iterator();
                while(it.hasNext()) {
                    ((List)apkList).add(Reflect.on(it.next()).call("b").get());
                }

                Object upgradeReq = Reflect.on("com.oppo.whoops.domain.dto.req.UpgradeReq", lpparam.classLoader)
                        .create()
                        .call("setAppType", isMarket)
                        .call("setApks", (List)apkList)
                        .get();

                Object upgradeRequest = Reflect.on("a.a.a.my", lpparam.classLoader).create(upgradeReq, isMarket).get();
                KxLog.d("/whoops/v1/upgrade Url : " + Reflect.on(upgradeRequest).call("getUrl").get());
                KxLog.d("/whoops/v1/upgrade body : " + Reflect.on(upgradeRequest).field("mUpgradeReq").get());
            }
        });

        XposedHelpers.findAndHookMethod("a.a.a.mw$1", lpparam.classLoader, "onTransactionSucess",
                int.class, int.class,  int.class, Object.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        if (param.args[3] == null) {
                            KxLog.d("/whoops/v1/upgrade response : is null");
                            return;
                        }
                        KxLog.d("/whoops/v1/upgrade response : ");
                        String upgrades = "";
                        Iterator it = ((List)Reflect.on(param.args[3]).call("getUpgrades").get()).iterator();
                        while(it.hasNext()) {
                            upgrades = upgrades
                                    + "whoops-response catType: " + Reflect.on(it.next()).call("getCatType").get()
                                    + "pluginType: " + Reflect.on(it.next()).call("getPluginType").get()
                                    + "downloadurl: " + Reflect.on(it.next()).call("getDownUrl").get()
                                    + "md5: " + Reflect.on(it.next()).call("getMd5").get()
                                    + "size: " + Reflect.on(it.next()).call("getSize").get()
                                    + "verCode: " + Reflect.on(it.next()).call("getVerCode").get()
                                    + "versionId: " + Reflect.on(it.next()).call("getVersionId").get()
                                    + "releaseId: " + Reflect.on(it.next()).call("getReleaseId").get()
                                    + "\n";
                        }
                        KxLog.d("/whoops/v1/upgrade response upgrades : " + upgrades);
                    }
                });
    }
}
