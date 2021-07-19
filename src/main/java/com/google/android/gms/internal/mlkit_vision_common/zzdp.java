/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdg;
import com.google.android.gms.internal.mlkit_vision_common.zzdm;
import com.google.android.gms.internal.mlkit_vision_common.zzdq;
import com.google.android.gms.internal.mlkit_vision_common.zzem;
import com.google.android.gms.internal.mlkit_vision_common.zzhi;
import java.nio.charset.Charset;
import java.util.Objects;

public class zzdp
extends zzdq {
    public final byte[] zzb;

    public zzdp(byte[] byArray) {
        Objects.requireNonNull(byArray);
        this.zzb = byArray;
    }

    public final boolean equals(Object object) {
        int n10 = 1;
        if (object == this) {
            return n10 != 0;
        }
        int n11 = object instanceof zzdf;
        if (n11 == 0) {
            return false;
        }
        n11 = ((zzdf)this).zza();
        Object object2 = object;
        object2 = (zzdf)object;
        int n12 = ((zzdf)object2).zza();
        if (n11 != n12) {
            return false;
        }
        n11 = ((zzdf)this).zza();
        if (n11 == 0) {
            return n10 != 0;
        }
        n10 = object instanceof zzdp;
        if (n10 != 0) {
            object = (zzdp)object;
            n10 = this.zzd();
            n11 = ((zzdf)object).zzd();
            if (n10 != 0 && n11 != 0 && n10 != n11) {
                return false;
            }
            n10 = ((zzdf)this).zza();
            return ((zzdq)this).zza((zzdf)object, 0, n10);
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
        return zzem.zza(n10, byArray, n13, n12);
    }

    public final zzdf zza(int n10, int n11) {
        n10 = ((zzdf)this).zza();
        byte[] byArray = null;
        if ((n10 = zzdf.zzb(0, n11, n10)) == 0) {
            return zzdf.zza;
        }
        byArray = this.zzb;
        int n12 = this.zze();
        zzdm zzdm2 = new zzdm(byArray, n12, n10);
        return zzdm2;
    }

    public final String zza(Charset charset) {
        byte[] byArray = this.zzb;
        int n10 = this.zze();
        int n11 = ((zzdf)this).zza();
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public final void zza(zzdg zzdg2) {
        byte[] byArray = this.zzb;
        int n10 = this.zze();
        int n11 = ((zzdf)this).zza();
        zzdg2.zza(byArray, n10, n11);
    }

    public final boolean zza(zzdf object, int n10, int n11) {
        n10 = ((zzdf)object).zza();
        if (n11 <= n10) {
            n10 = ((zzdf)object).zza();
            if (n11 <= n10) {
                n10 = object instanceof zzdp;
                if (n10 != 0) {
                    object = (zzdp)object;
                    byte[] byArray = this.zzb;
                    byte[] byArray2 = ((zzdp)object).zzb;
                    int n12 = this.zze() + n11;
                    n11 = this.zze();
                    int n13 = ((zzdp)object).zze();
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
                object = ((zzdf)object).zza(0, n11);
                zzdf zzdf2 = ((zzdf)this).zza(0, n11);
                return ((zzdf)object).equals(zzdf2);
            }
            int n14 = ((zzdf)object).zza();
            StringBuilder stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(n11);
            stringBuilder.append(", ");
            stringBuilder.append(n14);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        n10 = ((zzdf)this).zza();
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
        int n11 = ((zzdf)this).zza() + n10;
        return zzhi.zza(byArray, n10, n11);
    }

    public int zze() {
        return 0;
    }
}

