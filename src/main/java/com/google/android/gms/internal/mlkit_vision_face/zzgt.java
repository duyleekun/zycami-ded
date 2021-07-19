/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzey;
import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzgg;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzgw;
import com.google.android.gms.internal.mlkit_vision_face.zziy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzgt
extends zzey
implements zzgw,
RandomAccess {
    private static final zzgt zza;
    private static final zzgw zzb;
    private final List zzc;

    static {
        zzgt zzgt2;
        zza = zzgt2 = new zzgt();
        zzgt2.zzb();
        zzb = zzgt2;
    }

    public zzgt() {
        this(10);
    }

    public zzgt(int n10) {
        ArrayList arrayList = new ArrayList(n10);
        this(arrayList);
    }

    private zzgt(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    private static String zza(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzez;
        if (bl2) {
            return ((zzez)object).zzb();
        }
        return zzgg.zzb((byte[])object);
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
        boolean bl2 = collection instanceof zzgw;
        if (bl2) {
            collection = ((zzgw)collection).zzd();
        }
        n10 = (int)(this.zzc.addAll(n10, collection) ? 1 : 0);
        this.modCount = n11 = this.modCount + 1;
        return n10 != 0;
    }

    public final boolean addAll(Collection collection) {
        int n10 = this.size();
        return ((zzey)this).addAll(n10, collection);
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
        bl2 = object instanceof zzez;
        if (bl2) {
            object = (zzez)object;
            String string2 = ((zzez)object).zzb();
            boolean bl3 = ((zzez)object).zzc();
            if (bl3) {
                object = this.zzc;
                object.set(n10, string2);
            }
            return string2;
        }
        object = (byte[])object;
        String string3 = zzgg.zzb((byte[])object);
        boolean bl4 = zzgg.zza((byte[])object);
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
        return zzgt.zza(e10);
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        object = (String)object;
        this.zzc();
        return zzgt.zza(this.zzc.set(n10, object));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final Object zza(int n10) {
        return this.zzc.get(n10);
    }

    public final void zza(zzez zzez2) {
        int n10;
        this.zzc();
        this.zzc.add(zzez2);
        this.modCount = n10 = this.modCount + 1;
    }

    public final /* synthetic */ zzgm zzb(int n10) {
        int n11 = this.size();
        if (n10 >= n11) {
            ArrayList arrayList = new ArrayList(n10);
            List list = this.zzc;
            arrayList.addAll(list);
            list = new zzgt(arrayList);
            return list;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final List zzd() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzgw zze() {
        boolean bl2 = ((zzey)this).zza();
        if (bl2) {
            zziy zziy2 = new zziy(this);
            return zziy2;
        }
        return this;
    }
}

