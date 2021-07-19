/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

public final class TeeDataSource
implements DataSource {
    private long bytesRemaining;
    private final DataSink dataSink;
    private boolean dataSinkNeedsClosing;
    private final DataSource upstream;

    public TeeDataSource(DataSource object, DataSink dataSink) {
        object = (DataSource)Assertions.checkNotNull(object);
        this.upstream = object;
        this.dataSink = object = (DataSink)Assertions.checkNotNull(dataSink);
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    public void close() {
        DataSink dataSink = null;
        try {
            DataSource dataSource = this.upstream;
            dataSource.close();
            return;
        }
        finally {
            boolean bl2 = this.dataSinkNeedsClosing;
            if (bl2) {
                this.dataSinkNeedsClosing = false;
                dataSink = this.dataSink;
                dataSink.close();
            }
        }
    }

    public Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    public Uri getUri() {
        return this.upstream.getUri();
    }

    public long open(DataSpec dataSpec) {
        long l10;
        DataSource dataSource = this.upstream;
        this.bytesRemaining = l10 = dataSource.open(dataSpec);
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return l11;
        }
        long l13 = dataSpec.length;
        long l14 = -1;
        long l15 = l13 - l14;
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false && (object = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1)) != false) {
            dataSpec = dataSpec.subrange(l11, l10);
        }
        this.dataSinkNeedsClosing = true;
        this.dataSink.open(dataSpec);
        return this.bytesRemaining;
    }

    public int read(byte[] byArray, int n10, int n11) {
        long l10 = this.bytesRemaining;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return -1;
        }
        Object object2 = this.upstream;
        if ((n11 = object2.read(byArray, n10, n11)) > 0) {
            object2 = this.dataSink;
            object2.write(byArray, n10, n11);
            long l13 = this.bytesRemaining;
            l10 = -1;
            object = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
            if (object != false) {
                l10 = n11;
                this.bytesRemaining = l13 -= l10;
            }
        }
        return n11;
    }
}

