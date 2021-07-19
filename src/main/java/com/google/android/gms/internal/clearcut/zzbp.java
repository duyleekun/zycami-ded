/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzcg$zzg;
import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcx;
import com.google.android.gms.internal.clearcut.zzdg;
import com.google.android.gms.internal.clearcut.zzdh;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzef;
import com.google.android.gms.internal.clearcut.zzfr;
import java.util.List;
import java.util.Map;

public final class zzbp
implements zzfr {
    private final zzbn zzfo;

    private zzbp(zzbn zzbn2) {
        this.zzfo = zzbn2 = (zzbn)zzci.zza((Object)zzbn2, "output");
        zzbn2.zzfz = this;
    }

    public static zzbp zza(zzbn zzbn2) {
        zzbp zzbp2 = zzbn2.zzfz;
        if (zzbp2 != null) {
            return zzbp2;
        }
        zzbp2 = new zzbp(zzbn2);
        return zzbp2;
    }

    public final void zza(int n10, double d10) {
        this.zzfo.zza(n10, d10);
    }

    public final void zza(int n10, float f10) {
        this.zzfo.zza(n10, f10);
    }

    public final void zza(int n10, long l10) {
        this.zzfo.zza(n10, l10);
    }

    public final void zza(int n10, zzbb zzbb2) {
        this.zzfo.zza(n10, zzbb2);
    }

    public final void zza(int n10, zzdh zzdh2, Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            this.zzfo.zzb(n10, 2);
            zzbn zzbn2 = this.zzfo;
            Object k10 = entry.getKey();
            Object v10 = entry.getValue();
            int n11 = zzdg.zza(zzdh2, k10, v10);
            zzbn2.zzo(n11);
            zzbn2 = this.zzfo;
            k10 = entry.getKey();
            entry = entry.getValue();
            zzdg.zza(zzbn2, zzdh2, k10, entry);
        }
    }

    public final void zza(int n10, Object object) {
        boolean bl2 = object instanceof zzbb;
        if (bl2) {
            zzbn zzbn2 = this.zzfo;
            object = (zzbb)object;
            zzbn2.zzb(n10, (zzbb)object);
            return;
        }
        zzbn zzbn3 = this.zzfo;
        object = (zzdo)object;
        zzbn3.zzb(n10, (zzdo)object);
    }

    public final void zza(int n10, Object object, zzef zzef2) {
        zzbn zzbn2 = this.zzfo;
        object = (zzdo)object;
        zzbn2.zza(n10, (zzdo)object, zzef2);
    }

    public final void zza(int n10, String string2) {
        this.zzfo.zza(n10, string2);
    }

    public final void zza(int n10, List list) {
        int n11;
        int n12 = list instanceof zzcx;
        if (n12 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzcx)list;
            for (n11 = 0; n11 < (n13 = list.size()); ++n11) {
                zzbn zzbn2;
                Object object = list2.getRaw(n11);
                boolean bl2 = object instanceof String;
                if (bl2) {
                    zzbn2 = this.zzfo;
                    object = (String)object;
                    zzbn2.zza(n10, (String)object);
                    continue;
                }
                zzbn2 = this.zzfo;
                object = (zzbb)object;
                zzbn2.zza(n10, (zzbb)object);
            }
            return;
        }
        while (n11 < (n12 = list.size())) {
            zzbn zzbn3 = this.zzfo;
            String string2 = (String)list.get(n11);
            zzbn3.zza(n10, string2);
            ++n11;
        }
    }

    public final void zza(int n10, List list, zzef zzef2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zza(n10, e10, zzef2);
        }
    }

    public final void zza(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzbn.zzs(n14);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzbn2.zzn(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzbn3.zzc(n10, n16);
        }
    }

    public final void zzaa(int n10) {
        this.zzfo.zzb(n10, 3);
    }

    public final void zzab(int n10) {
        this.zzfo.zzb(n10, 4);
    }

    public final int zzaj() {
        return zzcg$zzg.zzko;
    }

    public final void zzb(int n10, long l10) {
        this.zzfo.zzb(n10, l10);
    }

    public final void zzb(int n10, Object object, zzef zzef2) {
        zzbn zzbn2 = this.zzfo;
        object = (zzdo)object;
        zzbn2.zzb(n10, 3);
        zzbp zzbp2 = zzbn2.zzfz;
        zzef2.zza(object, zzbp2);
        zzbn2.zzb(n10, 4);
    }

    public final void zzb(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            zzbn zzbn2 = this.zzfo;
            zzbb zzbb2 = (zzbb)list.get(i10);
            zzbn2.zza(n10, zzbb2);
        }
    }

    public final void zzb(int n10, List list, zzef zzef2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zzb(n10, e10, zzef2);
        }
    }

    public final void zzb(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzbn.zzv(n14);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzbn2.zzq(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzbn3.zzf(n10, n16);
        }
    }

    public final void zzb(int n10, boolean bl2) {
        this.zzfo.zzb(n10, bl2);
    }

    public final void zzc(int n10, int n11) {
        this.zzfo.zzc(n10, n11);
    }

    public final void zzc(int n10, long l10) {
        this.zzfo.zzc(n10, l10);
    }

    public final void zzc(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzbn.zze(l10);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzbn2.zzb(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzbn3.zza(n10, l13);
        }
    }

    public final void zzd(int n10, int n11) {
        this.zzfo.zzd(n10, n11);
    }

    public final void zzd(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzbn.zzf(l10);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzbn2.zzb(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzbn3.zza(n10, l13);
        }
    }

    public final void zze(int n10, int n11) {
        this.zzfo.zze(n10, n11);
    }

    public final void zze(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzbn.zzh(l10);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzbn2.zzd(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzbn3.zzc(n10, l13);
        }
    }

    public final void zzf(int n10, int n11) {
        this.zzfo.zzf(n10, n11);
    }

    public final void zzf(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zzfo;
            int n13 = 2;
            float f10 = 2.8E-45f;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            float f11 = 0.0f;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Float f12 = (Float)list.get(n10);
                f10 = f12.floatValue();
                n13 = zzbn.zzb(f10);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Float)list.get(n12);
                f11 = ((Float)object).floatValue();
                zzbn2.zza(f11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Float f13 = (Float)list.get(n12);
            float f14 = f13.floatValue();
            zzbn3.zza(n10, f14);
        }
    }

    public final void zzg(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            double d10;
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Double d11 = (Double)list.get(n10);
                d10 = d11;
                n13 = zzbn.zzb(d10);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Double)list.get(n12);
                d10 = (Double)object;
                zzbn2.zza(d10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Double d12 = (Double)list.get(n12);
            double d13 = d12;
            zzbn3.zza(n10, d13);
        }
    }

    public final void zzh(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzbn.zzx(n14);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzbn2.zzn(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzbn3.zzc(n10, n16);
        }
    }

    public final void zzi(int n10, long l10) {
        this.zzfo.zza(n10, l10);
    }

    /*
     * WARNING - void declaration
     */
    public final void zzi(int n10, List list, boolean n11) {
        int n12;
        int n13;
        if (n11 != 0) {
            void var3_5;
            Object object = this.zzfo;
            int n14 = 2;
            ((zzbn)object).zzb(n10, n14);
            zzbn zzbn2 = null;
            boolean bl2 = false;
            object = null;
            for (n10 = 0; n10 < (n14 = list.size()); ++n10) {
                Boolean bl3 = (Boolean)list.get(n10);
                n14 = zzbn.zzb(bl3);
                var3_5 += n14;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo((int)var3_5);
            while (n13 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Boolean)list.get(n13);
                boolean bl4 = (Boolean)object;
                zzbn2.zza(bl4);
                ++n13;
            }
            return;
        }
        for (n13 = 0; n13 < (n12 = list.size()); ++n13) {
            zzbn zzbn3 = this.zzfo;
            Boolean bl5 = (Boolean)list.get(n13);
            boolean bl6 = bl5;
            zzbn3.zzb(n10, bl6);
        }
    }

    public final void zzj(int n10, long l10) {
        this.zzfo.zzc(n10, l10);
    }

    public final void zzj(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzbn.zzt(n14);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzbn2.zzo(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzbn3.zzd(n10, n16);
        }
    }

    public final void zzk(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzbn.zzw(n14);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzbn2.zzq(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzbn3.zzf(n10, n16);
        }
    }

    public final void zzl(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzbn.zzi(l10);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzbn2.zzd(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzbn3.zzc(n10, l13);
        }
    }

    public final void zzm(int n10, int n11) {
        this.zzfo.zzf(n10, n11);
    }

    public final void zzm(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzbn.zzu(n14);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzbn2.zzp(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzbn3.zze(n10, n16);
        }
    }

    public final void zzn(int n10, int n11) {
        this.zzfo.zzc(n10, n11);
    }

    public final void zzn(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zzfo;
            int n13 = 2;
            ((zzbn)object).zzb(n10, n13);
            zzbn zzbn2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzbn.zzg(l10);
                n11 += n13;
            }
            zzbn2 = this.zzfo;
            zzbn2.zzo(n11);
            while (n12 < (n10 = list.size())) {
                zzbn2 = this.zzfo;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzbn2.zzc(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzbn zzbn3 = this.zzfo;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzbn3.zzb(n10, l13);
        }
    }
}

