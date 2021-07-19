/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CryptoInfo
 *  android.media.MediaCodec$CryptoInfo$Pattern
 */
package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.CryptoInfo$1;

public final class CryptoInfo$PatternHolderV24 {
    private final MediaCodec.CryptoInfo frameworkCryptoInfo;
    private final MediaCodec.CryptoInfo.Pattern pattern;

    private CryptoInfo$PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
        this.frameworkCryptoInfo = cryptoInfo;
        super(0, 0);
        this.pattern = cryptoInfo;
    }

    public /* synthetic */ CryptoInfo$PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo, CryptoInfo$1 cryptoInfo$1) {
        this(cryptoInfo);
    }

    public static /* synthetic */ void access$100(CryptoInfo$PatternHolderV24 cryptoInfo$PatternHolderV24, int n10, int n11) {
        cryptoInfo$PatternHolderV24.set(n10, n11);
    }

    private void set(int n10, int n11) {
        this.pattern.set(n10, n11);
        MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        MediaCodec.CryptoInfo.Pattern pattern = this.pattern;
        cryptoInfo.setPattern(pattern);
    }
}

