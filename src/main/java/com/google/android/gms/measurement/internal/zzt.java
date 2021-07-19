/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcw;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzdp;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzdr;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zziy;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzs;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzt {
    public final /* synthetic */ zzy zza;
    private String zzb;
    private boolean zzc;
    private zzdq zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    public /* synthetic */ zzt(zzy iterator2, String object, zzdq zzdq2, BitSet cloneable, BitSet object2, Map map, Map map2, zzs zzs2) {
        boolean bl2;
        this.zza = iterator2;
        this.zzb = object;
        this.zze = cloneable;
        this.zzf = object2;
        this.zzg = map;
        iterator2 = new Iterator();
        this.zzh = iterator2;
        iterator2 = map2.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (Integer)iterator2.next();
            object2 = (Long)map2.get(object);
            cloneable.add(object2);
            object2 = this.zzh;
            object2.put(object, cloneable);
        }
        this.zzc = false;
        this.zzd = zzdq2;
    }

    public /* synthetic */ zzt(zzy object, String string2, zzs zzs2) {
        this.zza = object;
        this.zzb = string2;
        this.zzc = true;
        this.zze = object = new BitSet();
        this.zzf = object = new BitSet();
        this.zzg = object = new ArrayMap();
        this.zzh = object = new ArrayMap();
    }

    public static /* synthetic */ BitSet zzc(zzt zzt2) {
        return zzt2.zze;
    }

    public final void zza(zzw object) {
        Object object2;
        Object object3;
        BitSet bitSet;
        int n11 = ((zzw)object).zza();
        Object object4 = ((zzw)object).zzd;
        if (object4 != null) {
            bitSet = this.zzf;
            boolean n10 = (Boolean)object4;
            bitSet.set(n11, n10);
        }
        if ((object4 = ((zzw)object).zze) != null) {
            bitSet = this.zze;
            boolean bl2 = (Boolean)object4;
            bitSet.set(n11, bl2);
        }
        object4 = ((zzw)object).zzf;
        long l10 = 1000L;
        if (object4 != null) {
            long l11;
            long l12;
            long l13;
            object4 = this.zzg;
            object3 = n11;
            object4 = (Long)object4.get(object3);
            object2 = ((zzw)object).zzf;
            long l14 = (Long)object2 / l10;
            if (object4 == null || (l13 = (l12 = l14 - (l11 = ((Long)object4).longValue())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                object4 = this.zzg;
                object2 = l14;
                object4.put(object3, object2);
            }
        }
        if ((object4 = ((zzw)object).zzg) != null) {
            object4 = this.zzh;
            Object object5 = n11;
            if ((object4 = (List)object4.get(object5)) == null) {
                object4 = new ArrayList();
                object3 = this.zzh;
                object3.put(object5, object4);
            }
            if ((n11 = (int)(((zzw)object).zzb() ? 1 : 0)) != 0) {
                object4.clear();
            }
            zzlo.zzb();
            object5 = this.zza.zzx.zzc();
            object3 = this.zzb;
            object2 = zzdw.zzaa;
            n11 = (int)(((zzae)object5).zzn((String)object3, (zzdv)object2) ? 1 : 0);
            if (n11 != 0 && (n11 = (int)(((zzw)object).zzc() ? 1 : 0)) != 0) {
                object4.clear();
            }
            zzlo.zzb();
            object5 = this.zza.zzx.zzc();
            object3 = this.zzb;
            n11 = (int)(((zzae)object5).zzn((String)object3, (zzdv)object2) ? 1 : 0);
            if (n11 != 0) {
                long l15 = ((zzw)object).zzg / l10;
                object = l15;
                n11 = (int)(object4.contains(object) ? 1 : 0);
                if (n11 == 0) {
                    object4.add(object);
                    return;
                }
            } else {
                long l16 = ((zzw)object).zzg / l10;
                object = l16;
                object4.add(object);
            }
        }
    }

    public final zzcx zzb(int n10) {
        Object object;
        Object object2;
        Object object3;
        int n11;
        ArrayList<Object> arrayList;
        int n12;
        zzcw zzcw2 = zzcx.zzh();
        zzcw2.zza(n10);
        n10 = (int)(this.zzc ? 1 : 0);
        zzcw2.zzd(n10 != 0);
        zziy zziy2 = this.zzd;
        if (zziy2 != null) {
            zzcw2.zzc((zzdq)zziy2);
        }
        zziy2 = zzdq.zzk();
        ArrayList<Object> arrayList2 = zzkf.zzn(this.zze);
        ((zzdp)zziy2).zzc(arrayList2);
        arrayList2 = zzkf.zzn(this.zzf);
        ((zzdp)zziy2).zza(arrayList2);
        arrayList2 = this.zzg;
        if (arrayList2 == null) {
            n12 = 0;
            arrayList2 = null;
        } else {
            n12 = arrayList2.size();
            arrayList = new ArrayList<Object>(n12);
            arrayList2 = this.zzg.keySet().iterator();
            while ((n11 = arrayList2.hasNext()) != 0) {
                object3 = (Integer)arrayList2.next();
                n11 = (Integer)object3;
                object2 = this.zzg;
                object = n11;
                if ((object2 = (Long)object2.get(object)) == null) continue;
                object = zzcz.zze();
                ((zzcy)object).zza(n11);
                long l10 = (Long)object2;
                ((zzcy)object).zzb(l10);
                object3 = (zzcz)((zzho)object).zzaA();
                arrayList.add(object3);
            }
            arrayList2 = arrayList;
        }
        if (arrayList2 != null) {
            ((zzdp)zziy2).zze(arrayList2);
        }
        if ((arrayList2 = this.zzh) == null) {
            arrayList2 = Collections.emptyList();
        } else {
            n12 = arrayList2.size();
            arrayList = new ArrayList<Object>(n12);
            arrayList2 = this.zzh.keySet().iterator();
            while ((n11 = (int)(arrayList2.hasNext() ? 1 : 0)) != 0) {
                object3 = (Integer)arrayList2.next();
                object2 = zzds.zzf();
                int n13 = (Integer)object3;
                ((zzdr)object2).zza(n13);
                object = this.zzh;
                object3 = (List)object.get(object3);
                if (object3 != null) {
                    Collections.sort(object3);
                    ((zzdr)object2).zzb((Iterable)object3);
                }
                object3 = (zzds)((zzho)object2).zzaA();
                arrayList.add(object3);
            }
            arrayList2 = arrayList;
        }
        ((zzdp)zziy2).zzg(arrayList2);
        zzcw2.zzb((zzdp)zziy2);
        return (zzcx)zzcw2.zzaA();
    }
}

