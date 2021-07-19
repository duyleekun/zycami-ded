/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.util.Util;

public final class EventSampleStream
implements SampleStream {
    private int currentIndex;
    private final EventMessageEncoder eventMessageEncoder;
    private EventStream eventStream;
    private boolean eventStreamAppendable;
    private long[] eventTimesUs;
    private boolean isFormatSentDownstream;
    private long pendingSeekPositionUs;
    private final Format upstreamFormat;

    public EventSampleStream(EventStream eventStream, Format object, boolean bl2) {
        this.upstreamFormat = object;
        this.eventStream = eventStream;
        this.eventMessageEncoder = object = new EventMessageEncoder();
        this.pendingSeekPositionUs = -9223372036854775807L;
        object = eventStream.presentationTimesUs;
        this.eventTimesUs = (long[])object;
        this.updateEventStream(eventStream, bl2);
    }

    public String eventStreamId() {
        return this.eventStream.id();
    }

    public boolean isReady() {
        return true;
    }

    public void maybeThrowError() {
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer object, boolean n10) {
        int n11 = 1;
        if (n10 == 0 && (n10 = this.isFormatSentDownstream) != 0) {
            long l10;
            int n12 = this.currentIndex;
            Object object2 = this.eventTimesUs;
            n10 = ((long[])object2).length;
            int n13 = -4;
            if (n12 == n10) {
                n12 = (int)(this.eventStreamAppendable ? 1 : 0);
                if (n12 == 0) {
                    ((Buffer)object).setFlags(4);
                    return n13;
                }
                return -3;
            }
            this.currentIndex = n10 = n12 + 1;
            object2 = this.eventMessageEncoder;
            EventMessage eventMessage = this.eventStream.events[n12];
            object2 = object2.encode(eventMessage);
            int n14 = ((long[])object2).length;
            ((DecoderInputBuffer)object).ensureSpaceForWrite(n14);
            ((DecoderInputBuffer)object).data.put((byte[])object2);
            ((DecoderInputBuffer)object).timeUs = l10 = this.eventTimesUs[n12];
            ((Buffer)object).setFlags(n11);
            return n13;
        }
        formatHolder.format = object = this.upstreamFormat;
        this.isFormatSentDownstream = n11;
        return -5;
    }

    public void seekToUs(long l10) {
        long[] lArray;
        int n10;
        long[] lArray2 = this.eventTimesUs;
        boolean bl2 = true;
        this.currentIndex = n10 = Util.binarySearchCeil(lArray2, l10, bl2, false);
        int n11 = this.eventStreamAppendable;
        if (n11 == 0 || n10 != (n11 = (lArray = this.eventTimesUs).length)) {
            bl2 = false;
        }
        if (!bl2) {
            l10 = -9223372036854775807L;
        }
        this.pendingSeekPositionUs = l10;
    }

    public int skipData(long l10) {
        int n10 = this.currentIndex;
        int n11 = Util.binarySearchCeil(this.eventTimesUs, l10, true, false);
        n11 = Math.max(n10, n11);
        int n12 = this.currentIndex;
        n12 = n11 - n12;
        this.currentIndex = n11;
        return n12;
    }

    public void updateEventStream(EventStream object, boolean object2) {
        long l10;
        int n10 = this.currentIndex;
        long l11 = -9223372036854775807L;
        if (n10 == 0) {
            l10 = l11;
        } else {
            long[] lArray = this.eventTimesUs;
            l10 = lArray[n10 += -1];
        }
        this.eventStreamAppendable = object2;
        this.eventStream = object;
        object = ((EventStream)object).presentationTimesUs;
        this.eventTimesUs = (long[])object;
        long l12 = this.pendingSeekPositionUs;
        object2 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (object2) {
            this.seekToUs(l12);
        } else {
            object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object2) {
                int n11;
                object2 = false;
                this.currentIndex = n11 = Util.binarySearchCeil((long[])object, l10, false, false);
            }
        }
    }
}

