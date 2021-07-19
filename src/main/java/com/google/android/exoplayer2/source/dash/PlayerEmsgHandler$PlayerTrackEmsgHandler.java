/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$ManifestExpiryEventInfo;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class PlayerEmsgHandler$PlayerTrackEmsgHandler
implements TrackOutput {
    private final MetadataInputBuffer buffer;
    private final FormatHolder formatHolder;
    private long maxLoadedChunkEndTimeUs;
    private final SampleQueue sampleQueue;
    public final /* synthetic */ PlayerEmsgHandler this$0;

    public PlayerEmsgHandler$PlayerTrackEmsgHandler(PlayerEmsgHandler object, Allocator allocator) {
        this.this$0 = object;
        this.sampleQueue = object = SampleQueue.createWithoutDrm(allocator);
        this.formatHolder = object = new FormatHolder();
        this.buffer = object = new MetadataInputBuffer();
        this.maxLoadedChunkEndTimeUs = -9223372036854775807L;
    }

    private MetadataInputBuffer dequeueSample() {
        this.buffer.clear();
        SampleQueue sampleQueue = this.sampleQueue;
        FormatHolder formatHolder = this.formatHolder;
        MetadataInputBuffer metadataInputBuffer = this.buffer;
        int n10 = sampleQueue.read(formatHolder, metadataInputBuffer, false, false);
        int n11 = -4;
        if (n10 == n11) {
            this.buffer.flip();
            return this.buffer;
        }
        return null;
    }

    private void onManifestExpiredMessageEncountered(long l10, long l11) {
        PlayerEmsgHandler$ManifestExpiryEventInfo playerEmsgHandler$ManifestExpiryEventInfo = new PlayerEmsgHandler$ManifestExpiryEventInfo(l10, l11);
        Handler handler = PlayerEmsgHandler.access$300(this.this$0);
        Message message = PlayerEmsgHandler.access$300(this.this$0).obtainMessage(1, (Object)playerEmsgHandler$ManifestExpiryEventInfo);
        handler.sendMessage(message);
    }

    private void parseAndDiscardSamples() {
        while (true) {
            Object object = this.sampleQueue;
            boolean bl2 = false;
            String string2 = null;
            boolean bl3 = ((SampleQueue)object).isReady(false);
            if (!bl3) break;
            object = this.dequeueSample();
            if (object == null) continue;
            long l10 = ((DecoderInputBuffer)object).timeUs;
            Object object2 = PlayerEmsgHandler.access$000(this.this$0);
            object = ((SimpleMetadataDecoder)object2).decode((MetadataInputBuffer)object);
            if (object == null) continue;
            object = (EventMessage)((Metadata)object).get(0);
            string2 = ((EventMessage)object).schemeIdUri;
            object2 = ((EventMessage)object).value;
            bl2 = PlayerEmsgHandler.access$100(string2, (String)object2);
            if (!bl2) continue;
            this.parsePlayerEmsgEvent(l10, (EventMessage)object);
        }
        this.sampleQueue.discardToRead();
    }

    private void parsePlayerEmsgEvent(long l10, EventMessage eventMessage) {
        long l11;
        long l12 = PlayerEmsgHandler.access$200(eventMessage);
        long l13 = l12 - (l11 = -9223372036854775807L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        this.onManifestExpiredMessageEncountered(l10, l12);
    }

    public void format(Format format) {
        this.sampleQueue.format(format);
    }

    public boolean maybeRefreshManifestBeforeLoadingNextChunk(long l10) {
        return this.this$0.maybeRefreshManifestBeforeLoadingNextChunk(l10);
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        long l10;
        long l11;
        long l12 = this.maxLoadedChunkEndTimeUs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false || (l11 = (l10 = (l13 = chunk.endTimeUs) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
            this.maxLoadedChunkEndTimeUs = l12 = chunk.endTimeUs;
        }
        this.this$0.onChunkLoadCompleted(chunk);
    }

    public boolean onChunkLoadError(Chunk chunk) {
        long l10;
        int n10;
        long l11 = this.maxLoadedChunkEndTimeUs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false && (n10 = (l10 = l11 - (l12 = chunk.startTimeUs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0) {
            n10 = 1;
        } else {
            n10 = 0;
            chunk = null;
        }
        return this.this$0.onChunkLoadError(n10 != 0);
    }

    public void release() {
        this.sampleQueue.release();
    }

    public int sampleData(DataReader dataReader, int n10, boolean bl2, int n11) {
        return this.sampleQueue.sampleData(dataReader, n10, bl2);
    }

    public void sampleData(ParsableByteArray parsableByteArray, int n10, int n11) {
        this.sampleQueue.sampleData(parsableByteArray, n10);
    }

    public void sampleMetadata(long l10, int n10, int n11, int n12, TrackOutput$CryptoData trackOutput$CryptoData) {
        this.sampleQueue.sampleMetadata(l10, n10, n11, n12, trackOutput$CryptoData);
        this.parseAndDiscardSamples();
    }
}

