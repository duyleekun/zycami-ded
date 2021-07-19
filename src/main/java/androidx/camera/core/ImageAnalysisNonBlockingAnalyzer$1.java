/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy;
import androidx.camera.core.impl.utils.futures.FutureCallback;

public class ImageAnalysisNonBlockingAnalyzer$1
implements FutureCallback {
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer this$0;
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy val$newPostedImage;

    public ImageAnalysisNonBlockingAnalyzer$1(ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer, ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy cacheAnalyzingImageProxy) {
        this.this$0 = imageAnalysisNonBlockingAnalyzer;
        this.val$newPostedImage = cacheAnalyzingImageProxy;
    }

    public void onFailure(Throwable throwable) {
        this.val$newPostedImage.close();
    }

    public void onSuccess(Void void_) {
    }
}

