/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int n10, int n11) {
        this.targetType = n10;
        byte[] byArray = new byte[n11 + 3];
        this.nalData = byArray;
        byArray[2] = 1;
    }

    public void appendToNalUnit(byte[] byArray, int n10, int n11) {
        int n12;
        boolean bl2 = this.isFilling;
        if (!bl2) {
            return;
        }
        byte[] byArray2 = this.nalData;
        int n13 = byArray2.length;
        int n14 = this.nalLength;
        int n15 = n14 + (n11 -= n10);
        if (n13 < n15) {
            n14 = (n14 + n11) * 2;
            this.nalData = byArray2 = Arrays.copyOf(byArray2, n14);
        }
        byArray2 = this.nalData;
        n13 = this.nalLength;
        System.arraycopy(byArray, n10, byArray2, n13, n11);
        this.nalLength = n12 = this.nalLength + n11;
    }

    public boolean endNalUnit(int n10) {
        int n11 = this.isFilling;
        if (n11 == 0) {
            return false;
        }
        this.nalLength = n11 = this.nalLength - n10;
        this.isFilling = false;
        n10 = 1;
        this.isCompleted = n10;
        return n10 != 0;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public void startNalUnit(int n10) {
        int n11 = this.isFilling;
        boolean bl2 = true;
        Assertions.checkState(n11 ^ bl2);
        n11 = this.targetType;
        if (n10 != n11) {
            bl2 = false;
        }
        this.isFilling = bl2;
        if (bl2) {
            this.nalLength = n10 = 3;
            this.isCompleted = false;
        }
    }
}

