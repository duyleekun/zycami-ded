/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfq;
import com.google.android.gms.internal.mlkit_vision_face.zzfv;
import com.google.android.gms.internal.mlkit_vision_face.zzgg;
import com.google.android.gms.internal.mlkit_vision_face.zzgw;
import com.google.android.gms.internal.mlkit_vision_face.zzhg;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzib;
import com.google.android.gms.internal.mlkit_vision_face.zzjh;
import com.google.android.gms.internal.mlkit_vision_face.zzjn;
import com.google.android.gms.internal.mlkit_vision_face.zzjq;
import java.util.List;
import java.util.Map;

public final class zzfs
implements zzjn {
    private final zzfq zza;

    private zzfs(zzfq zzfq2) {
        this.zza = zzfq2 = (zzfq)zzgg.zza((Object)zzfq2, "output");
        zzfq2.zza = this;
    }

    public static zzfs zza(zzfq zzfq2) {
        zzfs zzfs2 = zzfq2.zza;
        if (zzfs2 != null) {
            return zzfs2;
        }
        zzfs2 = new zzfs(zzfq2);
        return zzfs2;
    }

    public final int zza() {
        return zzjq.zza;
    }

    public final void zza(int n10) {
        this.zza.zza(n10, 3);
    }

    public final void zza(int n10, double d10) {
        this.zza.zza(n10, d10);
    }

    public final void zza(int n10, float f10) {
        this.zza.zza(n10, f10);
    }

    public final void zza(int n10, int n11) {
        this.zza.zze(n10, n11);
    }

    public final void zza(int n10, long l10) {
        this.zza.zza(n10, l10);
    }

    public final void zza(int n10, zzez zzez2) {
        this.zza.zza(n10, zzez2);
    }

    public final void zza(int n10, zzhg zzhg2, Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            zzfq zzfq2 = this.zza;
            int n11 = 2;
            zzfq2.zza(n10, n11);
            zzfq2 = this.zza;
            Object object2 = entry.getKey();
            Object object3 = entry.getValue();
            zzjh zzjh2 = zzhg2.zza;
            int n12 = 1;
            int n13 = zzfv.zza(zzjh2, n12, object2);
            zzjh2 = zzhg2.zzb;
            int n14 = zzfv.zza(zzjh2, n11, object3);
            zzfq2.zzb(n13 += n14);
            zzfq2 = this.zza;
            object2 = entry.getKey();
            entry = entry.getValue();
            object3 = zzhg2.zza;
            zzfv.zza(zzfq2, object3, n12, object2);
            object2 = zzhg2.zzb;
            zzfv.zza(zzfq2, object2, n11, entry);
        }
    }

    public final void zza(int n10, Object object) {
        boolean bl2 = object instanceof zzez;
        if (bl2) {
            zzfq zzfq2 = this.zza;
            object = (zzez)object;
            zzfq2.zzb(n10, (zzez)object);
            return;
        }
        zzfq zzfq3 = this.zza;
        object = (zzhl)object;
        zzfq3.zza(n10, (zzhl)object);
    }

    public final void zza(int n10, Object object, zzib zzib2) {
        zzfq zzfq2 = this.zza;
        object = (zzhl)object;
        zzfq2.zza(n10, (zzhl)object, zzib2);
    }

    public final void zza(int n10, String string2) {
        this.zza.zza(n10, string2);
    }

    public final void zza(int n10, List list) {
        int n11;
        int n12 = list instanceof zzgw;
        if (n12 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzgw)list;
            for (n11 = 0; n11 < (n13 = list.size()); ++n11) {
                zzfq zzfq2;
                Object object = list2.zza(n11);
                boolean bl2 = object instanceof String;
                if (bl2) {
                    zzfq2 = this.zza;
                    object = (String)object;
                    zzfq2.zza(n10, (String)object);
                    continue;
                }
                zzfq2 = this.zza;
                object = (zzez)object;
                zzfq2.zza(n10, (zzez)object);
            }
            return;
        }
        while (n11 < (n12 = list.size())) {
            zzfq zzfq3 = this.zza;
            String string2 = (String)list.get(n11);
            zzfq3.zza(n10, string2);
            ++n11;
        }
    }

    public final void zza(int n10, List list, zzib zzib2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zza(n10, e10, zzib2);
        }
    }

    public final void zza(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfq.zzf(n14);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfq2.zza(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfq3.zzb(n10, n16);
        }
    }

    public final void zza(int n10, boolean bl2) {
        this.zza.zza(n10, bl2);
    }

    public final void zzb(int n10) {
        this.zza.zza(n10, 4);
    }

    public final void zzb(int n10, int n11) {
        this.zza.zzb(n10, n11);
    }

    public final void zzb(int n10, long l10) {
        this.zza.zzc(n10, l10);
    }

    public final void zzb(int n10, Object object, zzib zzib2) {
        zzfq zzfq2 = this.zza;
        object = (zzhl)object;
        zzfq2.zza(n10, 3);
        zzfs zzfs2 = zzfq2.zza;
        zzib2.zza(object, zzfs2);
        zzfq2.zza(n10, 4);
    }

    public final void zzb(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            zzfq zzfq2 = this.zza;
            zzez zzez2 = (zzez)list.get(i10);
            zzfq2.zza(n10, zzez2);
        }
    }

    public final void zzb(int n10, List list, zzib zzib2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zzb(n10, e10, zzib2);
        }
    }

    public final void zzb(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfq.zzi(n14);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfq2.zzd(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfq3.zze(n10, n16);
        }
    }

    public final void zzc(int n10, int n11) {
        this.zza.zzb(n10, n11);
    }

    public final void zzc(int n10, long l10) {
        this.zza.zza(n10, l10);
    }

    public final void zzc(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfq.zzd(l10);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfq2.zza(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfq3.zza(n10, l13);
        }
    }

    public final void zzd(int n10, int n11) {
        this.zza.zze(n10, n11);
    }

    public final void zzd(int n10, long l10) {
        this.zza.zzc(n10, l10);
    }

    public final void zzd(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfq.zze(l10);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfq2.zza(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfq3.zza(n10, l13);
        }
    }

    public final void zze(int n10, int n11) {
        this.zza.zzc(n10, n11);
    }

    public final void zze(int n10, long l10) {
        this.zza.zzb(n10, l10);
    }

    public final void zze(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfq.zzg(l10);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfq2.zzc(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfq3.zzc(n10, l13);
        }
    }

    public final void zzf(int n10, int n11) {
        this.zza.zzd(n10, n11);
    }

    public final void zzf(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            float f10 = 2.8E-45f;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            float f11 = 0.0f;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Float f12 = (Float)list.get(n10);
                f10 = f12.floatValue();
                n13 = zzfq.zzb(f10);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Float)list.get(n12);
                f11 = ((Float)object).floatValue();
                zzfq2.zza(f11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Float f13 = (Float)list.get(n12);
            float f14 = f13.floatValue();
            zzfq3.zza(n10, f14);
        }
    }

    public final void zzg(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            double d10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Double d11 = (Double)list.get(n10);
                d10 = d11;
                n13 = zzfq.zzb(d10);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Double)list.get(n12);
                d10 = (Double)object;
                zzfq2.zza(d10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Double d12 = (Double)list.get(n12);
            double d13 = d12;
            zzfq3.zza(n10, d13);
        }
    }

    public final void zzh(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfq.zzk(n14);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfq2.zza(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfq3.zzb(n10, n16);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void zzi(int n10, List list, boolean n11) {
        int n12;
        int n13;
        if (n11 != 0) {
            void var3_5;
            Object object = this.zza;
            int n14 = 2;
            ((zzfq)object).zza(n10, n14);
            zzfq zzfq2 = null;
            boolean bl2 = false;
            object = null;
            for (n10 = 0; n10 < (n14 = list.size()); ++n10) {
                Boolean bl3 = (Boolean)list.get(n10);
                n14 = zzfq.zzb(bl3);
                var3_5 += n14;
            }
            zzfq2 = this.zza;
            zzfq2.zzb((int)var3_5);
            while (n13 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Boolean)list.get(n13);
                boolean bl4 = (Boolean)object;
                zzfq2.zza(bl4);
                ++n13;
            }
            return;
        }
        for (n13 = 0; n13 < (n12 = list.size()); ++n13) {
            zzfq zzfq3 = this.zza;
            Boolean bl5 = (Boolean)list.get(n13);
            boolean bl6 = bl5;
            zzfq3.zza(n10, bl6);
        }
    }

    public final void zzj(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfq.zzg(n14);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfq2.zzb(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfq3.zzc(n10, n16);
        }
    }

    public final void zzk(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfq.zzj(n14);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfq2.zzd(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfq3.zze(n10, n16);
        }
    }

    public final void zzl(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfq.zzh(l10);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfq2.zzc(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfq3.zzc(n10, l13);
        }
    }

    public final void zzm(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfq.zzh(n14);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfq2.zzc(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfq3.zzd(n10, n16);
        }
    }

    public final void zzn(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfq)object).zza(n10, n13);
            zzfq zzfq2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfq.zzf(l10);
                n11 += n13;
            }
            zzfq2 = this.zza;
            zzfq2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfq2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfq2.zzb(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfq zzfq3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfq3.zzb(n10, l13);
        }
    }
}

