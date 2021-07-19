/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$TakePictureState;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class ImageCapture$4
implements FutureCallback {
    public final /* synthetic */ ImageCapture this$0;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;
    public final /* synthetic */ ImageCapture$TakePictureState val$state;

    public ImageCapture$4(ImageCapture imageCapture, ImageCapture$TakePictureState imageCapture$TakePictureState, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.this$0 = imageCapture;
        this.val$state = imageCapture$TakePictureState;
        this.val$completer = callbackToFutureAdapter$Completer;
    }

    public void onFailure(Throwable throwable) {
        ImageCapture imageCapture = this.this$0;
        ImageCapture$TakePictureState imageCapture$TakePictureState = this.val$state;
        imageCapture.postTakePicture(imageCapture$TakePictureState);
        this.val$completer.setException(throwable);
    }

    public void onSuccess(Void object) {
        object = this.this$0;
        ImageCapture$TakePictureState imageCapture$TakePictureState = this.val$state;
        ((ImageCapture)object).postTakePicture(imageCapture$TakePictureState);
    }
}

