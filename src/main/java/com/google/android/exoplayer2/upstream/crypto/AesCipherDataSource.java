/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream.crypto;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher;
import com.google.android.exoplayer2.upstream.crypto.CryptoUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Map;

public final class AesCipherDataSource
implements DataSource {
    private AesFlushingCipher cipher;
    private final byte[] secretKey;
    private final DataSource upstream;

    public AesCipherDataSource(byte[] byArray, DataSource dataSource) {
        this.upstream = dataSource;
        this.secretKey = byArray;
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    public void close() {
        this.cipher = null;
        this.upstream.close();
    }

    public Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    public Uri getUri() {
        return this.upstream.getUri();
    }

    public long open(DataSpec dataSpec) {
        AesFlushingCipher aesFlushingCipher;
        long l10 = this.upstream.open(dataSpec);
        long l11 = CryptoUtil.getFNV64Hash(dataSpec.key);
        byte[] byArray = this.secretKey;
        long l12 = dataSpec.uriPositionOffset;
        long l13 = dataSpec.position + l12;
        this.cipher = aesFlushingCipher = new AesFlushingCipher(2, byArray, l11, l13);
        return l10;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        if (n11 == 0) {
            return 0;
        }
        DataSource dataSource = this.upstream;
        if ((n11 = dataSource.read(byArray, n10, n11)) == (n12 = -1)) {
            return n12;
        }
        ((AesFlushingCipher)Util.castNonNull(this.cipher)).updateInPlace(byArray, n10, n11);
        return n11;
    }
}

