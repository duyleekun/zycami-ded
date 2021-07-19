/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.MapCollections$EntrySet;
import androidx.collection.MapCollections$KeySet;
import androidx.collection.MapCollections$ValuesCollection;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class MapCollections {
    public MapCollections$EntrySet mEntrySet;
    public MapCollections$KeySet mKeySet;
    public MapCollections$ValuesCollection mValues;

    public static boolean containsAllHelper(Map map, Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = map.containsKey(e10);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static boolean equalsSetHelper(Set set, Object object) {
        boolean bl2 = true;
        if (set == object) {
            return bl2;
        }
        int n10 = object instanceof Set;
        if (n10 != 0) {
            block7: {
                block6: {
                    object = (Set)object;
                    n10 = set.size();
                    int n11 = object.size();
                    if (n10 != n11) break block6;
                    try {
                        boolean bl3 = set.containsAll((Collection<?>)object);
                        if (bl3) break block7;
                    }
                    catch (ClassCastException | NullPointerException runtimeException) {}
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public static boolean removeAllHelper(Map map, Collection object) {
        boolean bl2;
        int n10 = map.size();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            map.remove(e10);
        }
        int n11 = map.size();
        if (n10 != n11) {
            n11 = 1;
        } else {
            n11 = 0;
            map = null;
        }
        return n11 != 0;
    }

    public static boolean retainAllHelper(Map map, Collection collection) {
        boolean bl2;
        int n10 = map.size();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object k10 = iterator2.next();
            bl2 = collection.contains(k10);
            if (bl2) continue;
            iterator2.remove();
        }
        int n11 = map.size();
        if (n10 != n11) {
            n11 = 1;
        } else {
            n11 = 0;
            map = null;
        }
        return n11 != 0;
    }

    public abstract void colClear();

    public abstract Object colGetEntry(int var1, int var2);

    public abstract Map colGetMap();

    public abstract int colGetSize();

    public abstract int colIndexOfKey(Object var1);

    public abstract int colIndexOfValue(Object var1);

    public abstract void colPut(Object var1, Object var2);

    public abstract void colRemoveAt(int var1);

    public abstract Object colSetValue(int var1, Object var2);

    public Set getEntrySet() {
        MapCollections$EntrySet mapCollections$EntrySet = this.mEntrySet;
        if (mapCollections$EntrySet == null) {
            this.mEntrySet = mapCollections$EntrySet = new MapCollections$EntrySet(this);
        }
        return this.mEntrySet;
    }

    public Set getKeySet() {
        MapCollections$KeySet mapCollections$KeySet = this.mKeySet;
        if (mapCollections$KeySet == null) {
            this.mKeySet = mapCollections$KeySet = new MapCollections$KeySet(this);
        }
        return this.mKeySet;
    }

    public Collection getValues() {
        MapCollections$ValuesCollection mapCollections$ValuesCollection = this.mValues;
        if (mapCollections$ValuesCollection == null) {
            this.mValues = mapCollections$ValuesCollection = new MapCollections$ValuesCollection(this);
        }
        return this.mValues;
    }

    public Object[] toArrayHelper(int n10) {
        int n11 = this.colGetSize();
        Object[] objectArray = new Object[n11];
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            objectArray[i10] = object = this.colGetEntry(i10, n10);
        }
        return objectArray;
    }

    public Object[] toArrayHelper(Object[] objectArray, int n10) {
        int n11 = objectArray.length;
        int n12 = this.colGetSize();
        if (n11 < n12) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n12);
        }
        for (n11 = 0; n11 < n12; ++n11) {
            Object object;
            objectArray[n11] = object = this.colGetEntry(n11, n10);
        }
        n10 = objectArray.length;
        if (n10 > n12) {
            n10 = 0;
            objectArray[n12] = null;
        }
        return objectArray;
    }
}

