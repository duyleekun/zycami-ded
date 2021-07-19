/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzjz;
import com.google.android.gms.internal.measurement.zzka;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzkb
extends AbstractList
implements RandomAccess,
zzih {
    private final zzih zza;

    public zzkb(zzih zzih2) {
        this.zza = zzih2;
    }

    public static /* synthetic */ zzih zza(zzkb zzkb2) {
        return zzkb2.zza;
    }

    public final Iterator iterator() {
        zzka zzka2 = new zzka(this);
        return zzka2;
    }

    public final ListIterator listIterator(int n10) {
        zzjz zzjz2 = new zzjz(this, n10);
        return zzjz2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzgs serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public final Object zzg(int n10) {
        return this.zza.zzg(n10);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final zzih zzi() {
        return this;
    }
}

