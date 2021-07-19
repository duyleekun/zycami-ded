/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.util.Log
 *  android.util.Rational
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraClosedException;
import androidx.camera.core.CaptureBundles;
import androidx.camera.core.ImageCapture$1;
import androidx.camera.core.ImageCapture$2;
import androidx.camera.core.ImageCapture$3;
import androidx.camera.core.ImageCapture$4;
import androidx.camera.core.ImageCapture$5;
import androidx.camera.core.ImageCapture$6;
import androidx.camera.core.ImageCapture$7;
import androidx.camera.core.ImageCapture$8;
import androidx.camera.core.ImageCapture$Builder;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker;
import androidx.camera.core.ImageCapture$CaptureFailedException;
import androidx.camera.core.ImageCapture$Defaults;
import androidx.camera.core.ImageCapture$ImageCaptureRequest;
import androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor;
import androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor$ImageCaptor;
import androidx.camera.core.ImageCapture$OnImageCapturedCallback;
import androidx.camera.core.ImageCapture$OnImageSavedCallback;
import androidx.camera.core.ImageCapture$OutputFileOptions;
import androidx.camera.core.ImageCapture$TakePictureState;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.SessionConfig$SessionError;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfig$Builder;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.YuvToJpegProcessor;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.b.a0;
import b.a.b.b0;
import b.a.b.c0;
import b.a.b.d0;
import b.a.b.e0;
import b.a.b.f0;
import b.a.b.g0;
import b.a.b.h0;
import b.a.b.i0;
import b.a.b.j0;
import b.a.b.k0;
import b.a.b.l0;
import b.a.b.m0;
import b.a.b.n0;
import b.a.b.u;
import b.a.b.u1;
import b.a.b.v;
import b.a.b.x;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

