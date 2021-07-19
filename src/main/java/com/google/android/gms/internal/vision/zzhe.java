/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhg;
import com.google.android.gms.internal.vision.zzhh;
import com.google.android.gms.internal.vision.zzhj;
import com.google.android.gms.internal.vision.zzin;

public abstract class zzhe {
    public int zzub;
    public int zzuc = 100;
    private int zzud = -1 >>> 1;
    public zzhj zzue;
    private boolean zzuf = false;

    private zzhe() {
    }

    public /* synthetic */ zzhe(zzhh zzhh2) {
        this();
    }

    public static zzhe zza(byte[] byArray, int n10, int n11, boolean bl2) {
        Object object = new zzhg(byArray, 0, n11, false, null);
        try {
            ((zzhe)object).zzaz(n11);
            return object;
        }
        catch (zzin zzin2) {
            object = new IllegalArgumentException(zzin2);
            throw object;
        }
    }

    public static int zzbb(int n10) {
        int n11 = n10 >>> 1;
        return -(n10 & 1) ^ n11;
    }

    public static long zzr(long l10) {
        long l11 = l10 >>> 1;
        return -(l10 & 1L) ^ l11;
    }

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract void zzax(int var1);

    public abstract boolean zzay(int var1);

    public abstract int zzaz(int var1);

    public abstract void zzba(int var1);

    public abstract boolean zzen();

    public abstract long zzeq();

    public abstract long zzer();

    public abstract int zzes();

    public abstract long zzet();

    public abstract int zzeu();

    public abstract boolean zzev();

    public abstract String zzew();

    public abstract zzgs zzex();

    public abstract int zzey();

    public abstract int zzez();

    public abstract int zzfa();

    public abstract long zzfb();

    public abstract int zzfc();

    public abstract long zzfd();

    public abstract int zzfr();

    public abstract long zzfs();

    public abstract int zzft();
}

