/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.collection.ArrayMap;
import androidx.databinding.MapChangeRegistry;
import androidx.databinding.ObservableMap;
import androidx.databinding.ObservableMap$OnMapChangedCallback;
import java.util.Collection;

public class ObservableArrayMap
extends ArrayMap
implements ObservableMap {
    private transient MapChangeRegistry mListeners;

    private void notifyChange(Object object) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, object);
        }
    }

    public void addOnMapChangedCallback(ObservableMap$OnMapChangedCallback observableMap$OnMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry == null) {
            this.mListeners = mapChangeRegistry = new MapChangeRegistry();
        }
        this.mListeners.add(observableMap$OnMapChangedCallback);
    }

    public void clear() {
        boolean bl2 = this.isEmpty();
        if (!bl2) {
            super.clear();
            bl2 = false;
            this.notifyChange(null);
        }
    }

    public Object put(Object object, Object object2) {
        super.put(object, object2);
        this.notifyChange(object);
        return object2;
    }

    public boolean removeAll(Collection object) {
        int n10;
        object = object.iterator();
        boolean bl2 = false;
        while ((n10 = object.hasNext()) != 0) {
            Object e10 = object.next();
            n10 = this.indexOfKey(e10);
            if (n10 < 0) continue;
            bl2 = true;
            this.removeAt(n10);
        }
        return bl2;
    }

    public Object removeAt(int n10) {
        Object object = this.keyAt(n10);
        Object object2 = super.removeAt(n10);
        if (object2 != null) {
            this.notifyChange(object);
        }
        return object2;
    }

    public void removeOnMapChangedCallback(ObservableMap$OnMapChangedCallback observableMap$OnMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.remove(observableMap$OnMapChangedCallback);
        }
    }

    public boolean retainAll(Collection collection) {
        int n10 = this.size();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        while (n10 >= 0) {
            Object object = this.keyAt(n10);
            boolean bl2 = collection.contains(object);
            if (!bl2) {
                this.removeAt(n10);
                n12 = n11;
            }
            n10 += -1;
        }
        return n12 != 0;
    }

    public Object setValueAt(int n10, Object object) {
        Object object2 = this.keyAt(n10);
        Object object3 = super.setValueAt(n10, object);
        this.notifyChange(object2);
        return object3;
    }
}

