/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import java.util.Arrays;

public final class H262Reader$CsdBuffer {
    private static final byte[] START_CODE;
    public byte[] data;
    private boolean isFilling;
    public int length;
    public int sequenceExtensionPosition;

    static {
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[3];
        byArray[0] = 0;
        byArray2[1] = 0;
        byArray2[2] = 1;
        START_CODE = byArray;
    }

    public H262Reader$CsdBuffer(int n10) {
        byte[] byArray = new byte[n10];
        this.data = byArray;
    }

    public void onData(byte[] byArray, int n10, int n11) {
        int n12;
        boolean bl2 = this.isFilling;
        if (!bl2) {
            return;
        }
        byte[] byArray2 = this.data;
        int n13 = byArray2.length;
        int n14 = this.length;
        int n15 = n14 + (n11 -= n10);
        if (n13 < n15) {
            n14 = (n14 + n11) * 2;
            this.data = byArray2 = Arrays.copyOf(byArray2, n14);
        }
        byArray2 = this.data;
        n13 = this.length;
        System.arraycopy(byArray, n10, byArray2, n13, n11);
        this.length = n12 = this.length + n11;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onStartCode(int n10, int n11) {
        block4: {
            int n12 = this.isFilling;
            boolean bl2 = true;
            if (n12 != 0) {
                this.length = n12 = this.length - n11;
                n11 = this.sequenceExtensionPosition;
                if (n11 == 0 && n10 == (n11 = 181)) {
                    this.sequenceExtensionPosition = n12;
                    break block4;
                } else {
                    this.isFilling = false;
                    return bl2;
                }
            }
            n11 = 179;
            if (n10 == n11) {
                this.isFilling = bl2;
            }
        }
        byte[] byArray = START_CODE;
        n11 = byArray.length;
        this.onData(byArray, 0, n11);
        return false;
    }

    public void reset() {
        this.isFilling = false;
        this.length = 0;
        this.sequenceExtensionPosition = 0;
    }
}

