/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ForwardingImageProxy$OnImageCloseListener;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.ImageProxy;
import b.a.b.t;
import b.a.b.v1;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;

public class ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy
extends ForwardingImageProxy {
    public final WeakReference mNonBlockingAnalyzerWeakReference;

    public ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy(ImageProxy object, ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
        super((ImageProxy)object);
        object = new WeakReference(imageAnalysisNonBlockingAnalyzer);
        this.mNonBlockingAnalyzerWeakReference = object;
        object = new t(this);
        this.addOnImageCloseListener((ForwardingImageProxy$OnImageCloseListener)object);
    }

    private /* synthetic */ void a(ImageProxy object) {
        object = (ImageAnalysisNonBlockingAnalyzer)this.mNonBlockingAnalyzerWeakReference.get();
        if (object != null) {
            Executor executor = ((ImageAnalysisNonBlockingAnalyzer)object).mBackgroundExecutor;
            Objects.requireNonNull(object);
            v1 v12 = new v1((ImageAnalysisNonBlockingAnalyzer)object);
            executor.execute(v12);
        }
    }

    public /* synthetic */ void h(ImageProxy imageProxy) {
        this.a(imageProxy);
    }
}

