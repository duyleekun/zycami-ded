/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;

public final class AudioSink$ConfigurationException
extends Exception {
    public final Format format;

    public AudioSink$ConfigurationException(String string2, Format format) {
        super(string2);
        this.format = format;
    }

    public AudioSink$ConfigurationException(Throwable throwable, Format format) {
        super(throwable);
        this.format = format;
    }
}

