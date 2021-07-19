/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$1;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class ImageAnalysisNonBlockingAnalyzer
extends ImageAnalysisAbstractAnalyzer {
    public final Executor mBackgroundExecutor;
    public ImageProxy mCachedImage;
    private final Object mLock;
    private ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy mPostedImage;

    public ImageAnalysisNonBlockingAnalyzer(Executor executor) {
        Object object;
        this.mLock = object = new Object();
        this.mBackgroundExecutor = executor;
    }

    public ImageProxy acquireImage(ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireLatestImage();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void analyzeCachedImage() {
        Object object = this.mLock;
        synchronized (object) {
            Object var2_2 = null;
            this.mPostedImage = null;
            ImageProxy imageProxy = this.mCachedImage;
            if (imageProxy != null) {
                this.mCachedImage = null;
                this.onValidImageAvailable(imageProxy);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearCache() {
        Object object = this.mLock;
        synchronized (object) {
            ImageProxy imageProxy = this.mCachedImage;
            if (imageProxy != null) {
                imageProxy.close();
                imageProxy = null;
                this.mCachedImage = null;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onValidImageAvailable(ImageProxy object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            Object object3 = this.mIsAttached;
            if (object3 == 0) {
                object.close();
                return;
            }
            Object object4 = this.mPostedImage;
            if (object4 == null) {
                this.mPostedImage = object4 = new ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy((ImageProxy)object, this);
                object = this.analyzeImage((ImageProxy)object4);
                ImageAnalysisNonBlockingAnalyzer$1 imageAnalysisNonBlockingAnalyzer$1 = new ImageAnalysisNonBlockingAnalyzer$1(this, (ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy)object4);
                object4 = CameraXExecutors.directExecutor();
                Futures.addCallback((ListenableFuture)object, imageAnalysisNonBlockingAnalyzer$1, (Executor)object4);
                return;
            }
            object4 = object.getImageInfo();
            long l10 = object4.getTimestamp();
            Object object5 = this.mPostedImage;
            long l11 = (object5 = ((ForwardingImageProxy)object5).getImageInfo()).getTimestamp();
            long l12 = l10 - l11;
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 <= 0) {
                object.close();
            } else {
                object4 = this.mCachedImage;
                if (object4 != null) {
                    object4.close();
                }
                this.mCachedImage = object;
            }
            return;
        }
    }
}

