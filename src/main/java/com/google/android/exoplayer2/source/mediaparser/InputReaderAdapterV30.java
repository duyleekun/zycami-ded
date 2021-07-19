/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaParser$SeekableInputReader
 */
package com.google.android.exoplayer2.source.mediaparser;

import android.media.MediaParser;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;

public final class InputReaderAdapterV30
implements MediaParser.SeekableInputReader {
    private long currentPosition;
    private DataReader dataReader;
    private long lastSeekPosition;
    private long resourceLength;

    public long getAndResetSeekPosition() {
        long l10 = this.lastSeekPosition;
        this.lastSeekPosition = -1;
        return l10;
    }

    public long getLength() {
        return this.resourceLength;
    }

    public long getPosition() {
        return this.currentPosition;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12 = ((DataReader)Util.castNonNull(this.dataReader)).read(byArray, n10, n11);
        long l10 = this.currentPosition;
        long l11 = n12;
        this.currentPosition = l10 += l11;
        return n12;
    }

    public void seekToPosition(long l10) {
        this.lastSeekPosition = l10;
    }

    public void setCurrentPosition(long l10) {
        this.currentPosition = l10;
    }

    public void setDataReader(DataReader dataReader, long l10) {
        this.dataReader = dataReader;
        this.resourceLength = l10;
        this.lastSeekPosition = -1;
    }
}

