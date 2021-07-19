/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAudioSampleBuffers;
import com.meicam.sdk.NvsCustomAudioFx$RenderContext;

public interface NvsCustomAudioFx$Renderer {
    public void onCleanup();

    public NvsAudioSampleBuffers onFlush();

    public void onInit();

    public NvsAudioSampleBuffers onRender(NvsCustomAudioFx$RenderContext var1);

    public int querySupportedInputAudioSampleFormat();
}

