/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.hardware.display.DisplayManager$DisplayListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.Display
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package androidx.camera.view;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringAction$Builder;
import androidx.camera.core.ImageCapture$OnImageCapturedCallback;
import androidx.camera.core.ImageCapture$OnImageSavedCallback;
import androidx.camera.core.ImageCapture$OutputFileOptions;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.VideoCapture$OutputFileOptions;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.CameraView$1;
import androidx.camera.view.CameraView$2;
import androidx.camera.view.CameraView$3;
import androidx.camera.view.CameraView$CaptureMode;
import androidx.camera.view.CameraView$PinchToZoomGestureDetector;
import androidx.camera.view.CameraXModule;
import androidx.camera.view.FlashModeConverter;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewView$ScaleType;
import androidx.camera.view.R$styleable;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.concurrent.Executor;

public final class CameraView
extends FrameLayout {
    private static final String EXTRA_CAMERA_DIRECTION = "camera_direction";
    private static final String EXTRA_CAPTURE_MODE = "captureMode";
    private static final String EXTRA_FLASH = "flash";
    private static final String EXTRA_MAX_VIDEO_DURATION = "max_video_duration";
    private static final String EXTRA_MAX_VIDEO_SIZE = "max_video_size";
    private static final String EXTRA_PINCH_TO_ZOOM_ENABLED = "pinch_to_zoom_enabled";
    private static final String EXTRA_SCALE_TYPE = "scale_type";
    private static final String EXTRA_SUPER = "super";
    private static final String EXTRA_ZOOM_RATIO = "zoom_ratio";
    private static final int FLASH_MODE_AUTO = 1;
    private static final int FLASH_MODE_OFF = 4;
    private static final int FLASH_MODE_ON = 2;
    public static final int INDEFINITE_VIDEO_DURATION = 255;
    public static final int INDEFINITE_VIDEO_SIZE = 255;
    private static final int LENS_FACING_BACK = 2;
    private static final int LENS_FACING_FRONT = 1;
    private static final int LENS_FACING_NONE;
    public static final String TAG;
    public CameraXModule mCameraModule;
    private final DisplayManager.DisplayListener mDisplayListener;
    private long mDownEventTimestamp;
    private boolean mIsPinchToZoomEnabled = true;
    private CameraView$PinchToZoomGestureDetector mPinchToZoomGestureDetector;
    private PreviewView mPreviewView;
    private MotionEvent mUpEvent;

    static {
        TAG = CameraView.class.getSimpleName();
    }

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        CameraView$1 cameraView$1 = new CameraView$1(this);
        this.mDisplayListener = cameraView$1;
        this.init(context, attributeSet);
    }

    public CameraView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        CameraView$1 cameraView$1 = new CameraView$1(this);
        this.mDisplayListener = cameraView$1;
        this.init(context, attributeSet);
    }

    private long delta() {
        long l10 = System.currentTimeMillis();
        long l11 = this.mDownEventTimestamp;
        return l10 - l11;
    }

    private long getMaxVideoSize() {
        return this.mCameraModule.getMaxVideoSize();
    }

    private void init(Context context, AttributeSet object) {
        Object object2;
        Context context2 = this.getContext();
        this.mPreviewView = object2 = new PreviewView(context2);
        int n10 = 0;
        context2 = null;
        this.addView((View)object2, 0);
        object2 = new CameraXModule(this);
        this.mCameraModule = object2;
        if (object != null) {
            object2 = R$styleable.CameraView;
            object = context.obtainStyledAttributes(object, (int[])object2);
            int n11 = R$styleable.CameraView_scaleType;
            int n12 = this.getScaleType().getId();
            object2 = PreviewView$ScaleType.fromId(object.getInteger(n11, n12));
            this.setScaleType((PreviewView$ScaleType)((Object)object2));
            n11 = R$styleable.CameraView_pinchToZoomEnabled;
            n12 = this.isPinchToZoomEnabled() ? 1 : 0;
            n11 = object.getBoolean(n11, n12 != 0) ? 1 : 0;
            this.setPinchToZoomEnabled(n11 != 0);
            n11 = R$styleable.CameraView_captureMode;
            CameraView$CaptureMode cameraView$CaptureMode = this.getCaptureMode();
            n12 = cameraView$CaptureMode.getId();
            object2 = CameraView$CaptureMode.fromId(object.getInteger(n11, n12));
            this.setCaptureMode((CameraView$CaptureMode)((Object)object2));
            n11 = R$styleable.CameraView_lensFacing;
            n12 = 2;
            n11 = object.getInt(n11, n12);
            int n13 = 1;
            if (n11 != 0) {
                if (n11 != n13) {
                    if (n11 == n12) {
                        object2 = n13;
                        this.setCameraLensFacing((Integer)object2);
                    }
                } else {
                    object2 = 0;
                    this.setCameraLensFacing((Integer)object2);
                }
            } else {
                n11 = 0;
                object2 = null;
                this.setCameraLensFacing(null);
            }
            n11 = R$styleable.CameraView_flash;
            n11 = object.getInt(n11, 0);
            if (n11 != n13) {
                if (n11 != n12) {
                    n10 = 4;
                    if (n11 == n10) {
                        this.setFlash(n12);
                    }
                } else {
                    this.setFlash(n13);
                }
            } else {
                this.setFlash(0);
            }
            object.recycle();
        }
        if ((object = this.getBackground()) == null) {
            int n14 = -15658735;
            this.setBackgroundColor(n14);
        }
        object = new CameraView$PinchToZoomGestureDetector(this, context);
        this.mPinchToZoomGestureDetector = object;
    }

    private void setMaxVideoDuration(long l10) {
        this.mCameraModule.setMaxVideoDuration(l10);
    }

    private void setMaxVideoSize(long l10) {
        this.mCameraModule.setMaxVideoSize(l10);
    }

    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mCameraModule.bindToLifecycle(lifecycleOwner);
    }

    public void enableTorch(boolean bl2) {
        this.mCameraModule.enableTorch(bl2);
    }

    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        int n10 = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n10, n10);
        return layoutParams;
    }

    public Integer getCameraLensFacing() {
        return this.mCameraModule.getLensFacing();
    }

    public CameraView$CaptureMode getCaptureMode() {
        return this.mCameraModule.getCaptureMode();
    }

    public int getDisplaySurfaceRotation() {
        Display display = this.getDisplay();
        if (display == null) {
            return 0;
        }
        return display.getRotation();
    }

    public int getFlash() {
        return this.mCameraModule.getFlash();
    }

    public long getMaxVideoDuration() {
        return this.mCameraModule.getMaxVideoDuration();
    }

    public float getMaxZoomRatio() {
        return this.mCameraModule.getMaxZoomRatio();
    }

    public float getMinZoomRatio() {
        return this.mCameraModule.getMinZoomRatio();
    }

    public LiveData getPreviewStreamState() {
        return this.mPreviewView.getPreviewStreamState();
    }

    public PreviewView getPreviewView() {
        return this.mPreviewView;
    }

    public PreviewView$ScaleType getScaleType() {
        return this.mPreviewView.getScaleType();
    }

    public float getZoomRatio() {
        return this.mCameraModule.getZoomRatio();
    }

    public boolean hasCameraWithLensFacing(int n10) {
        return this.mCameraModule.hasCameraWithLensFacing(n10);
    }

    public boolean isPinchToZoomEnabled() {
        return this.mIsPinchToZoomEnabled;
    }

    public boolean isRecording() {
        return this.mCameraModule.isRecording();
    }

    public boolean isTorchOn() {
        return this.mCameraModule.isTorchOn();
    }

    public boolean isZoomSupported() {
        return this.mCameraModule.isZoomSupported();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        DisplayManager displayManager = (DisplayManager)this.getContext().getSystemService("display");
        DisplayManager.DisplayListener displayListener = this.mDisplayListener;
        Looper looper = Looper.getMainLooper();
        Handler handler = new Handler(looper);
        displayManager.registerDisplayListener(displayListener, handler);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DisplayManager displayManager = (DisplayManager)this.getContext().getSystemService("display");
        DisplayManager.DisplayListener displayListener = this.mDisplayListener;
        displayManager.unregisterDisplayListener(displayListener);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        this.mCameraModule.bindToLifecycleAfterViewMeasured();
        this.mCameraModule.invalidateView();
        super.onLayout(bl2, n10, n11, n12, n13);
    }

    public void onMeasure(int n10, int n11) {
        int n12 = this.getMeasuredWidth();
        if (n12 > 0 && (n12 = this.getMeasuredHeight()) > 0) {
            CameraXModule cameraXModule = this.mCameraModule;
            cameraXModule.bindToLifecycleAfterViewMeasured();
        }
        super.onMeasure(n10, n11);
    }

    public void onRestoreInstanceState(Parcelable object) {
        int n10 = object instanceof Bundle;
        if (n10 != 0) {
            object = (Bundle)object;
            Object object2 = object.getParcelable(EXTRA_SUPER);
            super.onRestoreInstanceState(object2);
            object2 = PreviewView$ScaleType.fromId(object.getInt(EXTRA_SCALE_TYPE));
            this.setScaleType((PreviewView$ScaleType)((Object)object2));
            float f10 = object.getFloat(EXTRA_ZOOM_RATIO);
            this.setZoomRatio(f10);
            n10 = object.getBoolean(EXTRA_PINCH_TO_ZOOM_ENABLED);
            this.setPinchToZoomEnabled(n10 != 0);
            n10 = FlashModeConverter.valueOf(object.getString(EXTRA_FLASH));
            this.setFlash(n10);
            long l10 = object.getLong(EXTRA_MAX_VIDEO_DURATION);
            this.setMaxVideoDuration(l10);
            l10 = object.getLong(EXTRA_MAX_VIDEO_SIZE);
            this.setMaxVideoSize(l10);
            object2 = object.getString(EXTRA_CAMERA_DIRECTION);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                n10 = 0;
                f10 = 0.0f;
                object2 = null;
            } else {
                n10 = LensFacingConverter.valueOf((String)object2);
                object2 = n10;
            }
            this.setCameraLensFacing((Integer)object2);
            object2 = EXTRA_CAPTURE_MODE;
            int n11 = object.getInt((String)object2);
            object = CameraView$CaptureMode.fromId(n11);
            this.setCaptureMode((CameraView$CaptureMode)((Object)object));
        } else {
            super.onRestoreInstanceState(object);
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        Object object = super.onSaveInstanceState();
        bundle.putParcelable(EXTRA_SUPER, object);
        int n10 = this.getScaleType().getId();
        bundle.putInt(EXTRA_SCALE_TYPE, n10);
        float f10 = this.getZoomRatio();
        bundle.putFloat(EXTRA_ZOOM_RATIO, f10);
        n10 = this.isPinchToZoomEnabled() ? 1 : 0;
        bundle.putBoolean(EXTRA_PINCH_TO_ZOOM_ENABLED, n10 != 0);
        n10 = this.getFlash();
        object = FlashModeConverter.nameOf(n10);
        String string2 = EXTRA_FLASH;
        bundle.putString(string2, (String)object);
        long l10 = this.getMaxVideoDuration();
        bundle.putLong(EXTRA_MAX_VIDEO_DURATION, l10);
        l10 = this.getMaxVideoSize();
        String string3 = EXTRA_MAX_VIDEO_SIZE;
        bundle.putLong(string3, l10);
        object = this.getCameraLensFacing();
        if (object != null) {
            n10 = this.getCameraLensFacing();
            object = LensFacingConverter.nameOf(n10);
            string2 = EXTRA_CAMERA_DIRECTION;
            bundle.putString(string2, (String)object);
        }
        n10 = this.getCaptureMode().getId();
        bundle.putInt(EXTRA_CAPTURE_MODE, n10);
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        boolean bl3;
        Object object = this.mCameraModule;
        boolean n10 = ((CameraXModule)object).isPaused();
        if (n10) {
            return false;
        }
        boolean bl4 = this.isPinchToZoomEnabled();
        if (bl4) {
            object = this.mPinchToZoomGestureDetector;
            object.onTouchEvent(motionEvent);
        }
        int n11 = motionEvent.getPointerCount();
        int n12 = 2;
        int n13 = 1;
        if (n11 == n12 && (bl3 = this.isPinchToZoomEnabled()) && (bl2 = this.isZoomSupported())) {
            return n13 != 0;
        }
        int n14 = motionEvent.getAction();
        if (n14) {
            boolean bl5;
            long l10;
            if (n14 != n13) {
                return false;
            }
            long l11 = this.delta();
            long l12 = l11 - (l10 = (long)(n12 = ViewConfiguration.getLongPressTimeout()));
            long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (l13 < 0 && (bl5 = ((CameraXModule)(object = this.mCameraModule)).isBoundToLifecycle())) {
                this.mUpEvent = motionEvent;
                this.performClick();
            }
        } else {
            long l14;
            this.mDownEventTimestamp = l14 = System.currentTimeMillis();
        }
        return n13 != 0;
    }

    public boolean performClick() {
        float f10;
        int n10;
        float f11;
        int n11;
        float f12;
        super.performClick();
        Object object = this.mUpEvent;
        float f13 = 2.0f;
        if (object != null) {
            f12 = object.getX();
        } else {
            f12 = this.getX();
            n11 = this.getWidth();
            f11 = (float)n11 / f13;
            f12 += f11;
        }
        Object object2 = this.mUpEvent;
        if (object2 != null) {
            f13 = object2.getY();
        } else {
            f11 = this.getY();
            n10 = this.getHeight();
            f10 = (float)n10 / f13;
            f13 = f11 + f10;
        }
        n11 = 0;
        f11 = 0.0f;
        this.mUpEvent = null;
        object2 = this.mCameraModule.getCamera();
        n10 = 1;
        f10 = Float.MIN_VALUE;
        if (object2 != null) {
            MeteringPointFactory meteringPointFactory = this.mPreviewView.getMeteringPointFactory();
            float f14 = 0.16666667f;
            float f15 = 0.25f;
            MeteringPoint meteringPoint = meteringPointFactory.createPoint(f12, f13, f14);
            object = meteringPointFactory.createPoint(f12, f13, f15);
            Object object3 = object2.getCameraControl();
            object2 = new FocusMeteringAction$Builder(meteringPoint, n10);
            int n12 = 2;
            object = ((FocusMeteringAction$Builder)object2).addPoint((MeteringPoint)object, n12).build();
            object = object3.startFocusAndMetering((FocusMeteringAction)object);
            object3 = new CameraView$3(this);
            object2 = CameraXExecutors.directExecutor();
            Futures.addCallback((ListenableFuture)object, (FutureCallback)object3, (Executor)object2);
        } else {
            object = TAG;
            String string2 = "cannot access camera";
            Logger.d((String)object, string2);
        }
        return n10 != 0;
    }

    public float rangeLimit(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f12), f11);
    }

    public void setCameraLensFacing(Integer n10) {
        this.mCameraModule.setCameraLensFacing(n10);
    }

    public void setCaptureMode(CameraView$CaptureMode cameraView$CaptureMode) {
        this.mCameraModule.setCaptureMode(cameraView$CaptureMode);
    }

    public void setFlash(int n10) {
        this.mCameraModule.setFlash(n10);
    }

    public void setPinchToZoomEnabled(boolean bl2) {
        this.mIsPinchToZoomEnabled = bl2;
    }

    public void setScaleType(PreviewView$ScaleType previewView$ScaleType) {
        this.mPreviewView.setScaleType(previewView$ScaleType);
    }

    public void setZoomRatio(float f10) {
        this.mCameraModule.setZoomRatio(f10);
    }

    public void startRecording(ParcelFileDescriptor object, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        object = OutputFileOptions.builder(object).build();
        this.startRecording((OutputFileOptions)object, executor, onVideoSavedCallback);
    }

    public void startRecording(OutputFileOptions object, Executor executor, OnVideoSavedCallback object2) {
        CameraView$2 cameraView$2 = new CameraView$2(this, (OnVideoSavedCallback)object2);
        object2 = this.mCameraModule;
        object = ((OutputFileOptions)object).toVideoCaptureOutputFileOptions();
        ((CameraXModule)object2).startRecording((VideoCapture$OutputFileOptions)object, executor, cameraView$2);
    }

    public void startRecording(File object, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        object = OutputFileOptions.builder((File)object).build();
        this.startRecording((OutputFileOptions)object, executor, onVideoSavedCallback);
    }

    public void stopRecording() {
        this.mCameraModule.stopRecording();
    }

    public void takePicture(ImageCapture$OutputFileOptions imageCapture$OutputFileOptions, Executor executor, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        this.mCameraModule.takePicture(imageCapture$OutputFileOptions, executor, imageCapture$OnImageSavedCallback);
    }

    public void takePicture(Executor executor, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        this.mCameraModule.takePicture(executor, imageCapture$OnImageCapturedCallback);
    }

    public void toggleCamera() {
        this.mCameraModule.toggleCamera();
    }
}

