/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 *  android.media.Image
 *  android.media.Image$Plane
 *  android.media.ImageWriter
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.core.internal;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifData$Builder;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.camera.core.internal.YuvToJpegProcessor$ByteBufferOutputStream;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;

public class YuvToJpegProcessor
implements CaptureProcessor {
    private static final String TAG = "YuvToJpegProcessor";
    private static final Rect UNINITIALIZED_RECT;
    private boolean mClosed;
    private Rect mImageRect;
    private ImageWriter mImageWriter;
    private final Object mLock;
    private final int mMaxImages;
    private int mProcessingImages;
    private final int mQuality;

    static {
        Rect rect;
        UNINITIALIZED_RECT = rect = new Rect(0, 0, 0, 0);
    }

    public YuvToJpegProcessor(int n10, int n11) {
        Object object;
        this.mLock = object = new Object();
        this.mClosed = false;
        this.mProcessingImages = 0;
        object = UNINITIALIZED_RECT;
        this.mImageRect = object;
        this.mQuality = n10;
        this.mMaxImages = n11;
    }

    private static ExifData getExifData(ImageProxy imageProxy) {
        ExifData$Builder exifData$Builder = ExifData.builderForDevice();
        imageProxy.getImageInfo().populateExifData(exifData$Builder);
        int n10 = imageProxy.getWidth();
        exifData$Builder = exifData$Builder.setImageWidth(n10);
        int n11 = imageProxy.getHeight();
        return exifData$Builder.setImageHeight(n11).build();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Object object = this.mLock;
        synchronized (object) {
            int n10 = this.mClosed;
            if (n10 == 0) {
                String string2;
                this.mClosed = n10 = 1;
                n10 = this.mProcessingImages;
                if (n10 == 0 && (string2 = this.mImageWriter) != null) {
                    string2 = TAG;
                    String string3 = "No processing in progress. Closing immediately.";
                    Logger.d(string2, string3);
                    string2 = this.mImageWriter;
                    string2.close();
                } else {
                    string2 = TAG;
                    String string4 = "close() called while processing. Will close after completion.";
                    Logger.d(string2, string4);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onOutputSurface(Surface object, int n10) {
        Object object2;
        int n11 = 256;
        if (n10 == n11) {
            n11 = 1;
        } else {
            n11 = 0;
            object2 = null;
        }
        String string2 = "YuvToJpegProcessor only supports JPEG output format.";
        Preconditions.checkState(n11 != 0, string2);
        object2 = this.mLock;
        synchronized (object2) {
            int n12 = this.mClosed;
            if (n12 == 0) {
                string2 = this.mImageWriter;
                if (string2 != null) {
                    String string3 = "Output surface already set.";
                    object = new IllegalStateException(string3);
                    throw object;
                }
                n12 = this.mMaxImages;
                object = ImageWriterCompat.newInstance(object, n12, n10);
                this.mImageWriter = object;
            } else {
                object = TAG;
                String string4 = "Cannot set output surface. Processor is closed.";
                Logger.w((String)object, string4);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onResolutionUpdate(Size size) {
        Object object = this.mLock;
        synchronized (object) {
            Rect rect;
            int n10 = size.getWidth();
            int n11 = size.getHeight();
            this.mImageRect = rect = new Rect(0, 0, n10, n11);
            return;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void process(ImageProxyBundle imageProxyBundle) {
        CharSequence charSequence;
        Object object;
        Object object2;
        block70: {
            Image image;
            Object object3;
            int n10;
            int n11;
            int n12;
            int n13;
            YuvToJpegProcessor yuvToJpegProcessor;
            block71: {
                void var3_15;
                int n14;
                String string2;
                block66: {
                    Object object4;
                    block65: {
                        block68: {
                            block69: {
                                block67: {
                                    int n15;
                                    block64: {
                                        yuvToJpegProcessor = this;
                                        object2 = imageProxyBundle.getCaptureIds();
                                        n15 = object2.size();
                                        n13 = 0;
                                        string2 = null;
                                        n12 = 1;
                                        if (n15 == n12) {
                                            n15 = n12;
                                        } else {
                                            n15 = 0;
                                            object = null;
                                        }
                                        charSequence = new StringBuilder();
                                        String string3 = "Processing image bundle have single capture id, but found ";
                                        charSequence.append(string3);
                                        n11 = object2.size();
                                        charSequence.append(n11);
                                        charSequence = charSequence.toString();
                                        Preconditions.checkArgument(n15 != 0, charSequence);
                                        n10 = (Integer)object2.get(0);
                                        object = imageProxyBundle;
                                        object2 = imageProxyBundle.getImageProxy(n10);
                                        n15 = object2.isDone();
                                        Preconditions.checkArgument(n15 != 0);
                                        object = yuvToJpegProcessor.mLock;
                                        // MONITORENTER : object
                                        charSequence = yuvToJpegProcessor.mImageWriter;
                                        n11 = (int)(yuvToJpegProcessor.mClosed ? 1 : 0);
                                        if (n11 == 0) {
                                            n11 = n12;
                                        } else {
                                            n11 = 0;
                                            string3 = null;
                                        }
                                        object3 = yuvToJpegProcessor.mImageRect;
                                        if (n11 != 0) {
                                            yuvToJpegProcessor.mProcessingImages = n14 = yuvToJpegProcessor.mProcessingImages + n12;
                                        }
                                        // MONITOREXIT : object
                                        n15 = 0;
                                        object = null;
                                        object4 = object2.get();
                                        object4 = (ImageProxy)object4;
                                        if (n11 != 0) break block64;
                                        object2 = TAG;
                                        object3 = "Image enqueued for processing on closed processor.";
                                        Logger.w((String)object2, (String)object3);
                                        object4.close();
                                        object3 = yuvToJpegProcessor.mLock;
                                        // MONITORENTER : object3
                                        if (n11 != 0) {
                                            n10 = yuvToJpegProcessor.mProcessingImages;
                                            yuvToJpegProcessor.mProcessingImages = n15 = n10 + -1;
                                            if (n10 == 0 && (n10 = yuvToJpegProcessor.mClosed) != 0) {
                                                n13 = n12;
                                            }
                                        }
                                        if (n13 == 0) return;
                                        charSequence.close();
                                        object2 = TAG;
                                        object = "Closed after completion of last image processed.";
                                        Logger.d((String)object2, (String)object);
                                        return;
                                    }
                                    image = charSequence.dequeueInputImage();
                                    object2 = object2.get();
                                    Image.Plane plane = object2;
                                    plane = (ImageProxy)object2;
                                    n10 = plane.getFormat();
                                    n14 = 35;
                                    if (n10 == n14) {
                                        n10 = n12;
                                    } else {
                                        n10 = 0;
                                        object2 = null;
                                    }
                                    object4 = "Input image is not expected YUV_420_888 image format";
                                    Preconditions.checkState(n10 != 0, (String)object4);
                                    Object object5 = ImageUtil.yuv_420_888toNv21((ImageProxy)plane);
                                    int n16 = 17;
                                    int n17 = plane.getWidth();
                                    int n18 = plane.getHeight();
                                    object2 = new YuvImage(object5, n16, n17, n18, null);
                                    object4 = image.getPlanes();
                                    object4 = object4[0];
                                    object4 = object4.getBuffer();
                                    int n19 = ((Buffer)object4).position();
                                    object5 = new ExifOutputStream;
                                    YuvToJpegProcessor$ByteBufferOutputStream yuvToJpegProcessor$ByteBufferOutputStream = new YuvToJpegProcessor$ByteBufferOutputStream((ByteBuffer)object4);
                                    ExifData exifData = YuvToJpegProcessor.getExifData((ImageProxy)plane);
                                    object5(yuvToJpegProcessor$ByteBufferOutputStream, exifData);
                                    n16 = yuvToJpegProcessor.mQuality;
                                    object2.compressToJpeg(object3, n16, (OutputStream)object5);
                                    plane.close();
                                    try {
                                        n10 = ((Buffer)object4).position();
                                        ((ByteBuffer)object4).limit(n10);
                                        ((ByteBuffer)object4).position(n19);
                                        charSequence.queueInputImage(image);
                                        object3 = yuvToJpegProcessor.mLock;
                                    }
                                    catch (ExecutionException executionException) {
                                        break block65;
                                    }
                                    catch (InterruptedException interruptedException) {
                                        break block65;
                                    }
                                    // MONITORENTER : object3
                                    if (n11 != 0) {
                                        n10 = yuvToJpegProcessor.mProcessingImages;
                                        yuvToJpegProcessor.mProcessingImages = n15 = n10 + -1;
                                        if (n10 == 0 && (n10 = (int)(yuvToJpegProcessor.mClosed ? 1 : 0)) != 0) {
                                            n13 = n12;
                                        }
                                    }
                                    if (n13 == 0) return;
                                    break block70;
                                    catch (Throwable throwable) {
                                        object = plane;
                                        break block66;
                                    }
                                    catch (ExecutionException executionException) {
                                    }
                                    catch (InterruptedException interruptedException) {
                                        // empty catch block
                                    }
                                    object = plane;
                                    break block65;
                                    catch (Throwable throwable) {
                                        break block67;
                                    }
                                    catch (ExecutionException executionException) {
                                        break block68;
                                    }
                                    catch (InterruptedException interruptedException) {
                                        break block68;
                                    }
                                    catch (Throwable throwable) {
                                        image = null;
                                    }
                                }
                                object = object4;
                                break block66;
                                catch (ExecutionException executionException) {
                                    break block69;
                                }
                                catch (InterruptedException interruptedException) {
                                    // empty catch block
                                }
                            }
                            image = null;
                        }
                        object = object4;
                        break block65;
                        catch (Throwable throwable) {
                            image = null;
                            break block66;
                        }
                        catch (ExecutionException executionException) {
                        }
                        catch (InterruptedException interruptedException) {
                            // empty catch block
                        }
                        image = null;
                    }
                    if (n11 != 0) {
                        object3 = TAG;
                        object4 = "Failed to process YUV -> JPEG";
                        Logger.e((String)object3, object4, (Throwable)object2);
                        object3 = charSequence.dequeueInputImage();
                        try {
                            object2 = object3.getPlanes();
                            object2 = object2[0];
                            object2 = object2.getBuffer();
                            ((ByteBuffer)object2).rewind();
                            ((ByteBuffer)object2).limit(0);
                            charSequence.queueInputImage((Image)object3);
                        }
                        finally {
                            image = object3;
                        }
                    }
                    break block71;
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                object3 = yuvToJpegProcessor.mLock;
                // MONITORENTER : object3
                if (n11 != 0) {
                    n11 = yuvToJpegProcessor.mProcessingImages;
                    yuvToJpegProcessor.mProcessingImages = n14 = n11 + -1;
                    if (n11 == 0 && (n11 = (int)(yuvToJpegProcessor.mClosed ? 1 : 0)) != 0) {
                        n13 = n12;
                    }
                }
                if (image != null) {
                    image.close();
                }
                if (object != null) {
                    object.close();
                }
                if (n13 == 0) throw var3_15;
                charSequence.close();
                object = TAG;
                string2 = "Closed after completion of last image processed.";
                Logger.d((String)object, string2);
                throw var3_15;
            }
            object3 = yuvToJpegProcessor.mLock;
            // MONITORENTER : object3
            if (n11 != 0) {
                n10 = yuvToJpegProcessor.mProcessingImages;
                yuvToJpegProcessor.mProcessingImages = n11 = n10 + -1;
                if (n10 == 0 && (n10 = (int)(yuvToJpegProcessor.mClosed ? 1 : 0)) != 0) {
                    n13 = n12;
                }
            }
            if (image != null) {
                image.close();
            }
            if (object != null) {
                object.close();
            }
            if (n13 == 0) return;
        }
        charSequence.close();
        object2 = TAG;
        object = "Closed after completion of last image processed.";
        Logger.d((String)object2, (String)object);
    }
}

