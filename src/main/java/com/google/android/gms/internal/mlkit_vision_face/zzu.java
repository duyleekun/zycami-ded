/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class zzu
implements Iterator {
    public final Iterator zza;
    private final Collection zzb;
    private final /* synthetic */ zzv zzc;

    public zzu(zzv object) {
        this.zzc = object;
        object = ((zzv)object).zzb;
        this.zzb = object;
        this.zza = object = zzm.zza((Collection)object);
    }

    public zzu(zzv collection, Iterator iterator2) {
        this.zzc = collection;
        collection = collection.zzb;
        this.zzb = collection;
        this.zza = iterator2;
    }

    public boolean hasNext() {
        this.zza();
        return this.zza.hasNext();
    }

    public Object next() {
        this.zza();
        return this.zza.next();
    }

    public void remove() {
        this.zza.remove();
        zzm.zzb(this.zzc.zzd);
        this.zzc.zzb();
    }

    public final void zza() {
        this.zzc.zza();
        Object object = this.zzc.zzb;
        Collection collection = this.zzb;
        if (object == collection) {
            return;
        }
        object = new ConcurrentModificationException();
        throw object;
    }
}

