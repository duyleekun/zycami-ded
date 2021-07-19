/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;

public abstract class e {
    public static String a(Context object, String string2, String string3, String object2, String string4) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(string4);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            grsBaseInfo.setAppName((String)object2);
        }
        object2 = new GrsClient((Context)object, grsBaseInfo);
        object = ((GrsClient)object2).synGetGrsUrl(string2, string3);
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        string3 = "QueryGrs";
        if (bl3) {
            HMSLog.i(string3, "Query Grs base url is empty.");
            return "";
        }
        HMSLog.i(string3, "Query Grs base url success.");
        return object;
    }
}

