/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzkg;
import com.google.android.gms.internal.vision.zzkj;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzki
implements Iterator {
    private int pos;
    private Iterator zzabu;
    private final /* synthetic */ zzkg zzabv;

    private zzki(zzkg zzkg2) {
        int n10;
        this.zzabv = zzkg2;
        this.pos = n10 = zzkg.zzb(zzkg2).size();
    }

    public /* synthetic */ zzki(zzkg zzkg2, zzkj zzkj2) {
        this(zzkg2);
    }

    private final Iterator zzix() {
        Iterator iterator2 = this.zzabu;
        if (iterator2 == null) {
            this.zzabu = iterator2 = zzkg.zzd(this.zzabv).entrySet().iterator();
        }
        return this.zzabu;
    }

    public final boolean hasNext() {
        Iterator iterator2;
        List list;
        int n10;
        int n11 = this.pos;
        return n11 > 0 && n11 <= (n10 = (list = zzkg.zzb(this.zzabv)).size()) || (n11 = (int)((iterator2 = this.zzix()).hasNext() ? 1 : 0)) != 0;
    }

    public final /* synthetic */ Object next() {
        int n10;
        Object object = this.zzix();
        boolean bl2 = object.hasNext();
        if (bl2) {
            return (Map.Entry)this.zzix().next();
        }
        object = zzkg.zzb(this.zzabv);
        this.pos = n10 = this.pos + -1;
        return (Map.Entry)object.get(n10);
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

