/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzei;
import com.google.android.gms.internal.clearcut.zzej;
import com.google.android.gms.internal.clearcut.zzeq;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class zzer
extends AbstractSet {
    private final /* synthetic */ zzei zzos;

    private zzer(zzei zzei2) {
        this.zzos = zzei2;
    }

    public /* synthetic */ zzer(zzei zzei2, zzej zzej2) {
        this(zzei2);
    }

    public /* synthetic */ boolean add(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (!bl2) {
            zzei zzei2 = this.zzos;
            Comparable comparable = (Comparable)object.getKey();
            object = object.getValue();
            zzei2.zza(comparable, object);
            return true;
        }
        return false;
    }

    public void clear() {
        this.zzos.clear();
    }

    public boolean contains(Object object) {
        boolean bl2;
        object = (Map.Entry)object;
        Object object2 = this.zzos;
        Object k10 = object.getKey();
        return (object2 = ((zzei)object2).get(k10)) == (object = object.getValue()) || object2 != null && (bl2 = object2.equals(object));
        {
        }
    }

    public Iterator iterator() {
        zzei zzei2 = this.zzos;
        zzeq zzeq2 = new zzeq(zzei2, null);
        return zzeq2;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (bl2) {
            zzei zzei2 = this.zzos;
            object = object.getKey();
            zzei2.remove(object);
            return true;
        }
        return false;
    }

    public int size() {
        return this.zzos.size();
    }
}

