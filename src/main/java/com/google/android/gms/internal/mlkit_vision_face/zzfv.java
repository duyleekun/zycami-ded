/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfq;
import com.google.android.gms.internal.mlkit_vision_face.zzfx;
import com.google.android.gms.internal.mlkit_vision_face.zzfy;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgg;
import com.google.android.gms.internal.mlkit_vision_face.zzgq;
import com.google.android.gms.internal.mlkit_vision_face.zzgr;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzho;
import com.google.android.gms.internal.mlkit_vision_face.zzhr;
import com.google.android.gms.internal.mlkit_vision_face.zzig;
import com.google.android.gms.internal.mlkit_vision_face.zzjh;
import com.google.android.gms.internal.mlkit_vision_face.zzjo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzfv {
    private static final zzfv zzd;
    public final zzig zza;
    private boolean zzb;
    private boolean zzc;

    static {
        zzfv zzfv2;
        zzd = zzfv2 = new zzfv(true);
    }

    private zzfv() {
        zzig zzig2;
        this.zza = zzig2 = zzig.zza(16);
    }

    private zzfv(zzig zzig2) {
        this.zza = zzig2;
        this.zzb();
    }

    private zzfv(boolean bl2) {
        zzig zzig2 = zzig.zza(0);
        this(zzig2);
        this.zzb();
    }

    public static int zza(zzfx iterator2, Object object) {
        zzjh zzjh2 = iterator2.zzb();
        int n10 = iterator2.zza();
        int n11 = (int)(iterator2.zzd() ? 1 : 0);
        if (n11 != 0) {
            int n12;
            int n13 = iterator2.zze();
            n11 = 0;
            if (n13 != 0) {
                int n14;
                object = (List)object;
                iterator2 = object.iterator();
                while ((n14 = iterator2.hasNext()) != 0) {
                    object = iterator2.next();
                    n14 = zzfv.zzb(zzjh2, object);
                    n11 += n14;
                }
                n13 = zzfq.zze(n10) + n11;
                n14 = zzfq.zzl(n11);
                return n13 + n14;
            }
            object = (List)object;
            iterator2 = object.iterator();
            while ((n12 = iterator2.hasNext()) != 0) {
                object = iterator2.next();
                n12 = zzfv.zza(zzjh2, n10, object);
                n11 += n12;
            }
            return n11;
        }
        return zzfv.zza(zzjh2, n10, object);
    }

    public static int zza(zzjh zzjh2, int n10, Object object) {
        n10 = zzfq.zze(n10);
        Object object2 = zzjh.zzj;
        if (zzjh2 == object2) {
            object2 = object;
            object2 = (zzhl)object;
            zzgg.zza((zzhl)object2);
            n10 <<= 1;
        }
        int n11 = zzfv.zzb(zzjh2, object);
        return n10 + n11;
    }

    public static zzfv zza() {
        return zzd;
    }

    private final Object zza(zzfx object) {
        zzig zzig2 = this.zza;
        boolean bl2 = (object = zzig2.get(object)) instanceof zzgq;
        if (bl2) {
            object = (zzgq)object;
            object = zzgq.zza();
        }
        return object;
    }

    private static Object zza(Object object) {
        boolean bl2 = object instanceof zzhr;
        if (bl2) {
            return ((zzhr)object).zza();
        }
        bl2 = object instanceof byte[];
        if (bl2) {
            object = (byte[])object;
            byte[] byArray = new byte[((Object)object).length];
            int n10 = ((Object)object).length;
            System.arraycopy(object, 0, byArray, 0, n10);
            return byArray;
        }
        return object;
    }

    public static void zza(zzfq zzfq2, zzjh zzjh2, int n10, Object object) {
        zzjh zzjh3 = zzjh.zzj;
        if (zzjh2 == zzjh3) {
            object = (zzhl)object;
            zzgg.zza((zzhl)object);
            zzfq2.zza(n10, 3);
            object.zza(zzfq2);
            zzfq2.zza(n10, 4);
            return;
        }
        int n11 = zzjh2.zzb();
        zzfq2.zza(n10, n11);
        int[] nArray = zzfy.zzb;
        int n12 = zzjh2.ordinal();
        n12 = nArray[n12];
        switch (n12) {
            default: {
                break;
            }
            case 18: {
                n12 = object instanceof zzgf;
                if (n12 != 0) {
                    n12 = ((zzgf)object).zza();
                    zzfq2.zza(n12);
                    return;
                }
                object = (Integer)object;
                n12 = (Integer)object;
                zzfq2.zza(n12);
                break;
            }
            case 17: {
                long l10 = (Long)object;
                zzfq2.zzb(l10);
                return;
            }
            case 16: {
                n12 = (Integer)object;
                zzfq2.zzc(n12);
                return;
            }
            case 15: {
                long l11 = (Long)object;
                zzfq2.zzc(l11);
                return;
            }
            case 14: {
                n12 = (Integer)object;
                zzfq2.zzd(n12);
                return;
            }
            case 13: {
                n12 = (Integer)object;
                zzfq2.zzb(n12);
                return;
            }
            case 12: {
                n12 = object instanceof zzez;
                if (n12 != 0) {
                    object = (zzez)object;
                    zzfq2.zza((zzez)object);
                    return;
                }
                object = (byte[])object;
                n10 = ((Object)object).length;
                zzfq2.zzb((byte[])object, 0, n10);
                return;
            }
            case 11: {
                n12 = object instanceof zzez;
                if (n12 != 0) {
                    object = (zzez)object;
                    zzfq2.zza((zzez)object);
                    return;
                }
                object = (String)object;
                zzfq2.zza((String)object);
                return;
            }
            case 10: {
                object = (zzhl)object;
                zzfq2.zza((zzhl)object);
                return;
            }
            case 9: {
                ((zzhl)object).zza(zzfq2);
                return;
            }
            case 8: {
                n12 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                zzfq2.zza(n12 != 0);
                return;
            }
            case 7: {
                n12 = (Integer)object;
                zzfq2.zzd(n12);
                return;
            }
            case 6: {
                long l12 = (Long)object;
                zzfq2.zzc(l12);
                return;
            }
            case 5: {
                n12 = (Integer)object;
                zzfq2.zza(n12);
                return;
            }
            case 4: {
                long l13 = (Long)object;
                zzfq2.zza(l13);
                return;
            }
            case 3: {
                long l14 = (Long)object;
                zzfq2.zza(l14);
                return;
            }
            case 2: {
                float f10 = ((Float)object).floatValue();
                zzfq2.zza(f10);
                return;
            }
            case 1: {
                object = (Double)object;
                double d10 = (Double)object;
                zzfq2.zza(d10);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(zzjh var0, Object var1_1) {
        zzgg.zza(var1_1);
        var2_2 = zzfy.zza;
        var0 = var0.zza();
        var3_3 = var0.ordinal();
        var3_3 = var2_2[var3_3];
        var4_4 = true;
        switch (var3_3) lbl-1000:
        // 4 sources

        {
            default: {
                var4_4 = false;
                var2_2 = null;
                break;
            }
            case 9: {
                var3_3 = var1_1 instanceof zzhl;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzgq) == 0) ** GOTO lbl-1000
                break;
            }
            case 8: {
                var3_3 = var1_1 instanceof Integer;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzgf) == 0) ** GOTO lbl-1000
                break;
            }
            case 7: {
                var3_3 = var1_1 instanceof zzez;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof byte[]) == 0) ** GOTO lbl-1000
                break;
            }
            case 6: {
                var4_4 = var1_1 instanceof String;
                break;
            }
            case 5: {
                var4_4 = var1_1 instanceof Boolean;
                break;
            }
            case 4: {
                var4_4 = var1_1 instanceof Double;
                break;
            }
            case 3: {
                var4_4 = var1_1 instanceof Float;
                break;
            }
            case 2: {
                var4_4 = var1_1 instanceof Long;
                break;
            }
            case 1: {
                var4_4 = var1_1 instanceof Integer;
            }
        }
        if (var4_4) {
            return;
        }
        var0 = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        throw var0;
    }

    private static boolean zza(Map.Entry object) {
        Object object2 = (zzfx)object.getKey();
        zzjo zzjo2 = object2.zzc();
        zzjo zzjo3 = zzjo.zzi;
        boolean bl2 = true;
        if (zzjo2 == zzjo3) {
            boolean bl3 = object2.zzd();
            zzjo2 = null;
            if (bl3) {
                object = ((List)object.getValue()).iterator();
                while (bl3 = object.hasNext()) {
                    object2 = (zzhl)object.next();
                    bl3 = object2.a_();
                    if (bl3) continue;
                    return false;
                }
            } else {
                bl3 = (object = object.getValue()) instanceof zzhl;
                if (bl3) {
                    boolean bl4 = (object = (zzhl)object).a_();
                    if (!bl4) {
                        return false;
                    }
                } else {
                    boolean bl5 = object instanceof zzgq;
                    if (bl5) {
                        return bl2;
                    }
                    object = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                    throw object;
                }
            }
        }
        return bl2;
    }

    private static int zzb(zzjh object, Object object2) {
        int[] nArray = zzfy.zzb;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw object;
            }
            case 18: {
                n10 = object2 instanceof zzgf;
                if (n10 != 0) {
                    return zzfq.zzk(((zzgf)object2).zza());
                }
                return zzfq.zzk((Integer)object2);
            }
            case 17: {
                return zzfq.zzf((Long)object2);
            }
            case 16: {
                return zzfq.zzh((Integer)object2);
            }
            case 15: {
                return zzfq.zzh((Long)object2);
            }
            case 14: {
                return zzfq.zzj((Integer)object2);
            }
            case 13: {
                return zzfq.zzg((Integer)object2);
            }
            case 12: {
                n10 = object2 instanceof zzez;
                if (n10 != 0) {
                    return zzfq.zzb((zzez)object2);
                }
                return zzfq.zzb((byte[])object2);
            }
            case 11: {
                n10 = object2 instanceof zzez;
                if (n10 != 0) {
                    return zzfq.zzb((zzez)object2);
                }
                return zzfq.zzb((String)object2);
            }
            case 10: {
                n10 = object2 instanceof zzgq;
                if (n10 != 0) {
                    return zzfq.zza((zzgq)object2);
                }
                return zzfq.zzb((zzhl)object2);
            }
            case 9: {
                return zzfq.zzc((zzhl)object2);
            }
            case 8: {
                return zzfq.zzb((Boolean)object2);
            }
            case 7: {
                return zzfq.zzi((Integer)object2);
            }
            case 6: {
                return zzfq.zzg((Long)object2);
            }
            case 5: {
                return zzfq.zzf((Integer)object2);
            }
            case 4: {
                return zzfq.zze((Long)object2);
            }
            case 3: {
                return zzfq.zzd((Long)object2);
            }
            case 2: {
                return zzfq.zzb(((Float)object2).floatValue());
            }
            case 1: 
        }
        return zzfq.zzb((Double)object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void zzb(zzfx object, Object list) {
        boolean bl2 = object.zzd();
        if (bl2) {
            bl2 = list instanceof List;
            if (!bl2) {
                object = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                throw object;
            }
            ArrayList arrayList = new ArrayList();
            list = list;
            arrayList.addAll(list);
            int n10 = arrayList.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Object e10 = arrayList.get(i10);
                zzjh zzjh2 = object.zzb();
                zzfv.zza(zzjh2, e10);
            }
            list = arrayList;
        } else {
            zzjh zzjh3 = object.zzb();
            zzfv.zza(zzjh3, list);
        }
        bl2 = list instanceof zzgq;
        if (bl2) {
            this.zzc = bl2 = true;
        }
        this.zza.zza((Comparable)object, list);
    }

    private final void zzb(Map.Entry object) {
        zzjo zzjo2;
        zzfx zzfx2 = (zzfx)object.getKey();
        boolean bl2 = (object = object.getValue()) instanceof zzgq;
        if (bl2) {
            object = (zzgq)object;
            object = zzgq.zza();
        }
        if (bl2 = zzfx2.zzd()) {
            boolean bl3;
            ArrayList arrayList = this.zza(zzfx2);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            object = ((List)object).iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                List list = arrayList;
                list = arrayList;
                object2 = zzfv.zza(object2);
                list.add(object2);
            }
            this.zza.zza(zzfx2, arrayList);
            return;
        }
        Object object3 = zzfx2.zzc();
        if (object3 == (zzjo2 = zzjo.zzi)) {
            object3 = this.zza(zzfx2);
            if (object3 == null) {
                object3 = this.zza;
                object = zzfv.zza(object);
                ((zzig)object3).zza(zzfx2, object);
                return;
            }
            boolean bl4 = object3 instanceof zzhr;
            if (bl4) {
                object3 = (zzhr)object3;
                object = (zzhr)object;
                object = zzfx2.zza((zzhr)object3, (zzhr)object);
            } else {
                object3 = ((zzhl)object3).zzm();
                object = (zzhl)object;
                object = zzfx2.zza((zzho)object3, (zzhl)object).zzh();
            }
            this.zza.zza(zzfx2, object);
            return;
        }
        object3 = this.zza;
        object = zzfv.zza(object);
        ((zzig)object3).zza(zzfx2, object);
    }

    private static int zzc(Map.Entry entry) {
        boolean bl2;
        zzjo zzjo2;
        zzfx zzfx2 = (zzfx)entry.getKey();
        Object object = entry.getValue();
        zzjo zzjo3 = zzfx2.zzc();
        if (zzjo3 == (zzjo2 = zzjo.zzi) && !(bl2 = zzfx2.zzd()) && !(bl2 = zzfx2.zze())) {
            boolean bl3 = object instanceof zzgq;
            if (bl3) {
                int n10 = ((zzfx)entry.getKey()).zza();
                object = (zzgq)object;
                return zzfq.zzb(n10, object);
            }
            int n11 = ((zzfx)entry.getKey()).zza();
            object = (zzhl)object;
            return zzfq.zzb(n11, object);
        }
        return zzfv.zza(zzfx2, object);
    }

    public final /* synthetic */ Object clone() {
        zzfx zzfx2;
        Object object;
        int n10;
        int n11;
        zzfv zzfv2 = new zzfv();
        Iterator iterator2 = null;
        for (n11 = 0; n11 < (n10 = ((zzig)(object = this.zza)).zzc()); ++n11) {
            object = this.zza.zzb(n11);
            zzfx2 = (zzfx)object.getKey();
            object = object.getValue();
            zzfv2.zzb(zzfx2, object);
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            zzfx2 = (zzfx)object.getKey();
            object = object.getValue();
            zzfv2.zzb(zzfx2, object);
        }
        n11 = (int)(this.zzc ? 1 : 0);
        zzfv2.zzc = n11;
        return zzfv2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzfv;
        if (!bl2) {
            return false;
        }
        object = (zzfv)object;
        zzig zzig2 = this.zza;
        object = ((zzfv)object).zza;
        return zzig2.equals(object);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(zzfv object) {
        Object object2;
        int n10;
        int n11;
        Map.Entry entry = null;
        for (n11 = 0; n11 < (n10 = ((zzig)(object2 = ((zzfv)object).zza)).zzc()); ++n11) {
            object2 = ((zzfv)object).zza.zzb(n11);
            this.zzb((Map.Entry)object2);
        }
        object = ((zzfv)object).zza.zzd().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            entry = (Map.Entry)object.next();
            this.zzb(entry);
        }
    }

    public final void zzb() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final Iterator zzd() {
        boolean bl2 = this.zzc;
        if (bl2) {
            Iterator iterator2 = this.zza.entrySet().iterator();
            zzgr zzgr2 = new zzgr(iterator2);
            return zzgr2;
        }
        return this.zza.entrySet().iterator();
    }

    public final Iterator zze() {
        boolean bl2 = this.zzc;
        if (bl2) {
            Iterator iterator2 = this.zza.zze().iterator();
            zzgr zzgr2 = new zzgr(iterator2);
            return zzgr2;
        }
        return this.zza.zze().iterator();
    }

    public final boolean zzf() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        for (int i10 = 0; i10 < (n10 = ((zzig)(object = this.zza)).zzc()); ++i10) {
            object = this.zza.zzb(i10);
            n10 = (int)(zzfv.zza((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = (int)(zzfv.zza((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public final int zzg() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = ((zzig)(object = this.zza)).zzc()); ++i10) {
            object = this.zza.zzb(i10);
            n10 = zzfv.zzc((Map.Entry)object);
            n11 += n10;
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = zzfv.zzc((Map.Entry)object);
            n11 += n10;
        }
        return n11;
    }
}

