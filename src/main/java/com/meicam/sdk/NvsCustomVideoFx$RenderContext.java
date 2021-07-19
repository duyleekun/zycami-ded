/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsCustomVideoFx$RenderHelper;
import com.meicam.sdk.NvsCustomVideoFx$VideoFrame;
import com.meicam.sdk.NvsVideoFrameInfo;
import java.nio.ByteBuffer;

public class NvsCustomVideoFx$RenderContext {
    public long effectEndTime;
    public long effectStartTime;
    public long effectTime;
    public boolean hasBuddyVideoFrame;
    public NvsCustomVideoFx.RenderHelper helper;
    public NvsVideoFrameInfo inputBuddyVideoFrameInfo;
    public ByteBuffer inputBuddyVideoFramebuffer;
    public NvsCustomVideoFx.VideoFrame inputVideoFrame;
    public NvsCustomVideoFx.VideoFrame outputVideoFrame;
}

