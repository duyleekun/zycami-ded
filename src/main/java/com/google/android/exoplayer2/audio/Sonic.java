/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

public final class Sonic {
    private static final int AMDF_FREQUENCY = 4000;
    private static final int BYTES_PER_SAMPLE = 2;
    private static final int MAXIMUM_PITCH = 400;
    private static final int MINIMUM_PITCH = 65;
    private final int channelCount;
    private final short[] downSampleBuffer;
    private short[] inputBuffer;
    private int inputFrameCount;
    private final int inputSampleRateHz;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequiredFrameCount;
    private int minDiff;
    private final int minPeriod;
    private int newRatePosition;
    private int oldRatePosition;
    private short[] outputBuffer;
    private int outputFrameCount;
    private final float pitch;
    private short[] pitchBuffer;
    private int pitchFrameCount;
    private int prevMinDiff;
    private int prevPeriod;
    private final float rate;
    private int remainingInputToCopyFrameCount;
    private final float speed;

    public Sonic(int n10, int n11, float f10, float f11, int n12) {
        int n13;
        this.inputSampleRateHz = n10;
        this.channelCount = n11;
        this.speed = f10;
        this.pitch = f11;
        f10 = n10;
        f11 = n12;
        this.rate = f10 /= f11;
        this.minPeriod = n13 = n10 / 400;
        this.maxPeriod = n10 /= 65;
        this.maxRequiredFrameCount = n10 *= 2;
        short[] sArray = new short[n10];
        this.downSampleBuffer = sArray;
        sArray = new short[n10 * n11];
        this.inputBuffer = sArray;
        sArray = new short[n10 * n11];
        this.outputBuffer = sArray;
        short[] sArray2 = new short[n10 * n11];
        this.pitchBuffer = sArray2;
    }

