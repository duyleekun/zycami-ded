/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;

public class DownsampleStrategy$c
extends DownsampleStrategy {
    public DownsampleStrategy$SampleSizeRounding a(int n10, int n11, int n12, int n13) {
        DownsampleStrategy$SampleSizeRounding downsampleStrategy$SampleSizeRounding;
        float f10;
        float f11 = this.b(n10, n11, n12, n13);
        float f12 = f11 - (f10 = 1.0f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            downsampleStrategy$SampleSizeRounding = DownsampleStrategy$SampleSizeRounding.QUALITY;
        } else {
            DownsampleStrategy downsampleStrategy = DownsampleStrategy.c;
            downsampleStrategy$SampleSizeRounding = downsampleStrategy.a(n10, n11, n12, n13);
        }
        return downsampleStrategy$SampleSizeRounding;
    }

    public float b(int n10, int n11, int n12, int n13) {
        float f10 = DownsampleStrategy.c.b(n10, n11, n12, n13);
        return Math.min(1.0f, f10);
    }
}

