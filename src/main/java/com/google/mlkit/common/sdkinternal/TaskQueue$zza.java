/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.TaskQueue;
import com.google.mlkit.common.sdkinternal.zzo;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicReference;

public final class TaskQueue$zza
implements Closeable {
    private final /* synthetic */ TaskQueue zza;

    private TaskQueue$zza(TaskQueue object) {
        boolean bl2;
        this.zza = object;
        object = TaskQueue.zza((TaskQueue)object);
        Thread thread = Thread.currentThread();
        object = ((AtomicReference)object).getAndSet(thread);
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2);
    }

    public /* synthetic */ TaskQueue$zza(TaskQueue taskQueue, zzo zzo2) {
        this(taskQueue);
    }

    public final void close() {
        TaskQueue.zza(this.zza).set(null);
        TaskQueue.zzb(this.zza);
    }
}

