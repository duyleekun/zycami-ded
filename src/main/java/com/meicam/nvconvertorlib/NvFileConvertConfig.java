/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.nvconvertorlib;

public class NvFileConvertConfig {
    public static final int RESIZE_OUTPUT_VIDEO_RESOLUTION_1080 = 3;
    public static final int RESIZE_OUTPUT_VIDEO_RESOLUTION_360 = 0;
    public static final int RESIZE_OUTPUT_VIDEO_RESOLUTION_480 = 1;
    public static final int RESIZE_OUTPUT_VIDEO_RESOLUTION_720 = 2;
    public static final int RESIZE_OUTPUT_VIDEO_RESOLUTION_NOT_RESIZE = 4;
    public float convertEnd = 0.0f;
    public float convertStart = 0.0f;
    public long dataRate = 0L;
    public boolean deposeOperatingRate = false;
    public int gopsize = 0;
    public boolean iFrameOnly = false;
    public int videoResolution = 4;

    public boolean videoResolutionIsValid() {
        int n10;
        int n11 = this.videoResolution;
        return n11 >= 0 && n11 <= (n10 = 4);
        {
        }
    }
}

