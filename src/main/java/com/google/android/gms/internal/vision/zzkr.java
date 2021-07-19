/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzkg;
import com.google.android.gms.internal.vision.zzkj;
import com.google.android.gms.internal.vision.zzko;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class zzkr
extends AbstractSet {
    private final /* synthetic */ zzkg zzabv;

    private zzkr(zzkg zzkg2) {
        this.zzabv = zzkg2;
    }

    public /* synthetic */ zzkr(zzkg zzkg2, zzkj zzkj2) {
        this(zzkg2);
    }

    public /* synthetic */ boolean add(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (!bl2) {
            zzkg zzkg2 = this.zzabv;
            Comparable comparable = (Comparable)object.getKey();
            object = object.getValue();
            zzkg2.zza(comparable, object);
            return true;
        }
        return false;
    }

    public void clear() {
        this.zzabv.clear();
    }

    public boolean contains(Object object) {
        boolean bl2;
        object = (Map.Entry)object;
        Object object2 = this.zzabv;
        Object k10 = object.getKey();
        return (object2 = ((zzkg)object2).get(k10)) == (object = object.getValue()) || object2 != null && (bl2 = object2.equals(object));
        {
        }
    }

    public Iterator iterator() {
        zzkg zzkg2 = this.zzabv;
        zzko zzko2 = new zzko(zzkg2, null);
        return zzko2;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (bl2) {
            zzkg zzkg2 = this.zzabv;
            object = object.getKey();
            zzkg2.remove(object);
            return true;
        }
        return false;
    }

    public int size() {
        return this.zzabv.size();
    }
}

