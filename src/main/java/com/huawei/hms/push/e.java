/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;

public class e {
    public static final String a = "e";

    public static Bundle a(Context object, String string2, String string3) {
        Bundle bundle = new Bundle();
        int n10 = 50101300;
        String string4 = String.valueOf(n10);
        bundle.putString("sdkVer", string4);
        string4 = object.getPackageName();
        String string5 = "pkgName";
        bundle.putString(string5, string4);
        object = HmsInstanceId.getInstance((Context)object).getId();
        string4 = "aaid";
        bundle.putString(string4, (String)object);
        object = ProxyCenter.getProxy();
        if (object != null) {
            object = object.getProxyType();
            string4 = "proxyType";
            bundle.putString(string4, (String)object);
        }
        object = "msgId";
        bundle.putString((String)object, string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            object = "analyticInfo";
            bundle.putString((String)object, string3);
        }
        return bundle;
    }

    public static void a(Context context, String string2, String string3, String string4) {
        PushBaseAnalytics pushBaseAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushBaseAnalytics == null) {
            return;
        }
        string2 = e.a(context, string2, string3);
        string3 = a;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("eventId:");
        charSequence.append(string4);
        charSequence.append(",UserProfiles:");
        String string5 = string2.toString();
        charSequence.append(string5);
        charSequence = charSequence.toString();
        HMSLog.i(string3, (String)charSequence);
        pushBaseAnalytics.report(context, string4, (Bundle)string2);
    }
}

