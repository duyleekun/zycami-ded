/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysis$Analyzer;
import androidx.camera.core.ImageProxy;

public final class q
implements ImageAnalysis$Analyzer {
    public final /* synthetic */ ImageAnalysis a;
    public final /* synthetic */ ImageAnalysis$Analyzer b;

    public /* synthetic */ q(ImageAnalysis imageAnalysis, ImageAnalysis$Analyzer imageAnalysis$Analyzer) {
        this.a = imageAnalysis;
        this.b = imageAnalysis$Analyzer;
    }

    public final void analyze(ImageProxy imageProxy) {
        ImageAnalysis imageAnalysis = this.a;
        ImageAnalysis$Analyzer imageAnalysis$Analyzer = this.b;
        imageAnalysis.d(imageAnalysis$Analyzer, imageProxy);
    }
}

