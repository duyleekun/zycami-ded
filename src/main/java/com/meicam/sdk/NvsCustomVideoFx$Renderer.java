/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsCustomVideoFx$RenderContext;

public interface NvsCustomVideoFx$Renderer {
    public void onCleanup();

    public void onInit();

    public void onPreloadResources();

    public void onRender(NvsCustomVideoFx$RenderContext var1);
}

