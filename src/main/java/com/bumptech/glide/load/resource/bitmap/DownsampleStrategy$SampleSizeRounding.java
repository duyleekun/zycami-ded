/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

public final class DownsampleStrategy$SampleSizeRounding
extends Enum {
    public static final /* enum */ DownsampleStrategy$SampleSizeRounding MEMORY;
    public static final /* enum */ DownsampleStrategy$SampleSizeRounding QUALITY;
    private static final /* synthetic */ DownsampleStrategy$SampleSizeRounding[] a;

    static {
        DownsampleStrategy$SampleSizeRounding downsampleStrategy$SampleSizeRounding;
        DownsampleStrategy$SampleSizeRounding downsampleStrategy$SampleSizeRounding2;
        MEMORY = downsampleStrategy$SampleSizeRounding2 = new DownsampleStrategy$SampleSizeRounding("MEMORY", 0);
        int n10 = 1;
        QUALITY = downsampleStrategy$SampleSizeRounding = new DownsampleStrategy$SampleSizeRounding("QUALITY", n10);
        DownsampleStrategy$SampleSizeRounding[] downsampleStrategy$SampleSizeRoundingArray = new DownsampleStrategy$SampleSizeRounding[2];
        downsampleStrategy$SampleSizeRoundingArray[0] = downsampleStrategy$SampleSizeRounding2;
        downsampleStrategy$SampleSizeRoundingArray[n10] = downsampleStrategy$SampleSizeRounding;
        a = downsampleStrategy$SampleSizeRoundingArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DownsampleStrategy$SampleSizeRounding() {
        void var2_-1;
        void var1_-1;
    }

    public static DownsampleStrategy$SampleSizeRounding valueOf(String string2) {
        return Enum.valueOf(DownsampleStrategy$SampleSizeRounding.class, string2);
    }

    public static DownsampleStrategy$SampleSizeRounding[] values() {
        return (DownsampleStrategy$SampleSizeRounding[])a.clone();
    }
}

