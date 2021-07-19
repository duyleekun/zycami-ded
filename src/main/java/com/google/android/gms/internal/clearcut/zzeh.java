/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzbu;
import com.google.android.gms.internal.clearcut.zzby;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzch;
import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzcv;
import com.google.android.gms.internal.clearcut.zzcx;
import com.google.android.gms.internal.clearcut.zzdc;
import com.google.android.gms.internal.clearcut.zzdj;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzef;
import com.google.android.gms.internal.clearcut.zzex;
import com.google.android.gms.internal.clearcut.zzez;
import com.google.android.gms.internal.clearcut.zzfd;
import com.google.android.gms.internal.clearcut.zzfr;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.List;
import java.util.RandomAccess;

public final class zzeh {
    private static final Class zzoh = zzeh.zzdp();
    private static final zzex zzoi = zzeh.zzd(false);
    private static final zzex zzoj = zzeh.zzd(true);
    private static final zzex zzok;

    static {
        zzez zzez2 = new zzez();
        zzok = zzez2;
    }

    public static int zza(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzdc;
        if (n12 != 0) {
            list = (zzdc)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzdc)list).getLong(n10);
                int n13 = zzbn.zze(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzbn.zze(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    private static Object zza(int n10, int n11, Object object, zzex zzex2) {
        if (object == null) {
            object = zzex2.zzdz();
        }
        long l10 = n11;
        zzex2.zza(object, n10, l10);
        return object;
    }

    public static Object zza(int n10, List object, zzck zzck2, Object object2, zzex zzex2) {
        if (zzck2 == null) {
            return object2;
        }
        int n11 = object instanceof RandomAccess;
        if (n11 != 0) {
            n11 = object.size();
            Object var7_7 = null;
            int n12 = 0;
            for (int i10 = 0; i10 < n11; ++i10) {
                Integer n13 = (Integer)((List)object).get(i10);
                int n14 = n13;
                zzcj zzcj2 = zzck2.zzb(n14);
                if (zzcj2 != null) {
                    if (i10 != n12) {
                        n13 = n14;
                        ((List)object).set(n12, n13);
                    }
                    ++n12;
                    continue;
                }
                object2 = zzeh.zza(n10, n14, object2, zzex2);
            }
            if (n12 != n11) {
                List list = ((List)object).subList(n12, n11);
                list.clear();
            }
        } else {
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Integer n15 = (Integer)object.next();
                n11 = n15;
                zzcj zzcj3 = zzck2.zzb(n11);
                if (zzcj3 != null) continue;
                object2 = zzeh.zza(n10, n11, object2, zzex2);
                object.remove();
            }
        }
        return object2;
    }

    public static void zza(int n10, List list, zzfr zzfr2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzfr2.zza(n10, list);
        }
    }

