/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgx;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzji;
import java.util.List;

public final class zzha {
    private final zzgz zza;

    private zzha(zzgz zzgz2) {
        zzia.zzb(zzgz2, "output");
        this.zza = zzgz2;
        zzgz2.zza = this;
    }

    public static zzha zza(zzgz zzgz2) {
        zzha zzha2 = zzgz2.zza;
        if (zzha2 != null) {
            return zzha2;
        }
        zzha2 = new zzha(zzgz2);
        return zzha2;
    }

    public final void zzA(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            float f10 = 2.8E-45f;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            float f11 = 0.0f;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Float f12 = (Float)list.get(n10);
                f12.floatValue();
                n11 += 4;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Float)list.get(n12);
                f11 = ((Float)object).floatValue();
                n11 = Float.floatToRawIntBits(f11);
                zzgz2.zzm(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Float f13 = (Float)list.get(n12);
                float f14 = f13.floatValue();
                int n14 = Float.floatToRawIntBits(f14);
                zzgz3.zzd(n10, n14);
            }
        }
    }

    public final void zzB(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Double d10 = (Double)list.get(n10);
                d10.doubleValue();
                n11 += 8;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Double)list.get(n12);
                double d11 = (Double)object;
                long l10 = Double.doubleToRawLongBits(d11);
                zzgz2.zzo(l10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Double d12 = (Double)list.get(n12);
                double d13 = d12;
                long l11 = Double.doubleToRawLongBits(d13);
                zzgz3.zzf(n10, l11);
            }
        }
    }

    public final void zzC(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzgz.zzv(n14);
                n11 += n13;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzgz2.zzk(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                zzgz3.zzb(n10, n16);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void zzD(int n10, List list, boolean n11) {
        int n12;
        if (n11 != 0) {
            void var3_5;
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            boolean bl2 = false;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Boolean bl3 = (Boolean)list.get(n10);
                bl3.booleanValue();
                ++var3_5;
            }
            zzgz2 = this.zza;
            zzgz2.zzl((int)var3_5);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Boolean)list.get(n12);
                byte by2 = ((Boolean)object).booleanValue();
                zzgz2.zzj(by2);
                ++n12;
            }
        } else {
            int n14;
            for (n12 = 0; n12 < (n14 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Boolean bl4 = (Boolean)list.get(n12);
                boolean bl5 = bl4;
                zzgz3.zzg(n10, bl5);
            }
        }
    }

    public final void zzE(int n10, List list) {
        int n11;
        int n12 = list instanceof zzih;
        if (n12 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzih)list;
            for (n11 = 0; n11 < (n13 = list.size()); ++n11) {
                zzgz zzgz2;
                Object object = list2.zzg(n11);
                boolean bl2 = object instanceof String;
                if (bl2) {
                    zzgz2 = this.zza;
                    object = (String)object;
                    zzgz2.zzh(n10, (String)object);
                    continue;
                }
                zzgz2 = this.zza;
                object = (zzgs)object;
                zzgz2.zzi(n10, (zzgs)object);
            }
        } else {
            while (n11 < (n12 = list.size())) {
                zzgz zzgz3 = this.zza;
                String string2 = (String)list.get(n11);
                zzgz3.zzh(n10, string2);
                ++n11;
            }
        }
    }

    public final void zzF(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            zzgz zzgz2 = this.zza;
            zzgs zzgs2 = (zzgs)list.get(i10);
            zzgz2.zzi(n10, zzgs2);
        }
    }

    public final void zzG(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzgz.zzw(n14);
                n11 += n13;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzgz2.zzl(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                zzgz3.zzc(n10, n16);
            }
        }
    }

    public final void zzH(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n14.intValue();
                n11 += 4;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzgz2.zzm(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                zzgz3.zzd(n10, n16);
            }
        }
    }

    public final void zzI(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l10 = (Long)list.get(n10);
                l10.longValue();
                n11 += 8;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Long)list.get(n12);
                long l11 = (Long)object;
                zzgz2.zzo(l11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                zzgz3.zzf(n10, l13);
            }
        }
    }

    public final void zzJ(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = n14;
                int n15 = n13 + n13;
                n13 = zzgz.zzw(n13 >> 31 ^ n15);
                n11 += n13;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                n13 = n11 + n11;
                n11 = n11 >> 31 ^ n13;
                zzgz2.zzl(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Integer n16 = (Integer)list.get(n12);
                int n17 = n16;
                int n18 = n17 + n17;
                n17 = n17 >> 31 ^ n18;
                zzgz3.zzc(n10, n17);
            }
        }
    }

    public final void zzK(int n10, List list, boolean n11) {
        int n12;
        int n13 = 63;
        if (n11) {
            long l10;
            long l11;
            Object object = this.zza;
            int n14 = 2;
            ((zzgz)object).zza(n10, n14);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n14 = list.size()); ++n10) {
                Long l12 = (Long)list.get(n10);
                l11 = l12;
                l10 = l11 + l11;
                l11 = l11 >> n13 ^ l10;
                n14 = zzgz.zzx(l11);
                n11 += n14;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Long)list.get(n12);
                l11 = (Long)object;
                l10 = l11 + l11;
                l11 = l11 >> n13 ^ l10;
                zzgz2.zzn(l11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Long l13 = (Long)list.get(n12);
                long l14 = l13;
                long l15 = l14 + l14;
                l14 = l14 >> n13 ^ l15;
                zzgz3.zze(n10, l14);
            }
        }
    }

    public final void zzb(int n10, int n11) {
        this.zza.zzd(n10, n11);
    }

    public final void zzc(int n10, long l10) {
        this.zza.zze(n10, l10);
    }

    public final void zzd(int n10, long l10) {
        this.zza.zzf(n10, l10);
    }

    public final void zze(int n10, float f10) {
        zzgz zzgz2 = this.zza;
        int n11 = Float.floatToRawIntBits(f10);
        zzgz2.zzd(n10, n11);
    }

    public final void zzf(int n10, double d10) {
        zzgz zzgz2 = this.zza;
        long l10 = Double.doubleToRawLongBits(d10);
        zzgz2.zzf(n10, l10);
    }

    public final void zzg(int n10, int n11) {
        this.zza.zzb(n10, n11);
    }

    public final void zzh(int n10, long l10) {
        this.zza.zze(n10, l10);
    }

    public final void zzi(int n10, int n11) {
        this.zza.zzb(n10, n11);
    }

    public final void zzj(int n10, long l10) {
        this.zza.zzf(n10, l10);
    }

    public final void zzk(int n10, int n11) {
        this.zza.zzd(n10, n11);
    }

    public final void zzl(int n10, boolean bl2) {
        this.zza.zzg(n10, bl2);
    }

    public final void zzm(int n10, String string2) {
        this.zza.zzh(n10, string2);
    }

    public final void zzn(int n10, zzgs zzgs2) {
        this.zza.zzi(n10, zzgs2);
    }

    public final void zzo(int n10, int n11) {
        this.zza.zzc(n10, n11);
    }

    public final void zzp(int n10, int n11) {
        zzgz zzgz2 = this.zza;
        int n12 = n11 + n11;
        n11 = n11 >> 31 ^ n12;
        zzgz2.zzc(n10, n11);
    }

    public final void zzq(int n10, long l10) {
        zzgz zzgz2 = this.zza;
        long l11 = l10 + l10;
        l10 = l10 >> 63 ^ l11;
        zzgz2.zze(n10, l10);
    }

    public final void zzr(int n10, Object object, zzji zzji2) {
        zzgz zzgz2 = this.zza;
        object = (zzix)object;
        zzgz2 = (zzgx)zzgz2;
        n10 = n10 << 3 | 2;
        ((zzgx)zzgz2).zzl(n10);
        Object object2 = object;
        object2 = (zzgb)object;
        int n11 = ((zzgb)object2).zzbq();
        int n12 = -1;
        if (n11 == n12) {
            n11 = zzji2.zze(object2);
            ((zzgb)object2).zzbr(n11);
        }
        ((zzgx)zzgz2).zzl(n11);
        object2 = zzgz2.zza;
        zzji2.zzm(object, (zzha)object2);
    }

    public final void zzs(int n10, Object object, zzji zzji2) {
        zzgz zzgz2 = this.zza;
        object = (zzix)object;
        zzgz2.zza(n10, 3);
        zzha zzha2 = zzgz2.zza;
        zzji2.zzm(object, zzha2);
        zzgz2.zza(n10, 4);
    }

    public final void zzt(int n10) {
        this.zza.zza(n10, 3);
    }

    public final void zzu(int n10) {
        this.zza.zza(n10, 4);
    }

    public final void zzv(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = zzgz.zzv(n14);
                n11 += n13;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzgz2.zzk(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                zzgz3.zzb(n10, n16);
            }
        }
    }

    public final void zzw(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n14.intValue();
                n11 += 4;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                zzgz2.zzm(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                zzgz3.zzd(n10, n16);
            }
        }
    }

    public final void zzx(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzgz.zzx(l10);
                n11 += n13;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzgz2.zzn(l10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                zzgz3.zze(n10, l13);
            }
        }
    }

    public final void zzy(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = zzgz.zzx(l10);
                n11 += n13;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                zzgz2.zzn(l10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                zzgz3.zze(n10, l13);
            }
        }
    }

    public final void zzz(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.zza;
            int n13 = 2;
            ((zzgz)object).zza(n10, n13);
            zzgz zzgz2 = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l10 = (Long)list.get(n10);
                l10.longValue();
                n11 += 8;
            }
            zzgz2 = this.zza;
            zzgz2.zzl(n11);
            while (n12 < (n10 = list.size())) {
                zzgz2 = this.zza;
                object = (Long)list.get(n12);
                long l11 = (Long)object;
                zzgz2.zzo(l11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                zzgz zzgz3 = this.zza;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                zzgz3.zzf(n10, l13);
            }
        }
    }
}

