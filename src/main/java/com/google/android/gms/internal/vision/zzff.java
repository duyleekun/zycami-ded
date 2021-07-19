/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfi;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class zzff {
    private final ConcurrentHashMap zzny;
    private final ReferenceQueue zznz;

    public zzff() {
        ReferenceQueue referenceQueue = new ReferenceQueue(16, 0.75f, 10);
        this.zzny = referenceQueue;
        this.zznz = referenceQueue = new ReferenceQueue();
    }

    public final List zza(Throwable object, boolean bl2) {
        Object object2;
        Object object3 = this.zznz.poll();
        while (object3 != null) {
            object2 = this.zzny;
            ((ConcurrentHashMap)object2).remove(object3);
            object3 = this.zznz.poll();
        }
        object3 = new zzfi((Throwable)object, null);
        object2 = this.zzny;
        object3 = (List)((ConcurrentHashMap)object2).get(object3);
        if (!bl2) {
            return object3;
        }
        if (object3 != null) {
            return object3;
        }
        object3 = this.zzny;
        ReferenceQueue referenceQueue = this.zznz;
        object2 = new zzfi((Throwable)object, referenceQueue);
        int n10 = 2;
        Vector vector = new Vector(n10);
        if ((object = (List)((ConcurrentHashMap)object3).putIfAbsent(object2, vector)) == null) {
            return vector;
        }
        return object;
    }
}

