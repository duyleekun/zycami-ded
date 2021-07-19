/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfs;
import com.google.android.gms.internal.clearcut.zzga;
import java.io.IOException;

public class zzfz {
    public volatile int zzrs = -1;

    public static final void zza(zzfz zzfz2, byte[] object, int n10, int n11) {
        try {
            object = zzfs.zzh((byte[])object, 0, n11);
        }
        catch (IOException iOException) {
            object = new RuntimeException;
            ((RuntimeException)object)("Serializing to a byte array threw an IOException (should never happen).", iOException);
            throw object;
        }
        zzfz2.zza((zzfs)object);
        ((zzfs)object).zzem();
    }

    public /* synthetic */ Object clone() {
        return this.zzep();
    }

    public String toString() {
        return zzga.zza(this);
    }

    public void zza(zzfs zzfs2) {
    }

    public final int zzas() {
        int n10;
        this.zzrs = n10 = this.zzen();
        return n10;
    }

    public int zzen() {
        return 0;
    }

    public zzfz zzep() {
        return (zzfz)super.clone();
    }
}

