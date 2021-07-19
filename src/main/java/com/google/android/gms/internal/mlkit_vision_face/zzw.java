/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzu;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzx;
import java.util.List;
import java.util.ListIterator;

public final class zzw
extends zzu
implements ListIterator {
    private final /* synthetic */ zzx zzb;

    public zzw(zzx zzx2) {
        this.zzb = zzx2;
        super(zzx2);
    }

    public zzw(zzx zzx2, int n10) {
        this.zzb = zzx2;
        ListIterator listIterator = ((List)zzx2.zzb).listIterator(n10);
        super(zzx2, listIterator);
    }

    private final ListIterator zzb() {
        this.zza();
        return (ListIterator)this.zza;
    }

    public final void add(Object object) {
        zzx zzx2 = this.zzb;
        boolean bl2 = zzx2.isEmpty();
        ListIterator listIterator = this.zzb();
        listIterator.add(object);
        object = this.zzb.zzd;
        zzm.zzc((zzm)object);
        if (bl2) {
            object = this.zzb;
            ((zzv)object).zzc();
        }
    }

    public final boolean hasPrevious() {
        return this.zzb().hasPrevious();
    }

    public final int nextIndex() {
        return this.zzb().nextIndex();
    }

    public final Object previous() {
        return this.zzb().previous();
    }

    public final int previousIndex() {
        return this.zzb().previousIndex();
    }

    public final void set(Object object) {
        this.zzb().set(object);
    }
}

