/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzhq;
import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzif;
import com.google.android.gms.internal.vision.zzij;
import com.google.android.gms.internal.vision.zzis;
import com.google.android.gms.internal.vision.zziu;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzjg;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzkg;
import com.google.android.gms.internal.vision.zzkx;
import com.google.android.gms.internal.vision.zzkz;
import com.google.android.gms.internal.vision.zzld;
import com.google.android.gms.internal.vision.zzlq;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.List;
import java.util.RandomAccess;

public final class zzkh {
    private static final Class zzabq = zzkh.zziv();
    private static final zzkx zzabr = zzkh.zzn(false);
    private static final zzkx zzabs = zzkh.zzn(true);
    private static final zzkx zzabt;

    static {
        zzkz zzkz2 = new zzkz();
        zzabt = zzkz2;
    }

    public static Object zza(int n10, int n11, Object object, zzkx zzkx2) {
        if (object == null) {
            object = zzkx2.zzjd();
        }
        long l10 = n11;
        zzkx2.zza(object, n10, l10);
        return object;
    }

    public static Object zza(int n10, List object, zzij zzij2, Object object2, zzkx zzkx2) {
        if (zzij2 == null) {
            return object2;
        }
        int n11 = object instanceof RandomAccess;
        if (n11 != 0) {
            n11 = object.size();
            int n12 = 0;
            for (int i10 = 0; i10 < n11; ++i10) {
                Integer n13 = (Integer)((List)object).get(i10);
                int n14 = n13;
                boolean bl2 = zzij2.zzg(n14);
                if (bl2) {
                    if (i10 != n12) {
                        n13 = n14;
                        ((List)object).set(n12, n13);
                    }
                    ++n12;
                    continue;
                }
                object2 = zzkh.zza(n10, n14, object2, zzkx2);
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
                boolean bl3 = zzij2.zzg(n11);
                if (bl3) continue;
                object2 = zzkh.zza(n10, n11, object2, zzkx2);
                object.remove();
            }
        }
        return object2;
    }

