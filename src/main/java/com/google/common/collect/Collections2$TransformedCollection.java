/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class Collections2$TransformedCollection
extends AbstractCollection {
    public final Collection fromCollection;
    public final Function function;

    public Collections2$TransformedCollection(Collection object, Function function) {
        object = (Collection)Preconditions.checkNotNull(object);
        this.fromCollection = object;
        this.function = object = (Function)Preconditions.checkNotNull(function);
    }

    public void clear() {
        this.fromCollection.clear();
    }

    public boolean isEmpty() {
        return this.fromCollection.isEmpty();
    }

    public Iterator iterator() {
        Iterator iterator2 = this.fromCollection.iterator();
        Function function = this.function;
        return Iterators.transform(iterator2, function);
    }

    public int size() {
        return this.fromCollection.size();
    }
}

