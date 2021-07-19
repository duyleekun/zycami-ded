/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets$SubSet$1;
import java.util.AbstractSet;
import java.util.Iterator;

public final class Sets$SubSet
extends AbstractSet {
    private final ImmutableMap inputSet;
    private final int mask;

    public Sets$SubSet(ImmutableMap immutableMap, int n10) {
        this.inputSet = immutableMap;
        this.mask = n10;
    }

    public static /* synthetic */ ImmutableMap access$100(Sets$SubSet sets$SubSet) {
        return sets$SubSet.inputSet;
    }

    public static /* synthetic */ int access$200(Sets$SubSet sets$SubSet) {
        return sets$SubSet.mask;
    }

    public boolean contains(Object object) {
        int n10;
        block3: {
            ImmutableMap immutableMap;
            block2: {
                immutableMap = this.inputSet;
                object = (Integer)immutableMap.get(object);
                n10 = 1;
                if (object == null) break block2;
                int n11 = this.mask;
                int n12 = (Integer)object;
                if ((n12 = n10 << n12 & n11) != 0) break block3;
            }
            n10 = 0;
            immutableMap = null;
        }
        return n10 != 0;
    }

    public Iterator iterator() {
        Sets$SubSet$1 sets$SubSet$1 = new Sets$SubSet$1(this);
        return sets$SubSet$1;
    }

    public int size() {
        return Integer.bitCount(this.mask);
    }
}

