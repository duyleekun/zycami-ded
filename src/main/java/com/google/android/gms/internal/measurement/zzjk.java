/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhf;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzif;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzim;
import com.google.android.gms.internal.measurement.zzis;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzjw;
import com.google.android.gms.internal.measurement.zzjy;
import com.google.android.gms.internal.measurement.zzkh;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.RandomAccess;

public final class zzjk {
    private static final Class zza;
    private static final zzjw zzb;
    private static final zzjw zzc;
    private static final zzjw zzd;

    static {
        Object object = "com.google.protobuf.GeneratedMessage";
        try {
            object = Class.forName((String)object);
        }
        catch (Throwable throwable) {
            object = null;
        }
        zza = object;
        zzb = zzjk.zzab(false);
        zzc = zzjk.zzab(true);
        zzd = object = new zzjy();
    }

    public static zzjw zzA() {
        return zzb;
    }

    public static zzjw zzB() {
        return zzc;
    }

    public static zzjw zzC() {
        return zzd;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean zzD(Object object, Object object2) {
        boolean bl2 = false;
        boolean bl3 = true;
        if (object == object2) return bl3;
        if (object == null) return bl2;
        boolean bl4 = object.equals(object2);
        if (!bl4) return false;
        return bl3;
    }

    public static void zzE(zzhf zzhf2, Object object, Object object2) {
        zzhf2.zzb(object2);
        throw null;
    }

    public static void zzF(zzjw zzjw2, Object object, Object object2) {
        Object object3 = zzjw2.zzd(object);
        object2 = zzjw2.zzd(object2);
        object2 = zzjw2.zzf(object3, object2);
        zzjw2.zzc(object, object2);
    }

    public static Object zzG(int n10, List object, zzhw zzhw2, Object object2, zzjw zzjw2) {
        if (zzhw2 == null) {
            return object2;
        }
        int n11 = object instanceof RandomAccess;
        if (n11 != 0) {
            n11 = object.size();
            int n12 = 0;
            for (int i10 = 0; i10 < n11; ++i10) {
                Integer n13 = (Integer)((List)object).get(i10);
                int n14 = n13;
                boolean bl2 = zzhw2.zza(n14);
                if (bl2) {
                    if (i10 != n12) {
                        n13 = n14;
                        ((List)object).set(n12, n13);
                    }
                    ++n12;
                    continue;
                }
                object2 = zzjk.zzH(n10, n14, object2, zzjw2);
            }
            if (n12 != n11) {
                ((List)object).subList(n12, n11).clear();
                return object2;
            }
        } else {
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Integer n15 = (Integer)object.next();
                n11 = n15;
                boolean bl3 = zzhw2.zza(n11);
                if (bl3) continue;
                object2 = zzjk.zzH(n10, n11, object2, zzjw2);
                object.remove();
            }
        }
        return object2;
    }

    public static Object zzH(int n10, int n11, Object object, zzjw zzjw2) {
        if (object == null) {
            object = zzjw2.zzb();
        }
        long l10 = n11;
        zzjw2.zza(object, n10, l10);
        return object;
    }

    public static void zzI(zzis object, Object object2, Object object3, long l10) {
        object = zzkh.zzn(object2, l10);
        object3 = zzkh.zzn(object3, l10);
        object = zzis.zzb(object, object3);
        zzkh.zzo(object2, l10, object);
    }

