/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdw;
import com.google.android.gms.internal.mlkit_vision_common.zzed;
import com.google.android.gms.internal.mlkit_vision_common.zzee;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzem;
import com.google.android.gms.internal.mlkit_vision_common.zzew;
import com.google.android.gms.internal.mlkit_vision_common.zzex;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzfu;
import com.google.android.gms.internal.mlkit_vision_common.zzfx;
import com.google.android.gms.internal.mlkit_vision_common.zzgm;
import com.google.android.gms.internal.mlkit_vision_common.zzhn;
import com.google.android.gms.internal.mlkit_vision_common.zzhu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzeb {
    private static final zzeb zzd;
    public final zzgm zza;
    private boolean zzb;
    private boolean zzc;

    static {
        zzeb zzeb2;
        zzd = zzeb2 = new zzeb(true);
    }

    private zzeb() {
        zzgm zzgm2;
        this.zza = zzgm2 = zzgm.zza(16);
    }

    private zzeb(zzgm zzgm2) {
        this.zza = zzgm2;
        this.zzb();
    }

    private zzeb(boolean bl2) {
        zzgm zzgm2 = zzgm.zza(0);
        this(zzgm2);
        this.zzb();
    }

    public static int zza(zzed iterator2, Object object) {
        zzhn zzhn2 = iterator2.zzb();
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
                    n14 = zzeb.zzb(zzhn2, object);
                    n11 += n14;
                }
                n13 = zzdw.zze(n10) + n11;
                n14 = zzdw.zzl(n11);
                return n13 + n14;
            }
            object = (List)object;
            iterator2 = object.iterator();
            while ((n12 = iterator2.hasNext()) != 0) {
                object = iterator2.next();
                n12 = zzeb.zza(zzhn2, n10, object);
                n11 += n12;
            }
            return n11;
        }
        return zzeb.zza(zzhn2, n10, object);
    }

    public static int zza(zzhn zzhn2, int n10, Object object) {
        n10 = zzdw.zze(n10);
        Object object2 = zzhn.zzj;
        if (zzhn2 == object2) {
            object2 = object;
            object2 = (zzfr)object;
            zzem.zza((zzfr)object2);
            n10 <<= 1;
        }
        int n11 = zzeb.zzb(zzhn2, object);
        return n10 + n11;
    }

    public static zzeb zza() {
        return zzd;
    }

    private final Object zza(zzed object) {
        zzgm zzgm2 = this.zza;
        boolean bl2 = (object = zzgm2.get(object)) instanceof zzew;
        if (bl2) {
            object = (zzew)object;
            object = zzew.zza();
        }
        return object;
    }

    private static Object zza(Object object) {
        boolean bl2 = object instanceof zzfx;
        if (bl2) {
            return ((zzfx)object).zza();
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

    public static void zza(zzdw zzdw2, zzhn zzhn2, int n10, Object object) {
        zzhn zzhn3 = zzhn.zzj;
        if (zzhn2 == zzhn3) {
            object = (zzfr)object;
            zzem.zza((zzfr)object);
            zzdw2.zza(n10, 3);
            object.zza(zzdw2);
            zzdw2.zza(n10, 4);
            return;
        }
        int n11 = zzhn2.zzb();
        zzdw2.zza(n10, n11);
        int[] nArray = zzee.zzb;
        int n12 = zzhn2.ordinal();
        n12 = nArray[n12];
        switch (n12) {
            default: {
                break;
            }
            case 18: {
                n12 = object instanceof zzel;
                if (n12 != 0) {
                    n12 = ((zzel)object).zza();
                    zzdw2.zza(n12);
                    return;
                }
                object = (Integer)object;
                n12 = (Integer)object;
                zzdw2.zza(n12);
                break;
            }
            case 17: {
                long l10 = (Long)object;
                zzdw2.zzb(l10);
                return;
            }
            case 16: {
                n12 = (Integer)object;
                zzdw2.zzc(n12);
                return;
            }
            case 15: {
                long l11 = (Long)object;
                zzdw2.zzc(l11);
                return;
            }
            case 14: {
                n12 = (Integer)object;
                zzdw2.zzd(n12);
                return;
            }
            case 13: {
                n12 = (Integer)object;
                zzdw2.zzb(n12);
                return;
            }
            case 12: {
                n12 = object instanceof zzdf;
                if (n12 != 0) {
                    object = (zzdf)object;
                    zzdw2.zza((zzdf)object);
                    return;
                }
                object = (byte[])object;
                n10 = ((Object)object).length;
                zzdw2.zzb((byte[])object, 0, n10);
                return;
            }
            case 11: {
                n12 = object instanceof zzdf;
                if (n12 != 0) {
                    object = (zzdf)object;
                    zzdw2.zza((zzdf)object);
                    return;
                }
                object = (String)object;
                zzdw2.zza((String)object);
                return;
            }
            case 10: {
                object = (zzfr)object;
                zzdw2.zza((zzfr)object);
                return;
            }
            case 9: {
                ((zzfr)object).zza(zzdw2);
                return;
            }
            case 8: {
                n12 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                zzdw2.zza(n12 != 0);
                return;
            }
            case 7: {
                n12 = (Integer)object;
                zzdw2.zzd(n12);
                return;
            }
            case 6: {
                long l12 = (Long)object;
                zzdw2.zzc(l12);
                return;
            }
            case 5: {
                n12 = (Integer)object;
                zzdw2.zza(n12);
                return;
            }
            case 4: {
                long l13 = (Long)object;
                zzdw2.zza(l13);
                return;
            }
            case 3: {
                long l14 = (Long)object;
                zzdw2.zza(l14);
                return;
            }
            case 2: {
                float f10 = ((Float)object).floatValue();
                zzdw2.zza(f10);
                return;
            }
            case 1: {
                object = (Double)object;
                double d10 = (Double)object;
                zzdw2.zza(d10);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(zzhn var0, Object var1_1) {
        zzem.zza(var1_1);
        var2_2 = zzee.zza;
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
                var3_3 = var1_1 instanceof zzfr;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzew) == 0) ** GOTO lbl-1000
                break;
            }
            case 8: {
                var3_3 = var1_1 instanceof Integer;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzel) == 0) ** GOTO lbl-1000
                break;
            }
            case 7: {
                var3_3 = var1_1 instanceof zzdf;
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
        Object object2 = (zzed)object.getKey();
        zzhu zzhu2 = object2.zzc();
        zzhu zzhu3 = zzhu.zzi;
        boolean bl2 = true;
        if (zzhu2 == zzhu3) {
            boolean bl3 = object2.zzd();
            zzhu2 = null;
            if (bl3) {
                object = ((List)object.getValue()).iterator();
                while (bl3 = object.hasNext()) {
                    object2 = (zzfr)object.next();
                    bl3 = object2.a_();
                    if (bl3) continue;
                    return false;
                }
            } else {
                bl3 = (object = object.getValue()) instanceof zzfr;
                if (bl3) {
                    boolean bl4 = (object = (zzfr)object).a_();
                    if (!bl4) {
                        return false;
                    }
                } else {
                    boolean bl5 = object instanceof zzew;
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

    private static int zzb(zzhn object, Object object2) {
        int[] nArray = zzee.zzb;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw object;
            }
            case 18: {
                n10 = object2 instanceof zzel;
                if (n10 != 0) {
                    return zzdw.zzk(((zzel)object2).zza());
                }
                return zzdw.zzk((Integer)object2);
            }
            case 17: {
                return zzdw.zzf((Long)object2);
            }
            case 16: {
                return zzdw.zzh((Integer)object2);
            }
            case 15: {
                return zzdw.zzh((Long)object2);
            }
            case 14: {
                return zzdw.zzj((Integer)object2);
            }
            case 13: {
                return zzdw.zzg((Integer)object2);
            }
            case 12: {
                n10 = object2 instanceof zzdf;
                if (n10 != 0) {
                    return zzdw.zzb((zzdf)object2);
                }
                return zzdw.zzb((byte[])object2);
            }
            case 11: {
                n10 = object2 instanceof zzdf;
                if (n10 != 0) {
                    return zzdw.zzb((zzdf)object2);
                }
                return zzdw.zzb((String)object2);
            }
            case 10: {
                n10 = object2 instanceof zzew;
                if (n10 != 0) {
                    return zzdw.zza((zzew)object2);
                }
                return zzdw.zzb((zzfr)object2);
            }
            case 9: {
                return zzdw.zzc((zzfr)object2);
            }
            case 8: {
                return zzdw.zzb((Boolean)object2);
            }
            case 7: {
                return zzdw.zzi((Integer)object2);
            }
            case 6: {
                return zzdw.zzg((Long)object2);
            }
            case 5: {
                return zzdw.zzf((Integer)object2);
            }
            case 4: {
                return zzdw.zze((Long)object2);
            }
            case 3: {
                return zzdw.zzd((Long)object2);
            }
            case 2: {
                return zzdw.zzb(((Float)object2).floatValue());
            }
            case 1: 
        }
        return zzdw.zzb((Double)object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void zzb(zzed object, Object list) {
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
                zzhn zzhn2 = object.zzb();
                zzeb.zza(zzhn2, e10);
            }
            list = arrayList;
        } else {
            zzhn zzhn3 = object.zzb();
            zzeb.zza(zzhn3, list);
        }
        bl2 = list instanceof zzew;
        if (bl2) {
            this.zzc = bl2 = true;
        }
        this.zza.zza((Comparable)object, list);
    }

    private final void zzb(Map.Entry object) {
        zzhu zzhu2;
        zzed zzed2 = (zzed)object.getKey();
        boolean bl2 = (object = object.getValue()) instanceof zzew;
        if (bl2) {
            object = (zzew)object;
            object = zzew.zza();
        }
        if (bl2 = zzed2.zzd()) {
            boolean bl3;
            ArrayList arrayList = this.zza(zzed2);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            object = ((List)object).iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                List list = arrayList;
                list = arrayList;
                object2 = zzeb.zza(object2);
                list.add(object2);
            }
            this.zza.zza(zzed2, arrayList);
            return;
        }
        Object object3 = zzed2.zzc();
        if (object3 == (zzhu2 = zzhu.zzi)) {
            object3 = this.zza(zzed2);
            if (object3 == null) {
                object3 = this.zza;
                object = zzeb.zza(object);
                ((zzgm)object3).zza(zzed2, object);
                return;
            }
            boolean bl4 = object3 instanceof zzfx;
            if (bl4) {
                object3 = (zzfx)object3;
                object = (zzfx)object;
                object = zzed2.zza((zzfx)object3, (zzfx)object);
            } else {
                object3 = ((zzfr)object3).zzm();
                object = (zzfr)object;
                object = zzed2.zza((zzfu)object3, (zzfr)object).zzh();
            }
            this.zza.zza(zzed2, object);
            return;
        }
        object3 = this.zza;
        object = zzeb.zza(object);
        ((zzgm)object3).zza(zzed2, object);
    }

    private static int zzc(Map.Entry entry) {
        boolean bl2;
        zzhu zzhu2;
        zzed zzed2 = (zzed)entry.getKey();
        Object object = entry.getValue();
        zzhu zzhu3 = zzed2.zzc();
        if (zzhu3 == (zzhu2 = zzhu.zzi) && !(bl2 = zzed2.zzd()) && !(bl2 = zzed2.zze())) {
            boolean bl3 = object instanceof zzew;
            if (bl3) {
                int n10 = ((zzed)entry.getKey()).zza();
                object = (zzew)object;
                return zzdw.zzb(n10, object);
            }
            int n11 = ((zzed)entry.getKey()).zza();
            object = (zzfr)object;
            return zzdw.zzb(n11, object);
        }
        return zzeb.zza(zzed2, object);
    }

    public final /* synthetic */ Object clone() {
        zzed zzed2;
        Object object;
        int n10;
        int n11;
        zzeb zzeb2 = new zzeb();
        Iterator iterator2 = null;
        for (n11 = 0; n11 < (n10 = ((zzgm)(object = this.zza)).zzc()); ++n11) {
            object = this.zza.zzb(n11);
            zzed2 = (zzed)object.getKey();
            object = object.getValue();
            zzeb2.zzb(zzed2, object);
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            zzed2 = (zzed)object.getKey();
            object = object.getValue();
            zzeb2.zzb(zzed2, object);
        }
        n11 = (int)(this.zzc ? 1 : 0);
        zzeb2.zzc = n11;
        return zzeb2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzeb;
        if (!bl2) {
            return false;
        }
        object = (zzeb)object;
        zzgm zzgm2 = this.zza;
        object = ((zzeb)object).zza;
        return zzgm2.equals(object);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(zzeb object) {
        Object object2;
        int n10;
        int n11;
        Map.Entry entry = null;
        for (n11 = 0; n11 < (n10 = ((zzgm)(object2 = ((zzeb)object).zza)).zzc()); ++n11) {
            object2 = ((zzeb)object).zza.zzb(n11);
            this.zzb((Map.Entry)object2);
        }
        object = ((zzeb)object).zza.zzd().iterator();
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
            zzex zzex2 = new zzex(iterator2);
            return zzex2;
        }
        return this.zza.entrySet().iterator();
    }

    public final Iterator zze() {
        boolean bl2 = this.zzc;
        if (bl2) {
            Iterator iterator2 = this.zza.zze().iterator();
            zzex zzex2 = new zzex(iterator2);
            return zzex2;
        }
        return this.zza.zze().iterator();
    }

    public final boolean zzf() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        for (int i10 = 0; i10 < (n10 = ((zzgm)(object = this.zza)).zzc()); ++i10) {
            object = this.zza.zzb(i10);
            n10 = (int)(zzeb.zza((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = (int)(zzeb.zza((Map.Entry)object) ? 1 : 0);
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
        for (int i10 = 0; i10 < (n10 = ((zzgm)(object = this.zza)).zzc()); ++i10) {
            object = this.zza.zzb(i10);
            n10 = zzeb.zzc((Map.Entry)object);
            n11 += n10;
        }
        iterator2 = this.zza.zzd().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = zzeb.zzc((Map.Entry)object);
            n11 += n10;
        }
        return n11;
    }
}

