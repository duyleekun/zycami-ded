/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.HashMap;
import java.util.Map;

public class ConnectionErrorMessages {
    private static final Map map;

    static {
        HashMap hashMap;
        map = hashMap = new HashMap();
    }

    public static String getErrorDialogButtonMessage(Activity activity, int n10) {
        int n11;
        Context context = ResourceLoaderUtil.getmContext();
        if (context == null) {
            activity = activity.getApplicationContext();
            ResourceLoaderUtil.setmContext((Context)activity);
        }
        if (n10 != (n11 = 1)) {
            n11 = 2;
            if (n10 != n11) {
                return ResourceLoaderUtil.getString("hms_confirm");
            }
            return ResourceLoaderUtil.getString("hms_update");
        }
        return ResourceLoaderUtil.getString("hms_install");
    }

    public static String getErrorMessage(Activity object, int n10) {
        Context context = ResourceLoaderUtil.getmContext();
        if (context == null) {
            object = object.getApplicationContext();
            ResourceLoaderUtil.setmContext((Context)object);
        }
        object = ResourceLoaderUtil.getString("hms_update_title");
        int n11 = 1;
        if (n10 != n11 && n10 != (n11 = 2)) {
            object = null;
        }
        return object;
    }

    public static String getErrorTitle(Activity object, int n10) {
        int n11;
        Context context = ResourceLoaderUtil.getmContext();
        if (context == null) {
            object = object.getApplicationContext();
            ResourceLoaderUtil.setmContext((Context)object);
        }
        if (n10 != (n11 = 1)) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 9;
                    context = null;
                    String string2 = "HuaweiApiAvailability";
                    if (n10 != n11) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Unexpected error code ");
                        ((StringBuilder)object).append(n10);
                        object = ((StringBuilder)object).toString();
                        HMSLog.e(string2, (String)object);
                        return null;
                    }
                    HMSLog.e(string2, "Huawei Mobile Services is invalid. Cannot recover.");
                    return null;
                }
                return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
            }
            return ResourceLoaderUtil.getString("hms_update_message");
        }
        return ResourceLoaderUtil.getString("hms_install_message");
    }
}

