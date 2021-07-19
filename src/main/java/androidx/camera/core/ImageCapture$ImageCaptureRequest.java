/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.util.Rational
 *  android.util.Size
 */
package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageCapture$OnImageCapturedCallback;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import b.a.b.y;
import b.a.b.z;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ImageCapture$ImageCaptureRequest {
    private final ImageCapture$OnImageCapturedCallback mCallback;
    public AtomicBoolean mDispatched;
    public final int mJpegQuality;
    private final Executor mListenerExecutor;
    public final int mRotationDegrees;
    private final Rational mTargetRatio;
    private final Rect mViewPortCropRect;

    public ImageCapture$ImageCaptureRequest(int n10, int n11, Rational rational, Rect rect, Executor executor, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        AtomicBoolean atomicBoolean;
        boolean bl2 = false;
        this.mDispatched = atomicBoolean = new AtomicBoolean(false);
        this.mRotationDegrees = n10;
        this.mJpegQuality = n11;
        if (rational != null) {
            boolean bl3;
            n10 = rational.isZero() ? 1 : 0;
            n11 = 1;
            Preconditions.checkArgument((n10 ^ n11) != 0, "Target ratio cannot be zero");
            float f10 = rational.floatValue();
            atomicBoolean = null;
            float f11 = f10 - 0.0f;
            n10 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (n10 > 0) {
                bl3 = n11;
            }
            String string2 = "Target ratio must be positive";
            Preconditions.checkArgument(bl3, string2);
        }
        this.mTargetRatio = rational;
        this.mViewPortCropRect = rect;
        this.mListenerExecutor = executor;
        this.mCallback = imageCapture$OnImageCapturedCallback;
    }

    private /* synthetic */ void a(ImageProxy imageProxy) {
        this.mCallback.onCaptureSuccess(imageProxy);
    }

    private /* synthetic */ void c(int n10, String string2, Throwable throwable) {
        ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback = this.mCallback;
        ImageCaptureException imageCaptureException = new ImageCaptureException(n10, string2, throwable);
        imageCapture$OnImageCapturedCallback.onError(imageCaptureException);
    }

    public static Rect getDispatchCropRect(Rect rect, int n10, Size size, int n11) {
        Matrix matrix = new Matrix();
        float f10 = n11 - n10;
        matrix.setRotate(f10);
        Object object = ImageUtil.sizeToVertexes(size);
        matrix.mapPoints(object);
        float f11 = object[0];
        float f12 = object[2];
        float f13 = object[4];
        float f14 = object[6];
        f11 = ImageUtil.min(f11, f12, f13, f14);
        f12 = object[1];
        f13 = object[3];
        f14 = object[5];
        f10 = object[7];
        f10 = ImageUtil.min(f12, f13, f14, f10);
        f11 = -f11;
        f10 = -f10;
        matrix.postTranslate(f11, f10);
        matrix.invert(matrix);
        object = new RectF;
        object();
        size = new RectF(rect);
        matrix.mapRect((RectF)object, (RectF)size);
        object.sort();
        rect = new Rect();
        object.round(rect);
        return rect;
    }

    public /* synthetic */ void b(ImageProxy imageProxy) {
        this.a(imageProxy);
    }

    public /* synthetic */ void d(int n10, String string2, Throwable throwable) {
        this.c(n10, string2, throwable);
    }

    public void dispatchImage(ImageProxy imageProxy) {
        int n10;
        AutoCloseable autoCloseable;
        Object object = this.mDispatched;
        int n11 = 0;
        Object object2 = null;
        int n12 = 1;
        boolean bl2 = ((AtomicBoolean)object).compareAndSet(false, n12 != 0);
        if (!bl2) {
            imageProxy.close();
            return;
        }
        object = new ExifRotationAvailability();
        bl2 = ((ExifRotationAvailability)object).shouldUseExifOrientation(imageProxy);
        if (bl2) {
            try {
                object = imageProxy.getPlanes();
            }
            catch (IOException iOException) {
                this.notifyCallbackError(n12, "Unable to parse JPEG exif", iOException);
                imageProxy.close();
                return;
            }
            object = object[0];
            object = object.getBuffer();
            ((ByteBuffer)object).rewind();
            n11 = ((Buffer)object).capacity();
            object2 = new byte[n11];
            ((ByteBuffer)object).get((byte[])object2);
            autoCloseable = new ByteArrayInputStream((byte[])object2);
            object2 = Exif.createFromInputStream((InputStream)autoCloseable);
            ((ByteBuffer)object).rewind();
            int n13 = ((Exif)object2).getWidth();
            n10 = ((Exif)object2).getHeight();
            object = new Size(n13, n10);
            n11 = ((Exif)object2).getRotation();
        } else {
            n11 = imageProxy.getWidth();
            n12 = imageProxy.getHeight();
            object = new Size(n11, n12);
            n11 = this.mRotationDegrees;
        }
        Object object3 = imageProxy.getImageInfo().getTagBundle();
        long l10 = imageProxy.getImageInfo().getTimestamp();
        object3 = ImmutableImageInfo.create((TagBundle)object3, l10, n11);
        autoCloseable = new SettableImageProxy(imageProxy, (Size)object, (ImageInfo)object3);
        object3 = this.mViewPortCropRect;
        if (object3 != null) {
            n10 = this.mRotationDegrees;
            object = ImageCapture$ImageCaptureRequest.getDispatchCropRect((Rect)object3, n10, (Size)object, n11);
            autoCloseable.setCropRect((Rect)object);
        } else {
            object = this.mTargetRatio;
            if (object != null) {
                if ((n11 %= 180) != 0) {
                    object2 = this.mTargetRatio;
                    n11 = object2.getDenominator();
                    object3 = this.mTargetRatio;
                    n12 = object3.getNumerator();
                    object = new Rational(n11, n12);
                }
                n12 = autoCloseable.getWidth();
                n10 = autoCloseable.getHeight();
                object2 = new Size(n12, n10);
                if ((n12 = (int)(ImageUtil.isAspectRatioValid((Size)object2, (Rational)object) ? 1 : 0)) != 0) {
                    object = ImageUtil.computeCropRectFromAspectRatio((Size)object2, (Rational)object);
                    autoCloseable.setCropRect((Rect)object);
                }
            }
        }
        object = this.mListenerExecutor;
        object2 = new z(this, (ImageProxy)autoCloseable);
        try {
            object.execute((Runnable)object2);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object = "ImageCapture";
            object2 = "Unable to post to the supplied executor.";
            Logger.e((String)object, (String)object2);
            imageProxy.close();
        }
    }

    public void notifyCallbackError(int n10, String string2, Throwable throwable) {
        Object object = this.mDispatched;
        y y10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (!bl3) {
            return;
        }
        object = this.mListenerExecutor;
        y10 = new y(this, n10, string2, throwable);
        try {
            object.execute(y10);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            String string3 = "ImageCapture";
            string2 = "Unable to post to the supplied executor.";
            Logger.e(string3, string2);
        }
    }
}

