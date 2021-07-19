/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzei;
import com.google.android.gms.internal.clearcut.zzej;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzeq
implements Iterator {
    private int pos = -1;
    private Iterator zzor;
    private final /* synthetic */ zzei zzos;
    private boolean zzow;

    private zzeq(zzei zzei2) {
        this.zzos = zzei2;
    }

    public /* synthetic */ zzeq(zzei zzei2, zzej zzej2) {
        this(zzei2);
    }

    private final Iterator zzdw() {
        Iterator iterator2 = this.zzor;
        if (iterator2 == null) {
            this.zzor = iterator2 = zzei.zzc(this.zzos).entrySet().iterator();
        }
        return this.zzor;
    }

    public final boolean hasNext() {
        Object object;
        int n10 = this.pos;
        int n11 = 1;
        List list = zzei.zzb(this.zzos);
        int n12 = list.size();
        if ((n10 += n11) >= n12 && ((n10 = (int)((object = zzei.zzc(this.zzos)).isEmpty() ? 1 : 0)) != 0 || (n10 = (int)((object = this.zzdw()).hasNext() ? 1 : 0)) == 0)) {
            return false;
        }
        return n11 != 0;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ Object next() {
        void var3_6;
        int n10;
        int n11 = 1;
        this.zzow = n11;
        this.pos = n10 = this.pos + n11;
        List list = zzei.zzb(this.zzos);
        n11 = list.size();
        if (n10 < n11) {
            List list2 = zzei.zzb(this.zzos);
            n10 = this.pos;
            Object e10 = list2.get(n10);
            return (Map.Entry)var3_6;
        }
        Object e11 = this.zzdw().next();
        return (Map.Entry)var3_6;
    }

    public final void remove() {
        int n10 = this.zzow;
        if (n10 != 0) {
            this.zzow = false;
            zzei zzei2 = this.zzos;
            zzei.zza(zzei2);
            n10 = this.pos;
            List list = zzei.zzb(this.zzos);
            int n11 = list.size();
            if (n10 < n11) {
                int n12;
                zzei2 = this.zzos;
                n11 = this.pos;
                this.pos = n12 = n11 + -1;
                zzei.zza(zzei2, n11);
                return;
            }
            this.zzdw().remove();
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        throw illegalStateException;
    }
}

