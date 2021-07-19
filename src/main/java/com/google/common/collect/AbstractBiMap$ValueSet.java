/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Set;

public class AbstractBiMap$ValueSet
extends ForwardingSet {
    public final /* synthetic */ AbstractBiMap this$0;
    public final Set valuesDelegate;

    private AbstractBiMap$ValueSet(AbstractBiMap object) {
        this.this$0 = object;
        this.valuesDelegate = object = ((AbstractBiMap)object).inverse.keySet();
    }

    public /* synthetic */ AbstractBiMap$ValueSet(AbstractBiMap abstractBiMap, AbstractBiMap$1 abstractBiMap$1) {
        this(abstractBiMap);
    }

    public Set delegate() {
        return this.valuesDelegate;
    }

    public Iterator iterator() {
        return Maps.valueIterator(this.this$0.entrySet().iterator());
    }

    public Object[] toArray() {
        return this.standardToArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.standardToArray(objectArray);
    }

    public String toString() {
        return this.standardToString();
    }
}

