/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public class CheckCRC64DownloadInputStream
extends CheckedInputStream {
    private long mClientCRC64;
    private String mRequestId;
    private long mServerCRC64;
    private long mTotalBytesRead;
    private long mTotalLength;

    public CheckCRC64DownloadInputStream(InputStream inputStream, Checksum checksum, long l10, long l11, String string2) {
        super(inputStream, checksum);
        this.mTotalLength = l10;
        this.mServerCRC64 = l11;
        this.mRequestId = string2;
    }

    private void checkCRC64(int n10) {
        long l10 = this.mTotalBytesRead;
        long l11 = n10;
        this.mTotalBytesRead = l10 += l11;
        l11 = this.mTotalLength;
        long l12 = l10 - l11;
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n10 >= 0) {
            this.mClientCRC64 = l10 = this.getChecksum().getValue();
            Long l13 = l10;
            l10 = this.mServerCRC64;
            Long l14 = l10;
            String string2 = this.mRequestId;
            OSSUtils.checkChecksum(l13, l14, string2);
        }
    }

    public long getClientCRC64() {
        return this.mClientCRC64;
    }

    public int read() {
        int n10 = super.read();
        this.checkCRC64(n10);
        return n10;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12 = super.read(byArray, n10, n11);
        this.checkCRC64(n12);
        return n12;
    }
}

