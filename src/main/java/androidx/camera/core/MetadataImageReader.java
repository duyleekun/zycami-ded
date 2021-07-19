/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.util.LongSparseArray
 *  android.view.Surface
 */
package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ForwardingImageProxy$OnImageCloseListener;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader$1;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import b.a.b.r0;
import b.a.b.s0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MetadataImageReader
implements ImageReaderProxy,
ForwardingImageProxy$OnImageCloseListener {
    private static final String TAG = "MetadataImageReader";
    private final List mAcquiredImageProxies;
    private CameraCaptureCallback mCameraCaptureCallback;
    private boolean mClosed;
    private Executor mExecutor;
    private int mImageProxiesIndex;
    private final ImageReaderProxy mImageReaderProxy;
    public ImageReaderProxy$OnImageAvailableListener mListener;
    private final Object mLock;
    private final List mMatchedImageProxies;
    private final LongSparseArray mPendingImageInfos;
    private final LongSparseArray mPendingImages;
    private ImageReaderProxy$OnImageAvailableListener mTransformedListener;

    public MetadataImageReader(int n10, int n11, int n12, int n13) {
        ImageReaderProxy imageReaderProxy = MetadataImageReader.createImageReaderProxy(n10, n11, n12, n13);
        this(imageReaderProxy);
    }

    public MetadataImageReader(ImageReaderProxy arrayList) {
        Object object;
        Object object2;
        this.mLock = object2 = new Object();
        this.mCameraCaptureCallback = object2 = new MetadataImageReader$1(this);
        this.mTransformedListener = object2 = new r0(this);
        this.mClosed = false;
        this.mPendingImageInfos = object = new LongSparseArray();
        this.mPendingImages = object = new LongSparseArray();
        this.mAcquiredImageProxies = object;
        this.mImageReaderProxy = arrayList;
        this.mImageProxiesIndex = 0;
        int n10 = this.getMaxImages();
        this.mMatchedImageProxies = arrayList = new ArrayList(n10);
    }

    private /* synthetic */ void a(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        imageReaderProxy$OnImageAvailableListener.onImageAvailable(this);
    }

    private /* synthetic */ void c(ImageReaderProxy imageReaderProxy) {
        this.imageIncoming(imageReaderProxy);
    }

    private static ImageReaderProxy createImageReaderProxy(int n10, int n11, int n12, int n13) {
        ImageReader imageReader = ImageReader.newInstance((int)n10, (int)n11, (int)n12, (int)n13);
        AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(imageReader);
        return androidImageReaderProxy;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void dequeImageProxy(ImageProxy imageProxy) {
        Object object = this.mLock;
        synchronized (object) {
            List list = this.mMatchedImageProxies;
            int n10 = list.indexOf(imageProxy);
            if (n10 >= 0) {
                List list2 = this.mMatchedImageProxies;
                list2.remove(n10);
                int n11 = this.mImageProxiesIndex;
                if (n10 <= n11) {
                    this.mImageProxiesIndex = n11 += -1;
                }
            }
            list = this.mAcquiredImageProxies;
            list.remove(imageProxy);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void enqueueImageProxy(SettableImageProxy object) {
        ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener;
        Object object2 = this.mLock;
        synchronized (object2) {
            Object object3 = this.mMatchedImageProxies;
            int n10 = object3.size();
            int n11 = this.getMaxImages();
            imageReaderProxy$OnImageAvailableListener = null;
            if (n10 < n11) {
                ((ForwardingImageProxy)object).addOnImageCloseListener(this);
                object3 = this.mMatchedImageProxies;
                object3.add(object);
                imageReaderProxy$OnImageAvailableListener = this.mListener;
                object = this.mExecutor;
            } else {
                object3 = "TAG";
                String string2 = "Maximum image number reached.";
                Logger.d((String)object3, string2);
                ((ForwardingImageProxy)object).close();
                object = null;
            }
        }
        if (imageReaderProxy$OnImageAvailableListener == null) return;
        if (object != null) {
            object2 = new s0(this, imageReaderProxy$OnImageAvailableListener);
            object.execute((Runnable)object2);
            return;
        }
        imageReaderProxy$OnImageAvailableListener.onImageAvailable(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void matchImages() {
        Object object = this.mLock;
        synchronized (object) {
            LongSparseArray longSparseArray = this.mPendingImageInfos;
            int n10 = longSparseArray.size() + -1;
            while (true) {
                if (n10 < 0) {
                    this.removeStaleData();
                    return;
                }
                Object object2 = this.mPendingImageInfos;
                object2 = object2.valueAt(n10);
                object2 = (ImageInfo)object2;
                long l10 = object2.getTimestamp();
                Object object3 = this.mPendingImages;
                object3 = object3.get(l10);
                if ((object3 = (ImageProxy)object3) != null) {
                    LongSparseArray longSparseArray2 = this.mPendingImages;
                    longSparseArray2.remove(l10);
                    Object object4 = this.mPendingImageInfos;
                    object4.removeAt(n10);
                    object4 = new SettableImageProxy((ImageProxy)object3, (ImageInfo)object2);
                    this.enqueueImageProxy((SettableImageProxy)object4);
                }
                n10 += -1;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void removeStaleData() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mPendingImages;
            int n10 = object2.size();
            if (n10 != 0 && (n10 = (object2 = this.mPendingImageInfos).size()) != 0) {
                object2 = this.mPendingImages;
                int n11 = 0;
                Object object3 = null;
                long l10 = object2.keyAt(0);
                object2 = l10;
                Object object4 = this.mPendingImageInfos;
                l10 = object4.keyAt(0);
                object4 = l10;
                boolean bl2 = ((Long)object4).equals(object2);
                int n12 = 1;
                if (!bl2) {
                    n11 = n12;
                }
                Preconditions.checkArgument(n11 != 0);
                long l11 = (Long)object4;
                long l12 = (Long)object2;
                n11 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                if (n11 > 0) {
                    object2 = this.mPendingImages;
                    for (n10 = object2.size() - n12; n10 >= 0; n10 += -1) {
                        object3 = this.mPendingImages;
                        long l13 = object3.keyAt(n10);
                        long l14 = l13 - (l11 = ((Long)object4).longValue());
                        n11 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                        if (n11 >= 0) continue;
                        object3 = this.mPendingImages;
                        object3 = object3.valueAt(n10);
                        object3 = (ImageProxy)object3;
                        object3.close();
                        object3 = this.mPendingImages;
                        object3.removeAt(n10);
                    }
                } else {
                    object3 = this.mPendingImageInfos;
                    for (n11 = object3.size() - n12; n11 >= 0; n11 += -1) {
                        long l15;
                        object4 = this.mPendingImageInfos;
                        l10 = object4.keyAt(n11);
                        long l16 = l10 - (l15 = ((Long)object2).longValue());
                        Object object5 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                        if (object5 >= 0) continue;
                        object4 = this.mPendingImageInfos;
                        object4.removeAt(n11);
                    }
                }
                return;
            }
            return;
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
            Object object2;
            int n10;
            Object object3 = this.mMatchedImageProxies;
            int n11 = object3.isEmpty();
            if (n11 != 0) {
                return null;
            }
            n11 = this.mImageProxiesIndex;
            Object object4 = this.mMatchedImageProxies;
            int n12 = object4.size();
            if (n11 >= n12) {
                object4 = "Maximum image number reached.";
                object3 = new IllegalStateException((String)object4);
                throw object3;
            }
            object3 = new ArrayList();
            object4 = null;
            for (n12 = 0; n12 < (n10 = (object2 = this.mMatchedImageProxies).size() + -1); ++n12) {
                object2 = this.mAcquiredImageProxies;
                List list = this.mMatchedImageProxies;
                n10 = (int)(object2.contains(list = list.get(n12)) ? 1 : 0);
                if (n10 != 0) continue;
                object2 = this.mMatchedImageProxies;
                object2 = object2.get(n12);
                object2 = (ImageProxy)object2;
                object3.add(object2);
            }
            object3 = object3.iterator();
            while (true) {
                if ((n12 = (int)(object3.hasNext() ? 1 : 0)) == 0) {
                    object3 = this.mMatchedImageProxies;
                    this.mImageProxiesIndex = n11 = object3.size() + -1;
                    object4 = this.mMatchedImageProxies;
                    this.mImageProxiesIndex = n10 = n11 + 1;
                    object3 = object4.get(n11);
                    object3 = (ImageProxy)object3;
                    object4 = this.mAcquiredImageProxies;
                    object4.add(object3);
                    return object3;
                }
                object4 = object3.next();
                object4 = (ImageProxy)object4;
                object4.close();
            }
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
            Object object2 = this.mMatchedImageProxies;
            int n10 = object2.isEmpty();
            if (n10 != 0) {
                return null;
            }
            n10 = this.mImageProxiesIndex;
            Object object3 = this.mMatchedImageProxies;
            int n11 = object3.size();
            if (n10 < n11) {
                int n12;
                object2 = this.mMatchedImageProxies;
                n11 = this.mImageProxiesIndex;
                this.mImageProxiesIndex = n12 = n11 + 1;
                object2 = object2.get(n11);
                object2 = (ImageProxy)object2;
                object3 = this.mAcquiredImageProxies;
                object3.add(object2);
                return object2;
            }
            object3 = "Maximum image number reached.";
            object2 = new IllegalStateException((String)object3);
            throw object2;
        }
    }

    public /* synthetic */ void b(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        this.a(imageReaderProxy$OnImageAvailableListener);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearOnImageAvailableListener() {
        Object object = this.mLock;
        synchronized (object) {
            Object var2_2 = null;
            this.mListener = null;
            this.mExecutor = null;
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
            Object object2 = this.mMatchedImageProxies;
            Object object3 = new ArrayList(object2);
            object3 = object3.iterator();
            while (true) {
                boolean bl3;
                if (!(bl3 = object3.hasNext())) {
                    object3 = this.mMatchedImageProxies;
                    object3.clear();
                    object3 = this.mImageReaderProxy;
                    object3.close();
                    this.mClosed = bl2 = true;
                    return;
                }
                object2 = object3.next();
                object2 = (ImageProxy)object2;
                object2.close();
            }
        }
    }

    public /* synthetic */ void d(ImageReaderProxy imageReaderProxy) {
        this.c(imageReaderProxy);
    }

    public CameraCaptureCallback getCameraCaptureCallback() {
        return this.mCameraCaptureCallback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getHeight() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getHeight();
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
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
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
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getMaxImages();
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
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getSurface();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getWidth() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getWidth();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void imageIncoming(ImageReaderProxy imageReaderProxy) {
        Object object = this.mLock;
        synchronized (object) {
            int n10;
            int n11 = this.mClosed;
            if (n11 != 0) {
                return;
            }
            n11 = 0;
            do {
                ImageProxy imageProxy;
                block10: {
                    Object object2;
                    n10 = 0;
                    imageProxy = null;
                    imageProxy = imageReaderProxy.acquireNextImage();
                    if (imageProxy == null) break block10;
                    ++n11;
                    LongSparseArray longSparseArray = this.mPendingImages;
                    {
                        catch (Throwable throwable) {
                            throw throwable;
                        }
                        catch (IllegalStateException illegalStateException) {}
                        object2 = TAG;
                        String string2 = "Failed to acquire next image.";
                        {
                            Logger.d((String)object2, string2, illegalStateException);
                            break block10;
                        }
                    }
                    object2 = imageProxy.getImageInfo();
                    long l10 = object2.getTimestamp();
                    longSparseArray.put(l10, (Object)imageProxy);
                    this.matchImages();
                }
                if (imageProxy == null) return;
            } while (n11 < (n10 = imageReaderProxy.getMaxImages()));
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onImageClose(ImageProxy imageProxy) {
        Object object = this.mLock;
        synchronized (object) {
            this.dequeImageProxy(imageProxy);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resultIncoming(CameraCaptureResult cameraCaptureResult) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mClosed;
            if (bl2) {
                return;
            }
            LongSparseArray longSparseArray = this.mPendingImageInfos;
            long l10 = cameraCaptureResult.getTimestamp();
            CameraCaptureResultImageInfo cameraCaptureResultImageInfo = new CameraCaptureResultImageInfo(cameraCaptureResult);
            longSparseArray.put(l10, (Object)cameraCaptureResultImageInfo);
            this.matchImages();
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
            object = this.mImageReaderProxy;
            ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener = this.mTransformedListener;
            object.setOnImageAvailableListener(imageReaderProxy$OnImageAvailableListener, executor);
            return;
        }
    }
}

