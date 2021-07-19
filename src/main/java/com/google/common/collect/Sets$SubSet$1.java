/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets$SubSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

public class Sets$SubSet$1
extends UnmodifiableIterator {
    public final ImmutableList elements;
    public int remainingSetBits;
    public final /* synthetic */ Sets$SubSet this$0;

    public Sets$SubSet$1(Sets$SubSet sets$SubSet) {
        int n10;
        ImmutableList immutableList;
        this.this$0 = sets$SubSet;
        this.elements = immutableList = Sets$SubSet.access$100(sets$SubSet).keySet().asList();
        this.remainingSetBits = n10 = Sets$SubSet.access$200(sets$SubSet);
    }

    public boolean hasNext() {
        int n10 = this.remainingSetBits;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public Object next() {
        int n10;
        int n11 = Integer.numberOfTrailingZeros(this.remainingSetBits);
        if (n11 != (n10 = 32)) {
            n10 = this.remainingSetBits;
            int n12 = ~(1 << n11);
            this.remainingSetBits = n10 &= n12;
            return this.elements.get(n11);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

