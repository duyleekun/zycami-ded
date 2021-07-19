/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.zza;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberedThreadFactory
implements ThreadFactory {
    private final String zza;
    private final int zzb;
    private final AtomicInteger zzc;
    private final ThreadFactory zzd;

    public NumberedThreadFactory(String string2) {
        this(string2, 0);
    }

    private NumberedThreadFactory(String string2, int n10) {
        Object object = new AtomicInteger();
        this.zzc = object;
        this.zzd = object = Executors.defaultThreadFactory();
        this.zza = string2 = (String)Preconditions.checkNotNull(string2, "Name must not be null");
        this.zzb = 0;
    }

    public Thread newThread(Runnable runnable) {
        Object object = this.zzd;
        zza zza2 = new zza(runnable, 0);
        runnable = object.newThread(zza2);
        object = this.zza;
        int n10 = this.zzc.getAndIncrement();
        int n11 = String.valueOf(object).length() + 13;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append((String)object);
        stringBuilder.append("[");
        stringBuilder.append(n10);
        stringBuilder.append("]");
        object = stringBuilder.toString();
        ((Thread)runnable).setName((String)object);
        return runnable;
    }
}

