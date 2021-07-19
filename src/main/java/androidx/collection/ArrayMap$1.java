/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import java.util.Map;

public class ArrayMap$1
extends MapCollections {
    public final /* synthetic */ ArrayMap this$0;

    public ArrayMap$1(ArrayMap arrayMap) {
        this.this$0 = arrayMap;
    }

    public void colClear() {
        this.this$0.clear();
    }

    public Object colGetEntry(int n10, int n11) {
        Object[] objectArray = this.this$0.mArray;
        n10 = (n10 << 1) + n11;
        return objectArray[n10];
    }

    public Map colGetMap() {
        return this.this$0;
    }

    public int colGetSize() {
        return this.this$0.mSize;
    }

    public int colIndexOfKey(Object object) {
        return this.this$0.indexOfKey(object);
    }

    public int colIndexOfValue(Object object) {
        return this.this$0.indexOfValue(object);
    }

    public void colPut(Object object, Object object2) {
        this.this$0.put(object, object2);
    }

    public void colRemoveAt(int n10) {
        this.this$0.removeAt(n10);
    }

    public Object colSetValue(int n10, Object object) {
        return this.this$0.setValueAt(n10, object);
    }
}

