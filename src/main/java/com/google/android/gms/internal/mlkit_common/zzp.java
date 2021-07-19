/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzn;
import java.io.FileDescriptor;
import java.util.concurrent.Callable;

public final class zzp
implements Callable {
    private final FileDescriptor zza;

    public zzp(FileDescriptor fileDescriptor) {
        this.zza = fileDescriptor;
    }

    public final Object call() {
        return zzn.zzb(this.zza);
    }
}

