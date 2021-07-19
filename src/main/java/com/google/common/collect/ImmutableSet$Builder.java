/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableCollection$ArrayBasedBuilder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.Arrays;
import java.util.Iterator;

public class ImmutableSet$Builder
extends ImmutableCollection$ArrayBasedBuilder {
    private int hashCode;
    public Object[] hashTable;

    public ImmutableSet$Builder() {
        super(4);
    }

    public ImmutableSet$Builder(int n10) {
        super(n10);
        Object[] objectArray = new Object[ImmutableSet.chooseTableSize(n10)];
        this.hashTable = objectArray;
    }

    private void addDeduping(Object object) {
        Object[] objectArray = this.hashTable;
        int n10 = objectArray.length + -1;
        int n11 = object.hashCode();
        int n12 = Hashing.smear(n11);
        while (true) {
            Object[] objectArray2;
            Object object2;
            if ((object2 = (objectArray2 = this.hashTable)[n12 &= n10]) == null) {
                objectArray2[n12] = object;
                this.hashCode = n10 = this.hashCode + n11;
                super.add(object);
                return;
            }
            boolean bl2 = object2.equals(object);
            if (bl2) {
                return;
            }
            ++n12;
        }
    }

    public ImmutableSet$Builder add(Object object) {
        Object[] objectArray;
        int n10;
        int n11;
        Preconditions.checkNotNull(object);
        Object[] objectArray2 = this.hashTable;
        if (objectArray2 != null && (n11 = ImmutableSet.chooseTableSize(this.size)) <= (n10 = (objectArray = this.hashTable).length)) {
            this.addDeduping(object);
            return this;
        }
        this.hashTable = null;
        super.add(object);
        return this;
    }

    public ImmutableSet$Builder add(Object ... objectArray) {
        Object[] objectArray2 = this.hashTable;
        if (objectArray2 != null) {
            for (Object object : objectArray) {
                this.add(object);
            }
        } else {
            super.add(objectArray);
        }
        return this;
    }

    public ImmutableSet$Builder addAll(Iterable object) {
        Preconditions.checkNotNull(object);
        Object object2 = this.hashTable;
        if (object2 != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = object.next();
                this.add(object2);
            }
        } else {
            super.addAll((Iterable)object);
        }
        return this;
    }

    public ImmutableSet$Builder addAll(Iterator iterator2) {
        boolean bl2;
        Preconditions.checkNotNull(iterator2);
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            this.add(e10);
        }
        return this;
    }

    public ImmutableSet build() {
        int n10 = this.size;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                Object object;
                int n12;
                Object[] objectArray = this.hashTable;
                if (objectArray != null && (n10 = ImmutableSet.chooseTableSize(n10)) == (n12 = (objectArray = this.hashTable).length)) {
                    n10 = this.size;
                    objectArray = this.contents;
                    n12 = objectArray.length;
                    if ((n10 = (int)(ImmutableSet.access$000(n10, n12) ? 1 : 0)) != 0) {
                        object = this.contents;
                        n12 = this.size;
                        object = Arrays.copyOf(object, n12);
                    } else {
                        object = this.contents;
                    }
                    Object[] objectArray2 = object;
                    int n13 = this.hashCode;
                    Object[] objectArray3 = this.hashTable;
                    n12 = objectArray3.length;
                    int n14 = n12 + -1;
                    int n15 = this.size;
                    objectArray = object;
                    object = new RegularImmutableSet(objectArray2, n13, objectArray3, n14, n15);
                } else {
                    n10 = this.size;
                    objectArray = this.contents;
                    object = ImmutableSet.access$100(n10, objectArray);
                    this.size = n12 = object.size();
                }
                this.forceCopy = n11;
                this.hashTable = null;
                return object;
            }
            return ImmutableSet.of(this.contents[0]);
        }
        return ImmutableSet.of();
    }
}

