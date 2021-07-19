/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzif;
import com.google.android.gms.internal.mlkit_vision_face.zzig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzio
implements Iterator {
    private int zza = -1;
    private boolean zzb;
    private Iterator zzc;
    private final /* synthetic */ zzig zzd;

    private zzio(zzig zzig2) {
        this.zzd = zzig2;
    }

    public /* synthetic */ zzio(zzig zzig2, zzif zzif2) {
        this(zzig2);
    }

    private final Iterator zza() {
        Iterator iterator2 = this.zzc;
        if (iterator2 == null) {
            this.zzc = iterator2 = zzig.zzc(this.zzd).entrySet().iterator();
        }
        return this.zzc;
    }

    public final boolean hasNext() {
        Object object;
        int n10 = this.zza;
        int n11 = 1;
        List list = zzig.zzb(this.zzd);
        int n12 = list.size();
        if ((n10 += n11) >= n12 && ((n10 = (int)((object = zzig.zzc(this.zzd)).isEmpty() ? 1 : 0)) != 0 || (n10 = (int)((object = this.zza()).hasNext() ? 1 : 0)) == 0)) {
            return false;
        }
        return n11 != 0;
    }

    public final /* synthetic */ Object next() {
        int n10;
        int n11 = 1;
        this.zzb = n11;
        this.zza = n10 = this.zza + n11;
        List list = zzig.zzb(this.zzd);
        n11 = list.size();
        if (n10 < n11) {
            list = zzig.zzb(this.zzd);
            n10 = this.zza;
            return (Map.Entry)list.get(n10);
        }
        return (Map.Entry)this.zza().next();
    }

    public final void remove() {
        int n10 = this.zzb;
        if (n10 != 0) {
            this.zzb = false;
            zzig zzig2 = this.zzd;
            zzig.zza(zzig2);
            n10 = this.zza;
            List list = zzig.zzb(this.zzd);
            int n11 = list.size();
            if (n10 < n11) {
                int n12;
                zzig2 = this.zzd;
                n11 = this.zza;
                this.zza = n12 = n11 + -1;
                zzig.zza(zzig2, n11);
                return;
            }
            this.zza().remove();
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        throw illegalStateException;
    }
}

