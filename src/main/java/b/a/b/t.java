/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ForwardingImageProxy$OnImageCloseListener;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy;
import androidx.camera.core.ImageProxy;

public final class t
implements ForwardingImageProxy$OnImageCloseListener {
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy a;

    public /* synthetic */ t(ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy imageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy) {
        this.a = imageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.a.h(imageProxy);
    }
}

