/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx$VERSION;
import com.huawei.hms.support.log.HMSLog;

public class p {
    public static String a(Context object) {
        CharSequence charSequence;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            charSequence = new StringBuilder();
            object = object.createDeviceProtectedStorageContext().getDataDir();
            ((StringBuilder)charSequence).append(object);
            ((StringBuilder)charSequence).append("");
            object = ((StringBuilder)charSequence).toString();
        } else {
            object = object.getFilesDir().getParent();
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 != 0) {
            charSequence = "CommFun";
            String string2 = "get storage root path of the current user failed.";
            HMSLog.e((String)charSequence, string2);
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean a() {
        void var0_3;
        int bl2 = HwBuildEx$VERSION.EMUI_SDK_INT;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Emui Api Level:");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        String string2 = "CommFun";
        HMSLog.d(string2, (String)charSequence);
        if (bl2 > 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var0_3;
    }

    public static long b(Context object) {
        long l10;
        int n10;
        object = object.getPackageManager();
        String string2 = "com.huawei.android.pushagent";
        object = object.getPackageInfo(string2, 0);
        try {
            n10 = object.versionCode;
        }
        catch (Exception exception) {
            object = "CommFun";
            string2 = "get nc versionCode error";
            HMSLog.e((String)object, string2);
            l10 = -1;
        }
        l10 = n10;
        return l10;
    }

    public static boolean c(Context context) {
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        int n11 = p.a();
        return n11 != 0 && (n11 = HwBuildEx$VERSION.EMUI_SDK_INT) < (n10 = 21) && (l13 = (l12 = (l11 = p.b(context)) - (l10 = 110001400L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0;
    }
}

