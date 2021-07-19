/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ArraySet;
import androidx.collection.MapCollections;
import java.util.Map;

public class ArraySet$1
extends MapCollections {
    public final /* synthetic */ ArraySet this$0;

    public ArraySet$1(ArraySet arraySet) {
        this.this$0 = arraySet;
    }

    public void colClear() {
        this.this$0.clear();
    }

    public Object colGetEntry(int n10, int n11) {
        return this.this$0.mArray[n10];
    }

    public Map colGetMap() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("not a map");
        throw unsupportedOperationException;
    }

    public int colGetSize() {
        return this.this$0.mSize;
    }

    public int colIndexOfKey(Object object) {
        return this.this$0.indexOf(object);
    }

    public int colIndexOfValue(Object object) {
        return this.this$0.indexOf(object);
    }

    public void colPut(Object object, Object object2) {
        this.this$0.add(object);
    }

    public void colRemoveAt(int n10) {
        this.this$0.removeAt(n10);
    }

    public Object colSetValue(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("not a map");
        throw unsupportedOperationException;
    }
}

