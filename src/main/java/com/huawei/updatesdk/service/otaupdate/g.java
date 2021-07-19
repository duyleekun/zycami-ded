/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Log
 *  android.widget.Toast
 */
package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.b.b.a;
import com.huawei.updatesdk.b.c.b;
import com.huawei.updatesdk.b.c.c;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import com.huawei.updatesdk.service.otaupdate.UpdateParams$Builder;
import com.huawei.updatesdk.service.otaupdate.d;
import com.huawei.updatesdk.service.otaupdate.e;
import com.huawei.updatesdk.service.otaupdate.f;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class g {
    public static void a() {
        String string2 = "UpdateSdk";
        Log.i((String)string2, (String)"UpdateSDK releaseCallBack");
        Object object = d.a();
        boolean bl2 = false;
        Iterator iterator2 = null;
        ((d)object).a((CheckUpdateCallBack)null);
        object = com.huawei.updatesdk.b.g.b.a();
        if (object != null && !(bl2 = object.isEmpty())) {
            boolean bl3;
            iterator2 = object.iterator();
            while (bl3 = iterator2.hasNext()) {
                Object object2 = (AsyncTask)iterator2.next();
                if (object2 != null) {
                    boolean bl4 = true;
                    object2.cancel(bl4);
                }
                object2 = "cancel task";
                Log.d((String)string2, (String)object2);
            }
            object.clear();
        }
    }

    private static void a(Context context) {
        com.huawei.updatesdk.a.b.a.a.a(context);
        Object object = new StringBuilder();
        ((StringBuilder)object).append("UpdateSDK version is: 3.0.1.300 ,flavor: envrelease ,pkgName: ");
        String string2 = context.getPackageName();
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        string2 = "updatesdk";
        Log.i((String)string2, (String)object);
        object = b.a();
        int n10 = ((c)object).b();
        int n11 = 3;
        if (n10 == n11) {
            com.huawei.updatesdk.a.a.d.h.a.b(context);
        }
    }

    public static void a(Context context, ApkUpgradeInfo apkUpgradeInfo, AppInfoAdapter appInfoAdapter) {
        boolean bl2;
        String string2;
        Object object;
        boolean bl3;
        if (appInfoAdapter != null && !(bl3 = TextUtils.isEmpty((CharSequence)(object = appInfoAdapter.getAppStorePkgName()))) && !(bl3 = TextUtils.equals((CharSequence)(object = f.f().c()), (CharSequence)(string2 = appInfoAdapter.getAppStorePkgName())))) {
            object = f.f();
            string2 = appInfoAdapter.getAppStorePkgName();
            ((f)object).d(string2);
        }
        if (appInfoAdapter != null && !(bl3 = TextUtils.isEmpty((CharSequence)(object = appInfoAdapter.getAppStorePkgName())))) {
            object = f.f();
            string2 = appInfoAdapter.getBusiness();
            ((f)object).c(string2);
        }
        bl3 = true;
        if (appInfoAdapter != null && (bl2 = appInfoAdapter.isMustBtnOne())) {
            bl2 = bl3;
        } else {
            bl2 = false;
            appInfoAdapter = null;
        }
        g.a(context, apkUpgradeInfo, bl2, bl3);
    }

    public static void a(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean bl2) {
        g.a(context, apkUpgradeInfo, bl2, false);
    }

    private static void a(Context context, ApkUpgradeInfo object, boolean bl2, boolean bl3) {
        block5: {
            String string2 = "UpdateSdk";
            if (context != null && object != null) {
                String string3;
                Intent intent = new Intent(context, AppUpdateActivity.class);
                Bundle bundle = new Bundle();
                String string4 = "app_update_parm";
                bundle.putSerializable(string4, (Serializable)object);
                bundle.putBoolean("app_must_btn", bl2);
                object = "is_apptouch";
                bundle.putBoolean((String)object, bl3);
                intent.putExtras(bundle);
                int n10 = context instanceof Activity;
                if (n10 == 0) {
                    n10 = 0x10000000;
                    intent.setFlags(n10);
                }
                try {
                    context.startActivity(intent);
                    break block5;
                }
                catch (SecurityException securityException) {
                    object = new StringBuilder();
                    String string5 = "go AppUpdateActivity security error: ";
                    ((StringBuilder)object).append(string5);
                    string3 = securityException.toString();
                }
                catch (ActivityNotFoundException activityNotFoundException) {
                    object = new StringBuilder();
                    String string6 = "go AppUpdateActivity error: ";
                    ((StringBuilder)object).append(string6);
                    string3 = activityNotFoundException.toString();
                }
                ((StringBuilder)object).append(string3);
                string3 = ((StringBuilder)object).toString();
                Log.e((String)string2, (String)string3);
            }
        }
    }

    public static void a(Context context, CheckUpdateCallBack checkUpdateCallBack, AppInfoAdapter object) {
        Object object2;
        boolean bl2;
        if (context == null) {
            return;
        }
        UpdateParams$Builder updateParams$Builder = new UpdateParams$Builder();
        String string2 = null;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((AppInfoAdapter)object).getAppStorePkgName())))) {
            string2 = ((AppInfoAdapter)object).getBusiness();
        }
        object2 = f.f();
        ((f)object2).c(string2);
        if (object != null) {
            object2 = ((AppInfoAdapter)object).getServiceZone();
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                object2 = ((AppInfoAdapter)object).getServiceZone();
                updateParams$Builder.setServiceZone((String)object2);
            }
            g.a(((AppInfoAdapter)object).getAppStorePkgName());
            object2 = ((AppInfoAdapter)object).getTargetPkgName();
            object2 = updateParams$Builder.setTargetPkgName((String)object2);
            List list = ((AppInfoAdapter)object).getPackageList();
            object2 = ((UpdateParams$Builder)object2).setPackageList(list);
            boolean bl3 = ((AppInfoAdapter)object).isMustBtnOne();
            object2 = ((UpdateParams$Builder)object2).setMustBtnOne(bl3);
            bl3 = ((AppInfoAdapter)object).isShowImmediate();
            object2 = ((UpdateParams$Builder)object2).setIsShowImmediate(bl3);
            int n10 = ((AppInfoAdapter)object).getMinIntervalDay();
            ((UpdateParams$Builder)object2).setMinIntervalDay(n10);
        }
        object = updateParams$Builder.build();
        ((UpdateParams)object).resetParamList();
        boolean bl4 = TextUtils.isEmpty((CharSequence)string2) ^ true;
        g.a(context, (UpdateParams)object, checkUpdateCallBack, bl4);
    }

    public static void a(Context object, CheckUpdateCallBack objectArray, boolean bl2, int n10, boolean bl3) {
        block2: {
            a a10;
            long l10;
            block3: {
                boolean bl4;
                if (object == null || !(bl4 = com.huawei.updatesdk.a.a.d.i.a.d(object))) break block2;
                g.a(object);
                l10 = System.currentTimeMillis();
                a10 = a.d();
                long l11 = a10.b();
                if (n10 == 0) break block3;
                l11 = Math.abs(l10 - l11);
                long l12 = n10;
                long l13 = 86400000L;
                long l14 = l11 - (l12 *= l13);
                Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 < 0) break block2;
            }
            a10 = a.d();
            a10.a(l10);
            UpdateParams$Builder updateParams$Builder = new UpdateParams$Builder();
            UpdateParams updateParams = updateParams$Builder.setIsShowImmediate(bl2).setMustBtnOne(bl3).setMinIntervalDay(n10).build();
            e e10 = new e((Context)object, updateParams, (CheckUpdateCallBack)objectArray);
            boolean bl5 = true;
            e10.b(bl5);
            object = com.huawei.updatesdk.b.g.c.b;
            objectArray = new Void[]{};
            e10.executeOnExecutor((Executor)object, objectArray);
        }
    }

    public static void a(Context object, CheckUpdateCallBack objectArray, boolean bl2, boolean bl3) {
        if (object == null) {
            return;
        }
        boolean bl4 = com.huawei.updatesdk.a.a.d.i.a.d((Context)object);
        if (bl4) {
            g.a((Context)object);
            UpdateParams$Builder string2 = new UpdateParams$Builder();
            UpdateParams intent = string2.setIsShowImmediate(bl2).setMustBtnOne(bl3).build();
            e e10 = new e((Context)object, intent, (CheckUpdateCallBack)objectArray);
            object = com.huawei.updatesdk.b.g.c.b;
            objectArray = new Void[]{};
            e10.executeOnExecutor((Executor)object, (Object[])objectArray);
        } else {
            if (objectArray != null) {
                Intent intent = new Intent();
                int n10 = 2;
                String string2 = "status";
                intent.putExtra(string2, n10);
                objectArray.onUpdateInfo(intent);
            }
            objectArray = "upsdk_no_available_network_prompt_toast";
            int n11 = com.huawei.updatesdk.b.h.c.c((Context)object, (String)objectArray);
            object = Toast.makeText((Context)object, (int)n11, (int)0);
            object.show();
        }
    }

    public static void a(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        if (context != null && updateParams != null && checkUpdateCallBack != null) {
            g.a(context);
            updateParams.resetParamList();
            g.b(context, updateParams, checkUpdateCallBack);
        }
    }

    private static void a(Context object, UpdateParams objectArray, CheckUpdateCallBack checkUpdateCallBack, boolean bl2) {
        block5: {
            Object object2;
            a a10;
            long l10;
            block6: {
                if (object == null || objectArray == null || checkUpdateCallBack == null) break block5;
                g.a(object);
                l10 = System.currentTimeMillis();
                a10 = a.d();
                long l11 = a10.b();
                int n10 = objectArray.getMinIntervalDay();
                if (n10 == 0) break block6;
                l11 = Math.abs(l10 - l11);
                n10 = objectArray.getMinIntervalDay();
                long l12 = n10;
                long l13 = 86400000L;
                long l14 = l11 - (l12 *= l13);
                object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 < 0) break block5;
            }
            if ((object2 = com.huawei.updatesdk.a.a.d.i.a.d(object)) != 0) {
                a10 = a.d();
                a10.a(l10);
                e e10 = new e((Context)object, (UpdateParams)objectArray, checkUpdateCallBack);
                e10.a(bl2);
                object = com.huawei.updatesdk.b.g.c.b;
                boolean bl3 = false;
                objectArray = new Void[]{};
                e10.executeOnExecutor((Executor)object, objectArray);
            } else {
                object = new Intent();
                int n11 = 2;
                String string2 = "status";
                object.putExtra(string2, n11);
                checkUpdateCallBack.onUpdateInfo((Intent)object);
            }
        }
    }

    public static void a(Context object, String objectArray, CheckUpdateCallBack checkUpdateCallBack) {
        boolean bl2;
        Object object2 = "status";
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)objectArray)) && checkUpdateCallBack != null) {
            bl2 = com.huawei.updatesdk.a.a.d.i.a.d(object);
            if (bl2) {
                g.a(object);
                object2 = new UpdateParams$Builder();
                bl2 = false;
                objectArray = ((UpdateParams$Builder)object2).setMustBtnOne(false).setTargetPkgName((String)objectArray).build();
                object2 = new e((Context)object, (UpdateParams)objectArray, checkUpdateCallBack);
                object = com.huawei.updatesdk.b.g.c.b;
                objectArray = new Void[]{};
                object2.executeOnExecutor((Executor)object, objectArray);
            } else {
                object = new Intent();
                int n10 = 2;
                object.putExtra((String)object2, n10);
                checkUpdateCallBack.onUpdateInfo((Intent)object);
            }
            return;
        }
        if (checkUpdateCallBack != null) {
            object = new Intent();
            int n11 = 1;
            object.putExtra((String)object2, n11);
            checkUpdateCallBack.onUpdateInfo((Intent)object);
        }
    }

    public static void a(String string2) {
        f.f().d(string2);
    }

    public static void b(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        g.a(context, updateParams, checkUpdateCallBack, false);
    }

    public static void b(String string2) {
        f.f().b(string2);
    }
}

