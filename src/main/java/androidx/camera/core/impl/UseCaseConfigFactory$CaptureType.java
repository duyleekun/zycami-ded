/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class UseCaseConfigFactory$CaptureType
extends Enum {
    private static final /* synthetic */ UseCaseConfigFactory$CaptureType[] $VALUES;
    public static final /* enum */ UseCaseConfigFactory$CaptureType IMAGE_ANALYSIS;
    public static final /* enum */ UseCaseConfigFactory$CaptureType IMAGE_CAPTURE;
    public static final /* enum */ UseCaseConfigFactory$CaptureType PREVIEW;
    public static final /* enum */ UseCaseConfigFactory$CaptureType VIDEO_CAPTURE;

    static {
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType2;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType3;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType4;
        IMAGE_CAPTURE = useCaseConfigFactory$CaptureType4 = new UseCaseConfigFactory$CaptureType("IMAGE_CAPTURE", 0);
        int n10 = 1;
        PREVIEW = useCaseConfigFactory$CaptureType3 = new UseCaseConfigFactory$CaptureType("PREVIEW", n10);
        int n11 = 2;
        IMAGE_ANALYSIS = useCaseConfigFactory$CaptureType2 = new UseCaseConfigFactory$CaptureType("IMAGE_ANALYSIS", n11);
        int n12 = 3;
        VIDEO_CAPTURE = useCaseConfigFactory$CaptureType = new UseCaseConfigFactory$CaptureType("VIDEO_CAPTURE", n12);
        UseCaseConfigFactory$CaptureType[] useCaseConfigFactory$CaptureTypeArray = new UseCaseConfigFactory$CaptureType[4];
        useCaseConfigFactory$CaptureTypeArray[0] = useCaseConfigFactory$CaptureType4;
        useCaseConfigFactory$CaptureTypeArray[n10] = useCaseConfigFactory$CaptureType3;
        useCaseConfigFactory$CaptureTypeArray[n11] = useCaseConfigFactory$CaptureType2;
        useCaseConfigFactory$CaptureTypeArray[n12] = useCaseConfigFactory$CaptureType;
        $VALUES = useCaseConfigFactory$CaptureTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private UseCaseConfigFactory$CaptureType() {
        void var2_-1;
        void var1_-1;
    }

    public static UseCaseConfigFactory$CaptureType valueOf(String string2) {
        return Enum.valueOf(UseCaseConfigFactory$CaptureType.class, string2);
    }

    public static UseCaseConfigFactory$CaptureType[] values() {
        return (UseCaseConfigFactory$CaptureType[])$VALUES.clone();
    }
}

