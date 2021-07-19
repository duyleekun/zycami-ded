/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgs;

public final class zzgm
extends zzgq {
    private final int zzc;

    public zzgm(byte[] byArray, int n10, int n11) {
        super(byArray);
        int n12 = byArray.length;
        zzgs.zzn(0, n11, n12);
        this.zzc = n11;
    }

    public final byte zza(int n10) {
        int n11 = this.zzc;
        int n12 = n10 + 1;
        if ((n12 = n11 - n12 | n10) < 0) {
            if (n10 < 0) {
                StringBuilder stringBuilder = new StringBuilder(22);
                stringBuilder.append("Index < 0: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(string2);
                throw arrayIndexOutOfBoundsException;
            }
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Index > length: ");
            stringBuilder.append(n10);
            stringBuilder.append(", ");
            stringBuilder.append(n11);
            String string3 = stringBuilder.toString();
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(string3);
            throw arrayIndexOutOfBoundsException;
        }
        return this.zza[n10];
    }

    public final byte zzb(int n10) {
        return this.zza[n10];
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return 0;
    }
}

