/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.Map;

public final class StatsDataSource
implements DataSource {
    private long bytesRead;
    private final DataSource dataSource;
    private Uri lastOpenedUri;
    private Map lastResponseHeaders;

    public StatsDataSource(DataSource object) {
        object = (DataSource)Assertions.checkNotNull(object);
        this.dataSource = object;
        object = Uri.EMPTY;
        this.lastOpenedUri = object;
        this.lastResponseHeaders = object = Collections.emptyMap();
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.dataSource.addTransferListener(transferListener);
    }

    public void close() {
        this.dataSource.close();
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public Uri getLastOpenedUri() {
        return this.lastOpenedUri;
    }

    public Map getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    public Map getResponseHeaders() {
        return this.dataSource.getResponseHeaders();
    }

    public Uri getUri() {
        return this.dataSource.getUri();
    }

    public long open(DataSpec object) {
        Object object2;
        this.lastOpenedUri = object2 = ((DataSpec)object).uri;
        object2 = Collections.emptyMap();
        this.lastResponseHeaders = object2;
        long l10 = this.dataSource.open((DataSpec)object);
        object = (Uri)Assertions.checkNotNull(this.getUri());
        this.lastOpenedUri = object;
        this.lastResponseHeaders = object = this.getResponseHeaders();
        return l10;
    }

    public int read(byte[] byArray, int n10, int n11) {
        DataSource dataSource = this.dataSource;
        int n12 = dataSource.read(byArray, n10, n11);
        if (n12 != (n10 = -1)) {
            long l10 = this.bytesRead;
            long l11 = n12;
            this.bytesRead = l10 += l11;
        }
        return n12;
    }

    public void resetBytesRead() {
        this.bytesRead = 0L;
    }
}

