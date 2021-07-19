/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager$WakeLock
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

public class StatsUtils {
    public static String getEventKey(Context context, Intent intent) {
        long l10 = (long)System.identityHashCode(context) << 32;
        return String.valueOf((long)System.identityHashCode(intent) | l10);
    }

    public static String getEventKey(PowerManager.WakeLock object, String string2) {
        long l10 = Process.myPid();
        int n10 = 32;
        l10 <<= n10;
        int n11 = System.identityHashCode(object);
        long l11 = n11;
        object = String.valueOf(String.valueOf(l10 |= l11));
        int n12 = TextUtils.isEmpty((CharSequence)string2);
        if (n12 != 0) {
            string2 = "";
        }
        if ((n12 = (string2 = String.valueOf(string2)).length()) != 0) {
            return ((String)object).concat(string2);
        }
        string2 = new String((String)object);
        return string2;
    }

    public static String zza(String string2) {
        String string3 = "com.google.android.gms";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            string2 = null;
        }
        return string2;
    }

    public static List zza(List list) {
        Object e10;
        String string2;
        int n10;
        int n11;
        if (list != null && (n11 = list.size()) == (n10 = 1) && (n11 = (int)((string2 = "com.google.android.gms").equals(e10 = list.get(0)) ? 1 : 0)) != 0) {
            list = null;
        }
        return list;
    }
}

