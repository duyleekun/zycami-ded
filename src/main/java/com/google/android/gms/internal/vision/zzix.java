/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zziw;
import com.google.android.gms.internal.vision.zziy;
import com.google.android.gms.internal.vision.zziz;
import java.util.List;

public abstract class zzix {
    private static final zzix zzzu;
    private static final zzix zzzv;

    static {
        zzix zzix2 = new zziz(null);
        zzzu = zzix2;
        zzix2 = new zziy(null);
        zzzv = zzix2;
    }

    private zzix() {
    }

    public /* synthetic */ zzix(zziw zziw2) {
        this();
    }

    public static zzix zzhu() {
        return zzzu;
    }

    public static zzix zzhv() {
        return zzzv;
    }

    public abstract List zza(Object var1, long var2);

    public abstract void zza(Object var1, Object var2, long var3);

    public abstract void zzb(Object var1, long var2);
}

