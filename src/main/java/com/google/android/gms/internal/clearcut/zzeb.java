/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzav;
import com.google.android.gms.internal.clearcut.zzcn;
import java.util.ArrayList;
import java.util.List;

public final class zzeb
extends zzav {
    private static final zzeb zznf;
    private final List zzls;

    static {
        zzeb zzeb2;
        zznf = zzeb2 = new zzeb();
        zzeb2.zzv();
    }

    public zzeb() {
        ArrayList arrayList = new ArrayList(10);
        this(arrayList);
    }

    private zzeb(List list) {
        this.zzls = list;
    }

    public static zzeb zzcn() {
        return zznf;
    }

    public final void add(int n10, Object object) {
        this.zzw();
        this.zzls.add(n10, object);
        this.modCount = n10 = this.modCount + 1;
    }

    public final Object get(int n10) {
        return this.zzls.get(n10);
    }

    public final Object remove(int n10) {
        int n11;
        this.zzw();
        Object e10 = this.zzls.remove(n10);
        this.modCount = n11 = this.modCount + 1;
        return e10;
    }

    public final Object set(int n10, Object object) {
        int n11;
        this.zzw();
        Object object2 = this.zzls.set(n10, object);
        this.modCount = n11 = this.modCount + 1;
        return object2;
    }

    public final int size() {
        return this.zzls.size();
    }

    public final /* synthetic */ zzcn zzi(int n10) {
        int n11 = this.size();
        if (n10 >= n11) {
            ArrayList arrayList = new ArrayList(n10);
            List list = this.zzls;
            arrayList.addAll(list);
            list = new zzeb(arrayList);
            return list;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

