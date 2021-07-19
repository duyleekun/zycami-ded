/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$9;
import androidx.camera.core.ImageCapture$OnImageSavedCallback;
import androidx.camera.core.ImageCapture$OutputFileResults;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageSaver$OnImageSavedCallback;
import androidx.camera.core.ImageSaver$SaveError;

public class ImageCapture$2
implements ImageSaver$OnImageSavedCallback {
    public final /* synthetic */ ImageCapture this$0;
    public final /* synthetic */ ImageCapture$OnImageSavedCallback val$imageSavedCallback;

    public ImageCapture$2(ImageCapture imageCapture, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        this.this$0 = imageCapture;
        this.val$imageSavedCallback = imageCapture$OnImageSavedCallback;
    }

    public void onError(ImageSaver$SaveError object, String string2, Throwable throwable) {
        int[] nArray = ImageCapture$9.$SwitchMap$androidx$camera$core$ImageSaver$SaveError;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 0;
            nArray = null;
        }
        object = this.val$imageSavedCallback;
        ImageCaptureException imageCaptureException = new ImageCaptureException(n11, string2, throwable);
        object.onError(imageCaptureException);
    }

    public void onImageSaved(ImageCapture$OutputFileResults imageCapture$OutputFileResults) {
        this.val$imageSavedCallback.onImageSaved(imageCapture$OutputFileResults);
    }
}

