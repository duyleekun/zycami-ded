/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

public interface VideoRendererEventListener {
    default public void onDroppedFrames(int n10, long l10) {
    }

    default public void onRenderedFirstFrame(Surface surface) {
    }

    default public void onVideoDecoderInitialized(String string2, long l10, long l11) {
    }

    default public void onVideoDecoderReleased(String string2) {
    }

    default public void onVideoDisabled(DecoderCounters decoderCounters) {
    }

    default public void onVideoEnabled(DecoderCounters decoderCounters) {
    }

    default public void onVideoFrameProcessingOffset(long l10, int n10) {
    }

    default public void onVideoInputFormatChanged(Format format) {
    }

    default public void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.onVideoInputFormatChanged(format);
    }

    default public void onVideoSizeChanged(int n10, int n11, int n12, float f10) {
    }
}

