/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzif;
import com.google.android.gms.internal.mlkit_vision_face.zzig;
import com.google.android.gms.internal.mlkit_vision_face.zzio;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class zzin
extends AbstractSet {
    private final /* synthetic */ zzig zza;

    private zzin(zzig zzig2) {
        this.zza = zzig2;
    }

    public /* synthetic */ zzin(zzig zzig2, zzif zzif2) {
        this(zzig2);
    }

    public /* synthetic */ boolean add(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (!bl2) {
            zzig zzig2 = this.zza;
            Comparable comparable = (Comparable)object.getKey();
            object = object.getValue();
            zzig2.zza(comparable, object);
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
        return (object2 = ((zzig)object2).get(k10)) == (object = object.getValue()) || object2 != null && (bl2 = object2.equals(object));
        {
        }
    }

    public Iterator iterator() {
        zzig zzig2 = this.zza;
        zzio zzio2 = new zzio(zzig2, null);
        return zzio2;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (bl2) {
            zzig zzig2 = this.zza;
            object = object.getKey();
            zzig2.remove(object);
            return true;
        }
        return false;
    }

    public int size() {
        return this.zza.size();
    }
}

