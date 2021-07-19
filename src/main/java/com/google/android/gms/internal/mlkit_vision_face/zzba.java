/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaz;
import com.google.android.gms.internal.mlkit_vision_face.zzh;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class zzba
extends AbstractCollection {
    private final Map zza;

    public zzba(Map map) {
        this.zza = map = (Map)zzj.zza(map);
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object object) {
        return this.zza.containsValue(object);
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final Iterator iterator() {
        Iterator iterator2 = this.zza.entrySet().iterator();
        zzaz zzaz2 = new zzaz(iterator2);
        return zzaz2;
    }

    public final boolean remove(Object object) {
        try {
            return super.remove(object);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            boolean bl2;
            Iterator iterator2 = this.zza.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Object v10 = entry.getValue();
                boolean bl3 = zzh.zza(object, v10);
                if (!bl3) continue;
                object = this.zza;
                iterator2 = entry.getKey();
                object.remove(iterator2);
                return true;
            }
            return false;
        }
    }

    public final boolean removeAll(Collection collection) {
        Collection collection2;
        try {
            collection2 = zzj.zza(collection);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            boolean bl2;
            collection2 = new Collection();
            Iterator iterator2 = this.zza.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Object v10 = entry.getValue();
                boolean bl3 = collection.contains(v10);
                if (!bl3) continue;
                entry = entry.getKey();
                collection2.add(entry);
            }
            return this.zza.keySet().removeAll(collection2);
        }
        collection2 = collection2;
        return super.removeAll(collection2);
    }

    public final boolean retainAll(Collection collection) {
        Collection collection2;
        try {
            collection2 = zzj.zza(collection);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            boolean bl2;
            collection2 = new Collection();
            Iterator iterator2 = this.zza.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Object v10 = entry.getValue();
                boolean bl3 = collection.contains(v10);
                if (!bl3) continue;
                entry = entry.getKey();
                collection2.add(entry);
            }
            return this.zza.keySet().retainAll(collection2);
        }
        collection2 = collection2;
        return super.retainAll(collection2);
    }

    public final int size() {
        return this.zza.size();
    }
}

