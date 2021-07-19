/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzfc;
import com.google.android.gms.internal.mlkit_common.zzfl;
import com.google.android.gms.internal.mlkit_common.zzfs;
import com.google.android.gms.internal.mlkit_common.zzgi;
import com.google.android.gms.internal.mlkit_common.zzgs;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhr;
import com.google.android.gms.internal.mlkit_common.zzix;
import com.google.android.gms.internal.mlkit_common.zzjc;
import com.google.android.gms.internal.mlkit_common.zzjd;
import java.util.List;
import java.util.Map;

public final class zzff
implements zzjd {
    private final zzfc zza;

    private zzff(zzfc zzfc2) {
        this.zza = zzfc2 = (zzfc)zzfs.zza((Object)zzfc2, "output");
        zzfc2.zza = this;
    }

    public static zzff zza(zzfc zzfc2) {
        zzff zzff2 = zzfc2.zza;
        if (zzff2 != null) {
            return zzff2;
        }
        zzff2 = new zzff(zzfc2);
        return zzff2;
    }

    public final int zza() {
        return zzjc.zza;
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

    public final void zza(int n10, zzep zzep2) {
        this.zza.zza(n10, zzep2);
    }

    public final void zza(int n10, zzgs zzgs2, Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            zzfc zzfc2 = this.zza;
            int n11 = 2;
            zzfc2.zza(n10, n11);
            zzfc2 = this.zza;
            Object object2 = entry.getKey();
            Object object3 = entry.getValue();
            zzix zzix2 = zzgs2.zza;
            int n12 = 1;
            int n13 = zzfl.zza(zzix2, n12, object2);
            zzix2 = zzgs2.zzb;
            int n14 = zzfl.zza(zzix2, n11, object3);
            zzfc2.zzb(n13 += n14);
            zzfc2 = this.zza;
            object2 = entry.getKey();
            entry = entry.getValue();
            object3 = zzgs2.zza;
            zzfl.zza(zzfc2, object3, n12, object2);
            object2 = zzgs2.zzb;
            zzfl.zza(zzfc2, object2, n11, entry);
        }
    }

    public final void zza(int n10, Object object) {
        boolean bl2 = object instanceof zzep;
        if (bl2) {
            zzfc zzfc2 = this.zza;
            object = (zzep)object;
            zzfc2.zzb(n10, (zzep)object);
            return;
        }
        zzfc zzfc3 = this.zza;
        object = (zzhb)object;
        zzfc3.zza(n10, (zzhb)object);
    }

    public final void zza(int n10, Object object, zzhr zzhr2) {
        zzfc zzfc2 = this.zza;
        object = (zzhb)object;
        zzfc2.zza(n10, (zzhb)object, zzhr2);
    }

    public final void zza(int n10, String string2) {
        this.zza.zza(n10, string2);
    }

    public final void zza(int n10, List list) {
        int n11;
        int n12 = list instanceof zzgi;
        if (n12 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzgi)list;
            for (n11 = 0; n11 < (n13 = list.size()); ++n11) {
                zzfc zzfc2;
                Object object = list2.zza(n11);
                boolean bl2 = object instanceof String;
                if (bl2) {
                    zzfc2 = this.zza;
                    object = (String)object;
                    zzfc2.zza(n10, (String)object);
                    continue;
                }
                zzfc2 = this.zza;
                object = (zzep)object;
                zzfc2.zza(n10, (zzep)object);
            }
            return;
        }
        while (n11 < (n12 = list.size())) {
            zzfc zzfc3 = this.zza;
            String string2 = (String)list.get(n11);
            zzfc3.zza(n10, string2);
            ++n11;
        }
    }

    public final void zza(int n10, List list, zzhr zzhr2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zza(n10, e10, zzhr2);
        }
    }

    public final void zza(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfc.zzf(n14);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfc2.zza(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfc3.zzb(n10, n16);
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

    public final void zzb(int n10, Object object, zzhr zzhr2) {
        zzfc zzfc2 = this.zza;
        object = (zzhb)object;
        zzfc2.zza(n10, 3);
        zzff zzff2 = zzfc2.zza;
        zzhr2.zza(object, zzff2);
        zzfc2.zza(n10, 4);
    }

    public final void zzb(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            zzfc zzfc2 = this.zza;
            zzep zzep2 = (zzep)list.get(i10);
            zzfc2.zza(n10, zzep2);
        }
    }

    public final void zzb(int n10, List list, zzhr zzhr2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zzb(n10, e10, zzhr2);
        }
    }

    public final void zzb(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfc.zzi(n14);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfc2.zzd(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfc3.zze(n10, n16);
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
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfc.zzd(l10);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfc2.zza(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfc3.zza(n10, l13);
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
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfc.zze(l10);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfc2.zza(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfc3.zza(n10, l13);
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
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfc.zzg(l10);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfc2.zzc(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfc3.zzc(n10, l13);
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
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            float f11 = 0.0f;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Float f12 = (Float)list.get(n10);
                f10 = f12.floatValue();
                n13 = zzfc.zzb(f10);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Float)list.get(n12);
                f11 = ((Float)object).floatValue();
                zzfc2.zza(f11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Float f13 = (Float)list.get(n12);
            float f14 = f13.floatValue();
            zzfc3.zza(n10, f14);
        }
    }

    public final void zzg(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            double d10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Double d11 = (Double)list.get(n10);
                d10 = d11;
                n13 = zzfc.zzb(d10);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Double)list.get(n12);
                d10 = (Double)object;
                zzfc2.zza(d10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Double d12 = (Double)list.get(n12);
            double d13 = d12;
            zzfc3.zza(n10, d13);
        }
    }

    public final void zzh(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfc.zzk(n14);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfc2.zza(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfc3.zzb(n10, n16);
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
            ((zzfc)object).zza(n10, n14);
            zzfc zzfc2 = null;
            boolean bl2 = false;
            object = null;
            for (n10 = 0; n10 < (n14 = list.size()); ++n10) {
                Boolean bl3 = (Boolean)list.get(n10);
                n14 = zzfc.zzb(bl3);
                var3_5 += n14;
            }
            zzfc2 = this.zza;
            zzfc2.zzb((int)var3_5);
            while (n13 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Boolean)list.get(n13);
                boolean bl4 = (Boolean)object;
                zzfc2.zza(bl4);
                ++n13;
            }
            return;
        }
        for (n13 = 0; n13 < (n12 = list.size()); ++n13) {
            zzfc zzfc3 = this.zza;
            Boolean bl5 = (Boolean)list.get(n13);
            boolean bl6 = bl5;
            zzfc3.zza(n10, bl6);
        }
    }

    public final void zzj(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfc.zzg(n14);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfc2.zzb(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfc3.zzc(n10, n16);
        }
    }

    public final void zzk(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfc.zzj(n14);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfc2.zzd(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfc3.zze(n10, n16);
        }
    }

    public final void zzl(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfc.zzh(l10);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfc2.zzc(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfc3.zzc(n10, l13);
        }
    }

    public final void zzm(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzfc.zzh(n14);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzfc2.zzc(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzfc3.zzd(n10, n16);
        }
    }

    public final void zzn(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzfc)object).zza(n10, n13);
            zzfc zzfc2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzfc.zzf(l10);
                n11 += n13;
            }
            zzfc2 = this.zza;
            zzfc2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzfc2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzfc2.zzb(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzfc zzfc3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzfc3.zzb(n10, l13);
        }
    }
}

