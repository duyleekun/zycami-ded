/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;

public class Camera2UseCaseConfigFactory$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType;
        int n12 = UseCaseConfigFactory$CaptureType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType = nArray;
        try {
            useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.IMAGE_CAPTURE;
            n11 = useCaseConfigFactory$CaptureType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType;
            useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.PREVIEW;
            n11 = useCaseConfigFactory$CaptureType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType;
            useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.IMAGE_ANALYSIS;
            n11 = useCaseConfigFactory$CaptureType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType;
            useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.VIDEO_CAPTURE;
            n11 = useCaseConfigFactory$CaptureType.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

