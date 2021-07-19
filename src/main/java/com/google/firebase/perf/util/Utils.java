/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.firebase.perf.logging.AndroidLogger;
import g.t;
import g.t$a;

public class Utils {
    private static Boolean mIsDebugLoggingEnabled;

    public static int bufferToInt(byte[] byArray) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = 4) && i10 < (n10 = byArray.length); ++i10) {
            n10 = byArray[i10] & 0xFF;
            int n12 = i10 * 8;
            n11 |= (n10 <<= n12);
        }
        return n11;
    }

    public static void checkArgument(boolean bl2, String string2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static boolean isDebugLoggingEnabled(Context object) {
        String string2;
        Boolean bl2 = mIsDebugLoggingEnabled;
        if (bl2 != null) {
            return bl2;
        }
        bl2 = null;
        Object object2 = object.getPackageManager();
        object = object.getPackageName();
        int n10 = 128;
        object = object2.getApplicationInfo((String)object, n10);
        object = ((ApplicationInfo)object).metaData;
        object2 = "firebase_performance_logcat_enabled";
        boolean bl3 = object.getBoolean((String)object2, false);
        object = bl3;
        try {
            mIsDebugLoggingEnabled = object;
            return (Boolean)object;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            // empty catch block
        }
        object2 = AndroidLogger.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No perf logcat meta data found ");
        string2 = ((Throwable)((Object)string2)).getMessage();
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        ((AndroidLogger)object2).debug(string2);
        return false;
    }

    public static int saturatedIntCast(long l10) {
        long l11 = Integer.MAX_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return -1 >>> 1;
        }
        l11 = 0x80000000L;
        long l13 = l10 - l11;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            return -1 << -1;
        }
        return (int)l10;
    }

    public static String stripSensitiveInfo(String object) {
        Object object2 = t.J((String)object);
        if (object2 != null) {
            object = ((t)object2).H();
            object2 = "";
            object = ((t$a)object).Y((String)object2).B((String)object2);
            object2 = null;
            object = ((t$a)object).F(null).o(null).toString();
        }
        return object;
    }

    public static String truncateURL(String string2, int n10) {
        int n11;
        int n12 = string2.length();
        if (n12 <= n10) {
            return string2;
        }
        n12 = string2.charAt(n10);
        if (n12 == (n11 = 47)) {
            return string2.substring(0, n10);
        }
        Object object = t.J(string2);
        if (object == null) {
            return string2.substring(0, n10);
        }
        n12 = ((String)(object = ((t)object).x())).lastIndexOf(n11);
        if (n12 >= 0) {
            n12 = n10 + -1;
            if ((n12 = string2.lastIndexOf(n11, n12)) >= 0) {
                return string2.substring(0, n12);
            }
        }
        return string2.substring(0, n10);
    }
}

