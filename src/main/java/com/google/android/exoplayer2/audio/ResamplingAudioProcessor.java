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

public final class ResamplingAudioProcessor
extends BaseAudioProcessor {
    public AudioProcessor$AudioFormat onConfigure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        AudioProcessor$AudioFormat audioProcessor$AudioFormat2;
        int n10 = audioProcessor$AudioFormat.encoding;
        int n11 = 2;
        int n12 = 3;
        if (n10 != n12 && n10 != n11 && n10 != (n12 = 0x10000000) && n10 != (n12 = 0x20000000) && n10 != (n12 = 0x30000000) && n10 != (n12 = 4)) {
            AudioProcessor$UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException = new AudioProcessor$UnhandledAudioFormatException(audioProcessor$AudioFormat);
            throw audioProcessor$UnhandledAudioFormatException;
        }
        if (n10 != n11) {
            n12 = audioProcessor$AudioFormat.sampleRate;
            int n13 = audioProcessor$AudioFormat.channelCount;
            audioProcessor$AudioFormat2 = new AudioProcessor$AudioFormat(n12, n13, n11);
        } else {
            audioProcessor$AudioFormat2 = AudioProcessor$AudioFormat.NOT_SET;
        }
        return audioProcessor$AudioFormat2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void queueInput(ByteBuffer object) {
        ByteBuffer byteBuffer;
        int n10;
        block11: {
            AudioProcessor$AudioFormat audioProcessor$AudioFormat;
            int n11;
            block16: {
                float f10;
                float f11;
                block17: {
                    int n12;
                    int n13;
                    int n14;
                    int n15;
                    int n16;
                    int n17;
                    block14: {
                        block12: {
                            block13: {
                                int n18;
                                block15: {
                                    n10 = ((Buffer)object).position();
                                    n11 = ((Buffer)object).limit();
                                    n17 = n11 - n10;
                                    audioProcessor$AudioFormat = this.inputAudioFormat;
                                    n18 = audioProcessor$AudioFormat.encoding;
                                    n16 = 0x30000000;
                                    f11 = 4.656613E-10f;
                                    n15 = 0x20000000;
                                    f10 = 1.0842022E-19f;
                                    n14 = 0x10000000;
                                    n13 = 4;
                                    n12 = 3;
                                    if (n18 == n12) break block12;
                                    if (n18 == n13) break block13;
                                    if (n18 == n14) break block14;
                                    if (n18 != n15) break block15;
                                    n17 /= 3;
                                    break block12;
                                }
                                if (n18 != n16) {
                                    object = new IllegalStateException();
                                    throw object;
                                }
                            }
                            n17 /= 2;
                            break block14;
                        }
                        n17 *= 2;
                    }
                    byteBuffer = this.replaceOutputBuffer(n17);
                    audioProcessor$AudioFormat = this.inputAudioFormat;
                    int n19 = audioProcessor$AudioFormat.encoding;
                    if (n19 == n12) break block16;
                    if (n19 == n13) break block17;
                    if (n19 != n14) {
                        if (n19 != n15) {
                            if (n19 != n16) {
                                object = new IllegalStateException();
                                throw object;
                            }
                            while (n10 < n11) {
                                byte by2 = n10 + 2;
                                by2 = ((ByteBuffer)object).get(by2);
                                byteBuffer.put(by2);
                                byte by2 = n10 + 3;
                                by2 = ((ByteBuffer)object).get(by2);
                                byteBuffer.put(by2);
                                n10 += 4;
                            }
                            break block11;
                        } else {
                            while (n10 < n11) {
                                byte by3 = n10 + 1;
                                by3 = ((ByteBuffer)object).get(by3);
                                byteBuffer.put(by3);
                                byte by3 = n10 + 2;
                                by3 = ((ByteBuffer)object).get(by3);
                                byteBuffer.put(by3);
                                n10 += 3;
                            }
                        }
                        break block11;
                    } else {
                        while (n10 < n11) {
                            byte by4 = n10 + 1;
                            by4 = ((ByteBuffer)object).get(by4);
                            byteBuffer.put(by4);
                            by4 = ((ByteBuffer)object).get(n10);
                            byteBuffer.put(by4);
                            n10 += 2;
                        }
                    }
                    break block11;
                }
                while (n10 < n11) {
                    float f12 = ((ByteBuffer)object).getFloat(n10);
                    int n20 = 1065353216;
                    f10 = 1.0f;
                    f12 = Util.constrainValue(f12, -1.0f, f10);
                    f11 = 32767.0f;
                    byte by5 = (short)(f12 *= f11);
                    byte by6 = (byte)(by5 & 0xFF);
                    byteBuffer.put(by6);
                    by5 = (byte)(by5 >> 8 & 0xFF);
                    byteBuffer.put(by5);
                    n10 += 4;
                }
                break block11;
            }
            while (n10 < n11) {
                float f13 = 0.0f;
                audioProcessor$AudioFormat = null;
                byteBuffer.put((byte)0);
                byte by7 = (byte)((((ByteBuffer)object).get(n10) & 0xFF) + -128);
                byteBuffer.put(by7);
                ++n10;
            }
        }
        n10 = ((Buffer)object).limit();
        ((ByteBuffer)object).position(n10);
        byteBuffer.flip();
    }
}