public final class ImageCapture
extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;
    private static final long CHECK_3A_TIMEOUT_IN_MS = 1000L;
    private static final int DEFAULT_CAPTURE_MODE = 1;
    public static final ImageCapture$Defaults DEFAULT_CONFIG;
    private static final int DEFAULT_FLASH_MODE = 2;
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    private static final int FLASH_MODE_UNKNOWN = 255;
    private static final byte JPEG_QUALITY_MAXIMIZE_QUALITY_MODE = 100;
    private static final byte JPEG_QUALITY_MINIMIZE_LATENCY_MODE = 95;
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ImageCapture";
    private CaptureBundle mCaptureBundle;
    private CaptureConfig mCaptureConfig;
    private final int mCaptureMode;
    private CaptureProcessor mCaptureProcessor;
    private final ImageReaderProxy$OnImageAvailableListener mClosingListener;
    private Rational mCropAspectRatio;
    private DeferrableSurface mDeferrableSurface;
    private final boolean mEnableCheck3AConverged;
    private ExecutorService mExecutor;
    private int mFlashMode;
    private ImageCapture$ImageCaptureRequestProcessor mImageCaptureRequestProcessor;
    public SafeCloseImageReaderProxy mImageReader;
    public final Executor mIoExecutor;
    private final AtomicReference mLockedFlashMode;
    private int mMaxCaptureStages;
    private CameraCaptureCallback mMetadataMatchingCaptureCallback;
    public ProcessingImageReader mProcessingImageReader;
    public final Executor mSequentialIoExecutor;
    private final ImageCapture$CaptureCallbackChecker mSessionCallbackChecker;
    public SessionConfig$Builder mSessionConfigBuilder;
    private boolean mUseSoftwareJpeg;

    static {
        ImageCapture$Defaults imageCapture$Defaults;
        DEFAULT_CONFIG = imageCapture$Defaults = new ImageCapture$Defaults();
    }

    public ImageCapture(ImageCaptureConfig atomicReference) {
        super((UseCaseConfig)((Object)atomicReference));
        atomicReference = new AtomicReference<Object>();
        this.mSessionCallbackChecker = atomicReference;
        atomicReference = n0.a;
        this.mClosingListener = atomicReference;
        int n10 = 0;
        this.mLockedFlashMode = atomicReference = new AtomicReference<Object>(null);
        this.mFlashMode = -1;
        this.mCropAspectRatio = null;
        atomicReference = null;
        this.mUseSoftwareJpeg = false;
        Object object = (ImageCaptureConfig)this.getCurrentConfig();
        Object object2 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        int n11 = object.containsOption((Config$Option)object2);
        int n12 = 1;
        this.mCaptureMode = n11 != 0 ? (n11 = ((ImageCaptureConfig)object).getCaptureMode()) : n12;
        object2 = CameraXExecutors.ioExecutor();
        this.mIoExecutor = object = (Executor)Preconditions.checkNotNull(((ImageCaptureConfig)object).getIoExecutor((Executor)object2));
        this.mSequentialIoExecutor = object = CameraXExecutors.newSequentialExecutor((Executor)object);
        n10 = this.mCaptureMode;
        this.mEnableCheck3AConverged = n10 == 0 ? n12 : false;
    }

    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ void a(YuvToJpegProcessor yuvToJpegProcessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            yuvToJpegProcessor.close();
        }
    }

    private void abortImageCaptureRequests() {
        CameraClosedException cameraClosedException = new CameraClosedException("Camera is closed.");
        this.mImageCaptureRequestProcessor.cancelRequests(cameraClosedException);
    }

    private /* synthetic */ ListenableFuture b(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest) {
        return this.takePictureInternal(imageCapture$ImageCaptureRequest);
    }

    private /* synthetic */ void d(String object, ImageCaptureConfig imageCaptureConfig, Size size, SessionConfig sessionConfig, SessionConfig$SessionError sessionConfig$SessionError) {
        this.clearPipeline();
        boolean bl2 = this.isCurrentCamera((String)object);
        if (bl2) {
            this.mSessionConfigBuilder = object = this.createPipeline((String)object, imageCaptureConfig, size);
            object = ((SessionConfig$Builder)object).build();
            this.updateSessionConfig((SessionConfig)object);
            this.notifyReset();
        }
    }

    public static boolean enforceSoftwareJpegConstraints(MutableConfig mutableConfig) {
        Config$Option config$Option = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean bl2 = Boolean.FALSE;
        Object object = (Boolean)mutableConfig.retrieveOption(config$Option, bl2);
        boolean bl3 = (Boolean)object;
        boolean bl4 = false;
        if (bl3) {
            int n10;
            String string2;
            bl3 = true;
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 26;
            String string3 = TAG;
            if (n11 < n12) {
                object = new StringBuilder();
                string2 = "Software JPEG only supported on API 26+, but current API level is ";
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(n11);
                object = ((StringBuilder)object).toString();
                Logger.w(string3, (String)object);
                bl3 = false;
                object = null;
            }
            Object object2 = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
            n12 = 0;
            string2 = null;
            if ((object2 = (Integer)mutableConfig.retrieveOption((Config$Option)object2, null)) != null && (n11 = ((Integer)object2).intValue()) != (n10 = 256)) {
                Logger.w(string3, "Software JPEG cannot be used with non-JPEG output buffer format.");
                bl3 = false;
                object = null;
            }
            object2 = ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR;
            if ((object2 = mutableConfig.retrieveOption((Config$Option)object2, null)) != null) {
                object = "CaptureProcessor is set, unable to use software JPEG.";
                Logger.w(string3, (String)object);
            } else {
                bl4 = bl3;
            }
            if (!bl4) {
                object = "Unable to support software JPEG. Disabling.";
                Logger.w(string3, (String)object);
                mutableConfig.insertOption(config$Option, bl2);
            }
        }
        return bl4;
    }

    private /* synthetic */ Object f(CaptureConfig$Builder object, List list, CaptureStage captureStage, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ImageCapture$8 imageCapture$8 = new ImageCapture$8(this, callbackToFutureAdapter$Completer);
        ((CaptureConfig$Builder)object).addCameraCaptureCallback(imageCapture$8);
        object = ((CaptureConfig$Builder)object).build();
        list.add(object);
        object = new StringBuilder();
        ((StringBuilder)object).append("issueTakePicture[stage=");
        int n10 = captureStage.getId();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    private CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        boolean bl2;
        List list = this.mCaptureBundle.getCaptureStages();
        if (list != null && !(bl2 = list.isEmpty())) {
            captureBundle = CaptureBundles.createCaptureBundle(list);
        }
        return captureBundle;
    }

    public static int getError(Throwable throwable) {
        boolean bl2 = throwable instanceof CameraClosedException;
        if (bl2) {
            return 3;
        }
        boolean bl3 = throwable instanceof ImageCapture$CaptureFailedException;
        if (bl3) {
            return 2;
        }
        return 0;
    }

    private int getJpegQuality() {
        int n10 = this.mCaptureMode;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return 95;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("CaptureMode ");
            int n12 = this.mCaptureMode;
            charSequence.append(n12);
            charSequence.append(" is invalid");
            charSequence = charSequence.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
            throw illegalStateException;
        }
        return 100;
    }

    private ListenableFuture getPreCaptureStateIfNeeded() {
        int n10 = this.mEnableCheck3AConverged;
        if (n10 == 0 && (n10 = this.getFlashMode()) != 0) {
            return Futures.immediateFuture(null);
        }
        ImageCapture$CaptureCallbackChecker imageCapture$CaptureCallbackChecker = this.mSessionCallbackChecker;
        ImageCapture$6 imageCapture$6 = new ImageCapture$6(this);
        return imageCapture$CaptureCallbackChecker.checkCaptureResult(imageCapture$6);
    }

    public static /* synthetic */ Void h(List list) {
        return null;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void i(ImageReaderProxy object) {
        String string2 = TAG;
        object = object.acquireLatestImage();
        CharSequence charSequence = new StringBuilder();
        String string3 = "Discarding ImageProxy which was inadvertently acquired: ";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        if (object == null) return;
        object.close();
        return;
        catch (Throwable throwable) {
            if (object == null) throw throwable;
            try {
                object.close();
                throw throwable;
            }
            catch (Throwable throwable2) {
                try {
                    throwable.addSuppressed(throwable2);
                    throw throwable;
                }
                catch (IllegalStateException illegalStateException) {
                    charSequence = "Failed to acquire latest image.";
                    Log.e((String)string2, (String)charSequence, (Throwable)illegalStateException);
                }
            }
        }
    }

    private /* synthetic */ ListenableFuture j(ImageCapture$TakePictureState imageCapture$TakePictureState, CameraCaptureResult cameraCaptureResult) {
        imageCapture$TakePictureState.mPreCaptureState = cameraCaptureResult;
        this.triggerAfIfNeeded(imageCapture$TakePictureState);
        boolean bl2 = this.isAePrecaptureRequired(imageCapture$TakePictureState);
        if (bl2) {
            return this.triggerAePrecapture(imageCapture$TakePictureState);
        }
        return Futures.immediateFuture(null);
    }

    private /* synthetic */ ListenableFuture l(ImageCapture$TakePictureState imageCapture$TakePictureState, CameraCaptureResult cameraCaptureResult) {
        return this.check3AConverged(imageCapture$TakePictureState);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void lockFlashMode() {
        AtomicReference atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            AtomicReference<Integer> atomicReference2 = this.mLockedFlashMode;
            atomicReference2 = atomicReference2.get();
            if (atomicReference2 != null) {
                return;
            }
            atomicReference2 = this.mLockedFlashMode;
            int n10 = this.getFlashMode();
            Integer n11 = n10;
            atomicReference2.set(n11);
            return;
        }
    }

    public static /* synthetic */ Void n(Boolean bl2) {
        return null;
    }

    private /* synthetic */ void o(ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Not bound to a valid Camera [");
        charSequence.append(this);
        charSequence.append("]");
        charSequence = charSequence.toString();
        ImageCaptureException imageCaptureException = new ImageCaptureException(4, (String)charSequence, null);
        imageCapture$OnImageCapturedCallback.onError(imageCaptureException);
    }

    private ListenableFuture preTakePicture(ImageCapture$TakePictureState object) {
        this.lockFlashMode();
        Object object2 = FutureChain.from(this.getPreCaptureStateIfNeeded());
        Object object3 = new m0(this, (ImageCapture$TakePictureState)object);
        ExecutorService executorService = this.mExecutor;
        object2 = ((FutureChain)object2).transformAsync((AsyncFunction)object3, executorService);
        object3 = new f0(this, (ImageCapture$TakePictureState)object);
        object = this.mExecutor;
        object = ((FutureChain)object2).transformAsync((AsyncFunction)object3, (Executor)object);
        object2 = e0.a;
        object3 = this.mExecutor;
        return ((FutureChain)object).transform((Function)object2, (Executor)object3);
    }

    private /* synthetic */ void q(Executor executor, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        this.takePicture(executor, imageCapture$OnImageCapturedCallback);
    }

    private /* synthetic */ void s(ImageCapture$OutputFileOptions imageCapture$OutputFileOptions, Executor executor, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        this.takePicture(imageCapture$OutputFileOptions, executor, imageCapture$OnImageSavedCallback);
    }

    private void sendImageCaptureRequest(Executor executor, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        Object object = this.getCamera();
        if (object == null) {
            object = new a0(this, imageCapture$OnImageCapturedCallback);
            executor.execute((Runnable)object);
            return;
        }
        ImageCapture$ImageCaptureRequestProcessor imageCapture$ImageCaptureRequestProcessor = this.mImageCaptureRequestProcessor;
        int n10 = this.getRelativeRotation((CameraInternal)object);
        int n11 = this.getJpegQuality();
        Rational rational = this.mCropAspectRatio;
        Rect rect = this.getViewPortCropRect();
        ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest = new ImageCapture$ImageCaptureRequest(n10, n11, rational, rect, executor, imageCapture$OnImageCapturedCallback);
        imageCapture$ImageCaptureRequestProcessor.sendRequest(imageCapture$ImageCaptureRequest);
    }

    private ListenableFuture takePictureInternal(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest) {
        k0 k02 = new k0(this, imageCapture$ImageCaptureRequest);
        return CallbackToFutureAdapter.getFuture(k02);
    }

    private void triggerAf(ImageCapture$TakePictureState object) {
        Logger.d(TAG, "triggerAf");
        ((ImageCapture$TakePictureState)object).mIsAfTriggered = true;
        object = this.getCameraControl().triggerAf();
        i0 i02 = i0.a;
        Executor executor = CameraXExecutors.directExecutor();
        object.addListener(i02, executor);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void trySetFlashModeToCameraControl() {
        AtomicReference atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            Object object = this.mLockedFlashMode;
            object = ((AtomicReference)object).get();
            if (object != null) {
                return;
            }
            object = this.getCameraControl();
            int n10 = this.getFlashMode();
            object.setFlashMode(n10);
            return;
        }
    }

    private /* synthetic */ Object u(ImageCapture$ImageCaptureRequest object, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object2 = this.mImageReader;
        Object object3 = new g0(callbackToFutureAdapter$Completer);
        Object object4 = CameraXExecutors.mainThreadExecutor();
        ((SafeCloseImageReaderProxy)object2).setOnImageAvailableListener((ImageReaderProxy$OnImageAvailableListener)object3, (Executor)object4);
        object2 = new ImageCapture$TakePictureState();
        object3 = FutureChain.from(this.preTakePicture((ImageCapture$TakePictureState)object2));
        object4 = new x(this, (ImageCapture$ImageCaptureRequest)object);
        object = this.mExecutor;
        object = ((FutureChain)object3).transformAsync((AsyncFunction)object4, (Executor)object);
        object3 = new ImageCapture$4(this, (ImageCapture$TakePictureState)object2, callbackToFutureAdapter$Completer);
        object2 = this.mExecutor;
        Futures.addCallback((ListenableFuture)object, (FutureCallback)object3, (Executor)object2);
        object2 = new b0((ListenableFuture)object);
        object = CameraXExecutors.directExecutor();
        callbackToFutureAdapter$Completer.addCancellationListener((Runnable)object2, (Executor)object);
        return "takePictureInternal";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void unlockFlashMode() {
        AtomicReference atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            Serializable serializable = this.mLockedFlashMode;
            int n10 = 0;
            serializable = ((AtomicReference)serializable).getAndSet(null);
            serializable = (Integer)serializable;
            if (serializable == null) {
                return;
            }
            int n11 = (Integer)serializable;
            if (n11 != (n10 = this.getFlashMode())) {
                this.trySetFlashModeToCameraControl();
            }
            return;
        }
    }

    public static /* synthetic */ void w(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ImageReaderProxy object) {
        block7: {
            block6: {
                object = object.acquireLatestImage();
                if (object == null) break block6;
                boolean bl2 = callbackToFutureAdapter$Completer.set(object);
                if (bl2) break block7;
                object.close();
            }
            String string2 = "Unable to acquire image";
            object = new IllegalStateException(string2);
            try {
                callbackToFutureAdapter$Completer.setException((Throwable)object);
            }
            catch (IllegalStateException illegalStateException) {
                callbackToFutureAdapter$Completer.setException(illegalStateException);
            }
        }
    }

    private /* synthetic */ ListenableFuture x(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest, Void void_) {
        return this.issueTakePicture(imageCapture$ImageCaptureRequest);
    }

    public static /* synthetic */ void z(ListenableFuture listenableFuture) {
        listenableFuture.cancel(true);
    }

    public /* synthetic */ ListenableFuture c(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest) {
        return this.b(imageCapture$ImageCaptureRequest);
    }

    public void cancelAfAeTrigger(ImageCapture$TakePictureState imageCapture$TakePictureState) {
        boolean bl2 = imageCapture$TakePictureState.mIsAfTriggered;
        if (!bl2 && !(bl2 = imageCapture$TakePictureState.mIsAePrecaptureTriggered)) {
            return;
        }
        CameraControlInternal cameraControlInternal = this.getCameraControl();
        boolean bl3 = imageCapture$TakePictureState.mIsAfTriggered;
        boolean bl4 = imageCapture$TakePictureState.mIsAePrecaptureTriggered;
        cameraControlInternal.cancelAfAeTrigger(bl3, bl4);
        imageCapture$TakePictureState.mIsAfTriggered = false;
        imageCapture$TakePictureState.mIsAePrecaptureTriggered = false;
    }

    public ListenableFuture check3AConverged(ImageCapture$TakePictureState object) {
        boolean bl2;
        Boolean bl3 = Boolean.FALSE;
        boolean bl4 = this.mEnableCheck3AConverged;
        if (!bl4 && !(bl2 = ((ImageCapture$TakePictureState)object).mIsAePrecaptureTriggered)) {
            return Futures.immediateFuture(bl3);
        }
        object = this.mSessionCallbackChecker;
        ImageCapture$7 imageCapture$7 = new ImageCapture$7(this);
        return ((ImageCapture$CaptureCallbackChecker)object).checkCaptureResult(imageCapture$7, 1000L, bl3);
    }

    public void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        this.mDeferrableSurface = null;
        this.mImageReader = null;
        this.mProcessingImageReader = null;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public SessionConfig$Builder createPipeline(String string2, ImageCaptureConfig imageCaptureConfig, Size size) {
        Object object;
        Object object2;
        ImageCapture imageCapture = this;
        Threads.checkMainThread();
        Object object3 = SessionConfig$Builder.createFrom(imageCaptureConfig);
        Object object4 = this.mSessionCallbackChecker;
        ((SessionConfig$Builder)object3).addRepeatingCameraCaptureCallback((CameraCaptureCallback)object4);
        object4 = imageCaptureConfig.getImageReaderProxyProvider();
        int n10 = 2;
        if (object4 != null) {
            object2 = imageCaptureConfig.getImageReaderProxyProvider();
            int n11 = size.getWidth();
            int n12 = size.getHeight();
            int n13 = this.getImageFormat();
            int n14 = 2;
            long l10 = 0L;
            object2 = object2.newInstance(n11, n12, n13, n14, l10);
            this.mImageReader = object4 = new SafeCloseImageReaderProxy((ImageReaderProxy)object2);
            this.mMetadataMatchingCaptureCallback = object4 = new ImageCapture$1(this);
        } else {
            int n15;
            object4 = this.mCaptureProcessor;
            if (object4 == null && (n15 = this.mUseSoftwareJpeg) == 0) {
                n15 = size.getWidth();
                int n16 = size.getHeight();
                int n17 = this.getImageFormat();
                object4 = new MetadataImageReader(n15, n16, n17, n10);
                this.mMetadataMatchingCaptureCallback = object2 = ((MetadataImageReader)object4).getCameraCaptureCallback();
                this.mImageReader = object2 = new SafeCloseImageReaderProxy((ImageReaderProxy)object4);
            } else {
                int n18;
                Object object5;
                n15 = 0;
                object2 = null;
                int n19 = this.getImageFormat();
                int n20 = this.getImageFormat();
                int n21 = imageCapture.mUseSoftwareJpeg;
                if (n21 != 0) {
                    int n22;
                    object4 = imageCapture.mCaptureProcessor;
                    if (object4 == null) {
                        n22 = 1;
                    } else {
                        n22 = 0;
                        object4 = null;
                    }
                    object2 = "CaptureProcessor should not be set if software JPEG is to be used.";
                    Preconditions.checkState(n22 != 0, (String)object2);
                    n22 = Build.VERSION.SDK_INT;
                    n15 = 26;
                    if (n22 < n15) {
                        object3 = new IllegalStateException("Software JPEG only supported on API 26+");
                        throw object3;
                    }
                    Logger.i(TAG, "Using software JPEG encoder.");
                    n15 = this.getJpegQuality();
                    n20 = imageCapture.mMaxCaptureStages;
                    object4 = new YuvToJpegProcessor(n15, n20);
                    n15 = 256;
                    object5 = object4;
                    n18 = n15;
                    object2 = object4;
                } else {
                    object5 = object4;
                    n18 = n20;
                }
                n21 = size.getWidth();
                int n23 = size.getHeight();
                int n24 = imageCapture.mMaxCaptureStages;
                ExecutorService executorService = imageCapture.mExecutor;
                object = CaptureBundles.singleDefaultCaptureBundle();
                CaptureBundle captureBundle = this.getCaptureBundle((CaptureBundle)object);
                object = object4;
                imageCapture.mProcessingImageReader = object4 = new ProcessingImageReader(n21, n23, n19, n24, executorService, captureBundle, (CaptureProcessor)object5, n18);
                imageCapture.mMetadataMatchingCaptureCallback = object4 = ((ProcessingImageReader)object4).getCameraCaptureCallback();
                object = imageCapture.mProcessingImageReader;
                imageCapture.mImageReader = object4 = new SafeCloseImageReaderProxy((ImageReaderProxy)object);
                if (object2 != null) {
                    object4 = imageCapture.mProcessingImageReader.getCloseFuture();
                    object = new v((YuvToJpegProcessor)object2);
                    object2 = CameraXExecutors.directExecutor();
                    object4.addListener((Runnable)object, (Executor)object2);
                }
            }
        }
        object2 = new u(this);
        imageCapture.mImageCaptureRequestProcessor = object4 = new ImageCapture$ImageCaptureRequestProcessor(n10, (ImageCapture$ImageCaptureRequestProcessor$ImageCaptor)object2);
        object4 = imageCapture.mImageReader;
        Object object6 = imageCapture.mClosingListener;
        object2 = CameraXExecutors.mainThreadExecutor();
        ((SafeCloseImageReaderProxy)object4).setOnImageAvailableListener((ImageReaderProxy$OnImageAvailableListener)object6, (Executor)object2);
        object4 = imageCapture.mImageReader;
        object6 = imageCapture.mDeferrableSurface;
        if (object6 != null) {
            ((DeferrableSurface)object6).close();
        }
        object2 = imageCapture.mImageReader.getSurface();
        imageCapture.mDeferrableSurface = object6 = new ImmediateSurface((Surface)object2);
        object6 = ((DeferrableSurface)object6).getTerminationFuture();
        Objects.requireNonNull(object4);
        object2 = new u1((SafeCloseImageReaderProxy)object4);
        object4 = CameraXExecutors.mainThreadExecutor();
        object6.addListener((Runnable)object2, (Executor)object4);
        object4 = imageCapture.mDeferrableSurface;
        ((SessionConfig$Builder)object3).addNonRepeatingSurface((DeferrableSurface)object4);
        object6 = string2;
        object2 = imageCaptureConfig;
        object = size;
        object4 = new c0(this, string2, imageCaptureConfig, size);
        ((SessionConfig$Builder)object3).addErrorListener((SessionConfig$ErrorListener)object4);
        return object3;
    }

    public /* synthetic */ void e(String string2, ImageCaptureConfig imageCaptureConfig, Size size, SessionConfig sessionConfig, SessionConfig$SessionError sessionConfig$SessionError) {
        this.d(string2, imageCaptureConfig, size, sessionConfig, sessionConfig$SessionError);
    }

    public /* synthetic */ Object g(CaptureConfig$Builder captureConfig$Builder, List list, CaptureStage captureStage, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.f(captureConfig$Builder, list, captureStage, callbackToFutureAdapter$Completer);
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    public UseCaseConfig getDefaultConfig(boolean bl2, UseCaseConfigFactory object) {
        Config config;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.IMAGE_CAPTURE;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getFlashMode() {
        AtomicReference atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            int n10 = this.mFlashMode;
            int n11 = -1;
            if (n10 == n11) {
                UseCaseConfig useCaseConfig = this.getCurrentConfig();
                useCaseConfig = (ImageCaptureConfig)useCaseConfig;
                n11 = 2;
                return ((ImageCaptureConfig)useCaseConfig).getFlashMode(n11);
            }
            return n10;
        }
    }

    public int getTargetRotation() {
        return this.getTargetRotationInternal();
    }

    public UseCaseConfig$Builder getUseCaseConfigBuilder(Config config) {
        return ImageCapture$Builder.fromConfig(config);
    }

    public boolean is3AConverged(CameraCaptureResult object) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5 = false;
        if (object == null) {
            return false;
        }
        Enum enum_ = object.getAfMode();
        Enum enum_2 = CameraCaptureMetaData$AfMode.ON_CONTINUOUS_AUTO;
        boolean bl6 = true;
        if (enum_ != enum_2 && (enum_ = object.getAfMode()) != (enum_2 = CameraCaptureMetaData$AfMode.OFF) && (enum_ = object.getAfMode()) != (enum_2 = CameraCaptureMetaData$AfMode.UNKNOWN) && (enum_ = object.getAfState()) != (enum_2 = CameraCaptureMetaData$AfState.FOCUSED) && (enum_ = object.getAfState()) != (enum_2 = CameraCaptureMetaData$AfState.LOCKED_FOCUSED) && (enum_ = object.getAfState()) != (enum_2 = CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED)) {
            bl4 = false;
            enum_ = null;
        } else {
            bl4 = bl6;
        }
        enum_2 = object.getAeState();
        Enum enum_3 = CameraCaptureMetaData$AeState.CONVERGED;
        if (enum_2 != enum_3 && (enum_2 = object.getAeState()) != (enum_3 = CameraCaptureMetaData$AeState.FLASH_REQUIRED) && (enum_2 = object.getAeState()) != (enum_3 = CameraCaptureMetaData$AeState.UNKNOWN)) {
            bl3 = false;
            enum_2 = null;
        } else {
            bl3 = bl6;
        }
        enum_3 = object.getAwbState();
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState = CameraCaptureMetaData$AwbState.CONVERGED;
        if (enum_3 != cameraCaptureMetaData$AwbState && (object = object.getAwbState()) != (enum_3 = CameraCaptureMetaData$AwbState.UNKNOWN)) {
            bl2 = false;
            object = null;
        } else {
            bl2 = bl6;
        }
        if (bl4 && bl3 && bl2) {
            bl5 = bl6;
        }
        return bl5;
    }

    public boolean isAePrecaptureRequired(ImageCapture$TakePictureState object) {
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState;
        int n10 = this.getFlashMode();
        int n11 = 0;
        int n12 = 1;
        if (n10 != 0) {
            if (n10 != n12) {
                int n13 = 2;
                if (n10 == n13) {
                    return false;
                }
                n10 = this.getFlashMode();
                object = new AssertionError(n10);
                throw object;
            }
            return n12 != 0;
        }
        object = object.mPreCaptureState.getAeState();
        if (object == (cameraCaptureMetaData$AeState = CameraCaptureMetaData$AeState.FLASH_REQUIRED)) {
            n11 = n12;
        }
        return n11 != 0;
    }

    public ListenableFuture issueTakePicture(ImageCapture$ImageCaptureRequest object) {
        Object object2;
        Object object3;
        Logger.d(TAG, "issueTakePicture");
        Object object4 = new ArrayList();
        Object object5 = new ArrayList();
        Iterator iterator2 = this.mProcessingImageReader;
        int n10 = 1;
        int n11 = 0;
        Object object6 = null;
        if (iterator2 != null) {
            boolean bl2 = this.mUseSoftwareJpeg;
            if (bl2) {
                iterator2 = CaptureBundles.singleDefaultCaptureBundle();
                object6 = (iterator2 = this.getCaptureBundle((CaptureBundle)((Object)iterator2))).getCaptureStages();
                n11 = object6.size();
                if (n11 > n10) {
                    object = new IllegalArgumentException("Software JPEG not supported with CaptureBundle size > 1.");
                    return Futures.immediateFailedFuture((Throwable)object);
                }
            } else {
                iterator2 = this.getCaptureBundle(null);
            }
            if (iterator2 == null) {
                object = new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle.");
                return Futures.immediateFailedFuture((Throwable)object);
            }
            object3 = iterator2.getCaptureStages();
            n10 = object3.size();
            if (n10 > (n11 = this.mMaxCaptureStages)) {
                object = new IllegalArgumentException("ImageCapture has CaptureStages > Max CaptureStage size");
                return Futures.immediateFailedFuture((Throwable)object);
            }
            this.mProcessingImageReader.setCaptureBundle((CaptureBundle)((Object)iterator2));
            object3 = this.mProcessingImageReader;
            object6 = ((ProcessingImageReader)object3).getTagBundleKey();
        } else {
            iterator2 = CaptureBundles.singleDefaultCaptureBundle();
            object2 = (iterator2 = this.getCaptureBundle((CaptureBundle)((Object)iterator2))).getCaptureStages();
            int n12 = object2.size();
            if (n12 > n10) {
                object = new IllegalArgumentException("ImageCapture have no CaptureProcess set with CaptureBundle size > 1.");
                return Futures.immediateFailedFuture((Throwable)object);
            }
        }
        iterator2 = iterator2.getCaptureStages().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Integer n13;
            int n14;
            object3 = (CaptureStage)iterator2.next();
            object2 = new CaptureConfig$Builder();
            int n15 = this.mCaptureConfig.getTemplateType();
            ((CaptureConfig$Builder)object2).setTemplateType(n15);
            Object object7 = this.mCaptureConfig.getImplementationOptions();
            ((CaptureConfig$Builder)object2).addImplementationOptions((Config)object7);
            object7 = this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks();
            ((CaptureConfig$Builder)object2).addAllCameraCaptureCallbacks((Collection)object7);
            object7 = this.mDeferrableSurface;
            ((CaptureConfig$Builder)object2).addSurface((DeferrableSurface)object7);
            object7 = new ExifRotationAvailability();
            n15 = (int)(((ExifRotationAvailability)object7).isRotationOptionSupported() ? 1 : 0);
            if (n15 != 0) {
                object7 = CaptureConfig.OPTION_ROTATION;
                n14 = ((ImageCapture$ImageCaptureRequest)object).mRotationDegrees;
                n13 = n14;
                ((CaptureConfig$Builder)object2).addImplementationOption((Config$Option)object7, n13);
            }
            object7 = CaptureConfig.OPTION_JPEG_QUALITY;
            n14 = ((ImageCapture$ImageCaptureRequest)object).mJpegQuality;
            n13 = n14;
            ((CaptureConfig$Builder)object2).addImplementationOption((Config$Option)object7, n13);
            object7 = object3.getCaptureConfig().getImplementationOptions();
            ((CaptureConfig$Builder)object2).addImplementationOptions((Config)object7);
            if (object6 != null) {
                n15 = object3.getId();
                object7 = n15;
                ((CaptureConfig$Builder)object2).addTag((String)object6, (Integer)object7);
            }
            object7 = this.mMetadataMatchingCaptureCallback;
            ((CaptureConfig$Builder)object2).addCameraCaptureCallback((CameraCaptureCallback)object7);
            object7 = new j0(this, (CaptureConfig$Builder)object2, (List)object5, (CaptureStage)object3);
            object3 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object7);
            object4.add(object3);
        }
        this.getCameraControl().submitCaptureRequests((List)object5);
        object = Futures.allAsList(object4);
        object4 = h0.a;
        object5 = CameraXExecutors.directExecutor();
        return Futures.transform((ListenableFuture)object, (Function)object4, (Executor)object5);
    }

    public /* synthetic */ ListenableFuture k(ImageCapture$TakePictureState imageCapture$TakePictureState, CameraCaptureResult cameraCaptureResult) {
        return this.j(imageCapture$TakePictureState, cameraCaptureResult);
    }

    public /* synthetic */ ListenableFuture m(ImageCapture$TakePictureState imageCapture$TakePictureState, CameraCaptureResult cameraCaptureResult) {
        return this.l(imageCapture$TakePictureState, cameraCaptureResult);
    }

    public void onAttached() {
        boolean bl2;
        int n10;
        Object object = (ImageCaptureConfig)this.getCurrentConfig();
        Object object2 = CaptureConfig$Builder.createFrom((UseCaseConfig)object).build();
        this.mCaptureConfig = object2;
        this.mCaptureProcessor = object2 = ((ImageCaptureConfig)object).getCaptureProcessor(null);
        this.mMaxCaptureStages = n10 = ((ImageCaptureConfig)object).getMaxCaptureStages(2);
        object2 = CaptureBundles.singleDefaultCaptureBundle();
        this.mCaptureBundle = object2 = ((ImageCaptureConfig)object).getCaptureBundle((CaptureBundle)object2);
        this.mUseSoftwareJpeg = bl2 = ((ImageCaptureConfig)object).isSoftwareJpegEncoderRequested();
        object = new ImageCapture$5(this);
        this.mExecutor = object = Executors.newFixedThreadPool(1, (ThreadFactory)object);
    }

    public void onCameraControlReady() {
        this.trySetFlashModeToCameraControl();
    }

    public void onDetached() {
        this.abortImageCaptureRequests();
        this.clearPipeline();
        this.mUseSoftwareJpeg = false;
        this.mExecutor.shutdown();
    }

    /*
     * WARNING - void declaration
     */
    public UseCaseConfig onMergeConfig(CameraInfoInternal object, UseCaseConfig$Builder useCaseConfig$Builder) {
        Object object2;
        Object object3;
        Object object4;
        boolean bl2 = ((Quirks)(object = object.getCameraQuirks())).contains((Class)(object4 = SoftwareJpegEncodingPreferredQuirk.class));
        if (bl2) {
            object = useCaseConfig$Builder.getMutableConfig();
            object4 = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
            object3 = Boolean.TRUE;
            object = (Boolean)object.retrieveOption((Config$Option)object4, object3);
            boolean bl3 = (Boolean)object;
            object2 = TAG;
            if (!bl3) {
                object = "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.";
                Logger.w((String)object2, (String)object);
            } else {
                Logger.i((String)object2, "Requesting software JPEG due to device quirk.");
                object = useCaseConfig$Builder.getMutableConfig();
                object.insertOption((Config$Option)object4, object3);
            }
        }
        object = useCaseConfig$Builder.getMutableConfig();
        boolean bl4 = ImageCapture.enforceSoftwareJpegConstraints((MutableConfig)object);
        object4 = useCaseConfig$Builder.getMutableConfig();
        object3 = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
        boolean bl5 = false;
        object2 = null;
        object4 = (Integer)object4.retrieveOption((Config$Option)object3, null);
        boolean bl6 = false;
        object3 = null;
        int n10 = 35;
        boolean bl7 = true;
        if (object4 != null) {
            void var7_13;
            Config$Option config$Option;
            Object object5 = useCaseConfig$Builder.getMutableConfig();
            object2 = object5.retrieveOption(config$Option = ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, null);
            if (object2 == null) {
                boolean bl8 = bl7;
            } else {
                boolean bl9 = false;
                object2 = null;
            }
            Preconditions.checkArgument((boolean)var7_13, "Cannot set buffer format with CaptureProcessor defined.");
            object2 = useCaseConfig$Builder.getMutableConfig();
            object5 = ImageInputConfig.OPTION_INPUT_FORMAT;
            if (!bl4) {
                n10 = (Integer)object4;
            }
            object = n10;
            object2.insertOption((Config$Option)object5, object);
        } else {
            object4 = useCaseConfig$Builder.getMutableConfig();
            Config$Option config$Option = ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR;
            if ((object4 = object4.retrieveOption(config$Option, null)) == null && !bl4) {
                object = useCaseConfig$Builder.getMutableConfig();
                object4 = ImageInputConfig.OPTION_INPUT_FORMAT;
                int n11 = 256;
                object2 = n11;
                object.insertOption((Config$Option)object4, object2);
            } else {
                object = useCaseConfig$Builder.getMutableConfig();
                object4 = ImageInputConfig.OPTION_INPUT_FORMAT;
                object2 = n10;
                object.insertOption((Config$Option)object4, object2);
            }
        }
        object = useCaseConfig$Builder.getMutableConfig();
        object4 = ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES;
        int n12 = 2;
        object2 = n12;
        object = (Integer)object.retrieveOption((Config$Option)object4, object2);
        boolean bl10 = ((Integer)object).intValue();
        if (bl10 >= bl7) {
            bl6 = bl7;
        }
        Preconditions.checkArgument(bl6, "Maximum outstanding image count must be at least 1");
        return useCaseConfig$Builder.getUseCaseConfig();
    }

    public void onStateDetached() {
        this.abortImageCaptureRequests();
    }

    public Size onSuggestedResolutionUpdated(Size size) {
        Object object = this.getCameraId();
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig)this.getCurrentConfig();
        this.mSessionConfigBuilder = object = this.createPipeline((String)object, imageCaptureConfig, size);
        object = ((SessionConfig$Builder)object).build();
        this.updateSessionConfig((SessionConfig)object);
        this.notifyActive();
        return size;
    }

    public /* synthetic */ void p(ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        this.o(imageCapture$OnImageCapturedCallback);
    }

    public void postTakePicture(ImageCapture$TakePictureState imageCapture$TakePictureState) {
        this.cancelAfAeTrigger(imageCapture$TakePictureState);
        this.unlockFlashMode();
    }

    public /* synthetic */ void r(Executor executor, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        this.q(executor, imageCapture$OnImageCapturedCallback);
    }

    public void setCropAspectRatio(Rational rational) {
        this.mCropAspectRatio = rational;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setFlashMode(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1) && n10 != (n11 = 2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid flash mode: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        AtomicReference atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            this.mFlashMode = n10;
            this.trySetFlashModeToCameraControl();
            return;
        }
    }

    public void setTargetRotation(int n10) {
        Rational rational;
        int n11 = this.getTargetRotation();
        boolean bl2 = this.setTargetRotationInternal(n10);
        if (bl2 && (rational = this.mCropAspectRatio) != null) {
            Rational rational2;
            n11 = CameraOrientationUtil.surfaceRotationToDegrees(n11);
            n10 = Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(n10) - n11);
            Rational rational3 = this.mCropAspectRatio;
            this.mCropAspectRatio = rational2 = ImageUtil.getRotatedAspectRatio(n10, rational3);
        }
    }

    public /* synthetic */ void t(ImageCapture$OutputFileOptions imageCapture$OutputFileOptions, Executor executor, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        this.s(imageCapture$OutputFileOptions, executor, imageCapture$OnImageSavedCallback);
    }

    public void takePicture(ImageCapture$OutputFileOptions object, Executor executor, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        Object object2;
        Object object3 = Looper.getMainLooper();
        if (object3 != (object2 = Looper.myLooper())) {
            object3 = CameraXExecutors.mainThreadExecutor();
            object2 = new d0(this, (ImageCapture$OutputFileOptions)object, executor, imageCapture$OnImageSavedCallback);
            object3.execute((Runnable)object2);
            return;
        }
        ImageCapture$2 imageCapture$2 = new ImageCapture$2(this, imageCapture$OnImageSavedCallback);
        object3 = new ImageCapture$3(this, (ImageCapture$OutputFileOptions)object, executor, imageCapture$2, imageCapture$OnImageSavedCallback);
        object = CameraXExecutors.mainThreadExecutor();
        this.sendImageCaptureRequest((Executor)object, (ImageCapture$OnImageCapturedCallback)object3);
    }

    public void takePicture(Executor executor, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        Object object;
        Object object2 = Looper.getMainLooper();
        if (object2 != (object = Looper.myLooper())) {
            object2 = CameraXExecutors.mainThreadExecutor();
            object = new l0(this, executor, imageCapture$OnImageCapturedCallback);
            object2.execute((Runnable)object);
            return;
        }
        this.sendImageCaptureRequest(executor, imageCapture$OnImageCapturedCallback);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImageCapture:");
        String string2 = this.getName();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public ListenableFuture triggerAePrecapture(ImageCapture$TakePictureState imageCapture$TakePictureState) {
        Logger.d(TAG, "triggerAePrecapture");
        imageCapture$TakePictureState.mIsAePrecaptureTriggered = true;
        return this.getCameraControl().triggerAePrecapture();
    }

    public void triggerAfIfNeeded(ImageCapture$TakePictureState imageCapture$TakePictureState) {
        Enum enum_;
        Enum enum_2;
        boolean bl2 = this.mEnableCheck3AConverged;
        if (bl2 && (enum_2 = imageCapture$TakePictureState.mPreCaptureState.getAfMode()) == (enum_ = CameraCaptureMetaData$AfMode.ON_MANUAL_AUTO) && (enum_2 = imageCapture$TakePictureState.mPreCaptureState.getAfState()) == (enum_ = CameraCaptureMetaData$AfState.INACTIVE)) {
            this.triggerAf(imageCapture$TakePictureState);
        }
    }

    public /* synthetic */ Object v(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.u(imageCapture$ImageCaptureRequest, callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ ListenableFuture y(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest, Void void_) {
        return this.x(imageCapture$ImageCaptureRequest, void_);
    }
}

