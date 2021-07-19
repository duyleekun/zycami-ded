/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class zzai
implements Iterator {
    private int zza;
    private int zzb;
    private int zzc;
    private final /* synthetic */ zzaf zzd;

    private zzai(zzaf zzaf2) {
        int n10;
        int n11;
        this.zzd = zzaf2;
        this.zza = n11 = zzaf.zza(zzaf2);
        this.zzb = n10 = zzaf2.zzd();
        this.zzc = -1;
    }

    public /* synthetic */ zzai(zzaf zzaf2, zzae zzae2) {
        this(zzaf2);
    }

    private final void zza() {
        int n10;
        Serializable serializable = this.zzd;
        int n11 = zzaf.zza(serializable);
        if (n11 == (n10 = this.zza)) {
            return;
        }
        serializable = new ConcurrentModificationException();
        throw serializable;
    }

    public boolean hasNext() {
        int n10 = this.zzb;
        return n10 >= 0;
    }

    public Object next() {
        this.zza();
        int n10 = this.hasNext();
        if (n10 != 0) {
            int n11;
            this.zzc = n10 = this.zzb;
            Object object = this.zza(n10);
            zzaf zzaf2 = this.zzd;
            int n12 = this.zzb;
            this.zzb = n11 = zzaf2.zza(n12);
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        zzaf zzaf2;
        this.zza();
        int n10 = this.zzc;
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            zzaf2 = null;
        }
        zzj.zza(n10 != 0, (Object)"no calls to next() since the last call to remove()");
        this.zza = n10 = this.zza + 32;
        zzaf2 = this.zzd;
        Object object = zzaf2.zzb;
        int n11 = this.zzc;
        object = object[n11];
        zzaf2.remove(object);
        n10 = this.zzb;
        int n12 = this.zzc;
        this.zzb = n10 = zzaf.zzb(n10, n12);
        this.zzc = -1;
    }

    public abstract Object zza(int var1);
}

