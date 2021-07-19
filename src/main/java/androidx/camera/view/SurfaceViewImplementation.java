/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.view.PixelCopy
 *  android.view.PixelCopy$OnPixelCopyFinishedListener
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener;
import androidx.camera.view.SurfaceViewImplementation$SurfaceRequestCallback;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import b.a.d.l;
import b.a.d.m;
import b.a.d.s;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class SurfaceViewImplementation
extends PreviewViewImplementation {
    private static final String TAG = "SurfaceViewImpl";
    private PreviewViewImplementation$OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    public final SurfaceViewImplementation$SurfaceRequestCallback mSurfaceRequestCallback;
    public SurfaceView mSurfaceView;

    public SurfaceViewImplementation(FrameLayout object, PreviewTransformation previewTransformation) {
        super((FrameLayout)object, previewTransformation);
        super(this);
        this.mSurfaceRequestCallback = object;
    }

    public static /* synthetic */ void a(int n10) {
        String string2 = TAG;
        if (n10 == 0) {
            String string3 = "PreviewView.SurfaceViewImplementation.getBitmap() succeeded";
            Logger.d(string2, string3);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "PreviewView.SurfaceViewImplementation.getBitmap() failed with error ";
            stringBuilder.append(string4);
            stringBuilder.append(n10);
            String string5 = stringBuilder.toString();
            Logger.e(string2, string5);
        }
    }

    private /* synthetic */ void b(SurfaceRequest surfaceRequest) {
        this.mSurfaceRequestCallback.setSurfaceRequest(surfaceRequest);
    }

    public /* synthetic */ void c(SurfaceRequest surfaceRequest) {
        this.b(surfaceRequest);
    }

    public View getPreview() {
        return this.mSurfaceView;
    }

    public Bitmap getPreviewBitmap() {
        int n10;
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView != null && (surfaceView = surfaceView.getHolder().getSurface()) != null && (n10 = (surfaceView = this.mSurfaceView.getHolder().getSurface()).isValid()) != 0) {
            n10 = this.mSurfaceView.getWidth();
            int n11 = this.mSurfaceView.getHeight();
            Object object = Bitmap.Config.ARGB_8888;
            surfaceView = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)object);
            SurfaceView surfaceView2 = this.mSurfaceView;
            object = m.a;
            Handler handler = surfaceView2.getHandler();
            PixelCopy.request((SurfaceView)surfaceView2, (Bitmap)surfaceView, (PixelCopy.OnPixelCopyFinishedListener)object, (Handler)handler);
            return surfaceView;
        }
        return null;
    }

    public void initializePreview() {
        SurfaceView surfaceView;
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        Object object = this.mParent.getContext();
        this.mSurfaceView = surfaceView = new SurfaceView(object);
        int n10 = this.mResolution.getWidth();
        int n11 = this.mResolution.getHeight();
        object = new FrameLayout.LayoutParams(n10, n11);
        surfaceView.setLayoutParams((ViewGroup.LayoutParams)object);
        this.mParent.removeAllViews();
        surfaceView = this.mParent;
        object = this.mSurfaceView;
        surfaceView.addView((View)object);
        surfaceView = this.mSurfaceView.getHolder();
        object = this.mSurfaceRequestCallback;
        surfaceView.addCallback((SurfaceHolder.Callback)object);
    }

    public void notifySurfaceNotInUse() {
        PreviewViewImplementation$OnSurfaceNotInUseListener previewViewImplementation$OnSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
        if (previewViewImplementation$OnSurfaceNotInUseListener != null) {
            previewViewImplementation$OnSurfaceNotInUseListener.onSurfaceNotInUse();
            previewViewImplementation$OnSurfaceNotInUseListener = null;
            this.mOnSurfaceNotInUseListener = null;
        }
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
    }

    public void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewViewImplementation$OnSurfaceNotInUseListener object) {
        Object object2;
        this.mResolution = object2 = surfaceRequest.getResolution();
        this.mOnSurfaceNotInUseListener = object;
        this.initializePreview();
        object = ContextCompat.getMainExecutor(this.mSurfaceView.getContext());
        object2 = new s(this);
        surfaceRequest.addRequestCancellationListener((Executor)object, (Runnable)object2);
        object = this.mSurfaceView;
        object2 = new l(this, surfaceRequest);
        object.post((Runnable)object2);
    }

    public ListenableFuture waitForNextFrame() {
        return Futures.immediateFuture(null);
    }
}

