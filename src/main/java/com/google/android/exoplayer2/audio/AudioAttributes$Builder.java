/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioAttributes;

public final class AudioAttributes$Builder {
    private int allowedCapturePolicy;
    private int contentType = 0;
    private int flags = 0;
    private int usage;

    public AudioAttributes$Builder() {
        int n10;
        this.usage = n10 = 1;
        this.allowedCapturePolicy = n10;
    }

    public AudioAttributes build() {
        int n10 = this.contentType;
        int n11 = this.flags;
        int n12 = this.usage;
        int n13 = this.allowedCapturePolicy;
        AudioAttributes audioAttributes = new AudioAttributes(n10, n11, n12, n13, null);
        return audioAttributes;
    }

    public AudioAttributes$Builder setAllowedCapturePolicy(int n10) {
        this.allowedCapturePolicy = n10;
        return this;
    }

    public AudioAttributes$Builder setContentType(int n10) {
        this.contentType = n10;
        return this;
    }

    public AudioAttributes$Builder setFlags(int n10) {
        this.flags = n10;
        return this;
    }

    public AudioAttributes$Builder setUsage(int n10) {
        this.usage = n10;
        return this;
    }
}

