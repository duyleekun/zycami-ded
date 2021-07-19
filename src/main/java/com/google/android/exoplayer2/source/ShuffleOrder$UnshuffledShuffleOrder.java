/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.ShuffleOrder;

public final class ShuffleOrder$UnshuffledShuffleOrder
implements ShuffleOrder {
    private final int length;

    public ShuffleOrder$UnshuffledShuffleOrder(int n10) {
        this.length = n10;
    }

    public ShuffleOrder cloneAndClear() {
        ShuffleOrder$UnshuffledShuffleOrder shuffleOrder$UnshuffledShuffleOrder = new ShuffleOrder$UnshuffledShuffleOrder(0);
        return shuffleOrder$UnshuffledShuffleOrder;
    }

    public ShuffleOrder cloneAndInsert(int n10, int n11) {
        int n12 = this.length + n11;
        ShuffleOrder$UnshuffledShuffleOrder shuffleOrder$UnshuffledShuffleOrder = new ShuffleOrder$UnshuffledShuffleOrder(n12);
        return shuffleOrder$UnshuffledShuffleOrder;
    }

    public ShuffleOrder cloneAndRemove(int n10, int n11) {
        int n12 = this.length - n11 + n10;
        ShuffleOrder$UnshuffledShuffleOrder shuffleOrder$UnshuffledShuffleOrder = new ShuffleOrder$UnshuffledShuffleOrder(n12);
        return shuffleOrder$UnshuffledShuffleOrder;
    }

    public int getFirstIndex() {
        int n10 = this.length;
        n10 = n10 > 0 ? 0 : -1;
        return n10;
    }

    public int getLastIndex() {
        int n10 = this.length;
        n10 = n10 > 0 ? (n10 += -1) : -1;
        return n10;
    }

    public int getLength() {
        return this.length;
    }

    public int getNextIndex(int n10) {
        int n11 = this.length;
        if (++n10 >= n11) {
            n10 = -1;
        }
        return n10;
    }

    public int getPreviousIndex(int n10) {
        int n11 = -1;
        if ((n10 += n11) >= 0) {
            n11 = n10;
        }
        return n11;
    }
}

