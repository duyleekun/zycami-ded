/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;
import com.google.android.exoplayer2.util.Assertions;

public final class SefSlowMotionVideoSampleTransformer$SegmentInfo {
    public final long endTimeUs;
    public final int maxLayer;
    public final int speedDivisor;
    public final long startTimeUs;

    public SefSlowMotionVideoSampleTransformer$SegmentInfo(SlowMotionData$Segment slowMotionData$Segment, int n10, int n11) {
        int n12;
        long l10;
        this.startTimeUs = l10 = C.msToUs(slowMotionData$Segment.startTimeMs);
        this.endTimeUs = l10 = C.msToUs(slowMotionData$Segment.endTimeMs);
        this.speedDivisor = n12 = slowMotionData$Segment.speedDivisor;
        this.maxLayer = n12 = SefSlowMotionVideoSampleTransformer$SegmentInfo.getSlowMotionMaxLayer(n12, n10, n11);
    }

    private static int getSlowMotionMaxLayer(int n10, int n11, int n12) {
        for (int i10 = n10; i10 > 0; i10 >>= 1) {
            int n13 = i10 & 1;
            int n14 = 1;
            if (n13 == n14) {
                if ((i10 >>= n14) != 0) {
                    n14 = 0;
                }
                i10 = 34;
                StringBuilder stringBuilder = new StringBuilder(i10);
                String string2 = "Invalid speed divisor: ";
                stringBuilder.append(string2);
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                Assertions.checkState(n14 != 0, string3);
                break;
            }
            ++n12;
        }
        return Math.min(n12, n11);
    }
}

