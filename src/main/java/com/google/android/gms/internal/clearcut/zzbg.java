/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbc;
import com.google.android.gms.internal.clearcut.zzbi;
import com.google.android.gms.internal.clearcut.zzbn;

public final class zzbg {
    private final byte[] buffer;
    private final zzbn zzfo;

    private zzbg(int n10) {
        Object object = new byte[n10];
        this.buffer = object;
        object = zzbn.zzc(object);
        this.zzfo = object;
    }

    public /* synthetic */ zzbg(int n10, zzbc zzbc2) {
        this(n10);
    }

    public final zzbb zzad() {
        Object object = this.zzfo;
        int n10 = ((zzbn)object).zzag();
        if (n10 == 0) {
            byte[] byArray = this.buffer;
            object = new zzbi(byArray);
            return object;
        }
        object = new IllegalStateException("Did not write as much data as expected.");
        throw object;
    }

    public final zzbn zzae() {
        return this.zzfo;
    }
}

