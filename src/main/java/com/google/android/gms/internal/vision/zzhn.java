/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zziu;
import com.google.android.gms.internal.vision.zzje;
import com.google.android.gms.internal.vision.zzjf;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzlq;
import com.google.android.gms.internal.vision.zzlt;
import java.util.List;
import java.util.Map;

public final class zzhn
implements zzlq {
    private final zzhl zztz;

    private zzhn(zzhl zzhl2) {
        this.zztz = zzhl2 = (zzhl)zzie.zza(zzhl2, "output");
        zzhl2.zzuo = this;
    }

    public static zzhn zza(zzhl zzhl2) {
        zzhn zzhn2 = zzhl2.zzuo;
        if (zzhn2 != null) {
            return zzhn2;
        }
        zzhn2 = new zzhn(zzhl2);
        return zzhn2;
    }

    public final void zza(int n10, double d10) {
        this.zztz.zza(n10, d10);
    }

    public final void zza(int n10, float f10) {
        this.zztz.zza(n10, f10);
    }

    public final void zza(int n10, long l10) {
        this.zztz.zza(n10, l10);
    }

    public final void zza(int n10, zzgs zzgs2) {
        this.zztz.zza(n10, zzgs2);
    }

    public final void zza(int n10, zzje zzje2, Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            this.zztz.writeTag(n10, 2);
            zzhl zzhl2 = this.zztz;
            Object k10 = entry.getKey();
            Object v10 = entry.getValue();
            int n11 = zzjf.zza(zzje2, k10, v10);
            zzhl2.zzbe(n11);
            zzhl2 = this.zztz;
            k10 = entry.getKey();
            entry = entry.getValue();
            zzjf.zza(zzhl2, zzje2, k10, entry);
        }
    }

    public final void zza(int n10, Object object) {
        boolean bl2 = object instanceof zzgs;
        if (bl2) {
            zzhl zzhl2 = this.zztz;
            object = (zzgs)object;
            zzhl2.zzb(n10, (zzgs)object);
            return;
        }
        zzhl zzhl3 = this.zztz;
        object = (zzjn)object;
        zzhl3.zza(n10, (zzjn)object);
    }

    public final void zza(int n10, Object object, zzkf zzkf2) {
        zzhl zzhl2 = this.zztz;
        object = (zzjn)object;
        zzhl2.zza(n10, (zzjn)object, zzkf2);
    }

    public final void zza(int n10, String string2) {
        this.zztz.zza(n10, string2);
    }

    public final void zza(int n10, List list) {
        int n11;
        int n12 = list instanceof zziu;
        if (n12 != 0) {
            int n13;
            List list2 = list;
            list2 = (zziu)list;
            for (n11 = 0; n11 < (n13 = list.size()); ++n11) {
                zzhl zzhl2;
                Object object = list2.zzbt(n11);
                boolean bl2 = object instanceof String;
                if (bl2) {
                    zzhl2 = this.zztz;
                    object = (String)object;
                    zzhl2.zza(n10, (String)object);
                    continue;
                }
                zzhl2 = this.zztz;
                object = (zzgs)object;
                zzhl2.zza(n10, (zzgs)object);
            }
            return;
        }
        while (n11 < (n12 = list.size())) {
            zzhl zzhl3 = this.zztz;
            String string2 = (String)list.get(n11);
            zzhl3.zza(n10, string2);
            ++n11;
        }
    }

    public final void zza(int n10, List list, zzkf zzkf2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zza(n10, e10, zzkf2);
        }
    }

    public final void zza(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzhl.zzbi(n14);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzhl2.zzbd(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzhl3.zzj(n10, n16);
        }
    }

    public final void zza(int n10, boolean bl2) {
        this.zztz.zza(n10, bl2);
    }

    public final void zzb(int n10, long l10) {
        this.zztz.zzb(n10, l10);
    }

    public final void zzb(int n10, Object object, zzkf zzkf2) {
        zzhl zzhl2 = this.zztz;
        object = (zzjn)object;
        zzhl2.writeTag(n10, 3);
        zzhn zzhn2 = zzhl2.zzuo;
        zzkf2.zza(object, zzhn2);
        zzhl2.writeTag(n10, 4);
    }

    public final void zzb(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            zzhl zzhl2 = this.zztz;
            zzgs zzgs2 = (zzgs)list.get(i10);
            zzhl2.zza(n10, zzgs2);
        }
    }

    public final void zzb(int n10, List list, zzkf zzkf2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zzb(n10, e10, zzkf2);
        }
    }

    public final void zzb(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzhl.zzbl(n14);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzhl2.zzbg(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzhl3.zzm(n10, n16);
        }
    }

    public final void zzbq(int n10) {
        this.zztz.writeTag(n10, 3);
    }

    public final void zzbr(int n10) {
        this.zztz.writeTag(n10, 4);
    }

    public final void zzc(int n10, long l10) {
        this.zztz.zzc(n10, l10);
    }

    public final void zzc(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzhl.zzv(l10);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzhl2.zzs(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzhl3.zza(n10, l13);
        }
    }

    public final void zzd(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzhl.zzw(l10);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzhl2.zzs(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzhl3.zza(n10, l13);
        }
    }

    public final void zze(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzhl.zzy(l10);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzhl2.zzu(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzhl3.zzc(n10, l13);
        }
    }

    public final void zzf(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zztz;
            int n13 = 2;
            float f10 = 2.8E-45f;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            float f11 = 0.0f;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Float f12 = (Float)list.get(n10);
                f10 = f12.floatValue();
                n13 = zzhl.zzt(f10);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Float)list.get(n12);
                f11 = ((Float)object).floatValue();
                zzhl2.zzs(f11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Float f13 = (Float)list.get(n12);
            float f14 = f13.floatValue();
            zzhl3.zza(n10, f14);
        }
    }

    public final void zzg(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            double d10;
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Double d11 = (Double)list.get(n10);
                d10 = d11;
                n13 = zzhl.zzb(d10);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Double)list.get(n12);
                d10 = (Double)object;
                zzhl2.zza(d10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Double d12 = (Double)list.get(n12);
            double d13 = d12;
            zzhl3.zza(n10, d13);
        }
    }

    public final int zzgd() {
        return zzlt.zzaex;
    }

    public final void zzh(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzhl.zzbn(n14);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzhl2.zzbd(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzhl3.zzj(n10, n16);
        }
    }

    public final void zzi(int n10, long l10) {
        this.zztz.zza(n10, l10);
    }

    /*
     * WARNING - void declaration
     */
    public final void zzi(int n10, List list, boolean n11) {
        int n12;
        int n13;
        if (n11 != 0) {
            void var3_5;
            Object object = this.zztz;
            int n14 = 2;
            ((zzhl)object).writeTag(n10, n14);
            zzhl zzhl2 = null;
            boolean bl2 = false;
            object = null;
            for (n10 = 0; n10 < (n14 = list.size()); ++n10) {
                Boolean bl3 = (Boolean)list.get(n10);
                n14 = zzhl.zzl(bl3);
                var3_5 += n14;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe((int)var3_5);
            while (n13 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Boolean)list.get(n13);
                boolean bl4 = (Boolean)object;
                zzhl2.zzk(bl4);
                ++n13;
            }
            return;
        }
        for (n13 = 0; n13 < (n12 = list.size()); ++n13) {
            zzhl zzhl3 = this.zztz;
            Boolean bl5 = (Boolean)list.get(n13);
            boolean bl6 = bl5;
            zzhl3.zza(n10, bl6);
        }
    }

    public final void zzj(int n10, int n11) {
        this.zztz.zzj(n10, n11);
    }

    public final void zzj(int n10, long l10) {
        this.zztz.zzc(n10, l10);
    }

    public final void zzj(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzhl.zzbj(n14);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzhl2.zzbe(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzhl3.zzk(n10, n16);
        }
    }

    public final void zzk(int n10, int n11) {
        this.zztz.zzk(n10, n11);
    }

    public final void zzk(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzhl.zzbm(n14);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzhl2.zzbg(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzhl3.zzm(n10, n16);
        }
    }

    public final void zzl(int n10, int n11) {
        this.zztz.zzl(n10, n11);
    }

    public final void zzl(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzhl.zzz(l10);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzhl2.zzu(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzhl3.zzc(n10, l13);
        }
    }

    public final void zzm(int n10, int n11) {
        this.zztz.zzm(n10, n11);
    }

    public final void zzm(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzhl.zzbk(n14);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzhl2.zzbf(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzhl3.zzl(n10, n16);
        }
    }

    public final void zzn(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zztz;
            int n13 = 2;
            ((zzhl)object).writeTag(n10, n13);
            zzhl zzhl2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzhl.zzx(l10);
                n11 += n13;
            }
            zzhl2 = this.zztz;
            zzhl2.zzbe(n11);
            while (n12 < (n10 = list.size())) {
                zzhl2 = this.zztz;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzhl2.zzt(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzhl zzhl3 = this.zztz;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzhl3.zzb(n10, l13);
        }
    }

    public final void zzt(int n10, int n11) {
        this.zztz.zzm(n10, n11);
    }

    public final void zzu(int n10, int n11) {
        this.zztz.zzj(n10, n11);
    }
}

