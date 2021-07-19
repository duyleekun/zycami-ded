/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video;

public interface VideoListener {
    default public void onRenderedFirstFrame() {
    }

    default public void onSurfaceSizeChanged(int n10, int n11) {
    }

    default public void onVideoSizeChanged(int n10, int n11, int n12, float f10) {
    }
}

