/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzei;
import com.google.android.gms.internal.clearcut.zzej;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzek
implements Iterator {
    private int pos;
    private Iterator zzor;
    private final /* synthetic */ zzei zzos;

    private zzek(zzei zzei2) {
        int n10;
        this.zzos = zzei2;
        this.pos = n10 = zzei.zzb(zzei2).size();
    }

    public /* synthetic */ zzek(zzei zzei2, zzej zzej2) {
        this(zzei2);
    }

    private final Iterator zzdw() {
        Iterator iterator2 = this.zzor;
        if (iterator2 == null) {
            this.zzor = iterator2 = zzei.zzd(this.zzos).entrySet().iterator();
        }
        return this.zzor;
    }

    public final boolean hasNext() {
        Iterator iterator2;
        List list;
        int n10;
        int n11 = this.pos;
        return n11 > 0 && n11 <= (n10 = (list = zzei.zzb(this.zzos)).size()) || (n11 = (int)((iterator2 = this.zzdw()).hasNext() ? 1 : 0)) != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ Object next() {
        int n10;
        Object object = this.zzdw();
        boolean bl2 = object.hasNext();
        if (bl2) {
            object = this.zzdw().next();
            return (Map.Entry)object;
        }
        object = zzei.zzb(this.zzos);
        this.pos = n10 = this.pos + -1;
        object = object.get(n10);
        return (Map.Entry)object;
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

