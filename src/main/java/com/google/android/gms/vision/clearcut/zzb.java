/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision.clearcut;

public final class zzb {
    private final Object lock;
    private final long zzcb;
    private long zzcc;

    public zzb(double d10) {
        long l10;
        Object object;
        this.lock = object = new Object();
        this.zzcc = Long.MIN_VALUE;
        this.zzcb = l10 = Math.round(30000.0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean tryAcquire() {
        Object object = this.lock;
        synchronized (object) {
            long l10 = System.currentTimeMillis();
            long l11 = this.zzcc;
            long l12 = this.zzcb;
            long l13 = (l11 += l12) - l10;
            long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (l14 > 0) {
                return false;
            }
            this.zzcc = l10;
            return true;
        }
    }
}

