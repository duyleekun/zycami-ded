/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzez;

public final class zzes
extends zzez {
    private final int zzc;
    private final int zzd;

    public zzes(byte[] byArray, int n10, int n11) {
        super(byArray);
        int n12 = n10 + n11;
        int n13 = byArray.length;
        zzep.zzb(n10, n12, n13);
        this.zzc = n10;
        this.zzd = n11;
    }

    public final byte zza(int n10) {
        int n11 = ((zzep)this).zza();
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
        byte[] byArray = this.zzb;
        n12 = this.zzc + n10;
        return byArray[n12];
    }

    public final int zza() {
        return this.zzd;
    }

    public final byte zzb(int n10) {
        byte[] byArray = this.zzb;
        int n11 = this.zzc + n10;
        return byArray[n11];
    }

    public final int zze() {
        return this.zzc;
    }
}

