/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzfu;
import com.google.android.gms.internal.mlkit_vision_face.zzfv;
import com.google.android.gms.internal.mlkit_vision_face.zzfx;
import com.google.android.gms.internal.mlkit_vision_face.zzgs;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzib;
import com.google.android.gms.internal.mlkit_vision_face.zzid;
import com.google.android.gms.internal.mlkit_vision_face.zzit;
import com.google.android.gms.internal.mlkit_vision_face.zzjn;
import com.google.android.gms.internal.mlkit_vision_face.zzjo;
import java.util.Map;

public final class zzhs
implements zzib {
    private final zzhl zza;
    private final zzit zzb;
    private final boolean zzc;
    private final zzfu zzd;

    private zzhs(zzit zzit2, zzfu zzfu2, zzhl zzhl2) {
        boolean bl2;
        this.zzb = zzit2;
        this.zzc = bl2 = zzfu2.zza(zzhl2);
        this.zzd = zzfu2;
        this.zza = zzhl2;
    }

    public static zzhs zza(zzit zzit2, zzfu zzfu2, zzhl zzhl2) {
        zzhs zzhs2 = new zzhs(zzit2, zzfu2, zzhl2);
        return zzhs2;
    }

    public final int zza(Object object) {
        Object object2 = this.zzb.zza(object);
        int n10 = object2.hashCode();
        boolean bl2 = this.zzc;
        if (bl2) {
            zzfu zzfu2 = this.zzd;
            object = zzfu2.zza(object);
            n10 *= 53;
            int n11 = ((zzfv)object).hashCode();
            n10 += n11;
        }
        return n10;
    }

    public final void zza(Object object, zzjn zzjn2) {
        boolean bl2;
        Object object2 = this.zzd.zza(object).zzd();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            zzjo zzjo2;
            Object object3 = (Map.Entry)object2.next();
            zzfx zzfx2 = (zzfx)object3.getKey();
            zzjo zzjo3 = zzfx2.zzc();
            if (zzjo3 == (zzjo2 = zzjo.zzi) && !(bl3 = zzfx2.zzd()) && !(bl3 = zzfx2.zze())) {
                int n10;
                bl3 = object3 instanceof zzgs;
                if (bl3) {
                    n10 = zzfx2.zza();
                    object3 = ((zzgs)object3).zza().zzc();
                    zzjn2.zza(n10, object3);
                    continue;
                }
                n10 = zzfx2.zza();
                object3 = object3.getValue();
                zzjn2.zza(n10, object3);
                continue;
            }
            object = new IllegalStateException("Found invalid MessageSet item.");
            throw object;
        }
        object2 = this.zzb;
        object = ((zzit)object2).zza(object);
        ((zzit)object2).zzb(object, zzjn2);
    }

    public final boolean zza(Object object, Object object2) {
        Object object3;
        Object object4 = this.zzb.zza(object);
        boolean bl2 = object4.equals(object3 = this.zzb.zza(object2));
        if (!bl2) {
            return false;
        }
        bl2 = this.zzc;
        if (bl2) {
            object = this.zzd.zza(object);
            object2 = this.zzd.zza(object2);
            return ((zzfv)object).equals(object2);
        }
        return true;
    }

    public final int zzb(Object object) {
        zzit zzit2 = this.zzb;
        Object object2 = zzit2.zza(object);
        int n10 = zzit2.zzc(object2) + 0;
        boolean bl2 = this.zzc;
        if (bl2) {
            object2 = this.zzd;
            object = ((zzfu)object2).zza(object);
            int n11 = ((zzfv)object).zzg();
            n10 += n11;
        }
        return n10;
    }

    public final void zzb(Object object, Object object2) {
        Object object3 = this.zzb;
        zzid.zza((zzit)object3, object, object2);
        boolean bl2 = this.zzc;
        if (bl2) {
            object3 = this.zzd;
            zzid.zza((zzfu)object3, object, object2);
        }
    }

    public final void zzc(Object object) {
        this.zzb.zzb(object);
        this.zzd.zzc(object);
    }

    public final boolean zzd(Object object) {
        return this.zzd.zza(object).zzf();
    }
}

