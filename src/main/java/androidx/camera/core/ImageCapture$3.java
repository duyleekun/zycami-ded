/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$OnImageCapturedCallback;
import androidx.camera.core.ImageCapture$OnImageSavedCallback;
import androidx.camera.core.ImageCapture$OutputFileOptions;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageSaver;
import androidx.camera.core.ImageSaver$OnImageSavedCallback;
import java.util.concurrent.Executor;

public class ImageCapture$3
extends ImageCapture$OnImageCapturedCallback {
    public final /* synthetic */ ImageCapture this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ ImageCapture$OnImageSavedCallback val$imageSavedCallback;
    public final /* synthetic */ ImageSaver$OnImageSavedCallback val$imageSavedCallbackWrapper;
    public final /* synthetic */ ImageCapture$OutputFileOptions val$outputFileOptions;

    public ImageCapture$3(ImageCapture imageCapture, ImageCapture$OutputFileOptions imageCapture$OutputFileOptions, Executor executor, ImageSaver$OnImageSavedCallback imageSaver$OnImageSavedCallback, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        this.this$0 = imageCapture;
        this.val$outputFileOptions = imageCapture$OutputFileOptions;
        this.val$executor = executor;
        this.val$imageSavedCallbackWrapper = imageSaver$OnImageSavedCallback;
        this.val$imageSavedCallback = imageCapture$OnImageSavedCallback;
    }

    public void onCaptureSuccess(ImageProxy imageProxy) {
        Executor executor = this.this$0.mIoExecutor;
        ImageCapture$OutputFileOptions imageCapture$OutputFileOptions = this.val$outputFileOptions;
        int n10 = imageProxy.getImageInfo().getRotationDegrees();
        Executor executor2 = this.val$executor;
        Executor executor3 = this.this$0.mSequentialIoExecutor;
        ImageSaver$OnImageSavedCallback imageSaver$OnImageSavedCallback = this.val$imageSavedCallbackWrapper;
        ImageSaver imageSaver = new ImageSaver(imageProxy, imageCapture$OutputFileOptions, n10, executor2, executor3, imageSaver$OnImageSavedCallback);
        executor.execute(imageSaver);
    }

    public void onError(ImageCaptureException imageCaptureException) {
        this.val$imageSavedCallback.onError(imageCaptureException);
    }
}

