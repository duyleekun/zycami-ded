/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzo;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class zzp {
    private final ConcurrentHashMap zza;
    private final ReferenceQueue zzb;

    public zzp() {
        ReferenceQueue referenceQueue = new ReferenceQueue(16, 0.75f, 10);
        this.zza = referenceQueue;
        this.zzb = referenceQueue = new ReferenceQueue();
    }

    public final List zza(Throwable object, boolean bl2) {
        ConcurrentHashMap concurrentHashMap;
        Vector vector = this.zzb.poll();
        while (vector != null) {
            concurrentHashMap = this.zza;
            concurrentHashMap.remove(vector);
            vector = this.zzb.poll();
        }
        int n10 = 0;
        vector = new Vector((Throwable)object, null);
        concurrentHashMap = this.zza;
        if ((vector = (List)concurrentHashMap.get(vector)) != null) {
            return vector;
        }
        concurrentHashMap = this.zza;
        ReferenceQueue referenceQueue = this.zzb;
        zzo zzo2 = new zzo((Throwable)object, referenceQueue);
        n10 = 2;
        vector = new Vector(n10);
        if ((object = (List)concurrentHashMap.putIfAbsent(zzo2, vector)) == null) {
            return vector;
        }
        return object;
    }
}

