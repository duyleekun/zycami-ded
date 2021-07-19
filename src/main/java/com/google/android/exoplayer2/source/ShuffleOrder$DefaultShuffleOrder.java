/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.ShuffleOrder;
import java.util.Arrays;
import java.util.Random;

public class ShuffleOrder$DefaultShuffleOrder
implements ShuffleOrder {
    private final int[] indexInShuffled;
    private final Random random;
    private final int[] shuffled;

    public ShuffleOrder$DefaultShuffleOrder(int n10) {
        Random random = new Random();
        this(n10, random);
    }

    public ShuffleOrder$DefaultShuffleOrder(int n10, long l10) {
        Random random = new Random(l10);
        this(n10, random);
    }

    private ShuffleOrder$DefaultShuffleOrder(int n10, Random random) {
        int[] nArray = ShuffleOrder$DefaultShuffleOrder.createShuffledList(n10, random);
        this(nArray, random);
    }

    public ShuffleOrder$DefaultShuffleOrder(int[] nArray, long l10) {
        int n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        Random random = new Random(l10);
        this(nArray, random);
    }

    private ShuffleOrder$DefaultShuffleOrder(int[] nArray, Random object) {
        int n10;
        this.shuffled = nArray;
        this.random = object;
        object = new int[nArray.length];
        this.indexInShuffled = (int[])object;
        int n11 = 0;
        object = null;
        while (n11 < (n10 = nArray.length)) {
            int[] nArray2 = this.indexInShuffled;
            int n12 = nArray[n11];
            nArray2[n12] = n11++;
        }
    }

    private static int[] createShuffledList(int n10, Random random) {
        int[] nArray = new int[n10];
        int n11 = 0;
        while (n11 < n10) {
            int n12;
            int n13 = n11 + 1;
            int n14 = random.nextInt(n13);
            nArray[n11] = n12 = nArray[n14];
            nArray[n14] = n11;
            n11 = n13;
        }
        return nArray;
    }

    public ShuffleOrder cloneAndClear() {
        long l10 = this.random.nextLong();
        Random random = new Random(l10);
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = new ShuffleOrder$DefaultShuffleOrder(0, random);
        return shuffleOrder$DefaultShuffleOrder;
    }

    public ShuffleOrder cloneAndInsert(int n10, int n11) {
        int[] nArray;
        int n12;
        int n13;
        int n14;
        int n15;
        int[] nArray2;
        Random random;
        int[] nArray3 = new int[n11];
        int[] nArray4 = new int[n11];
        int n16 = 0;
        int n17 = 0;
        int[] nArray5 = null;
        while (n17 < n11) {
            random = this.random;
            nArray2 = this.shuffled;
            n15 = nArray2.length + 1;
            nArray3[n17] = n14 = random.nextInt(n15);
            random = this.random;
            n15 = n17 + 1;
            n14 = random.nextInt(n15);
            nArray4[n17] = n13 = nArray4[n14];
            nArray4[n14] = n17 += n10;
            n17 = n15;
        }
        Arrays.sort(nArray3);
        n17 = this.shuffled.length + n11;
        nArray5 = new int[n17];
        n14 = 0;
        random = null;
        n15 = 0;
        nArray2 = null;
        while (n16 < (n12 = (nArray = this.shuffled).length + n11)) {
            if (n14 < n11 && n15 == (n12 = nArray3[n14])) {
                n13 = n14 + 1;
                nArray5[n16] = n14 = nArray4[n14];
                n14 = n13;
            } else {
                n12 = n15 + 1;
                nArray5[n16] = n15 = nArray[n15];
                n15 = nArray5[n16];
                if (n15 >= n10) {
                    nArray5[n16] = n15 = nArray5[n16] + n11;
                }
                n15 = n12;
            }
            ++n16;
        }
        long l10 = this.random.nextLong();
        Random random2 = new Random(l10);
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = new ShuffleOrder$DefaultShuffleOrder(nArray5, random2);
        return shuffleOrder$DefaultShuffleOrder;
    }

    public ShuffleOrder cloneAndRemove(int n10, int n11) {
        int[] nArray;
        int n12;
        int n13 = n11 - n10;
        int n14 = this.shuffled.length - n13;
        int[] nArray2 = new int[n14];
        int n15 = 0;
        for (int i10 = 0; i10 < (n12 = (nArray = this.shuffled).length); ++i10) {
            n12 = nArray[i10];
            if (n12 >= n10 && (n12 = nArray[i10]) < n11) {
                ++n15;
                continue;
            }
            n12 = i10 - n15;
            int n16 = nArray[i10];
            int n17 = n16 >= n10 ? nArray[i10] - n13 : nArray[i10];
            nArray2[n12] = n17;
        }
        long l10 = this.random.nextLong();
        Random random = new Random(l10);
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = new ShuffleOrder$DefaultShuffleOrder(nArray2, random);
        return shuffleOrder$DefaultShuffleOrder;
    }

    public int getFirstIndex() {
        int n10;
        int[] nArray = this.shuffled;
        int n11 = nArray.length;
        if (n11 > 0) {
            n11 = 0;
            n10 = nArray[0];
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int getLastIndex() {
        int n10;
        int[] nArray = this.shuffled;
        int n11 = nArray.length;
        if (n11 > 0) {
            n11 = nArray.length + -1;
            n10 = nArray[n11];
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int getLength() {
        return this.shuffled.length;
    }

    public int getNextIndex(int n10) {
        int[] nArray = this.shuffled;
        int n11 = nArray.length;
        n10 = (n10 = this.indexInShuffled[n10] + 1) < n11 ? nArray[n10] : -1;
        return n10;
    }

    public int getPreviousIndex(int n10) {
        int[] nArray = this.indexInShuffled;
        n10 = nArray[n10];
        int n11 = -1;
        if ((n10 += n11) >= 0) {
            nArray = this.shuffled;
            n11 = nArray[n10];
        }
        return n11;
    }
}

