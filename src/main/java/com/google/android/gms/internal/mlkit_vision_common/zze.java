/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzd;
import com.google.android.gms.internal.mlkit_vision_common.zzl;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class zze
extends AbstractCollection
implements Serializable {
    private static final Object[] zza = new Object[0];

    public final boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean addAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public /* synthetic */ Iterator iterator() {
        return this.zza();
    }

    public final boolean remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean removeAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean retainAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final Object[] toArray() {
        Object[] objectArray = zza;
        return this.toArray(objectArray);
    }

    public final Object[] toArray(Object[] object) {
        zzd.zza(object);
        int n10 = this.size();
        int n11 = ((Object[])object).length;
        if (n11 < n10) {
            Object[] objectArray = this.zzb();
            if (objectArray != null) {
                n10 = this.zzc();
                int n12 = this.zzd();
                object = object.getClass();
                return Arrays.copyOfRange(objectArray, n10, n12, (Class<? extends T[]>)object);
            }
            object = (Object[])Array.newInstance(object.getClass().getComponentType(), n10);
        } else {
            n11 = ((Object[])object).length;
            if (n11 > n10) {
                n11 = 0;
                Object var4_5 = null;
                object[n10] = null;
            }
        }
        this.zza((Object[])object, 0);
        return object;
    }

    public int zza(Object[] objectArray, int n10) {
        boolean bl2;
        zzl zzl2 = (zzl)this.iterator();
        while (bl2 = zzl2.hasNext()) {
            Object e10 = zzl2.next();
            int n11 = n10 + 1;
            objectArray[n10] = e10;
            n10 = n11;
        }
        return n10;
    }

    public abstract zzl zza();

    public Object[] zzb() {
        return null;
    }

    public int zzc() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int zzd() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

