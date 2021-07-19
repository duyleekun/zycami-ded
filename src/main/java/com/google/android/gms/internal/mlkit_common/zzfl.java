/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzfc;
import com.google.android.gms.internal.mlkit_common.zzfk;
import com.google.android.gms.internal.mlkit_common.zzfn;
import com.google.android.gms.internal.mlkit_common.zzfs;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzgc;
import com.google.android.gms.internal.mlkit_common.zzgh;
import com.google.android.gms.internal.mlkit_common.zzha;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhh;
import com.google.android.gms.internal.mlkit_common.zzhs;
import com.google.android.gms.internal.mlkit_common.zzix;
import com.google.android.gms.internal.mlkit_common.zzja;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzfl {
    private static final zzfl zzd;
    public final zzhs zza;
    private boolean zzb;
    private boolean zzc;

    static {
        zzfl zzfl2;
        zzd = zzfl2 = new zzfl(true);
    }

    private zzfl() {
        zzhs zzhs2;
        this.zza = zzhs2 = zzhs.zza(16);
    }

    private zzfl(zzhs zzhs2) {
        this.zza = zzhs2;
        this.zzb();
    }

    private zzfl(boolean bl2) {
        zzhs zzhs2 = zzhs.zza(0);
        this(zzhs2);
        this.zzb();
    }

    public static int zza(zzfn iterator2, Object object) {
        zzix zzix2 = iterator2.zzb();
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
                    n14 = zzfl.zzb(zzix2, object);
                    n11 += n14;
                }
                n13 = zzfc.zze(n10) + n11;
                n14 = zzfc.zzl(n11);
                return n13 + n14;
            }
            object = (List)object;
            iterator2 = object.iterator();
            while ((n12 = iterator2.hasNext()) != 0) {
                object = iterator2.next();
                n12 = zzfl.zza(zzix2, n10, object);
                n11 += n12;
            }
            return n11;
        }
        return zzfl.zza(zzix2, n10, object);
    }

    public static int zza(zzix zzix2, int n10, Object object) {
        n10 = zzfc.zze(n10);
        Object object2 = zzix.zzj;
        if (zzix2 == object2) {
            object2 = object;
            object2 = (zzhb)object;
            zzfs.zza((zzhb)object2);
            n10 <<= 1;
        }
        int n11 = zzfl.zzb(zzix2, object);
        return n10 + n11;
    }

    public static zzfl zza() {
        return zzd;
    }

    private final Object zza(zzfn object) {
        zzhs zzhs2 = this.zza;
        boolean bl2 = (object = zzhs2.get(object)) instanceof zzgc;
        if (bl2) {
            object = (zzgc)object;
            object = zzgc.zza();
        }
        return object;
    }

    private static Object zza(Object object) {
        boolean bl2 = object instanceof zzhh;
        if (bl2) {
            return ((zzhh)object).zza();
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

    public static void zza(zzfc zzfc2, zzix zzix2, int n10, Object object) {
        zzix zzix3 = zzix.zzj;
        if (zzix2 == zzix3) {
            object = (zzhb)object;
            zzfs.zza((zzhb)object);
            zzfc2.zza(n10, 3);
            object.zza(zzfc2);
            zzfc2.zza(n10, 4);
            return;
        }
        int n11 = zzix2.zzb();
        zzfc2.zza(n10, n11);
        int[] nArray = zzfk.zzb;
        int n12 = zzix2.ordinal();
        n12 = nArray[n12];
        switch (n12) {
            default: {
                break;
            }
            case 18: {
                n12 = object instanceof zzfv;
                if (n12 != 0) {
                    n12 = ((zzfv)object).zza();
                    zzfc2.zza(n12);
                    return;
                }
                object = (Integer)object;
                n12 = (Integer)object;
                zzfc2.zza(n12);
                break;
            }
            case 17: {
                long l10 = (Long)object;
                zzfc2.zzb(l10);
                return;
            }
            case 16: {
                n12 = (Integer)object;
                zzfc2.zzc(n12);
                return;
            }
            case 15: {
                long l11 = (Long)object;
                zzfc2.zzc(l11);
                return;
            }
            case 14: {
                n12 = (Integer)object;
                zzfc2.zzd(n12);
                return;
            }
            case 13: {
                n12 = (Integer)object;
                zzfc2.zzb(n12);
                return;
            }
            case 12: {
                n12 = object instanceof zzep;
                if (n12 != 0) {
                    object = (zzep)object;
                    zzfc2.zza((zzep)object);
                    return;
                }
                object = (byte[])object;
                n10 = ((Object)object).length;
                zzfc2.zzb((byte[])object, 0, n10);
                return;
            }
            case 11: {
                n12 = object instanceof zzep;
                if (n12 != 0) {
                    object = (zzep)object;
                    zzfc2.zza((zzep)object);
                    return;
                }
                object = (String)object;
                zzfc2.zza((String)object);
                return;
            }
            case 10: {
                object = (zzhb)object;
                zzfc2.zza((zzhb)object);
                return;
            }
            case 9: {
                ((zzhb)object).zza(zzfc2);
                return;
            }
            case 8: {
                n12 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                zzfc2.zza(n12 != 0);
                return;
            }
            case 7: {
                n12 = (Integer)object;
                zzfc2.zzd(n12);
                return;
            }
            case 6: {
                long l12 = (Long)object;
                zzfc2.zzc(l12);
                return;
            }
            case 5: {
                n12 = (Integer)object;
                zzfc2.zza(n12);
                return;
            }
            case 4: {
                long l13 = (Long)object;
                zzfc2.zza(l13);
                return;
            }
            case 3: {
                long l14 = (Long)object;
                zzfc2.zza(l14);
                return;
            }
            case 2: {
                float f10 = ((Float)object).floatValue();
                zzfc2.zza(f10);
                return;
            }
            case 1: {
                object = (Double)object;
                double d10 = (Double)object;
                zzfc2.zza(d10);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(zzix var0, Object var1_1) {
        zzfs.zza(var1_1);
        var2_2 = zzfk.zza;
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
                var3_3 = var1_1 instanceof zzhb;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzgc) == 0) ** GOTO lbl-1000
                break;
            }
            case 8: {
                var3_3 = var1_1 instanceof Integer;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzfv) == 0) ** GOTO lbl-1000
                break;
            }
            case 7: {
                var3_3 = var1_1 instanceof zzep;
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
        Object object2 = (zzfn)object.getKey();
        zzja zzja2 = object2.zzc();
        zzja zzja3 = zzja.zzi;
        boolean bl2 = true;
        if (zzja2 == zzja3) {
            boolean bl3 = object2.zzd();
            zzja2 = null;
            if (bl3) {
                object = ((List)object.getValue()).iterator();
                while (bl3 = object.hasNext()) {
                    object2 = (zzhb)object.next();
                    bl3 = object2.zzi();
                    if (bl3) continue;
                    return false;
                }
            } else {
                bl3 = (object = object.getValue()) instanceof zzhb;
                if (bl3) {
                    boolean bl4 = (object = (zzhb)object).zzi();
                    if (!bl4) {
                        return false;
                    }
                } else {
                    boolean bl5 = object instanceof zzgc;
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

    private static int zzb(zzix object, Object object2) {
        int[] nArray = zzfk.zzb;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw object;
            }
            case 18: {
                n10 = object2 instanceof zzfv;
                if (n10 != 0) {
                    return zzfc.zzk(((zzfv)object2).zza());
                }
                return zzfc.zzk((Integer)object2);
            }
            case 17: {
                return zzfc.zzf((Long)object2);
            }
            case 16: {
                return zzfc.zzh((Integer)object2);
            }
            case 15: {
                return zzfc.zzh((Long)object2);
            }
            case 14: {
                return zzfc.zzj((Integer)object2);
            }
            case 13: {
                return zzfc.zzg((Integer)object2);
            }
            case 12: {
                n10 = object2 instanceof zzep;
                if (n10 != 0) {
                    return zzfc.zzb((zzep)object2);
                }
                return zzfc.zzb((byte[])object2);
            }
            case 11: {
                n10 = object2 instanceof zzep;
                if (n10 != 0) {
                    return zzfc.zzb((zzep)object2);
                }
                return zzfc.zzb((String)object2);
            }
            case 10: {
                n10 = object2 instanceof zzgc;
                if (n10 != 0) {
                    return zzfc.zza((zzgc)object2);
                }
                return zzfc.zzb((zzhb)object2);
            }
            case 9: {
                return zzfc.zzc((zzhb)object2);
            }
            case 8: {
                return zzfc.zzb((Boolean)object2);
            }
            case 7: {
                return zzfc.zzi((Integer)object2);
            }
            case 6: {
                return zzfc.zzg((Long)object2);
            }
            case 5: {
                return zzfc.zzf((Integer)object2);
            }
            case 4: {
                return zzfc.zze((Long)object2);
            }
            case 3: {
                return zzfc.zzd((Long)object2);
            }
            case 2: {
                return zzfc.zzb(((Float)object2).floatValue());
            }
            case 1: 
        }
        return zzfc.zzb((Double)object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void zzb(zzfn object, Object list) {
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
                zzix zzix2 = object.zzb();
                zzfl.zza(zzix2, e10);
            }
            list = arrayList;
        } else {
            zzix zzix3 = object.zzb();
            zzfl.zza(zzix3, list);
        }
        bl2 = list instanceof zzgc;
        if (bl2) {
            this.zzc = bl2 = true;
        }
        this.zza.zza((Comparable)object, list);
    }

    private final void zzb(Map.Entry object) {
        zzja zzja2;
        zzfn zzfn2 = (zzfn)object.getKey();
        boolean bl2 = (object = object.getValue()) instanceof zzgc;
        if (bl2) {
            object = (zzgc)object;
            object = zzgc.zza();
        }
        if (bl2 = zzfn2.zzd()) {
            boolean bl3;
            ArrayList arrayList = this.zza(zzfn2);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            object = ((List)object).iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                List list = arrayList;
                list = arrayList;
                object2 = zzfl.zza(object2);
                list.add(object2);
            }
            this.zza.zza(zzfn2, arrayList);
            return;
        }
        Object object3 = zzfn2.zzc();
        if (object3 == (zzja2 = zzja.zzi)) {
            object3 = this.zza(zzfn2);
            if (object3 == null) {
                object3 = this.zza;
                object = zzfl.zza(object);
                ((zzhs)object3).zza(zzfn2, object);
                return;
            }
            boolean bl4 = object3 instanceof zzhh;
            if (bl4) {
                object3 = (zzhh)object3;
                object = (zzhh)object;
                object = zzfn2.zza((zzhh)object3, (zzhh)object);
            } else {
                object3 = ((zzhb)object3).zzm();
                object = (zzhb)object;
                object = zzfn2.zza((zzha)object3, (zzhb)object).zzg();
            }
            this.zza.zza(zzfn2, object);
            return;
        }
        object3 = this.zza;
        object = zzfl.zza(object);
        ((zzhs)object3).zza(zzfn2, object);
    }

    private static int zzc(Map.Entry entry) {
        boolean bl2;
        zzja zzja2;
        zzfn zzfn2 = (zzfn)entry.getKey();
        Object object = entry.getValue();
        zzja zzja3 = zzfn2.zzc();
        if (zzja3 == (zzja2 = zzja.zzi) && !(bl2 = zzfn2.zzd()) && !(bl2 = zzfn2.zze())) {
            boolean bl3 = object instanceof zzgc;
            if (bl3) {
                int n10 = ((zzfn)entry.getKey()).zza();
                object = (zzgc)object;
                return zzfc.zzb(n10, object);
            }
            int n11 = ((zzfn)entry.getKey()).zza();
            object = (zzhb)object;
            return zzfc.zzb(n11, object);
        }
        return zzfl.zza(zzfn2, object);
    }

    public final /* synthetic */ Object clone() {
        zzfn zzfn2;
        Object object;
        int n10;
        int n11;
        zzfl zzfl2 = new zzfl();
        Iterator iterator2 = null;
        for (n11 = 0; n11 < (n10 = ((zzhs)(object = this.zza)).zzc()); ++n11) {
            object = this.zza.zzb(n11);
            zzfn2 = (zzfn)object.getKey();
            object = object.getValue();
            zzfl2.zzb(zzfn2, object);
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            zzfn2 = (zzfn)object.getKey();
            object = object.getValue();
            zzfl2.zzb(zzfn2, object);
        }
        n11 = (int)(this.zzc ? 1 : 0);
        zzfl2.zzc = n11;
        return zzfl2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzfl;
        if (!bl2) {
            return false;
        }
        object = (zzfl)object;
        zzhs zzhs2 = this.zza;
        object = ((zzfl)object).zza;
        return zzhs2.equals(object);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(zzfl object) {
        Object object2;
        int n10;
        int n11;
        Map.Entry entry = null;
        for (n11 = 0; n11 < (n10 = ((zzhs)(object2 = ((zzfl)object).zza)).zzc()); ++n11) {
            object2 = ((zzfl)object).zza.zzb(n11);
            this.zzb((Map.Entry)object2);
        }
        object = ((zzfl)object).zza.zzd().iterator();
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
            zzgh zzgh2 = new zzgh(iterator2);
            return zzgh2;
        }
        return this.zza.entrySet().iterator();
    }

    public final Iterator zze() {
        boolean bl2 = this.zzc;
        if (bl2) {
            Iterator iterator2 = this.zza.zze().iterator();
            zzgh zzgh2 = new zzgh(iterator2);
            return zzgh2;
        }
        return this.zza.zze().iterator();
    }

    public final boolean zzf() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        for (int i10 = 0; i10 < (n10 = ((zzhs)(object = this.zza)).zzc()); ++i10) {
            object = this.zza.zzb(i10);
            n10 = (int)(zzfl.zza((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = (int)(zzfl.zza((Map.Entry)object) ? 1 : 0);
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
        for (int i10 = 0; i10 < (n10 = ((zzhs)(object = this.zza)).zzc()); ++i10) {
            object = this.zza.zzb(i10);
            n10 = zzfl.zzc((Map.Entry)object);
            n11 += n10;
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = zzfl.zzc((Map.Entry)object);
            n11 += n10;
        }
        return n11;
    }
}

