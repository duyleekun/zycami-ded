/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzbz;
import com.google.android.gms.internal.clearcut.zzca;
import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzcr;
import com.google.android.gms.internal.clearcut.zzcu;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzdp;
import com.google.android.gms.internal.clearcut.zzdv;
import com.google.android.gms.internal.clearcut.zzei;
import com.google.android.gms.internal.clearcut.zzfl;
import com.google.android.gms.internal.clearcut.zzfq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzby {
    private static final zzby zzgw;
    private final zzei zzgt;
    private boolean zzgu;
    private boolean zzgv = false;

    static {
        zzby zzby2;
        zzgw = zzby2 = new zzby(true);
    }

    private zzby() {
        zzei zzei2;
        this.zzgt = zzei2 = zzei.zzaj(16);
    }

    private zzby(boolean bl2) {
        zzei zzei2;
        this.zzgt = zzei2 = zzei.zzaj(0);
        this.zzv();
    }

    public static int zza(zzfl zzfl2, int n10, Object object) {
        n10 = zzbn.zzr(n10);
        Object object2 = zzfl.zzql;
        if (zzfl2 == object2) {
            object2 = object;
            object2 = (zzdo)object;
            zzci.zzf((zzdo)object2);
            n10 <<= 1;
        }
        int n11 = zzby.zzb(zzfl2, object);
        return n10 + n11;
    }

    private final Object zza(zzca object) {
        zzei zzei2 = this.zzgt;
        boolean bl2 = (object = zzei2.get(object)) instanceof zzcr;
        if (bl2) {
            object = zzcr.zzbr();
        }
        return object;
    }

    public static void zza(zzbn zzbn2, zzfl zzfl2, int n10, Object object) {
        zzfl zzfl3 = zzfl.zzql;
        if (zzfl2 == zzfl3) {
            object = (zzdo)object;
            zzci.zzf((zzdo)object);
            zzbn2.zzb(n10, 3);
            object.zzb(zzbn2);
            zzbn2.zzb(n10, 4);
            return;
        }
        int n11 = zzfl2.zzel();
        zzbn2.zzb(n10, n11);
        int[] nArray = zzbz.zzgq;
        int n12 = zzfl2.ordinal();
        n12 = nArray[n12];
        switch (n12) {
            default: {
                break;
            }
            case 18: {
                n12 = object instanceof zzcj;
                if (n12 != 0) {
                    n12 = ((zzcj)object).zzc();
                    zzbn2.zzn(n12);
                    return;
                }
                object = (Integer)object;
                n12 = (Integer)object;
                zzbn2.zzn(n12);
                break;
            }
            case 17: {
                long l10 = (Long)object;
                zzbn2.zzc(l10);
                return;
            }
            case 16: {
                n12 = (Integer)object;
                zzbn2.zzp(n12);
                return;
            }
            case 15: {
                long l11 = (Long)object;
                zzbn2.zzd(l11);
                return;
            }
            case 14: {
                n12 = (Integer)object;
                zzbn2.zzq(n12);
                return;
            }
            case 13: {
                n12 = (Integer)object;
                zzbn2.zzo(n12);
                return;
            }
            case 12: {
                n12 = object instanceof zzbb;
                if (n12 != 0) {
                    object = (zzbb)object;
                    zzbn2.zza((zzbb)object);
                    return;
                }
                object = (byte[])object;
                n10 = ((Object)object).length;
                zzbn2.zzd((byte[])object, 0, n10);
                return;
            }
            case 11: {
                n12 = object instanceof zzbb;
                if (n12 != 0) {
                    object = (zzbb)object;
                    zzbn2.zza((zzbb)object);
                    return;
                }
                object = (String)object;
                zzbn2.zzg((String)object);
                return;
            }
            case 10: {
                object = (zzdo)object;
                zzbn2.zzb((zzdo)object);
                return;
            }
            case 9: {
                ((zzdo)object).zzb(zzbn2);
                return;
            }
            case 8: {
                n12 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                zzbn2.zza(n12 != 0);
                return;
            }
            case 7: {
                n12 = (Integer)object;
                zzbn2.zzq(n12);
                return;
            }
            case 6: {
                long l12 = (Long)object;
                zzbn2.zzd(l12);
                return;
            }
            case 5: {
                n12 = (Integer)object;
                zzbn2.zzn(n12);
                return;
            }
            case 4: {
                long l13 = (Long)object;
                zzbn2.zzb(l13);
                return;
            }
            case 3: {
                long l14 = (Long)object;
                zzbn2.zzb(l14);
                return;
            }
            case 2: {
                float f10 = ((Float)object).floatValue();
                zzbn2.zza(f10);
                return;
            }
            case 1: {
                object = (Double)object;
                double d10 = (Double)object;
                zzbn2.zza(d10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void zza(zzca object, Object list) {
        boolean bl2 = object.zzaw();
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
                zzfl zzfl2 = object.zzau();
                zzby.zza(zzfl2, e10);
            }
            list = arrayList;
        } else {
            zzfl zzfl3 = object.zzau();
            zzby.zza(zzfl3, list);
        }
        bl2 = list instanceof zzcr;
        if (bl2) {
            this.zzgv = bl2 = true;
        }
        this.zzgt.zza((Comparable)object, list);
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(zzfl var0, Object var1_1) {
        block13: {
            zzci.checkNotNull(var1_1);
            var2_2 = zzbz.zzgx;
            var0 = var0.zzek();
            var3_3 = var0.ordinal();
            var3_3 = var2_2[var3_3];
            var4_4 = true;
            var5_5 = false;
            block0 : switch (var3_3) {
                default: {
                    break block13;
                }
                case 9: {
                    var3_3 = var1_1 instanceof zzdo;
                    if (var3_3 != 0 || (var3_3 = var1_1 instanceof zzcr) != 0) break;
lbl15:
                    // 3 sources

                    while (true) {
                        var4_4 = false;
                        var2_2 = null;
                        break block0;
                        break;
                    }
                }
                case 8: {
                    var3_3 = var1_1 instanceof Integer;
                    if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzcj) == 0) ** GOTO lbl15
                    break;
                }
                case 7: {
                    var3_3 = var1_1 instanceof zzbb;
                    if (var3_3 != 0 || (var3_3 = var1_1 instanceof byte[]) != 0) ** break;
                    ** continue;
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
            var5_5 = var4_4;
        }
        if (var5_5) {
            return;
        }
        var0 = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        throw var0;
    }

    public static zzby zzar() {
        return zzgw;
    }

    private static int zzb(zzca iterator2, Object object) {
        zzfl zzfl2 = iterator2.zzau();
        int n10 = iterator2.zzc();
        int n11 = (int)(iterator2.zzaw() ? 1 : 0);
        if (n11 != 0) {
            int n12;
            int n13 = iterator2.zzax();
            n11 = 0;
            object = (List)object;
            if (n13 != 0) {
                int n14;
                iterator2 = object.iterator();
                while ((n14 = iterator2.hasNext()) != 0) {
                    object = iterator2.next();
                    n14 = zzby.zzb(zzfl2, object);
                    n11 += n14;
                }
                n13 = zzbn.zzr(n10) + n11;
                n14 = zzbn.zzz(n11);
                return n13 + n14;
            }
            iterator2 = object.iterator();
            while ((n12 = iterator2.hasNext()) != 0) {
                object = iterator2.next();
                n12 = zzby.zza(zzfl2, n10, object);
                n11 += n12;
            }
            return n11;
        }
        return zzby.zza(zzfl2, n10, object);
    }

    private static int zzb(zzfl object, Object object2) {
        int[] nArray = zzbz.zzgq;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw object;
            }
            case 18: {
                n10 = object2 instanceof zzcj;
                if (n10 != 0) {
                    return zzbn.zzx(((zzcj)object2).zzc());
                }
                return zzbn.zzx((Integer)object2);
            }
            case 17: {
                return zzbn.zzg((Long)object2);
            }
            case 16: {
                return zzbn.zzu((Integer)object2);
            }
            case 15: {
                return zzbn.zzi((Long)object2);
            }
            case 14: {
                return zzbn.zzw((Integer)object2);
            }
            case 13: {
                return zzbn.zzt((Integer)object2);
            }
            case 12: {
                n10 = object2 instanceof zzbb;
                if (n10 != 0) {
                    return zzbn.zzb((zzbb)object2);
                }
                return zzbn.zzd((byte[])object2);
            }
            case 11: {
                n10 = object2 instanceof zzbb;
                if (n10 != 0) {
                    return zzbn.zzb((zzbb)object2);
                }
                return zzbn.zzh((String)object2);
            }
            case 10: {
                n10 = object2 instanceof zzcr;
                if (n10 != 0) {
                    return zzbn.zza((zzcr)object2);
                }
                return zzbn.zzc((zzdo)object2);
            }
            case 9: {
                return zzbn.zzd((zzdo)object2);
            }
            case 8: {
                return zzbn.zzb((Boolean)object2);
            }
            case 7: {
                return zzbn.zzv((Integer)object2);
            }
            case 6: {
                return zzbn.zzh((Long)object2);
            }
            case 5: {
                return zzbn.zzs((Integer)object2);
            }
            case 4: {
                return zzbn.zzf((Long)object2);
            }
            case 3: {
                return zzbn.zze((Long)object2);
            }
            case 2: {
                return zzbn.zzb(((Float)object2).floatValue());
            }
            case 1: 
        }
        return zzbn.zzb((Double)object2);
    }

    private static boolean zzb(Map.Entry object) {
        Object object2 = (zzca)object.getKey();
        zzfq zzfq2 = object2.zzav();
        zzfq zzfq3 = zzfq.zzrf;
        boolean bl2 = true;
        if (zzfq2 == zzfq3) {
            boolean bl3 = object2.zzaw();
            zzfq2 = null;
            object = object.getValue();
            if (bl3) {
                object = ((List)object).iterator();
                while (bl3 = object.hasNext()) {
                    object2 = (zzdo)object.next();
                    bl3 = object2.isInitialized();
                    if (bl3) continue;
                    return false;
                }
            } else {
                bl3 = object instanceof zzdo;
                if (bl3) {
                    boolean bl4 = (object = (zzdo)object).isInitialized();
                    if (!bl4) {
                        return false;
                    }
                } else {
                    boolean bl5 = object instanceof zzcr;
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

    private final void zzc(Map.Entry object) {
        zzfq zzfq2;
        zzca zzca2 = (zzca)object.getKey();
        boolean bl2 = (object = object.getValue()) instanceof zzcr;
        if (bl2) {
            object = zzcr.zzbr();
        }
        if (bl2 = zzca2.zzaw()) {
            boolean bl3;
            ArrayList arrayList = this.zza(zzca2);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            object = ((List)object).iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                List list = arrayList;
                list = arrayList;
                object2 = zzby.zzd(object2);
                list.add(object2);
            }
            this.zzgt.zza(zzca2, arrayList);
            return;
        }
        Object object3 = zzca2.zzav();
        if (object3 == (zzfq2 = zzfq.zzrf)) {
            object3 = this.zza(zzca2);
            if (object3 == null) {
                object3 = this.zzgt;
                object = zzby.zzd(object);
                ((zzei)object3).zza(zzca2, object);
                return;
            }
            boolean bl4 = object3 instanceof zzdv;
            if (bl4) {
                object3 = (zzdv)object3;
                object = (zzdv)object;
                object = zzca2.zza((zzdv)object3, (zzdv)object);
            } else {
                object3 = ((zzdo)object3).zzbc();
                object = (zzdo)object;
                object = zzca2.zza((zzdp)object3, (zzdo)object).zzbj();
            }
            this.zzgt.zza(zzca2, object);
            return;
        }
        object3 = this.zzgt;
        object = zzby.zzd(object);
        ((zzei)object3).zza(zzca2, object);
    }

    private static int zzd(Map.Entry object) {
        boolean bl2;
        zzfq zzfq2;
        zzca zzca2 = (zzca)object.getKey();
        Object object2 = object.getValue();
        zzfq zzfq3 = zzca2.zzav();
        if (zzfq3 == (zzfq2 = zzfq.zzrf) && !(bl2 = zzca2.zzaw()) && !(bl2 = zzca2.zzax())) {
            boolean bl3 = object2 instanceof zzcr;
            object = (zzca)object.getKey();
            int n10 = object.zzc();
            if (bl3) {
                object2 = (zzcr)object2;
                return zzbn.zzb(n10, object2);
            }
            object2 = (zzdo)object2;
            return zzbn.zzd(n10, object2);
        }
        return zzby.zzb(zzca2, object2);
    }

    private static Object zzd(Object object) {
        boolean bl2 = object instanceof zzdv;
        if (bl2) {
            return ((zzdv)object).zzci();
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

    public final /* synthetic */ Object clone() {
        zzca zzca2;
        Object object;
        int n10;
        int n11;
        zzby zzby2 = new zzby();
        Iterator iterator2 = null;
        for (n11 = 0; n11 < (n10 = ((zzei)(object = this.zzgt)).zzdr()); ++n11) {
            object = this.zzgt.zzak(n11);
            zzca2 = (zzca)object.getKey();
            object = object.getValue();
            zzby2.zza(zzca2, object);
        }
        iterator2 = this.zzgt.zzds().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            zzca2 = (zzca)object.getKey();
            object = object.getValue();
            zzby2.zza(zzca2, object);
        }
        n11 = (int)(this.zzgv ? 1 : 0);
        zzby2.zzgv = n11;
        return zzby2;
    }

    public final Iterator descendingIterator() {
        boolean bl2 = this.zzgv;
        if (bl2) {
            Iterator iterator2 = this.zzgt.zzdt().iterator();
            zzcu zzcu2 = new zzcu(iterator2);
            return zzcu2;
        }
        return this.zzgt.zzdt().iterator();
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzby;
        if (!bl2) {
            return false;
        }
        object = (zzby)object;
        zzei zzei2 = this.zzgt;
        object = ((zzby)object).zzgt;
        return zzei2.equals(object);
    }

    public final int hashCode() {
        return this.zzgt.hashCode();
    }

    public final boolean isEmpty() {
        return this.zzgt.isEmpty();
    }

    public final boolean isImmutable() {
        return this.zzgu;
    }

    public final boolean isInitialized() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        for (int i10 = 0; i10 < (n10 = ((zzei)(object = this.zzgt)).zzdr()); ++i10) {
            object = this.zzgt.zzak(i10);
            n10 = (int)(zzby.zzb((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        iterator2 = this.zzgt.zzds().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = (int)(zzby.zzb((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public final Iterator iterator() {
        boolean bl2 = this.zzgv;
        if (bl2) {
            Iterator iterator2 = this.zzgt.entrySet().iterator();
            zzcu zzcu2 = new zzcu(iterator2);
            return zzcu2;
        }
        return this.zzgt.entrySet().iterator();
    }

    public final void zza(zzby object) {
        Object object2;
        int n10;
        int n11;
        Map.Entry entry = null;
        for (n11 = 0; n11 < (n10 = ((zzei)(object2 = ((zzby)object).zzgt)).zzdr()); ++n11) {
            object2 = ((zzby)object).zzgt.zzak(n11);
            this.zzc((Map.Entry)object2);
        }
        object = ((zzby)object).zzgt.zzds().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            entry = (Map.Entry)object.next();
            this.zzc(entry);
        }
    }

    public final int zzas() {
        zzca zzca2;
        Object object;
        int n10;
        Iterator iterator2 = null;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = ((zzei)(object = this.zzgt)).zzdr()); ++i10) {
            object = this.zzgt.zzak(i10);
            zzca2 = (zzca)object.getKey();
            object = object.getValue();
            n10 = zzby.zzb(zzca2, object);
            n11 += n10;
        }
        iterator2 = this.zzgt.zzds().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            zzca2 = (zzca)object.getKey();
            object = object.getValue();
            n10 = zzby.zzb(zzca2, object);
            n11 += n10;
        }
        return n11;
    }

    public final int zzat() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = ((zzei)(object = this.zzgt)).zzdr()); ++i10) {
            object = this.zzgt.zzak(i10);
            n10 = zzby.zzd((Map.Entry)object);
            n11 += n10;
        }
        iterator2 = this.zzgt.zzds().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = zzby.zzd((Map.Entry)object);
            n11 += n10;
        }
        return n11;
    }

    public final void zzv() {
        boolean bl2 = this.zzgu;
        if (bl2) {
            return;
        }
        this.zzgt.zzv();
        this.zzgu = true;
    }
}

