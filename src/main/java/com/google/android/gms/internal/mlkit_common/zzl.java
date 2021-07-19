/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.system.Os
 */
package com.google.android.gms.internal.mlkit_common;

import android.system.Os;
import java.util.concurrent.Callable;

public final class zzl
implements Callable {
    private final String zza;

    public zzl(String string2) {
        this.zza = string2;
    }

    public final Object call() {
        return Os.lstat((String)this.zza);
    }
}

