/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.model;

public final class CompositeConfig$Resolution
extends Enum {
    private static final /* synthetic */ CompositeConfig$Resolution[] $VALUES;
    public static final /* enum */ CompositeConfig$Resolution R_1080;
    public static final /* enum */ CompositeConfig$Resolution R_480;
    public static final /* enum */ CompositeConfig$Resolution R_720;
    private int resolution;

    static {
        CompositeConfig$Resolution compositeConfig$Resolution;
        CompositeConfig$Resolution compositeConfig$Resolution2;
        CompositeConfig$Resolution compositeConfig$Resolution3;
        R_480 = compositeConfig$Resolution3 = new CompositeConfig$Resolution("R_480", 0, 480);
        int n10 = 1;
        R_720 = compositeConfig$Resolution2 = new CompositeConfig$Resolution("R_720", n10, 720);
        int n11 = 2;
        R_1080 = compositeConfig$Resolution = new CompositeConfig$Resolution("R_1080", n11, 1080);
        CompositeConfig$Resolution[] compositeConfig$ResolutionArray = new CompositeConfig$Resolution[3];
        compositeConfig$ResolutionArray[0] = compositeConfig$Resolution3;
        compositeConfig$ResolutionArray[n10] = compositeConfig$Resolution2;
        compositeConfig$ResolutionArray[n11] = compositeConfig$Resolution;
        $VALUES = compositeConfig$ResolutionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CompositeConfig$Resolution() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.resolution = var3_1;
    }

    public static CompositeConfig$Resolution valueOf(String string2) {
        return Enum.valueOf(CompositeConfig$Resolution.class, string2);
    }

    public static CompositeConfig$Resolution[] values() {
        return (CompositeConfig$Resolution[])$VALUES.clone();
    }

    public int getValue() {
        return this.resolution;
    }
}

