/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.source.IcyDataSource$Listener;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Map;

public final class IcyDataSource
implements DataSource {
    private int bytesUntilMetadata;
    private final IcyDataSource$Listener listener;
    private final int metadataIntervalBytes;
    private final byte[] metadataLengthByteHolder;
    private final DataSource upstream;

    public IcyDataSource(DataSource object, int n10, IcyDataSource$Listener icyDataSource$Listener) {
        int n11 = 1;
        int n12 = n10 > 0 ? n11 : 0;
        Assertions.checkArgument(n12 != 0);
        this.upstream = object;
        this.metadataIntervalBytes = n10;
        this.listener = icyDataSource$Listener;
        object = new byte[n11];
        this.metadataLengthByteHolder = (byte[])object;
        this.bytesUntilMetadata = n10;
    }

    private boolean readMetadata() {
        int n10;
        int n11;
        Object object = this.upstream;
        Object object2 = this.metadataLengthByteHolder;
        ParsableByteArray parsableByteArray = null;
        boolean bl2 = true;
        int n12 = object.read((byte[])object2, 0, (int)(bl2 ? 1 : 0));
        if (n12 == (n11 = -1)) {
            return false;
        }
        object = this.metadataLengthByteHolder;
        n12 = (object[0] & 0xFF) << 4;
        if (n12 == 0) {
            return bl2;
        }
        byte[] byArray = new byte[n12];
        int n13 = 0;
        for (int i10 = n12; i10 > 0; i10 -= n10) {
            DataSource dataSource = this.upstream;
            n10 = dataSource.read(byArray, n13, i10);
            if (n10 == n11) {
                return false;
            }
            n13 += n10;
        }
        while (n12 > 0) {
            n11 = n12 + -1;
            if ((n11 = byArray[n11]) != 0) break;
            n12 += -1;
        }
        if (n12 > 0) {
            object2 = this.listener;
            parsableByteArray = new ParsableByteArray(byArray, n12);
            object2.onIcyMetadata(parsableByteArray);
        }
        return bl2;
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    public void close() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    public Uri getUri() {
        return this.upstream.getUri();
    }

    public long open(DataSpec object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        DataSource dataSource;
        int n13;
        int n14 = this.bytesUntilMetadata;
        int n15 = -1;
        if (n14 == 0) {
            n14 = (int)(this.readMetadata() ? 1 : 0);
            if (n14 != 0) {
                this.bytesUntilMetadata = n14 = this.metadataIntervalBytes;
            } else {
                return n15;
            }
        }
        if ((n13 = (dataSource = this.upstream).read(byArray, n10, n11 = Math.min(n12 = this.bytesUntilMetadata, n11))) != n15) {
            this.bytesUntilMetadata = n10 = this.bytesUntilMetadata - n13;
        }
        return n13;
    }
}

