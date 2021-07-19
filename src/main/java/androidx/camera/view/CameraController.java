/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.hardware.display.DisplayManager$DisplayListener
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.Display
 */
package androidx.camera.view;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringAction$Builder;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysis$Analyzer;
import androidx.camera.core.ImageAnalysis$Builder;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$Builder;
import androidx.camera.core.ImageCapture$Metadata;
import androidx.camera.core.ImageCapture$OnImageCapturedCallback;
import androidx.camera.core.ImageCapture$OnImageSavedCallback;
import androidx.camera.core.ImageCapture$OutputFileOptions;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.Preview$Builder;
import androidx.camera.core.Preview$SurfaceProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.UseCaseGroup$Builder;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.VideoCapture$Builder;
import androidx.camera.core.VideoCapture$OutputFileOptions;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraController$1;
import androidx.camera.view.CameraController$2;
import androidx.camera.view.CameraController$DisplayRotationListener;
import androidx.camera.view.ForwardingLiveData;
import androidx.camera.view.SensorRotationListener;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import b.a.d.b;
import b.a.d.c;
import b.a.d.d;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached.";
    private static final String TAG = "CameraController";
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    private ImageAnalysis$Analyzer mAnalysisAnalyzer;
    private Executor mAnalysisExecutor;
    private final Context mAppContext;
    public Camera mCamera;
    public ProcessCameraProvider mCameraProvider;
    public CameraSelector mCameraSelector;
    private final CameraController$DisplayRotationListener mDisplayRotationListener;
    private int mEnabledUseCases;
    private ImageAnalysis mImageAnalysis;
    public final ImageCapture mImageCapture;
    private final ListenableFuture mInitializationFuture;
    private boolean mPinchToZoomEnabled;
    public final Preview mPreview;
    public Display mPreviewDisplay;
    public final SensorRotationListener mSensorRotationListener;
    public Preview$SurfaceProvider mSurfaceProvider;
    private boolean mTapToFocusEnabled;
    private final ForwardingLiveData mTorchState;
    public final VideoCapture mVideoCapture;
    public final AtomicBoolean mVideoIsRecording;
    public ViewPort mViewPort;
    private final ForwardingLiveData mZoomState;

    public CameraController(Context context) {
        boolean bl2;
        Object object = CameraSelector.DEFAULT_BACK_CAMERA;
        this.mCameraSelector = object;
        this.mEnabledUseCases = 3;
        this.mVideoIsRecording = object = new AtomicBoolean(false);
        this.mPinchToZoomEnabled = bl2 = true;
        this.mTapToFocusEnabled = bl2;
        this.mZoomState = object = new ForwardingLiveData();
        this.mTorchState = object = new ForwardingLiveData();
        this.mAppContext = context = context.getApplicationContext();
        object = new Preview$Builder();
        this.mPreview = object = ((Preview$Builder)object).build();
        object = new ImageCapture$Builder();
        this.mImageCapture = object = ((ImageCapture$Builder)object).build();
        object = new ImageAnalysis$Builder();
        this.mImageAnalysis = object = ((ImageAnalysis$Builder)object).build();
        object = new VideoCapture$Builder();
        this.mVideoCapture = object = ((VideoCapture$Builder)object).build();
        object = ProcessCameraProvider.getInstance(context);
        c c10 = new c(this);
        ScheduledExecutorService scheduledExecutorService = CameraXExecutors.mainThreadExecutor();
        this.mInitializationFuture = object = Futures.transform((ListenableFuture)object, c10, scheduledExecutorService);
        this.mDisplayRotationListener = object = new CameraController$DisplayRotationListener(this);
        object = new CameraController$1(this, context);
        this.mSensorRotationListener = object;
    }

    private /* synthetic */ Void a(ProcessCameraProvider processCameraProvider) {
        this.mCameraProvider = processCameraProvider;
        this.startCameraAndTrackStates();
        return null;
    }

    private /* synthetic */ void c(CameraSelector cameraSelector) {
        this.mCameraSelector = cameraSelector;
    }

    private /* synthetic */ void e(int n10) {
        this.mEnabledUseCases = n10;
    }

    private DisplayManager getDisplayManager() {
        return (DisplayManager)this.mAppContext.getSystemService("display");
    }

    private boolean isCameraAttached() {
        boolean bl2;
        Camera camera = this.mCamera;
        if (camera != null) {
            bl2 = true;
        } else {
            bl2 = false;
            camera = null;
        }
        return bl2;
    }

    private boolean isCameraInitialized() {
        boolean bl2;
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            bl2 = true;
        } else {
            bl2 = false;
            processCameraProvider = null;
        }
        return bl2;
    }

    private boolean isPreviewViewAttached() {
        boolean bl2;
        Object object = this.mSurfaceProvider;
        if (object != null && (object = this.mViewPort) != null && (object = this.mPreviewDisplay) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private boolean isUseCaseEnabled(int n10) {
        int n11 = this.mEnabledUseCases;
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    private boolean isVideoCaptureEnabledInternal() {
        return this.isVideoCaptureEnabled();
    }

    private float speedUpZoomBy2X(float f10) {
        float f11 = 1.0f;
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        float f13 = 2.0f;
        if (f12 > 0) {
            return (f10 - f11) * f13 + f11;
        }
        f10 = (f11 - f10) * f13;
        return f11 - f10;
    }

    private void startListeningToRotationEvents() {
        Object object = this.getDisplayManager();
        CameraController$DisplayRotationListener cameraController$DisplayRotationListener = this.mDisplayRotationListener;
        Looper looper = Looper.getMainLooper();
        Handler handler = new Handler(looper);
        object.registerDisplayListener((DisplayManager.DisplayListener)cameraController$DisplayRotationListener, handler);
        object = this.mSensorRotationListener;
        boolean bl2 = object.canDetectOrientation();
        if (bl2) {
            object = this.mSensorRotationListener;
            object.enable();
        }
    }

    private void stopListeningToRotationEvents() {
        DisplayManager displayManager = this.getDisplayManager();
        CameraController$DisplayRotationListener cameraController$DisplayRotationListener = this.mDisplayRotationListener;
        displayManager.unregisterDisplayListener((DisplayManager.DisplayListener)cameraController$DisplayRotationListener);
        this.mSensorRotationListener.disable();
    }

    private void unbindImageAnalysisAndRecreate(int n10, int n11) {
        ImageAnalysis imageAnalysis;
        Object object;
        boolean bl2 = this.isCameraInitialized();
        if (bl2) {
            object = this.mCameraProvider;
            int n12 = 1;
            UseCase[] useCaseArray = new UseCase[n12];
            ImageAnalysis imageAnalysis2 = this.mImageAnalysis;
            useCaseArray[0] = imageAnalysis2;
            ((ProcessCameraProvider)object).unbind(useCaseArray);
        }
        object = new ImageAnalysis$Builder();
        this.mImageAnalysis = imageAnalysis = ((ImageAnalysis$Builder)object).setBackpressureStrategy(n10).setImageQueueDepth(n11).build();
        Executor executor = this.mAnalysisExecutor;
        if (executor != null && (object = this.mAnalysisAnalyzer) != null) {
            imageAnalysis.setAnalyzer(executor, (ImageAnalysis$Analyzer)object);
        }
    }

    public void attachPreviewSurface(Preview$SurfaceProvider preview$SurfaceProvider, ViewPort viewPort, Display display) {
        Threads.checkMainThread();
        Object object = this.mSurfaceProvider;
        if (object != preview$SurfaceProvider) {
            this.mSurfaceProvider = preview$SurfaceProvider;
            object = this.mPreview;
            ((Preview)object).setSurfaceProvider(preview$SurfaceProvider);
        }
        this.mViewPort = viewPort;
        this.mPreviewDisplay = display;
        this.startListeningToRotationEvents();
        this.startCameraAndTrackStates();
    }

    public /* synthetic */ Void b(ProcessCameraProvider processCameraProvider) {
        return this.a(processCameraProvider);
    }

    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
    }

    public void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
        this.mPreview.setSurfaceProvider(null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        this.mPreviewDisplay = null;
        this.stopListeningToRotationEvents();
    }

    public UseCaseGroup createUseCaseGroup() {
        UseCase useCase;
        Object object;
        boolean bl2 = this.isCameraInitialized();
        boolean bl3 = false;
        Object object2 = null;
        String string2 = TAG;
        if (!bl2) {
            Logger.d(string2, CAMERA_NOT_INITIALIZED);
            return null;
        }
        bl2 = this.isPreviewViewAttached();
        if (!bl2) {
            Logger.d(string2, PREVIEW_VIEW_NOT_ATTACHED);
            return null;
        }
        UseCaseGroup$Builder useCaseGroup$Builder = new UseCaseGroup$Builder();
        object2 = this.mPreview;
        useCaseGroup$Builder = useCaseGroup$Builder.addUseCase((UseCase)object2);
        bl3 = this.isImageCaptureEnabled();
        string2 = null;
        int n10 = 1;
        if (bl3) {
            object2 = this.mImageCapture;
            useCaseGroup$Builder.addUseCase((UseCase)object2);
        } else {
            object2 = this.mCameraProvider;
            object = new UseCase[n10];
            useCase = this.mImageCapture;
            object[0] = useCase;
            ((ProcessCameraProvider)object2).unbind((UseCase)object);
        }
        bl3 = this.isImageAnalysisEnabled();
        if (bl3) {
            object2 = this.mImageAnalysis;
            useCaseGroup$Builder.addUseCase((UseCase)object2);
        } else {
            object2 = this.mCameraProvider;
            object = new UseCase[n10];
            useCase = this.mImageAnalysis;
            object[0] = useCase;
            ((ProcessCameraProvider)object2).unbind((UseCase)object);
        }
        bl3 = this.isVideoCaptureEnabledInternal();
        if (bl3) {
            object2 = this.mVideoCapture;
            useCaseGroup$Builder.addUseCase((UseCase)object2);
        } else {
            object2 = this.mCameraProvider;
            UseCase[] useCaseArray = new UseCase[n10];
            useCaseArray[0] = object = this.mVideoCapture;
            ((ProcessCameraProvider)object2).unbind(useCaseArray);
        }
        object2 = this.mViewPort;
        useCaseGroup$Builder.setViewPort((ViewPort)object2);
        return useCaseGroup$Builder.build();
    }

    public /* synthetic */ void d(CameraSelector cameraSelector) {
        this.c(cameraSelector);
    }

    public ListenableFuture enableTorch(boolean bl2) {
        Threads.checkMainThread();
        boolean bl3 = this.isCameraAttached();
        if (!bl3) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return Futures.immediateFuture(null);
        }
        return this.mCamera.getCameraControl().enableTorch(bl2);
    }

    public /* synthetic */ void f(int n10) {
        this.e(n10);
    }

    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Object object = this.mCamera;
        object = object == null ? null : object.getCameraInfo();
        return object;
    }

    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    public ListenableFuture getInitializationFuture() {
        return this.mInitializationFuture;
    }

    public LiveData getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    public LiveData getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    public boolean hasCamera(CameraSelector object) {
        Threads.checkMainThread();
        Preconditions.checkNotNull(object);
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            try {
                return processCameraProvider.hasCamera((CameraSelector)object);
            }
            catch (CameraInfoUnavailableException cameraInfoUnavailableException) {
                Logger.w(TAG, "Failed to check camera availability", cameraInfoUnavailableException);
                return false;
            }
        }
        object = new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
        throw object;
    }

    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return this.isUseCaseEnabled(2);
    }

    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return this.isUseCaseEnabled(1);
    }

    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    public boolean isRecording() {
        Threads.checkMainThread();
        return this.mVideoIsRecording.get();
    }

    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return this.isUseCaseEnabled(4);
    }

    public void onPinchToZoom(float f10) {
        boolean bl2 = this.isCameraAttached();
        String string2 = TAG;
        if (!bl2) {
            Logger.w(string2, CAMERA_NOT_ATTACHED);
            return;
        }
        bl2 = this.mPinchToZoomEnabled;
        if (!bl2) {
            Logger.d(string2, "Pinch to zoom disabled.");
            return;
        }
        Object object = new StringBuilder();
        String string3 = "Pinch to zoom with scale: ";
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        Logger.d(string2, (String)object);
        object = (ZoomState)this.getZoomState().getValue();
        if (object == null) {
            return;
        }
        float f11 = object.getZoomRatio();
        f10 = this.speedUpZoomBy2X(f10);
        f11 *= f10;
        f10 = object.getMinZoomRatio();
        f10 = Math.max(f11, f10);
        float f12 = object.getMaxZoomRatio();
        f10 = Math.min(f10, f12);
        this.setZoomRatio(f10);
    }

    public void onTapToFocus(MeteringPointFactory object, float f10, float f11) {
        boolean bl2 = this.isCameraAttached();
        String string2 = TAG;
        if (!bl2) {
            Logger.w(string2, CAMERA_NOT_ATTACHED);
            return;
        }
        bl2 = this.mTapToFocusEnabled;
        if (!bl2) {
            Logger.d(string2, "Tap to focus disabled. ");
            return;
        }
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Tap to focus: ");
        ((StringBuilder)object2).append(f10);
        ((StringBuilder)object2).append(", ");
        ((StringBuilder)object2).append(f11);
        object2 = ((StringBuilder)object2).toString();
        Logger.d(string2, (String)object2);
        object2 = ((MeteringPointFactory)object).createPoint(f10, f11, 0.16666667f);
        object = ((MeteringPointFactory)object).createPoint(f10, f11, 0.25f);
        CameraControl cameraControl = this.mCamera.getCameraControl();
        FocusMeteringAction$Builder focusMeteringAction$Builder = new FocusMeteringAction$Builder((MeteringPoint)object2, 1);
        object = focusMeteringAction$Builder.addPoint((MeteringPoint)object, 2).build();
        cameraControl.startFocusAndMetering((FocusMeteringAction)object);
    }

    public void setCameraSelector(CameraSelector object) {
        Threads.checkMainThread();
        Object object2 = this.mCameraSelector;
        if (object2 == object) {
            return;
        }
        object2 = this.mCameraProvider;
        if (object2 == null) {
            return;
        }
        ((ProcessCameraProvider)object2).unbindAll();
        object2 = this.mCameraSelector;
        this.mCameraSelector = object;
        object = new d(this, (CameraSelector)object2);
        this.startCameraAndTrackStates((Runnable)object);
    }

    public void setEnabledUseCases(int n10) {
        Threads.checkMainThread();
        int n11 = this.mEnabledUseCases;
        if (n10 == n11) {
            return;
        }
        this.mEnabledUseCases = n10;
        n10 = this.isVideoCaptureEnabled() ? 1 : 0;
        if (n10 == 0) {
            this.stopRecording();
        }
        b b10 = new b(this, n11);
        this.startCameraAndTrackStates(b10);
    }

    public void setImageAnalysisAnalyzer(Executor executor, ImageAnalysis$Analyzer imageAnalysis$Analyzer) {
        Threads.checkMainThread();
        Object object = this.mAnalysisAnalyzer;
        if (object == imageAnalysis$Analyzer && (object = this.mAnalysisExecutor) == executor) {
            return;
        }
        this.mAnalysisExecutor = executor;
        this.mAnalysisAnalyzer = imageAnalysis$Analyzer;
        this.mImageAnalysis.setAnalyzer(executor, imageAnalysis$Analyzer);
    }

    public void setImageAnalysisBackpressureStrategy(int n10) {
        Threads.checkMainThread();
        ImageAnalysis imageAnalysis = this.mImageAnalysis;
        int n11 = imageAnalysis.getBackpressureStrategy();
        if (n11 == n10) {
            return;
        }
        n11 = this.mImageAnalysis.getImageQueueDepth();
        this.unbindImageAnalysisAndRecreate(n10, n11);
        this.startCameraAndTrackStates();
    }

    public void setImageAnalysisImageQueueDepth(int n10) {
        Threads.checkMainThread();
        ImageAnalysis imageAnalysis = this.mImageAnalysis;
        int n11 = imageAnalysis.getImageQueueDepth();
        if (n11 == n10) {
            return;
        }
        n11 = this.mImageAnalysis.getBackpressureStrategy();
        this.unbindImageAnalysisAndRecreate(n11, n10);
        this.startCameraAndTrackStates();
    }

    public void setImageCaptureFlashMode(int n10) {
        Threads.checkMainThread();
        this.mImageCapture.setFlashMode(n10);
    }

    public ListenableFuture setLinearZoom(float f10) {
        Threads.checkMainThread();
        boolean bl2 = this.isCameraAttached();
        if (!bl2) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return Futures.immediateFuture(null);
        }
        return this.mCamera.getCameraControl().setLinearZoom(f10);
    }

    public void setPinchToZoomEnabled(boolean bl2) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = bl2;
    }

    public void setTapToFocusEnabled(boolean bl2) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = bl2;
    }

    public ListenableFuture setZoomRatio(float f10) {
        Threads.checkMainThread();
        boolean bl2 = this.isCameraAttached();
        if (!bl2) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return Futures.immediateFuture(null);
        }
        return this.mCamera.getCameraControl().setZoomRatio(f10);
    }

    public abstract Camera startCamera();

    public void startCameraAndTrackStates() {
        this.startCameraAndTrackStates(null);
    }

    public void startCameraAndTrackStates(Runnable object) {
        Object object2;
        try {
            object2 = this.startCamera();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            if (object != null) {
                object.run();
            }
            object = new IllegalStateException("The selected camera does not support the enabled use cases. Please disable use case and/or select a different camera. e.g. #setVideoCaptureEnabled(false)", illegalArgumentException);
            throw object;
        }
        this.mCamera = object2;
        boolean bl2 = this.isCameraAttached();
        if (!bl2) {
            Logger.d("CameraController", "Use cases not attached to camera.");
            return;
        }
        object = this.mZoomState;
        object2 = this.mCamera.getCameraInfo().getZoomState();
        ((ForwardingLiveData)object).setSource((LiveData)object2);
        object = this.mTorchState;
        object2 = this.mCamera.getCameraInfo().getTorchState();
        ((ForwardingLiveData)object).setSource((LiveData)object2);
    }

    public void startRecording(OutputFileOptions object, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(this.isCameraInitialized(), "Camera not initialized.");
        Preconditions.checkState(this.isVideoCaptureEnabled(), "VideoCapture disabled.");
        VideoCapture videoCapture = this.mVideoCapture;
        object = ((OutputFileOptions)object).toVideoCaptureOutputFileOptions();
        CameraController$2 cameraController$2 = new CameraController$2(this, onVideoSavedCallback);
        videoCapture.startRecording((VideoCapture$OutputFileOptions)object, executor, cameraController$2);
        this.mVideoIsRecording.set(true);
    }

    public void stopRecording() {
        Threads.checkMainThread();
        Object object = this.mVideoIsRecording;
        boolean bl2 = ((AtomicBoolean)object).get();
        if (bl2) {
            object = this.mVideoCapture;
            ((VideoCapture)object).stopRecording();
        }
    }

    public void takePicture(ImageCapture$OutputFileOptions imageCapture$OutputFileOptions, Executor executor, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(this.isCameraInitialized(), "Camera not initialized.");
        Preconditions.checkState(this.isImageCaptureEnabled(), "ImageCapture disabled.");
        this.updateMirroringFlagInOutputFileOptions(imageCapture$OutputFileOptions);
        this.mImageCapture.takePicture(imageCapture$OutputFileOptions, executor, imageCapture$OnImageSavedCallback);
    }

    public void takePicture(Executor executor, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(this.isCameraInitialized(), "Camera not initialized.");
        Preconditions.checkState(this.isImageCaptureEnabled(), "ImageCapture disabled.");
        this.mImageCapture.takePicture(executor, imageCapture$OnImageCapturedCallback);
    }

    public void updateMirroringFlagInOutputFileOptions(ImageCapture$OutputFileOptions object) {
        int n10;
        Object object2 = this.mCameraSelector.getLensFacing();
        if (object2 != null && !(n10 = ((ImageCapture$Metadata)(object2 = ((ImageCapture$OutputFileOptions)object).getMetadata())).isReversedHorizontalSet())) {
            object = ((ImageCapture$OutputFileOptions)object).getMetadata();
            object2 = this.mCameraSelector.getLensFacing();
            n10 = (Integer)object2;
            if (!n10) {
                n10 = 1;
            } else {
                n10 = 0;
                object2 = null;
            }
            ((ImageCapture$Metadata)object).setReversedHorizontal(n10 != 0);
        }
    }
}

