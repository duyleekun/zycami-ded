/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzgl;
import com.google.android.gms.internal.mlkit_vision_common.zzgm;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzgu
implements Iterator {
    private int zza = -1;
    private boolean zzb;
    private Iterator zzc;
    private final /* synthetic */ zzgm zzd;

    private zzgu(zzgm zzgm2) {
        this.zzd = zzgm2;
    }

    public /* synthetic */ zzgu(zzgm zzgm2, zzgl zzgl2) {
        this(zzgm2);
    }

    private final Iterator zza() {
        Iterator iterator2 = this.zzc;
        if (iterator2 == null) {
            this.zzc = iterator2 = zzgm.zzc(this.zzd).entrySet().iterator();
        }
        return this.zzc;
    }

    public final boolean hasNext() {
        Object object;
        int n10 = this.zza;
        int n11 = 1;
        List list = zzgm.zzb(this.zzd);
        int n12 = list.size();
        if ((n10 += n11) >= n12 && ((n10 = (int)((object = zzgm.zzc(this.zzd)).isEmpty() ? 1 : 0)) != 0 || (n10 = (int)((object = this.zza()).hasNext() ? 1 : 0)) == 0)) {
            return false;
        }
        return n11 != 0;
    }

    public final /* synthetic */ Object next() {
        int n10;
        int n11 = 1;
        this.zzb = n11;
        this.zza = n10 = this.zza + n11;
        List list = zzgm.zzb(this.zzd);
        n11 = list.size();
        if (n10 < n11) {
            list = zzgm.zzb(this.zzd);
            n10 = this.zza;
            return (Map.Entry)list.get(n10);
        }
        return (Map.Entry)this.zza().next();
    }

    public final void remove() {
        int n10 = this.zzb;
        if (n10 != 0) {
            this.zzb = false;
            zzgm zzgm2 = this.zzd;
            zzgm.zza(zzgm2);
            n10 = this.zza;
            List list = zzgm.zzb(this.zzd);
            int n11 = list.size();
            if (n10 < n11) {
                int n12;
                zzgm2 = this.zzd;
                n11 = this.zza;
                this.zza = n12 = n11 + -1;
                zzgm.zza(zzgm2, n11);
                return;
            }
            this.zza().remove();
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        throw illegalStateException;
    }
}

