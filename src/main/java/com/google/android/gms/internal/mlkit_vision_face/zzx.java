/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzw;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class zzx
extends zzv
implements List {
    public final /* synthetic */ zzm zzd;

    public zzx(zzm zzm2, Object object, List list, zzv zzv2) {
        this.zzd = zzm2;
        super(zzm2, object, list, zzv2);
    }

    public void add(int n10, Object object) {
        this.zza();
        Collection collection = this.zzb;
        boolean bl2 = collection.isEmpty();
        List list = (List)this.zzb;
        list.add(n10, object);
        zzm zzm2 = this.zzd;
        zzm.zzc(zzm2);
        if (bl2) {
            this.zzc();
        }
    }

    public boolean addAll(int n10, Collection collection) {
        int n11 = collection.isEmpty();
        if (n11 != 0) {
            return false;
        }
        n11 = this.size();
        Object object = (List)this.zzb;
        if ((n10 = (int)(object.addAll(n10, collection) ? 1 : 0)) != 0) {
            collection = this.zzb;
            int n12 = collection.size();
            object = this.zzd;
            zzm.zza((zzm)object, n12 -= n11);
            if (n11 == 0) {
                this.zzc();
            }
        }
        return n10 != 0;
    }

    public Object get(int n10) {
        this.zza();
        return ((List)this.zzb).get(n10);
    }

    public int indexOf(Object object) {
        this.zza();
        return ((List)this.zzb).indexOf(object);
    }

    public int lastIndexOf(Object object) {
        this.zza();
        return ((List)this.zzb).lastIndexOf(object);
    }

    public ListIterator listIterator() {
        this.zza();
        zzw zzw2 = new zzw(this);
        return zzw2;
    }

    public ListIterator listIterator(int n10) {
        this.zza();
        zzw zzw2 = new zzw(this, n10);
        return zzw2;
    }

    public Object remove(int n10) {
        this.zza();
        Object e10 = ((List)this.zzb).remove(n10);
        zzm.zzb(this.zzd);
        this.zzb();
        return e10;
    }

    public Object set(int n10, Object object) {
        this.zza();
        return ((List)this.zzb).set(n10, object);
    }

    public List subList(int n10, int n11) {
        this.zza();
        zzm zzm2 = this.zzd;
        Object object = this.zza;
        List list = (List)this.zzb;
        List list2 = list.subList(n10, n11);
        zzv zzv2 = this.zzc;
        if (zzv2 == null) {
            zzv2 = this;
        }
        return zzm2.zza(object, list2, zzv2);
    }
}

