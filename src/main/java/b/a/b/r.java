/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageAnalysis$Analyzer;
import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class r
implements Runnable {
    public final /* synthetic */ ImageAnalysisAbstractAnalyzer a;
    public final /* synthetic */ ImageProxy b;
    public final /* synthetic */ ImageAnalysis$Analyzer c;
    public final /* synthetic */ CallbackToFutureAdapter$Completer d;

    public /* synthetic */ r(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, ImageProxy imageProxy, ImageAnalysis$Analyzer imageAnalysis$Analyzer, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = imageAnalysisAbstractAnalyzer;
        this.b = imageProxy;
        this.c = imageAnalysis$Analyzer;
        this.d = callbackToFutureAdapter$Completer;
    }

    public final void run() {
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.a;
        ImageProxy imageProxy = this.b;
        ImageAnalysis$Analyzer imageAnalysis$Analyzer = this.c;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.d;
        imageAnalysisAbstractAnalyzer.b(imageProxy, imageAnalysis$Analyzer, callbackToFutureAdapter$Completer);
    }
}

