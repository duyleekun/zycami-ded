/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

public class ImmutableMultimap$2
extends UnmodifiableIterator {
    public final /* synthetic */ ImmutableMultimap this$0;
    public Iterator valueCollectionItr;
    public Iterator valueItr;

    public ImmutableMultimap$2(ImmutableMultimap object) {
        this.this$0 = object;
        this.valueCollectionItr = object = ((ImmutableMultimap)object).map.values().iterator();
        this.valueItr = object = Iterators.emptyIterator();
    }

    public boolean hasNext() {
        Iterator iterator2 = this.valueItr;
        boolean bl2 = iterator2.hasNext();
        if (!bl2 && !(bl2 = (iterator2 = this.valueCollectionItr).hasNext())) {
            bl2 = false;
            iterator2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object next() {
        Iterator iterator2 = this.valueItr;
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            this.valueItr = iterator2 = ((ImmutableCollection)this.valueCollectionItr.next()).iterator();
        }
        return this.valueItr.next();
    }
}

