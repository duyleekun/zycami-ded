/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzes;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class zzde
extends AbstractList
implements zzes {
    private boolean zza = true;

    public void add(int n10, Object object) {
        this.zzc();
        super.add(n10, object);
    }

    public boolean add(Object object) {
        this.zzc();
        return super.add(object);
    }

    public boolean addAll(int n10, Collection collection) {
        this.zzc();
        return super.addAll(n10, collection);
    }

    public boolean addAll(Collection collection) {
        this.zzc();
        return super.addAll(collection);
    }

    public void clear() {
        this.zzc();
        super.clear();
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof List;
        if (n11 == 0) {
            return false;
        }
        n11 = object instanceof RandomAccess;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (List)object;
        n11 = this.size();
        if (n11 != (n10 = object.size())) {
            return false;
        }
        for (n10 = 0; n10 < n11; ++n10) {
            Object e10;
            Object e11 = this.get(n10);
            boolean bl3 = e11.equals(e10 = object.get(n10));
            if (bl3) continue;
            return false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.size();
        int n11 = 1;
        for (int i10 = 0; i10 < n10; ++i10) {
            n11 *= 31;
            Object e10 = this.get(i10);
            int n12 = e10.hashCode();
            n11 += n12;
        }
        return n11;
    }

    public Object remove(int n10) {
        this.zzc();
        return super.remove(n10);
    }

    public boolean remove(Object object) {
        this.zzc();
        return super.remove(object);
    }

    public boolean removeAll(Collection collection) {
        this.zzc();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        this.zzc();
        return super.retainAll(collection);
    }

    public Object set(int n10, Object object) {
        this.zzc();
        return super.set(n10, object);
    }

    public boolean zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zza = false;
    }

    public final void zzc() {
        boolean bl2 = this.zza;
        if (bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

