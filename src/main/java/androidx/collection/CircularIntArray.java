/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int n10) {
        int n11 = 1;
        if (n10 >= n11) {
            int n12 = 0x40000000;
            if (n10 <= n12) {
                n12 = Integer.bitCount(n10);
                if (n12 != n11) {
                    n10 = Integer.highestOneBit(n10 + -1) << n11;
                }
                this.mCapacityBitmask = n11 = n10 + -1;
                int[] nArray = new int[n10];
                this.mElements = nArray;
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
        int n10 = ((int[])object).length;
        int n11 = this.mHead;
        int n12 = n10 - n11;
        int n13 = n10 << 1;
        if (n13 >= 0) {
            int[] nArray = new int[n13];
            System.arraycopy(object, n11, nArray, 0, n12);
            object = this.mElements;
            n11 = this.mHead;
            System.arraycopy(object, 0, nArray, n12, n11);
            this.mElements = nArray;
            this.mHead = 0;
            this.mTail = n10;
            this.mCapacityBitmask = n13 += -1;
            return;
        }
        object = new RuntimeException;
        object("Max array capacity exceeded");
        throw object;
    }

    public void addFirst(int n10) {
        int n11 = this.mHead + -1;
        int n12 = this.mCapacityBitmask;
        this.mHead = n11 &= n12;
        int[] nArray = this.mElements;
        nArray[n11] = n10;
        n10 = this.mTail;
        if (n11 == n10) {
            this.doubleCapacity();
        }
    }

    public void addLast(int n10) {
        int[] nArray = this.mElements;
        int n11 = this.mTail;
        nArray[n11] = n10;
        this.mTail = n10 = this.mCapacityBitmask & ++n11;
        int n12 = this.mHead;
        if (n10 == n12) {
            this.doubleCapacity();
        }
    }

    public void clear() {
        int n10;
        this.mTail = n10 = this.mHead;
    }

    public int get(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size())) {
            int[] nArray = this.mElements;
            int n12 = this.mHead + n10;
            n10 = this.mCapacityBitmask & n12;
            return nArray[n10];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public int getFirst() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        if (n10 != n11) {
            return this.mElements[n10];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public int getLast() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        if (n10 != n11) {
            int[] nArray = this.mElements;
            n11 += -1;
            int n12 = this.mCapacityBitmask;
            return nArray[n11 &= n12];
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

    public int popFirst() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        if (n10 != n11) {
            n11 = this.mElements[n10];
            ++n10;
            int n12 = this.mCapacityBitmask;
            this.mHead = n10 &= n12;
            return n11;
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public int popLast() {
        int n10 = this.mHead;
        int n11 = this.mTail;
        if (n10 != n11) {
            n10 = this.mCapacityBitmask & (n11 += -1);
            n11 = this.mElements[n10];
            this.mTail = n10;
            return n11;
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
            n11 = this.mTail - n10;
            this.mTail = n10 = this.mCapacityBitmask & n11;
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
            n11 = this.mHead + n10;
            this.mHead = n10 = this.mCapacityBitmask & n11;
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

