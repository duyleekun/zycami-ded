/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.updatesdk;

import android.content.Context;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import com.huawei.updatesdk.service.otaupdate.g;

public final class UpdateSdkAPI {
    public static void checkAppUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean bl2, boolean bl3) {
        g.a(context, checkUpdateCallBack, bl2, bl3);
    }

    public static void checkAppUpdate(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        g.a(context, updateParams, checkUpdateCallBack);
    }

    public static void checkAppUpdateByAppInfo(Context context, CheckUpdateCallBack checkUpdateCallBack, AppInfoAdapter appInfoAdapter) {
        g.a(context, checkUpdateCallBack, appInfoAdapter);
    }

    public static void checkAppUpdateForHMSKit(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        g.b(context, updateParams, checkUpdateCallBack);
    }

    public static void checkClientOTAUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean bl2, int n10, boolean bl3) {
        g.a(context, checkUpdateCallBack, bl2, n10, bl3);
    }

    public static void checkTargetAppUpdate(Context context, String string2, CheckUpdateCallBack checkUpdateCallBack) {
        g.a(context, string2, checkUpdateCallBack);
    }

    public static void releaseCallBack() {
        g.a();
    }

    public static void setAppStorePkgName(String string2) {
        g.a(string2);
    }

    public static void setServiceZone(String string2) {
        g.b(string2);
    }

    public static void showUpdateDialog(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean bl2) {
        g.a(context, apkUpgradeInfo, bl2);
    }

    public static void showUpdateDialogByAppInfo(Context context, ApkUpgradeInfo apkUpgradeInfo, AppInfoAdapter appInfoAdapter) {
        g.a(context, apkUpgradeInfo, appInfoAdapter);
    }
}

