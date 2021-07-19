/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

public abstract class Sets$ImprovedAbstractSet
extends AbstractSet {
    public boolean removeAll(Collection collection) {
        return Sets.removeAllImpl((Set)this, collection);
    }

    public boolean retainAll(Collection collection) {
        collection = (Collection)Preconditions.checkNotNull(collection);
        return super.retainAll(collection);
    }
}

