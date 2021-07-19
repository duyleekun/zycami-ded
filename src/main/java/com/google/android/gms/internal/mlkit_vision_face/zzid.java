/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfq;
import com.google.android.gms.internal.mlkit_vision_face.zzfu;
import com.google.android.gms.internal.mlkit_vision_face.zzfv;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzge;
import com.google.android.gms.internal.mlkit_vision_face.zzgu;
import com.google.android.gms.internal.mlkit_vision_face.zzgw;
import com.google.android.gms.internal.mlkit_vision_face.zzgz;
import com.google.android.gms.internal.mlkit_vision_face.zzhi;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzib;
import com.google.android.gms.internal.mlkit_vision_face.zzig;
import com.google.android.gms.internal.mlkit_vision_face.zzit;
import com.google.android.gms.internal.mlkit_vision_face.zziv;
import com.google.android.gms.internal.mlkit_vision_face.zziz;
import com.google.android.gms.internal.mlkit_vision_face.zzjn;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.List;

public final class zzid {
    private static final Class zza = zzid.zzd();
    private static final zzit zzb = zzid.zza(false);
    private static final zzit zzc = zzid.zza(true);
    private static final zzit zzd;

    static {
        zziv zziv2 = new zziv();
        zzd = zziv2;
    }

    public static int zza(int n10, Object object, zzib zzib2) {
        boolean bl2 = object instanceof zzgu;
        if (bl2) {
            object = (zzgu)object;
            return zzfq.zza(n10, (zzgu)object);
        }
        object = (zzhl)object;
        return zzfq.zzb(n10, (zzhl)object, zzib2);
    }

    public static int zza(int n10, List list) {
        int n11;
        int n12 = list.size();
        if (n12 == 0) {
            return 0;
        }
        n10 = zzfq.zze(n10) * n12;
        int n13 = list instanceof zzgw;
        if (n13 != 0) {
            list = (zzgw)list;
            for (n11 = 0; n11 < n12; ++n11) {
                Object object = list.zza(n11);
                boolean bl2 = object instanceof zzez;
                if (bl2) {
                    object = (zzez)object;
                    n13 = zzfq.zzb((zzez)object);
                } else {
                    object = (String)object;
                    n13 = zzfq.zzb((String)object);
                }
                n10 += n13;
            }
        } else {
            while (n11 < n12) {
                Object object = list.get(n11);
                boolean bl3 = object instanceof zzez;
                if (bl3) {
                    object = (zzez)object;
                    n13 = zzfq.zzb(object);
                } else {
                    object = (String)object;
                    n13 = zzfq.zzb(object);
                }
                n10 += n13;
                ++n11;
            }
        }
        return n10;
    }

    public static int zza(int n10, List list, zzib zzib2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzfq.zze(n10) * n11;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = list.get(i10);
            boolean bl2 = object instanceof zzgu;
            if (bl2) {
                object = (zzgu)object;
                n12 = zzfq.zza(object);
            } else {
                object = (zzhl)object;
                n12 = zzfq.zza(object, zzib2);
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
        int n12 = zzid.zza(list);
        int n13 = list.size();
        n10 = zzfq.zze(n10);
        return n12 + (n13 *= n10);
    }

    public static int zza(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzgz;
        if (n12 != 0) {
            list = (zzgz)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzgz)list).zza(n10);
                int n13 = zzfq.zzd(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzfq.zzd(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzit zza() {
        return zzb;
    }

    private static zzit zza(boolean bl2) {
        int n10;
        GenericDeclaration genericDeclaration;
        try {
            genericDeclaration = zzid.zze();
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
        return (zzit)((Object)bl3);
    }

    public static void zza(int n10, List list, zzjn zzjn2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzjn2.zza(n10, list);
        }
    }

    public static void zza(int n10, List list, zzjn zzjn2, zzib zzib2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzjn2.zza(n10, list, zzib2);
        }
    }

    public static void zza(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzg(n10, list, bl2);
        }
    }

    public static void zza(zzfu object, Object object2, Object object3) {
        object3 = ((zzfu)object).zza(object3);
        zzig zzig2 = ((zzfv)object3).zza;
        boolean bl2 = zzig2.isEmpty();
        if (!bl2) {
            object = ((zzfu)object).zzb(object2);
            ((zzfv)object).zza((zzfv)object3);
        }
    }

    public static void zza(zzhi object, Object object2, Object object3, long l10) {
        Object object4 = zziz.zzf(object2, l10);
        object3 = zziz.zzf(object3, l10);
        object = object.zza(object4, object3);
        zziz.zza(object2, l10, object);
    }

    public static void zza(zzit zzit2, Object object, Object object2) {
        Object object3 = zzit2.zza(object);
        object2 = zzit2.zza(object2);
        object2 = zzit2.zzb(object3, object2);
        zzit2.zza(object, object2);
    }

    public static void zza(Class serializable) {
        boolean bl2;
        Class clazz = zzgd.class;
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
        n10 = zzfq.zze(n10);
        n11 *= n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            zzez zzez2 = (zzez)list.get(i10);
            n10 = zzfq.zzb(zzez2);
            n11 += n10;
        }
        return n11;
    }

