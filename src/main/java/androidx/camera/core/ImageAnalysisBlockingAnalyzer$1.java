/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysisBlockingAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.futures.FutureCallback;

public class ImageAnalysisBlockingAnalyzer$1
implements FutureCallback {
    public final /* synthetic */ ImageAnalysisBlockingAnalyzer this$0;
    public final /* synthetic */ ImageProxy val$imageProxy;

    public ImageAnalysisBlockingAnalyzer$1(ImageAnalysisBlockingAnalyzer imageAnalysisBlockingAnalyzer, ImageProxy imageProxy) {
        this.this$0 = imageAnalysisBlockingAnalyzer;
        this.val$imageProxy = imageProxy;
    }

    public void onFailure(Throwable throwable) {
        this.val$imageProxy.close();
    }

    public void onSuccess(Void void_) {
    }
}

