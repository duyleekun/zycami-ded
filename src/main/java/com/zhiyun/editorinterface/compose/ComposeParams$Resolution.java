/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorinterface.compose;

public final class ComposeParams$Resolution
extends Enum {
    public static final /* enum */ ComposeParams$Resolution RESOLUTION_1080P;
    public static final /* enum */ ComposeParams$Resolution RESOLUTION_2K;
    public static final /* enum */ ComposeParams$Resolution RESOLUTION_480P;
    public static final /* enum */ ComposeParams$Resolution RESOLUTION_4K;
    public static final /* enum */ ComposeParams$Resolution RESOLUTION_720P;
    public static final /* enum */ ComposeParams$Resolution RESOLUTION_ORIGINAL;
    private static final /* synthetic */ ComposeParams$Resolution[] a;
    public int height;

    static {
        ComposeParams$Resolution composeParams$Resolution;
        ComposeParams$Resolution composeParams$Resolution2;
        ComposeParams$Resolution composeParams$Resolution3;
        ComposeParams$Resolution composeParams$Resolution4;
        ComposeParams$Resolution composeParams$Resolution5;
        ComposeParams$Resolution composeParams$Resolution6;
        int n10 = 1;
        RESOLUTION_ORIGINAL = composeParams$Resolution6 = new ComposeParams$Resolution("RESOLUTION_ORIGINAL", 0, n10);
        RESOLUTION_480P = composeParams$Resolution5 = new ComposeParams$Resolution("RESOLUTION_480P", n10, 480);
        int n11 = 2;
        RESOLUTION_720P = composeParams$Resolution4 = new ComposeParams$Resolution("RESOLUTION_720P", n11, 720);
        int n12 = 3;
        RESOLUTION_1080P = composeParams$Resolution3 = new ComposeParams$Resolution("RESOLUTION_1080P", n12, 1080);
        int n13 = 4;
        RESOLUTION_2K = composeParams$Resolution2 = new ComposeParams$Resolution("RESOLUTION_2K", n13, 1440);
        int n14 = 5;
        RESOLUTION_4K = composeParams$Resolution = new ComposeParams$Resolution("RESOLUTION_4K", n14, 2160);
        ComposeParams$Resolution[] composeParams$ResolutionArray = new ComposeParams$Resolution[6];
        composeParams$ResolutionArray[0] = composeParams$Resolution6;
        composeParams$ResolutionArray[n10] = composeParams$Resolution5;
        composeParams$ResolutionArray[n11] = composeParams$Resolution4;
        composeParams$ResolutionArray[n12] = composeParams$Resolution3;
        composeParams$ResolutionArray[n13] = composeParams$Resolution2;
        composeParams$ResolutionArray[n14] = composeParams$Resolution;
        a = composeParams$ResolutionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ComposeParams$Resolution() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.height = var3_1;
    }

    public static ComposeParams$Resolution valueOf(String string2) {
        return Enum.valueOf(ComposeParams$Resolution.class, string2);
    }

    public static ComposeParams$Resolution[] values() {
        return (ComposeParams$Resolution[])a.clone();
    }

    public int getHeight() {
        return this.height;
    }
}

