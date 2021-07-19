/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.Cleaner$zza;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

public final class zzb
implements Runnable {
    private final ReferenceQueue zza;
    private final Set zzb;

    public zzb(ReferenceQueue referenceQueue, Set set) {
        this.zza = referenceQueue;
        this.zzb = set;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void run() {
        boolean bl2;
        ReferenceQueue referenceQueue = this.zza;
        Set set = this.zzb;
        while (!(bl2 = set.isEmpty())) {
            Cleaner$zza cleaner$zza;
            try {
                cleaner$zza = referenceQueue.remove();
            }
            catch (InterruptedException interruptedException) {
                continue;
            }
            cleaner$zza = cleaner$zza;
            cleaner$zza.clean();
        }
    }
}

