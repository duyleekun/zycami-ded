/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SingleSampleMediaPeriod;
import com.google.android.exoplayer2.source.SingleSampleMediaPeriod$1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

public final class SingleSampleMediaPeriod$SampleStreamImpl
implements SampleStream {
    private static final int STREAM_STATE_END_OF_STREAM = 2;
    private static final int STREAM_STATE_SEND_FORMAT = 0;
    private static final int STREAM_STATE_SEND_SAMPLE = 1;
    private boolean notifiedDownstreamFormat;
    private int streamState;
    public final /* synthetic */ SingleSampleMediaPeriod this$0;

    private SingleSampleMediaPeriod$SampleStreamImpl(SingleSampleMediaPeriod singleSampleMediaPeriod) {
        this.this$0 = singleSampleMediaPeriod;
    }

    public /* synthetic */ SingleSampleMediaPeriod$SampleStreamImpl(SingleSampleMediaPeriod singleSampleMediaPeriod, SingleSampleMediaPeriod$1 singleSampleMediaPeriod$1) {
        this(singleSampleMediaPeriod);
    }

    private void maybeNotifyDownstreamFormat() {
        boolean bl2 = this.notifiedDownstreamFormat;
        if (!bl2) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = SingleSampleMediaPeriod.access$300(this.this$0);
            int n10 = MimeTypes.getTrackType(this.this$0.format.sampleMimeType);
            SingleSampleMediaPeriod singleSampleMediaPeriod = this.this$0;
            Format format = singleSampleMediaPeriod.format;
            long l10 = 0L;
            mediaSourceEventListener$EventDispatcher.downstreamFormatChanged(n10, format, 0, null, l10);
            this.notifiedDownstreamFormat = bl2 = true;
        }
    }

    public boolean isReady() {
        return this.this$0.loadingFinished;
    }

    public void maybeThrowError() {
        Object object = this.this$0;
        boolean bl2 = ((SingleSampleMediaPeriod)object).treatLoadErrorsAsEndOfStream;
        if (!bl2) {
            object = ((SingleSampleMediaPeriod)object).loader;
            ((Loader)object).maybeThrowError();
        }
    }

    public int readData(FormatHolder object, DecoderInputBuffer object2, boolean bl2) {
        this.maybeNotifyDownstreamFormat();
        int n10 = this.streamState;
        int n11 = 4;
        int n12 = 2;
        int n13 = -4;
        if (n10 == n12) {
            ((Buffer)object2).addFlag(n11);
            return n13;
        }
        int n14 = 1;
        if (!bl2 && n10 != 0) {
            object = this.this$0;
            bl2 = ((SingleSampleMediaPeriod)object).loadingFinished;
            if (bl2) {
                object = ((SingleSampleMediaPeriod)object).sampleData;
                if (object != null) {
                    long l10;
                    ((Buffer)object2).addFlag(n14);
                    ((DecoderInputBuffer)object2).timeUs = l10 = 0L;
                    boolean n15 = ((DecoderInputBuffer)object2).isFlagsOnly();
                    if (n15) {
                        return n13;
                    }
                    int n16 = this.this$0.sampleSize;
                    ((DecoderInputBuffer)object2).ensureSpaceForWrite(n16);
                    object = ((DecoderInputBuffer)object2).data;
                    object2 = this.this$0;
                    byte[] byArray = ((SingleSampleMediaPeriod)object2).sampleData;
                    n10 = 0;
                    int n17 = ((SingleSampleMediaPeriod)object2).sampleSize;
                    ((ByteBuffer)object).put(byArray, 0, n17);
                } else {
                    ((Buffer)object2).addFlag(n11);
                }
                this.streamState = n12;
                return n13;
            }
            return -3;
        }
        ((FormatHolder)object).format = object2 = this.this$0.format;
        this.streamState = n14;
        return -5;
    }

    public void reset() {
        int n10 = this.streamState;
        int n11 = 2;
        if (n10 == n11) {
            this.streamState = n10 = 1;
        }
    }

    public int skipData(long l10) {
        int n10;
        this.maybeNotifyDownstreamFormat();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0 && (l12 = (long)this.streamState) != (n10 = 2)) {
            this.streamState = n10;
            return 1;
        }
        return 0;
    }
}

