/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzgl;
import com.google.android.gms.internal.mlkit_vision_common.zzgm;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzgo
implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzgm zzc;

    private zzgo(zzgm zzgm2) {
        int n10;
        this.zzc = zzgm2;
        this.zza = n10 = zzgm.zzb(zzgm2).size();
    }

    public /* synthetic */ zzgo(zzgm zzgm2, zzgl zzgl2) {
        this(zzgm2);
    }

    private final Iterator zza() {
        Iterator iterator2 = this.zzb;
        if (iterator2 == null) {
            this.zzb = iterator2 = zzgm.zzd(this.zzc).entrySet().iterator();
        }
        return this.zzb;
    }

    public final boolean hasNext() {
        Iterator iterator2;
        List list;
        int n10;
        int n11 = this.zza;
        return n11 > 0 && n11 <= (n10 = (list = zzgm.zzb(this.zzc)).size()) || (n11 = (int)((iterator2 = this.zza()).hasNext() ? 1 : 0)) != 0;
    }

    public final /* synthetic */ Object next() {
        int n10;
        Object object = this.zza();
        boolean bl2 = object.hasNext();
        if (bl2) {
            return (Map.Entry)this.zza().next();
        }
        object = zzgm.zzb(this.zzc);
        this.zza = n10 = this.zza + -1;
        return (Map.Entry)object.get(n10);
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

