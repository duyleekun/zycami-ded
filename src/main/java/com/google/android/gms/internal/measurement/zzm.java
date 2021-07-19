/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzr;
import java.util.concurrent.atomic.AtomicReference;

public final class zzm
extends zzr {
    private final AtomicReference zza;
    private boolean zzb;

    public zzm() {
        AtomicReference atomicReference;
        this.zza = atomicReference = new AtomicReference();
    }

    public static final Object zze(Bundle object, Class object2) {
        Object[] objectArray;
        Object var2_2 = null;
        if (object != null && (object = object.get((String)(objectArray = "r"))) != null) {
            try {
                var2_2 = ((Class)object2).cast(object);
            }
            catch (ClassCastException classCastException) {
                object2 = ((Class)object2).getCanonicalName();
                object = object.getClass().getCanonicalName();
                objectArray = new Object[]{object2, object};
                object = String.format("Unexpected object type. Expected, Received: %s, %s", objectArray);
                Log.w((String)"AM", (String)object, (Throwable)classCastException);
                throw classCastException;
            }
        }
        return var2_2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzb(Bundle object) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            try {
                boolean bl2;
                AtomicReference atomicReference2 = this.zza;
                atomicReference2.set(object);
                this.zzb = bl2 = true;
                return;
            }
            finally {
                object = this.zza;
                object.notify();
            }
        }
    }

    public final String zzc(long l10) {
        return (String)zzm.zze(this.zzd(l10), String.class);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Bundle zzd(long l10) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            boolean bl2 = this.zzb;
            if (!bl2) {
                try {
                    AtomicReference atomicReference2 = this.zza;
                    atomicReference2.wait(l10);
                }
                catch (InterruptedException interruptedException) {
                    return null;
                }
            }
            AtomicReference atomicReference3 = this.zza;
            atomicReference3 = atomicReference3.get();
            return (Bundle)atomicReference3;
        }
    }
}

