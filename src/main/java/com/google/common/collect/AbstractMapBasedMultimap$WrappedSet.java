/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

public class AbstractMapBasedMultimap$WrappedSet
extends AbstractMapBasedMultimap$WrappedCollection
implements Set {
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$WrappedSet(AbstractMapBasedMultimap abstractMapBasedMultimap, Object object, Set set) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, set, null);
    }

    public boolean removeAll(Collection collection) {
        int n10 = collection.isEmpty();
        if (n10 != 0) {
            return false;
        }
        n10 = this.size();
        Collection collection2 = (Set)this.delegate;
        boolean bl2 = Sets.removeAllImpl((Set)collection2, collection);
        if (bl2) {
            collection2 = this.delegate;
            int n11 = collection2.size();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
            int n12 = AbstractMapBasedMultimap.access$200(abstractMapBasedMultimap);
            AbstractMapBasedMultimap.access$202(abstractMapBasedMultimap, n12 += (n11 -= n10));
            this.removeIfEmpty();
        }
        return bl2;
    }
}

