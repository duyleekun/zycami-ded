/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjs;

public abstract class zzgg
implements zzjs {
    private boolean zztf = true;
    private int zztg = -1;

    public /* synthetic */ Object clone() {
        return this.zzeg();
    }

    public final zzjs zzeg() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("clone() should be implemented by subclasses.");
        throw unsupportedOperationException;
    }
}

