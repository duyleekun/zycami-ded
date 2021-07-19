/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzgx;
import java.util.NoSuchElementException;

public final class zzgv
extends zzgx {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzgs zztw;

    public zzgv(zzgs zzgs2) {
        int n10;
        this.zztw = zzgs2;
        this.limit = n10 = zzgs2.size();
    }

    public final boolean hasNext() {
        int n10 = this.position;
        int n11 = this.limit;
        return n10 < n11;
    }

    public final byte nextByte() {
        int n10 = this.position;
        int n11 = this.limit;
        if (n10 < n11) {
            this.position = n11 = n10 + 1;
            return this.zztw.zzav(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

