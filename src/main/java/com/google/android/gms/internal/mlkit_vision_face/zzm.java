/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzax;
import com.google.android.gms.internal.mlkit_vision_face.zzp;
import com.google.android.gms.internal.mlkit_vision_face.zzq;
import com.google.android.gms.internal.mlkit_vision_face.zzs;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzx;
import com.google.android.gms.internal.mlkit_vision_face.zzy;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public abstract class zzm
extends zzy
implements Serializable {
    private transient Map zza;
    private transient int zzb;

    public zzm(Map object) {
        boolean bl2 = object.isEmpty();
        if (bl2) {
            this.zza = object;
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public static /* synthetic */ int zza(zzm zzm2, int n10) {
        int n11;
        zzm2.zzb = n11 = zzm2.zzb + n10;
        return n11;
    }

    public static /* synthetic */ Iterator zza(Collection collection) {
        return zzm.zzb(collection);
    }

    public static /* synthetic */ Map zza(zzm zzm2) {
        return zzm2.zza;
    }

    public static /* synthetic */ void zza(zzm zzm2, Object object) {
        zzm2.zzc(object);
    }

    public static /* synthetic */ int zzb(zzm zzm2) {
        int n10;
        int n11 = zzm2.zzb;
        zzm2.zzb = n10 = n11 + -1;
        return n11;
    }

    public static /* synthetic */ int zzb(zzm zzm2, int n10) {
        int n11;
        zzm2.zzb = n11 = zzm2.zzb - n10;
        return n11;
    }

    private static Iterator zzb(Collection collection) {
        boolean bl2 = collection instanceof List;
        if (bl2) {
            return ((List)collection).listIterator();
        }
        return collection.iterator();
    }

    public static /* synthetic */ int zzc(zzm zzm2) {
        int n10;
        int n11 = zzm2.zzb;
        zzm2.zzb = n10 = n11 + 1;
        return n11;
    }

    private final void zzc(Object object) {
        Map map = this.zza;
        if ((object = (Collection)zzax.zzc(map, object)) != null) {
            int n10;
            int n11 = object.size();
            object.clear();
            this.zzb = n10 = this.zzb - n11;
        }
    }

    public abstract Collection zza();

    public Collection zza(Object object) {
        Collection collection = (Collection)this.zza.get(object);
        if (collection == null) {
            collection = this.zza();
        }
        return this.zza(object, collection);
    }

    public Collection zza(Object object, Collection collection) {
        zzv zzv2 = new zzv(this, object, collection, null);
        return zzv2;
    }

    public final List zza(Object object, List list, zzv zzv2) {
        boolean bl2 = list instanceof RandomAccess;
        if (bl2) {
            zzs zzs2 = new zzs(this, object, list, zzv2);
            return zzs2;
        }
        zzx zzx2 = new zzx(this, object, list, zzv2);
        return zzx2;
    }

    public boolean zza(Object object, Object object2) {
        Collection collection = (Collection)this.zza.get(object);
        int n10 = 1;
        if (collection == null) {
            collection = this.zza();
            int n11 = collection.add(object2);
            if (n11 != 0) {
                this.zzb = n11 = this.zzb + n10;
                this.zza.put(object, collection);
                return n10 != 0;
            }
            object = new AssertionError((Object)"New Collection violated the Collection spec");
            throw object;
        }
        int n12 = collection.add(object2);
        if (n12 != 0) {
            this.zzb = n12 = this.zzb + n10;
            return n10 != 0;
        }
        return false;
    }

    public void zzb() {
        boolean bl2;
        Iterator iterator2 = this.zza.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Collection collection = (Collection)iterator2.next();
            collection.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final Set zzc() {
        Map map = this.zza;
        zzq zzq2 = new zzq(this, map);
        return zzq2;
    }

    public final Map zzd() {
        Map map = this.zza;
        zzp zzp2 = new zzp(this, map);
        return zzp2;
    }
}

