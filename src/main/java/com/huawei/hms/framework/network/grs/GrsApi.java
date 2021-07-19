/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.framework.network.grs.IQueryUrlsCallBack;
import com.huawei.hms.framework.network.grs.a;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Map;

public class GrsApi {
    private static final String TAG = "GrsApi";
    private static GrsClient grsClient;

    public static void ayncGetGrsUrl(String string2, String string3, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(TAG, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        GrsClient grsClient = GrsApi.grsClient;
        if (grsClient != null && string2 != null && string3 != null) {
            grsClient.ayncGetGrsUrl(string2, string3, iQueryUrlCallBack);
            return;
        }
        iQueryUrlCallBack.onCallBackFail(-6);
    }

    public static void ayncGetGrsUrls(String string2, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(TAG, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        GrsClient grsClient = GrsApi.grsClient;
        if (grsClient != null && string2 != null) {
            grsClient.ayncGetGrsUrls(string2, iQueryUrlsCallBack);
            return;
        }
        iQueryUrlsCallBack.onCallBackFail(-6);
    }

    public static void clearSp() {
        GrsClient grsClient = GrsApi.grsClient;
        if (grsClient == null) {
            Logger.w(TAG, "GrsApi.clearSp return because grsClient is null.");
            return;
        }
        grsClient.clearSp();
    }

    public static boolean forceExpire() {
        GrsClient grsClient = GrsApi.grsClient;
        if (grsClient == null) {
            Logger.w(TAG, "GrsApi.forceExpire return false because grsClient is null.");
            return false;
        }
        return grsClient.forceExpire();
    }

    public static CountryCodeBean getCountryCode(Context context, boolean bl2) {
        return a.a(context, bl2);
    }

    public static int grsSdkInit(Context context, GrsBaseInfo grsBaseInfo) {
        GrsClient grsClient;
        GrsApi.grsClient = grsClient = new GrsClient(context, grsBaseInfo);
        return 0;
    }

    public static String synGetGrsUrl(String string2, String string3) {
        GrsClient grsClient = GrsApi.grsClient;
        if (grsClient != null && string2 != null && string3 != null) {
            return grsClient.synGetGrsUrl(string2, string3);
        }
        Logger.w(TAG, "GrsApi.synGetGrsUrl method maybe grsSdkInit has not completed and grsClient is null.");
        return null;
    }

    public static Map synGetGrsUrls(String hashMap) {
        GrsClient grsClient = GrsApi.grsClient;
        if (grsClient != null && hashMap != null) {
            return grsClient.synGetGrsUrls((String)((Object)hashMap));
        }
        Logger.w(TAG, "GrsApi.synGetGrsUrls method maybe grsSdkInit has not completed and grsClient is null.");
        hashMap = new HashMap();
        return hashMap;
    }
}

