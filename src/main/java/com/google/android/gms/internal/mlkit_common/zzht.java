/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzfc;
import com.google.android.gms.internal.mlkit_common.zzfg;
import com.google.android.gms.internal.mlkit_common.zzfl;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzft;
import com.google.android.gms.internal.mlkit_common.zzgg;
import com.google.android.gms.internal.mlkit_common.zzgi;
import com.google.android.gms.internal.mlkit_common.zzgp;
import com.google.android.gms.internal.mlkit_common.zzgu;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhr;
import com.google.android.gms.internal.mlkit_common.zzhs;
import com.google.android.gms.internal.mlkit_common.zzij;
import com.google.android.gms.internal.mlkit_common.zzil;
import com.google.android.gms.internal.mlkit_common.zzip;
import com.google.android.gms.internal.mlkit_common.zzjd;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.List;

public final class zzht {
    private static final Class zza = zzht.zzd();
    private static final zzij zzb = zzht.zza(false);
    private static final zzij zzc = zzht.zza(true);
    private static final zzij zzd;

    static {
        zzil zzil2 = new zzil();
        zzd = zzil2;
    }

    public static int zza(int n10, Object object, zzhr zzhr2) {
        boolean bl2 = object instanceof zzgg;
        if (bl2) {
            object = (zzgg)object;
            return zzfc.zza(n10, (zzgg)object);
        }
        object = (zzhb)object;
        return zzfc.zzb(n10, (zzhb)object, zzhr2);
    }

    public static int zza(int n10, List list) {
        int n11;
        int n12 = list.size();
        if (n12 == 0) {
            return 0;
        }
        n10 = zzfc.zze(n10) * n12;
        int n13 = list instanceof zzgi;
        if (n13 != 0) {
            list = (zzgi)list;
            for (n11 = 0; n11 < n12; ++n11) {
                Object object = list.zza(n11);
                boolean bl2 = object instanceof zzep;
                if (bl2) {
                    object = (zzep)object;
                    n13 = zzfc.zzb((zzep)object);
                } else {
                    object = (String)object;
                    n13 = zzfc.zzb((String)object);
                }
                n10 += n13;
            }
        } else {
            while (n11 < n12) {
                Object object = list.get(n11);
                boolean bl3 = object instanceof zzep;
                if (bl3) {
                    object = (zzep)object;
                    n13 = zzfc.zzb(object);
                } else {
                    object = (String)object;
                    n13 = zzfc.zzb(object);
                }
                n10 += n13;
                ++n11;
            }
        }
        return n10;
    }

    public static int zza(int n10, List list, zzhr zzhr2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzfc.zze(n10) * n11;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = list.get(i10);
            boolean bl2 = object instanceof zzgg;
            if (bl2) {
                object = (zzgg)object;
                n12 = zzfc.zza(object);
            } else {
                object = (zzhb)object;
                n12 = zzfc.zza(object, zzhr2);
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
        int n12 = zzht.zza(list);
        int n13 = list.size();
        n10 = zzfc.zze(n10);
        return n12 + (n13 *= n10);
    }

    public static int zza(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzgp;
        if (n12 != 0) {
            list = (zzgp)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzgp)list).zza(n10);
                int n13 = zzfc.zzd(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzfc.zzd(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzij zza() {
        return zzb;
    }

    private static zzij zza(boolean bl2) {
        int n10;
        GenericDeclaration genericDeclaration;
        try {
            genericDeclaration = zzht.zze();
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
        return (zzij)((Object)bl3);
    }

    public static void zza(int n10, List list, zzjd zzjd2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzjd2.zza(n10, list);
        }
    }

    public static void zza(int n10, List list, zzjd zzjd2, zzhr zzhr2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzjd2.zza(n10, list, zzhr2);
        }
    }

    public static void zza(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzg(n10, list, bl2);
        }
    }

    public static void zza(zzfg object, Object object2, Object object3) {
        object3 = ((zzfg)object).zza(object3);
        zzhs zzhs2 = ((zzfl)object3).zza;
        boolean bl2 = zzhs2.isEmpty();
        if (!bl2) {
            object = ((zzfg)object).zzb(object2);
            ((zzfl)object).zza((zzfl)object3);
        }
    }

    public static void zza(zzgu object, Object object2, Object object3, long l10) {
        Object object4 = zzip.zzf(object2, l10);
        object3 = zzip.zzf(object3, l10);
        object = object.zza(object4, object3);
        zzip.zza(object2, l10, object);
    }

    public static void zza(zzij zzij2, Object object, Object object2) {
        Object object3 = zzij2.zza(object);
        object2 = zzij2.zza(object2);
        object2 = zzij2.zzb(object3, object2);
        zzij2.zza(object, object2);
    }

    public static void zza(Class serializable) {
        boolean bl2;
        Class clazz = zzfq.class;
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
        n10 = zzfc.zze(n10);
        n11 *= n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            zzep zzep2 = (zzep)list.get(i10);
            n10 = zzfc.zzb(zzep2);
            n11 += n10;
        }
        return n11;
    }

