/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdw;
import com.google.android.gms.internal.mlkit_vision_common.zzea;
import com.google.android.gms.internal.mlkit_vision_common.zzeb;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzek;
import com.google.android.gms.internal.mlkit_vision_common.zzfa;
import com.google.android.gms.internal.mlkit_vision_common.zzfc;
import com.google.android.gms.internal.mlkit_vision_common.zzff;
import com.google.android.gms.internal.mlkit_vision_common.zzfo;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzgh;
import com.google.android.gms.internal.mlkit_vision_common.zzgm;
import com.google.android.gms.internal.mlkit_vision_common.zzgz;
import com.google.android.gms.internal.mlkit_vision_common.zzhb;
import com.google.android.gms.internal.mlkit_vision_common.zzhf;
import com.google.android.gms.internal.mlkit_vision_common.zzht;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.List;

public final class zzgj {
    private static final Class zza = zzgj.zzd();
    private static final zzgz zzb = zzgj.zza(false);
    private static final zzgz zzc = zzgj.zza(true);
    private static final zzgz zzd;

    static {
        zzhb zzhb2 = new zzhb();
        zzd = zzhb2;
    }

    public static int zza(int n10, Object object, zzgh zzgh2) {
        boolean bl2 = object instanceof zzfa;
        if (bl2) {
            object = (zzfa)object;
            return zzdw.zza(n10, (zzfa)object);
        }
        object = (zzfr)object;
        return zzdw.zzb(n10, (zzfr)object, zzgh2);
    }

    public static int zza(int n10, List list) {
        int n11;
        int n12 = list.size();
        if (n12 == 0) {
            return 0;
        }
        n10 = zzdw.zze(n10) * n12;
        int n13 = list instanceof zzfc;
        if (n13 != 0) {
            list = (zzfc)list;
            for (n11 = 0; n11 < n12; ++n11) {
                Object object = list.zza(n11);
                boolean bl2 = object instanceof zzdf;
                if (bl2) {
                    object = (zzdf)object;
                    n13 = zzdw.zzb((zzdf)object);
                } else {
                    object = (String)object;
                    n13 = zzdw.zzb((String)object);
                }
                n10 += n13;
            }
        } else {
            while (n11 < n12) {
                Object object = list.get(n11);
                boolean bl3 = object instanceof zzdf;
                if (bl3) {
                    object = (zzdf)object;
                    n13 = zzdw.zzb(object);
                } else {
                    object = (String)object;
                    n13 = zzdw.zzb(object);
                }
                n10 += n13;
                ++n11;
            }
        }
        return n10;
    }

