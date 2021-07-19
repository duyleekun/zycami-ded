/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjl;
import com.google.android.gms.internal.measurement.zzjs;
import java.util.Iterator;
import java.util.List;

public final class zzjq
implements Iterator {
    public final /* synthetic */ zzjs zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzjq(zzjs zzjs2, zzjl zzjl2) {
        this.zza = zzjs2;
    }

    private final Iterator zza() {
        Iterator iterator2 = this.zzd;
        if (iterator2 == null) {
            this.zzd = iterator2 = zzjs.zzi(this.zza).entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        int n10 = this.zzb;
        int n11 = 1;
        List list = zzjs.zzh(this.zza);
        int n12 = list.size();
        if ((n10 += n11) >= n12) {
            Object object = zzjs.zzi(this.zza);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.zza();
                n10 = (int)(object.hasNext() ? 1 : 0);
                if (n10 == 0) {
                    return false;
                }
            } else {
                n11 = 0;
            }
        }
        return n11 != 0;
    }

    public final void remove() {
        int n10 = this.zzc;
        if (n10 != 0) {
            this.zzc = false;
            zzjs zzjs2 = this.zza;
            zzjs.zzg(zzjs2);
            n10 = this.zzb;
            List list = zzjs.zzh(this.zza);
            int n11 = list.size();
            if (n10 < n11) {
                int n12;
                zzjs2 = this.zza;
                n11 = this.zzb;
                this.zzb = n12 = n11 + -1;
                zzjs.zzj(zzjs2, n11);
                return;
            }
            this.zza().remove();
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        throw illegalStateException;
    }
}

