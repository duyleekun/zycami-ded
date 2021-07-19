/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioFormat
 */
package com.google.mediapipe.components;

import android.media.AudioFormat;
import java.nio.ByteBuffer;

public interface AudioDataConsumer {
    public void onNewAudioData(ByteBuffer var1, long var2, AudioFormat var4);
}

