/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaParser
 *  android.media.MediaParser$OutputConsumer
 *  android.media.MediaParser$SeekMap
 *  android.media.MediaParser$SeekPoint
 */
package com.google.android.exoplayer2.source.chunk;

import android.media.MediaParser;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;
import com.google.android.exoplayer2.source.chunk.MediaParserChunkExtractor$TrackOutputProviderAdapter;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;

public final class MediaParserChunkExtractor
implements ChunkExtractor {
    private final DummyTrackOutput dummyTrackOutput;
    private final InputReaderAdapterV30 inputReaderAdapter;
    private final MediaParser mediaParser;
    private final OutputConsumerAdapterV30 outputConsumerAdapter;
    private long pendingSeekUs;
    private Format[] sampleFormats;
    private ChunkExtractor$TrackOutputProvider trackOutputProvider;
    private final MediaParserChunkExtractor$TrackOutputProviderAdapter trackOutputProviderAdapter;

    public MediaParserChunkExtractor(int n10, Format object, List list) {
        int n11;
        boolean bl2 = true;
        Object object2 = new OutputConsumerAdapterV30((Format)object, n10, bl2);
        this.outputConsumerAdapter = object2;
        Object object3 = new InputReaderAdapterV30();
        this.inputReaderAdapter = object3;
        object3 = (String)Assertions.checkNotNull(((Format)object).containerMimeType);
        n10 = (int)(MimeTypes.isMatroska((String)object3) ? 1 : 0);
        object3 = n10 != 0 ? "android.media.mediaparser.MatroskaParser" : "android.media.mediaparser.FragmentedMp4Parser";
        ((OutputConsumerAdapterV30)object2).setSelectedParserName((String)object3);
        object3 = MediaParser.createByName((String)object3, (MediaParser.OutputConsumer)object2);
        this.mediaParser = object3;
        object = Boolean.TRUE;
        object3.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", object);
        object3.setParameter("android.media.mediaparser.inBandCryptoInfo", object);
        object3.setParameter("android.media.mediaparser.includeSupplementalData", object);
        object3.setParameter("android.media.mediaparser.eagerlyExposeTrackType", object);
        object3.setParameter("android.media.mediaparser.exposeDummySeekMap", object);
        object3.setParameter("android.media.mediaParser.exposeChunkIndexAsMediaFormat", object);
        object2 = "android.media.mediaParser.overrideInBandCaptionDeclarations";
        object3.setParameter((String)object2, object);
        object3 = new ArrayList();
        object = null;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            object2 = MediaParserUtil.toCaptionsMediaFormat((Format)list.get(i10));
            ((ArrayList)object3).add(object2);
        }
        this.mediaParser.setParameter("android.media.mediaParser.exposeCaptionFormats", object3);
        this.outputConsumerAdapter.setMuxedCaptionFormats(list);
        this.trackOutputProviderAdapter = object3 = new MediaParserChunkExtractor$TrackOutputProviderAdapter(this, null);
        this.dummyTrackOutput = object3 = new DummyTrackOutput();
        this.pendingSeekUs = -9223372036854775807L;
    }

    public static /* synthetic */ ChunkExtractor$TrackOutputProvider access$100(MediaParserChunkExtractor mediaParserChunkExtractor) {
        return mediaParserChunkExtractor.trackOutputProvider;
    }

    public static /* synthetic */ DummyTrackOutput access$200(MediaParserChunkExtractor mediaParserChunkExtractor) {
        return mediaParserChunkExtractor.dummyTrackOutput;
    }

    public static /* synthetic */ Format[] access$302(MediaParserChunkExtractor mediaParserChunkExtractor, Format[] formatArray) {
        mediaParserChunkExtractor.sampleFormats = formatArray;
        return formatArray;
    }

    public static /* synthetic */ OutputConsumerAdapterV30 access$400(MediaParserChunkExtractor mediaParserChunkExtractor) {
        return mediaParserChunkExtractor.outputConsumerAdapter;
    }

    private void maybeExecutePendingSeek() {
        MediaParser.SeekMap seekMap = this.outputConsumerAdapter.getDummySeekMap();
        long l10 = this.pendingSeekUs;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false && seekMap != null) {
            MediaParser mediaParser = this.mediaParser;
            seekMap = (MediaParser.SeekPoint)seekMap.getSeekPoints((long)l10).first;
            mediaParser.seek((MediaParser.SeekPoint)seekMap);
            this.pendingSeekUs = l11;
        }
    }

    public ChunkIndex getChunkIndex() {
        return this.outputConsumerAdapter.getChunkIndex();
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(ChunkExtractor$TrackOutputProvider object, long l10, long l11) {
        this.trackOutputProvider = object;
        this.outputConsumerAdapter.setSampleTimestampUpperLimitFilterUs(l11);
        object = this.outputConsumerAdapter;
        MediaParserChunkExtractor$TrackOutputProviderAdapter mediaParserChunkExtractor$TrackOutputProviderAdapter = this.trackOutputProviderAdapter;
        ((OutputConsumerAdapterV30)object).setExtractorOutput(mediaParserChunkExtractor$TrackOutputProviderAdapter);
        this.pendingSeekUs = l10;
    }

    public boolean read(ExtractorInput extractorInput) {
        this.maybeExecutePendingSeek();
        InputReaderAdapterV30 inputReaderAdapterV30 = this.inputReaderAdapter;
        long l10 = extractorInput.getLength();
        inputReaderAdapterV30.setDataReader(extractorInput, l10);
        extractorInput = this.mediaParser;
        inputReaderAdapterV30 = this.inputReaderAdapter;
        return extractorInput.advance(inputReaderAdapterV30);
    }

    public void release() {
        this.mediaParser.release();
    }
}

