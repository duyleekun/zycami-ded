/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import java.nio.ByteBuffer;

public class NvsAudioSampleBuffers {
    public static final int AUDIO_SAMPLE_FROMAT_DOUBLE = 5;
    public static final int AUDIO_SAMPLE_FROMAT_DOUBLE_PLANAR = 10;
    public static final int AUDIO_SAMPLE_FROMAT_SIGNED_16 = 2;
    public static final int AUDIO_SAMPLE_FROMAT_SIGNED_16_PLANAR = 7;
    public static final int AUDIO_SAMPLE_FROMAT_SIGNED_32 = 3;
    public static final int AUDIO_SAMPLE_FROMAT_SIGNED_32_PLANAR = 8;
    public static final int AUDIO_SAMPLE_FROMAT_SINGLE_FLOAT = 4;
    public static final int AUDIO_SAMPLE_FROMAT_SINGLE_FLOAT_PLANAR = 9;
    public static final int AUDIO_SAMPLE_FROMAT_UNSIGNED_8 = 1;
    public static final int AUDIO_SAMPLE_FROMAT_UNSIGNED_8_PLANAR = 6;
    public int actualSampleCount;
    public ByteBuffer audioBuffer;
    public int channelCount;
    public int sampleRate;
    public int sampleformat;
    public long timeStamp;
}

