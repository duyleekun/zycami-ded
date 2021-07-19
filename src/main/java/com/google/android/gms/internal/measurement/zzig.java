/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzkb;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzig
extends zzgc
implements RandomAccess,
zzih {
    public static final zzih zza;
    private static final zzig zzb;
    private final List zzc;

    static {
        zzig zzig2;
        zzb = zzig2 = new zzig(10);
        zzig2.zzb();
        zza = zzig2;
    }

    public zzig() {
        this(10);
    }

    public zzig(int n10) {
        ArrayList arrayList = new ArrayList(n10);
        this.zzc = arrayList;
    }

    private zzig(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    private static String zzj(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzgs;
        if (bl2) {
            object = (zzgs)object;
            Charset charset = zzia.zza;
            return ((zzgs)object).zzl(charset);
        }
        return zzia.zzd((byte[])object);
    }

    public final boolean addAll(int n10, Collection collection) {
        int n11;
        this.zzbL();
        boolean bl2 = collection instanceof zzih;
        if (bl2) {
            collection = ((zzih)collection).zzh();
        }
        n10 = (int)(this.zzc.addAll(n10, collection) ? 1 : 0);
        this.modCount = n11 = this.modCount + 1;
        return n10 != 0;
    }

    public final boolean addAll(Collection collection) {
        int n10 = this.size();
        return ((zzgc)this).addAll(n10, collection);
    }

    public final void clear() {
        int n10;
        this.zzbL();
        this.zzc.clear();
        this.modCount = n10 = this.modCount + 1;
    }

    public final int size() {
        return this.zzc.size();
    }

    public final String zzd(int n10) {
        Object object = this.zzc.get(n10);
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzgs;
        if (bl2) {
            object = (zzgs)object;
            Object object2 = zzia.zza;
            object2 = ((zzgs)object).zzl((Charset)object2);
            boolean bl3 = ((zzgs)object).zzh();
            if (bl3) {
                object = this.zzc;
                object.set(n10, object2);
            }
            return object2;
        }
        object = (byte[])object;
        String string2 = zzia.zzd(object);
        boolean bl4 = zzia.zzc((byte[])object);
        if (bl4) {
            object = this.zzc;
            object.set(n10, string2);
        }
        return string2;
    }

    public final void zzf(zzgs zzgs2) {
        int n10;
        this.zzbL();
        this.zzc.add(zzgs2);
        this.modCount = n10 = this.modCount + 1;
    }

    public final Object zzg(int n10) {
        return this.zzc.get(n10);
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzih zzi() {
        boolean bl2 = this.zza();
        if (bl2) {
            zzkb zzkb2 = new zzkb(this);
            return zzkb2;
        }
        return this;
    }
}

