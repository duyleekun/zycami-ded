/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;

public final class v1
implements Runnable {
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer a;

    public /* synthetic */ v1(ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
        this.a = imageAnalysisNonBlockingAnalyzer;
    }

    public final void run() {
        this.a.analyzeCachedImage();
    }
}

