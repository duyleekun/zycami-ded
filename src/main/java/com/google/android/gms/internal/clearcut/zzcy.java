/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcz;
import com.google.android.gms.internal.clearcut.zzda;
import com.google.android.gms.internal.clearcut.zzdb;

public abstract class zzcy {
    private static final zzcy zzlt;
    private static final zzcy zzlu;

    static {
        zzcy zzcy2 = new zzda(null);
        zzlt = zzcy2;
        zzcy2 = new zzdb(null);
        zzlu = zzcy2;
    }

    private zzcy() {
    }

    public /* synthetic */ zzcy(zzcz zzcz2) {
        this();
    }

    public static zzcy zzbv() {
        return zzlt;
    }

    public static zzcy zzbw() {
        return zzlu;
    }

    public abstract void zza(Object var1, long var2);

    public abstract void zza(Object var1, Object var2, long var3);
}

