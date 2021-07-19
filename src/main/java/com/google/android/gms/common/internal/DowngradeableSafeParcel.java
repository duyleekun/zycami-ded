/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class DowngradeableSafeParcel
extends AbstractSafeParcelable
implements ReflectedParcelable {
    private static final Object zza;
    private static ClassLoader zzb;
    private static Integer zzc;
    private boolean zzd = false;

    static {
        Object object;
        zza = object = new Object();
    }

    public static boolean canUnparcelSafely(String string2) {
        DowngradeableSafeParcel.zza();
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Integer getUnparcelClientVersion() {
        Object object = zza;
        synchronized (object) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ClassLoader zza() {
        Object object = zza;
        synchronized (object) {
            return null;
        }
    }

    public abstract boolean prepareForClientVersion(int var1);

    public void setShouldDowngrade(boolean bl2) {
        this.zzd = bl2;
    }

    public boolean shouldDowngrade() {
        return this.zzd;
    }
}

