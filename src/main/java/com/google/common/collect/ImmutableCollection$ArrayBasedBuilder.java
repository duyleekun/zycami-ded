/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ObjectArrays;
import java.util.Arrays;
import java.util.Collection;

public abstract class ImmutableCollection$ArrayBasedBuilder
extends ImmutableCollection$Builder {
    public Object[] contents;
    public boolean forceCopy;
    public int size;

    public ImmutableCollection$ArrayBasedBuilder(int n10) {
        CollectPreconditions.checkNonnegative(n10, "initialCapacity");
        Object[] objectArray = new Object[n10];
        this.contents = objectArray;
        this.size = 0;
    }

    private void getReadyToExpandTo(int n10) {
        Object[] objectArray = this.contents;
        int n11 = objectArray.length;
        if (n11 < n10) {
            n11 = objectArray.length;
            n10 = ImmutableCollection$Builder.expandedCapacity(n11, n10);
            Object[] objectArray2 = Arrays.copyOf(objectArray, n10);
            this.contents = objectArray2;
            this.forceCopy = false;
        } else {
            n10 = (int)(this.forceCopy ? 1 : 0);
            if (n10 != 0) {
                Object[] objectArray3 = (Object[])objectArray.clone();
                this.contents = objectArray3;
                this.forceCopy = false;
            }
        }
    }

    public ImmutableCollection$ArrayBasedBuilder add(Object object) {
        int n10;
        Preconditions.checkNotNull(object);
        int n11 = this.size + 1;
        this.getReadyToExpandTo(n11);
        Object[] objectArray = this.contents;
        int n12 = this.size;
        this.size = n10 = n12 + 1;
        objectArray[n12] = object;
        return this;
    }

    public ImmutableCollection$Builder add(Object ... objectArray) {
        ObjectArrays.checkElementsNotNull(objectArray);
        int n10 = this.size;
        int n11 = objectArray.length;
        this.getReadyToExpandTo(n10 += n11);
        Object[] objectArray2 = this.contents;
        n11 = this.size;
        int n12 = objectArray.length;
        System.arraycopy(objectArray, 0, objectArray2, n11, n12);
        n10 = this.size;
        int n13 = objectArray.length;
        this.size = n10 += n13;
        return this;
    }

    public ImmutableCollection$Builder addAll(Iterable objectArray) {
        boolean bl2 = objectArray instanceof Collection;
        if (bl2) {
            Object[] objectArray2 = objectArray;
            objectArray2 = (Collection)objectArray;
            int n10 = this.size;
            int n11 = objectArray2.size();
            this.getReadyToExpandTo(n10 += n11);
            n10 = objectArray2 instanceof ImmutableCollection;
            if (n10 != 0) {
                int n12;
                objectArray2 = (ImmutableCollection)objectArray2;
                objectArray = this.contents;
                n10 = this.size;
                this.size = n12 = objectArray2.copyIntoArray(objectArray, n10);
                return this;
            }
        }
        super.addAll((Iterable)objectArray);
        return this;
    }
}

