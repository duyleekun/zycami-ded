/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzjl;
import com.google.android.gms.internal.measurement.zzjs;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzkp;
import java.util.ArrayList;
import java.util.List;

public final class zzhj {
    private static final zzhj zzd;
    public final zzjs zza;
    private boolean zzb;
    private boolean zzc;

    static {
        zzhj zzhj2;
        zzd = zzhj2 = new zzhj(true);
    }

    private zzhj() {
        zzjl zzjl2 = new zzjl(16);
        this.zza = zzjl2;
    }

    private zzhj(boolean bl2) {
        zzjl zzjl2 = new zzjl(0);
        this.zza = zzjl2;
        this.zzb();
        this.zzb();
    }

    public static zzhj zza() {
        throw null;
    }

    private static final void zzd(zzhi object, Object object2) {
        Object[] objectArray;
        Object object3;
        block13: {
            block14: {
                object3 = object.zzb();
                zzia.zza(object2);
                objectArray = zzko.zza;
                objectArray = zzkp.zza;
                object3 = ((zzko)((Object)object3)).zza();
                int n10 = ((Enum)object3).ordinal();
                switch (n10) {
                    default: {
                        break block13;
                    }
                    case 8: {
                        n10 = object2 instanceof zzix;
                        if (n10 == 0 && (n10 = object2 instanceof zzie) == 0) break block13;
                        break block14;
                    }
                    case 7: {
                        n10 = object2 instanceof Integer;
                        if (n10 == 0 && (n10 = object2 instanceof zzhu) == 0) break block13;
                        break block14;
                    }
                    case 6: {
                        n10 = object2 instanceof zzgs;
                        if (n10 == 0 && (n10 = object2 instanceof byte[]) == 0) break block13;
                        break block14;
                    }
                    case 5: {
                        n10 = object2 instanceof String;
                        break;
                    }
                    case 4: {
                        n10 = object2 instanceof Boolean;
                        break;
                    }
                    case 3: {
                        n10 = object2 instanceof Double;
                        break;
                    }
                    case 2: {
                        n10 = object2 instanceof Float;
                        break;
                    }
                    case 1: {
                        n10 = object2 instanceof Long;
                        break;
                    }
                    case 0: {
                        n10 = object2 instanceof Integer;
                    }
                }
                if (n10 == 0) break block13;
            }
            return;
        }
        objectArray = new Object[3];
        Integer n11 = object.zza();
        objectArray[0] = n11;
        object = object.zzb().zza();
        objectArray[1] = object;
        objectArray[2] = object2 = object2.getClass().getName();
        object = String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", objectArray);
        object3 = new IllegalArgumentException((String)object);
        throw object3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzhj;
        if (!bl2) {
            return false;
        }
        object = (zzhj)object;
        zzjs zzjs2 = this.zza;
        object = ((zzhj)object).zza;
        return zzjs2.equals(object);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void zzc(zzhi object, Object list) {
        boolean bl2 = object.zzc();
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
                zzhj.zzd((zzhi)object, e10);
            }
            list = arrayList;
        } else {
            zzhj.zzd((zzhi)object, list);
        }
        bl2 = list instanceof zzie;
        if (bl2) {
            this.zzc = bl2 = true;
        }
        this.zza.zzf((Comparable)object, list);
    }
}