    public static void zza(int n10, List list, zzlq zzlq2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzlq2.zza(n10, list);
        }
    }

    public static void zza(int n10, List list, zzlq zzlq2, zzkf zzkf2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzlq2.zza(n10, list, zzkf2);
        }
    }

    public static void zza(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzg(n10, list, bl2);
        }
    }

    public static void zza(zzhq object, Object object2, Object object3) {
        object3 = ((zzhq)object).zzh(object3);
        zzkg zzkg2 = ((zzht)object3).zzux;
        boolean bl2 = zzkg2.isEmpty();
        if (!bl2) {
            object = ((zzhq)object).zzi(object2);
            ((zzht)object).zza((zzht)object3);
        }
    }

    public static void zza(zzjg object, Object object2, Object object3, long l10) {
        Object object4 = zzld.zzp(object2, l10);
        object3 = zzld.zzp(object3, l10);
        object = object.zzc(object4, object3);
        zzld.zza(object2, l10, object);
    }

    public static void zza(zzkx zzkx2, Object object, Object object2) {
        Object object3 = zzkx2.zzy(object);
        object2 = zzkx2.zzy(object2);
        object2 = zzkx2.zzh(object3, object2);
        zzkx2.zzf(object, object2);
    }

    public static void zzb(int n10, List list, zzlq zzlq2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzlq2.zzb(n10, list);
        }
    }

    public static void zzb(int n10, List list, zzlq zzlq2, zzkf zzkf2) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            zzlq2.zzb(n10, list, zzkf2);
        }
    }

    public static void zzb(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzf(n10, list, bl2);
        }
    }

    public static int zzc(int n10, Object object, zzkf zzkf2) {
        boolean bl2 = object instanceof zzis;
        if (bl2) {
            object = (zzis)object;
            return zzhl.zza(n10, (zzis)object);
        }
        object = (zzjn)object;
        return zzhl.zzb(n10, (zzjn)object, zzkf2);
    }

    public static int zzc(int n10, List list) {
        int n11;
        int n12 = list.size();
        if (n12 == 0) {
            return 0;
        }
        n10 = zzhl.zzbh(n10) * n12;
        int n13 = list instanceof zziu;
        if (n13 != 0) {
            list = (zziu)list;
            for (n11 = 0; n11 < n12; ++n11) {
                Object object = list.zzbt(n11);
                boolean bl2 = object instanceof zzgs;
                if (bl2) {
                    object = (zzgs)object;
                    n13 = zzhl.zzb((zzgs)object);
                } else {
                    object = (String)object;
                    n13 = zzhl.zzx((String)object);
                }
                n10 += n13;
            }
        } else {
            while (n11 < n12) {
                Object object = list.get(n11);
                boolean bl3 = object instanceof zzgs;
                if (bl3) {
                    object = (zzgs)object;
                    n13 = zzhl.zzb(object);
                } else {
                    object = (String)object;
                    n13 = zzhl.zzx(object);
                }
                n10 += n13;
                ++n11;
            }
        }
        return n10;
    }

    public static int zzc(int n10, List list, zzkf zzkf2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzhl.zzbh(n10) * n11;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = list.get(i10);
            boolean bl2 = object instanceof zzis;
            if (bl2) {
                object = (zzis)object;
                n12 = zzhl.zza(object);
            } else {
                object = (zzjn)object;
                n12 = zzhl.zza(object, zzkf2);
            }
            n10 += n12;
        }
        return n10;
    }

    public static void zzc(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzc(n10, list, bl2);
        }
    }

    public static int zzd(int n10, List list) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzhl.zzbh(n10);
        n11 *= n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            zzgs zzgs2 = (zzgs)list.get(i10);
            n10 = zzhl.zzb(zzgs2);
            n11 += n10;
        }
        return n11;
    }

    public static int zzd(int n10, List list, zzkf zzkf2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            zzjn zzjn2 = (zzjn)list.get(i10);
            int n13 = zzhl.zzc(n10, zzjn2, zzkf2);
            n12 += n13;
        }
        return n12;
    }

    public static void zzd(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzd(n10, list, bl2);
        }
    }

    public static void zze(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzn(n10, list, bl2);
        }
    }

    public static boolean zze(Object object, Object object2) {
        boolean bl2;
        return object == object2 || object != null && (bl2 = object.equals(object2));
        {
        }
    }

    public static void zzf(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zze(n10, list, bl2);
        }
    }

    public static void zzg(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzl(n10, list, bl2);
        }
    }

    public static void zzg(Class serializable) {
        boolean bl2;
        Class clazz = zzid.class;
        boolean bl3 = clazz.isAssignableFrom((Class<?>)serializable);
        if (!bl3 && (clazz = zzabq) != null && !(bl2 = clazz.isAssignableFrom((Class<?>)serializable))) {
            serializable = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            throw serializable;
        }
    }

    public static void zzh(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zza(n10, list, bl2);
        }
    }

    public static void zzi(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzj(n10, list, bl2);
        }
    }

    public static zzkx zzis() {
        return zzabr;
    }

    public static zzkx zzit() {
        return zzabs;
    }

    public static zzkx zziu() {
        return zzabt;
    }

    private static Class zziv() {
        String string2 = "com.google.protobuf.GeneratedMessage";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Class zziw() {
        String string2 = "com.google.protobuf.UnknownFieldSetSchema";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static void zzj(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzm(n10, list, bl2);
        }
    }

    public static void zzk(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzb(n10, list, bl2);
        }
    }

    public static void zzl(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzk(n10, list, bl2);
        }
    }

    public static void zzm(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzh(n10, list, bl2);
        }
    }

    private static zzkx zzn(boolean bl2) {
        int n10;
        GenericDeclaration genericDeclaration;
        try {
            genericDeclaration = zzkh.zziw();
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
        return (zzkx)((Object)bl3);
    }

    public static void zzn(int n10, List list, zzlq zzlq2, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            zzlq2.zzi(n10, list, bl2);
        }
    }

    public static int zzo(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzkh.zzq(list);
        int n13 = list.size();
        n10 = zzhl.zzbh(n10);
        return n12 + (n13 *= n10);
    }

    public static int zzp(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzkh.zzr(list);
        n10 = zzhl.zzbh(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzq(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzkh.zzs(list);
        n10 = zzhl.zzbh(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzq(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzjb;
        if (n12 != 0) {
            list = (zzjb)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzjb)list).getLong(n10);
                int n13 = zzhl.zzv(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzhl.zzv(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzr(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzkh.zzt(list);
        n10 = zzhl.zzbh(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzr(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzjb;
        if (n12 != 0) {
            list = (zzjb)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzjb)list).getLong(n10);
                int n13 = zzhl.zzw(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzhl.zzw(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzs(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzkh.zzu(list);
        n10 = zzhl.zzbh(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzs(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzjb;
        if (n12 != 0) {
            list = (zzjb)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((zzjb)list).getLong(n10);
                int n13 = zzhl.zzx(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = zzhl.zzx(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzt(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzkh.zzv(list);
        n10 = zzhl.zzbh(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzt(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzif;
        if (n12 != 0) {
            list = (zzif)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzhl.zzbn(((zzif)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzhl.zzbn(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzu(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = zzkh.zzw(list);
        n10 = zzhl.zzbh(n10);
        int n13 = n11 * n10;
        return n12 + n13;
    }

    public static int zzu(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzif;
        if (n12 != 0) {
            list = (zzif)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzhl.zzbi(((zzif)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzhl.zzbi(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzv(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzhl.zzq(n10, 0);
        return n11 * n10;
    }

    public static int zzv(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzif;
        if (n12 != 0) {
            list = (zzif)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzhl.zzbj(((zzif)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzhl.zzbj(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzw(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzhl.zzg(n10, 0L);
        return n11 * n10;
    }

    public static int zzw(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof zzif;
        if (n12 != 0) {
            list = (zzif)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = zzhl.zzbk(((zzif)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = zzhl.zzbk(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int zzx(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = zzhl.zzb(n10, true);
        return n11 * n10;
    }

    public static int zzx(List list) {
        return list.size() << 2;
    }

    public static int zzy(List list) {
        return list.size() << 3;
    }

    public static int zzz(List list) {
        return list.size();
    }
}

