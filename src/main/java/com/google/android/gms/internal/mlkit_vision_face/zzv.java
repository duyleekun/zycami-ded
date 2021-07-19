/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzj;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzu;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class zzv
extends AbstractCollection {
    public final Object zza;
    public Collection zzb;
    public final zzv zzc;
    public final /* synthetic */ zzm zzd;
    private final Collection zze;

    public zzv(zzm object, Object object2, Collection collection, zzv zzv2) {
        this.zzd = object;
        this.zza = object2;
        this.zzb = collection;
        this.zzc = zzv2;
        object = zzv2 == null ? null : zzv2.zzb;
        this.zze = object;
    }

    public boolean add(Object object) {
        this.zza();
        Collection collection = this.zzb;
        boolean bl2 = collection.isEmpty();
        Object object2 = this.zzb;
        boolean bl3 = object2.add(object);
        if (bl3) {
            object2 = this.zzd;
            zzm.zzc((zzm)object2);
            if (bl2) {
                this.zzc();
            }
        }
        return bl3;
    }

    public boolean addAll(Collection collection) {
        int n10 = collection.isEmpty();
        if (n10 != 0) {
            return false;
        }
        n10 = this.size();
        Collection collection2 = this.zzb;
        boolean bl2 = collection2.addAll(collection);
        if (bl2) {
            collection2 = this.zzb;
            int n11 = collection2.size();
            zzm zzm2 = this.zzd;
            zzm.zza(zzm2, n11 -= n10);
            if (n10 == 0) {
                this.zzc();
            }
        }
        return bl2;
    }

    public void clear() {
        int n10 = this.size();
        if (n10 == 0) {
            return;
        }
        this.zzb.clear();
        zzm.zzb(this.zzd, n10);
        this.zzb();
    }

    public boolean contains(Object object) {
        this.zza();
        return this.zzb.contains(object);
    }

    public boolean containsAll(Collection collection) {
        this.zza();
        return this.zzb.containsAll(collection);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        this.zza();
        return this.zzb.equals(object);
    }

    public int hashCode() {
        this.zza();
        return this.zzb.hashCode();
    }

    public Iterator iterator() {
        this.zza();
        zzu zzu2 = new zzu(this);
        return zzu2;
    }

    public boolean remove(Object object) {
        this.zza();
        Object object2 = this.zzb;
        boolean bl2 = object2.remove(object);
        if (bl2) {
            object2 = this.zzd;
            zzm.zzb((zzm)object2);
            this.zzb();
        }
        return bl2;
    }

    public boolean removeAll(Collection collection) {
        int n10 = collection.isEmpty();
        if (n10 != 0) {
            return false;
        }
        n10 = this.size();
        Collection collection2 = this.zzb;
        boolean bl2 = collection2.removeAll(collection);
        if (bl2) {
            collection2 = this.zzb;
            int n11 = collection2.size();
            zzm zzm2 = this.zzd;
            zzm.zza(zzm2, n11 -= n10);
            this.zzb();
        }
        return bl2;
    }

    public boolean retainAll(Collection collection) {
        zzj.zza(collection);
        int n10 = this.size();
        Collection collection2 = this.zzb;
        boolean bl2 = collection2.retainAll(collection);
        if (bl2) {
            collection2 = this.zzb;
            int n11 = collection2.size();
            zzm zzm2 = this.zzd;
            zzm.zza(zzm2, n11 -= n10);
            this.zzb();
        }
        return bl2;
    }

    public int size() {
        this.zza();
        return this.zzb.size();
    }

    public String toString() {
        this.zza();
        return this.zzb.toString();
    }

    public final void zza() {
        Object object = this.zzc;
        if (object != null) {
            ((zzv)object).zza();
            object = this.zzc.zzb;
            Collection collection = this.zze;
            if (object != collection) {
                object = new ConcurrentModificationException();
                throw object;
            }
        } else {
            object = this.zzb;
            boolean bl2 = object.isEmpty();
            if (bl2) {
                object = zzm.zza(this.zzd);
                Object object2 = this.zza;
                if ((object = (Collection)object.get(object2)) != null) {
                    this.zzb = object;
                }
            }
        }
    }

    public final void zzb() {
        Object object;
        Object object2 = this;
        while ((object = ((zzv)object2).zzc) != null) {
            object2 = object;
        }
        object = ((zzv)object2).zzb;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = zzm.zza(((zzv)object2).zzd);
            object2 = ((zzv)object2).zza;
            object.remove(object2);
        }
    }

    public final void zzc() {
        Object object;
        Collection collection = this;
        while ((object = collection.zzc) != null) {
            collection = object;
        }
        object = zzm.zza(collection.zzd);
        Object object2 = collection.zza;
        collection = collection.zzb;
        object.put(object2, collection);
    }
}

