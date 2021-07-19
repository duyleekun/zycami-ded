/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzif;
import com.google.android.gms.internal.mlkit_vision_face.zzig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzii
implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzig zzc;

    private zzii(zzig zzig2) {
        int n10;
        this.zzc = zzig2;
        this.zza = n10 = zzig.zzb(zzig2).size();
    }

    public /* synthetic */ zzii(zzig zzig2, zzif zzif2) {
        this(zzig2);
    }

    private final Iterator zza() {
        Iterator iterator2 = this.zzb;
        if (iterator2 == null) {
            this.zzb = iterator2 = zzig.zzd(this.zzc).entrySet().iterator();
        }
        return this.zzb;
    }

    public final boolean hasNext() {
        Iterator iterator2;
        List list;
        int n10;
        int n11 = this.zza;
        return n11 > 0 && n11 <= (n10 = (list = zzig.zzb(this.zzc)).size()) || (n11 = (int)((iterator2 = this.zza()).hasNext() ? 1 : 0)) != 0;
    }

    public final /* synthetic */ Object next() {
        int n10;
        Object object = this.zza();
        boolean bl2 = object.hasNext();
        if (bl2) {
            return (Map.Entry)this.zza().next();
        }
        object = zzig.zzb(this.zzc);
        this.zza = n10 = this.zza + -1;
        return (Map.Entry)object.get(n10);
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

