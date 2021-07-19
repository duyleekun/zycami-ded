/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import java.util.AbstractCollection;
import java.util.Iterator;

public class AbstractMultimap$Values
extends AbstractCollection {
    public final /* synthetic */ AbstractMultimap this$0;

    public AbstractMultimap$Values(AbstractMultimap abstractMultimap) {
        this.this$0 = abstractMultimap;
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
    }

    public Iterator iterator() {
        return this.this$0.valueIterator();
    }

    public int size() {
        return this.this$0.size();
    }
}

