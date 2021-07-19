/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageAnalysis$Analyzer;
import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import java.util.concurrent.Executor;

public final class s
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ImageAnalysisAbstractAnalyzer a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ ImageProxy c;
    public final /* synthetic */ ImageAnalysis$Analyzer d;

    public /* synthetic */ s(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, Executor executor, ImageProxy imageProxy, ImageAnalysis$Analyzer imageAnalysis$Analyzer) {
        this.a = imageAnalysisAbstractAnalyzer;
        this.b = executor;
        this.c = imageProxy;
        this.d = imageAnalysis$Analyzer;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.a;
        Executor executor = this.b;
        ImageProxy imageProxy = this.c;
        ImageAnalysis$Analyzer imageAnalysis$Analyzer = this.d;
        return imageAnalysisAbstractAnalyzer.d(executor, imageProxy, imageAnalysis$Analyzer, callbackToFutureAdapter$Completer);
    }
}

