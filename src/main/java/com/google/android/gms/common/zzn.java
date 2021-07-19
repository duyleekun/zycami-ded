/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzl;
import com.google.android.gms.common.zzo;
import java.util.concurrent.Callable;

public final class zzn
extends zzl {
    private final Callable zzb;

    private zzn(Callable callable) {
        super(false, null, null);
        this.zzb = callable;
    }

    public /* synthetic */ zzn(Callable callable, zzo zzo2) {
        this(callable);
    }

    public final String zzb() {
        Callable callable;
        try {
            callable = this.zzb;
        }
        catch (Exception exception) {
            RuntimeException runtimeException = new RuntimeException(exception);
            throw runtimeException;
        }
        callable = callable.call();
        return (String)((Object)callable);
    }
}

