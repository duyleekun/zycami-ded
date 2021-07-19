/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets$PowerSet$1;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class Sets$PowerSet
extends AbstractSet {
    public final ImmutableMap inputSet;

    public Sets$PowerSet(Set object) {
        int n10 = object.size();
        int n11 = 30;
        n10 = n10 <= n11 ? 1 : 0;
        n11 = object.size();
        Preconditions.checkArgument(n10 != 0, "Too many elements to create power set: %s > 30", n11);
        this.inputSet = object = Maps.indexMap((Collection)object);
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof Set;
        if (bl2) {
            object = (Set)object;
            return this.inputSet.keySet().containsAll((Collection<?>)object);
        }
        return false;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Sets$PowerSet;
        if (bl2) {
            object = (Sets$PowerSet)object;
            ImmutableMap immutableMap = this.inputSet;
            object = ((Sets$PowerSet)object).inputSet;
            return immutableMap.equals(object);
        }
        return super.equals(object);
    }

    public int hashCode() {
        int n10 = this.inputSet.keySet().hashCode();
        int n11 = this.inputSet.size() + -1;
        return n10 << n11;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator iterator() {
        int n10 = this.size();
        Sets$PowerSet$1 sets$PowerSet$1 = new Sets$PowerSet$1(this, n10);
        return sets$PowerSet$1;
    }

    public int size() {
        int n10 = this.inputSet.size();
        return 1 << n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("powerSet(");
        ImmutableMap immutableMap = this.inputSet;
        stringBuilder.append(immutableMap);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

