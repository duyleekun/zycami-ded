/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.ProcessingImageReader$1;
import androidx.camera.core.ProcessingImageReader$2;
import androidx.camera.core.ProcessingImageReader$3;
import androidx.camera.core.SettableImageProxyBundle;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.b.x0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class ProcessingImageReader
implements ImageReaderProxy {
    private static final String TAG = "ProcessingImageReader";
    private final List mCaptureIdList;
    public final CaptureProcessor mCaptureProcessor;
    private FutureCallback mCaptureStageReadyCallback;
    public CallbackToFutureAdapter$Completer mCloseCompleter;
    private ListenableFuture mCloseFuture;
    public boolean mClosed;
    public Executor mExecutor;
    private ImageReaderProxy$OnImageAvailableListener mImageProcessedListener;
    public final MetadataImageReader mInputImageReader;
    public ImageReaderProxy$OnImageAvailableListener mListener;
    public final Object mLock;
    public final ImageReaderProxy mOutputImageReader;
    public final Executor mPostProcessExecutor;
    public boolean mProcessing;
    public SettableImageProxyBundle mSettableImageProxyBundle;
    private String mTagBundleKey;
    private ImageReaderProxy$OnImageAvailableListener mTransformedListener;

    public ProcessingImageReader(int n10, int n11, int n12, int n13, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        this(n10, n11, n12, n13, executor, captureBundle, captureProcessor, n12);
    }

    public ProcessingImageReader(int n10, int n11, int n12, int n13, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor, int n14) {
        MetadataImageReader metadataImageReader = new MetadataImageReader(n10, n11, n12, n13);
        this(metadataImageReader, executor, captureBundle, captureProcessor, n14);
    }

    public ProcessingImageReader(MetadataImageReader metadataImageReader, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        int n10 = metadataImageReader.getImageFormat();
        this(metadataImageReader, executor, captureBundle, captureProcessor, n10);
    }

    public ProcessingImageReader(MetadataImageReader object, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor, int n10) {
        ImageReader imageReader = new Object();
        this.mLock = imageReader;
        imageReader = new ProcessingImageReader$1(this);
        this.mTransformedListener = imageReader;
        imageReader = new ProcessingImageReader$2(this);
        this.mImageProcessedListener = imageReader;
        imageReader = new ProcessingImageReader$3(this);
        this.mCaptureStageReadyCallback = imageReader;
        this.mClosed = false;
        this.mProcessing = false;
        imageReader = new String();
        this.mTagBundleKey = imageReader;
        List list = Collections.emptyList();
        Object object2 = this.mTagBundleKey;
        imageReader = new SettableImageProxyBundle(list, (String)object2);
        this.mSettableImageProxyBundle = imageReader;
        this.mCaptureIdList = imageReader = new ArrayList();
        int n11 = ((MetadataImageReader)object).getMaxImages();
        list = captureBundle.getCaptureStages();
        int n12 = list.size();
        if (n11 >= n12) {
            this.mInputImageReader = object;
            n11 = ((MetadataImageReader)object).getWidth();
            n12 = ((MetadataImageReader)object).getHeight();
            int n13 = 256;
            if (n10 == n13) {
                n11 = ((MetadataImageReader)object).getWidth();
                n12 = ((MetadataImageReader)object).getHeight();
                n11 *= n12;
                n12 = 1;
            }
            int n14 = ((MetadataImageReader)object).getMaxImages();
            imageReader = ImageReader.newInstance((int)n11, (int)n12, (int)n10, (int)n14);
            this.mOutputImageReader = object2 = new AndroidImageReaderProxy(imageReader);
            this.mPostProcessExecutor = executor;
            this.mCaptureProcessor = captureProcessor;
            executor = object2.getSurface();
            captureProcessor.onOutputSurface((Surface)executor, n10);
            n10 = ((MetadataImageReader)object).getWidth();
            int n15 = ((MetadataImageReader)object).getHeight();
            super(n10, n15);
            captureProcessor.onResolutionUpdate((Size)executor);
            this.setCaptureBundle(captureBundle);
            return;
        }
        object = new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ Object a(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object = this.mLock;
        synchronized (object) {
            this.mCloseCompleter = callbackToFutureAdapter$Completer;
            return "ProcessingImageReader-close";
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImageProxy acquireLatestImage() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mOutputImageReader;
            return imageReaderProxy.acquireLatestImage();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImageProxy acquireNextImage() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mOutputImageReader;
            return imageReaderProxy.acquireNextImage();
        }
    }

    public /* synthetic */ Object b(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a(callbackToFutureAdapter$Completer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearOnImageAvailableListener() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = false;
            Object object2 = null;
            this.mListener = null;
            this.mExecutor = null;
            object2 = this.mInputImageReader;
            ((MetadataImageReader)object2).clearOnImageAvailableListener();
            object2 = this.mOutputImageReader;
            object2.clearOnImageAvailableListener();
            bl2 = this.mProcessing;
            if (!bl2) {
                object2 = this.mSettableImageProxyBundle;
                ((SettableImageProxyBundle)object2).close();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mClosed;
            if (bl2) {
                return;
            }
            Object object2 = this.mOutputImageReader;
            object2.clearOnImageAvailableListener();
            bl2 = this.mProcessing;
            if (!bl2) {
                object2 = this.mInputImageReader;
                ((MetadataImageReader)object2).close();
                object2 = this.mSettableImageProxyBundle;
                ((SettableImageProxyBundle)object2).close();
                object2 = this.mOutputImageReader;
                object2.close();
                object2 = this.mCloseCompleter;
                if (object2 != null) {
                    ((CallbackToFutureAdapter$Completer)object2).set(null);
                }
            }
            this.mClosed = bl2 = true;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraCaptureCallback getCameraCaptureCallback() {
        Object object = this.mLock;
        synchronized (object) {
            MetadataImageReader metadataImageReader = this.mInputImageReader;
            return metadataImageReader.getCameraCaptureCallback();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture getCloseFuture() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2;
            boolean bl2 = this.mClosed;
            if (bl2 && !(bl2 = this.mProcessing)) {
                bl2 = false;
                object2 = null;
                return Futures.immediateFuture(null);
            }
            object2 = this.mCloseFuture;
            if (object2 == null) {
                object2 = new x0(this);
                this.mCloseFuture = object2 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object2);
            }
            object2 = this.mCloseFuture;
            return Futures.nonCancellationPropagating((ListenableFuture)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getHeight() {
        Object object = this.mLock;
        synchronized (object) {
            MetadataImageReader metadataImageReader = this.mInputImageReader;
            return metadataImageReader.getHeight();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getImageFormat() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mOutputImageReader;
            return imageReaderProxy.getImageFormat();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getMaxImages() {
        Object object = this.mLock;
        synchronized (object) {
            MetadataImageReader metadataImageReader = this.mInputImageReader;
            return metadataImageReader.getMaxImages();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Surface getSurface() {
        Object object = this.mLock;
        synchronized (object) {
            MetadataImageReader metadataImageReader = this.mInputImageReader;
            return metadataImageReader.getSurface();
        }
    }

    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getWidth() {
        Object object = this.mLock;
        synchronized (object) {
            MetadataImageReader metadataImageReader = this.mInputImageReader;
            return metadataImageReader.getWidth();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void imageIncoming(ImageReaderProxy object) {
        Object object2 = this.mLock;
        // MONITORENTER : object2
        boolean bl2 = this.mClosed;
        if (bl2) {
            // MONITOREXIT : object2
            return;
        }
        object = object.acquireNextImage();
        if (object == null) return;
        Object object3 = object.getImageInfo();
        object3 = object3.getTagBundle();
        Object object4 = this.mTagBundleKey;
        object4 = this.mCaptureIdList;
        boolean bl3 = object4.contains(object3 = ((TagBundle)object3).getTag((String)object4));
        if (!bl3) {
            object4 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "ImageProxyBundle does not contain this id: ";
            stringBuilder.append(string2);
            stringBuilder.append(object3);
            object3 = stringBuilder.toString();
            Logger.w((String)object4, (String)object3);
            object.close();
            return;
        }
        object3 = this.mSettableImageProxyBundle;
        ((SettableImageProxyBundle)object3).addImageProxy((ImageProxy)object);
        return;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (IllegalStateException illegalStateException) {}
            String string3 = TAG;
            String string4 = "Failed to acquire latest image.";
            {
                Logger.e(string3, string4, illegalStateException);
                // MONITOREXIT : object2
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setCaptureBundle(CaptureBundle object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object.getCaptureStages();
            if (object4 != null) {
                int n10;
                object4 = this.mInputImageReader;
                int n11 = ((MetadataImageReader)object4).getMaxImages();
                if (n11 < (n10 = (object3 = object.getCaptureStages()).size())) {
                    object4 = "CaptureBundle is larger than InputImageReader.";
                    object = new IllegalArgumentException((String)object4);
                    throw object;
                }
                object4 = this.mCaptureIdList;
                object4.clear();
                object4 = object.getCaptureStages();
                object4 = object4.iterator();
                while ((n10 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                    object3 = object4.next();
                    if ((object3 = (CaptureStage)object3) == null) continue;
                    List list = this.mCaptureIdList;
                    n10 = object3.getId();
                    object3 = n10;
                    list.add(object3);
                }
            }
            int n12 = object.hashCode();
            this.mTagBundleKey = object = Integer.toString(n12);
            object3 = this.mCaptureIdList;
            object4 = new Object((List)object3, (String)object);
            this.mSettableImageProxyBundle = object4;
            this.setupSettableImageProxyBundleCallbacks();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setOnImageAvailableListener(ImageReaderProxy$OnImageAvailableListener object, Executor executor) {
        Object object2 = this.mLock;
        synchronized (object2) {
            object = Preconditions.checkNotNull(object);
            this.mListener = object = (ImageReaderProxy$OnImageAvailableListener)object;
            object = Preconditions.checkNotNull(executor);
            this.mExecutor = object = (Executor)object;
            object = this.mInputImageReader;
            ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener = this.mTransformedListener;
            ((MetadataImageReader)object).setOnImageAvailableListener(imageReaderProxy$OnImageAvailableListener, executor);
            object = this.mOutputImageReader;
            imageReaderProxy$OnImageAvailableListener = this.mImageProcessedListener;
            object.setOnImageAvailableListener(imageReaderProxy$OnImageAvailableListener, executor);
            return;
        }
    }

    public void setupSettableImageProxyBundleCallbacks() {
        Object object;
        int n10;
        Object object2 = new ArrayList();
        Object object3 = this.mCaptureIdList.iterator();
        while ((n10 = object3.hasNext()) != 0) {
            object = (Integer)object3.next();
            SettableImageProxyBundle settableImageProxyBundle = this.mSettableImageProxyBundle;
            n10 = (Integer)object;
            object = settableImageProxyBundle.getImageProxy(n10);
            object2.add(object);
        }
        object2 = Futures.allAsList(object2);
        object3 = this.mCaptureStageReadyCallback;
        object = this.mPostProcessExecutor;
        Futures.addCallback((ListenableFuture)object2, (FutureCallback)object3, (Executor)object);
    }
}

