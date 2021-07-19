/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzkg;
import com.google.android.gms.internal.vision.zzkj;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzko
implements Iterator {
    private int pos = -1;
    private Iterator zzabu;
    private final /* synthetic */ zzkg zzabv;
    private boolean zzaby;

    private zzko(zzkg zzkg2) {
        this.zzabv = zzkg2;
    }

    public /* synthetic */ zzko(zzkg zzkg2, zzkj zzkj2) {
        this(zzkg2);
    }

    private final Iterator zzix() {
        Iterator iterator2 = this.zzabu;
        if (iterator2 == null) {
            this.zzabu = iterator2 = zzkg.zzc(this.zzabv).entrySet().iterator();
        }
        return this.zzabu;
    }

    public final boolean hasNext() {
        Object object;
        int n10 = this.pos;
        int n11 = 1;
        List list = zzkg.zzb(this.zzabv);
        int n12 = list.size();
        if ((n10 += n11) >= n12 && ((n10 = (int)((object = zzkg.zzc(this.zzabv)).isEmpty() ? 1 : 0)) != 0 || (n10 = (int)((object = this.zzix()).hasNext() ? 1 : 0)) == 0)) {
            return false;
        }
        return n11 != 0;
    }

    public final /* synthetic */ Object next() {
        int n10;
        int n11 = 1;
        this.zzaby = n11;
        this.pos = n10 = this.pos + n11;
        List list = zzkg.zzb(this.zzabv);
        n11 = list.size();
        if (n10 < n11) {
            list = zzkg.zzb(this.zzabv);
            n10 = this.pos;
            return (Map.Entry)list.get(n10);
        }
        return (Map.Entry)this.zzix().next();
    }

    public final void remove() {
        int n10 = this.zzaby;
        if (n10 != 0) {
            this.zzaby = false;
            zzkg zzkg2 = this.zzabv;
            zzkg.zza(zzkg2);
            n10 = this.pos;
            List list = zzkg.zzb(this.zzabv);
            int n11 = list.size();
            if (n10 < n11) {
                int n12;
                zzkg2 = this.zzabv;
                n11 = this.pos;
                this.pos = n12 = n11 + -1;
                zzkg.zza(zzkg2, n11);
                return;
            }
            this.zzix().remove();
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        throw illegalStateException;
    }
}

