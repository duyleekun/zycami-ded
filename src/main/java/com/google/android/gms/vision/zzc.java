/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package com.google.android.gms.vision;

import android.util.SparseIntArray;

public final class zzc {
    private static final Object lock;
    private static int zzba;
    private final SparseIntArray zzbb;
    private final SparseIntArray zzbc;

    static {
        Object object;
        lock = object = new Object();
    }

    public zzc() {
        SparseIntArray sparseIntArray;
        this.zzbb = sparseIntArray = new SparseIntArray();
        this.zzbc = sparseIntArray = new SparseIntArray();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int zzb(int n10) {
        Object object = lock;
        synchronized (object) {
            SparseIntArray sparseIntArray = this.zzbb;
            int n11 = -1;
            int n12 = sparseIntArray.get(n10, n11);
            if (n12 != n11) {
                return n12;
            }
            n12 = zzba;
            zzba = n11 = n12 + 1;
            SparseIntArray sparseIntArray2 = this.zzbb;
            sparseIntArray2.append(n10, n12);
            sparseIntArray2 = this.zzbc;
            sparseIntArray2.append(n12, n10);
            return n12;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int zzc(int n10) {
        Object object = lock;
        synchronized (object) {
            SparseIntArray sparseIntArray = this.zzbc;
            return sparseIntArray.get(n10);
        }
    }
}

