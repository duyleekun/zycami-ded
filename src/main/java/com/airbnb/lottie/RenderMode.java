/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

public final class RenderMode
extends Enum {
    private static final /* synthetic */ RenderMode[] $VALUES;
    public static final /* enum */ RenderMode AUTOMATIC;
    public static final /* enum */ RenderMode HARDWARE;
    public static final /* enum */ RenderMode SOFTWARE;

    static {
        RenderMode renderMode;
        RenderMode renderMode2;
        RenderMode renderMode3;
        AUTOMATIC = renderMode3 = new RenderMode("AUTOMATIC", 0);
        int n10 = 1;
        HARDWARE = renderMode2 = new RenderMode("HARDWARE", n10);
        int n11 = 2;
        SOFTWARE = renderMode = new RenderMode("SOFTWARE", n11);
        RenderMode[] renderModeArray = new RenderMode[3];
        renderModeArray[0] = renderMode3;
        renderModeArray[n10] = renderMode2;
        renderModeArray[n11] = renderMode;
        $VALUES = renderModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RenderMode() {
        void var2_-1;
        void var1_-1;
    }

    public static RenderMode valueOf(String string2) {
        return Enum.valueOf(RenderMode.class, string2);
    }

    public static RenderMode[] values() {
        return (RenderMode[])$VALUES.clone();
    }
}

