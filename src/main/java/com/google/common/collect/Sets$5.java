/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets$5$1;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class Sets$5
extends AbstractSet {
    public final /* synthetic */ ImmutableMap val$index;
    public final /* synthetic */ int val$size;

    public Sets$5(int n10, ImmutableMap immutableMap) {
        this.val$size = n10;
        this.val$index = immutableMap;
    }

    public boolean contains(Object object) {
        ImmutableSet immutableSet;
        boolean bl2;
        int n10;
        int n11 = object instanceof Set;
        boolean bl3 = false;
        if (n11 != 0 && (n11 = (object = (Set)object).size()) == (n10 = this.val$size) && (bl2 = (immutableSet = this.val$index.keySet()).containsAll((Collection<?>)object))) {
            bl3 = true;
        }
        return bl3;
    }

    public Iterator iterator() {
        Sets$5$1 sets$5$1 = new Sets$5$1(this);
        return sets$5$1;
    }

    public int size() {
        int n10 = this.val$index.size();
        int n11 = this.val$size;
        return IntMath.binomial(n10, n11);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sets.combinations(");
        ImmutableSet immutableSet = this.val$index.keySet();
        stringBuilder.append(immutableSet);
        stringBuilder.append(", ");
        int n10 = this.val$size;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

