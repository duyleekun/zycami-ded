/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher;
import com.google.android.exoplayer2.upstream.crypto.CryptoUtil;
import com.google.android.exoplayer2.util.Util;

public final class AesCipherDataSink
implements DataSink {
    private AesFlushingCipher cipher;
    private final byte[] scratch;
    private final byte[] secretKey;
    private final DataSink wrappedDataSink;

    public AesCipherDataSink(byte[] byArray, DataSink dataSink) {
        this(byArray, dataSink, null);
    }

    public AesCipherDataSink(byte[] byArray, DataSink dataSink, byte[] byArray2) {
        this.wrappedDataSink = dataSink;
        this.secretKey = byArray;
        this.scratch = byArray2;
    }

    public void close() {
        this.cipher = null;
        this.wrappedDataSink.close();
    }

    public void open(DataSpec dataSpec) {
        AesFlushingCipher aesFlushingCipher;
        this.wrappedDataSink.open(dataSpec);
        long l10 = CryptoUtil.getFNV64Hash(dataSpec.key);
        byte[] byArray = this.secretKey;
        long l11 = dataSpec.uriPositionOffset;
        long l12 = dataSpec.position + l11;
        this.cipher = aesFlushingCipher = new AesFlushingCipher(1, byArray, l10, l12);
    }

    public void write(byte[] byArray, int n10, int n11) {
        Object object = this.scratch;
        if (object == null) {
            ((AesFlushingCipher)Util.castNonNull(this.cipher)).updateInPlace(byArray, n10, n11);
            object = this.wrappedDataSink;
            object.write(byArray, n10, n11);
        } else {
            int n12;
            object = null;
            for (int i10 = 0; i10 < n11; i10 += n12) {
                Object object2;
                n12 = n11 - i10;
                int n13 = this.scratch.length;
                n12 = Math.min(n12, n13);
                Object object3 = object2 = Util.castNonNull(this.cipher);
                object3 = (AesFlushingCipher)object2;
                int n14 = n10 + i10;
                byte[] byArray2 = this.scratch;
                ((AesFlushingCipher)object3).update(byArray, n14, n12, byArray2, 0);
                object2 = this.wrappedDataSink;
                object3 = this.scratch;
                object2.write((byte[])object3, 0, n12);
            }
        }
    }
}

