/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdw;
import com.google.android.gms.internal.mlkit_vision_common.zzeb;
import com.google.android.gms.internal.mlkit_vision_common.zzem;
import com.google.android.gms.internal.mlkit_vision_common.zzfc;
import com.google.android.gms.internal.mlkit_vision_common.zzfm;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzgh;
import com.google.android.gms.internal.mlkit_vision_common.zzhn;
import com.google.android.gms.internal.mlkit_vision_common.zzht;
import com.google.android.gms.internal.mlkit_vision_common.zzhw;
import java.util.List;
import java.util.Map;

public final class zzdy
implements zzht {
    private final zzdw zza;

    private zzdy(zzdw zzdw2) {
        this.zza = zzdw2 = (zzdw)zzem.zza((Object)zzdw2, "output");
        zzdw2.zza = this;
    }

    public static zzdy zza(zzdw zzdw2) {
        zzdy zzdy2 = zzdw2.zza;
        if (zzdy2 != null) {
            return zzdy2;
        }
        zzdy2 = new zzdy(zzdw2);
        return zzdy2;
    }

    public final int zza() {
        return zzhw.zza;
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

    public final void zza(int n10, zzdf zzdf2) {
        this.zza.zza(n10, zzdf2);
    }

    public final void zza(int n10, zzfm zzfm2, Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            zzdw zzdw2 = this.zza;
            int n11 = 2;
            zzdw2.zza(n10, n11);
            zzdw2 = this.zza;
            Object object2 = entry.getKey();
            Object object3 = entry.getValue();
            zzhn zzhn2 = zzfm2.zza;
            int n12 = 1;
            int n13 = zzeb.zza(zzhn2, n12, object2);
            zzhn2 = zzfm2.zzb;
            int n14 = zzeb.zza(zzhn2, n11, object3);
            zzdw2.zzb(n13 += n14);
            zzdw2 = this.zza;
            object2 = entry.getKey();
            entry = entry.getValue();
            object3 = zzfm2.zza;
            zzeb.zza(zzdw2, object3, n12, object2);
            object2 = zzfm2.zzb;
            zzeb.zza(zzdw2, object2, n11, entry);
        }
    }

    public final void zza(int n10, Object object) {
        boolean bl2 = object instanceof zzdf;
        if (bl2) {
            zzdw zzdw2 = this.zza;
            object = (zzdf)object;
            zzdw2.zzb(n10, (zzdf)object);
            return;
        }
        zzdw zzdw3 = this.zza;
        object = (zzfr)object;
        zzdw3.zza(n10, (zzfr)object);
    }

    public final void zza(int n10, Object object, zzgh zzgh2) {
        zzdw zzdw2 = this.zza;
        object = (zzfr)object;
        zzdw2.zza(n10, (zzfr)object, zzgh2);
    }

    public final void zza(int n10, String string2) {
        this.zza.zza(n10, string2);
    }

    public final void zza(int n10, List list) {
        int n11;
        int n12 = list instanceof zzfc;
        if (n12 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzfc)list;
            for (n11 = 0; n11 < (n13 = list.size()); ++n11) {
                zzdw zzdw2;
                Object object = list2.zza(n11);
                boolean bl2 = object instanceof String;
                if (bl2) {
                    zzdw2 = this.zza;
                    object = (String)object;
                    zzdw2.zza(n10, (String)object);
                    continue;
                }
                zzdw2 = this.zza;
                object = (zzdf)object;
                zzdw2.zza(n10, (zzdf)object);
            }
            return;
        }
        while (n11 < (n12 = list.size())) {
            zzdw zzdw3 = this.zza;
            String string2 = (String)list.get(n11);
            zzdw3.zza(n10, string2);
            ++n11;
        }
    }

    public final void zza(int n10, List list, zzgh zzgh2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zza(n10, e10, zzgh2);
        }
    }

    public final void zza(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzdw.zzf(n14);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzdw2.zza(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzdw3.zzb(n10, n16);
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

    public final void zzb(int n10, Object object, zzgh zzgh2) {
        zzdw zzdw2 = this.zza;
        object = (zzfr)object;
        zzdw2.zza(n10, 3);
        zzdy zzdy2 = zzdw2.zza;
        zzgh2.zza(object, zzdy2);
        zzdw2.zza(n10, 4);
    }

    public final void zzb(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            zzdw zzdw2 = this.zza;
            zzdf zzdf2 = (zzdf)list.get(i10);
            zzdw2.zza(n10, zzdf2);
        }
    }

    public final void zzb(int n10, List list, zzgh zzgh2) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.zzb(n10, e10, zzgh2);
        }
    }

    public final void zzb(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzdw.zzi(n14);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzdw2.zzd(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzdw3.zze(n10, n16);
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
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzdw.zzd(l10);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzdw2.zza(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzdw3.zza(n10, l13);
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
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzdw.zze(l10);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzdw2.zza(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzdw3.zza(n10, l13);
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
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzdw.zzg(l10);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzdw2.zzc(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzdw3.zzc(n10, l13);
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
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            float f11 = 0.0f;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Float f12 = (Float)list.get(n10);
                f10 = f12.floatValue();
                n13 = zzdw.zzb(f10);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Float)list.get(n12);
                f11 = ((Float)object).floatValue();
                zzdw2.zza(f11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Float f13 = (Float)list.get(n12);
            float f14 = f13.floatValue();
            zzdw3.zza(n10, f14);
        }
    }

    public final void zzg(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            double d10;
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Double d11 = (Double)list.get(n10);
                d10 = d11;
                n13 = zzdw.zzb(d10);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Double)list.get(n12);
                d10 = (Double)object;
                zzdw2.zza(d10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Double d12 = (Double)list.get(n12);
            double d13 = d12;
            zzdw3.zza(n10, d13);
        }
    }

    public final void zzh(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzdw.zzk(n14);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzdw2.zza(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzdw3.zzb(n10, n16);
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
            ((zzdw)object).zza(n10, n14);
            zzdw zzdw2 = null;
            boolean bl2 = false;
            object = null;
            for (n10 = 0; n10 < (n14 = list.size()); ++n10) {
                Boolean bl3 = (Boolean)list.get(n10);
                n14 = zzdw.zzb(bl3);
                var3_5 += n14;
            }
            zzdw2 = this.zza;
            zzdw2.zzb((int)var3_5);
            while (n13 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Boolean)list.get(n13);
                boolean bl4 = (Boolean)object;
                zzdw2.zza(bl4);
                ++n13;
            }
            return;
        }
        for (n13 = 0; n13 < (n12 = list.size()); ++n13) {
            zzdw zzdw3 = this.zza;
            Boolean bl5 = (Boolean)list.get(n13);
            boolean bl6 = bl5;
            zzdw3.zza(n10, bl6);
        }
    }

    public final void zzj(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzdw.zzg(n14);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzdw2.zzb(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzdw3.zzc(n10, n16);
        }
    }

    public final void zzk(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzdw.zzj(n14);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzdw2.zzd(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzdw3.zze(n10, n16);
        }
    }

    public final void zzl(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzdw.zzh(l10);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzdw2.zzc(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzdw3.zzc(n10, l13);
        }
    }

    public final void zzm(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzdw.zzh(n14);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzdw2.zzc(n11);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Integer n15 = (Integer)list.get(n12);
            int n16 = n15;
            zzdw3.zzd(n10, n16);
        }
    }

    public final void zzn(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzdw)object).zza(n10, n13);
            zzdw zzdw2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzdw.zzf(l10);
                n11 += n13;
            }
            zzdw2 = this.zza;
            zzdw2.zzb(n11);
            while (n12 < (n10 = list.size())) {
                zzdw2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzdw2.zzb(l10);
                ++n12;
            }
            return;
        }
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            zzdw zzdw3 = this.zza;
            Long l12 = (Long)list.get(n12);
            long l13 = l12;
            zzdw3.zzb(n10, l13);
        }
    }
}

