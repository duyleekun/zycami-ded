/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

public final class ImageSaver$SaveError
extends Enum {
    private static final /* synthetic */ ImageSaver$SaveError[] $VALUES;
    public static final /* enum */ ImageSaver$SaveError CROP_FAILED;
    public static final /* enum */ ImageSaver$SaveError ENCODE_FAILED;
    public static final /* enum */ ImageSaver$SaveError FILE_IO_FAILED;
    public static final /* enum */ ImageSaver$SaveError UNKNOWN;

    static {
        ImageSaver$SaveError imageSaver$SaveError;
        ImageSaver$SaveError imageSaver$SaveError2;
        ImageSaver$SaveError imageSaver$SaveError3;
        ImageSaver$SaveError imageSaver$SaveError4;
        FILE_IO_FAILED = imageSaver$SaveError4 = new ImageSaver$SaveError("FILE_IO_FAILED", 0);
        int n10 = 1;
        ENCODE_FAILED = imageSaver$SaveError3 = new ImageSaver$SaveError("ENCODE_FAILED", n10);
        int n11 = 2;
        CROP_FAILED = imageSaver$SaveError2 = new ImageSaver$SaveError("CROP_FAILED", n11);
        int n12 = 3;
        UNKNOWN = imageSaver$SaveError = new ImageSaver$SaveError("UNKNOWN", n12);
        ImageSaver$SaveError[] imageSaver$SaveErrorArray = new ImageSaver$SaveError[4];
        imageSaver$SaveErrorArray[0] = imageSaver$SaveError4;
        imageSaver$SaveErrorArray[n10] = imageSaver$SaveError3;
        imageSaver$SaveErrorArray[n11] = imageSaver$SaveError2;
        imageSaver$SaveErrorArray[n12] = imageSaver$SaveError;
        $VALUES = imageSaver$SaveErrorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ImageSaver$SaveError() {
        void var2_-1;
        void var1_-1;
    }

    public static ImageSaver$SaveError valueOf(String string2) {
        return Enum.valueOf(ImageSaver$SaveError.class, string2);
    }

    public static ImageSaver$SaveError[] values() {
        return (ImageSaver$SaveError[])$VALUES.clone();
    }
}

