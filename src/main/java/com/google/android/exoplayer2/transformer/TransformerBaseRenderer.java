/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.transformer.MuxerWrapper;
import com.google.android.exoplayer2.transformer.Transformation;
import com.google.android.exoplayer2.transformer.TransformerMediaClock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;

public abstract class TransformerBaseRenderer
extends BaseRenderer {
    public boolean isRendererStarted;
    public final TransformerMediaClock mediaClock;
    public final MuxerWrapper muxerWrapper;
    public final Transformation transformation;

    public TransformerBaseRenderer(int n10, MuxerWrapper muxerWrapper, TransformerMediaClock transformerMediaClock, Transformation transformation) {
        super(n10);
        this.muxerWrapper = muxerWrapper;
        this.mediaClock = transformerMediaClock;
        this.transformation = transformation;
    }

    public final MediaClock getMediaClock() {
        return this.mediaClock;
    }

    public final boolean isReady() {
        return this.isSourceReady();
    }

    public final void onEnabled(boolean bl2, boolean bl3) {
        this.muxerWrapper.registerTrack();
        TransformerMediaClock transformerMediaClock = this.mediaClock;
        int n10 = this.getTrackType();
        transformerMediaClock.updateTimeForTrackType(n10, 0L);
    }

    public final void onStarted() {
        this.isRendererStarted = true;
    }

    public final void onStopped() {
        this.isRendererStarted = false;
    }

    public final int supportsFormat(Format object) {
        int n10;
        object = ((Format)object).sampleMimeType;
        int n11 = MimeTypes.getTrackType((String)object);
        if (n11 != (n10 = this.getTrackType())) {
            return RendererCapabilities.create(0);
        }
        MuxerWrapper muxerWrapper = this.muxerWrapper;
        boolean bl2 = muxerWrapper.supportsSampleMimeType((String)object);
        if (bl2) {
            return RendererCapabilities.create(4);
        }
        return RendererCapabilities.create(1);
    }
}

