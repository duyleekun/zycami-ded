/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.BaseAudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class FloatResamplingAudioProcessor
extends BaseAudioProcessor {
    private static final int FLOAT_NAN_AS_INT = 0;
    private static final double PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR = 4.656612875245797E-10;

    static {
        FLOAT_NAN_AS_INT = Float.floatToIntBits(0.0f / 0.0f);
    }

    private static void writePcm32BitFloat(int n10, ByteBuffer byteBuffer) {
        int n11;
        double d10 = n10;
        double d11 = 4.656612875245797E-10;
        float f10 = (float)(d10 *= d11);
        n10 = Float.floatToIntBits(f10);
        if (n10 == (n11 = FLOAT_NAN_AS_INT)) {
            f10 = 0.0f;
            n10 = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(n10);
    }

    public AudioProcessor$AudioFormat onConfigure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        int n10 = audioProcessor$AudioFormat.encoding;
        int n11 = Util.isEncodingHighResolutionPcm(n10);
        if (n11 != 0) {
            AudioProcessor$AudioFormat audioProcessor$AudioFormat2;
            n11 = 4;
            if (n10 != n11) {
                int n12 = audioProcessor$AudioFormat.sampleRate;
                int n13 = audioProcessor$AudioFormat.channelCount;
                audioProcessor$AudioFormat2 = new AudioProcessor$AudioFormat(n12, n13, n11);
            } else {
                audioProcessor$AudioFormat2 = AudioProcessor$AudioFormat.NOT_SET;
            }
            return audioProcessor$AudioFormat2;
        }
        AudioProcessor$UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException = new AudioProcessor$UnhandledAudioFormatException(audioProcessor$AudioFormat);
        throw audioProcessor$UnhandledAudioFormatException;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void queueInput(ByteBuffer object) {
        ByteBuffer byteBuffer;
        int n10;
        int n11 = ((Buffer)object).limit();
        int n12 = n11 - n10;
        AudioProcessor$AudioFormat audioProcessor$AudioFormat = this.inputAudioFormat;
        int n13 = audioProcessor$AudioFormat.encoding;
        int n14 = 0x20000000;
        if (n13 != n14) {
            n14 = 0x30000000;
            if (n13 != n14) {
                object = new IllegalStateException();
                throw object;
            }
            byteBuffer = this.replaceOutputBuffer(n12);
            for (n10 = ((Buffer)object).position(); n10 < n11; n10 += 4) {
                n13 = ((ByteBuffer)object).get(n10) & 0xFF;
                n14 = n10 + 1;
                n14 = (((ByteBuffer)object).get(n14) & 0xFF) << 8;
                n13 |= n14;
                n14 = n10 + 2;
                n14 = (((ByteBuffer)object).get(n14) & 0xFF) << 16;
                n13 |= n14;
                n14 = n10 + 3;
                n14 = (((ByteBuffer)object).get(n14) & 0xFF) << 24;
                FloatResamplingAudioProcessor.writePcm32BitFloat(n13 |= n14, byteBuffer);
            }
        } else {
            n12 = n12 / 3 * 4;
            byteBuffer = this.replaceOutputBuffer(n12);
            while (n10 < n11) {
                n13 = (((ByteBuffer)object).get(n10) & 0xFF) << 8;
                n14 = n10 + 1;
                n14 = (((ByteBuffer)object).get(n14) & 0xFF) << 16;
                n13 |= n14;
                n14 = n10 + 2;
                n14 = (((ByteBuffer)object).get(n14) & 0xFF) << 24;
                FloatResamplingAudioProcessor.writePcm32BitFloat(n13 |= n14, byteBuffer);
                n10 += 3;
            }
        }
        n10 = ((Buffer)object).limit();
        ((ByteBuffer)object).position(n10);
        byteBuffer.flip();
    }
}

