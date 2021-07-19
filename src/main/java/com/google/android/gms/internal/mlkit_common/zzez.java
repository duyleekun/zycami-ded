/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzem;
import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzes;
import com.google.android.gms.internal.mlkit_common.zzew;
import com.google.android.gms.internal.mlkit_common.zzfs;
import com.google.android.gms.internal.mlkit_common.zzir;
import java.nio.charset.Charset;
import java.util.Objects;

public class zzez
extends zzew {
    public final byte[] zzb;

    public zzez(byte[] byArray) {
        Objects.requireNonNull(byArray);
        this.zzb = byArray;
    }

    public final boolean equals(Object object) {
        int n10 = 1;
        if (object == this) {
            return n10 != 0;
        }
        int n11 = object instanceof zzep;
        if (n11 == 0) {
            return false;
        }
        n11 = ((zzep)this).zza();
        Object object2 = object;
        object2 = (zzep)object;
        int n12 = ((zzep)object2).zza();
        if (n11 != n12) {
            return false;
        }
        n11 = ((zzep)this).zza();
        if (n11 == 0) {
            return n10 != 0;
        }
        n10 = object instanceof zzez;
        if (n10 != 0) {
            object = (zzez)object;
            n10 = this.zzd();
            n11 = ((zzep)object).zzd();
            if (n10 != 0 && n11 != 0 && n10 != n11) {
                return false;
            }
            n10 = ((zzep)this).zza();
            return ((zzew)this).zza((zzep)object, 0, n10);
        }
        return object.equals(this);
    }

    public byte zza(int n10) {
        return this.zzb[n10];
    }

    public int zza() {
        return this.zzb.length;
    }

    public final int zza(int n10, int n11, int n12) {
        byte[] byArray = this.zzb;
        int n13 = this.zze();
        return zzfs.zza(n10, byArray, n13, n12);
    }

    public final zzep zza(int n10, int n11) {
        n10 = ((zzep)this).zza();
        byte[] byArray = null;
        if ((n10 = zzep.zzb(0, n11, n10)) == 0) {
            return zzep.zza;
        }
        byArray = this.zzb;
        int n12 = this.zze();
        zzes zzes2 = new zzes(byArray, n12, n10);
        return zzes2;
    }

    public final String zza(Charset charset) {
        byte[] byArray = this.zzb;
        int n10 = this.zze();
        int n11 = ((zzep)this).zza();
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public final void zza(zzem zzem2) {
        byte[] byArray = this.zzb;
        int n10 = this.zze();
        int n11 = ((zzep)this).zza();
        zzem2.zza(byArray, n10, n11);
    }

    public final boolean zza(zzep object, int n10, int n11) {
        n10 = ((zzep)object).zza();
        if (n11 <= n10) {
            n10 = ((zzep)object).zza();
            if (n11 <= n10) {
                n10 = object instanceof zzez;
                if (n10 != 0) {
                    object = (zzez)object;
                    byte[] byArray = this.zzb;
                    byte[] byArray2 = ((zzez)object).zzb;
                    int n12 = this.zze() + n11;
                    n11 = this.zze();
                    int n13 = ((zzez)object).zze();
                    while (n11 < n12) {
                        byte by2 = byArray[n11];
                        byte by3 = byArray2[n13];
                        if (by2 != by3) {
                            return false;
                        }
                        ++n11;
                        ++n13;
                    }
                    return true;
                }
                object = ((zzep)object).zza(0, n11);
                zzep zzep2 = ((zzep)this).zza(0, n11);
                return ((zzep)object).equals(zzep2);
            }
            int n14 = ((zzep)object).zza();
            StringBuilder stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(n11);
            stringBuilder.append(", ");
            stringBuilder.append(n14);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        n10 = ((zzep)this).zza();
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("Length too large: ");
        stringBuilder.append(n11);
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public byte zzb(int n10) {
        return this.zzb[n10];
    }

    public final boolean zzc() {
        int n10 = this.zze();
        byte[] byArray = this.zzb;
        int n11 = ((zzep)this).zza() + n10;
        return zzir.zza(byArray, n10, n11);
    }

    public int zze() {
        return 0;
    }
}

