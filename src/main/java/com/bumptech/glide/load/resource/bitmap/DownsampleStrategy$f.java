/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;

public class DownsampleStrategy$f
extends DownsampleStrategy {
    public DownsampleStrategy$SampleSizeRounding a(int n10, int n11, int n12, int n13) {
        return DownsampleStrategy$SampleSizeRounding.QUALITY;
    }

    public float b(int n10, int n11, int n12, int n13) {
        return 1.0f;
    }
}

