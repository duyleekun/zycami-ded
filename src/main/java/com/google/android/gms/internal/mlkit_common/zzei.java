/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzhh;

public abstract class zzei
implements zzhh {
    private boolean zza = true;
    private int zzb = -1;

    public /* synthetic */ Object clone() {
        return this.zza();
    }

    public final zzhh zza() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("clone() should be implemented by subclasses.");
        throw unsupportedOperationException;
    }
}

