/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzee;
import com.google.android.gms.internal.vision.zzfa;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class zzeb
extends AbstractCollection
implements Serializable {
    private static final Object[] zzmu = new Object[0];

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

    public abstract boolean contains(Object var1);

    public /* synthetic */ Iterator iterator() {
        return this.zzcp();
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
        Object[] objectArray = zzmu;
        return this.toArray(objectArray);
    }

    public final Object[] toArray(Object[] object) {
        zzde.checkNotNull(object);
        int n10 = this.size();
        int n11 = ((Object[])object).length;
        if (n11 < n10) {
            Object[] objectArray = this.zzcq();
            if (objectArray != null) {
                n10 = this.zzcr();
                int n12 = this.zzcs();
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
        zzfa zzfa2 = (zzfa)this.iterator();
        while (bl2 = zzfa2.hasNext()) {
            Object e10 = zzfa2.next();
            int n11 = n10 + 1;
            objectArray[n10] = e10;
            n10 = n11;
        }
        return n10;
    }

    public abstract zzfa zzcp();

    public Object[] zzcq() {
        return null;
    }

    public int zzcr() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int zzcs() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public zzee zzct() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return zzee.zzcv();
        }
        return zzee.zza(this.toArray());
    }

    public abstract boolean zzcu();
}

