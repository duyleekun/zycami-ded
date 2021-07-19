/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;

public class DownsampleStrategy$e
extends DownsampleStrategy {
    public DownsampleStrategy$SampleSizeRounding a(int n10, int n11, int n12, int n13) {
        n10 = (int)(DownsampleStrategy.i ? 1 : 0);
        if (n10 != 0) {
            return DownsampleStrategy$SampleSizeRounding.QUALITY;
        }
        return DownsampleStrategy$SampleSizeRounding.MEMORY;
    }

    public float b(int n10, int n11, int n12, int n13) {
        boolean bl2 = DownsampleStrategy.i;
        if (bl2) {
            float f10 = n12;
            float f11 = n10;
            f10 /= f11;
            f11 = n13;
            float f12 = n11;
            return Math.min(f10, f11 /= f12);
        }
        n10 /= n12;
        n10 = Math.max(n11 /= n13, n10);
        n11 = 1065353216;
        float f13 = 1.0f;
        if (n10 != 0) {
            n10 = Integer.highestOneBit(n10);
            float f14 = n10;
            f13 /= f14;
        }
        return f13;
    }
}

