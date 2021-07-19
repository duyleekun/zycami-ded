/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.CompactHashMap;
import java.util.Map;

public final class CompactHashMap$MapEntry
extends AbstractMapEntry {
    private final Object key;
    private int lastKnownIndex;
    public final /* synthetic */ CompactHashMap this$0;

    public CompactHashMap$MapEntry(CompactHashMap object, int n10) {
        this.this$0 = object;
        this.key = object = ((CompactHashMap)object).keys[n10];
        this.lastKnownIndex = n10;
    }

    private void updateLastKnownIndex() {
        block3: {
            Object object;
            Object object2;
            int n10;
            block2: {
                n10 = this.lastKnownIndex;
                int n11 = -1;
                if (n10 == n11 || n10 >= (n11 = (object2 = this.this$0).size())) break block2;
                object = this.key;
                object2 = this.this$0.keys;
                int n12 = this.lastKnownIndex;
                n10 = (int)(Objects.equal(object, object2 = object2[n12]) ? 1 : 0);
                if (n10 != 0) break block3;
            }
            object = this.this$0;
            object2 = this.key;
            this.lastKnownIndex = n10 = CompactHashMap.access$400((CompactHashMap)object, object2);
        }
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        Object object = this.this$0.delegateOrNull();
        if (object != null) {
            Object object2 = this.key;
            return object.get(object2);
        }
        this.updateLastKnownIndex();
        int n10 = this.lastKnownIndex;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 0;
            object = null;
        } else {
            Object[] objectArray = this.this$0.values;
            object = objectArray[n10];
        }
        return object;
    }

    public Object setValue(Object object) {
        Map map = this.this$0.delegateOrNull();
        if (map != null) {
            Object object2 = this.key;
            return map.put(object2, object);
        }
        this.updateLastKnownIndex();
        int n10 = this.lastKnownIndex;
        int n11 = -1;
        if (n10 == n11) {
            map = this.this$0;
            Object object3 = this.key;
            ((CompactHashMap)map).put(object3, object);
            return null;
        }
        Object[] objectArray = this.this$0.values;
        Object object4 = objectArray[n10];
        objectArray[n10] = object;
        return object4;
    }
}