    public static int zza(int n10, List list, zzgh zzgh2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzdw.zze(n10) * n11;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = list.get(i10);
            boolean bl2 = object instanceof zzfa;
            if (bl2) {
                object = (zzfa)object;
                n12 = zzdw.zza(object);
            } else {
                object = (zzfr)object;
                n12 = zzdw.zza(object, zzgh2);
            }
            n10 += n12;
        }
        return n10;
    }

    public static int zza(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzgj.zza(list);
        int n13 = list.size();
        n10 = zzdw.zze(n10);
        return n12 + (n13 *= n10);
    }

    public static int zza(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzff;
        if (n12 != 0) {
            list = (zzff)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzff)list).zza(n10);
                int n13 = zzdw.zzd(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzdw.zzd(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzgz zza() {
        return zzb;
    }

    private static zzgz zza(boolean bl2) {
        int n10;
        GenericDeclaration genericDeclaration;
        try {
            genericDeclaration = zzgj.zze();
            if (genericDeclaration == null) {
                return null;
            }
            n10 = 1;
        }
        catch (Throwable throwable) {
            return null;
        }
        Class[] classArray = new Class[n10];
        Class<Boolean> clazz = Boolean.TYPE;
        classArray[0] = clazz;
        genericDeclaration = ((Class)genericDeclaration).getConstructor(classArray);
        Object[] objectArray = new Object[n10];
        Boolean bl3 = bl2;
        objectArray[0] = bl3;
        bl3 = ((Constructor)genericDeclaration).newInstance(objectArray);
        return (zzgz)((Object)bl3);
    }

    public static void zza(int n10, List list, zzht zzht2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzht2.zza(n10, list);
        }
    }

    public static void zza(int n10, List list, zzht zzht2, zzgh zzgh2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzht2.zza(n10, list, zzgh2);
        }
    }

    public static void zza(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzg(n10, list, bl2);
        }
    }

    public static void zza(zzea object, Object object2, Object object3) {
        object3 = ((zzea)object).zza(object3);
        zzgm zzgm2 = ((zzeb)object3).zza;
        boolean bl2 = zzgm2.isEmpty();
        if (!bl2) {
            object = ((zzea)object).zzb(object2);
            ((zzeb)object).zza((zzeb)object3);
        }
    }

    public static void zza(zzfo object, Object object2, Object object3, long l10) {
        Object object4 = zzhf.zzf(object2, l10);
        object3 = zzhf.zzf(object3, l10);
        object = object.zza(object4, object3);
        zzhf.zza(object2, l10, object);
    }

    public static void zza(zzgz zzgz2, Object object, Object object2) {
        Object object3 = zzgz2.zza(object);
        object2 = zzgz2.zza(object2);
        object2 = zzgz2.zzb(object3, object2);
        zzgz2.zza(object, object2);
    }

    public static void zza(Class serializable) {
        boolean bl2;
        Class clazz = zzej.class;
        boolean bl3 = clazz.isAssignableFrom((Class<?>)serializable);
        if (!bl3 && (clazz = zza) != null && !(bl2 = clazz.isAssignableFrom((Class<?>)serializable))) {
            serializable = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            throw serializable;
        }
    }

    public static boolean zza(Object object, Object object2) {
        boolean bl2;
        return object == object2 || object != null && (bl2 = object.equals(object2));
        {
        }
    }

    public static int zzb(int n10, List list) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzdw.zze(n10);
        n11 *= n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            zzdf zzdf2 = (zzdf)list.get(i10);
            n10 = zzdw.zzb(zzdf2);
            n11 += n10;
        }
        return n11;
    }

    public static int zzb(int n10, List list, zzgh zzgh2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            zzfr zzfr2 = (zzfr)list.get(i10);
            int n13 = zzdw.zzc(n10, zzfr2, zzgh2);
            n12 += n13;
        }
        return n12;
    }

    public static int zzb(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzgj.zzb(list);
        n10 = zzdw.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzb(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzff;
        if (n12 != 0) {
            list = (zzff)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzff)list).zza(n10);
                int n13 = zzdw.zze(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzdw.zze(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzgz zzb() {
        return zzc;
    }

    public static void zzb(int n10, List list, zzht zzht2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzht2.zzb(n10, list);
        }
    }

    public static void zzb(int n10, List list, zzht zzht2, zzgh zzgh2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzht2.zzb(n10, list, zzgh2);
        }
    }

    public static void zzb(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzf(n10, list, bl2);
        }
    }

    public static int zzc(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzgj.zzc(list);
        n10 = zzdw.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzc(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzff;
        if (n12 != 0) {
            list = (zzff)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzff)list).zza(n10);
                int n13 = zzdw.zzf(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzdw.zzf(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzgz zzc() {
        return zzd;
    }

    public static void zzc(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzc(n10, list, bl2);
        }
    }

    public static int zzd(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzgj.zzd(list);
        n10 = zzdw.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzd(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzek;
        if (n12 != 0) {
            list = (zzek)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzdw.zzk(((zzek)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzdw.zzk(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    private static Class zzd() {
        String string2 = "com.google.protobuf.GeneratedMessage";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static void zzd(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzd(n10, list, bl2);
        }
    }

    public static int zze(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzgj.zze(list);
        n10 = zzdw.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zze(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzek;
        if (n12 != 0) {
            list = (zzek)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzdw.zzf(((zzek)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzdw.zzf(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    private static Class zze() {
        String string2 = "com.google.protobuf.UnknownFieldSetSchema";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static void zze(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzn(n10, list, bl2);
        }
    }

    public static int zzf(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzgj.zzf(list);
        n10 = zzdw.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzf(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzek;
        if (n12 != 0) {
            list = (zzek)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzdw.zzg(((zzek)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzdw.zzg(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzf(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zze(n10, list, bl2);
        }
    }

    public static int zzg(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzgj.zzg(list);
        n10 = zzdw.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzg(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzek;
        if (n12 != 0) {
            list = (zzek)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzdw.zzh(((zzek)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzdw.zzh(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzg(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzl(n10, list, bl2);
        }
    }

    public static int zzh(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzdw.zzi(n10, 0);
        return n11 * n10;
    }

    public static int zzh(List list) {
        return list.size() << 2;
    }

    public static void zzh(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zza(n10, list, bl2);
        }
    }

    public static int zzi(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzdw.zzg(n10, 0L);
        return n11 * n10;
    }

    public static int zzi(List list) {
        return list.size() << 3;
    }

    public static void zzi(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzj(n10, list, bl2);
        }
    }

    public static int zzj(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzdw.zzb(n10, true);
        return n11 * n10;
    }

    public static int zzj(List list) {
        return list.size();
    }

    public static void zzj(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzm(n10, list, bl2);
        }
    }

    public static void zzk(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzb(n10, list, bl2);
        }
    }

    public static void zzl(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzk(n10, list, bl2);
        }
    }

    public static void zzm(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzh(n10, list, bl2);
        }
    }

    public static void zzn(int n10, List list, zzht zzht2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzht2.zzi(n10, list, bl2);
        }
    }
}

