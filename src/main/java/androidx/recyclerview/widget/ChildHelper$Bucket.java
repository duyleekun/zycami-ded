/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public class ChildHelper$Bucket {
    public static final int BITS_PER_WORD = 64;
    public static final long LAST_BIT = Long.MIN_VALUE;
    public long mData = 0L;
    public ChildHelper$Bucket mNext;

    private void ensureNext() {
        ChildHelper$Bucket childHelper$Bucket = this.mNext;
        if (childHelper$Bucket == null) {
            this.mNext = childHelper$Bucket = new ChildHelper$Bucket();
        }
    }

    public void clear(int n10) {
        int n11 = 64;
        if (n10 >= n11) {
            ChildHelper$Bucket childHelper$Bucket = this.mNext;
            if (childHelper$Bucket != null) {
                childHelper$Bucket.clear(n10 -= n11);
            }
        } else {
            long l10 = this.mData;
            long l11 = 1L << n10 ^ (long)-1;
            this.mData = l10 &= l11;
        }
    }

    public int countOnesBefore(int n10) {
        ChildHelper$Bucket childHelper$Bucket = this.mNext;
        int n11 = 64;
        long l10 = 1L;
        if (childHelper$Bucket == null) {
            if (n10 >= n11) {
                return Long.bitCount(this.mData);
            }
            long l11 = this.mData;
            long l12 = (l10 << n10) - l10;
            return Long.bitCount(l11 & l12);
        }
        if (n10 < n11) {
            long l13 = this.mData;
            long l14 = (l10 << n10) - l10;
            return Long.bitCount(l13 & l14);
        }
        n10 -= n11;
        n10 = childHelper$Bucket.countOnesBefore(n10);
        int n12 = Long.bitCount(this.mData);
        return n10 + n12;
    }

    public boolean get(int n10) {
        int n11 = 64;
        if (n10 >= n11) {
            this.ensureNext();
            ChildHelper$Bucket childHelper$Bucket = this.mNext;
            return childHelper$Bucket.get(n10 -= n11);
        }
        long l10 = this.mData;
        long l11 = 1L << n10;
        long l12 = (l10 &= l11) - (l11 = 0L);
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void insert(int n10, boolean bl2) {
        int n11 = 64;
        if (n10 >= n11) {
            this.ensureNext();
            ChildHelper$Bucket childHelper$Bucket = this.mNext;
            childHelper$Bucket.insert(n10 -= n11, bl2);
        } else {
            ChildHelper$Bucket childHelper$Bucket;
            long l10 = this.mData;
            long l11 = Long.MIN_VALUE & l10;
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            int n12 = 1;
            l13 = l13 != false ? (long)n12 : (long)0;
            long l14 = 1L;
            long l15 = (l14 << n10) - l14;
            l14 = l10 & l15;
            this.mData = l10 = (l10 & (l15 ^= (long)-1)) << n12 | l14;
            if (bl2) {
                this.set(n10);
            } else {
                this.clear(n10);
            }
            if (l13 != false || (childHelper$Bucket = this.mNext) != null) {
                this.ensureNext();
                childHelper$Bucket = this.mNext;
                childHelper$Bucket.insert(0, (boolean)l13);
            }
        }
    }

    public boolean remove(int n10) {
        int n11 = 64;
        if (n10 >= n11) {
            this.ensureNext();
            ChildHelper$Bucket childHelper$Bucket = this.mNext;
            return childHelper$Bucket.remove(n10 -= n11);
        }
        long l10 = 1L;
        long l11 = l10 << n10;
        long l12 = this.mData;
        long l13 = l12 & l11;
        long l14 = 0L;
        n10 = (int)(l13 == l14 ? 0 : (l13 < l14 ? -1 : 1));
        int n12 = 1;
        n10 = n10 != 0 ? n12 : 0;
        l14 = l11 ^ (long)-1;
        this.mData = l12 &= l14;
        l11 -= l10;
        l10 = l12 & l11;
        l11 = Long.rotateRight((l11 ^ (long)-1) & l12, n12);
        this.mData = l10 |= l11;
        ChildHelper$Bucket childHelper$Bucket = this.mNext;
        if (childHelper$Bucket != null) {
            n11 = (int)(childHelper$Bucket.get(0) ? 1 : 0);
            if (n11 != 0) {
                n11 = 63;
                this.set(n11);
            }
            childHelper$Bucket = this.mNext;
            childHelper$Bucket.remove(0);
        }
        return n10 != 0;
    }

    public void reset() {
        long l10;
        this.mData = l10 = 0L;
        ChildHelper$Bucket childHelper$Bucket = this.mNext;
        if (childHelper$Bucket != null) {
            childHelper$Bucket.reset();
        }
    }

    public void set(int n10) {
        int n11 = 64;
        if (n10 >= n11) {
            this.ensureNext();
            ChildHelper$Bucket childHelper$Bucket = this.mNext;
            childHelper$Bucket.set(n10 -= n11);
        } else {
            long l10 = this.mData;
            long l11 = 1L << n10;
            this.mData = l10 |= l11;
        }
    }

    public String toString() {
        Object object = this.mNext;
        if (object == null) {
            long l10 = this.mData;
            object = Long.toBinaryString(l10);
        } else {
            object = new StringBuilder();
            String string2 = this.mNext.toString();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("xx");
            long l11 = this.mData;
            string2 = Long.toBinaryString(l11);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        return object;
    }
}

