/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Rational
 *  android.util.Size
 *  android.view.Display
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewConfiguration
 *  android.widget.FrameLayout
 */
package androidx.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview$SurfaceProvider;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ViewPort$Builder;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.CameraController;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewView$1;
import androidx.camera.view.PreviewView$2;
import androidx.camera.view.PreviewView$ImplementationMode;
import androidx.camera.view.PreviewView$ScaleType;
import androidx.camera.view.PreviewView$StreamState;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.PreviewViewMeteringPointFactory;
import androidx.camera.view.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.a.d.k;
import java.util.concurrent.atomic.AtomicReference;

public final class PreviewView
extends FrameLayout {
    public static final int DEFAULT_BACKGROUND_COLOR = 17170444;
    private static final PreviewView$ImplementationMode DEFAULT_IMPL_MODE = PreviewView$ImplementationMode.PERFORMANCE;
    private static final String TAG = "PreviewView";
    public final AtomicReference mActiveStreamStateObserver;
    public CameraController mCameraController;
    public PreviewViewImplementation mImplementation;
    public PreviewView$ImplementationMode mImplementationMode;
    private final View.OnLayoutChangeListener mOnLayoutChangeListener;
    public final MutableLiveData mPreviewStreamStateLiveData;
    public final PreviewTransformation mPreviewTransform;
    public PreviewViewMeteringPointFactory mPreviewViewMeteringPointFactory;
    private final ScaleGestureDetector mScaleGestureDetector;
    public final Preview$SurfaceProvider mSurfaceProvider;
    private MotionEvent mTouchUpEvent;

    public PreviewView(Context context) {
        this(context, null);
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int n10) {
        this(context, attributeSet, n10, 0);
    }

    public PreviewView(Context context, AttributeSet object, int n10, int n11) {
        super(context, object, n10, n11);
        PreviewTransformation previewTransformation;
        PreviewView$ImplementationMode previewView$ImplementationMode;
        this.mImplementationMode = previewView$ImplementationMode = DEFAULT_IMPL_MODE;
        this.mPreviewTransform = previewTransformation = new PreviewTransformation();
        Object object2 = PreviewView$StreamState.IDLE;
        Object object3 = new MutableLiveData(object2);
        this.mPreviewStreamStateLiveData = object3;
        object3 = new AtomicReference();
        this.mActiveStreamStateObserver = object3;
        this.mPreviewViewMeteringPointFactory = object3 = new PreviewViewMeteringPointFactory(previewTransformation);
        object3 = new k(this);
        this.mOnLayoutChangeListener = object3;
        this.mSurfaceProvider = object3 = new PreviewView$1(this);
        Threads.checkMainThread();
        object3 = context.getTheme();
        int[] nArray = R$styleable.PreviewView;
        object3 = object3.obtainStyledAttributes(object, nArray, n10, n11);
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 29;
        if (n12 >= n13) {
            object2 = this;
            this.saveAttributeDataForStyleable(context, nArray, (AttributeSet)object, (TypedArray)object3, n10, n11);
        }
        int n14 = R$styleable.PreviewView_scaleType;
        Object object4 = previewTransformation.getScaleType();
        n10 = object4.getId();
        n14 = object3.getInteger(n14, n10);
        object = PreviewView$ScaleType.fromId(n14);
        this.setScaleType((PreviewView$ScaleType)((Object)object));
        n14 = R$styleable.PreviewView_implementationMode;
        n10 = previewView$ImplementationMode.getId();
        n14 = object3.getInteger(n14, n10);
        object = PreviewView$ImplementationMode.fromId(n14);
        this.setImplementationMode((PreviewView$ImplementationMode)((Object)object));
        super(this);
        super(context, (ScaleGestureDetector.OnScaleGestureListener)object4);
        this.mScaleGestureDetector = object;
        context = this.getBackground();
        if (context == null) {
            context = this.getContext();
            n14 = 17170444;
            int n15 = ContextCompat.getColor(context, n14);
            this.setBackgroundColor(n15);
        }
        return;
        finally {
            object3.recycle();
        }
    }

    private /* synthetic */ void a(View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        int n18 = 1;
        n10 = (n12 -= n10) == (n16 -= n14) && (n13 -= n11) == (n17 -= n15) ? 0 : n18;
        if (n10 != 0) {
            this.redrawPreview();
            this.attachToControllerIfReady(n18 != 0);
        }
    }

    private void attachToControllerIfReady(boolean bl2) {
        block6: {
            boolean bl3;
            Display display = this.getDisplay();
            Object object = this.getViewPort();
            CameraController cameraController = this.mCameraController;
            if (cameraController != null && object != null && (bl3 = this.isAttachedToWindow()) && display != null) {
                cameraController = this.mCameraController;
                Preview$SurfaceProvider preview$SurfaceProvider = this.getSurfaceProvider();
                try {
                    cameraController.attachPreviewSurface(preview$SurfaceProvider, (ViewPort)object, display);
                }
                catch (IllegalStateException illegalStateException) {
                    if (bl2) {
                        String string2 = illegalStateException.getMessage();
                        object = TAG;
                        Logger.e((String)object, string2, illegalStateException);
                        break block6;
                    }
                    throw illegalStateException;
                }
            }
        }
    }

    private int getViewPortScaleType() {
        Object object = PreviewView$2.$SwitchMap$androidx$camera$view$PreviewView$ScaleType;
        Object object2 = this.getScaleType();
        int n10 = ((Enum)object2).ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                object = new IllegalStateException;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unexpected scale type: ");
                PreviewView$ScaleType previewView$ScaleType = this.getScaleType();
                ((StringBuilder)object2).append((Object)previewView$ScaleType);
                object2 = ((StringBuilder)object2).toString();
                object((String)object2);
                throw object;
            }
            case 4: 
            case 5: 
            case 6: {
                return 3;
            }
            case 3: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 1: 
        }
        return 2;
    }

    public /* synthetic */ void b(View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        this.a(view, n10, n11, n12, n13, n14, n15, n16, n17);
    }

    public Bitmap getBitmap() {
        Threads.checkMainThread();
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        previewViewImplementation = previewViewImplementation == null ? null : previewViewImplementation.getBitmap();
        return previewViewImplementation;
    }

    public CameraController getController() {
        Threads.checkMainThread();
        return this.mCameraController;
    }

    public PreviewView$ImplementationMode getImplementationMode() {
        Threads.checkMainThread();
        return this.mImplementationMode;
    }

    public MeteringPointFactory getMeteringPointFactory() {
        Threads.checkMainThread();
        return this.mPreviewViewMeteringPointFactory;
    }

    public LiveData getPreviewStreamState() {
        return this.mPreviewStreamStateLiveData;
    }

    public PreviewView$ScaleType getScaleType() {
        Threads.checkMainThread();
        return this.mPreviewTransform.getScaleType();
    }

    public Preview$SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.mSurfaceProvider;
    }

    public ViewPort getViewPort() {
        Threads.checkMainThread();
        Display display = this.getDisplay();
        if (display == null) {
            return null;
        }
        int n10 = this.getDisplay().getRotation();
        return this.getViewPort(n10);
    }

    public ViewPort getViewPort(int n10) {
        Threads.checkMainThread();
        int n11 = this.getWidth();
        if (n11 != 0 && (n11 = this.getHeight()) != 0) {
            int n12 = this.getWidth();
            int n13 = this.getHeight();
            Rational rational = new Rational(n12, n13);
            ViewPort$Builder viewPort$Builder = new ViewPort$Builder(rational, n10);
            n10 = this.getViewPortScaleType();
            ViewPort$Builder viewPort$Builder2 = viewPort$Builder.setScaleType(n10);
            n11 = this.getLayoutDirection();
            return viewPort$Builder2.setLayoutDirection(n11).build();
        }
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object object = this.mOnLayoutChangeListener;
        this.addOnLayoutChangeListener((View.OnLayoutChangeListener)object);
        object = this.mImplementation;
        if (object != null) {
            ((PreviewViewImplementation)object).onAttachedToWindow();
        }
        this.attachToControllerIfReady(true);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Object object = this.mOnLayoutChangeListener;
        this.removeOnLayoutChangeListener((View.OnLayoutChangeListener)object);
        object = this.mImplementation;
        if (object != null) {
            ((PreviewViewImplementation)object).onDetachedFromWindow();
        }
        if ((object = this.mCameraController) != null) {
            ((CameraController)object).clearPreviewSurface();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        CameraController cameraController = this.mCameraController;
        if (cameraController == null) {
            return super.onTouchEvent(motionEvent);
        }
        int n10 = motionEvent.getPointerCount();
        int n11 = 0;
        int n12 = 1;
        if (n10 == n12) {
            n10 = n12;
        } else {
            n10 = 0;
            cameraController = null;
        }
        int n13 = motionEvent.getAction();
        n13 = n13 == n12 ? n12 : 0;
        long l10 = motionEvent.getEventTime();
        long l11 = motionEvent.getDownTime();
        l10 -= l11;
        int n14 = ViewConfiguration.getLongPressTimeout();
        l11 = n14;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 < 0 ? (long)n12 : (long)0;
        if (n10 != 0 && n13 != 0 && l12 != false) {
            this.mTouchUpEvent = motionEvent;
            this.performClick();
            return n12 != 0;
        }
        cameraController = this.mScaleGestureDetector;
        n10 = cameraController.onTouchEvent(motionEvent) ? 1 : 0;
        if (n10 != 0 || (bl2 = super.onTouchEvent(motionEvent))) {
            n11 = n12;
        }
        return n11 != 0;
    }

    public boolean performClick() {
        CameraController cameraController = this.mCameraController;
        if (cameraController != null) {
            float f10;
            cameraController = this.mTouchUpEvent;
            float f11 = 2.0f;
            if (cameraController != null) {
                f10 = cameraController.getX();
            } else {
                int n10 = this.getWidth();
                f10 = (float)n10 / f11;
            }
            Object object = this.mTouchUpEvent;
            if (object != null) {
                f11 = object.getY();
            } else {
                int n11 = this.getHeight();
                float f12 = n11;
                f11 = f12 / f11;
            }
            object = this.mCameraController;
            PreviewViewMeteringPointFactory previewViewMeteringPointFactory = this.mPreviewViewMeteringPointFactory;
            ((CameraController)object).onTapToFocus(previewViewMeteringPointFactory, f10, f11);
        }
        this.mTouchUpEvent = null;
        return super.performClick();
    }

    public void redrawPreview() {
        Object object = this.mImplementation;
        if (object != null) {
            ((PreviewViewImplementation)object).redrawPreview();
        }
        object = this.mPreviewViewMeteringPointFactory;
        int n10 = this.getWidth();
        int n11 = this.getHeight();
        Size size = new Size(n10, n11);
        n10 = this.getLayoutDirection();
        ((PreviewViewMeteringPointFactory)object).recalculate(size, n10);
    }

    public void setController(CameraController cameraController) {
        Threads.checkMainThread();
        CameraController cameraController2 = this.mCameraController;
        if (cameraController2 != null && cameraController2 != cameraController) {
            cameraController2.clearPreviewSurface();
        }
        this.mCameraController = cameraController;
        this.attachToControllerIfReady(false);
    }

    public void setImplementationMode(PreviewView$ImplementationMode previewView$ImplementationMode) {
        Threads.checkMainThread();
        this.mImplementationMode = previewView$ImplementationMode;
    }

    public void setScaleType(PreviewView$ScaleType previewView$ScaleType) {
        Threads.checkMainThread();
        this.mPreviewTransform.setScaleType(previewView$ScaleType);
        this.redrawPreview();
        this.attachToControllerIfReady(false);
    }

    public boolean shouldUseTextureView(SurfaceRequest object, PreviewView$ImplementationMode object2) {
        int n10;
        int n11;
        CharSequence charSequence = ((SurfaceRequest)object).getCamera().getCameraInfo().getImplementationType();
        String string2 = "androidx.camera.camera2.legacy";
        boolean n112 = ((String)charSequence).equals(string2);
        Object object3 = ((SurfaceRequest)object).isRGBA8888Required();
        Object object4 = 1;
        if (object3 == 0 && (object3 = Build.VERSION.SDK_INT) > (n11 = 24) && !n112 && (object3 = (Object)(object = (Object)PreviewView$2.$SwitchMap$androidx$camera$view$PreviewView$ImplementationMode)[n10 = ((Enum)object2).ordinal()]) != object4) {
            Object object5 = 2;
            if (object3 == object5) {
                return false;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Invalid implementation mode: ");
            ((StringBuilder)charSequence).append(object2);
            object2 = ((StringBuilder)charSequence).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        return (boolean)object4;
    }
}

