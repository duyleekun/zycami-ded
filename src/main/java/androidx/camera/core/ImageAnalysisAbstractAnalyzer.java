/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysis$Analyzer;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.os.OperationCanceledException;
import b.a.b.r;
import b.a.b.s;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public abstract class ImageAnalysisAbstractAnalyzer
implements ImageReaderProxy$OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private final Object mAnalyzerLock;
    public boolean mIsAttached;
    private volatile int mRelativeRotation;
    private ImageAnalysis$Analyzer mSubscribedAnalyzer;
    private Executor mUserExecutor;

    public ImageAnalysisAbstractAnalyzer() {
        Object object;
        this.mAnalyzerLock = object = new Object();
        this.mIsAttached = true;
    }

    private /* synthetic */ void a(ImageProxy object, ImageAnalysis$Analyzer object2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        boolean bl2 = this.mIsAttached;
        if (bl2) {
            Object object3 = object.getImageInfo().getTagBundle();
            long l10 = object.getImageInfo().getTimestamp();
            int n10 = this.mRelativeRotation;
            object3 = ImmutableImageInfo.create((TagBundle)object3, l10, n10);
            SettableImageProxy settableImageProxy = new SettableImageProxy((ImageProxy)object, (ImageInfo)object3);
            object2.analyze(settableImageProxy);
            object = null;
            callbackToFutureAdapter$Completer.set(null);
        } else {
            object2 = "ImageAnalysis is detached";
            object = new OperationCanceledException((String)object2);
            callbackToFutureAdapter$Completer.setException((Throwable)object);
        }
    }

    private /* synthetic */ Object c(Executor executor, ImageProxy imageProxy, ImageAnalysis$Analyzer imageAnalysis$Analyzer, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        r r10 = new r(this, imageProxy, imageAnalysis$Analyzer, callbackToFutureAdapter$Completer);
        executor.execute(r10);
        return "analyzeImage";
    }

    public abstract ImageProxy acquireImage(ImageReaderProxy var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public ListenableFuture analyzeImage(ImageProxy object) {
        Object object2 = this.mAnalyzerLock;
        // MONITORENTER : object2
        Executor executor = this.mUserExecutor;
        ImageAnalysis$Analyzer imageAnalysis$Analyzer = this.mSubscribedAnalyzer;
        // MONITOREXIT : object2
        if (imageAnalysis$Analyzer != null && executor != null) {
            object2 = new s(this, executor, (ImageProxy)object, imageAnalysis$Analyzer);
            return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object2);
        }
        object2 = "No analyzer or executor currently set.";
        object = new OperationCanceledException((String)object2);
        return Futures.immediateFailedFuture((Throwable)object);
    }

    public void attach() {
        this.mIsAttached = true;
    }

    public /* synthetic */ void b(ImageProxy imageProxy, ImageAnalysis$Analyzer imageAnalysis$Analyzer, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a(imageProxy, imageAnalysis$Analyzer, callbackToFutureAdapter$Completer);
    }

    public abstract void clearCache();

    public /* synthetic */ Object d(Executor executor, ImageProxy imageProxy, ImageAnalysis$Analyzer imageAnalysis$Analyzer, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.c(executor, imageProxy, imageAnalysis$Analyzer, callbackToFutureAdapter$Completer);
    }

    public void detach() {
        this.mIsAttached = false;
        this.clearCache();
    }

    public void onImageAvailable(ImageReaderProxy object) {
        block3: {
            object = this.acquireImage((ImageReaderProxy)object);
            if (object == null) break block3;
            try {
                this.onValidImageAvailable((ImageProxy)object);
            }
            catch (IllegalStateException illegalStateException) {
                String string2 = "ImageAnalysisAnalyzer";
                String string3 = "Failed to acquire image.";
                Logger.e(string2, string3, illegalStateException);
            }
        }
    }

    public abstract void onValidImageAvailable(ImageProxy var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setAnalyzer(Executor executor, ImageAnalysis$Analyzer imageAnalysis$Analyzer) {
        Object object = this.mAnalyzerLock;
        synchronized (object) {
            if (imageAnalysis$Analyzer == null) {
                this.clearCache();
            }
            this.mSubscribedAnalyzer = imageAnalysis$Analyzer;
            this.mUserExecutor = executor;
            return;
        }
    }

    public void setRelativeRotation(int n10) {
        this.mRelativeRotation = n10;
    }
}

