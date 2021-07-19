/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbk;
import com.google.android.gms.internal.clearcut.zzbl;
import com.google.android.gms.internal.clearcut.zzco;

public final class zzbm
extends zzbk {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzfu;
    private int zzfv;
    private int zzfw;
    private int zzfx = -1 >>> 1;

    private zzbm(byte[] byArray, int n10, int n11, boolean bl2) {
        super(null);
        this.buffer = byArray;
        this.limit = n11 += n10;
        this.pos = n10;
        this.zzfw = n10;
        this.zzfu = bl2;
    }

    public /* synthetic */ zzbm(byte[] byArray, int n10, int n11, boolean bl2, zzbl zzbl2) {
        this(byArray, n10, n11, bl2);
    }

    public final int zzaf() {
        int n10 = this.pos;
        int n11 = this.zzfw;
        return n10 - n11;
    }

    public final int zzl(int n10) {
        if (n10 >= 0) {
            int n11 = ((zzbk)this).zzaf();
            if ((n10 += n11) <= (n11 = this.zzfx)) {
                this.zzfx = n10;
                int n12 = this.limit;
                int n13 = this.zzfv;
                this.limit = n12 += n13;
                n13 = this.zzfw;
                if ((n13 = n12 - n13) > n10) {
                    this.zzfv = n13 -= n10;
                    this.limit = n12 -= n13;
                } else {
                    n10 = 0;
                    Object var5_5 = null;
                    this.zzfv = 0;
                }
                return n11;
            }
            throw zzco.zzbl();
        }
        zzco zzco2 = new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        throw zzco2;
    }
}

