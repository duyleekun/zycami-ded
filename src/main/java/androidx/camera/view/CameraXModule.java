/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Rational
 *  android.util.Size
 */
package androidx.camera.view;

import android.content.Context;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraSelector$Builder;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$Builder;
import androidx.camera.core.ImageCapture$Metadata;
import androidx.camera.core.ImageCapture$OnImageCapturedCallback;
import androidx.camera.core.ImageCapture$OnImageSavedCallback;
import androidx.camera.core.ImageCapture$OutputFileOptions;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.Preview$Builder;
import androidx.camera.core.Preview$SurfaceProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.VideoCapture$Builder;
import androidx.camera.core.VideoCapture$OnVideoSavedCallback;
import androidx.camera.core.VideoCapture$OutputFileOptions;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraView;
import androidx.camera.view.CameraView$CaptureMode;
import androidx.camera.view.CameraXModule$3;
import androidx.camera.view.CameraXModule$4;
import androidx.camera.view.CameraXModule$5;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CameraXModule {
    private static final Rational ASPECT_RATIO_16_9;
    private static final Rational ASPECT_RATIO_3_4;
    private static final Rational ASPECT_RATIO_4_3;
    private static final Rational ASPECT_RATIO_9_16;
    public static final String TAG = "CameraXModule";
    private static final float UNITY_ZOOM_SCALE = 1.0f;
    private static final float ZOOM_NOT_SUPPORTED = 1.0f;
    public Camera mCamera;
    public Integer mCameraLensFacing;
    public ProcessCameraProvider mCameraProvider;
    private final CameraView mCameraView;
    private CameraView$CaptureMode mCaptureMode;
    public LifecycleOwner mCurrentLifecycle;
    private final LifecycleObserver mCurrentLifecycleObserver;
    private int mFlash;
    private ImageCapture mImageCapture;
    private final ImageCapture$Builder mImageCaptureBuilder;
    private long mMaxVideoDuration;
    private long mMaxVideoSize;
    private LifecycleOwner mNewLifecycle;
    public Preview mPreview;
    private final Preview$Builder mPreviewBuilder;
    private VideoCapture mVideoCapture;
    private final VideoCapture$Builder mVideoCaptureBuilder;
    public final AtomicBoolean mVideoIsRecording;

    static {
        Rational rational;
        int n10 = 16;
        int n11 = 9;
        ASPECT_RATIO_16_9 = rational = new Rational(n10, n11);
        int n12 = 4;
        int n13 = 3;
        ASPECT_RATIO_4_3 = rational = new Rational(n12, n13);
        ASPECT_RATIO_9_16 = rational = new Rational(n11, n10);
        ASPECT_RATIO_3_4 = rational = new Rational(n13, n12);
    }

    public CameraXModule(CameraView object) {
        long l10;
        Object object2;
        this.mVideoIsRecording = object2 = new AtomicBoolean(false);
        object2 = CameraView$CaptureMode.IMAGE;
        this.mCaptureMode = object2;
        this.mMaxVideoDuration = l10 = (long)-1;
        this.mMaxVideoSize = l10;
        this.mFlash = 2;
        super(this);
        this.mCurrentLifecycleObserver = object2;
        object2 = 1;
        this.mCameraLensFacing = object2;
        this.mCameraView = object;
        object = ProcessCameraProvider.getInstance(object.getContext());
        super(this);
        ScheduledExecutorService scheduledExecutorService = CameraXExecutors.mainThreadExecutor();
        Futures.addCallback((ListenableFuture)object, (FutureCallback)object2, scheduledExecutorService);
        super();
        this.mPreviewBuilder = object = ((Preview$Builder)object).setTargetName("Preview");
        object = new ImageCapture$Builder();
        this.mImageCaptureBuilder = object = ((ImageCapture$Builder)object).setTargetName("ImageCapture");
        object = new VideoCapture$Builder();
        this.mVideoCaptureBuilder = object = ((VideoCapture$Builder)object).setTargetName("VideoCapture");
    }

    private Set getAvailableCameraLensFacing() {
        Object object = Arrays.asList(LensFacingConverter.values());
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>((Collection<Integer>)object);
        object = this.mCurrentLifecycle;
        if (object != null) {
            int n10 = 1;
            boolean bl2 = this.hasCameraWithLensFacing(n10);
            if (!bl2) {
                object = n10;
                linkedHashSet.remove(object);
            }
            n10 = 0;
            object = null;
            bl2 = this.hasCameraWithLensFacing(0);
            if (!bl2) {
                object = 0;
                linkedHashSet.remove(object);
            }
        }
        return linkedHashSet;
    }

    private int getMeasuredHeight() {
        return this.mCameraView.getMeasuredHeight();
    }

    private int getMeasuredWidth() {
        return this.mCameraView.getMeasuredWidth();
    }

    private void rebindToLifecycle() {
        LifecycleOwner lifecycleOwner = this.mCurrentLifecycle;
        if (lifecycleOwner != null) {
            this.bindToLifecycle(lifecycleOwner);
        }
    }

    private void updateViewInfo() {
        int n10;
        UseCase useCase = this.mImageCapture;
        if (useCase != null) {
            int n11 = this.getWidth();
            int n12 = this.getHeight();
            Rational rational = new Rational(n11, n12);
            ((ImageCapture)useCase).setCropAspectRatio(rational);
            useCase = this.mImageCapture;
            n10 = this.getDisplaySurfaceRotation();
            ((ImageCapture)useCase).setTargetRotation(n10);
        }
        if ((useCase = this.mVideoCapture) != null) {
            n10 = this.getDisplaySurfaceRotation();
            ((VideoCapture)useCase).setTargetRotation(n10);
        }
    }

    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mNewLifecycle = lifecycleOwner;
        int n10 = this.getMeasuredWidth();
        if (n10 > 0 && (n10 = this.getMeasuredHeight()) > 0) {
            this.bindToLifecycleAfterViewMeasured();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void bindToLifecycleAfterViewMeasured() {
        var1_1 = this.mNewLifecycle;
        if (var1_1 == null) {
            return;
        }
        this.clearCurrentLifecycle();
        var1_1 = this.mNewLifecycle.getLifecycle().getCurrentState();
        var2_2 = Lifecycle$State.DESTROYED;
        var3_3 = 0;
        var4_4 = 0.0f;
        var5_5 = null;
        if (var1_1 == var2_2) {
            this.mNewLifecycle = null;
            return;
        }
        var1_1 = this.mNewLifecycle;
        this.mCurrentLifecycle = var1_1;
        this.mNewLifecycle = null;
        var1_1 = this.mCameraProvider;
        if (var1_1 == null) {
            return;
        }
        var1_1 = this.getAvailableCameraLensFacing();
        var6_6 = var1_1.isEmpty();
        var7_7 /* !! */  = "CameraXModule";
        if (var6_6) {
            var2_2 = "Unable to bindToLifeCycle since no cameras available";
            Logger.w(var7_7 /* !! */ , (String)var2_2);
            this.mCameraLensFacing = null;
        }
        if ((var2_2 = this.mCameraLensFacing) != null && !(var6_6 = var1_1.contains(var2_2))) {
            var2_2 = new StringBuilder();
            var2_2.append("Camera does not exist with direction ");
            var5_5 = this.mCameraLensFacing;
            var2_2.append(var5_5);
            var2_2 = var2_2.toString();
            Logger.w(var7_7 /* !! */ , (String)var2_2);
            this.mCameraLensFacing = var1_1 = (Integer)var1_1.iterator().next();
            var1_1 = new StringBuilder();
            var1_1.append("Defaulting to primary camera with direction ");
            var2_2 = this.mCameraLensFacing;
            var1_1.append(var2_2);
            var1_1 = var1_1.toString();
            Logger.w(var7_7 /* !! */ , (String)var1_1);
        }
        if ((var1_1 = this.mCameraLensFacing) == null) {
            return;
        }
        var8_8 = this.getDisplayRotationDegrees();
        var6_6 = false;
        var2_2 = null;
        var3_3 = 1;
        var4_4 = 1.4E-45f;
        if (var8_8 == 0) ** GOTO lbl-1000
        var8_8 = this.getDisplayRotationDegrees();
        var9_9 = 180;
        var10_10 = 2.52E-43f;
        if (var8_8 != var9_9) {
            var8_8 = 0;
            var1_1 = null;
            var11_11 = 0.0f;
        } else lbl-1000:
        // 2 sources

        {
            var8_8 = var3_3;
            var11_11 = var4_4;
        }
        var7_7 /* !! */  = this.getCaptureMode();
        var12_12 /* !! */  = CameraView$CaptureMode.IMAGE;
        if (var7_7 /* !! */  == var12_12 /* !! */ ) {
            var1_1 = var8_8 != 0 ? CameraXModule.ASPECT_RATIO_3_4 : CameraXModule.ASPECT_RATIO_4_3;
        } else {
            this.mImageCaptureBuilder.setTargetAspectRatio(var3_3);
            var7_7 /* !! */  = this.mVideoCaptureBuilder;
            var7_7 /* !! */ .setTargetAspectRatio(var3_3);
            var1_1 = var8_8 != 0 ? CameraXModule.ASPECT_RATIO_9_16 : CameraXModule.ASPECT_RATIO_16_9;
        }
        var7_7 /* !! */  = this.mImageCaptureBuilder;
        var13_13 = this.getDisplaySurfaceRotation();
        var7_7 /* !! */ .setTargetRotation(var13_13);
        this.mImageCapture = var7_7 /* !! */  = this.mImageCaptureBuilder.build();
        var7_7 /* !! */  = this.mVideoCaptureBuilder;
        var13_13 = this.getDisplaySurfaceRotation();
        var7_7 /* !! */ .setTargetRotation(var13_13);
        this.mVideoCapture = var7_7 /* !! */  = this.mVideoCaptureBuilder.build();
        var10_10 = this.getMeasuredWidth();
        var11_11 = var1_1.floatValue();
        var8_8 = (int)(var10_10 /= var11_11);
        var7_7 /* !! */  = this.mPreviewBuilder;
        var15_15 = this.getMeasuredWidth();
        var14_14 = new Size(var15_15, var8_8);
        var7_7 /* !! */ .setTargetResolution((Size)var14_14);
        this.mPreview = var1_1 = this.mPreviewBuilder.build();
        var7_7 /* !! */  = this.mCameraView.getPreviewView().getSurfaceProvider();
        var1_1.setSurfaceProvider((Preview$SurfaceProvider)var7_7 /* !! */ );
        var1_1 = new CameraSelector$Builder();
        var9_9 = this.mCameraLensFacing;
        var1_1 = var1_1.requireLensFacing(var9_9).build();
        var7_7 /* !! */  = this.getCaptureMode();
        var13_13 = 2;
        if (var7_7 /* !! */  == var12_12 /* !! */ ) {
            var7_7 /* !! */  = this.mCameraProvider;
            var12_12 /* !! */  = this.mCurrentLifecycle;
            var14_14 = new UseCase[var13_13];
            var16_16 = this.mImageCapture;
            var14_14[0] = var16_16;
            var14_14[var3_3] = var2_2 = this.mPreview;
            this.mCamera = var1_1 = var7_7 /* !! */ .bindToLifecycle((LifecycleOwner)var12_12 /* !! */ , (CameraSelector)var1_1, var14_14);
        } else {
            var7_7 /* !! */  = this.getCaptureMode();
            if (var7_7 /* !! */  == (var12_12 /* !! */  = CameraView$CaptureMode.VIDEO)) {
                var7_7 /* !! */  = this.mCameraProvider;
                var12_12 /* !! */  = this.mCurrentLifecycle;
                var14_14 = new UseCase[var13_13];
                var16_17 = this.mVideoCapture;
                var14_14[0] = var16_17;
                var14_14[var3_3] = var2_2 = this.mPreview;
                this.mCamera = var1_1 = var7_7 /* !! */ .bindToLifecycle((LifecycleOwner)var12_12 /* !! */ , (CameraSelector)var1_1, var14_14);
            } else {
                var7_7 /* !! */  = this.mCameraProvider;
                var12_12 /* !! */  = this.mCurrentLifecycle;
                var15_15 = 3;
                var16_18 = new UseCase[var15_15];
                var17_19 = this.mImageCapture;
                var16_18[0] = var17_19;
                var16_18[var3_3] = var2_2 = this.mVideoCapture;
                var16_18[var13_13] = var2_2 = this.mPreview;
                this.mCamera = var1_1 = var7_7 /* !! */ .bindToLifecycle((LifecycleOwner)var12_12 /* !! */ , (CameraSelector)var1_1, var16_18);
            }
        }
        this.setZoomRatio(1.0f);
        var1_1 = this.mCurrentLifecycle.getLifecycle();
        var2_2 = this.mCurrentLifecycleObserver;
        var1_1.addObserver((LifecycleObserver)var2_2);
        var8_8 = this.getFlash();
        this.setFlash(var8_8);
    }

    public void clearCurrentLifecycle() {
        Object object = this.mCurrentLifecycle;
        if (object != null && (object = this.mCameraProvider) != null) {
            UseCase[] useCaseArray;
            boolean bl2;
            object = new ArrayList();
            Object object2 = this.mImageCapture;
            if (object2 != null && (bl2 = (useCaseArray = this.mCameraProvider).isBound((UseCase)object2))) {
                object2 = this.mImageCapture;
                object.add(object2);
            }
            if ((object2 = this.mVideoCapture) != null && (bl2 = (useCaseArray = this.mCameraProvider).isBound((UseCase)object2))) {
                object2 = this.mVideoCapture;
                object.add(object2);
            }
            if ((object2 = this.mPreview) != null && (bl2 = (useCaseArray = this.mCameraProvider).isBound((UseCase)object2))) {
                object2 = this.mPreview;
                object.add(object2);
            }
            if (!(bl2 = object.isEmpty())) {
                object2 = this.mCameraProvider;
                useCaseArray = new UseCase[]{};
                object = object.toArray(useCaseArray);
                ((ProcessCameraProvider)object2).unbind((UseCase)object);
            }
            if ((object = this.mPreview) != null) {
                object.setSurfaceProvider(null);
            }
        }
        this.mCamera = null;
        this.mCurrentLifecycle = null;
    }

    public void close() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
        throw unsupportedOperationException;
    }

    public void enableTorch(boolean bl2) {
        Object object = this.mCamera;
        if (object == null) {
            return;
        }
        ListenableFuture listenableFuture = object.getCameraControl().enableTorch(bl2);
        object = new CameraXModule$5(this);
        Executor executor = CameraXExecutors.directExecutor();
        Futures.addCallback(listenableFuture, (FutureCallback)object, executor);
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public CameraView$CaptureMode getCaptureMode() {
        return this.mCaptureMode;
    }

    public Context getContext() {
        return this.mCameraView.getContext();
    }

    public int getDisplayRotationDegrees() {
        return CameraOrientationUtil.surfaceRotationToDegrees(this.getDisplaySurfaceRotation());
    }

    public int getDisplaySurfaceRotation() {
        return this.mCameraView.getDisplaySurfaceRotation();
    }

    public int getFlash() {
        return this.mFlash;
    }

    public int getHeight() {
        return this.mCameraView.getHeight();
    }

    public Integer getLensFacing() {
        return this.mCameraLensFacing;
    }

    public long getMaxVideoDuration() {
        return this.mMaxVideoDuration;
    }

    public long getMaxVideoSize() {
        return this.mMaxVideoSize;
    }

    public float getMaxZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return ((ZoomState)camera.getCameraInfo().getZoomState().getValue()).getMaxZoomRatio();
        }
        return 1.0f;
    }

    public float getMinZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return ((ZoomState)camera.getCameraInfo().getZoomState().getValue()).getMinZoomRatio();
        }
        return 1.0f;
    }

    public int getRelativeCameraOrientation(boolean bl2) {
        int n10;
        Object object = this.mCamera;
        if (object != null) {
            object = object.getCameraInfo();
            int n11 = this.getDisplaySurfaceRotation();
            n10 = object.getSensorRotationDegrees(n11);
            if (bl2) {
                int n12 = 360 - n10;
                n10 = n12 % 360;
            }
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public int getWidth() {
        return this.mCameraView.getWidth();
    }

    public float getZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return ((ZoomState)camera.getCameraInfo().getZoomState().getValue()).getZoomRatio();
        }
        return 1.0f;
    }

    public boolean hasCameraWithLensFacing(int n10) {
        CameraSelector$Builder cameraSelector$Builder;
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider == null) {
            return false;
        }
        try {
            cameraSelector$Builder = new CameraSelector$Builder();
        }
        catch (CameraInfoUnavailableException cameraInfoUnavailableException) {
            return false;
        }
        Object object = cameraSelector$Builder.requireLensFacing(n10);
        object = ((CameraSelector$Builder)object).build();
        return processCameraProvider.hasCamera((CameraSelector)object);
    }

    public void invalidateView() {
        this.updateViewInfo();
    }

    public boolean isBoundToLifecycle() {
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

    public boolean isPaused() {
        return false;
    }

    public boolean isRecording() {
        return this.mVideoIsRecording.get();
    }

    public boolean isTorchOn() {
        int n10;
        Object object = this.mCamera;
        int n11 = 0;
        if (object == null) {
            return false;
        }
        int n12 = (Integer)(object = (Integer)object.getCameraInfo().getTorchState().getValue());
        if (n12 == (n10 = 1)) {
            n11 = n10;
        }
        return n11 != 0;
    }

    public boolean isZoomSupported() {
        float f10;
        float f11 = this.getMaxZoomRatio();
        float f12 = f11 - (f10 = 1.0f);
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 != false) {
            f13 = 1.0f;
            f11 = Float.MIN_VALUE;
        } else {
            f13 = 0.0f;
            f11 = 0.0f;
        }
        return (boolean)f13;
    }

    public void open() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
        throw unsupportedOperationException;
    }

    public void setCameraLensFacing(Integer object) {
        Integer n10 = this.mCameraLensFacing;
        boolean bl2 = Objects.equals(n10, object);
        if (!bl2) {
            this.mCameraLensFacing = object;
            object = this.mCurrentLifecycle;
            if (object != null) {
                this.bindToLifecycle((LifecycleOwner)object);
            }
        }
    }

    public void setCaptureMode(CameraView$CaptureMode cameraView$CaptureMode) {
        this.mCaptureMode = cameraView$CaptureMode;
        this.rebindToLifecycle();
    }

    public void setFlash(int n10) {
        this.mFlash = n10;
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture == null) {
            return;
        }
        imageCapture.setFlashMode(n10);
    }

    public void setMaxVideoDuration(long l10) {
        this.mMaxVideoDuration = l10;
    }

    public void setMaxVideoSize(long l10) {
        this.mMaxVideoSize = l10;
    }

    public void setZoomRatio(float f10) {
        Object object = this.mCamera;
        if (object != null) {
            ListenableFuture listenableFuture = object.getCameraControl().setZoomRatio(f10);
            object = new CameraXModule$4(this);
            Executor executor = CameraXExecutors.directExecutor();
            Futures.addCallback(listenableFuture, (FutureCallback)object, executor);
        } else {
            String string2 = TAG;
            object = "Failed to set zoom ratio";
            Logger.e(string2, (String)object);
        }
    }

    public void startRecording(VideoCapture$OutputFileOptions object, Executor executor, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        Object object2;
        Object object3 = this.mVideoCapture;
        if (object3 == null) {
            return;
        }
        object3 = this.getCaptureMode();
        if (object3 != (object2 = CameraView$CaptureMode.IMAGE)) {
            if (videoCapture$OnVideoSavedCallback != null) {
                this.mVideoIsRecording.set(true);
                object3 = this.mVideoCapture;
                object2 = new CameraXModule$3(this, videoCapture$OnVideoSavedCallback);
                object3.startRecording((VideoCapture$OutputFileOptions)object, executor, (VideoCapture$OnVideoSavedCallback)object2);
                return;
            }
            object = new IllegalArgumentException("OnVideoSavedCallback should not be empty");
            throw object;
        }
        object = new IllegalStateException("Can not record video under IMAGE capture mode.");
        throw object;
    }

    public void stopRecording() {
        VideoCapture videoCapture = this.mVideoCapture;
        if (videoCapture == null) {
            return;
        }
        videoCapture.stopRecording();
    }

    public void takePicture(ImageCapture$OutputFileOptions object, Executor executor, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        Object object2;
        Object object3 = this.mImageCapture;
        if (object3 == null) {
            return;
        }
        object3 = this.getCaptureMode();
        if (object3 != (object2 = CameraView$CaptureMode.VIDEO)) {
            if (imageCapture$OnImageSavedCallback != null) {
                boolean bl2;
                object3 = ((ImageCapture$OutputFileOptions)object).getMetadata();
                object2 = this.mCameraLensFacing;
                if (object2 != null && !(bl2 = ((Integer)object2).intValue())) {
                    bl2 = true;
                } else {
                    bl2 = false;
                    object2 = null;
                }
                ((ImageCapture$Metadata)object3).setReversedHorizontal(bl2);
                this.mImageCapture.takePicture((ImageCapture$OutputFileOptions)object, executor, imageCapture$OnImageSavedCallback);
                return;
            }
            object = new IllegalArgumentException("OnImageSavedCallback should not be empty");
            throw object;
        }
        object = new IllegalStateException("Can not take picture under VIDEO capture mode.");
        throw object;
    }

    public void takePicture(Executor object, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        CameraView$CaptureMode cameraView$CaptureMode;
        Object object2 = this.mImageCapture;
        if (object2 == null) {
            return;
        }
        object2 = this.getCaptureMode();
        if (object2 != (cameraView$CaptureMode = CameraView$CaptureMode.VIDEO)) {
            if (imageCapture$OnImageCapturedCallback != null) {
                this.mImageCapture.takePicture((Executor)object, imageCapture$OnImageCapturedCallback);
                return;
            }
            object = new IllegalArgumentException("OnImageCapturedCallback should not be empty");
            throw object;
        }
        object = new IllegalStateException("Can not take picture under VIDEO capture mode.");
        throw object;
    }

    public void toggleCamera() {
        boolean bl2;
        int n10;
        Object object = this.getAvailableCameraLensFacing();
        int n11 = object.isEmpty();
        if (n11 != 0) {
            return;
        }
        Integer n12 = this.mCameraLensFacing;
        if (n12 == null) {
            object = (Integer)object.iterator().next();
            this.setCameraLensFacing((Integer)object);
            return;
        }
        n11 = n12;
        if (n11 == (n10 = 1)) {
            n11 = 0;
            n12 = null;
            Integer n13 = 0;
            boolean bl3 = object.contains(n13);
            if (bl3) {
                object = 0;
                this.setCameraLensFacing((Integer)object);
                return;
            }
        }
        if ((n11 = (n12 = this.mCameraLensFacing).intValue()) == 0 && (bl2 = object.contains(n12 = Integer.valueOf(n10)))) {
            object = n10;
            this.setCameraLensFacing((Integer)object);
        }
    }
}