    public static void zza(int n10, List list, zzfr zzfr2, zzef zzef2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzfr2.zza(n10, list, zzef2);
        }
    }

    public static void zza(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzg(n10, list, bl2);
        }
    }

    public static void zza(zzbu object, Object object2, Object object3) {
        boolean bl2 = ((zzby)(object3 = ((zzbu)object).zza(object3))).isEmpty();
        if (!bl2) {
            object = ((zzbu)object).zzb(object2);
            ((zzby)object).zza((zzby)object3);
        }
    }

    public static void zza(zzdj object, Object object2, Object object3, long l10) {
        Object object4 = zzfd.zzo(object2, l10);
        object3 = zzfd.zzo(object3, l10);
        object = object.zzb(object4, object3);
        zzfd.zza(object2, l10, object);
    }

    public static void zza(zzex zzex2, Object object, Object object2) {
        Object object3 = zzex2.zzq(object);
        object2 = zzex2.zzq(object2);
        object2 = zzex2.zzg(object3, object2);
        zzex2.zze(object, object2);
    }

    public static int zzb(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzdc;
        if (n12 != 0) {
            list = (zzdc)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzdc)list).getLong(n10);
                int n13 = zzbn.zzf(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzbn.zzf(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzb(int n10, List list, zzfr zzfr2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzfr2.zzb(n10, list);
        }
    }

    public static void zzb(int n10, List list, zzfr zzfr2, zzef zzef2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzfr2.zzb(n10, list, zzef2);
        }
    }

    public static void zzb(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzf(n10, list, bl2);
        }
    }

    public static int zzc(int n10, Object object, zzef zzef2) {
        boolean bl2 = object instanceof zzcv;
        if (bl2) {
            object = (zzcv)object;
            return zzbn.zza(n10, (zzcv)object);
        }
        object = (zzdo)object;
        return zzbn.zzb(n10, (zzdo)object, zzef2);
    }

    public static int zzc(int n10, List list) {
        int n11;
        int n12 = list.size();
        if (n12 == 0) {
            return 0;
        }
        n10 = zzbn.zzr(n10) * n12;
        int n13 = list instanceof zzcx;
        if (n13 != 0) {
            list = (zzcx)list;
            for (n11 = 0; n11 < n12; ++n11) {
                Object object = list.getRaw(n11);
                boolean bl2 = object instanceof zzbb;
                if (bl2) {
                    object = (zzbb)object;
                    n13 = zzbn.zzb((zzbb)object);
                } else {
                    object = (String)object;
                    n13 = zzbn.zzh((String)object);
                }
                n10 += n13;
            }
        } else {
            while (n11 < n12) {
                Object object = list.get(n11);
                boolean bl3 = object instanceof zzbb;
                if (bl3) {
                    object = (zzbb)object;
                    n13 = zzbn.zzb(object);
                } else {
                    object = (String)object;
                    n13 = zzbn.zzh(object);
                }
                n10 += n13;
                ++n11;
            }
        }
        return n10;
    }

    public static int zzc(int n10, List list, zzef zzef2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzbn.zzr(n10) * n11;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = list.get(i10);
            boolean bl2 = object instanceof zzcv;
            if (bl2) {
                object = (zzcv)object;
                n12 = zzbn.zza(object);
            } else {
                object = (zzdo)object;
                n12 = zzbn.zzb(object, zzef2);
            }
            n10 += n12;
        }
        return n10;
    }

    public static int zzc(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzdc;
        if (n12 != 0) {
            list = (zzdc)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzdc)list).getLong(n10);
                int n13 = zzbn.zzg(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzbn.zzg(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzc(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzc(n10, list, bl2);
        }
    }

    public static boolean zzc(int n10, int n11, int n12) {
        boolean bl2 = true;
        int n13 = 40;
        if (n11 < n13) {
            return bl2;
        }
        long l10 = n11;
        long l11 = n10;
        l10 = l10 - l11 + 1L;
        long l12 = n12;
        l11 = (long)2 * l12;
        long l13 = 3;
        l11 += l13;
        l12 += l13;
        long l14 = 9;
        long l15 = (l10 += l14) - (l11 += (l12 *= l13));
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 <= 0) {
            return bl2;
        }
        return false;
    }

    public static int zzd(int n10, List list) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzbn.zzr(n10);
        n11 *= n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            zzbb zzbb2 = (zzbb)list.get(i10);
            n10 = zzbn.zzb(zzbb2);
            n11 += n10;
        }
        return n11;
    }

    public static int zzd(int n10, List list, zzef zzef2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            zzdo zzdo2 = (zzdo)list.get(i10);
            int n13 = zzbn.zzc(n10, zzdo2, zzef2);
            n12 += n13;
        }
        return n12;
    }

    public static int zzd(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzch;
        if (n12 != 0) {
            list = (zzch)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzbn.zzx(((zzch)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzbn.zzx(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    private static zzex zzd(boolean bl2) {
        int n10;
        GenericDeclaration genericDeclaration;
        try {
            genericDeclaration = zzeh.zzdq();
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
        return (zzex)((Object)bl3);
    }

    public static void zzd(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzd(n10, list, bl2);
        }
    }

    public static boolean zzd(Object object, Object object2) {
        boolean bl2;
        return object == object2 || object != null && (bl2 = object.equals(object2));
        {
        }
    }

    public static zzex zzdm() {
        return zzoi;
    }

    public static zzex zzdn() {
        return zzoj;
    }

    public static zzex zzdo() {
        return zzok;
    }

    private static Class zzdp() {
        String string2 = "com.google.protobuf.GeneratedMessage";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Class zzdq() {
        String string2 = "com.google.protobuf.UnknownFieldSetSchema";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static int zze(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzch;
        if (n12 != 0) {
            list = (zzch)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzbn.zzs(((zzch)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzbn.zzs(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zze(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzn(n10, list, bl2);
        }
    }

    public static int zzf(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzch;
        if (n12 != 0) {
            list = (zzch)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzbn.zzt(((zzch)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzbn.zzt(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzf(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zze(n10, list, bl2);
        }
    }

    public static void zzf(Class serializable) {
        boolean bl2;
        Class clazz = zzcg.class;
        boolean bl3 = clazz.isAssignableFrom((Class<?>)serializable);
        if (!bl3 && (clazz = zzoh) != null && !(bl2 = clazz.isAssignableFrom((Class<?>)serializable))) {
            serializable = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            throw serializable;
        }
    }

    public static int zzg(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzch;
        if (n12 != 0) {
            list = (zzch)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzbn.zzu(((zzch)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzbn.zzu(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static void zzg(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzl(n10, list, bl2);
        }
    }

    public static int zzh(List list) {
        return list.size() << 2;
    }

    public static void zzh(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zza(n10, list, bl2);
        }
    }

    public static int zzi(List list) {
        return list.size() << 3;
    }

    public static void zzi(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzj(n10, list, bl2);
        }
    }

    public static int zzj(List list) {
        return list.size();
    }

    public static void zzj(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzm(n10, list, bl2);
        }
    }

    public static void zzk(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzb(n10, list, bl2);
        }
    }

    public static void zzl(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzk(n10, list, bl2);
        }
    }

    public static void zzm(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzh(n10, list, bl2);
        }
    }

    public static void zzn(int n10, List list, zzfr zzfr2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzfr2.zzi(n10, list, bl2);
        }
    }

    public static int zzo(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzeh.zza(list);
        int n13 = list.size();
        n10 = zzbn.zzr(n10);
        return n12 + (n13 *= n10);
    }

    public static int zzp(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzeh.zzb(list);
        n10 = zzbn.zzr(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzq(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzeh.zzc(list);
        n10 = zzbn.zzr(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzr(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzeh.zzd(list);
        n10 = zzbn.zzr(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzs(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzeh.zze(list);
        n10 = zzbn.zzr(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzt(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzeh.zzf(list);
        n10 = zzbn.zzr(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzu(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzeh.zzg(list);
        n10 = zzbn.zzr(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzv(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzbn.zzj(n10, 0);
        return n11 * n10;
    }

    public static int zzw(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzbn.zzg(n10, 0L);
        return n11 * n10;
    }

    public static int zzx(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzbn.zzc(n10, true);
        return n11 * n10;
    }
}

