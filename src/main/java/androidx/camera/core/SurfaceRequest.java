/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.core;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest$1;
import androidx.camera.core.SurfaceRequest$2;
import androidx.camera.core.SurfaceRequest$3;
import androidx.camera.core.SurfaceRequest$4;
import androidx.camera.core.SurfaceRequest$Result;
import androidx.camera.core.SurfaceRequest$TransformationInfo;
import androidx.camera.core.SurfaceRequest$TransformationInfoListener;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurface$SurfaceUnavailableException;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import b.a.b.c1;
import b.a.b.d1;
import b.a.b.e1;
import b.a.b.f1;
import b.a.b.h1;
import b.a.b.i1;
import b.a.b.j1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class SurfaceRequest {
    private final CameraInternal mCamera;
    private final DeferrableSurface mInternalDeferrableSurface;
    private final boolean mRGBA8888Required;
    private final CallbackToFutureAdapter$Completer mRequestCancellationCompleter;
    private final Size mResolution;
    private final ListenableFuture mSessionStatusFuture;
    private final CallbackToFutureAdapter$Completer mSurfaceCompleter;
    public final ListenableFuture mSurfaceFuture;
    private SurfaceRequest$TransformationInfo mTransformationInfo;
    private Executor mTransformationInfoExecutor;
    private SurfaceRequest$TransformationInfoListener mTransformationInfoListener;

    public SurfaceRequest(Size object, CameraInternal object2, boolean bl2) {
        this.mResolution = object;
        this.mCamera = object2;
        this.mRGBA8888Required = bl2;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("SurfaceRequest[size: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(", id: ");
        int n10 = this.hashCode();
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append("]");
        object = ((StringBuilder)object2).toString();
        object2 = new AtomicReference(null);
        Object object3 = new i1((AtomicReference)object2, (String)object);
        object3 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object3);
        this.mRequestCancellationCompleter = object2 = (CallbackToFutureAdapter$Completer)Preconditions.checkNotNull(((AtomicReference)object2).get());
        Object object4 = new AtomicReference(null);
        Object object5 = new j1((AtomicReference)object4, (String)object);
        this.mSessionStatusFuture = object5 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object5);
        SurfaceRequest$1 surfaceRequest$1 = new SurfaceRequest$1(this, (CallbackToFutureAdapter$Completer)object2, (ListenableFuture)object3);
        object2 = CameraXExecutors.directExecutor();
        Futures.addCallback((ListenableFuture)object5, surfaceRequest$1, (Executor)object2);
        object2 = (CallbackToFutureAdapter$Completer)Preconditions.checkNotNull(((AtomicReference)object4).get());
        object3 = new AtomicReference(null);
        Object object6 = new h1((AtomicReference)object3, (String)object);
        this.mSurfaceFuture = object6 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object6);
        this.mSurfaceCompleter = object3 = (CallbackToFutureAdapter$Completer)Preconditions.checkNotNull(((AtomicReference)object3).get());
        this.mInternalDeferrableSurface = object3 = new SurfaceRequest$2(this);
        object3 = ((DeferrableSurface)object3).getTerminationFuture();
        object4 = new SurfaceRequest$3(this, (ListenableFuture)object3, (CallbackToFutureAdapter$Completer)object2, (String)object);
        object = CameraXExecutors.directExecutor();
        Futures.addCallback((ListenableFuture)object6, (FutureCallback)object4, (Executor)object);
        super(this);
        object2 = CameraXExecutors.directExecutor();
        object3.addListener((Runnable)object, (Executor)object2);
    }

    public static /* synthetic */ Object a(AtomicReference serializable, String string2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ((AtomicReference)serializable).set(callbackToFutureAdapter$Completer);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("-cancellation");
        return ((StringBuilder)serializable).toString();
    }

    public static /* synthetic */ Object b(AtomicReference serializable, String string2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ((AtomicReference)serializable).set(callbackToFutureAdapter$Completer);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("-status");
        return ((StringBuilder)serializable).toString();
    }

    public static /* synthetic */ Object c(AtomicReference serializable, String string2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ((AtomicReference)serializable).set(callbackToFutureAdapter$Completer);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("-Surface");
        return ((StringBuilder)serializable).toString();
    }

    private /* synthetic */ void d() {
        this.mSurfaceFuture.cancel(true);
    }

    public static /* synthetic */ void f(Consumer consumer, Surface object) {
        object = SurfaceRequest$Result.of(3, object);
        consumer.accept(object);
    }

    public static /* synthetic */ void g(Consumer consumer, Surface object) {
        object = SurfaceRequest$Result.of(4, object);
        consumer.accept(object);
    }

    public static /* synthetic */ void h(SurfaceRequest$TransformationInfoListener surfaceRequest$TransformationInfoListener, SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo) {
        surfaceRequest$TransformationInfoListener.onTransformationInfoUpdate(surfaceRequest$TransformationInfo);
    }

    public static /* synthetic */ void i(SurfaceRequest$TransformationInfoListener surfaceRequest$TransformationInfoListener, SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo) {
        surfaceRequest$TransformationInfoListener.onTransformationInfoUpdate(surfaceRequest$TransformationInfo);
    }

    public void addRequestCancellationListener(Executor executor, Runnable runnable) {
        this.mRequestCancellationCompleter.addCancellationListener(runnable, executor);
    }

    public void clearTransformationInfoListener() {
        this.mTransformationInfoListener = null;
        this.mTransformationInfoExecutor = null;
    }

    public /* synthetic */ void e() {
        this.d();
    }

    public CameraInternal getCamera() {
        return this.mCamera;
    }

    public DeferrableSurface getDeferrableSurface() {
        return this.mInternalDeferrableSurface;
    }

    public Size getResolution() {
        return this.mResolution;
    }

    public boolean isRGBA8888Required() {
        return this.mRGBA8888Required;
    }

    public void provideSurface(Surface surface, Executor executor, Consumer consumer) {
        Object object = this.mSurfaceCompleter;
        boolean bl2 = ((CallbackToFutureAdapter$Completer)object).set(surface);
        if (!bl2 && !(bl2 = (object = this.mSurfaceFuture).isCancelled())) {
            object = this.mSurfaceFuture;
            bl2 = object.isDone();
            Preconditions.checkState(bl2);
            object = this.mSurfaceFuture;
            object.get();
            object = new c1(consumer, surface);
            try {
                executor.execute((Runnable)object);
            }
            catch (InterruptedException | ExecutionException exception) {
                object = new d1(consumer, surface);
                executor.execute((Runnable)object);
            }
        } else {
            object = this.mSessionStatusFuture;
            SurfaceRequest$4 surfaceRequest$4 = new SurfaceRequest$4(this, consumer, surface);
            Futures.addCallback((ListenableFuture)object, surfaceRequest$4, executor);
        }
    }

    public void setTransformationInfoListener(Executor executor, SurfaceRequest$TransformationInfoListener surfaceRequest$TransformationInfoListener) {
        this.mTransformationInfoListener = surfaceRequest$TransformationInfoListener;
        this.mTransformationInfoExecutor = executor;
        SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo = this.mTransformationInfo;
        if (surfaceRequest$TransformationInfo != null) {
            e1 e12 = new e1(surfaceRequest$TransformationInfoListener, surfaceRequest$TransformationInfo);
            executor.execute(e12);
        }
    }

    public void updateTransformationInfo(SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo) {
        this.mTransformationInfo = surfaceRequest$TransformationInfo;
        SurfaceRequest$TransformationInfoListener surfaceRequest$TransformationInfoListener = this.mTransformationInfoListener;
        if (surfaceRequest$TransformationInfoListener != null) {
            Executor executor = this.mTransformationInfoExecutor;
            f1 f12 = new f1(surfaceRequest$TransformationInfoListener, surfaceRequest$TransformationInfo);
            executor.execute(f12);
        }
    }

    public boolean willNotProvideSurface() {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mSurfaceCompleter;
        DeferrableSurface$SurfaceUnavailableException deferrableSurface$SurfaceUnavailableException = new DeferrableSurface$SurfaceUnavailableException("Surface request will not complete.");
        return callbackToFutureAdapter$Completer.setException(deferrableSurface$SurfaceUnavailableException);
    }
}