    private void adjustRate(float f10, int n10) {
        int n11 = this.outputFrameCount;
        if (n11 == n10) {
            return;
        }
        n11 = this.inputSampleRateHz;
        float f11 = (float)n11 / f10;
        int n12 = (int)f11;
        while (true) {
            int n13 = 16384;
            f11 = 2.2959E-41f;
            if (n12 <= n13 && n11 <= n13) {
                int n14;
                this.moveNewSamplesToPitchBuffer(n10);
                n10 = 0;
                n13 = 0;
                f11 = 0.0f;
                while (true) {
                    int n15;
                    int n16;
                    int n17 = this.pitchFrameCount;
                    int n18 = n17 + -1;
                    n14 = 1;
                    if (n13 >= n18) break;
                    while ((n18 = ((n17 = this.oldRatePosition) + 1) * n12) > (n16 = (n15 = this.newRatePosition) * n11)) {
                        short[] sArray = this.outputBuffer;
                        n18 = this.outputFrameCount;
                        this.outputBuffer = sArray = this.ensureSpaceForAdditionalFrames(sArray, n18, n14);
                        sArray = null;
                        for (n17 = 0; n17 < (n18 = this.channelCount); ++n17) {
                            short[] sArray2 = this.outputBuffer;
                            n16 = this.outputFrameCount * n18 + n17;
                            short[] sArray3 = this.pitchBuffer;
                            n18 = n18 * n13 + n17;
                            sArray2[n16] = n18 = (int)this.interpolate(sArray3, n18, n11, n12);
                        }
                        this.newRatePosition = n17 = this.newRatePosition + n14;
                        this.outputFrameCount = n17 = this.outputFrameCount + n14;
                    }
                    this.oldRatePosition = ++n17;
                    if (n17 == n11) {
                        this.oldRatePosition = 0;
                        if (n15 != n12) {
                            n14 = 0;
                        }
                        Assertions.checkState(n14 != 0);
                        this.newRatePosition = 0;
                    }
                    ++n13;
                }
                this.removePitchFrames(n17 -= n14);
                return;
            }
            n12 /= 2;
            n11 /= 2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void changeSpeed(float f10) {
        int n10;
        int n11 = this.inputFrameCount;
        int n12 = this.maxRequiredFrameCount;
        if (n11 < n12) {
            return;
        }
        n12 = 0;
        do {
            short[] sArray;
            if ((n10 = this.remainingInputToCopyFrameCount) > 0) {
                n10 = this.copyInputToOutput(n12);
                continue;
            }
            short[] sArray2 = this.inputBuffer;
            n10 = this.findPitchPeriod(sArray2, n12);
            double d10 = f10;
            double d11 = 1.0;
            double d12 = d10 - d11;
            Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            if (object > 0) {
                sArray = this.inputBuffer;
                object = this.skipPitchPeriod(sArray, n12, f10, n10);
                n10 += object;
                continue;
            }
            sArray = this.inputBuffer;
            n10 = this.insertPitchPeriod(sArray, n12, f10, n10);
        } while ((n10 = this.maxRequiredFrameCount + (n12 += n10)) <= n11);
        this.removeProcessedInputFrames(n12);
    }

    private int copyInputToOutput(int n10) {
        int n11 = this.maxRequiredFrameCount;
        int n12 = this.remainingInputToCopyFrameCount;
        n11 = Math.min(n11, n12);
        short[] sArray = this.inputBuffer;
        this.copyToOutput(sArray, n10, n11);
        this.remainingInputToCopyFrameCount = n10 = this.remainingInputToCopyFrameCount - n11;
        return n11;
    }

    private void copyToOutput(short[] sArray, int n10, int n11) {
        int n12;
        short[] sArray2 = this.outputBuffer;
        int n13 = this.outputFrameCount;
        this.outputBuffer = sArray2 = this.ensureSpaceForAdditionalFrames(sArray2, n13, n11);
        n13 = this.channelCount;
        n10 *= n13;
        int n14 = this.outputFrameCount * n13;
        System.arraycopy(sArray, n10, sArray2, n14, n13 *= n11);
        this.outputFrameCount = n12 = this.outputFrameCount + n11;
    }

    private void downSampleInput(short[] sArray, int n10, int n11) {
        int n12 = this.maxRequiredFrameCount / n11;
        int n13 = this.channelCount;
        n11 *= n13;
        n10 *= n13;
        n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            short[] sArray2 = null;
            int n14 = 0;
            for (int i11 = 0; i11 < n11; ++i11) {
                int n15 = i10 * n11 + n10 + i11;
                n15 = sArray[n15];
                n14 += n15;
            }
            n14 /= n11;
            sArray2 = this.downSampleBuffer;
            sArray2[i10] = n14 = (int)((short)n14);
        }
    }

    private short[] ensureSpaceForAdditionalFrames(short[] sArray, int n10, int n11) {
        int n12 = sArray.length;
        int n13 = this.channelCount;
        if ((n10 += n11) <= (n12 /= n13)) {
            return sArray;
        }
        n12 = (n12 * 3 / 2 + n11) * n13;
        return Arrays.copyOf(sArray, n12);
    }

    private int findPitchPeriod(short[] sArray, int n10) {
        int n11;
        int n12 = this.inputSampleRateHz;
        int n13 = 4000;
        int n14 = 1;
        n12 = n12 > n13 ? (n12 /= n13) : n14;
        n13 = this.channelCount;
        if (n13 == n14 && n12 == n14) {
            n12 = this.minPeriod;
            n13 = this.maxPeriod;
            n11 = this.findPitchPeriodInRange(sArray, n10, n12, n13);
        } else {
            this.downSampleInput(sArray, n10, n12);
            short[] sArray2 = this.downSampleBuffer;
            int n15 = this.minPeriod / n12;
            int n16 = this.maxPeriod / n12;
            n13 = this.findPitchPeriodInRange(sArray2, 0, n15, n16);
            if (n12 != n14) {
                n13 *= n12;
                n15 = n13 - (n12 *= 4);
                n13 += n12;
                n12 = this.minPeriod;
                if (n15 < n12) {
                    n15 = n12;
                }
                if (n13 > (n12 = this.maxPeriod)) {
                    n13 = n12;
                }
                if ((n12 = this.channelCount) == n14) {
                    n11 = this.findPitchPeriodInRange(sArray, n10, n15, n13);
                } else {
                    this.downSampleInput(sArray, n10, n14);
                    sArray = this.downSampleBuffer;
                    n11 = this.findPitchPeriodInRange(sArray, 0, n15, n13);
                }
            } else {
                n11 = n13;
            }
        }
        n10 = this.minDiff;
        n12 = this.maxDiff;
        n10 = (int)(this.previousPeriodBetter(n10, n12) ? 1 : 0);
        n10 = n10 != 0 ? this.prevPeriod : n11;
        this.prevMinDiff = n12 = this.minDiff;
        this.prevPeriod = n11;
        return n10;
    }

    private int findPitchPeriodInRange(short[] sArray, int n10, int n11, int n12) {
        int n13 = this.channelCount;
        n10 *= n13;
        n13 = 1;
        int n14 = 255;
        int n15 = 0;
        int n16 = 0;
        while (n11 <= n12) {
            int n17;
            int n18;
            int n19 = 0;
            for (n18 = 0; n18 < n11; ++n18) {
                n17 = n10 + n18;
                n17 = sArray[n17];
                int n20 = n10 + n11 + n18;
                n20 = sArray[n20];
                n17 = Math.abs(n17 - n20);
                n19 += n17;
            }
            n18 = n19 * n15;
            n17 = n13 * n11;
            if (n18 < n17) {
                n15 = n11;
                n13 = n19;
            }
            if ((n18 = n19 * n14) > (n17 = n16 * n11)) {
                n14 = n11;
                n16 = n19;
            }
            ++n11;
        }
        this.minDiff = n13 /= n15;
        this.maxDiff = n16 /= n14;
        return n15;
    }

    private int insertPitchPeriod(short[] sArray, int n10, float f10, int n11) {
        int n12;
        int n13;
        int n14;
        float f11 = 0.5f;
        float f12 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        int n15 = 1065353216;
        float f13 = 1.0f;
        if (f12 < 0) {
            f11 = (float)n11 * f10;
            n14 = (int)(f11 /= (f13 -= f10));
        } else {
            f11 = n11;
            n13 = 0x40000000;
            float f14 = 2.0f * f10 - f13;
            f11 *= f14;
            this.remainingInputToCopyFrameCount = n14 = (int)(f11 /= (f13 -= f10));
            n14 = n11;
        }
        short[] sArray2 = this.outputBuffer;
        n15 = this.outputFrameCount;
        int n16 = n11 + n14;
        this.outputBuffer = sArray2 = this.ensureSpaceForAdditionalFrames(sArray2, n15, n16);
        n15 = this.channelCount;
        n13 = n10 * n15;
        int n17 = this.outputFrameCount * n15;
        System.arraycopy(sArray, n13, sArray2, n17, n15 *= n11);
        n15 = this.channelCount;
        short[] sArray3 = this.outputBuffer;
        n17 = this.outputFrameCount + n11;
        int n18 = n10 + n11;
        f12 = n14;
        Sonic.overlapAdd(n14, n15, sArray3, n17, sArray, n18, sArray, n10);
        this.outputFrameCount = n12 = this.outputFrameCount + n16;
        return n14;
    }

    private short interpolate(short[] sArray, int n10, int n11, int n12) {
        int n13 = sArray[n10];
        int n14 = this.channelCount;
        short s10 = sArray[n10 += n14];
        n10 = this.newRatePosition * n11;
        n11 = this.oldRatePosition;
        n14 = n11 * n12;
        n11 = (n11 + 1) * n12;
        n10 = n11 - n10;
        n13 *= n10;
        n10 = ((n11 -= n14) - n10) * s10;
        return (short)((n13 + n10) / n11);
    }

    private void moveNewSamplesToPitchBuffer(int n10) {
        int n11 = this.outputFrameCount - n10;
        short[] sArray = this.pitchBuffer;
        int n12 = this.pitchFrameCount;
        this.pitchBuffer = sArray = this.ensureSpaceForAdditionalFrames(sArray, n12, n11);
        short[] sArray2 = this.outputBuffer;
        int n13 = this.channelCount;
        int n14 = n10 * n13;
        int n15 = this.pitchFrameCount * n13;
        System.arraycopy(sArray2, n14, sArray, n15, n13 *= n11);
        this.outputFrameCount = n10;
        this.pitchFrameCount = n10 = this.pitchFrameCount + n11;
    }

    private static void overlapAdd(int n10, int n11, short[] sArray, int n12, short[] sArray2, int n13, short[] sArray3, int n14) {
        for (int i10 = 0; i10 < n11; ++i10) {
            int n15 = n12 * n11 + i10;
            int n16 = n14 * n11 + i10;
            int n17 = n13 * n11 + i10;
            for (int i11 = 0; i11 < n10; ++i11) {
                int n18 = sArray2[n17];
                int n19 = n10 - i11;
                n18 *= n19;
                n19 = sArray3[n16] * i11;
                sArray[n15] = n18 = (int)((short)((n18 + n19) / n10));
                n15 += n11;
                n17 += n11;
                n16 += n11;
            }
        }
    }

    private boolean previousPeriodBetter(int n10, int n11) {
        int n12;
        if (n10 != 0 && (n12 = this.prevPeriod) != 0) {
            n12 = n10 * 3;
            if (n11 > n12) {
                return false;
            }
            n11 = this.prevMinDiff * 3;
            return (n10 *= 2) > n11;
        }
        return false;
    }

    private void processStreamInput() {
        double d10;
        int n10 = this.outputFrameCount;
        float f10 = this.speed;
        float f11 = this.pitch;
        float f12 = this.rate * f11;
        double d11 = f10 /= f11;
        double d12 = 1.00001;
        double d13 = d11 - d12;
        Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object <= 0 && (object = (d10 = d11 - (d12 = 0.99999)) == 0.0 ? 0 : (d10 < 0.0 ? -1 : 1)) >= 0) {
            short[] sArray = this.inputBuffer;
            object = this.inputFrameCount;
            this.copyToOutput(sArray, 0, (int)object);
            this.inputFrameCount = 0;
        } else {
            this.changeSpeed(f10);
        }
        f10 = 1.0f;
        float f13 = f12 == f10 ? 0 : (f12 > f10 ? 1 : -1);
        if (f13 != false) {
            this.adjustRate(f12, n10);
        }
    }

