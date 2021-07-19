/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.MpegAudioUtil;

public final class MpegAudioUtil$Header {
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;

    public boolean setForHeaderData(int n10) {
        int n11 = MpegAudioUtil.access$000(n10);
        boolean n12 = false;
        Object object = null;
        if (n11 == 0) {
            return false;
        }
        n11 = n10 >>> 19;
        int n13 = 3;
        int n14 = 1;
        if ((n11 &= n13) == n14) {
            return false;
        }
        int n15 = n10 >>> 17 & n13;
        if (n15 == 0) {
            return false;
        }
        int n16 = n10 >>> 12;
        int n17 = 15;
        if ((n16 &= n17) != 0 && n16 != n17) {
            n17 = n10 >>> 10 & n13;
            if (n17 == n13) {
                return false;
            }
            this.version = n11;
            object = MpegAudioUtil.access$100();
            int n18 = 3 - n15;
            this.mimeType = object = object[n18];
            object = MpegAudioUtil.access$200();
            String string2 = object[n17];
            this.sampleRate = (int)string2;
            n17 = 2;
            if (n11 == n17) {
                reference var3_5 = string2 / n17;
                this.sampleRate = (int)var3_5;
            } else if (n11 == 0) {
                reference var3_6 = string2 / 4;
                this.sampleRate = (int)var3_6;
            }
            int n19 = n10 >>> 9 & n14;
            this.samplesPerFrame = n18 = MpegAudioUtil.access$300(n11, n15);
            if (n15 == n13) {
                if (n11 == n13) {
                    int[] nArray = MpegAudioUtil.access$400();
                    n11 = nArray[n16 -= n14];
                } else {
                    int[] nArray = MpegAudioUtil.access$500();
                    n11 = nArray[n16 -= n14];
                }
                this.bitrate = n11;
                n11 *= 12;
                n15 = this.sampleRate;
                this.frameSize = n11 = (n11 / n15 + n19) * 4;
            } else {
                n18 = 144;
                if (n11 == n13) {
                    if (n15 == n17) {
                        int[] nArray = MpegAudioUtil.access$600();
                        n11 = nArray[n16 -= n14];
                    } else {
                        int[] nArray = MpegAudioUtil.access$700();
                        n11 = nArray[n16 -= n14];
                    }
                    this.bitrate = n11;
                    n11 *= n18;
                    n15 = this.sampleRate;
                    this.frameSize = n11 = n11 / n15 + n19;
                } else {
                    int[] nArray = MpegAudioUtil.access$800();
                    this.bitrate = n11 = nArray[n16 -= n14];
                    if (n15 == n14) {
                        n18 = 72;
                    }
                    n18 *= n11;
                    n11 = this.sampleRate;
                    this.frameSize = n18 = n18 / n11 + n19;
                }
            }
            n10 = n10 >> 6 & n13;
            if (n10 == n13) {
                n17 = n14;
            }
            this.channels = n17;
            return n14 != 0;
        }
        return false;
    }
}

