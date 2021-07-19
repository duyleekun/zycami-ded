/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzgw;
import com.google.android.gms.internal.mlkit_vision_face.zzix;
import com.google.android.gms.internal.mlkit_vision_face.zzja;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zziy
extends AbstractList
implements zzgw,
RandomAccess {
    private final zzgw zza;

    public zziy(zzgw zzgw2) {
        this.zza = zzgw2;
    }

    public static /* synthetic */ zzgw zza(zziy zziy2) {
        return zziy2.zza;
    }

    public final /* synthetic */ Object get(int n10) {
        return (String)this.zza.get(n10);
    }

    public final Iterator iterator() {
        zzja zzja2 = new zzja(this);
        return zzja2;
    }

    public final ListIterator listIterator(int n10) {
        zzix zzix2 = new zzix(this, n10);
        return zzix2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final Object zza(int n10) {
        return this.zza.zza(n10);
    }

    public final void zza(zzez serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public final List zzd() {
        return this.zza.zzd();
    }

    public final zzgw zze() {
        return this;
    }
}

