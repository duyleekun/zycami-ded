/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load;

public final class PreferredColorSpace
extends Enum {
    public static final /* enum */ PreferredColorSpace DISPLAY_P3;
    public static final /* enum */ PreferredColorSpace SRGB;
    private static final /* synthetic */ PreferredColorSpace[] a;

    static {
        PreferredColorSpace preferredColorSpace;
        PreferredColorSpace preferredColorSpace2;
        SRGB = preferredColorSpace2 = new PreferredColorSpace("SRGB", 0);
        int n10 = 1;
        DISPLAY_P3 = preferredColorSpace = new PreferredColorSpace("DISPLAY_P3", n10);
        PreferredColorSpace[] preferredColorSpaceArray = new PreferredColorSpace[2];
        preferredColorSpaceArray[0] = preferredColorSpace2;
        preferredColorSpaceArray[n10] = preferredColorSpace;
        a = preferredColorSpaceArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PreferredColorSpace() {
        void var2_-1;
        void var1_-1;
    }

    public static PreferredColorSpace valueOf(String string2) {
        return Enum.valueOf(PreferredColorSpace.class, string2);
    }

    public static PreferredColorSpace[] values() {
        return (PreferredColorSpace[])a.clone();
    }
}

