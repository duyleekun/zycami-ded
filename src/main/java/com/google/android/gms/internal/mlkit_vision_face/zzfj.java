/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfa;
import com.google.android.gms.internal.mlkit_vision_face.zzfg;
import com.google.android.gms.internal.mlkit_vision_face.zzfk;
import com.google.android.gms.internal.mlkit_vision_face.zzgg;
import com.google.android.gms.internal.mlkit_vision_face.zzjc;
import java.nio.charset.Charset;
import java.util.Objects;

public class zzfj
extends zzfk {
    public final byte[] zzb;

    public zzfj(byte[] byArray) {
        Objects.requireNonNull(byArray);
        this.zzb = byArray;
    }

    public final boolean equals(Object object) {
        int n10 = 1;
        if (object == this) {
            return n10 != 0;
        }
        int n11 = object instanceof zzez;
        if (n11 == 0) {
            return false;
        }
        n11 = ((zzez)this).zza();
        Object object2 = object;
        object2 = (zzez)object;
        int n12 = ((zzez)object2).zza();
        if (n11 != n12) {
            return false;
        }
        n11 = ((zzez)this).zza();
        if (n11 == 0) {
            return n10 != 0;
        }
        n10 = object instanceof zzfj;
        if (n10 != 0) {
            object = (zzfj)object;
            n10 = this.zzd();
            n11 = ((zzez)object).zzd();
            if (n10 != 0 && n11 != 0 && n10 != n11) {
                return false;
            }
            n10 = ((zzez)this).zza();
            return ((zzfk)this).zza((zzez)object, 0, n10);
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
        return zzgg.zza(n10, byArray, n13, n12);
    }

    public final zzez zza(int n10, int n11) {
        n10 = ((zzez)this).zza();
        byte[] byArray = null;
        if ((n10 = zzez.zzb(0, n11, n10)) == 0) {
            return zzez.zza;
        }
        byArray = this.zzb;
        int n12 = this.zze();
        zzfg zzfg2 = new zzfg(byArray, n12, n10);
        return zzfg2;
    }

    public final String zza(Charset charset) {
        byte[] byArray = this.zzb;
        int n10 = this.zze();
        int n11 = ((zzez)this).zza();
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public final void zza(zzfa zzfa2) {
        byte[] byArray = this.zzb;
        int n10 = this.zze();
        int n11 = ((zzez)this).zza();
        zzfa2.zza(byArray, n10, n11);
    }

    public final boolean zza(zzez object, int n10, int n11) {
        n10 = ((zzez)object).zza();
        if (n11 <= n10) {
            n10 = ((zzez)object).zza();
            if (n11 <= n10) {
                n10 = object instanceof zzfj;
                if (n10 != 0) {
                    object = (zzfj)object;
                    byte[] byArray = this.zzb;
                    byte[] byArray2 = ((zzfj)object).zzb;
                    int n12 = this.zze() + n11;
                    n11 = this.zze();
                    int n13 = ((zzfj)object).zze();
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
                object = ((zzez)object).zza(0, n11);
                zzez zzez2 = ((zzez)this).zza(0, n11);
                return ((zzez)object).equals(zzez2);
            }
            int n14 = ((zzez)object).zza();
            StringBuilder stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(n11);
            stringBuilder.append(", ");
            stringBuilder.append(n14);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        n10 = ((zzez)this).zza();
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
        int n11 = ((zzez)this).zza() + n10;
        return zzjc.zza(byArray, n10, n11);
    }

    public int zze() {
        return 0;
    }
}

