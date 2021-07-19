/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzgp;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgx;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzkn;
import java.nio.charset.Charset;
import java.util.Objects;

public class zzgq
extends zzgp {
    public final byte[] zza;

    public zzgq(byte[] byArray) {
        Objects.requireNonNull(byArray);
        this.zza = byArray;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof zzgs;
        StringBuilder stringBuilder = null;
        if (n10 == 0) {
            return false;
        }
        n10 = this.zzc();
        Object object2 = object;
        object2 = (zzgs)object;
        int n11 = ((zzgs)object2).zzc();
        if (n10 != n11) {
            return false;
        }
        n10 = this.zzc();
        if (n10 == 0) {
            return bl2;
        }
        n10 = object instanceof zzgq;
        if (n10 != 0) {
            object = (zzgq)object;
            n10 = this.zzm();
            n11 = ((zzgs)object).zzm();
            if (n10 != 0 && n11 != 0 && n10 != n11) {
                return false;
            }
            n10 = this.zzc();
            if (n10 <= (n11 = ((zzgs)object).zzc())) {
                n11 = ((zzgs)object).zzc();
                if (n10 <= n11) {
                    void var2_5;
                    n11 = object instanceof zzgq;
                    if (n11 != 0) {
                        object2 = this.zza;
                        byte[] byArray = ((zzgq)object).zza;
                        ((zzgq)object).zzd();
                        int n12 = 0;
                        object = null;
                        int n13 = 0;
                        while (n12 < n10) {
                            Object object3 = object2[n12];
                            byte by2 = byArray[n13];
                            if (object3 != by2) {
                                boolean bl3 = false;
                                Object var12_17 = null;
                                break;
                            }
                            ++n12;
                            ++n13;
                        }
                    } else {
                        object = ((zzgs)object).zze(0, n10);
                        zzgs zzgs2 = this.zze(0, n10);
                        boolean bl4 = ((zzgs)object).equals(zzgs2);
                    }
                    return (boolean)var2_5;
                }
                int n14 = ((zzgs)object).zzc();
                stringBuilder = new StringBuilder(59);
                stringBuilder.append("Ran off end of other: 0, ");
                stringBuilder.append(n10);
                stringBuilder.append(", ");
                stringBuilder.append(n14);
                object = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            int n15 = this.zzc();
            stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(n10);
            stringBuilder.append(n15);
            String string2 = stringBuilder.toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        return object.equals(this);
    }

    public byte zza(int n10) {
        return this.zza[n10];
    }

    public byte zzb(int n10) {
        return this.zza[n10];
    }

    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    public final zzgs zze(int n10, int n11) {
        n10 = this.zzc();
        if ((n10 = zzgs.zzn(0, n11, n10)) == 0) {
            return zzgs.zzb;
        }
        byte[] byArray = this.zza;
        zzgm zzgm2 = new zzgm(byArray, 0, n10);
        return zzgm2;
    }

    public final void zzf(zzgh zzgh2) {
        byte[] byArray = this.zza;
        int n10 = this.zzc();
        ((zzgx)zzgh2).zzp(byArray, 0, n10);
    }

    public final String zzg(Charset charset) {
        byte[] byArray = this.zza;
        int n10 = this.zzc();
        String string2 = new String(byArray, 0, n10, charset);
        return string2;
    }

    public final boolean zzh() {
        byte[] byArray = this.zza;
        int n10 = this.zzc();
        return zzkn.zzb(byArray, 0, n10);
    }

    public final int zzi(int n10, int n11, int n12) {
        byte[] byArray = this.zza;
        return zzia.zzh(n10, byArray, 0, n12);
    }
}

