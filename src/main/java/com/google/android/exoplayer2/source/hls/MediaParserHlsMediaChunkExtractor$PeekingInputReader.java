/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaParser$SeekableInputReader
 */
package com.google.android.exoplayer2.source.hls;

import android.media.MediaParser;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.source.hls.MediaParserHlsMediaChunkExtractor$1;

public final class MediaParserHlsMediaChunkExtractor$PeekingInputReader
implements MediaParser.SeekableInputReader {
    private final ExtractorInput extractorInput;
    private int totalPeekedBytes;

    private MediaParserHlsMediaChunkExtractor$PeekingInputReader(ExtractorInput extractorInput) {
        this.extractorInput = extractorInput;
    }

    public /* synthetic */ MediaParserHlsMediaChunkExtractor$PeekingInputReader(ExtractorInput extractorInput, MediaParserHlsMediaChunkExtractor$1 mediaParserHlsMediaChunkExtractor$1) {
        this(extractorInput);
    }

    public static /* synthetic */ int access$100(MediaParserHlsMediaChunkExtractor$PeekingInputReader mediaParserHlsMediaChunkExtractor$PeekingInputReader) {
        return mediaParserHlsMediaChunkExtractor$PeekingInputReader.totalPeekedBytes;
    }

    public long getLength() {
        return this.extractorInput.getLength();
    }

    public long getPosition() {
        return this.extractorInput.getPeekPosition();
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12 = this.extractorInput.peek(byArray, n10, n11);
        this.totalPeekedBytes = n10 = this.totalPeekedBytes + n12;
        return n12;
    }

    public void seekToPosition(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

