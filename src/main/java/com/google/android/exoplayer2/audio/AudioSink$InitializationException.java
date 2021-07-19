/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;

public final class AudioSink$InitializationException
extends Exception {
    public final int audioTrackState;
    public final Format format;
    public final boolean isRecoverable;

    public AudioSink$InitializationException(int n10, int n11, int n12, int n13, Format format, boolean bl2, Exception exception) {
        String string2 = bl2 ? " (recoverable)" : "";
        int n14 = string2.length() + 80;
        StringBuilder stringBuilder = new StringBuilder(n14);
        stringBuilder.append("AudioTrack init failed ");
        stringBuilder.append(n10);
        stringBuilder.append(" ");
        stringBuilder.append("Config(");
        stringBuilder.append(n11);
        String string3 = ", ";
        stringBuilder.append(string3);
        stringBuilder.append(n12);
        stringBuilder.append(string3);
        stringBuilder.append(n13);
        stringBuilder.append(")");
        stringBuilder.append(string2);
        string3 = stringBuilder.toString();
        super(string3, exception);
        this.audioTrackState = n10;
        this.isRecoverable = bl2;
        this.format = format;
    }
}

