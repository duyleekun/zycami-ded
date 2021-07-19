/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzek;
import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzfs;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzgi;
import com.google.android.gms.internal.mlkit_common.zzik;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzgj
extends zzek
implements zzgi,
RandomAccess {
    private static final zzgj zza;
    private static final zzgi zzb;
    private final List zzc;

    static {
        zzgj zzgj2;
        zza = zzgj2 = new zzgj();
        zzgj2.b_();
        zzb = zzgj2;
    }

    public zzgj() {
        this(10);
    }

    public zzgj(int n10) {
        ArrayList arrayList = new ArrayList(n10);
        this(arrayList);
    }

    private zzgj(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    private static String zza(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzep;
        if (bl2) {
            return ((zzep)object).zzb();
        }
        return zzfs.zzb((byte[])object);
    }

    public final zzgi a_() {
        boolean bl2 = ((zzek)this).zza();
        if (bl2) {
            zzik zzik2 = new zzik(this);
            return zzik2;
        }
        return this;
    }

    public final /* synthetic */ void add(int n10, Object object) {
        object = (String)object;
        this.zzc();
        this.zzc.add(n10, object);
        this.modCount = n10 = this.modCount + 1;
    }

    public final boolean addAll(int n10, Collection collection) {
        int n11;
        this.zzc();
        boolean bl2 = collection instanceof zzgi;
        if (bl2) {
            collection = ((zzgi)collection).zzb();
        }
        n10 = (int)(this.zzc.addAll(n10, collection) ? 1 : 0);
        this.modCount = n11 = this.modCount + 1;
        return n10 != 0;
    }

    public final boolean addAll(Collection collection) {
        int n10 = this.size();
        return ((zzek)this).addAll(n10, collection);
    }

    public final void clear() {
        int n10;
        this.zzc();
        this.zzc.clear();
        this.modCount = n10 = this.modCount + 1;
    }

    public final /* synthetic */ Object get(int n10) {
        Object object = this.zzc.get(n10);
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzep;
        if (bl2) {
            object = (zzep)object;
            String string2 = ((zzep)object).zzb();
            boolean bl3 = ((zzep)object).zzc();
            if (bl3) {
                object = this.zzc;
                object.set(n10, string2);
            }
            return string2;
        }
        object = (byte[])object;
        String string3 = zzfs.zzb((byte[])object);
        boolean bl4 = zzfs.zza((byte[])object);
        if (bl4) {
            object = this.zzc;
            object.set(n10, string3);
        }
        return string3;
    }

    public final /* synthetic */ Object remove(int n10) {
        int n11;
        this.zzc();
        Object e10 = this.zzc.remove(n10);
        this.modCount = n11 = this.modCount + 1;
        return zzgj.zza(e10);
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        object = (String)object;
        this.zzc();
        return zzgj.zza(this.zzc.set(n10, object));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final Object zza(int n10) {
        return this.zzc.get(n10);
    }

    public final void zza(zzep zzep2) {
        int n10;
        this.zzc();
        this.zzc.add(zzep2);
        this.modCount = n10 = this.modCount + 1;
    }

    public final /* synthetic */ zzfy zzb(int n10) {
        int n11 = this.size();
        if (n10 >= n11) {
            ArrayList arrayList = new ArrayList(n10);
            List list = this.zzc;
            arrayList.addAll(list);
            list = new zzgj(arrayList);
            return list;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final List zzb() {
        return Collections.unmodifiableList(this.zzc);
    }
}

