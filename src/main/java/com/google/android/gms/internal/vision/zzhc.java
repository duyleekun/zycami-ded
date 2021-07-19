/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzgt;
import com.google.android.gms.internal.vision.zzgz;
import com.google.android.gms.internal.vision.zzhd;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzlf;
import java.nio.charset.Charset;
import java.util.Objects;

public class zzhc
extends zzhd {
    public final byte[] zzua;

    public zzhc(byte[] byArray) {
        Objects.requireNonNull(byArray);
        this.zzua = byArray;
    }

    public final boolean equals(Object object) {
        int n10 = 1;
        if (object == this) {
            return n10 != 0;
        }
        int n11 = object instanceof zzgs;
        if (n11 == 0) {
            return false;
        }
        n11 = ((zzgs)this).size();
        Object object2 = object;
        object2 = (zzgs)object;
        int n12 = ((zzgs)object2).size();
        if (n11 != n12) {
            return false;
        }
        n11 = ((zzgs)this).size();
        if (n11 == 0) {
            return n10 != 0;
        }
        n10 = object instanceof zzhc;
        if (n10 != 0) {
            object = (zzhc)object;
            n10 = this.zzfn();
            n11 = ((zzgs)object).zzfn();
            if (n10 != 0 && n11 != 0 && n10 != n11) {
                return false;
            }
            n10 = ((zzgs)this).size();
            return ((zzhd)this).zza((zzgs)object, 0, n10);
        }
        return object.equals(this);
    }

    public int size() {
        return this.zzua.length;
    }

    public final String zza(Charset charset) {
        byte[] byArray = this.zzua;
        int n10 = this.zzfo();
        int n11 = ((zzgs)this).size();
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public final void zza(zzgt zzgt2) {
        byte[] byArray = this.zzua;
        int n10 = this.zzfo();
        int n11 = ((zzgs)this).size();
        zzgt2.zzc(byArray, n10, n11);
    }

    public void zza(byte[] byArray, int n10, int n11, int n12) {
        System.arraycopy(this.zzua, 0, byArray, 0, n12);
    }

    public final boolean zza(zzgs object, int n10, int n11) {
        n10 = ((zzgs)object).size();
        if (n11 <= n10) {
            n10 = ((zzgs)object).size();
            if (n11 <= n10) {
                n10 = object instanceof zzhc;
                if (n10 != 0) {
                    object = (zzhc)object;
                    byte[] byArray = this.zzua;
                    byte[] byArray2 = ((zzhc)object).zzua;
                    int n12 = this.zzfo() + n11;
                    n11 = this.zzfo();
                    int n13 = ((zzhc)object).zzfo();
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
                object = ((zzgs)object).zzi(0, n11);
                zzgs zzgs2 = ((zzgs)this).zzi(0, n11);
                return ((zzgs)object).equals(zzgs2);
            }
            int n14 = ((zzgs)object).size();
            StringBuilder stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(n11);
            stringBuilder.append(", ");
            stringBuilder.append(n14);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        n10 = ((zzgs)this).size();
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("Length too large: ");
        stringBuilder.append(n11);
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public byte zzau(int n10) {
        return this.zzua[n10];
    }

    public byte zzav(int n10) {
        return this.zzua[n10];
    }

    public final int zzd(int n10, int n11, int n12) {
        byte[] byArray = this.zzua;
        int n13 = this.zzfo();
        return zzie.zza(n10, byArray, n13, n12);
    }

    public final boolean zzfm() {
        int n10 = this.zzfo();
        byte[] byArray = this.zzua;
        int n11 = ((zzgs)this).size() + n10;
        return zzlf.zzf(byArray, n10, n11);
    }

    public int zzfo() {
        return 0;
    }

    public final zzgs zzi(int n10, int n11) {
        n10 = ((zzgs)this).size();
        byte[] byArray = null;
        if ((n10 = zzgs.zze(0, n11, n10)) == 0) {
            return zzgs.zztt;
        }
        byArray = this.zzua;
        int n12 = this.zzfo();
        zzgz zzgz2 = new zzgz(byArray, n12, n10);
        return zzgz2;
    }
}

