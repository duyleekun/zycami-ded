/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;

public final class ClippingMediaPeriod$ClippingSampleStream
implements SampleStream {
    public final SampleStream childStream;
    private boolean sentEos;
    public final /* synthetic */ ClippingMediaPeriod this$0;

    public ClippingMediaPeriod$ClippingSampleStream(ClippingMediaPeriod clippingMediaPeriod, SampleStream sampleStream) {
        this.this$0 = clippingMediaPeriod;
        this.childStream = sampleStream;
    }

    public void clearSentEos() {
        this.sentEos = false;
    }

    public boolean isReady() {
        Object object = this.this$0;
        boolean bl2 = ((ClippingMediaPeriod)object).isPendingInitialDiscontinuity();
        if (!bl2 && (bl2 = (object = this.childStream).isReady())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void maybeThrowError() {
        this.childStream.maybeThrowError();
    }

    public int readData(FormatHolder object, DecoderInputBuffer object2, boolean n10) {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        Object object3 = this.this$0;
        boolean n11 = ((ClippingMediaPeriod)object3).isPendingInitialDiscontinuity();
        int n12 = -3;
        if (n11) {
            return n12;
        }
        boolean bl2 = this.sentEos;
        int n13 = 4;
        int n14 = -4;
        if (bl2) {
            ((Buffer)object2).setFlags(n13);
            return n14;
        }
        object3 = this.childStream;
        n10 = object3.readData((FormatHolder)object, (DecoderInputBuffer)object2, n10 != 0);
        int n15 = -5;
        long l16 = Long.MIN_VALUE;
        if (n10 == n15) {
            object2 = (Format)Assertions.checkNotNull(((FormatHolder)object).format);
            n10 = ((Format)object2).encoderDelay;
            if (n10 != 0 || (n12 = ((Format)object2).encoderPadding) != 0) {
                long l17;
                long l18;
                ClippingMediaPeriod clippingMediaPeriod = this.this$0;
                long l19 = clippingMediaPeriod.startUs;
                long l20 = 0L;
                n13 = (int)(l19 == l20 ? 0 : (l19 < l20 ? -1 : 1));
                n14 = 0;
                if (n13 != 0) {
                    n10 = 0;
                }
                if ((n12 = (int)((l18 = (l17 = clippingMediaPeriod.endUs) - l16) == 0L ? 0 : (l18 < 0L ? -1 : 1))) == 0) {
                    n14 = ((Format)object2).encoderPadding;
                }
                ((FormatHolder)object).format = object2 = ((Format)object2).buildUpon().setEncoderDelay(n10).setEncoderPadding(n14).build();
            }
            return n15;
        }
        object = this.this$0;
        long l21 = ((ClippingMediaPeriod)object).endUs;
        long l22 = l21 - l16;
        Object object4 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
        if (object4 != false && (n10 == n14 && (l15 = (l14 = (l13 = ((DecoderInputBuffer)object2).timeUs) - l21) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= 0 || n10 == n12 && (l12 = (l11 = (l10 = ((ClippingMediaPeriod)object).getBufferedPositionUs()) - l16) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false && (l12 = (long)((DecoderInputBuffer)object2).waitingForKeys) == false)) {
            ((DecoderInputBuffer)object2).clear();
            ((Buffer)object2).setFlags(n13);
            this.sentEos = true;
            return n14;
        }
        return n10;
    }

    public int skipData(long l10) {
        ClippingMediaPeriod clippingMediaPeriod = this.this$0;
        boolean bl2 = clippingMediaPeriod.isPendingInitialDiscontinuity();
        if (bl2) {
            return -3;
        }
        return this.childStream.skipData(l10);
    }
}

