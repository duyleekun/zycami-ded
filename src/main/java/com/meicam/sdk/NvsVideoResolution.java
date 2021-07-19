/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsRational;

public class NvsVideoResolution {
    public static final int VIDEO_RESOLUTION_BIT_DEPTH_16_BIT_FLOAT = 1;
    public static final int VIDEO_RESOLUTION_BIT_DEPTH_8_BIT = 0;
    public static final int VIDEO_RESOLUTION_BIT_DEPTH_AUTO = 2;
    public int bitDepth;
    public int imageHeight;
    public NvsRational imagePAR;
    public int imageWidth;
}

