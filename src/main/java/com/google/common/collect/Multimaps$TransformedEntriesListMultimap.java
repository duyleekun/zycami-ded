/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap;
import java.util.Collection;
import java.util.List;

public final class Multimaps$TransformedEntriesListMultimap
extends Multimaps$TransformedEntriesMultimap
implements ListMultimap {
    public Multimaps$TransformedEntriesListMultimap(ListMultimap listMultimap, Maps$EntryTransformer maps$EntryTransformer) {
        super(listMultimap, maps$EntryTransformer);
    }

    public List get(Object object) {
        Collection collection = this.fromMultimap.get(object);
        return this.transform(object, collection);
    }

    public List removeAll(Object object) {
        Collection collection = this.fromMultimap.removeAll(object);
        return this.transform(object, collection);
    }

    public List replaceValues(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public List transform(Object object, Collection collection) {
        collection = (List)collection;
        object = Maps.asValueToValueFunction(this.transformer, object);
        return Lists.transform((List)collection, (Function)object);
    }
}

