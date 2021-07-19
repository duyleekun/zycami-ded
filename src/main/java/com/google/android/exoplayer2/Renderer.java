/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlayerMessage$Target;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;

public interface Renderer
extends PlayerMessage$Target {
    public static final int MSG_CUSTOM_BASE = 10000;
    public static final int MSG_SET_AUDIO_ATTRIBUTES = 3;
    public static final int MSG_SET_AUDIO_SESSION_ID = 102;
    public static final int MSG_SET_AUX_EFFECT_INFO = 5;
    public static final int MSG_SET_CAMERA_MOTION_LISTENER = 7;
    public static final int MSG_SET_SCALING_MODE = 4;
    public static final int MSG_SET_SKIP_SILENCE_ENABLED = 101;
    public static final int MSG_SET_SURFACE = 1;
    public static final int MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER = 8;
    public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 6;
    public static final int MSG_SET_VOLUME = 2;
    public static final int MSG_SET_WAKEUP_LISTENER = 103;
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_STARTED = 2;
    public static final int VIDEO_SCALING_MODE_DEFAULT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;

    public void disable();

    public void enable(RendererConfiguration var1, Format[] var2, SampleStream var3, long var4, boolean var6, boolean var7, long var8, long var10);

    public RendererCapabilities getCapabilities();

    public MediaClock getMediaClock();

    public String getName();

    public long getReadingPositionUs();

    public int getState();

    public SampleStream getStream();

    public int getTrackType();

    public boolean hasReadStreamToEnd();

    public boolean isCurrentStreamFinal();

    public boolean isEnded();

    public boolean isReady();

    public void maybeThrowStreamError();

    public void render(long var1, long var3);

    public void replaceStream(Format[] var1, SampleStream var2, long var3, long var5);

    public void reset();

    public void resetPosition(long var1);

    public void setCurrentStreamFinal();

    public void setIndex(int var1);

    default public void setPlaybackSpeed(float f10, float f11) {
    }

    public void start();

    public void stop();
}

