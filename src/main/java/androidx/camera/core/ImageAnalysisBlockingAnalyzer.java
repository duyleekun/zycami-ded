/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageAnalysisBlockingAnalyzer$1;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class ImageAnalysisBlockingAnalyzer
extends ImageAnalysisAbstractAnalyzer {
    public ImageProxy acquireImage(ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireNextImage();
    }

    public void clearCache() {
    }

    public void onValidImageAvailable(ImageProxy object) {
        ListenableFuture listenableFuture = this.analyzeImage((ImageProxy)object);
        ImageAnalysisBlockingAnalyzer$1 imageAnalysisBlockingAnalyzer$1 = new ImageAnalysisBlockingAnalyzer$1(this, (ImageProxy)object);
        object = CameraXExecutors.directExecutor();
        Futures.addCallback(listenableFuture, imageAnalysisBlockingAnalyzer$1, (Executor)object);
    }
}

