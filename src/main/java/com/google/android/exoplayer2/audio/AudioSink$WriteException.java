/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;

public final class AudioSink$WriteException
extends Exception {
    public final int errorCode;
    public final Format format;
    public final boolean isRecoverable;

    public AudioSink$WriteException(int n10, Format format, boolean bl2) {
        CharSequence charSequence = new StringBuilder(36);
        charSequence.append("AudioTrack write failed: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.isRecoverable = bl2;
        this.errorCode = n10;
        this.format = format;
    }
}

