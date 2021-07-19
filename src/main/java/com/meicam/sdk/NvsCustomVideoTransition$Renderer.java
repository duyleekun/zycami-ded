/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsCustomVideoTransition$RenderContext;

public interface NvsCustomVideoTransition$Renderer {
    public void onCleanup();

    public void onInit();

    public void onPreloadResources();

    public void onRender(NvsCustomVideoTransition$RenderContext var1);
}