    public static int zzb(int n10, List list, zzib zzib2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            zzhl zzhl2 = (zzhl)list.get(i10);
            int n13 = zzfq.zzc(n10, zzhl2, zzib2);
            n12 += n13;
        }
        return n12;
    }

    public static int zzb(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzid.zzb(list);
        n10 = zzfq.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzb(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzgz;
        if (n12 != 0) {
            list = (zzgz)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzgz)list).zza(n10);
                int n13 = zzfq.zze(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzfq.zze(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzit zzb() {
        return zzc;
    }

    public static void zzb(int n10, List list, zzjn zzjn2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzjn2.zzb(n10, list);
        }
    }

    public static void zzb(int n10, List list, zzjn zzjn2, zzib zzib2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzjn2.zzb(n10, list, zzib2);
        }
    }

    public static void zzb(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzf(n10, list, bl2);
        }
    }

    public static int zzc(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzid.zzc(list);
        n10 = zzfq.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzc(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzgz;
        if (n12 != 0) {
            list = (zzgz)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzgz)list).zza(n10);
                int n13 = zzfq.zzf(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzfq.zzf(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static zzit zzc() {
        return zzd;
    }

    public static void zzc(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzc(n10, list, bl2);
        }
    }

    public static int zzd(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzid.zzd(list);
        n10 = zzfq.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzd(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzge;
        if (n12 != 0) {
            list = (zzge)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzfq.zzk(((zzge)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzfq.zzk(n14);
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

    public static void zzd(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzd(n10, list, bl2);
        }
    }

    public static int zze(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzid.zze(list);
        n10 = zzfq.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zze(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzge;
        if (n12 != 0) {
            list = (zzge)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzfq.zzf(((zzge)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzfq.zzf(n14);
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

    public static void zze(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzn(n10, list, bl2);
        }
    }

    public static int zzf(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzid.zzf(list);
        n10 = zzfq.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzf(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzge;
        if (n12 != 0) {
            list = (zzge)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzfq.zzg(((zzge)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzfq.zzg(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzf(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zze(n10, list, bl2);
        }
    }

    public static int zzg(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzid.zzg(list);
        n10 = zzfq.zze(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzg(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzge;
        if (n12 != 0) {
            list = (zzge)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzfq.zzh(((zzge)list).zza(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzfq.zzh(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzg(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzl(n10, list, bl2);
        }
    }

    public static int zzh(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzfq.zzi(n10, 0);
        return n11 * n10;
    }

    public static int zzh(List list) {
        return list.size() << 2;
    }

    public static void zzh(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zza(n10, list, bl2);
        }
    }

    public static int zzi(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzfq.zzg(n10, 0L);
        return n11 * n10;
    }

    public static int zzi(List list) {
        return list.size() << 3;
    }

    public static void zzi(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzj(n10, list, bl2);
        }
    }

    public static int zzj(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzfq.zzb(n10, true);
        return n11 * n10;
    }

    public static int zzj(List list) {
        return list.size();
    }

    public static void zzj(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzm(n10, list, bl2);
        }
    }

    public static void zzk(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzb(n10, list, bl2);
        }
    }

    public static void zzl(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzk(n10, list, bl2);
        }
    }

    public static void zzm(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzh(n10, list, bl2);
        }
    }

    public static void zzn(int n10, List list, zzjn zzjn2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzjn2.zzi(n10, list, bl2);
        }
    }
}

