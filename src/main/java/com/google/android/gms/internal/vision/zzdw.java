/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzdp;
import com.google.android.gms.internal.vision.zzds;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class zzdw
implements Iterator {
    private int currentIndex;
    private final /* synthetic */ zzdp zzmo;
    private int zzmp;
    private int zzmq;

    private zzdw(zzdp zzdp2) {
        int n10;
        int n11;
        this.zzmo = zzdp2;
        this.zzmp = n11 = zzdp.zza(zzdp2);
        this.currentIndex = n10 = zzdp2.zzci();
        this.zzmq = -1;
    }

    public /* synthetic */ zzdw(zzdp zzdp2, zzds zzds2) {
        this(zzdp2);
    }

    private final void zzcn() {
        int n10;
        Serializable serializable = this.zzmo;
        int n11 = zzdp.zza(serializable);
        if (n11 == (n10 = this.zzmp)) {
            return;
        }
        serializable = new ConcurrentModificationException();
        throw serializable;
    }

    public boolean hasNext() {
        int n10 = this.currentIndex;
        return n10 >= 0;
    }

    public Object next() {
        this.zzcn();
        int n10 = this.hasNext();
        if (n10 != 0) {
            int n11;
            this.zzmq = n10 = this.currentIndex;
            Object object = this.zzu(n10);
            zzdp zzdp2 = this.zzmo;
            int n12 = this.currentIndex;
            this.currentIndex = n11 = zzdp2.zzt(n12);
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        zzdp zzdp2;
        this.zzcn();
        int n10 = this.zzmq;
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            zzdp2 = null;
        }
        zzde.checkState(n10 != 0, "no calls to next() since the last call to remove()");
        this.zzmp = n10 = this.zzmp + 32;
        zzdp2 = this.zzmo;
        Object object = zzdp2.zzmi;
        int n11 = this.zzmq;
        object = object[n11];
        zzdp2.remove(object);
        n10 = this.currentIndex;
        int n12 = this.zzmq;
        this.currentIndex = n10 = zzdp.zzg(n10, n12);
        this.zzmq = -1;
    }

    public abstract Object zzu(int var1);
}

