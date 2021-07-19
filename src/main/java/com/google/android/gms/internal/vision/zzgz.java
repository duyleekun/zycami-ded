/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhc;

public final class zzgz
extends zzhc {
    private final int zztx;
    private final int zzty;

    public zzgz(byte[] byArray, int n10, int n11) {
        super(byArray);
        int n12 = n10 + n11;
        int n13 = byArray.length;
        zzgs.zze(n10, n12, n13);
        this.zztx = n10;
        this.zzty = n11;
    }

    public final int size() {
        return this.zzty;
    }

    public final void zza(byte[] byArray, int n10, int n11, int n12) {
        byte[] byArray2 = this.zzua;
        n11 = ((zzhc)this).zzfo();
        System.arraycopy(byArray2, n11, byArray, 0, n12);
    }

    public final byte zzau(int n10) {
        int n11 = ((zzgs)this).size();
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
        byte[] byArray = this.zzua;
        n12 = this.zztx + n10;
        return byArray[n12];
    }

    public final byte zzav(int n10) {
        byte[] byArray = this.zzua;
        int n11 = this.zztx + n10;
        return byArray[n11];
    }

    public final int zzfo() {
        return this.zztx;
    }
}

