/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zziu;
import com.google.android.gms.internal.vision.zzla;
import com.google.android.gms.internal.vision.zzlb;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzky
extends AbstractList
implements zziu,
RandomAccess {
    private final zziu zzace;

    public zzky(zziu zziu2) {
        this.zzace = zziu2;
    }

    public static /* synthetic */ zziu zza(zzky zzky2) {
        return zzky2.zzace;
    }

    public final /* synthetic */ Object get(int n10) {
        return (String)this.zzace.get(n10);
    }

    public final Iterator iterator() {
        zzla zzla2 = new zzla(this);
        return zzla2;
    }

    public final ListIterator listIterator(int n10) {
        zzlb zzlb2 = new zzlb(this, n10);
        return zzlb2;
    }

    public final int size() {
        return this.zzace.size();
    }

    public final Object zzbt(int n10) {
        return this.zzace.zzbt(n10);
    }

    public final void zzc(zzgs serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public final List zzhs() {
        return this.zzace.zzhs();
    }

    public final zziu zzht() {
        return this;
    }
}

