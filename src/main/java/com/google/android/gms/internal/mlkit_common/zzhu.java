/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzhs;
import com.google.android.gms.internal.mlkit_common.zzhv;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzhu
implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzhs zzc;

    private zzhu(zzhs zzhs2) {
        int n10;
        this.zzc = zzhs2;
        this.zza = n10 = zzhs.zzb(zzhs2).size();
    }

    public /* synthetic */ zzhu(zzhs zzhs2, zzhv zzhv2) {
        this(zzhs2);
    }

    private final Iterator zza() {
        Iterator iterator2 = this.zzb;
        if (iterator2 == null) {
            this.zzb = iterator2 = zzhs.zzd(this.zzc).entrySet().iterator();
        }
        return this.zzb;
    }

    public final boolean hasNext() {
        Iterator iterator2;
        List list;
        int n10;
        int n11 = this.zza;
        return n11 > 0 && n11 <= (n10 = (list = zzhs.zzb(this.zzc)).size()) || (n11 = (int)((iterator2 = this.zza()).hasNext() ? 1 : 0)) != 0;
    }

    public final /* synthetic */ Object next() {
        int n10;
        Object object = this.zza();
        boolean bl2 = object.hasNext();
        if (bl2) {
            return (Map.Entry)this.zza().next();
        }
        object = zzhs.zzb(this.zzc);
        this.zza = n10 = this.zza + -1;
        return (Map.Entry)object.get(n10);
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

