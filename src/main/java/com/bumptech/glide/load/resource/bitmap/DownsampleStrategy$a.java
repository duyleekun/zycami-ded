/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;

public class DownsampleStrategy$a
extends DownsampleStrategy {
    public DownsampleStrategy$SampleSizeRounding a(int n10, int n11, int n12, int n13) {
        return DownsampleStrategy$SampleSizeRounding.QUALITY;
    }

    public float b(int n10, int n11, int n12, int n13) {
        n10 /= n12;
        n10 = Math.min(n11 /= n13, n10);
        n11 = 1065353216;
        float f10 = 1.0f;
        if (n10 != 0) {
            n10 = Integer.highestOneBit(n10);
            float f11 = n10;
            f10 /= f11;
        }
        return f10;
    }
}

