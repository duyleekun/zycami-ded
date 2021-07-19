/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import java.util.Arrays;

public final class TrackOutput$CryptoData {
    public final int clearBlocks;
    public final int cryptoMode;
    public final int encryptedBlocks;
    public final byte[] encryptionKey;

    public TrackOutput$CryptoData(int n10, byte[] byArray, int n11, int n12) {
        this.cryptoMode = n10;
        this.encryptionKey = byArray;
        this.encryptedBlocks = n11;
        this.clearBlocks = n12;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = TrackOutput$CryptoData.class) == (clazz = object.getClass())) {
            boolean bl3;
            object = (TrackOutput$CryptoData)object;
            int n10 = this.cryptoMode;
            int n11 = ((TrackOutput$CryptoData)object).cryptoMode;
            if (n10 != n11 || (n10 = this.encryptedBlocks) != (n11 = ((TrackOutput$CryptoData)object).encryptedBlocks) || (n10 = this.clearBlocks) != (n11 = ((TrackOutput$CryptoData)object).clearBlocks) || !(bl3 = Arrays.equals((byte[])(object2 = (Object)this.encryptionKey), (byte[])(object = (Object)((TrackOutput$CryptoData)object).encryptionKey)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.cryptoMode * 31;
        int n11 = Arrays.hashCode(this.encryptionKey);
        n10 = (n10 + n11) * 31;
        n11 = this.encryptedBlocks;
        n10 = (n10 + n11) * 31;
        n11 = this.clearBlocks;
        return n10 + n11;
    }
}

