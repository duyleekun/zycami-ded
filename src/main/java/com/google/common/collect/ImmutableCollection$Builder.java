/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;

public abstract class ImmutableCollection$Builder {
    public static final int DEFAULT_INITIAL_CAPACITY = 4;

    public static int expandedCapacity(int n10, int n11) {
        if (n11 >= 0) {
            int n12 = n10 >> 1;
            if ((n10 = n10 + n12 + 1) < n11) {
                n10 = Integer.highestOneBit(n11 += -1) << 1;
            }
            if (n10 < 0) {
                n10 = -1 >>> 1;
            }
            return n10;
        }
        AssertionError assertionError = new AssertionError((Object)"cannot store more than MAX_VALUE elements");
        throw assertionError;
    }

    public abstract ImmutableCollection$Builder add(Object var1);

    public ImmutableCollection$Builder add(Object ... objectArray) {
        for (Object object : objectArray) {
            this.add(object);
        }
        return this;
    }

    public ImmutableCollection$Builder addAll(Iterable object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            this.add(e10);
        }
        return this;
    }

    public ImmutableCollection$Builder addAll(Iterator iterator2) {
        boolean bl2;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            this.add(e10);
        }
        return this;
    }

    public abstract ImmutableCollection build();
}

