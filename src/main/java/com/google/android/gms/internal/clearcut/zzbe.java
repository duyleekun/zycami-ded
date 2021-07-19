/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbi;

public final class zzbe
extends zzbi {
    private final int zzfm;
    private final int zzfn;

    public zzbe(byte[] byArray, int n10, int n11) {
        super(byArray);
        int n12 = n10 + n11;
        int n13 = byArray.length;
        zzbb.zzb(n10, n12, n13);
        this.zzfm = n10;
        this.zzfn = n11;
    }

    public final int size() {
        return this.zzfn;
    }

    public final int zzac() {
        return this.zzfm;
    }

    public final byte zzj(int n10) {
        int n11 = ((zzbb)this).size();
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
        byte[] byArray = this.zzfp;
        n12 = this.zzfm + n10;
        return byArray[n12];
    }
}

