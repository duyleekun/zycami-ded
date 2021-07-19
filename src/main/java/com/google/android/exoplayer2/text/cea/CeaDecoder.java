/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer$Owner;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder$CeaInputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder$CeaOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.n0.b.b;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public abstract class CeaDecoder
implements SubtitleDecoder {
    private static final int NUM_INPUT_BUFFERS = 10;
    private static final int NUM_OUTPUT_BUFFERS = 2;
    private final ArrayDeque availableInputBuffers;
    private final ArrayDeque availableOutputBuffers;
    private CeaDecoder$CeaInputBuffer dequeuedInputBuffer;
    private long playbackPositionUs;
    private long queuedInputBufferCount;
    private final PriorityQueue queuedInputBuffers;

    public CeaDecoder() {
        Object object;
        Object object2;
        int n10;
        int n11;
        AbstractCollection abstractCollection;
        this.availableInputBuffers = abstractCollection = new AbstractCollection();
        int n12 = 0;
        abstractCollection = null;
        ArrayDeque arrayDeque = null;
        for (n11 = 0; n11 < (n10 = 10); ++n11) {
            object2 = this.availableInputBuffers;
            object = new CeaDecoder$CeaInputBuffer(null);
            ((ArrayDeque)object2).add(object);
        }
        this.availableOutputBuffers = arrayDeque = new ArrayDeque();
        while (n12 < (n11 = 2)) {
            arrayDeque = this.availableOutputBuffers;
            object = new b(this);
            object2 = new CeaDecoder$CeaOutputBuffer((OutputBuffer$Owner)object);
            arrayDeque.add(object2);
            ++n12;
        }
        this.queuedInputBuffers = abstractCollection;
    }

    private void releaseInputBuffer(CeaDecoder$CeaInputBuffer ceaDecoder$CeaInputBuffer) {
        ceaDecoder$CeaInputBuffer.clear();
        this.availableInputBuffers.add(ceaDecoder$CeaInputBuffer);
    }

    public abstract Subtitle createSubtitle();

    public abstract void decode(SubtitleInputBuffer var1);

    public SubtitleInputBuffer dequeueInputBuffer() {
        boolean bl2;
        Object object = this.dequeuedInputBuffer;
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        object = this.availableInputBuffers;
        bl2 = ((ArrayDeque)object).isEmpty();
        if (bl2) {
            return null;
        }
        this.dequeuedInputBuffer = object = (CeaDecoder$CeaInputBuffer)this.availableInputBuffers.pollFirst();
        return object;
    }

    public SubtitleOutputBuffer dequeueOutputBuffer() {
        Object object = this.availableOutputBuffers;
        Object object2 = ((ArrayDeque)object).isEmpty();
        SubtitleOutputBuffer subtitleOutputBuffer = null;
        if (object2 != 0) {
            return null;
        }
        while ((object2 = ((AbstractCollection)(object = this.queuedInputBuffers)).isEmpty()) == 0) {
            object = (CeaDecoder$CeaInputBuffer)Util.castNonNull((CeaDecoder$CeaInputBuffer)this.queuedInputBuffers.peek());
            long l10 = ((DecoderInputBuffer)object).timeUs;
            long l11 = this.playbackPositionUs;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) break;
            object = (CeaDecoder$CeaInputBuffer)Util.castNonNull((CeaDecoder$CeaInputBuffer)this.queuedInputBuffers.poll());
            boolean bl2 = ((Buffer)object).isEndOfStream();
            if (bl2) {
                subtitleOutputBuffer = (SubtitleOutputBuffer)Util.castNonNull((SubtitleOutputBuffer)this.availableOutputBuffers.pollFirst());
                subtitleOutputBuffer.addFlag(4);
                this.releaseInputBuffer((CeaDecoder$CeaInputBuffer)object);
                return subtitleOutputBuffer;
            }
            this.decode((SubtitleInputBuffer)object);
            bl2 = this.isNewSubtitleDataAvailable();
            if (bl2) {
                Subtitle subtitle = this.createSubtitle();
                subtitleOutputBuffer = (SubtitleOutputBuffer)Util.castNonNull((SubtitleOutputBuffer)this.availableOutputBuffers.pollFirst());
                l11 = ((DecoderInputBuffer)object).timeUs;
                subtitleOutputBuffer.setContent(l11, subtitle, Long.MAX_VALUE);
                this.releaseInputBuffer((CeaDecoder$CeaInputBuffer)object);
                return subtitleOutputBuffer;
            }
            this.releaseInputBuffer((CeaDecoder$CeaInputBuffer)object);
        }
        return null;
    }

    public void flush() {
        Object object;
        boolean bl2;
        long l10;
        this.queuedInputBufferCount = l10 = 0L;
        this.playbackPositionUs = l10;
        while (!(bl2 = ((AbstractCollection)(object = this.queuedInputBuffers)).isEmpty())) {
            object = (CeaDecoder$CeaInputBuffer)Util.castNonNull((CeaDecoder$CeaInputBuffer)this.queuedInputBuffers.poll());
            this.releaseInputBuffer((CeaDecoder$CeaInputBuffer)object);
        }
        object = this.dequeuedInputBuffer;
        if (object != null) {
            this.releaseInputBuffer((CeaDecoder$CeaInputBuffer)object);
            bl2 = false;
            object = null;
            this.dequeuedInputBuffer = null;
        }
    }

    public final SubtitleOutputBuffer getAvailableOutputBuffer() {
        return (SubtitleOutputBuffer)this.availableOutputBuffers.pollFirst();
    }

    public abstract String getName();

    public final long getPositionUs() {
        return this.playbackPositionUs;
    }

    public abstract boolean isNewSubtitleDataAvailable();

    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        boolean bl2;
        Object object = this.dequeuedInputBuffer;
        if (subtitleInputBuffer == object) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkArgument(bl2);
        subtitleInputBuffer = (CeaDecoder$CeaInputBuffer)subtitleInputBuffer;
        bl2 = subtitleInputBuffer.isDecodeOnly();
        if (bl2) {
            this.releaseInputBuffer((CeaDecoder$CeaInputBuffer)subtitleInputBuffer);
        } else {
            long l10;
            long l11 = this.queuedInputBufferCount;
            this.queuedInputBufferCount = l10 = 1L + l11;
            CeaDecoder$CeaInputBuffer.access$102((CeaDecoder$CeaInputBuffer)subtitleInputBuffer, l11);
            object = this.queuedInputBuffers;
            ((PriorityQueue)object).add(subtitleInputBuffer);
        }
        this.dequeuedInputBuffer = null;
    }

    public void release() {
    }

    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer);
    }

    public void setPositionUs(long l10) {
        this.playbackPositionUs = l10;
    }
}