    public static int zzb(int n10, List list, zzhr zzhr2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            zzhb zzhb2 = (zzhb)list.get(i10);
            int n13 = zzfc.zzc(n10, zzhb2, zzhr2);
            n12 += n13;
        }
        return n12;
    }

    public static int zzb(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzht.zzb(list);
        n10 = zzfc.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzb(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzgp;
        if (n12 != 0) {
            list = (zzgp)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzgp)list).zza(n10);
                int n13 = zzfc.zze(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzfc.zze(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzij zzb() {
        return zzc;
    }

    public static void zzb(int n10, List list, zzjd zzjd2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzjd2.zzb(n10, list);
        }
    }

    public static void zzb(int n10, List list, zzjd zzjd2, zzhr zzhr2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzjd2.zzb(n10, list, zzhr2);
        }
    }

    public static void zzb(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzf(n10, list, bl2);
        }
    }

    public static int zzc(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzht.zzc(list);
        n10 = zzfc.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzc(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzgp;
        if (n12 != 0) {
            list = (zzgp)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzgp)list).zza(n10);
                int n13 = zzfc.zzf(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzfc.zzf(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzij zzc() {
        return zzd;
    }

    public static void zzc(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzc(n10, list, bl2);
        }
    }

    public static int zzd(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzht.zzd(list);
        n10 = zzfc.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzd(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzft;
        if (n12 != 0) {
            list = (zzft)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzfc.zzk(((zzft)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzfc.zzk(n14);
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

    public static void zzd(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzd(n10, list, bl2);
        }
    }

    public static int zze(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzht.zze(list);
        n10 = zzfc.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zze(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzft;
        if (n12 != 0) {
            list = (zzft)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzfc.zzf(((zzft)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzfc.zzf(n14);
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

    public static void zze(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzn(n10, list, bl2);
        }
    }

    public static int zzf(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzht.zzf(list);
        n10 = zzfc.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzf(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzft;
        if (n12 != 0) {
            list = (zzft)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzfc.zzg(((zzft)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzfc.zzg(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzf(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zze(n10, list, bl2);
        }
    }

    public static int zzg(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzht.zzg(list);
        n10 = zzfc.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzg(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzft;
        if (n12 != 0) {
            list = (zzft)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzfc.zzh(((zzft)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzfc.zzh(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzg(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzl(n10, list, bl2);
        }
    }

    public static int zzh(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzfc.zzi(n10, 0);
        return n11 * n10;
    }

    public static int zzh(List list) {
        return list.size() << 2;
    }

    public static void zzh(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zza(n10, list, bl2);
        }
    }

    public static int zzi(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzfc.zzg(n10, 0L);
        return n11 * n10;
    }

    public static int zzi(List list) {
        return list.size() << 3;
    }

    public static void zzi(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzj(n10, list, bl2);
        }
    }

    public static int zzj(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzfc.zzb(n10, true);
        return n11 * n10;
    }

    public static int zzj(List list) {
        return list.size();
    }

    public static void zzj(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzm(n10, list, bl2);
        }
    }

    public static void zzk(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzb(n10, list, bl2);
        }
    }

    public static void zzl(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzk(n10, list, bl2);
        }
    }

    public static void zzm(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzh(n10, list, bl2);
        }
    }

    public static void zzn(int n10, List list, zzjd zzjd2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjd2.zzi(n10, list, bl2);
        }
    }
}

