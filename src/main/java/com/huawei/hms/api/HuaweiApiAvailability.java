/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.Fragment
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.b;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.HuaweiApiCallable;
import d.j.d.a.k;
import java.util.HashMap;
import java.util.Map;

public abstract class HuaweiApiAvailability {
    public static final String ACTIVITY_NAME = "com.huawei.hms.core.activity.JumpActivity";
    public static final String APPID_HMS = "C10132067";
    public static final String APPID_HMS_TV = "C100636709";
    public static final String HMS_API_NAME_GAME = "HuaweiGame.API";
    public static final String HMS_API_NAME_IAP = "HuaweiIap.API";
    public static final String HMS_API_NAME_ID = "HuaweiID.API";
    public static final String HMS_API_NAME_OD = "HuaweiOpenDevice.API";
    public static final String HMS_API_NAME_PAY = "HuaweiPay.API";
    public static final String HMS_API_NAME_PPS = "HuaweiPPSkit.API";
    public static final String HMS_API_NAME_PUSH = "HuaweiPush.API";
    public static final String HMS_API_NAME_SNS = "HuaweiSns.API";
    public static final int HMS_JSON_VERSION_MIN = 30000000;
    public static final int HMS_SDK_VERSION_CODE = 50200300;
    public static final String HMS_SDK_VERSION_NAME = "5.2.0.300";
    public static final int HMS_VERSION_CODE_GAME = 20503000;
    public static final int HMS_VERSION_CODE_IAP = 20700300;
    public static final int HMS_VERSION_CODE_ID = 30000000;
    public static final int HMS_VERSION_CODE_MIN = 20503000;
    public static final int HMS_VERSION_CODE_OD = 20601000;
    public static final int HMS_VERSION_CODE_PAY = 20503000;
    public static final int HMS_VERSION_CODE_PPS = 20700300;
    public static final int HMS_VERSION_CODE_PUSH = 20503000;
    public static final int HMS_VERSION_CODE_SNS = 20503000;
    public static final int HMS_VERSION_MAX = 20600000;
    public static final int HMS_VERSION_MIN = 20503000;
    public static final int NOTICE_VERSION_CODE = 20600000;
    public static final String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";
    public static final String SERVICES_PACKAGE = "com.huawei.hwid";
    public static final String SERVICES_PACKAGE_TV = "com.huawei.hwid.tv";
    public static final String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    public static final String SERVICES_SIGNATURE_CAR = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public static final String SERVICES_SIGNATURE_TV = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public static int SERVICES_VERSION_CODE = 30000100;
    private static final Map a;

    static {
        HashMap<String, Integer> hashMap;
        a = hashMap = new HashMap<String, Integer>();
        Integer n10 = 30000000;
        hashMap.put(HMS_API_NAME_ID, n10);
        n10 = 20503000;
        hashMap.put(HMS_API_NAME_SNS, n10);
        hashMap.put(HMS_API_NAME_PAY, n10);
        hashMap.put(HMS_API_NAME_PUSH, n10);
        hashMap.put(HMS_API_NAME_GAME, n10);
        n10 = 20601000;
        hashMap.put(HMS_API_NAME_OD, n10);
        n10 = 20700300;
        hashMap.put(HMS_API_NAME_IAP, n10);
        hashMap.put(HMS_API_NAME_PPS, n10);
    }

    public static Map getApiMap() {
        return a;
    }

    public static HuaweiApiAvailability getInstance() {
        return b.getInstance();
    }

    public static int getServicesVersionCode() {
        return SERVICES_VERSION_CODE;
    }

    public static void setServicesVersionCode(int n10) {
        SERVICES_VERSION_CODE = n10;
    }

    public abstract k checkApiAccessible(HuaweiApi var1, HuaweiApi ... var2);

    public abstract k checkApiAccessible(HuaweiApiCallable var1, HuaweiApiCallable ... var2);

    public abstract PendingIntent getErrPendingIntent(Context var1, int var2, int var3);

    public abstract PendingIntent getErrPendingIntent(Context var1, ConnectionResult var2);

    public abstract Dialog getErrorDialog(Activity var1, int var2, int var3);

    public abstract Dialog getErrorDialog(Activity var1, int var2, int var3, DialogInterface.OnCancelListener var4);

    public abstract String getErrorString(int var1);

    public abstract k getHuaweiServicesReady(Activity var1);

    public abstract Intent getResolveErrorIntent(Activity var1, int var2);

    public abstract PendingIntent getResolveErrorPendingIntent(Activity var1, int var2);

    public abstract int isHuaweiMobileNoticeAvailable(Context var1);

    public abstract int isHuaweiMobileServicesAvailable(Context var1);

    public abstract int isHuaweiMobileServicesAvailable(Context var1, int var2);

    public abstract boolean isUserResolvableError(int var1);

    public abstract boolean isUserResolvableError(int var1, PendingIntent var2);

    public abstract void popupErrNotification(Context var1, ConnectionResult var2);

    public abstract void resolveError(Activity var1, int var2, int var3);

    public abstract void resolveError(Activity var1, int var2, int var3, PendingIntent var4);

    public abstract boolean showErrorDialogFragment(Activity var1, int var2, int var3);

    public abstract boolean showErrorDialogFragment(Activity var1, int var2, int var3, DialogInterface.OnCancelListener var4);

    public abstract boolean showErrorDialogFragment(Activity var1, int var2, Fragment var3, int var4, DialogInterface.OnCancelListener var5);

    public abstract void showErrorNotification(Context var1, int var2);
}

