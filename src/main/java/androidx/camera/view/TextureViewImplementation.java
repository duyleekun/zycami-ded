/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener;
import androidx.camera.view.TextureViewImplementation$1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import b.a.d.o;
import b.a.d.p;
import b.a.d.q;
import b.a.d.r;
import b.a.d.t;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class TextureViewImplementation
extends PreviewViewImplementation {
    private static final String TAG = "TextureViewImpl";
    public SurfaceTexture mDetachedSurfaceTexture;
    public boolean mIsSurfaceTextureDetachedFromView = false;
    public AtomicReference mNextFrameCompleter;
    public PreviewViewImplementation$OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    public ListenableFuture mSurfaceReleaseFuture;
    public SurfaceRequest mSurfaceRequest;
    public SurfaceTexture mSurfaceTexture;
    public TextureView mTextureView;

    public TextureViewImplementation(FrameLayout object, PreviewTransformation previewTransformation) {
        super((FrameLayout)object, previewTransformation);
        super();
        this.mNextFrameCompleter = object;
    }

    private /* synthetic */ void a(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            surfaceRequest = null;
            this.mSurfaceRequest = null;
            this.mSurfaceReleaseFuture = null;
        }
        this.notifySurfaceNotInUse();
    }

    private /* synthetic */ Object c(Surface surface, CallbackToFutureAdapter$Completer object) {
        Logger.d(TAG, "Surface set on Preview.");
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Executor executor = CameraXExecutors.directExecutor();
        Objects.requireNonNull(object);
        t t10 = new t((CallbackToFutureAdapter$Completer)object);
        surfaceRequest.provideSurface(surface, executor, t10);
        object = new StringBuilder();
        ((StringBuilder)object).append("provideSurface[request=");
        surfaceRequest = this.mSurfaceRequest;
        ((StringBuilder)object).append(surfaceRequest);
        ((StringBuilder)object).append(" surface=");
        ((StringBuilder)object).append(surface);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    private /* synthetic */ void e(Surface object, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        String string2 = "Safe to release surface.";
        Logger.d(TAG, string2);
        this.notifySurfaceNotInUse();
        object.release();
        object = this.mSurfaceReleaseFuture;
        if (object == listenableFuture) {
            this.mSurfaceReleaseFuture = null;
        }
        if ((object = this.mSurfaceRequest) == surfaceRequest) {
            this.mSurfaceRequest = null;
        }
    }

    private /* synthetic */ Object g(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.mNextFrameCompleter.set(callbackToFutureAdapter$Completer);
        return "textureViewImpl_waitForNextFrame";
    }

    private void notifySurfaceNotInUse() {
        PreviewViewImplementation$OnSurfaceNotInUseListener previewViewImplementation$OnSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
        if (previewViewImplementation$OnSurfaceNotInUseListener != null) {
            previewViewImplementation$OnSurfaceNotInUseListener.onSurfaceNotInUse();
            previewViewImplementation$OnSurfaceNotInUseListener = null;
            this.mOnSurfaceNotInUseListener = null;
        }
    }

    private void reattachSurfaceTexture() {
        SurfaceTexture surfaceTexture;
        SurfaceTexture surfaceTexture2;
        boolean bl2 = this.mIsSurfaceTextureDetachedFromView;
        if (bl2 && (surfaceTexture2 = this.mDetachedSurfaceTexture) != null && (surfaceTexture2 = this.mTextureView.getSurfaceTexture()) != (surfaceTexture = this.mDetachedSurfaceTexture)) {
            this.mTextureView.setSurfaceTexture(surfaceTexture);
            this.mDetachedSurfaceTexture = null;
            bl2 = false;
            surfaceTexture2 = null;
            this.mIsSurfaceTextureDetachedFromView = false;
        }
    }

    public /* synthetic */ void b(SurfaceRequest surfaceRequest) {
        this.a(surfaceRequest);
    }

    public /* synthetic */ Object d(Surface surface, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.c(surface, callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void f(Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        this.e(surface, listenableFuture, surfaceRequest);
    }

    public View getPreview() {
        return this.mTextureView;
    }

    public Bitmap getPreviewBitmap() {
        boolean bl2;
        TextureView textureView = this.mTextureView;
        if (textureView != null && (bl2 = textureView.isAvailable())) {
            return this.mTextureView.getBitmap();
        }
        return null;
    }

    public /* synthetic */ Object h(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.g(callbackToFutureAdapter$Completer);
    }

    public void initializePreview() {
        TextureView textureView;
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        Object object = this.mParent.getContext();
        this.mTextureView = textureView = new TextureView(object);
        int n10 = this.mResolution.getWidth();
        int n11 = this.mResolution.getHeight();
        object = new FrameLayout.LayoutParams(n10, n11);
        textureView.setLayoutParams((ViewGroup.LayoutParams)object);
        textureView = this.mTextureView;
        object = new TextureViewImplementation$1(this);
        textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)object);
        this.mParent.removeAllViews();
        textureView = this.mParent;
        object = this.mTextureView;
        textureView.addView((View)object);
    }

    public void onAttachedToWindow() {
        this.reattachSurfaceTexture();
    }

    public void onDetachedFromWindow() {
        this.mIsSurfaceTextureDetachedFromView = true;
    }

    public void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewViewImplementation$OnSurfaceNotInUseListener object) {
        Object object2;
        this.mResolution = object2 = surfaceRequest.getResolution();
        this.mOnSurfaceNotInUseListener = object;
        this.initializePreview();
        object = this.mSurfaceRequest;
        if (object != null) {
            ((SurfaceRequest)object).willNotProvideSurface();
        }
        this.mSurfaceRequest = surfaceRequest;
        object = ContextCompat.getMainExecutor(this.mTextureView.getContext());
        object2 = new p(this, surfaceRequest);
        surfaceRequest.addRequestCancellationListener((Executor)object, (Runnable)object2);
        this.tryToProvidePreviewSurface();
    }

    public void tryToProvidePreviewSurface() {
        Object object;
        Object object2;
        Object object3 = this.mResolution;
        if (object3 != null && (object2 = this.mSurfaceTexture) != null && (object = this.mSurfaceRequest) != null) {
            int n10 = object3.getWidth();
            int n11 = this.mResolution.getHeight();
            object2.setDefaultBufferSize(n10, n11);
            object2 = this.mSurfaceTexture;
            object3 = new Surface(object2);
            object2 = this.mSurfaceRequest;
            object = new r(this, (Surface)object3);
            this.mSurfaceReleaseFuture = object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
            q q10 = new q(this, (Surface)object3, (ListenableFuture)object, (SurfaceRequest)object2);
            object3 = ContextCompat.getMainExecutor(this.mTextureView.getContext());
            object.addListener(q10, (Executor)object3);
            this.onSurfaceProvided();
        }
    }

    public ListenableFuture waitForNextFrame() {
        o o10 = new o(this);
        return CallbackToFutureAdapter.getFuture(o10);
    }
}

