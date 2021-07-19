/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzfc;
import com.google.android.gms.internal.mlkit_vision_common.zzhd;
import com.google.android.gms.internal.mlkit_vision_common.zzhg;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzhe
extends AbstractList
implements zzfc,
RandomAccess {
    private final zzfc zza;

    public zzhe(zzfc zzfc2) {
        this.zza = zzfc2;
    }

    public static /* synthetic */ zzfc zza(zzhe zzhe2) {
        return zzhe2.zza;
    }

    public final /* synthetic */ Object get(int n10) {
        return (String)this.zza.get(n10);
    }

    public final Iterator iterator() {
        zzhg zzhg2 = new zzhg(this);
        return zzhg2;
    }

    public final ListIterator listIterator(int n10) {
        zzhd zzhd2 = new zzhd(this, n10);
        return zzhd2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final Object zza(int n10) {
        return this.zza.zza(n10);
    }

    public final void zza(zzdf serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public final List zzd() {
        return this.zza.zzd();
    }

    public final zzfc zze() {
        return this;
    }
}

