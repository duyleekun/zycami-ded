/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;

public abstract class BaseRenderer
implements Renderer,
RendererCapabilities {
    private RendererConfiguration configuration;
    private final FormatHolder formatHolder;
    private int index;
    private long lastResetPositionUs;
    private long readingPositionUs;
    private int state;
    private SampleStream stream;
    private Format[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private boolean throwRendererExceptionIsExecuting;
    private final int trackType;

    public BaseRenderer(int n10) {
        FormatHolder formatHolder;
        this.trackType = n10;
        this.formatHolder = formatHolder = new FormatHolder();
        this.readingPositionUs = Long.MIN_VALUE;
    }

    public final ExoPlaybackException createRendererException(Throwable throwable, Format format) {
        return this.createRendererException(throwable, format, false);
    }

    public final ExoPlaybackException createRendererException(Throwable throwable, Format format, boolean bl2) {
        int n10;
        block6: {
            boolean bl3;
            if (format != null && !(bl3 = this.throwRendererExceptionIsExecuting)) {
                this.throwRendererExceptionIsExecuting = true;
                bl3 = false;
                try {
                    n10 = this.supportsFormat(format);
                    n10 = RendererCapabilities.getFormatSupport(n10);
                    break block6;
                }
                catch (ExoPlaybackException exoPlaybackException) {
                    this.throwRendererExceptionIsExecuting = false;
                }
                finally {
                    this.throwRendererExceptionIsExecuting = false;
                }
            }
            n10 = 4;
        }
        String string2 = this.getName();
        int n11 = this.getIndex();
        return ExoPlaybackException.createForRenderer(throwable, string2, n11, format, n10, bl2);
    }

    public final void disable() {
        int n10 = this.state;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        Assertions.checkState(n11 != 0);
        this.formatHolder.clear();
        this.state = 0;
        this.stream = null;
        this.streamFormats = null;
        this.streamIsFinal = false;
        this.onDisabled();
    }

    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArray, SampleStream sampleStream, long l10, boolean bl2, boolean bl3, long l11, long l12) {
        BaseRenderer baseRenderer = this;
        long l13 = l10;
        boolean bl4 = bl2;
        int n10 = this.state;
        int n11 = 1;
        n10 = n10 == 0 ? n11 : 0;
        Assertions.checkState(n10 != 0);
        baseRenderer.configuration = rendererConfiguration;
        baseRenderer.state = n11;
        baseRenderer.lastResetPositionUs = l13;
        n10 = (int)(bl3 ? 1 : 0);
        this.onEnabled(bl4, bl3);
        this.replaceStream(formatArray, sampleStream, l11, l12);
        this.onPositionReset(l13, bl4);
    }

    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public final RendererConfiguration getConfiguration() {
        return (RendererConfiguration)Assertions.checkNotNull(this.configuration);
    }

    public final FormatHolder getFormatHolder() {
        this.formatHolder.clear();
        return this.formatHolder;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getLastResetPositionUs() {
        return this.lastResetPositionUs;
    }

    public MediaClock getMediaClock() {
        return null;
    }

    public final long getReadingPositionUs() {
        return this.readingPositionUs;
    }

    public final int getState() {
        return this.state;
    }

    public final SampleStream getStream() {
        return this.stream;
    }

    public final Format[] getStreamFormats() {
        return (Format[])Assertions.checkNotNull(this.streamFormats);
    }

    public final int getTrackType() {
        return this.trackType;
    }

    public void handleMessage(int n10, Object object) {
    }

    public final boolean hasReadStreamToEnd() {
        long l10 = this.readingPositionUs;
        long l11 = Long.MIN_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public final boolean isSourceReady() {
        boolean bl2 = this.hasReadStreamToEnd();
        if (bl2) {
            bl2 = this.streamIsFinal;
        } else {
            SampleStream sampleStream = (SampleStream)Assertions.checkNotNull(this.stream);
            bl2 = sampleStream.isReady();
        }
        return bl2;
    }

    public final void maybeThrowStreamError() {
        ((SampleStream)Assertions.checkNotNull(this.stream)).maybeThrowError();
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean bl2, boolean bl3) {
    }

    public void onPositionReset(long l10, boolean bl2) {
    }

    public void onReset() {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public void onStreamChanged(Format[] formatArray, long l10, long l11) {
    }

    public final int readSource(FormatHolder formatHolder, DecoderInputBuffer object, boolean n10) {
        int n11;
        Object object2 = (SampleStream)Assertions.checkNotNull(this.stream);
        n10 = object2.readData(formatHolder, (DecoderInputBuffer)object, n10 != 0);
        if (n10 == (n11 = -4)) {
            long l10;
            boolean bl2 = ((Buffer)object).isEndOfStream();
            if (bl2) {
                long l11;
                this.readingPositionUs = l11 = Long.MIN_VALUE;
                bl2 = this.streamIsFinal;
                if (!bl2) {
                    n11 = -3;
                }
                return n11;
            }
            long l12 = ((DecoderInputBuffer)object).timeUs;
            long l13 = this.streamOffsetUs;
            ((DecoderInputBuffer)object).timeUs = l12 += l13;
            this.readingPositionUs = l10 = Math.max(this.readingPositionUs, l12);
        } else {
            int n12 = -5;
            if (n10 == n12) {
                object = (Format)Assertions.checkNotNull(formatHolder.format);
                long l14 = ((Format)object).subsampleOffsetUs;
                long l15 = Long.MAX_VALUE;
                long l16 = l14 - l15;
                n11 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                if (n11 != 0) {
                    object2 = ((Format)object).buildUpon();
                    long l17 = ((Format)object).subsampleOffsetUs;
                    long l18 = this.streamOffsetUs;
                    formatHolder.format = object = ((Format$Builder)object2).setSubsampleOffsetUs(l17 += l18).build();
                }
            }
        }
        return n10;
    }

    public final void replaceStream(Format[] formatArray, SampleStream sampleStream, long l10, long l11) {
        Assertions.checkState(this.streamIsFinal ^ true);
        this.stream = sampleStream;
        this.readingPositionUs = l11;
        this.streamFormats = formatArray;
        this.streamOffsetUs = l11;
        this.onStreamChanged(formatArray, l10, l11);
    }

    public final void reset() {
        int n10 = this.state;
        n10 = n10 == 0 ? 1 : 0;
        Assertions.checkState(n10 != 0);
        this.formatHolder.clear();
        this.onReset();
    }

    public final void resetPosition(long l10) {
        this.streamIsFinal = false;
        this.lastResetPositionUs = l10;
        this.readingPositionUs = l10;
        this.onPositionReset(l10, false);
    }

    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    public final void setIndex(int n10) {
        this.index = n10;
    }

    public int skipSource(long l10) {
        SampleStream sampleStream = (SampleStream)Assertions.checkNotNull(this.stream);
        long l11 = this.streamOffsetUs;
        return sampleStream.skipData(l10 -= l11);
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

    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }
}

