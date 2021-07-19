/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

public final class Transformation {
    public final boolean flattenForSlowMotion;
    public final String outputMimeType;
    public final boolean removeAudio;
    public final boolean removeVideo;

    public Transformation(boolean bl2, boolean bl3, boolean bl4, String string2) {
        this.removeAudio = bl2;
        this.removeVideo = bl3;
        this.flattenForSlowMotion = bl4;
        this.outputMimeType = string2;
    }
}