    public static void zzJ(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzB(n10, list, bl2);
        }
    }

    public static void zzK(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzA(n10, list, bl2);
        }
    }

    public static void zzL(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzx(n10, list, bl2);
        }
    }

    public static void zzM(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzy(n10, list, bl2);
        }
    }

    public static void zzN(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzK(n10, list, bl2);
        }
    }

    public static void zzO(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzz(n10, list, bl2);
        }
    }

    public static void zzP(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzI(n10, list, bl2);
        }
    }

    public static void zzQ(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzv(n10, list, bl2);
        }
    }

    public static void zzR(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzG(n10, list, bl2);
        }
    }

    public static void zzS(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzJ(n10, list, bl2);
        }
    }

    public static void zzT(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzw(n10, list, bl2);
        }
    }

    public static void zzU(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzH(n10, list, bl2);
        }
    }

    public static void zzV(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzC(n10, list, bl2);
        }
    }

    public static void zzW(int n10, List list, zzha zzha2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzha2.zzD(n10, list, bl2);
        }
    }

    public static void zzX(int n10, List list, zzha zzha2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzha2.zzE(n10, list);
        }
    }

    public static void zzY(int n10, List list, zzha zzha2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzha2.zzF(n10, list);
        }
    }

    public static void zzZ(int n10, List list, zzha zzha2, zzji zzji2) {
        int n11;
        if (list != null && (n11 = list.isEmpty()) == 0) {
            int n12;
            for (n11 = 0; n11 < (n12 = list.size()); ++n11) {
                Object e10 = list.get(n11);
                zzha2.zzr(n10, e10, zzji2);
            }
        }
    }

    public static void zza(Class serializable) {
        boolean bl2;
        Class clazz = zzhs.class;
        boolean bl3 = clazz.isAssignableFrom((Class<?>)serializable);
        if (!bl3 && (clazz = zza) != null && !(bl2 = clazz.isAssignableFrom((Class<?>)serializable))) {
            serializable = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            throw serializable;
        }
    }

    public static void zzaa(int n10, List list, zzha zzha2, zzji zzji2) {
        int n11;
        if (list != null && (n11 = list.isEmpty()) == 0) {
            int n12;
            for (n11 = 0; n11 < (n12 = list.size()); ++n11) {
                Object e10 = list.get(n11);
                zzha2.zzs(n10, e10, zzji2);
            }
        }
    }

    private static zzjw zzab(boolean bl2) {
        Class[] classArray;
        Constructor constructor = "com.google.protobuf.UnknownFieldSetSchema";
        try {
            constructor = Class.forName((String)((Object)constructor));
        }
        catch (Throwable throwable) {
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        int n10 = 1;
        try {
            classArray = new Class[n10];
        }
        catch (Throwable throwable) {
            return null;
        }
        Class<Boolean> clazz = Boolean.TYPE;
        classArray[0] = clazz;
        constructor = ((Class)((Object)constructor)).getConstructor(classArray);
        Object[] objectArray = new Object[n10];
        Boolean bl3 = bl2;
        objectArray[0] = bl3;
        bl3 = constructor.newInstance(objectArray);
        return (zzjw)((Object)bl3);
    }

    public static int zzb(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzim;
        if (n12 != 0) {
            list = (zzim)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzim)list).zzc(n10);
                int n13 = zzgz.zzx(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzgz.zzx(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzc(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzjk.zzb(list);
        int n13 = list.size();
        n10 = zzgz.zzu(n10);
        return n12 + (n13 *= n10);
    }

    public static int zzd(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzim;
        if (n12 != 0) {
            list = (zzim)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzim)list).zzc(n10);
                int n13 = zzgz.zzx(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzgz.zzx(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static int zze(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzjk.zzd(list);
        n10 = zzgz.zzu(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzf(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzim;
        int n13 = 63;
        if (n12 != 0) {
            list = (zzim)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzim)list).zzc(n10);
                long l11 = l10 + l10;
                l10 = l10 >> n13 ^ l11;
                int n14 = zzgz.zzx(l10);
                n12 += n14;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l12 = (Long)list.get(n10);
                long l13 = l12;
                long l14 = l13 + l13;
                l13 = l13 >> n13 ^ l14;
                int n15 = zzgz.zzx(l13);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzg(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzjk.zzf(list);
        n10 = zzgz.zzu(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzh(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzht;
        if (n12 != 0) {
            list = (zzht)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzgz.zzv(((zzht)list).zzg(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzgz.zzv(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzi(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzjk.zzh(list);
        n10 = zzgz.zzu(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzj(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzht;
        if (n12 != 0) {
            list = (zzht)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzgz.zzv(((zzht)list).zzg(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzgz.zzv(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzk(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzjk.zzj(list);
        n10 = zzgz.zzu(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzl(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzht;
        if (n12 != 0) {
            list = (zzht)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzgz.zzw(((zzht)list).zzg(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzgz.zzw(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzm(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzjk.zzl(list);
        n10 = zzgz.zzu(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzn(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzht;
        if (n12 != 0) {
            list = (zzht)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = ((zzht)list).zzg(n10);
                int n14 = n13 + n13;
                n13 = zzgz.zzw(n13 >> 31 ^ n14);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n15 = (Integer)list.get(n10);
                int n16 = n15;
                int n17 = n16 + n16;
                n16 = zzgz.zzw(n16 >> 31 ^ n17);
                n12 += n16;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzo(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzjk.zzn(list);
        n10 = zzgz.zzu(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzp(List list) {
        return list.size() * 4;
    }

    public static int zzq(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzgz.zzw(n10 << 3) + 4;
        return n11 * n10;
    }

    public static int zzr(List list) {
        return list.size() * 8;
    }

    public static int zzs(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzgz.zzw(n10 << 3) + 8;
        return n11 * n10;
    }

    public static int zzt(List list) {
        return list.size();
    }

    public static int zzu(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzgz.zzw(n10 << 3) + 1;
        return n11 * n10;
    }

    public static int zzv(int n10, List list) {
        int n11;
        int n12 = list.size();
        if (n12 == 0) {
            return 0;
        }
        n10 = zzgz.zzu(n10) * n12;
        int n13 = list instanceof zzih;
        if (n13 != 0) {
            list = (zzih)list;
            for (n11 = 0; n11 < n12; ++n11) {
                Object object = list.zzg(n11);
                boolean bl2 = object instanceof zzgs;
                if (bl2) {
                    object = (zzgs)object;
                    n13 = zzgz.zzA((zzgs)object);
                } else {
                    object = (String)object;
                    n13 = zzgz.zzy((String)object);
                }
                n10 += n13;
            }
        } else {
            while (n11 < n12) {
                Object object = list.get(n11);
                boolean bl3 = object instanceof zzgs;
                if (bl3) {
                    object = (zzgs)object;
                    n13 = zzgz.zzA(object);
                } else {
                    object = (String)object;
                    n13 = zzgz.zzy(object);
                }
                n10 += n13;
                ++n11;
            }
        }
        return n10;
    }

    public static int zzw(int n10, Object object, zzji zzji2) {
        boolean bl2 = object instanceof zzif;
        if (bl2) {
            object = (zzif)object;
            n10 = zzgz.zzw(n10 << 3);
            int n11 = ((zzif)object).zza();
            int n12 = zzgz.zzw(n11) + n11;
            return n10 + n12;
        }
        object = (zzix)object;
        n10 = zzgz.zzw(n10 << 3);
        int n13 = zzgz.zzB((zzix)object, zzji2);
        return n10 + n13;
    }

    public static int zzx(int n10, List list, zzji zzji2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzgz.zzu(n10) * n11;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = list.get(i10);
            boolean bl2 = object instanceof zzif;
            if (bl2) {
                object = (zzif)object;
                n12 = zzgz.zzz(object);
            } else {
                object = (zzix)object;
                n12 = zzgz.zzB(object, zzji2);
            }
            n10 += n12;
        }
        return n10;
    }

    public static int zzy(int n10, List list) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzgz.zzu(n10);
        n11 *= n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            zzgs zzgs2 = (zzgs)list.get(i10);
            n10 = zzgz.zzA(zzgs2);
            n11 += n10;
        }
        return n11;
    }

    public static int zzz(int n10, List list, zzji zzji2) {
        int n11 = list.size();
        if (n11 != 0) {
            int n12 = 0;
            for (int i10 = 0; i10 < n11; ++i10) {
                zzix zzix2 = (zzix)list.get(i10);
                int n13 = zzgz.zzE(n10, zzix2, zzji2);
                n12 += n13;
            }
            return n12;
        }
        return 0;
    }
}

