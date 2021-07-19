/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;

public final class AudioProcessor$UnhandledAudioFormatException
extends Exception {
    public AudioProcessor$UnhandledAudioFormatException(AudioProcessor$AudioFormat object) {
        object = String.valueOf(object);
        int n10 = String.valueOf(object).length() + 18;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Unhandled format: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        super((String)object);
    }
}

