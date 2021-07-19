/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2$FilteredCollection;
import com.google.common.collect.Sets;
import java.util.Set;

public class Sets$FilteredSet
extends Collections2$FilteredCollection
implements Set {
    public Sets$FilteredSet(Set set, Predicate predicate) {
        super(set, predicate);
    }

    public boolean equals(Object object) {
        return Sets.equalsImpl(this, object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
}

