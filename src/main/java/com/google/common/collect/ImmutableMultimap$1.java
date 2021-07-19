/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;

public class ImmutableMultimap$1
extends UnmodifiableIterator {
    public final Iterator asMapItr;
    public Object currentKey;
    public final /* synthetic */ ImmutableMultimap this$0;
    public Iterator valueItr;

    public ImmutableMultimap$1(ImmutableMultimap object) {
        this.this$0 = object;
        this.asMapItr = object = ((ImmutableMultimap)object).map.entrySet().iterator();
        this.currentKey = null;
        this.valueItr = object = Iterators.emptyIterator();
    }

    public boolean hasNext() {
        Iterator iterator2 = this.valueItr;
        boolean bl2 = iterator2.hasNext();
        if (!bl2 && !(bl2 = (iterator2 = this.asMapItr).hasNext())) {
            bl2 = false;
            iterator2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Map.Entry next() {
        Object object;
        Object object2 = this.valueItr;
        boolean bl2 = object2.hasNext();
        if (!bl2) {
            object2 = (Map.Entry)this.asMapItr.next();
            object = object2.getKey();
            this.currentKey = object;
            this.valueItr = object2 = ((ImmutableCollection)object2.getValue()).iterator();
        }
        object2 = this.currentKey;
        object = this.valueItr.next();
        return Maps.immutableEntry(object2, object);
    }
}

