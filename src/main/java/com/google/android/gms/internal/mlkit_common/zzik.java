/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzgi;
import com.google.android.gms.internal.mlkit_common.zzim;
import com.google.android.gms.internal.mlkit_common.zzin;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzik
extends AbstractList
implements zzgi,
RandomAccess {
    private final zzgi zza;

    public zzik(zzgi zzgi2) {
        this.zza = zzgi2;
    }

    public static /* synthetic */ zzgi zza(zzik zzik2) {
        return zzik2.zza;
    }

    public final zzgi a_() {
        return this;
    }

    public final /* synthetic */ Object get(int n10) {
        return (String)this.zza.get(n10);
    }

    public final Iterator iterator() {
        zzim zzim2 = new zzim(this);
        return zzim2;
    }

    public final ListIterator listIterator(int n10) {
        zzin zzin2 = new zzin(this, n10);
        return zzin2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final Object zza(int n10) {
        return this.zza.zza(n10);
    }

    public final void zza(zzep serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public final List zzb() {
        return this.zza.zzb();
    }
}

