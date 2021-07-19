/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzr;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzq {
    private final Object zza;
    private Queue zzb;
    private boolean zzc;

    public zzq() {
        Object object;
        this.zza = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(Task task) {
        Object object;
        Object object2 = this.zza;
        synchronized (object2) {
            boolean bl2;
            object = this.zzb;
            if (object != null && !(bl2 = this.zzc)) {
                this.zzc = bl2 = true;
            } else {
                return;
            }
        }
        while (true) {
            object = this.zza;
            synchronized (object) {
                object2 = this.zzb;
                object2 = object2.poll();
                object2 = (zzr)object2;
                if (object2 == null) {
                    task = null;
                    this.zzc = false;
                    return;
                }
            }
            object2.zza(task);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(zzr zzr2) {
        Object object = this.zza;
        synchronized (object) {
            ArrayDeque<zzr> arrayDeque = this.zzb;
            if (arrayDeque == null) {
                this.zzb = arrayDeque = new ArrayDeque<zzr>();
            }
            arrayDeque = this.zzb;
            arrayDeque.add(zzr2);
            return;
        }
    }
}

