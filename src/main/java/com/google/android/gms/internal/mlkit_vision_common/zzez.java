/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzde;
import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzem;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzfc;
import com.google.android.gms.internal.mlkit_vision_common.zzhe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzez
extends zzde
implements zzfc,
RandomAccess {
    private static final zzez zza;
    private static final zzfc zzb;
    private final List zzc;

    static {
        zzez zzez2;
        zza = zzez2 = new zzez();
        zzez2.zzb();
        zzb = zzez2;
    }

    public zzez() {
        this(10);
    }

    public zzez(int n10) {
        ArrayList arrayList = new ArrayList(n10);
        this(arrayList);
    }

    private zzez(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    private static String zza(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzdf;
        if (bl2) {
            return ((zzdf)object).zzb();
        }
        return zzem.zzb((byte[])object);
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
        boolean bl2 = collection instanceof zzfc;
        if (bl2) {
            collection = ((zzfc)collection).zzd();
        }
        n10 = (int)(this.zzc.addAll(n10, collection) ? 1 : 0);
        this.modCount = n11 = this.modCount + 1;
        return n10 != 0;
    }

    public final boolean addAll(Collection collection) {
        int n10 = this.size();
        return ((zzde)this).addAll(n10, collection);
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
        bl2 = object instanceof zzdf;
        if (bl2) {
            object = (zzdf)object;
            String string2 = ((zzdf)object).zzb();
            boolean bl3 = ((zzdf)object).zzc();
            if (bl3) {
                object = this.zzc;
                object.set(n10, string2);
            }
            return string2;
        }
        object = (byte[])object;
        String string3 = zzem.zzb((byte[])object);
        boolean bl4 = zzem.zza((byte[])object);
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
        return zzez.zza(e10);
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        object = (String)object;
        this.zzc();
        return zzez.zza(this.zzc.set(n10, object));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final Object zza(int n10) {
        return this.zzc.get(n10);
    }

    public final void zza(zzdf zzdf2) {
        int n10;
        this.zzc();
        this.zzc.add(zzdf2);
        this.modCount = n10 = this.modCount + 1;
    }

    public final /* synthetic */ zzes zzb(int n10) {
        int n11 = this.size();
        if (n10 >= n11) {
            ArrayList arrayList = new ArrayList(n10);
            List list = this.zzc;
            arrayList.addAll(list);
            list = new zzez(arrayList);
            return list;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final List zzd() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzfc zze() {
        boolean bl2 = ((zzde)this).zza();
        if (bl2) {
            zzhe zzhe2 = new zzhe(this);
            return zzhe2;
        }
        return this;
    }
}

