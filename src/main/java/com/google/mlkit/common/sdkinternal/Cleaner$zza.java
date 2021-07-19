/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.Cleaner$Cleanable;
import com.google.mlkit.common.sdkinternal.zzd;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

public final class Cleaner$zza
extends PhantomReference
implements Cleaner$Cleanable {
    private final Set zza;
    private final Runnable zzb;

    private Cleaner$zza(Object object, ReferenceQueue referenceQueue, Set set, Runnable runnable) {
        super(object, referenceQueue);
        this.zza = set;
        this.zzb = runnable;
    }

    public /* synthetic */ Cleaner$zza(Object object, ReferenceQueue referenceQueue, Set set, Runnable runnable, zzd zzd2) {
        this(object, referenceQueue, set, runnable);
    }

    public final void clean() {
        Set set = this.zza;
        boolean bl2 = set.remove(this);
        if (!bl2) {
            return;
        }
        this.clear();
        this.zzb.run();
    }
}

