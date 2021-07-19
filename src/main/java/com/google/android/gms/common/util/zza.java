/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.PowerManager
 *  android.os.SystemClock
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.android.gms.common.util.PlatformVersion;

public final class zza {
    private static final IntentFilter zza;
    private static long zzb;
    private static float zzc;

    static {
        IntentFilter intentFilter;
        zza = intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        zzc = 0.0f / 0.0f;
    }

    public static int zza(Context context) {
        Context context2;
        int n10 = -1;
        if (context != null && (context2 = context.getApplicationContext()) != null) {
            int n11;
            context2 = context.getApplicationContext();
            Object object = zza;
            context2 = context2.registerReceiver(null, object);
            int n12 = 0;
            if (context2 == null) {
                n11 = 0;
                context2 = null;
            } else {
                object = "plugged";
                n11 = context2.getIntExtra((String)object, 0);
            }
            int n13 = 3;
            boolean bl2 = PlatformVersion.isAtLeastJellyBeanMR1();
            if (bl2) {
                n13 = 7;
            }
            if ((n11 &= n13) != 0) {
                n11 = 1;
            } else {
                n11 = 0;
                context2 = null;
            }
            object = "power";
            context = (PowerManager)context.getSystemService((String)object);
            if (context == null) {
                return n10;
            }
            n10 = (int)(PlatformVersion.isAtLeastKitKatWatch() ? 1 : 0);
            boolean bl3 = n10 != 0 ? context.isInteractive() : context.isScreenOn();
            if (bl3) {
                n12 = 2;
            }
            return n12 | n11;
        }
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static float zzb(Context context) {
        Class<zza> clazz = zza.class;
        synchronized (clazz) {
            float f10;
            long l10 = SystemClock.elapsedRealtime();
            long l11 = zzb;
            l10 -= l11;
            l11 = 60000L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 < 0 && (l12 = (long)Float.isNaN(f10 = zzc)) == false) {
                return zzc;
            }
            context = context.getApplicationContext();
            l12 = 0;
            f10 = 0.0f;
            String string2 = null;
            IntentFilter intentFilter = zza;
            if ((context = context.registerReceiver(null, intentFilter)) != null) {
                string2 = "level";
                int n10 = -1;
                l12 = context.getIntExtra(string2, n10);
                String string3 = "scale";
                int n11 = context.getIntExtra(string3, n10);
                f10 = l12;
                float f11 = n11;
                zzc = f10 /= f11;
            }
            zzb = l10 = SystemClock.elapsedRealtime();
            return zzc;
        }
    }
}

