/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzav;
import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcn;
import com.google.android.gms.internal.clearcut.zzcx;
import com.google.android.gms.internal.clearcut.zzfa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzcw
extends zzav
implements zzcx,
RandomAccess {
    private static final zzcw zzlq;
    private static final zzcx zzlr;
    private final List zzls;

    static {
        zzcw zzcw2;
        zzlq = zzcw2 = new zzcw();
        zzcw2.zzv();
        zzlr = zzcw2;
    }

    public zzcw() {
        this(10);
    }

    public zzcw(int n10) {
        ArrayList arrayList = new ArrayList(n10);
        this(arrayList);
    }

    private zzcw(ArrayList arrayList) {
        this.zzls = arrayList;
    }

    private static String zze(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzbb;
        if (bl2) {
            return ((zzbb)object).zzz();
        }
        return zzci.zzf((byte[])object);
    }

    public final /* synthetic */ void add(int n10, Object object) {
        object = (String)object;
        this.zzw();
        this.zzls.add(n10, object);
        this.modCount = n10 = this.modCount + 1;
    }

    public final boolean addAll(int n10, Collection collection) {
        int n11;
        this.zzw();
        boolean bl2 = collection instanceof zzcx;
        if (bl2) {
            collection = ((zzcx)collection).zzbt();
        }
        n10 = (int)(this.zzls.addAll(n10, collection) ? 1 : 0);
        this.modCount = n11 = this.modCount + 1;
        return n10 != 0;
    }

    public final boolean addAll(Collection collection) {
        int n10 = this.size();
        return ((zzav)this).addAll(n10, collection);
    }

    public final void clear() {
        int n10;
        this.zzw();
        this.zzls.clear();
        this.modCount = n10 = this.modCount + 1;
    }

    public final /* synthetic */ Object get(int n10) {
        Object object = this.zzls.get(n10);
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof zzbb;
        if (bl2) {
            object = (zzbb)object;
            String string2 = ((zzbb)object).zzz();
            boolean bl3 = ((zzbb)object).zzaa();
            if (bl3) {
                object = this.zzls;
                object.set(n10, string2);
            }
            return string2;
        }
        object = (byte[])object;
        String string3 = zzci.zzf((byte[])object);
        boolean bl4 = zzci.zze((byte[])object);
        if (bl4) {
            object = this.zzls;
            object.set(n10, string3);
        }
        return string3;
    }

    public final Object getRaw(int n10) {
        return this.zzls.get(n10);
    }

    public final /* synthetic */ Object remove(int n10) {
        int n11;
        this.zzw();
        Object e10 = this.zzls.remove(n10);
        this.modCount = n11 = this.modCount + 1;
        return zzcw.zze(e10);
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        object = (String)object;
        this.zzw();
        return zzcw.zze(this.zzls.set(n10, object));
    }

    public final int size() {
        return this.zzls.size();
    }

    public final List zzbt() {
        return Collections.unmodifiableList(this.zzls);
    }

    public final zzcx zzbu() {
        boolean bl2 = ((zzav)this).zzu();
        if (bl2) {
            zzfa zzfa2 = new zzfa(this);
            return zzfa2;
        }
        return this;
    }

    public final /* synthetic */ zzcn zzi(int n10) {
        int n11 = this.size();
        if (n10 >= n11) {
            ArrayList arrayList = new ArrayList(n10);
            List list = this.zzls;
            arrayList.addAll(list);
            list = new zzcw(arrayList);
            return list;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

