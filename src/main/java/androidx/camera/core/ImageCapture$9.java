/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageSaver$SaveError;

public class ImageCapture$9 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageSaver$SaveError;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        ImageSaver$SaveError imageSaver$SaveError;
        int n10 = ImageSaver$SaveError.values().length;
        int[] nArray = new int[n10];
        $SwitchMap$androidx$camera$core$ImageSaver$SaveError = nArray;
        try {
            imageSaver$SaveError = ImageSaver$SaveError.FILE_IO_FAILED;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
        int n11 = imageSaver$SaveError.ordinal();
        int n12 = 1;
        nArray[n11] = n12;
    }
}

