/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Collections2$PermutationIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;

public final class Collections2$PermutationCollection
extends AbstractCollection {
    public final ImmutableList inputList;

    public Collections2$PermutationCollection(ImmutableList immutableList) {
        this.inputList = immutableList;
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof List;
        if (bl2) {
            object = (List)object;
            return Collections2.access$000(this.inputList, (List)object);
        }
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator iterator() {
        ImmutableList immutableList = this.inputList;
        Collections2$PermutationIterator collections2$PermutationIterator = new Collections2$PermutationIterator(immutableList);
        return collections2$PermutationIterator;
    }

    public int size() {
        return IntMath.factorial(this.inputList.size());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("permutations(");
        ImmutableList immutableList = this.inputList;
        stringBuilder.append(immutableList);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

