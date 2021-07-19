/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.Cleaner$Cleanable;
import com.google.mlkit.common.sdkinternal.Cleaner$zza;
import com.google.mlkit.common.sdkinternal.zza;
import com.google.mlkit.common.sdkinternal.zzb;
import com.google.mlkit.common.sdkinternal.zzc;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ThreadFactory;

public class Cleaner {
    private final ReferenceQueue zza;
    private final Set zzb;

    private Cleaner() {
        Set set = new Set();
        this.zza = set;
        set = new Set();
        this.zzb = set = Collections.synchronizedSet(set);
    }

    public static Cleaner create() {
        ThreadFactory threadFactory = com.google.mlkit.common.sdkinternal.zza.zza;
        Cleaner cleaner = new Cleaner();
        Object object = zzc.zza;
        cleaner.register(cleaner, (Runnable)object);
        object = cleaner.zza;
        Set set = cleaner.zzb;
        zzb zzb2 = new zzb((ReferenceQueue)object, set);
        threadFactory.newThread(zzb2).start();
        return cleaner;
    }

    public Cleaner$Cleanable register(Object object, Runnable runnable) {
        ReferenceQueue referenceQueue = this.zza;
        Set set = this.zzb;
        Cleaner$zza cleaner$zza = new Cleaner$zza(object, referenceQueue, set, runnable, null);
        this.zzb.add(cleaner$zza);
        return cleaner$zza;
    }
}

