/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.system.Os
 */
package com.google.android.gms.internal.mlkit_common;

import android.system.Os;
import java.io.FileDescriptor;
import java.util.concurrent.Callable;

public final class zzi
implements Callable {
    private final FileDescriptor zza;

    public zzi(FileDescriptor fileDescriptor) {
        this.zza = fileDescriptor;
    }

    public final Object call() {
        return Os.fstat((FileDescriptor)this.zza);
    }
}

