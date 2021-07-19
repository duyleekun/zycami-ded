/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class TimedValueQueue {
    private static final int INITIAL_BUFFER_SIZE = 10;
    private int first;
    private int size;
    private long[] timestamps;
    private Object[] values;

    public TimedValueQueue() {
        this(10);
    }

    public TimedValueQueue(int n10) {
        long[] lArray = new long[n10];
        this.timestamps = lArray;
        Object[] objectArray = TimedValueQueue.newArray(n10);
        this.values = objectArray;
    }

    private void addUnchecked(long l10, Object object) {
        int n10 = this.first;
        int n11 = this.size;
        n10 += n11;
        Object[] objectArray = this.values;
        int n12 = objectArray.length;
        this.timestamps[n10 %= n12] = l10;
        objectArray[n10] = object;
        this.size = ++n11;
    }

    private void clearBufferOnTimeDiscontinuity(long l10) {
        int n10 = this.size;
        if (n10 > 0) {
            int n11 = this.first + n10 + -1;
            long[] lArray = this.timestamps;
            n10 = this.values.length;
            long l11 = lArray[n11 %= n10];
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object <= 0) {
                this.clear();
            }
        }
    }

    private void doubleCapacityIfFull() {
        int n10 = this.size;
        Object[] objectArray = this.values;
        int n11 = objectArray.length;
        if (n10 < n11) {
            return;
        }
        n10 = n11 * 2;
        long[] lArray = new long[n10];
        Object[] objectArray2 = TimedValueQueue.newArray(n10);
        int n12 = this.first;
        long[] lArray2 = this.timestamps;
        System.arraycopy(lArray2, n12, lArray, 0, n11 -= n12);
        Object[] objectArray3 = this.values;
        int n13 = this.first;
        System.arraycopy(objectArray3, n13, objectArray2, 0, n11);
        n12 = this.first;
        if (n12 > 0) {
            lArray2 = this.timestamps;
            System.arraycopy(lArray2, 0, lArray, n11, n12);
            objectArray3 = this.values;
            n13 = this.first;
            System.arraycopy(objectArray3, 0, objectArray2, n11, n13);
        }
        this.timestamps = lArray;
        this.values = objectArray2;
        this.first = 0;
    }

    private static Object[] newArray(int n10) {
        return new Object[n10];
    }

    private Object poll(long l10, boolean bl2) {
        long l11;
        long l12;
        long l13;
        int n10;
        long[] lArray;
        long l14;
        long l15;
        long l16;
        long l17;
        int n11;
        Object object = null;
        long l18 = Long.MAX_VALUE;
        while ((n11 = this.size) > 0 && ((l17 = (l16 = (l15 = l10 - (l14 = (lArray = this.timestamps)[n10 = this.first])) - (l13 = 0L)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) >= 0 || !bl2 && (l12 = (l11 = (l13 = -l15) - l18) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0)) {
            object = this.popFirst();
            l18 = l15;
        }
        return object;
    }

    private Object popFirst() {
        Object[] objectArray;
        int n10 = this.size;
        int n11 = 1;
        if (n10 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            objectArray = null;
        }
        Assertions.checkState(n10 != 0);
        objectArray = this.values;
        int n12 = this.first;
        Object object = objectArray[n12];
        objectArray[n12] = null;
        n12 += n11;
        n10 = objectArray.length;
        this.first = n12 %= n10;
        this.size = n10 = this.size - n11;
        return object;
    }

    public void add(long l10, Object object) {
        synchronized (this) {
            this.clearBufferOnTimeDiscontinuity(l10);
            this.doubleCapacityIfFull();
            this.addUnchecked(l10, object);
            return;
        }
    }

    public void clear() {
        synchronized (this) {
            Object[] objectArray = null;
            this.first = 0;
            this.size = 0;
            objectArray = this.values;
            Arrays.fill(objectArray, null);
            return;
        }
    }

    public Object poll(long l10) {
        synchronized (this) {
            Object object = this.poll(l10, false);
            return object;
        }
    }

    public Object pollFirst() {
        synchronized (this) {
            Object object;
            block5: {
                int n10 = this.size;
                if (n10 != 0) break block5;
                n10 = 0;
                object = null;
            }
            object = this.popFirst();
            return object;
            finally {
            }
        }
    }

    public Object pollFloor(long l10) {
        synchronized (this) {
            boolean bl2 = true;
            Object object = this.poll(l10, bl2);
            return object;
        }
    }

    public int size() {
        synchronized (this) {
            int n10 = this.size;
            return n10;
        }
    }
}

