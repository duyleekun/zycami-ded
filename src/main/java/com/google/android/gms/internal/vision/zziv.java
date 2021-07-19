/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgi;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zziu;
import com.google.android.gms.internal.vision.zzky;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zziv
extends zzgi
implements zziu,
RandomAccess {
    private static final zziv zzzr;
    private static final zziu zzzs;
    private final List zzzt;

    static {
        zziv zziv2;
        zzzr = zziv2 = new zziv();
        zziv2.zzej();
        zzzs = zziv2;
    }

    public zziv() {
        this(10);
    }

    public zziv(int n10) {
        ArrayList arrayList = new ArrayList(n10);
        this(arrayList);
    }

    private zziv(ArrayList arrayList) {
        this.zzzt = arrayList;
    }

    private static String zzm(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzgs;
        if (bl2) {
            return ((zzgs)object).zzfl();
        }
        return zzie.zzh((byte[])object);
    }

    public final /* synthetic */ void add(int n10, Object object) {
        object = (String)object;
        this.zzek();
        this.zzzt.add(n10, object);
        this.modCount = n10 = this.modCount + 1;
    }

    public final boolean addAll(int n10, Collection collection) {
        int n11;
        this.zzek();
        boolean bl2 = collection instanceof zziu;
        if (bl2) {
            collection = ((zziu)collection).zzhs();
        }
        n10 = (int)(this.zzzt.addAll(n10, collection) ? 1 : 0);
        this.modCount = n11 = this.modCount + 1;
        return n10 != 0;
    }

    public final boolean addAll(Collection collection) {
        int n10 = this.size();
        return ((zzgi)this).addAll(n10, collection);
    }

    public final void clear() {
        int n10;
        this.zzek();
        this.zzzt.clear();
        this.modCount = n10 = this.modCount + 1;
    }

    public final /* synthetic */ Object get(int n10) {
        Object object = this.zzzt.get(n10);
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzgs;
        if (bl2) {
            object = (zzgs)object;
            String string2 = ((zzgs)object).zzfl();
            boolean bl3 = ((zzgs)object).zzfm();
            if (bl3) {
                object = this.zzzt;
                object.set(n10, string2);
            }
            return string2;
        }
        object = (byte[])object;
        String string3 = zzie.zzh((byte[])object);
        boolean bl4 = zzie.zzg((byte[])object);
        if (bl4) {
            object = this.zzzt;
            object.set(n10, string3);
        }
        return string3;
    }

    public final /* synthetic */ Object remove(int n10) {
        int n11;
        this.zzek();
        Object e10 = this.zzzt.remove(n10);
        this.modCount = n11 = this.modCount + 1;
        return zziv.zzm(e10);
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        object = (String)object;
        this.zzek();
        return zziv.zzm(this.zzzt.set(n10, object));
    }

    public final int size() {
        return this.zzzt.size();
    }

    public final /* synthetic */ zzik zzan(int n10) {
        int n11 = this.size();
        if (n10 >= n11) {
            ArrayList arrayList = new ArrayList(n10);
            List list = this.zzzt;
            arrayList.addAll(list);
            list = new zziv(arrayList);
            return list;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final Object zzbt(int n10) {
        return this.zzzt.get(n10);
    }

    public final void zzc(zzgs zzgs2) {
        int n10;
        this.zzek();
        this.zzzt.add(zzgs2);
        this.modCount = n10 = this.modCount + 1;
    }

    public final List zzhs() {
        return Collections.unmodifiableList(this.zzzt);
    }

    public final zziu zzht() {
        boolean bl2 = ((zzgi)this).zzei();
        if (bl2) {
            zzky zzky2 = new zzky(this);
            return zzky2;
        }
        return this;
    }
}

