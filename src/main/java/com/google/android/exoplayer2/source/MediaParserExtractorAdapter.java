/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaParser
 *  android.media.MediaParser$OutputConsumer
 *  android.media.MediaParser$SeekPoint
 *  android.media.MediaParser$SeekableInputReader
 *  android.net.Uri
 *  android.util.Pair
 */
package com.google.android.exoplayer2.source;

import android.media.MediaParser;
import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.upstream.DataReader;
import java.util.Map;

public final class MediaParserExtractorAdapter
implements ProgressiveMediaExtractor {
    private final InputReaderAdapterV30 inputReaderAdapter;
    private final MediaParser mediaParser;
    private final OutputConsumerAdapterV30 outputConsumerAdapter;
    private String parserName;

    public MediaParserExtractorAdapter() {
        OutputConsumerAdapterV30 outputConsumerAdapterV30;
        this.outputConsumerAdapter = outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        Object object = new InputReaderAdapterV30();
        this.inputReaderAdapter = object;
        object = new String[]{};
        outputConsumerAdapterV30 = MediaParser.create((MediaParser.OutputConsumer)outputConsumerAdapterV30, (String[])object);
        this.mediaParser = outputConsumerAdapterV30;
        object = Boolean.TRUE;
        outputConsumerAdapterV30.setParameter("android.media.mediaparser.eagerlyExposeTrackType", object);
        outputConsumerAdapterV30.setParameter("android.media.mediaparser.inBandCryptoInfo", object);
        outputConsumerAdapterV30.setParameter("android.media.mediaparser.includeSupplementalData", object);
        this.parserName = "android.media.mediaparser.UNKNOWN";
    }

    public void disableSeekingOnMp3Streams() {
        String string2 = "android.media.mediaparser.Mp3Parser";
        Object object = this.parserName;
        boolean bl2 = string2.equals(object);
        if (bl2) {
            object = this.outputConsumerAdapter;
            ((OutputConsumerAdapterV30)object).disableSeeking();
        }
    }

    public long getCurrentInputPosition() {
        return this.inputReaderAdapter.getPosition();
    }

    public void init(DataReader object, Uri object2, Map map, long l10, long l11, ExtractorOutput extractorOutput) {
        this.outputConsumerAdapter.setExtractorOutput(extractorOutput);
        this.inputReaderAdapter.setDataReader((DataReader)object, l11);
        this.inputReaderAdapter.setCurrentPosition(l10);
        object = this.mediaParser.getParserName();
        object2 = "android.media.mediaparser.UNKNOWN";
        boolean bl2 = ((String)object2).equals(object);
        if (bl2) {
            object = this.mediaParser;
            object2 = this.inputReaderAdapter;
            object.advance((MediaParser.SeekableInputReader)object2);
            this.parserName = object = this.mediaParser.getParserName();
            object2 = this.outputConsumerAdapter;
            ((OutputConsumerAdapterV30)object2).setSelectedParserName((String)object);
        } else {
            object2 = this.parserName;
            boolean bl3 = ((String)object).equals(object2);
            if (!bl3) {
                this.parserName = object = this.mediaParser.getParserName();
                object2 = this.outputConsumerAdapter;
                ((OutputConsumerAdapterV30)object2).setSelectedParserName((String)object);
            }
        }
    }

    public int read(PositionHolder positionHolder) {
        int n10;
        long l10;
        MediaParser mediaParser = this.mediaParser;
        InputReaderAdapterV30 inputReaderAdapterV30 = this.inputReaderAdapter;
        boolean bl2 = mediaParser.advance((MediaParser.SeekableInputReader)inputReaderAdapterV30);
        inputReaderAdapterV30 = this.inputReaderAdapter;
        positionHolder.position = l10 = inputReaderAdapterV30.getAndResetSeekPosition();
        if (!bl2) {
            n10 = -1;
        } else {
            long l11 = -1;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) {
                n10 = 1;
            } else {
                n10 = 0;
                positionHolder = null;
            }
        }
        return n10;
    }

    public void release() {
        this.mediaParser.release();
    }

    public void seek(long l10, long l11) {
        this.inputReaderAdapter.setCurrentPosition(l10);
        Pair pair = this.outputConsumerAdapter.getSeekPoints(l11);
        MediaParser mediaParser = this.mediaParser;
        MediaParser.SeekPoint seekPoint = (MediaParser.SeekPoint)pair.second;
        long l12 = seekPoint.position;
        long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        Object object = l13 == false ? pair.second : pair.first;
        object = (MediaParser.SeekPoint)object;
        mediaParser.seek((MediaParser.SeekPoint)object);
    }
}

