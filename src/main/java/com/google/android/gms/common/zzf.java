/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzd;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class zzf
extends zzd {
    private static final WeakReference zzb;
    private WeakReference zza;

    static {
        WeakReference<Object> weakReference;
        zzb = weakReference = new WeakReference<Object>(null);
    }

    public zzf(byte[] object) {
        super((byte[])object);
        object = zzb;
        this.zza = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] zza() {
        synchronized (this) {
            Object object = this.zza;
            object = ((Reference)object).get();
            object = (byte[])object;
            if (object == null) {
                WeakReference<Object> weakReference;
                object = this.zzd();
                this.zza = weakReference = new WeakReference<Object>(object);
            }
            return object;
        }
    }

    public abstract byte[] zzd();
}

