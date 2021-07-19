/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CryptoInfo
 */
package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.CryptoInfo$PatternHolderV24;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    private final MediaCodec.CryptoInfo frameworkCryptoInfo;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final CryptoInfo$PatternHolderV24 patternHolder;

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo;
        this.frameworkCryptoInfo = cryptoInfo = new MediaCodec.CryptoInfo();
        int n10 = Util.SDK_INT;
        CryptoInfo$PatternHolderV24 cryptoInfo$PatternHolderV24 = null;
        int n11 = 24;
        if (n10 >= n11) {
            CryptoInfo$PatternHolderV24 cryptoInfo$PatternHolderV242;
            cryptoInfo$PatternHolderV24 = cryptoInfo$PatternHolderV242 = new CryptoInfo$PatternHolderV24(cryptoInfo, null);
        }
        this.patternHolder = cryptoInfo$PatternHolderV24;
    }

    public MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.frameworkCryptoInfo;
    }

    public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return this.getFrameworkCryptoInfo();
    }

    public void increaseClearDataFirstSubSampleBy(int n10) {
        int n11;
        if (n10 == 0) {
            return;
        }
        int[] nArray = this.numBytesOfClearData;
        if (nArray == null) {
            int n12 = 1;
            this.numBytesOfClearData = nArray = new int[n12];
            MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
            cryptoInfo.numBytesOfClearData = nArray;
        }
        nArray = this.numBytesOfClearData;
        nArray[0] = n11 = nArray[0] + n10;
    }

    public void set(int n10, int[] nArray, int[] nArray2, byte[] byArray, byte[] byArray2, int n11, int n12, int n13) {
        this.numSubSamples = n10;
        this.numBytesOfClearData = nArray;
        this.numBytesOfEncryptedData = nArray2;
        this.key = byArray;
        this.iv = byArray2;
        this.mode = n11;
        this.encryptedBlocks = n12;
        this.clearBlocks = n13;
        MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        cryptoInfo.numSubSamples = n10;
        cryptoInfo.numBytesOfClearData = nArray;
        cryptoInfo.numBytesOfEncryptedData = nArray2;
        cryptoInfo.key = byArray;
        cryptoInfo.iv = byArray2;
        cryptoInfo.mode = n11;
        n10 = Util.SDK_INT;
        int n14 = 24;
        if (n10 >= n14) {
            CryptoInfo$PatternHolderV24 cryptoInfo$PatternHolderV24 = (CryptoInfo$PatternHolderV24)Assertions.checkNotNull(this.patternHolder);
            CryptoInfo$PatternHolderV24.access$100(cryptoInfo$PatternHolderV24, n12, n13);
        }
    }
}

