/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Collections2$PermutationIterator
extends AbstractIterator {
    public final int[] c;
    public int j;
    public final List list;
    public final int[] o;

    public Collections2$PermutationIterator(List object) {
        Object object2 = new ArrayList(object);
        this.list = object2;
        int n10 = object.size();
        object2 = new int[n10];
        this.c = (int[])object2;
        object = new int[n10];
        this.o = (int[])object;
        Arrays.fill((int[])object2, 0);
        Arrays.fill((int[])object, 1);
        this.j = -1 >>> 1;
    }

    public void calculateNextPermutation() {
        block4: {
            Object object;
            int n10;
            int n11;
            int[] nArray;
            int n12;
            Object object2 = this.list;
            this.j = n12 = object2.size() + -1;
            int n13 = -1;
            if (n12 == n13) {
                return;
            }
            n12 = 0;
            object2 = null;
            while (true) {
                nArray = this.c;
                n11 = this.j;
                n10 = nArray[n11];
                object = this.o;
                int n14 = object[n11];
                if ((n10 += n14) < 0) {
                    this.switchDirection();
                    continue;
                }
                n14 = n11 + 1;
                if (n10 != n14) break;
                if (n11 != 0) {
                    ++n12;
                    this.switchDirection();
                    continue;
                }
                break block4;
                break;
            }
            object = this.list;
            n13 = nArray[n11];
            n13 = n11 - n13 + n12;
            n11 = n11 - n10 + n12;
            Collections.swap(object, n13, n11);
            object2 = this.c;
            n13 = this.j;
            object2[n13] = n10;
        }
    }

    public List computeNext() {
        int n10 = this.j;
        if (n10 <= 0) {
            return (List)this.endOfData();
        }
        ImmutableList immutableList = ImmutableList.copyOf((Collection)this.list);
        this.calculateNextPermutation();
        return immutableList;
    }

    public void switchDirection() {
        int n10;
        int[] nArray = this.o;
        int n11 = this.j;
        nArray[n11] = n10 = -nArray[n11];
        this.j = n11 += -1;
    }
}

