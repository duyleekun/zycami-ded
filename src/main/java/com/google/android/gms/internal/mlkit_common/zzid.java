/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzhs;
import com.google.android.gms.internal.mlkit_common.zzhv;
import com.google.android.gms.internal.mlkit_common.zzia;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class zzid
extends AbstractSet {
    private final /* synthetic */ zzhs zza;

    private zzid(zzhs zzhs2) {
        this.zza = zzhs2;
    }

    public /* synthetic */ zzid(zzhs zzhs2, zzhv zzhv2) {
        this(zzhs2);
    }

    public /* synthetic */ boolean add(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (!bl2) {
            zzhs zzhs2 = this.zza;
            Comparable comparable = (Comparable)object.getKey();
            object = object.getValue();
            zzhs2.zza(comparable, object);
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
        return (object2 = ((zzhs)object2).get(k10)) == (object = object.getValue()) || object2 != null && (bl2 = object2.equals(object));
        {
        }
    }

    public Iterator iterator() {
        zzhs zzhs2 = this.zza;
        zzia zzia2 = new zzia(zzhs2, null);
        return zzia2;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (bl2) {
            zzhs zzhs2 = this.zza;
            object = object.getKey();
            zzhs2.remove(object);
            return true;
        }
        return false;
    }

    public int size() {
        return this.zza.size();
    }
}

