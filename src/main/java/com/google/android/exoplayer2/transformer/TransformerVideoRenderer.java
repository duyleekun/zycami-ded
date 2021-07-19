/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.transformer.MuxerWrapper;
import com.google.android.exoplayer2.transformer.SampleTransformer;
import com.google.android.exoplayer2.transformer.SefSlowMotionVideoSampleTransformer;
import com.google.android.exoplayer2.transformer.Transformation;
import com.google.android.exoplayer2.transformer.TransformerBaseRenderer;
import com.google.android.exoplayer2.transformer.TransformerMediaClock;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public final class TransformerVideoRenderer
extends TransformerBaseRenderer {
    private static final String TAG = "TransformerVideoRenderer";
    private final DecoderInputBuffer buffer;
    private boolean formatRead;
    private boolean isBufferPending;
    private boolean isInputStreamEnded;
    private SampleTransformer sampleTransformer;

    public TransformerVideoRenderer(MuxerWrapper object, TransformerMediaClock transformerMediaClock, Transformation transformation) {
        int n10 = 2;
        super(n10, (MuxerWrapper)object, transformerMediaClock, transformation);
        this.buffer = object = new DecoderInputBuffer(n10);
    }

    private boolean readAndTransformBuffer() {
        this.buffer.clear();
        Object object = this.getFormatHolder();
        DecoderInputBuffer decoderInputBuffer = this.buffer;
        int n10 = 0;
        DecoderInputBuffer decoderInputBuffer2 = null;
        int bl2 = this.readSource((FormatHolder)object, decoderInputBuffer, false);
        int n11 = -5;
        if (bl2 != n11) {
            int n12 = -3;
            if (bl2 == n12) {
                return false;
            }
            object = this.buffer;
            boolean bl3 = ((Buffer)object).isEndOfStream();
            boolean bl4 = true;
            if (bl3) {
                this.isInputStreamEnded = bl4;
                object = this.muxerWrapper;
                int n13 = this.getTrackType();
                ((MuxerWrapper)object).endTrack(n13);
                return false;
            }
            object = this.mediaClock;
            n10 = this.getTrackType();
            DecoderInputBuffer decoderInputBuffer3 = this.buffer;
            long l10 = decoderInputBuffer3.timeUs;
            ((TransformerMediaClock)object).updateTimeForTrackType(n10, l10);
            ((ByteBuffer)Assertions.checkNotNull(this.buffer.data)).flip();
            object = this.sampleTransformer;
            if (object != null) {
                decoderInputBuffer2 = this.buffer;
                object.transformSample(decoderInputBuffer2);
            }
            return bl4;
        }
        object = new IllegalStateException("Format changes are not supported.");
        throw object;
    }

    public String getName() {
        return TAG;
    }

    public boolean isEnded() {
        return this.isInputStreamEnded;
    }

    public void render(long l10, long l11) {
        boolean bl2 = this.isRendererStarted;
        if (bl2 && !(bl2 = this.isEnded())) {
            Object object;
            bl2 = this.formatRead;
            boolean bl3 = true;
            if (!bl2) {
                int n10;
                Object object2;
                object = this.getFormatHolder();
                int n11 = this.readSource((FormatHolder)object, (DecoderInputBuffer)(object2 = this.buffer), bl3);
                if (n11 != (n10 = -5)) {
                    return;
                }
                object = (Format)Assertions.checkNotNull(((FormatHolder)object).format);
                this.formatRead = bl3;
                object2 = this.transformation;
                n11 = (int)(((Transformation)object2).flattenForSlowMotion ? 1 : 0);
                if (n11 != 0) {
                    this.sampleTransformer = object2 = new SefSlowMotionVideoSampleTransformer((Format)object);
                }
                object2 = this.muxerWrapper;
                ((MuxerWrapper)object2).addTrackFormat((Format)object);
            }
            do {
                if (!(bl2 = this.isBufferPending) && !(bl2 = this.readAndTransformBuffer())) {
                    return;
                }
                MuxerWrapper muxerWrapper = this.muxerWrapper;
                int n12 = this.getTrackType();
                object = this.buffer;
                ByteBuffer byteBuffer = ((DecoderInputBuffer)object).data;
                boolean bl4 = ((Buffer)object).isKeyFrame();
                object = this.buffer;
                long l12 = ((DecoderInputBuffer)object).timeUs;
                this.isBufferPending = bl2 = muxerWrapper.writeSample(n12, byteBuffer, bl4, l12) ^ bl3;
            } while (!bl2);
        }
    }
}

