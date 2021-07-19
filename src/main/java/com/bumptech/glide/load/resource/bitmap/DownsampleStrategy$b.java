/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;

public class DownsampleStrategy$b
extends DownsampleStrategy {
    public DownsampleStrategy$SampleSizeRounding a(int n10, int n11, int n12, int n13) {
        return DownsampleStrategy$SampleSizeRounding.MEMORY;
    }

    public float b(int n10, int n11, int n12, int n13) {
        float f10 = n11;
        float f11 = n13;
        float f12 = n10;
        float f13 = n12;
        f12 /= f13;
        f12 = Math.max(f10 /= f11, f12);
        double d10 = Math.ceil(f12);
        n10 = (int)d10;
        n11 = Integer.highestOneBit(n10);
        n12 = 1;
        f13 = Float.MIN_VALUE;
        if ((n11 = Math.max(n12, n11)) >= n10) {
            n12 = 0;
            f13 = 0.0f;
        }
        f12 = n11 << n12;
        return 1.0f / f12;
    }
}

