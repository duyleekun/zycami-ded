/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class TopKSelector {
    private final Object[] buffer;
    private int bufferSize;
    private final Comparator comparator;
    private final int k;
    private Object threshold;

    private TopKSelector(Comparator comparator, int n10) {
        boolean bl2;
        String string2 = "comparator";
        this.comparator = comparator = (Comparator)Preconditions.checkNotNull(comparator, string2);
        this.k = n10;
        comparator = null;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        Preconditions.checkArgument(bl2, "k must be nonnegative, was %s", n10);
        Object[] objectArray = new Object[n10 * 2];
        this.buffer = objectArray;
        this.bufferSize = 0;
        this.threshold = null;
    }

    public static TopKSelector greatest(int n10) {
        Ordering ordering = Ordering.natural();
        return TopKSelector.greatest(n10, ordering);
    }

    public static TopKSelector greatest(int n10, Comparator comparator) {
        comparator = Ordering.from(comparator).reverse();
        TopKSelector topKSelector = new TopKSelector(comparator, n10);
        return topKSelector;
    }

    public static TopKSelector least(int n10) {
        Ordering ordering = Ordering.natural();
        return TopKSelector.least(n10, ordering);
    }

    public static TopKSelector least(int n10, Comparator comparator) {
        TopKSelector topKSelector = new TopKSelector(comparator, n10);
        return topKSelector;
    }

    private int partition(int n10, int n11, int n12) {
        Object object;
        Object object2 = this.buffer;
        Object object3 = object2[n12];
        object2[n12] = object = object2[n11];
        n12 = n10;
        while (n10 < n11) {
            object2 = this.comparator;
            object = this.buffer[n10];
            int n13 = object2.compare(object, object3);
            if (n13 < 0) {
                this.swap(n12, n10);
                ++n12;
            }
            ++n10;
        }
        Object[] objectArray = this.buffer;
        objectArray[n11] = object2 = objectArray[n12];
        objectArray[n12] = object3;
        return n12;
    }

    private void swap(int n10, int n11) {
        Object object;
        Object[] objectArray = this.buffer;
        Object object2 = objectArray[n10];
        objectArray[n10] = object = objectArray[n11];
        objectArray[n11] = object2;
    }

    private void trim() {
        Object object;
        Object[] objectArray;
        int n10 = this.k * 2 + -1;
        int n11 = n10 + 0;
        Object object2 = RoundingMode.CEILING;
        n11 = IntMath.log2(n11, object2) * 3;
        int n12 = 0;
        object2 = null;
        int n13 = 0;
        Comparator comparator = null;
        int n14 = 0;
        while (n12 < n10) {
            int n15;
            int n16 = n12 + n10 + 1 >>> 1;
            if ((n16 = this.partition(n12, n10, n16)) > (n15 = this.k)) {
                n10 = n16 += -1;
            } else {
                if (n16 >= n15) break;
                ++n12;
                n12 = Math.max(n16, n12);
                n14 = n16;
            }
            if (++n13 < n11) continue;
            objectArray = this.buffer;
            comparator = this.comparator;
            Arrays.sort(objectArray, n12, n10, comparator);
            break;
        }
        this.bufferSize = n10 = this.k;
        this.threshold = object = this.buffer[n14];
        while (++n14 < (n10 = this.k)) {
            object = this.comparator;
            objectArray = this.buffer[n14];
            object2 = this.threshold;
            n10 = object.compare(objectArray, object2);
            if (n10 <= 0) continue;
            this.threshold = object = this.buffer[n14];
        }
    }

    public void offer(Object object) {
        int n10 = this.k;
        if (n10 == 0) {
            return;
        }
        int n11 = this.bufferSize;
        if (n11 == 0) {
            int n12;
            Object[] objectArray = this.buffer;
            n11 = 0;
            Object var5_7 = null;
            objectArray[0] = object;
            this.threshold = object;
            this.bufferSize = n12 = 1;
        } else if (n11 < n10) {
            int n13;
            Object object2 = this.buffer;
            this.bufferSize = n13 = n11 + 1;
            object2[n11] = object;
            object2 = this.comparator;
            Object object3 = this.threshold;
            n10 = object2.compare(object, object3);
            if (n10 > 0) {
                this.threshold = object;
            }
        } else {
            Object[] objectArray = this.comparator;
            Object object4 = this.threshold;
            n10 = objectArray.compare(object, object4);
            if (n10 < 0) {
                int n14;
                objectArray = this.buffer;
                n11 = this.bufferSize;
                this.bufferSize = n14 = n11 + 1;
                objectArray[n11] = object;
                int n15 = this.k * 2;
                if (n14 == n15) {
                    this.trim();
                }
            }
        }
    }

    public void offerAll(Iterable object) {
        object = object.iterator();
        this.offerAll((Iterator)object);
    }

    public void offerAll(Iterator iterator2) {
        boolean bl2;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            this.offer(e10);
        }
    }

    public List topK() {
        Object object = this.buffer;
        int n10 = this.bufferSize;
        Comparator comparator = this.comparator;
        Arrays.sort(object, 0, n10, comparator);
        int n11 = this.bufferSize;
        n10 = this.k;
        if (n11 > n10) {
            object = this.buffer;
            int n12 = ((Object[])object).length;
            Arrays.fill(object, n10, n12, null);
            this.bufferSize = n11 = this.k;
            Object[] objectArray = this.buffer;
            this.threshold = object = objectArray[n11 += -1];
        }
        object = this.buffer;
        n10 = this.bufferSize;
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(object, n10)));
    }
}

