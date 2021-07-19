/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;
import com.google.android.exoplayer2.source.chunk.MediaParserChunkExtractor;
import com.google.android.exoplayer2.source.chunk.MediaParserChunkExtractor$1;

public class MediaParserChunkExtractor$TrackOutputProviderAdapter
implements ExtractorOutput {
    public final /* synthetic */ MediaParserChunkExtractor this$0;

    private MediaParserChunkExtractor$TrackOutputProviderAdapter(MediaParserChunkExtractor mediaParserChunkExtractor) {
        this.this$0 = mediaParserChunkExtractor;
    }

    public /* synthetic */ MediaParserChunkExtractor$TrackOutputProviderAdapter(MediaParserChunkExtractor mediaParserChunkExtractor, MediaParserChunkExtractor$1 mediaParserChunkExtractor$1) {
        this(mediaParserChunkExtractor);
    }

    public void endTracks() {
        MediaParserChunkExtractor mediaParserChunkExtractor = this.this$0;
        Format[] formatArray = MediaParserChunkExtractor.access$400(mediaParserChunkExtractor).getSampleFormats();
        MediaParserChunkExtractor.access$302(mediaParserChunkExtractor, formatArray);
    }

    public void seekMap(SeekMap seekMap) {
    }

    public TrackOutput track(int n10, int n11) {
        TrackOutput trackOutput;
        ChunkExtractor$TrackOutputProvider chunkExtractor$TrackOutputProvider = MediaParserChunkExtractor.access$100(this.this$0);
        if (chunkExtractor$TrackOutputProvider != null) {
            chunkExtractor$TrackOutputProvider = MediaParserChunkExtractor.access$100(this.this$0);
            trackOutput = chunkExtractor$TrackOutputProvider.track(n10, n11);
        } else {
            trackOutput = MediaParserChunkExtractor.access$200(this.this$0);
        }
        return trackOutput;
    }
}

