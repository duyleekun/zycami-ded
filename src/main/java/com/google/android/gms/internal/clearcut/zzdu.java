/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzax;
import com.google.android.gms.internal.clearcut.zzay;
import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbu;
import com.google.android.gms.internal.clearcut.zzby;
import com.google.android.gms.internal.clearcut.zzca;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzco;
import com.google.android.gms.internal.clearcut.zzct;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzef;
import com.google.android.gms.internal.clearcut.zzeh;
import com.google.android.gms.internal.clearcut.zzex;
import com.google.android.gms.internal.clearcut.zzey;
import com.google.android.gms.internal.clearcut.zzfq;
import com.google.android.gms.internal.clearcut.zzfr;
import java.util.Map;

public final class zzdu
implements zzef {
    private final zzdo zzmn;
    private final boolean zzmo;
    private final zzex zzmx;
    private final zzbu zzmy;

    private zzdu(zzex zzex2, zzbu zzbu2, zzdo zzdo2) {
        boolean bl2;
        this.zzmx = zzex2;
        this.zzmo = bl2 = zzbu2.zze(zzdo2);
        this.zzmy = zzbu2;
        this.zzmn = zzdo2;
    }

    public static zzdu zza(zzex zzex2, zzbu zzbu2, zzdo zzdo2) {
        zzdu zzdu2 = new zzdu(zzex2, zzbu2, zzdo2);
        return zzdu2;
    }

    public final boolean equals(Object object, Object object2) {
        Object object3;
        Object object4 = this.zzmx.zzq(object);
        boolean bl2 = object4.equals(object3 = this.zzmx.zzq(object2));
        if (!bl2) {
            return false;
        }
        bl2 = this.zzmo;
        if (bl2) {
            object = this.zzmy.zza(object);
            object2 = this.zzmy.zza(object2);
            return ((zzby)object).equals(object2);
        }
        return true;
    }

    public final int hashCode(Object object) {
        Object object2 = this.zzmx.zzq(object);
        int n10 = object2.hashCode();
        boolean bl2 = this.zzmo;
        if (bl2) {
            zzbu zzbu2 = this.zzmy;
            object = zzbu2.zza(object);
            n10 *= 53;
            int n11 = ((zzby)object).hashCode();
            n10 += n11;
        }
        return n10;
    }

    public final Object newInstance() {
        return this.zzmn.zzbd().zzbi();
    }

    public final void zza(Object object, zzfr zzfr2) {
        boolean bl2;
        Object object2 = this.zzmy.zza(object).iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            zzfq zzfq2;
            Object object3 = (Map.Entry)object2.next();
            zzca zzca2 = (zzca)object3.getKey();
            zzfq zzfq3 = zzca2.zzav();
            if (zzfq3 == (zzfq2 = zzfq.zzrf) && !(bl3 = zzca2.zzaw()) && !(bl3 = zzca2.zzax())) {
                bl3 = object3 instanceof zzct;
                int n10 = zzca2.zzc();
                object3 = bl3 ? ((zzct)object3).zzbs().zzr() : object3.getValue();
                zzfr2.zza(n10, object3);
                continue;
            }
            object = new IllegalStateException("Found invalid MessageSet item.");
            throw object;
        }
        object2 = this.zzmx;
        object = ((zzex)object2).zzq(object);
        ((zzex)object2).zzc(object, zzfr2);
    }

    public final void zza(Object object, byte[] byArray, int n10, int n11, zzay zzay2) {
        object = (zzcg)object;
        Object object2 = ((zzcg)object).zzjp;
        Object object3 = zzey.zzea();
        if (object2 == object3) {
            object2 = zzey.zzeb();
            ((zzcg)object).zzjp = object2;
        }
        object = object2;
        while (n10 < n11) {
            int n12;
            int n13 = zzax.zza(byArray, n10, zzay2);
            int n14 = zzay2.zzfd;
            n10 = 11;
            int n15 = 2;
            if (n14 != n10) {
                n10 = n14 & 7;
                if (n10 == n15) {
                    object3 = byArray;
                    n12 = n11;
                    n10 = zzax.zza(n14, byArray, n13, n11, (zzey)object, zzay2);
                    continue;
                }
                n10 = zzax.zza(n14, byArray, n13, n11, zzay2);
                continue;
            }
            n10 = 0;
            n14 = 0;
            object2 = null;
            while (n13 < n11) {
                n13 = zzax.zza(byArray, n13, zzay2);
                n12 = zzay2.zzfd;
                int n16 = n12 >>> 3;
                int n17 = n12 & 7;
                if (n16 != n15) {
                    int n18 = 3;
                    if (n16 == n18 && n17 == n15) {
                        n13 = zzax.zze(byArray, n13, zzay2);
                        object2 = (zzbb)zzay2.zzff;
                        continue;
                    }
                } else if (n17 == 0) {
                    n13 = zzax.zza(byArray, n13, zzay2);
                    n10 = zzay2.zzfd;
                    continue;
                }
                if (n12 == (n16 = 12)) break;
                n13 = zzax.zza(n12, byArray, n13, n11, zzay2);
            }
            if (object2 != null) {
                n10 = n10 << 3 | n15;
                ((zzey)object).zzb(n10, object2);
            }
            n10 = n13;
        }
        if (n10 == n11) {
            return;
        }
        throw zzco.zzbo();
    }

    public final void zzc(Object object) {
        this.zzmx.zzc(object);
        this.zzmy.zzc(object);
    }

    public final void zzc(Object object, Object object2) {
        Object object3 = this.zzmx;
        zzeh.zza((zzex)object3, object, object2);
        boolean bl2 = this.zzmo;
        if (bl2) {
            object3 = this.zzmy;
            zzeh.zza((zzbu)object3, object, object2);
        }
    }

    public final int zzm(Object object) {
        zzex zzex2 = this.zzmx;
        Object object2 = zzex2.zzq(object);
        int n10 = zzex2.zzr(object2) + 0;
        boolean bl2 = this.zzmo;
        if (bl2) {
            object2 = this.zzmy;
            object = ((zzbu)object2).zza(object);
            int n11 = ((zzby)object).zzat();
            n10 += n11;
        }
        return n10;
    }

    public final boolean zzo(Object object) {
        return this.zzmy.zza(object).isInitialized();
    }
}

