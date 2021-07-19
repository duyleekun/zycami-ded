/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzhv;
import com.google.android.gms.internal.vision.zzhw;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzio;
import com.google.android.gms.internal.vision.zzit;
import com.google.android.gms.internal.vision.zzjm;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjs;
import com.google.android.gms.internal.vision.zzkg;
import com.google.android.gms.internal.vision.zzlk;
import com.google.android.gms.internal.vision.zzlr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzht {
    private static final zzht zzva;
    public final zzkg zzux;
    private boolean zzuy;
    private boolean zzuz;

    static {
        zzht zzht2;
        zzva = zzht2 = new zzht(true);
    }

    private zzht() {
        zzkg zzkg2;
        this.zzux = zzkg2 = zzkg.zzcb(16);
    }

    private zzht(zzkg zzkg2) {
        this.zzux = zzkg2;
        this.zzej();
    }

    private zzht(boolean bl2) {
        zzkg zzkg2 = zzkg.zzcb(0);
        this(zzkg2);
        this.zzej();
    }

    public static int zza(zzlk zzlk2, int n10, Object object) {
        n10 = zzhl.zzbh(n10);
        Object object2 = zzlk.zzado;
        if (zzlk2 == object2) {
            object2 = object;
            object2 = (zzjn)object;
            zzie.zzf((zzjn)object2);
            n10 <<= 1;
        }
        int n11 = zzht.zzb(zzlk2, object);
        return n10 + n11;
    }

    public static void zza(zzhl zzhl2, zzlk zzlk2, int n10, Object object) {
        zzlk zzlk3 = zzlk.zzado;
        if (zzlk2 == zzlk3) {
            object = (zzjn)object;
            zzie.zzf((zzjn)object);
            zzhl2.writeTag(n10, 3);
            object.zzb(zzhl2);
            zzhl2.writeTag(n10, 4);
            return;
        }
        int n11 = zzlk2.zzjl();
        zzhl2.writeTag(n10, n11);
        int[] nArray = zzhw.zztn;
        int n12 = zzlk2.ordinal();
        n12 = nArray[n12];
        switch (n12) {
            default: {
                break;
            }
            case 18: {
                n12 = object instanceof zzih;
                if (n12 != 0) {
                    n12 = ((zzih)object).zzak();
                    zzhl2.zzbd(n12);
                    return;
                }
                object = (Integer)object;
                n12 = (Integer)object;
                zzhl2.zzbd(n12);
                break;
            }
            case 17: {
                long l10 = (Long)object;
                zzhl2.zzt(l10);
                return;
            }
            case 16: {
                n12 = (Integer)object;
                zzhl2.zzbf(n12);
                return;
            }
            case 15: {
                long l11 = (Long)object;
                zzhl2.zzu(l11);
                return;
            }
            case 14: {
                n12 = (Integer)object;
                zzhl2.zzbg(n12);
                return;
            }
            case 13: {
                n12 = (Integer)object;
                zzhl2.zzbe(n12);
                return;
            }
            case 12: {
                n12 = object instanceof zzgs;
                if (n12 != 0) {
                    object = (zzgs)object;
                    zzhl2.zza((zzgs)object);
                    return;
                }
                object = (byte[])object;
                n10 = ((Object)object).length;
                zzhl2.zze((byte[])object, 0, n10);
                return;
            }
            case 11: {
                n12 = object instanceof zzgs;
                if (n12 != 0) {
                    object = (zzgs)object;
                    zzhl2.zza((zzgs)object);
                    return;
                }
                object = (String)object;
                zzhl2.zzw((String)object);
                return;
            }
            case 10: {
                object = (zzjn)object;
                zzhl2.zzb((zzjn)object);
                return;
            }
            case 9: {
                ((zzjn)object).zzb(zzhl2);
                return;
            }
            case 8: {
                n12 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                zzhl2.zzk(n12 != 0);
                return;
            }
            case 7: {
                n12 = (Integer)object;
                zzhl2.zzbg(n12);
                return;
            }
            case 6: {
                long l12 = (Long)object;
                zzhl2.zzu(l12);
                return;
            }
            case 5: {
                n12 = (Integer)object;
                zzhl2.zzbd(n12);
                return;
            }
            case 4: {
                long l13 = (Long)object;
                zzhl2.zzs(l13);
                return;
            }
            case 3: {
                long l14 = (Long)object;
                zzhl2.zzs(l14);
                return;
            }
            case 2: {
                float f10 = ((Float)object).floatValue();
                zzhl2.zzs(f10);
                return;
            }
            case 1: {
                object = (Double)object;
                double d10 = (Double)object;
                zzhl2.zza(d10);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(zzlk var0, Object var1_1) {
        zzie.checkNotNull(var1_1);
        var2_2 = zzhw.zzvd;
        var0 = var0.zzjk();
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
                var3_3 = var1_1 instanceof zzjn;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzio) == 0) ** GOTO lbl-1000
                break;
            }
            case 8: {
                var3_3 = var1_1 instanceof Integer;
                if (var3_3 == 0 && (var3_3 = var1_1 instanceof zzih) == 0) ** GOTO lbl-1000
                break;
            }
            case 7: {
                var3_3 = var1_1 instanceof zzgs;
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

    private static int zzb(zzlk object, Object object2) {
        int[] nArray = zzhw.zztn;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw object;
            }
            case 18: {
                n10 = object2 instanceof zzih;
                if (n10 != 0) {
                    return zzhl.zzbn(((zzih)object2).zzak());
                }
                return zzhl.zzbn((Integer)object2);
            }
            case 17: {
                return zzhl.zzx((Long)object2);
            }
            case 16: {
                return zzhl.zzbk((Integer)object2);
            }
            case 15: {
                return zzhl.zzz((Long)object2);
            }
            case 14: {
                return zzhl.zzbm((Integer)object2);
            }
            case 13: {
                return zzhl.zzbj((Integer)object2);
            }
            case 12: {
                n10 = object2 instanceof zzgs;
                if (n10 != 0) {
                    return zzhl.zzb((zzgs)object2);
                }
                return zzhl.zzf((byte[])object2);
            }
            case 11: {
                n10 = object2 instanceof zzgs;
                if (n10 != 0) {
                    return zzhl.zzb((zzgs)object2);
                }
                return zzhl.zzx((String)object2);
            }
            case 10: {
                n10 = object2 instanceof zzio;
                if (n10 != 0) {
                    return zzhl.zza((zzio)object2);
                }
                return zzhl.zzc((zzjn)object2);
            }
            case 9: {
                return zzhl.zzd((zzjn)object2);
            }
            case 8: {
                return zzhl.zzl((Boolean)object2);
            }
            case 7: {
                return zzhl.zzbl((Integer)object2);
            }
            case 6: {
                return zzhl.zzy((Long)object2);
            }
            case 5: {
                return zzhl.zzbi((Integer)object2);
            }
            case 4: {
                return zzhl.zzw((Long)object2);
            }
            case 3: {
                return zzhl.zzv((Long)object2);
            }
            case 2: {
                return zzhl.zzt(((Float)object2).floatValue());
            }
            case 1: 
        }
        return zzhl.zzb((Double)object2);
    }

    private static boolean zzb(Map.Entry object) {
        Object object2 = (zzhv)object.getKey();
        zzlr zzlr2 = object2.zzgn();
        zzlr zzlr3 = zzlr.zzaei;
        boolean bl2 = true;
        if (zzlr2 == zzlr3) {
            boolean bl3 = object2.zzgo();
            zzlr2 = null;
            if (bl3) {
                object = ((List)object.getValue()).iterator();
                while (bl3 = object.hasNext()) {
                    object2 = (zzjn)object.next();
                    bl3 = object2.isInitialized();
                    if (bl3) continue;
                    return false;
                }
            } else {
                bl3 = (object = object.getValue()) instanceof zzjn;
                if (bl3) {
                    boolean bl4 = (object = (zzjn)object).isInitialized();
                    if (!bl4) {
                        return false;
                    }
                } else {
                    boolean bl5 = object instanceof zzio;
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

    public static int zzc(zzhv iterator2, Object object) {
        zzlk zzlk2 = iterator2.zzgm();
        int n10 = iterator2.zzak();
        int n11 = (int)(iterator2.zzgo() ? 1 : 0);
        if (n11 != 0) {
            int n12;
            int n13 = iterator2.zzgp();
            n11 = 0;
            if (n13 != 0) {
                int n14;
                object = (List)object;
                iterator2 = object.iterator();
                while ((n14 = iterator2.hasNext()) != 0) {
                    object = iterator2.next();
                    n14 = zzht.zzb(zzlk2, object);
                    n11 += n14;
                }
                n13 = zzhl.zzbh(n10) + n11;
                n14 = zzhl.zzbp(n11);
                return n13 + n14;
            }
            object = (List)object;
            iterator2 = object.iterator();
            while ((n12 = iterator2.hasNext()) != 0) {
                object = iterator2.next();
                n12 = zzht.zza(zzlk2, n10, object);
                n11 += n12;
            }
            return n11;
        }
        return zzht.zza(zzlk2, n10, object);
    }

    private final void zzc(Map.Entry object) {
        zzlr zzlr2;
        zzhv zzhv2 = (zzhv)object.getKey();
        boolean bl2 = (object = object.getValue()) instanceof zzio;
        if (bl2) {
            object = (zzio)object;
            object = zzio.zzhp();
        }
        if (bl2 = zzhv2.zzgo()) {
            boolean bl3;
            ArrayList arrayList = this.zza(zzhv2);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            object = ((List)object).iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                List list = arrayList;
                list = arrayList;
                object2 = zzht.zzk(object2);
                list.add(object2);
            }
            this.zzux.zza(zzhv2, arrayList);
            return;
        }
        Object object3 = zzhv2.zzgn();
        if (object3 == (zzlr2 = zzlr.zzaei)) {
            object3 = this.zza(zzhv2);
            if (object3 == null) {
                object3 = this.zzux;
                object = zzht.zzk(object);
                ((zzkg)object3).zza(zzhv2, object);
                return;
            }
            boolean bl4 = object3 instanceof zzjs;
            if (bl4) {
                object3 = (zzjs)object3;
                object = (zzjs)object;
                object = zzhv2.zza((zzjs)object3, (zzjs)object);
            } else {
                object3 = ((zzjn)object3).zzhc();
                object = (zzjn)object;
                object = zzhv2.zza((zzjm)object3, (zzjn)object).zzgw();
            }
            this.zzux.zza(zzhv2, object);
            return;
        }
        object3 = this.zzux;
        object = zzht.zzk(object);
        ((zzkg)object3).zza(zzhv2, object);
    }

    private static int zzd(Map.Entry entry) {
        boolean bl2;
        zzlr zzlr2;
        zzhv zzhv2 = (zzhv)entry.getKey();
        Object object = entry.getValue();
        zzlr zzlr3 = zzhv2.zzgn();
        if (zzlr3 == (zzlr2 = zzlr.zzaei) && !(bl2 = zzhv2.zzgo()) && !(bl2 = zzhv2.zzgp())) {
            boolean bl3 = object instanceof zzio;
            if (bl3) {
                int n10 = ((zzhv)entry.getKey()).zzak();
                object = (zzio)object;
                return zzhl.zzb(n10, object);
            }
            int n11 = ((zzhv)entry.getKey()).zzak();
            object = (zzjn)object;
            return zzhl.zzb(n11, object);
        }
        return zzht.zzc(zzhv2, object);
    }

    public static zzht zzgh() {
        return zzva;
    }

    private static Object zzk(Object object) {
        boolean bl2 = object instanceof zzjs;
        if (bl2) {
            return ((zzjs)object).zzeg();
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
        zzhv zzhv2;
        Object object;
        int n10;
        int n11;
        zzht zzht2 = new zzht();
        Iterator iterator2 = null;
        for (n11 = 0; n11 < (n10 = ((zzkg)(object = this.zzux)).zzin()); ++n11) {
            object = this.zzux.zzcc(n11);
            zzhv2 = (zzhv)object.getKey();
            object = object.getValue();
            zzht2.zza(zzhv2, object);
        }
        iterator2 = this.zzux.zzio().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            zzhv2 = (zzhv)object.getKey();
            object = object.getValue();
            zzht2.zza(zzhv2, object);
        }
        n11 = (int)(this.zzuz ? 1 : 0);
        zzht2.zzuz = n11;
        return zzht2;
    }

    public final Iterator descendingIterator() {
        boolean bl2 = this.zzuz;
        if (bl2) {
            Iterator iterator2 = this.zzux.zzip().iterator();
            zzit zzit2 = new zzit(iterator2);
            return zzit2;
        }
        return this.zzux.zzip().iterator();
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzht;
        if (!bl2) {
            return false;
        }
        object = (zzht)object;
        zzkg zzkg2 = this.zzux;
        object = ((zzht)object).zzux;
        return zzkg2.equals(object);
    }

    public final int hashCode() {
        return this.zzux.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzuy;
    }

    public final boolean isInitialized() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        for (int i10 = 0; i10 < (n10 = ((zzkg)(object = this.zzux)).zzin()); ++i10) {
            object = this.zzux.zzcc(i10);
            n10 = (int)(zzht.zzb((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        iterator2 = this.zzux.zzio().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = (int)(zzht.zzb((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public final Iterator iterator() {
        boolean bl2 = this.zzuz;
        if (bl2) {
            Iterator iterator2 = this.zzux.entrySet().iterator();
            zzit zzit2 = new zzit(iterator2);
            return zzit2;
        }
        return this.zzux.entrySet().iterator();
    }

    public final Object zza(zzhv object) {
        zzkg zzkg2 = this.zzux;
        boolean bl2 = (object = zzkg2.get(object)) instanceof zzio;
        if (bl2) {
            object = (zzio)object;
            object = zzio.zzhp();
        }
        return object;
    }

    public final void zza(zzht object) {
        Object object2;
        int n10;
        int n11;
        Map.Entry entry = null;
        for (n11 = 0; n11 < (n10 = ((zzkg)(object2 = ((zzht)object).zzux)).zzin()); ++n11) {
            object2 = ((zzht)object).zzux.zzcc(n11);
            this.zzc((Map.Entry)object2);
        }
        object = ((zzht)object).zzux.zzio().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            entry = (Map.Entry)object.next();
            this.zzc(entry);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void zza(zzhv object, Object list) {
        boolean bl2 = object.zzgo();
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
                zzlk zzlk2 = object.zzgm();
                zzht.zza(zzlk2, e10);
            }
            list = arrayList;
        } else {
            zzlk zzlk3 = object.zzgm();
            zzht.zza(zzlk3, list);
        }
        bl2 = list instanceof zzio;
        if (bl2) {
            this.zzuz = bl2 = true;
        }
        this.zzux.zza((Comparable)object, list);
    }

    public final void zzb(zzhv object, Object object2) {
        boolean bl2 = object.zzgo();
        if (bl2) {
            zzht.zza(object.zzgm(), object2);
            ArrayList<Object> arrayList = this.zza((zzhv)object);
            if (arrayList == null) {
                arrayList = new ArrayList<Object>();
                zzkg zzkg2 = this.zzux;
                zzkg2.zza((Comparable)object, arrayList);
            } else {
                arrayList = arrayList;
            }
            arrayList.add(object2);
            return;
        }
        object = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        throw object;
    }

    public final void zzej() {
        boolean bl2 = this.zzuy;
        if (bl2) {
            return;
        }
        this.zzux.zzej();
        this.zzuy = true;
    }

    public final int zzgi() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = ((zzkg)(object = this.zzux)).zzin()); ++i10) {
            object = this.zzux.zzcc(i10);
            n10 = zzht.zzd((Map.Entry)object);
            n11 += n10;
        }
        iterator2 = this.zzux.zzio().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = zzht.zzd((Map.Entry)object);
            n11 += n10;
        }
        return n11;
    }
}

