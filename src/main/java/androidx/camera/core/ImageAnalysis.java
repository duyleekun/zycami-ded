/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageAnalysis$Analyzer;
import androidx.camera.core.ImageAnalysis$Builder;
import androidx.camera.core.ImageAnalysis$Defaults;
import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageAnalysisBlockingAnalyzer;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.SessionConfig$SessionError;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfig$Builder;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import b.a.b.p;
import b.a.b.q;
import b.a.b.u1;
import java.util.concurrent.Executor;

public final class ImageAnalysis
extends UseCase {
    private static final int DEFAULT_BACKPRESSURE_STRATEGY = 0;
    public static final ImageAnalysis$Defaults DEFAULT_CONFIG;
    private static final int DEFAULT_IMAGE_QUEUE_DEPTH = 6;
    private static final int NON_BLOCKING_IMAGE_DEPTH = 4;
    public static final int STRATEGY_BLOCK_PRODUCER = 1;
    public static final int STRATEGY_KEEP_ONLY_LATEST = 0;
    private static final String TAG = "ImageAnalysis";
    private final Object mAnalysisLock;
    private DeferrableSurface mDeferrableSurface;
    public final ImageAnalysisAbstractAnalyzer mImageAnalysisAbstractAnalyzer;
    private ImageAnalysis$Analyzer mSubscribedAnalyzer;

    static {
        ImageAnalysis$Defaults imageAnalysis$Defaults;
        DEFAULT_CONFIG = imageAnalysis$Defaults = new ImageAnalysis$Defaults();
    }

    public ImageAnalysis(ImageAnalysisConfig object) {
        super((UseCaseConfig)object);
        Object object2;
        this.mAnalysisLock = object2 = new Object();
        object2 = (ImageAnalysisConfig)this.getCurrentConfig();
        Executor executor = null;
        int n10 = ((ImageAnalysisConfig)object2).getBackpressureStrategy(0);
        int n11 = 1;
        if (n10 == n11) {
            this.mImageAnalysisAbstractAnalyzer = object = new ImageAnalysisBlockingAnalyzer();
        } else {
            executor = CameraXExecutors.highPriorityExecutor();
            object = object.getBackgroundExecutor(executor);
            this.mImageAnalysisAbstractAnalyzer = object2 = new ImageAnalysisNonBlockingAnalyzer((Executor)object);
        }
    }

    private /* synthetic */ void a(String object, ImageAnalysisConfig imageAnalysisConfig, Size size, SessionConfig object2, SessionConfig$SessionError sessionConfig$SessionError) {
        this.clearPipeline();
        object2 = this.mImageAnalysisAbstractAnalyzer;
        ((ImageAnalysisAbstractAnalyzer)object2).clearCache();
        boolean bl2 = this.isCurrentCamera((String)object);
        if (bl2) {
            object = this.createPipeline((String)object, imageAnalysisConfig, size).build();
            this.updateSessionConfig((SessionConfig)object);
            this.notifyReset();
        }
    }

    private /* synthetic */ void c(ImageAnalysis$Analyzer imageAnalysis$Analyzer, ImageProxy imageProxy) {
        Rect rect = this.getViewPortCropRect();
        if (rect != null) {
            rect = this.getViewPortCropRect();
            imageProxy.setCropRect(rect);
        }
        imageAnalysis$Analyzer.analyze(imageProxy);
    }

    private void tryUpdateRelativeRotation() {
        CameraInternal cameraInternal = this.getCamera();
        if (cameraInternal != null) {
            ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
            int n10 = this.getRelativeRotation(cameraInternal);
            imageAnalysisAbstractAnalyzer.setRelativeRotation(n10);
        }
    }

    public /* synthetic */ void b(String string2, ImageAnalysisConfig imageAnalysisConfig, Size size, SessionConfig sessionConfig, SessionConfig$SessionError sessionConfig$SessionError) {
        this.a(string2, imageAnalysisConfig, size, sessionConfig, sessionConfig$SessionError);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearAnalyzer() {
        Object object = this.mAnalysisLock;
        synchronized (object) {
            Object object2 = this.mImageAnalysisAbstractAnalyzer;
            ((ImageAnalysisAbstractAnalyzer)object2).setAnalyzer(null, null);
            object2 = this.mSubscribedAnalyzer;
            if (object2 != null) {
                this.notifyInactive();
            }
            this.mSubscribedAnalyzer = null;
            return;
        }
    }

    public void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
            deferrableSurface = null;
            this.mDeferrableSurface = null;
        }
    }

    public SessionConfig$Builder createPipeline(String string2, ImageAnalysisConfig imageAnalysisConfig, Size size) {
        Object object;
        Threads.checkMainThread();
        Object object2 = CameraXExecutors.highPriorityExecutor();
        object2 = (Executor)Preconditions.checkNotNull(imageAnalysisConfig.getBackgroundExecutor((Executor)object2));
        int n10 = this.getBackpressureStrategy();
        int n11 = 1;
        n10 = n10 == n11 ? this.getImageQueueDepth() : 4;
        Object object3 = imageAnalysisConfig.getImageReaderProxyProvider();
        if (object3 != null) {
            object = imageAnalysisConfig.getImageReaderProxyProvider();
            int n12 = size.getWidth();
            int n13 = size.getHeight();
            int n14 = this.getImageFormat();
            long l10 = 0L;
            object = object.newInstance(n12, n13, n14, n10, l10);
            object3 = new SafeCloseImageReaderProxy((ImageReaderProxy)object);
        } else {
            n11 = size.getWidth();
            int n15 = size.getHeight();
            int n16 = this.getImageFormat();
            object = ImageReaderProxys.createIsolatedReader(n11, n15, n16, n10);
            object3 = new SafeCloseImageReaderProxy((ImageReaderProxy)object);
        }
        this.tryUpdateRelativeRotation();
        object = this.mImageAnalysisAbstractAnalyzer;
        ((SafeCloseImageReaderProxy)object3).setOnImageAvailableListener((ImageReaderProxy$OnImageAvailableListener)object, (Executor)object2);
        object2 = SessionConfig$Builder.createFrom(imageAnalysisConfig);
        object = this.mDeferrableSurface;
        if (object != null) {
            ((DeferrableSurface)object).close();
        }
        Object object4 = ((SafeCloseImageReaderProxy)object3).getSurface();
        this.mDeferrableSurface = object = new ImmediateSurface((Surface)object4);
        object = ((DeferrableSurface)object).getTerminationFuture();
        object4 = new u1((SafeCloseImageReaderProxy)object3);
        object3 = CameraXExecutors.mainThreadExecutor();
        object.addListener((Runnable)object4, (Executor)object3);
        object3 = this.mDeferrableSurface;
        ((SessionConfig$Builder)object2).addSurface((DeferrableSurface)object3);
        object3 = new p(this, string2, imageAnalysisConfig, size);
        ((SessionConfig$Builder)object2).addErrorListener((SessionConfig$ErrorListener)object3);
        return object2;
    }

    public /* synthetic */ void d(ImageAnalysis$Analyzer imageAnalysis$Analyzer, ImageProxy imageProxy) {
        this.c(imageAnalysis$Analyzer, imageProxy);
    }

    public int getBackpressureStrategy() {
        return ((ImageAnalysisConfig)this.getCurrentConfig()).getBackpressureStrategy(0);
    }

    public UseCaseConfig getDefaultConfig(boolean bl2, UseCaseConfigFactory object) {
        Config config;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.IMAGE_ANALYSIS;
        object = object.getConfig(useCaseConfigFactory$CaptureType);
        if (bl2) {
            config = DEFAULT_CONFIG.getConfig();
            object = Config.mergeConfigs((Config)object, config);
        }
        if (object == null) {
            bl2 = false;
            config = null;
        } else {
            config = this.getUseCaseConfigBuilder((Config)object).getUseCaseConfig();
        }
        return config;
    }

    public int getImageQueueDepth() {
        return ((ImageAnalysisConfig)this.getCurrentConfig()).getImageQueueDepth(6);
    }

    public int getTargetRotation() {
        return this.getTargetRotationInternal();
    }

    public UseCaseConfig$Builder getUseCaseConfigBuilder(Config config) {
        return ImageAnalysis$Builder.fromConfig(config);
    }

    public void onAttached() {
        this.mImageAnalysisAbstractAnalyzer.attach();
    }

    public void onDetached() {
        this.clearPipeline();
        this.mImageAnalysisAbstractAnalyzer.detach();
    }

    public Size onSuggestedResolutionUpdated(Size size) {
        Object object = (ImageAnalysisConfig)this.getCurrentConfig();
        String string2 = this.getCameraId();
        object = this.createPipeline(string2, (ImageAnalysisConfig)object, size).build();
        this.updateSessionConfig((SessionConfig)object);
        return size;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setAnalyzer(Executor object, ImageAnalysis$Analyzer imageAnalysis$Analyzer) {
        Object object2 = this.mAnalysisLock;
        synchronized (object2) {
            ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
            q q10 = new q(this, imageAnalysis$Analyzer);
            imageAnalysisAbstractAnalyzer.setAnalyzer((Executor)object, q10);
            object = this.mSubscribedAnalyzer;
            if (object == null) {
                this.notifyActive();
            }
            this.mSubscribedAnalyzer = imageAnalysis$Analyzer;
            return;
        }
    }

    public void setTargetRotation(int n10) {
        if ((n10 = (int)(this.setTargetRotationInternal(n10) ? 1 : 0)) != 0) {
            this.tryUpdateRelativeRotation();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImageAnalysis:");
        String string2 = this.getName();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

