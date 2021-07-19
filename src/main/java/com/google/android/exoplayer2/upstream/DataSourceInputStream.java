/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.InputStream;

public final class DataSourceInputStream
extends InputStream {
    private boolean closed = false;
    private final DataSource dataSource;
    private final DataSpec dataSpec;
    private boolean opened = false;
    private final byte[] singleByteArray;
    private long totalBytesRead;

    public DataSourceInputStream(DataSource object, DataSpec dataSpec) {
        this.dataSource = object;
        this.dataSpec = dataSpec;
        object = new byte[1];
        this.singleByteArray = (byte[])object;
    }

    private void checkOpened() {
        boolean bl2 = this.opened;
        if (!bl2) {
            DataSource dataSource = this.dataSource;
            DataSpec dataSpec = this.dataSpec;
            dataSource.open(dataSpec);
            this.opened = bl2 = true;
        }
    }

    public long bytesRead() {
        return this.totalBytesRead;
    }

    public void close() {
        boolean bl2 = this.closed;
        if (!bl2) {
            DataSource dataSource = this.dataSource;
            dataSource.close();
            this.closed = bl2 = true;
        }
    }

    public void open() {
        this.checkOpened();
    }

    public int read() {
        int n10;
        byte[] byArray = this.singleByteArray;
        int n11 = this.read(byArray);
        if (n11 != (n10 = -1)) {
            byArray = this.singleByteArray;
            n11 = byArray[0];
            n10 = n11 & 0xFF;
        }
        return n10;
    }

    public int read(byte[] byArray) {
        int n10 = byArray.length;
        return this.read(byArray, 0, n10);
    }

    public int read(byte[] byArray, int n10, int n11) {
        boolean bl2 = this.closed ^ true;
        Assertions.checkState(bl2);
        this.checkOpened();
        DataSource dataSource = this.dataSource;
        int n12 = dataSource.read(byArray, n10, n11);
        n10 = -1;
        if (n12 == n10) {
            return n10;
        }
        long l10 = this.totalBytesRead;
        long l11 = n12;
        this.totalBytesRead = l10 += l11;
        return n12;
    }
}

