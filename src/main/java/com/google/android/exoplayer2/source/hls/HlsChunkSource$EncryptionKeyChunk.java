/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.Arrays;

public final class HlsChunkSource$EncryptionKeyChunk
extends DataChunk {
    private byte[] result;

    public HlsChunkSource$EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int n10, Object object, byte[] byArray) {
        super(dataSource, dataSpec, 3, format, n10, object, byArray);
    }

    public void consume(byte[] byArray, int n10) {
        byArray = Arrays.copyOf(byArray, n10);
        this.result = byArray;
    }

    public byte[] getResult() {
        return this.result;
    }
}

