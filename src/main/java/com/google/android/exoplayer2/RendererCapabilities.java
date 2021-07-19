/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Format;

public interface RendererCapabilities {
    public static final int ADAPTIVE_NOT_SEAMLESS = 8;
    public static final int ADAPTIVE_NOT_SUPPORTED = 0;
    public static final int ADAPTIVE_SEAMLESS = 16;
    public static final int ADAPTIVE_SUPPORT_MASK = 24;
    public static final int FORMAT_EXCEEDS_CAPABILITIES = 3;
    public static final int FORMAT_HANDLED = 4;
    public static final int FORMAT_SUPPORT_MASK = 7;
    public static final int FORMAT_UNSUPPORTED_DRM = 2;
    public static final int FORMAT_UNSUPPORTED_SUBTYPE = 1;
    public static final int FORMAT_UNSUPPORTED_TYPE = 0;
    public static final int TUNNELING_NOT_SUPPORTED = 0;
    public static final int TUNNELING_SUPPORTED = 32;
    public static final int TUNNELING_SUPPORT_MASK = 32;

    public static int create(int n10) {
        return RendererCapabilities.create(n10, 0, 0);
    }

    public static int create(int n10, int n11, int n12) {
        return n10 | n11 | n12;
    }

    public static int getAdaptiveSupport(int n10) {
        return n10 & 0x18;
    }

    public static int getFormatSupport(int n10) {
        return n10 & 7;
    }

    public static int getTunnelingSupport(int n10) {
        return n10 & 0x20;
    }

    public String getName();

    public int getTrackType();

    public int supportsFormat(Format var1);

    public int supportsMixedMimeTypeAdaptation();
}