    private void removePitchFrames(int n10) {
        int n11;
        if (n10 == 0) {
            return;
        }
        short[] sArray = this.pitchBuffer;
        int n12 = this.channelCount;
        int n13 = n10 * n12;
        int n14 = (this.pitchFrameCount - n10) * n12;
        System.arraycopy(sArray, n13, sArray, 0, n14);
        this.pitchFrameCount = n11 = this.pitchFrameCount - n10;
    }

    private void removeProcessedInputFrames(int n10) {
        int n11 = this.inputFrameCount - n10;
        short[] sArray = this.inputBuffer;
        int n12 = this.channelCount;
        n10 *= n12;
        System.arraycopy(sArray, n10, sArray, 0, n12 *= n11);
        this.inputFrameCount = n11;
    }

    private int skipPitchPeriod(short[] sArray, int n10, float f10, int n11) {
        int n12;
        int n13;
        float f11 = 2.0f;
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        float f13 = 1.0f;
        if (f12 >= 0) {
            f11 = n11;
            n13 = (int)(f11 /= (f10 -= f13));
        } else {
            float f14 = n11;
            f14 *= (f11 -= f10);
            this.remainingInputToCopyFrameCount = n13 = (int)(f14 /= (f10 -= f13));
            n13 = n11;
        }
        short[] sArray2 = this.outputBuffer;
        f12 = this.outputFrameCount;
        short[] sArray3 = this.ensureSpaceForAdditionalFrames(sArray2, (int)f12, n13);
        this.outputBuffer = sArray3;
        f12 = this.channelCount;
        int n14 = this.outputFrameCount;
        int n15 = n10 + n11;
        Sonic.overlapAdd(n13, (int)f12, sArray3, n14, sArray, n10, sArray, n15);
        this.outputFrameCount = n12 = this.outputFrameCount + n13;
        return n13;
    }

