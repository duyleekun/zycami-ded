/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.BaseAudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public final class ChannelMappingAudioProcessor
extends BaseAudioProcessor {
    private int[] outputChannels;
    private int[] pendingOutputChannels;

    public AudioProcessor$AudioFormat onConfigure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        Object object = this.pendingOutputChannels;
        if (object == null) {
            return AudioProcessor$AudioFormat.NOT_SET;
        }
        int n10 = audioProcessor$AudioFormat.encoding;
        int n11 = 2;
        if (n10 == n11) {
            int n12;
            AudioProcessor$AudioFormat audioProcessor$AudioFormat2;
            n10 = audioProcessor$AudioFormat.channelCount;
            int n13 = ((int[])object).length;
            int n14 = 1;
            if (n10 != n13) {
                n10 = n14;
            } else {
                n10 = 0;
                audioProcessor$AudioFormat2 = null;
            }
            for (n13 = 0; n13 < (n12 = ((int[])object).length); ++n13) {
                n12 = object[n13];
                int n15 = audioProcessor$AudioFormat.channelCount;
                if (n12 < n15) {
                    n12 = n12 != n13 ? n14 : 0;
                    n10 |= n12;
                    continue;
                }
                object = new AudioProcessor$UnhandledAudioFormatException;
                object(audioProcessor$AudioFormat);
                throw object;
            }
            if (n10 != 0) {
                int n16 = audioProcessor$AudioFormat.sampleRate;
                int n17 = ((int[])object).length;
                audioProcessor$AudioFormat2 = new AudioProcessor$AudioFormat(n16, n17, n11);
            } else {
                audioProcessor$AudioFormat2 = AudioProcessor$AudioFormat.NOT_SET;
            }
            return audioProcessor$AudioFormat2;
        }
        object = new AudioProcessor$UnhandledAudioFormatException;
        object(audioProcessor$AudioFormat);
        throw object;
    }

    public void onFlush() {
        int[] nArray = this.pendingOutputChannels;
        this.outputChannels = nArray;
    }

    public void onReset() {
        this.outputChannels = null;
        this.pendingOutputChannels = null;
    }

    public void queueInput(ByteBuffer byteBuffer) {
        int n10;
        int[] nArray = (int[])Assertions.checkNotNull(this.outputChannels);
        int n11 = byteBuffer.limit();
        int n12 = n11 - n10;
        int n13 = this.inputAudioFormat.bytesPerFrame;
        n12 /= n13;
        AudioProcessor$AudioFormat audioProcessor$AudioFormat = this.outputAudioFormat;
        n13 = audioProcessor$AudioFormat.bytesPerFrame;
        ByteBuffer byteBuffer2 = this.replaceOutputBuffer(n12 *= n13);
        for (n10 = byteBuffer.position(); n10 < n11; n10 += n13) {
            n13 = nArray.length;
            for (int i10 = 0; i10 < n13; ++i10) {
                short s10 = nArray[i10] * 2 + n10;
                s10 = byteBuffer.getShort(s10);
                byteBuffer2.putShort(s10);
            }
            audioProcessor$AudioFormat = this.inputAudioFormat;
            n13 = audioProcessor$AudioFormat.bytesPerFrame;
        }
        byteBuffer.position(n11);
        byteBuffer2.flip();
    }

    public void setChannelMap(int[] nArray) {
        this.pendingOutputChannels = nArray;
    }
}

