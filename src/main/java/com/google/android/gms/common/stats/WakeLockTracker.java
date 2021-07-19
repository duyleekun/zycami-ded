/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.LoggingConstants;
import com.google.android.gms.common.stats.StatsUtils;
import com.google.android.gms.common.stats.WakeLockEvent;
import com.google.android.gms.common.util.zza;
import java.util.Arrays;
import java.util.List;

public class WakeLockTracker {
    private static WakeLockTracker zza;
    private static Boolean zzb;
    private static boolean zzc;

    static {
        WakeLockTracker wakeLockTracker;
        zza = wakeLockTracker = new WakeLockTracker();
        zzc = false;
    }

    public static WakeLockTracker getInstance() {
        return zza;
    }

    private static void zza(Context context, WakeLockEvent wakeLockEvent) {
        Object object;
        Intent intent;
        try {
            intent = new Intent();
            object = LoggingConstants.zza;
        }
        catch (Exception exception) {
            Log.wtf((String)"WakeLockTracker", (Throwable)exception);
            return;
        }
        intent = intent.setComponent(object);
        object = "com.google.android.gms.common.stats.EXTRA_LOG_EVENT";
        wakeLockEvent = intent.putExtra((String)object, (Parcelable)wakeLockEvent);
        context.startService((Intent)wakeLockEvent);
    }

    private static boolean zza() {
        Boolean bl2 = zzb;
        if (bl2 == null) {
            zzb = bl2 = Boolean.FALSE;
        }
        return zzb;
    }

    public void registerAcquireEvent(Context context, Intent intent, String string2, String string3, String string4, int n10, String string5) {
        String[] stringArray = new String[]{string5};
        List<String> list = Arrays.asList(stringArray);
        String string6 = intent.getStringExtra("WAKE_LOCK_KEY");
        this.registerEvent(context, string6, 7, string2, string3, string4, n10, list);
    }

    public void registerDeadlineEvent(Context context, String string2, String string3, String string4, int n10, List list, boolean bl2, long l10) {
        boolean bl3 = WakeLockTracker.zza();
        if (!bl3) {
            return;
        }
        long l11 = System.currentTimeMillis();
        List list2 = StatsUtils.zza(list);
        int n11 = com.google.android.gms.common.util.zza.zza(context);
        String string5 = StatsUtils.zza(context.getPackageName());
        float f10 = com.google.android.gms.common.util.zza.zzb(context);
        WakeLockEvent wakeLockEvent = new WakeLockEvent(l11, 16, string2, n10, list2, null, l10, n11, string3, string5, f10, 0L, string4, bl2);
        WakeLockTracker.zza(context, wakeLockEvent);
    }

    public void registerEvent(Context context, String string2, int n10, String string3, String string4, String string5, int n11, List list) {
        this.registerEvent(context, string2, n10, string3, string4, string5, n11, list, 0L);
    }

    public void registerEvent(Context context, String string2, int n10, String string3, String string4, String string5, int n11, List list, long l10) {
        int n12 = WakeLockTracker.zza();
        if (n12 == 0) {
            return;
        }
        n12 = TextUtils.isEmpty((CharSequence)string2);
        if (n12 != 0) {
            String string6 = "missing wakeLock key. ";
            String string7 = String.valueOf(string2);
            int n13 = string7.length();
            string6 = n13 != 0 ? string6.concat(string7) : (string7 = new String(string6));
            Log.e((String)"WakeLockTracker", (String)string6);
            return;
        }
        n12 = 7;
        if (n12 == n10 || (n12 = 8) == n10 || (n12 = 10) == n10 || (n12 = 11) == n10) {
            WakeLockEvent wakeLockEvent;
            long l11 = System.currentTimeMillis();
            WakeLockEvent wakeLockEvent2 = wakeLockEvent;
            List list2 = StatsUtils.zza(list);
            long l12 = SystemClock.elapsedRealtime();
            int n14 = com.google.android.gms.common.util.zza.zza(context);
            String string8 = StatsUtils.zza(context.getPackageName());
            float f10 = com.google.android.gms.common.util.zza.zzb(context);
            wakeLockEvent = new WakeLockEvent(l11, n10, string3, n11, list2, string2, l12, n14, string4, string8, f10, l10, string5, false);
            wakeLockEvent2 = context;
            WakeLockEvent wakeLockEvent3 = wakeLockEvent;
            WakeLockTracker.zza(context, wakeLockEvent);
        }
    }

    public void registerReleaseEvent(Context context, Intent intent) {
        String string2 = intent.getStringExtra("WAKE_LOCK_KEY");
        this.registerEvent(context, string2, 8, null, null, null, 0, null);
    }
}

