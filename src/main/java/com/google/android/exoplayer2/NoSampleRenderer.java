/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;

public abstract class NoSampleRenderer
implements Renderer,
RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    private SampleStream stream;
    private boolean streamIsFinal;

    public final void disable() {
        int n10 = this.state;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        Assertions.checkState(n11 != 0);
        this.state = 0;
        this.stream = null;
        this.streamIsFinal = false;
        this.onDisabled();
    }

    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArray, SampleStream sampleStream, long l10, boolean bl2, boolean bl3, long l11, long l12) {
        NoSampleRenderer noSampleRenderer = this;
        int n10 = this.state;
        int n11 = 1;
        n10 = n10 == 0 ? n11 : 0;
        Assertions.checkState(n10 != 0);
        noSampleRenderer.configuration = rendererConfiguration;
        noSampleRenderer.state = n11;
        this.onEnabled(bl2);
        this.replaceStream(formatArray, sampleStream, l11, l12);
        this.onPositionReset(l10, bl2);
    }

    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    public final int getIndex() {
        return this.index;
    }

    public MediaClock getMediaClock() {
        return null;
    }

    public long getReadingPositionUs() {
        return Long.MIN_VALUE;
    }

    public final int getState() {
        return this.state;
    }

    public final SampleStream getStream() {
        return this.stream;
    }

    public final int getTrackType() {
        return 7;
    }

    public void handleMessage(int n10, Object object) {
    }

    public final boolean hasReadStreamToEnd() {
        return true;
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public boolean isEnded() {
        return true;
    }

    public boolean isReady() {
        return true;
    }

    public final void maybeThrowStreamError() {
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean bl2) {
    }

    public void onPositionReset(long l10, boolean bl2) {
    }

    public void onRendererOffsetChanged(long l10) {
    }

    public void onReset() {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public final void replaceStream(Format[] formatArray, SampleStream sampleStream, long l10, long l11) {
        Assertions.checkState(this.streamIsFinal ^ true);
        this.stream = sampleStream;
        this.onRendererOffsetChanged(l11);
    }

    public final void reset() {
        int n10 = this.state;
        n10 = n10 == 0 ? 1 : 0;
        Assertions.checkState(n10 != 0);
        this.onReset();
    }

    public final void resetPosition(long l10) {
        this.streamIsFinal = false;
        this.onPositionReset(l10, false);
    }

    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    public final void setIndex(int n10) {
        this.index = n10;
    }

    public final void start() {
        int n10 = this.state;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        Assertions.checkState(n11 != 0);
        this.state = 2;
        this.onStarted();
    }

    public final void stop() {
        int n10 = this.state;
        int n11 = 1;
        int n12 = 2;
        n10 = n10 == n12 ? n11 : 0;
        Assertions.checkState(n10 != 0);
        this.state = n11;
        this.onStopped();
    }

    public int supportsFormat(Format format) {
        return RendererCapabilities.create(0);
    }

    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }
}

