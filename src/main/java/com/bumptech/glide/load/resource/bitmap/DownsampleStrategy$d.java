/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;

public class DownsampleStrategy$d
extends DownsampleStrategy {
    public DownsampleStrategy$SampleSizeRounding a(int n10, int n11, int n12, int n13) {
        return DownsampleStrategy$SampleSizeRounding.QUALITY;
    }

    public float b(int n10, int n11, int n12, int n13) {
        float f10 = n12;
        float f11 = n10;
        f10 /= f11;
        f11 = n13;
        float f12 = n11;
        return Math.max(f10, f11 /= f12);
    }
}

