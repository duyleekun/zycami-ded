/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package com.google.android.gms.internal.phenotype;

import android.content.Context;
import android.os.Build;

public final class zzh {
    private static final Object zzak;
    private static Context zzal;
    private static boolean zzam = false;
    private static volatile Boolean zzan;
    private static volatile Boolean zzbq;

    static {
        Object object;
        zzak = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void init(Context context) {
        Object object = zzak;
        synchronized (object) {
            Context context2;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            if ((n10 < n11 || (n10 = (int)(context.isDeviceProtectedStorage() ? 1 : 0)) == 0) && (context2 = context.getApplicationContext()) != null) {
                context = context2;
            }
            if ((context2 = zzal) != context) {
                n10 = 0;
                context2 = null;
                zzan = null;
            }
            zzal = context;
        }
        zzam = false;
    }

    public static void maybeInit(Context context) {
        Context context2 = zzal;
        if (context2 == null) {
            zzh.init(context);
        }
    }
}