    public void flush() {
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.pitchFrameCount = 0;
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.prevPeriod = 0;
        this.prevMinDiff = 0;
        this.minDiff = 0;
        this.maxDiff = 0;
    }

    public void getOutput(ShortBuffer shortBuffer) {
        int n10;
        int n11 = shortBuffer.remaining();
        int n12 = this.channelCount;
        n11 /= n12;
        n12 = this.outputFrameCount;
        n11 = Math.min(n11, n12);
        short[] sArray = this.outputBuffer;
        int n13 = this.channelCount * n11;
        shortBuffer.put(sArray, 0, n13);
        this.outputFrameCount = n10 = this.outputFrameCount - n11;
        sArray = this.outputBuffer;
        n13 = this.channelCount;
        System.arraycopy(sArray, n11 *= n13, sArray, 0, n10 *= n13);
    }

    public int getOutputSize() {
        int n10 = this.outputFrameCount;
        int n11 = this.channelCount;
        return n10 * n11 * 2;
    }

    public int getPendingInputBytes() {
        int n10 = this.inputFrameCount;
        int n11 = this.channelCount;
        return n10 * n11 * 2;
    }

    public void queueEndOfStream() {
        int n10 = this.inputFrameCount;
        float f10 = this.speed;
        float f11 = this.pitch;
        float f12 = this.rate * f11;
        int n11 = this.outputFrameCount;
        float f13 = (float)n10 / (f10 /= f11);
        f10 = this.pitchFrameCount;
        f13 = (f13 + f10) / f12 + 0.5f;
        int n12 = (int)f13;
        n11 += n12;
        short[] sArray = this.inputBuffer;
        int n13 = this.maxRequiredFrameCount * 2 + n10;
        this.inputBuffer = sArray = this.ensureSpaceForAdditionalFrames(sArray, n10, n13);
        n12 = 0;
        f10 = 0.0f;
        sArray = null;
        n13 = 0;
        f12 = 0.0f;
        while (true) {
            int n14 = this.maxRequiredFrameCount;
            int n15 = n14 * 2;
            int n16 = this.channelCount;
            if (n13 >= (n15 *= n16)) break;
            short[] sArray2 = this.inputBuffer;
            n16 = n16 * n10 + n13;
            sArray2[n16] = 0;
            ++n13;
        }
        n10 = this.inputFrameCount;
        this.inputFrameCount = n10 += (n14 *= 2);
        this.processStreamInput();
        n10 = this.outputFrameCount;
        if (n10 > n11) {
            this.outputFrameCount = n11;
        }
        this.inputFrameCount = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.pitchFrameCount = 0;
    }

    public void queueInput(ShortBuffer shortBuffer) {
        int n10;
        int n11 = shortBuffer.remaining();
        int n12 = this.channelCount;
        n11 /= n12;
        n12 = n12 * n11 * 2;
        short[] sArray = this.inputBuffer;
        int n13 = this.inputFrameCount;
        this.inputBuffer = sArray = this.ensureSpaceForAdditionalFrames(sArray, n13, n11);
        n13 = this.inputFrameCount;
        int n14 = this.channelCount;
        shortBuffer.get(sArray, n13 *= n14, n12 /= 2);
        this.inputFrameCount = n10 = this.inputFrameCount + n11;
        this.processStreamInput();
    }
}

