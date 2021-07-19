/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzgl;
import com.google.android.gms.internal.mlkit_vision_common.zzgm;
import com.google.android.gms.internal.mlkit_vision_common.zzgu;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class zzgt
extends AbstractSet {
    private final /* synthetic */ zzgm zza;

    private zzgt(zzgm zzgm2) {
        this.zza = zzgm2;
    }

    public /* synthetic */ zzgt(zzgm zzgm2, zzgl zzgl2) {
        this(zzgm2);
    }

    public /* synthetic */ boolean add(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (!bl2) {
            zzgm zzgm2 = this.zza;
            Comparable comparable = (Comparable)object.getKey();
            object = object.getValue();
            zzgm2.zza(comparable, object);
            return true;
        }
        return false;
    }

    public void clear() {
        this.zza.clear();
    }

    public boolean contains(Object object) {
        boolean bl2;
        object = (Map.Entry)object;
        Object object2 = this.zza;
        Object k10 = object.getKey();
        return (object2 = ((zzgm)object2).get(k10)) == (object = object.getValue()) || object2 != null && (bl2 = object2.equals(object));
        {
        }
    }

    public Iterator iterator() {
        zzgm zzgm2 = this.zza;
        zzgu zzgu2 = new zzgu(zzgm2, null);
        return zzgu2;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (bl2) {
            zzgm zzgm2 = this.zza;
            object = object.getKey();
            zzgm2.remove(object);
            return true;
        }
        return false;
    }

    public int size() {
        return this.zza.size();
    }
}

