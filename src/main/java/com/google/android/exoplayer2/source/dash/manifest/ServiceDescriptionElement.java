/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

public final class ServiceDescriptionElement {
    public final long maxOffsetMs;
    public final float maxPlaybackSpeed;
    public final long minOffsetMs;
    public final float minPlaybackSpeed;
    public final long targetOffsetMs;

    public ServiceDescriptionElement(long l10, long l11, long l12, float f10, float f11) {
        this.targetOffsetMs = l10;
        this.minOffsetMs = l11;
        this.maxOffsetMs = l12;
        this.minPlaybackSpeed = f10;
        this.maxPlaybackSpeed = f11;
    }
}

