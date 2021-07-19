/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfx;

public final class zzfw
implements Cloneable {
    private static final zzfx zzrl;
    private int mSize;
    private boolean zzrm = false;
    private int[] zzrn;
    private zzfx[] zzro;

    static {
        zzfx zzfx2;
        zzrl = zzfx2 = new zzfx();
    }

    public zzfw() {
        this(10);
    }

    private zzfw(int n10) {
        int n11;
        int n12;
        n10 <<= 2;
        for (int i10 = n11 = 4; i10 < (n12 = 32); ++i10) {
            n12 = (1 << i10) + -12;
            if (n10 > n12) continue;
            n10 = n12;
            break;
        }
        int[] nArray = new int[n10 /= n11];
        this.zzrn = nArray;
        zzfx[] zzfxArray = new zzfx[n10];
        this.zzro = zzfxArray;
        this.mSize = 0;
    }

    public final /* synthetic */ Object clone() {
        int n10 = this.mSize;
        zzfw zzfw2 = new zzfw(n10);
        Object object = this.zzrn;
        Object object2 = zzfw2.zzrn;
        System.arraycopy(object, 0, object2, 0, n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            object = this.zzro;
            object2 = object[i10];
            if (object2 == null) continue;
            object2 = zzfw2.zzro;
            object = (zzfx)object[i10].clone();
            object2[i10] = (int)object;
        }
        zzfw2.mSize = n10;
        return zzfw2;
    }

    public final boolean equals(Object zzfxArray) {
        zzfx[] zzfxArray2;
        int n10;
        zzfx zzfx2;
        int[] nArray;
        int n11;
        int n12;
        int n13;
        block7: {
            n13 = 1;
            if (zzfxArray == this) {
                return n13 != 0;
            }
            n12 = zzfxArray instanceof zzfw;
            if (!n12) {
                return false;
            }
            zzfxArray = (zzfw)zzfxArray;
            n12 = this.mSize;
            n11 = zzfxArray.mSize;
            if (n12 != n11) {
                return false;
            }
            int[] nArray2 = this.zzrn;
            nArray = zzfxArray.zzrn;
            zzfx2 = null;
            for (n10 = 0; n10 < n12; n10 += 1) {
                int n14 = nArray2[n10];
                int n15 = nArray[n10];
                if (n14 == n15) continue;
                n12 = 0;
                zzfxArray2 = null;
                break block7;
            }
            n12 = n13;
        }
        if (n12) {
            int n16;
            block8: {
                zzfxArray2 = this.zzro;
                zzfxArray = zzfxArray.zzro;
                n11 = this.mSize;
                nArray = null;
                for (int i10 = 0; i10 < n11; ++i10) {
                    zzfx2 = zzfxArray2[i10];
                    zzfx zzfx3 = zzfxArray[i10];
                    n10 = zzfx2.equals(zzfx3);
                    if (n10) continue;
                    n16 = 0;
                    zzfxArray = null;
                    break block8;
                }
                n16 = n13;
            }
            if (n16) {
                return n13 != 0;
            }
        }
        return false;
    }

    public final int hashCode() {
        int n10;
        int n11 = 17;
        for (int i10 = 0; i10 < (n10 = this.mSize); ++i10) {
            n11 *= 31;
            n10 = this.zzrn[i10];
            n11 = (n11 + n10) * 31;
            zzfx zzfx2 = this.zzro[i10];
            n10 = zzfx2.hashCode();
            n11 += n10;
        }
        return n11;
    }

    public final boolean isEmpty() {
        int n10 = this.mSize;
        return n10 == 0;
    }

    public final int size() {
        return this.mSize;
    }

    public final zzfx zzaq(int n10) {
        return this.zzro[n10];
    }
}

