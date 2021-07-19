/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import java.util.AbstractSet;
import java.util.Iterator;

public class CompactHashMap$KeySetView
extends AbstractSet {
    public final /* synthetic */ CompactHashMap this$0;

    public CompactHashMap$KeySetView(CompactHashMap compactHashMap) {
        this.this$0 = compactHashMap;
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    public Iterator iterator() {
        return this.this$0.keySetIterator();
    }

    public boolean remove(Object object) {
        boolean bl2;
        Object object2 = this.this$0.delegateOrNull();
        if (object2 != null) {
            object2 = object2.keySet();
            bl2 = object2.remove(object);
        } else if ((object = CompactHashMap.access$100(this.this$0, object)) != (object2 = CompactHashMap.access$200())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int size() {
        return this.this$0.size();
    }
}

