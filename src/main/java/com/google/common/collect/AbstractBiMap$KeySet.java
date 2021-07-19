/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class AbstractBiMap$KeySet
extends ForwardingSet {
    public final /* synthetic */ AbstractBiMap this$0;

    private AbstractBiMap$KeySet(AbstractBiMap abstractBiMap) {
        this.this$0 = abstractBiMap;
    }

    public /* synthetic */ AbstractBiMap$KeySet(AbstractBiMap abstractBiMap, AbstractBiMap$1 abstractBiMap$1) {
        this(abstractBiMap);
    }

    public void clear() {
        this.this$0.clear();
    }

    public Set delegate() {
        return AbstractBiMap.access$100(this.this$0).keySet();
    }

    public Iterator iterator() {
        return Maps.keyIterator(this.this$0.entrySet().iterator());
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object);
        if (!bl2) {
            return false;
        }
        AbstractBiMap.access$200(this.this$0, object);
        return true;
    }

    public boolean removeAll(Collection collection) {
        return this.standardRemoveAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return this.standardRetainAll(collection);
    }
}

