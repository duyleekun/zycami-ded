/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

public final class CircularArray {
    private int mCapacityBitmask;
    private Object[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int n10) {
        int n11 = 1;
        if (n10 >= n11) {
            int n12 = 0x40000000;
            if (n10 <= n12) {
                n12 = Integer.bitCount(n10);
                if (n12 != n11) {
                    n10 = Integer.highestOneBit(n10 + -1) << n11;
                }
                this.mCapacityBitmask = n11 = n10 + -1;
                Object[] objectArray = new Object[n10];
                this.mElements = objectArray;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("capacity must be <= 2^30");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("capacity must be >= 1");
        throw illegalArgumentException;
    }

    private void doubleCapacity() {
        Object object = this.mElements;
        int n10 = ((Object[])object).length;
        int n11 = this.mHead;
        int n12 = n10 - n11;
        int n13 = n10 << 1;
        if (n13 >= 0) {
            Object[] objectArray = new Object[n13];
            System.arraycopy(object, n11, objectArray, 0, n12);
            object = this.mElements;
            n11 = this.mHead;
            System.arraycopy(object, 0, objectArray, n12, n11);
            this.mElements = objectArray;
            this.mHead = 0;
            this.mTail = n10;
            this.mCapacityBitmask = n13 += -1;
            return;
        }
        object = new RuntimeException("Max array capacity exceeded");
        throw object;
    }

    public void addFirst(Object object) {
        int n10 = this.mHead + -1;
        int n11 = this.mCapacityBitmask;
        this.mHead = n10 &= n11;
        Object[] objectArray = this.mElements;
        objectArray[n10] = object;
        int n12 = this.mTail;
        if (n10 == n12) {
            this.doubleCapacity();
        }
    }

    public void addLast(Object object) {
        int n10;
        Object[] objectArray = this.mElements;
        int n11 = this.mTail;
        objectArray[n11] = object;
        this.mTail = n10 = this.mCapacityBitmask & ++n11;
        int n12 = this.mHead;
        if (n10 == n12) {
            this.doubleCapacity();
        }
    }

    public void clear() {
        int n10 = this.size();
        this.removeFromStart(n10);
    }

    public Object get(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size())) {
            Object[] objectArray = this.mElements;
            int n12 = this.mHead + n10;
            n10 = this.mCapacityBitmask & n12;
            return objectArray[n10];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public Object getFirst() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        if (n10 != n11) {
            return this.mElements[n10];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public Object getLast() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        if (n10 != n11) {
            Object[] objectArray = this.mElements;
            n11 += -1;
            int n12 = this.mCapacityBitmask;
            return objectArray[n11 &= n12];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public boolean isEmpty() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public Object popFirst() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        if (n10 != n11) {
            Object[] objectArray = this.mElements;
            Object object = objectArray[n10];
            objectArray[n10] = null;
            ++n10;
            n11 = this.mCapacityBitmask;
            this.mHead = n10 &= n11;
            return object;
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public Object popLast() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        if (n10 != n11) {
            n10 = this.mCapacityBitmask & (n11 += -1);
            Object[] objectArray = this.mElements;
            Object object = objectArray[n10];
            objectArray[n10] = null;
            this.mTail = n10;
            return object;
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public void removeFromEnd(int n10) {
        if (n10 <= 0) {
            return;
        }
        int n11 = this.size();
        if (n10 <= n11) {
            int n12;
            n11 = 0;
            Object[] objectArray = null;
            int n13 = this.mTail;
            if (n10 < n13) {
                n11 = n13 - n10;
            }
            for (n13 = n11; n13 < (n12 = this.mTail); ++n13) {
                Object[] objectArray2 = this.mElements;
                objectArray2[n13] = null;
            }
            n11 = n12 - n11;
            this.mTail = n12 -= n11;
            if ((n10 -= n11) > 0) {
                objectArray = this.mElements;
                this.mTail = n11 = objectArray.length;
                n11 -= n10;
                for (n10 = n11; n10 < (n13 = this.mTail); ++n10) {
                    Object[] objectArray3 = this.mElements;
                    objectArray3[n10] = null;
                }
                this.mTail = n11;
            }
            return;
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public void removeFromStart(int n10) {
        if (n10 <= 0) {
            return;
        }
        int n11 = this.size();
        if (n10 <= n11) {
            Object[] objectArray = this.mElements;
            n11 = objectArray.length;
            int n12 = this.mHead;
            int n13 = n11 - n12;
            if (n10 < n13) {
                n11 = n12 + n10;
            }
            while (true) {
                n13 = 0;
                if (n12 >= n11) break;
                Object[] objectArray2 = this.mElements;
                objectArray2[n12] = null;
                ++n12;
            }
            n12 = this.mHead;
            n10 -= (n11 -= n12);
            n12 += n11;
            this.mHead = n11 = this.mCapacityBitmask & n12;
            if (n10 > 0) {
                objectArray = null;
                for (n11 = 0; n11 < n10; ++n11) {
                    Object[] objectArray3 = this.mElements;
                    objectArray3[n11] = null;
                }
                this.mHead = n10;
            }
            return;
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public int size() {
        int n10 = this.mTail;
        int n11 = this.mHead;
        n10 -= n11;
        n11 = this.mCapacityBitmask;
        return n10 & n11;
    }
}

