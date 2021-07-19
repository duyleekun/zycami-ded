/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.TotalCaptureResult
 */
package androidx.camera.camera2.interop;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.a.e.a;
import b.a.a.e.b;
import b.a.a.e.c;
import b.a.a.e.d;
import b.a.a.e.e;
import b.a.a.e.f;
import b.a.a.e.g;
import b.a.a.e.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class Camera2CameraControl {
    public static final String TAG_KEY = "Camera2CameraControl";
    private Camera2ImplConfig$Builder mBuilder;
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final Camera2CameraControlImpl$CaptureResultListener mCaptureResultListener;
    public CallbackToFutureAdapter$Completer mCompleter;
    public final Executor mExecutor;
    private boolean mIsActive = false;
    public final Object mLock;
    private boolean mPendingUpdate = false;

    public Camera2CameraControl(Camera2CameraControlImpl camera2CameraControlImpl, Executor executor) {
        Object object;
        this.mLock = object = new Object();
        this.mBuilder = object = new Camera2ImplConfig$Builder();
        this.mCaptureResultListener = object = new d(this);
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
    }

    private /* synthetic */ void a(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.updateConfig(callbackToFutureAdapter$Completer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void addCaptureRequestOptionsInternal(CaptureRequestOptions captureRequestOptions) {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = captureRequestOptions.listOptions();
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (Config$Option)object3;
                Object object4 = this.mBuilder;
                object4 = ((Camera2ImplConfig$Builder)object4).getMutableConfig();
                Object object5 = captureRequestOptions.retrieveOption((Config$Option)object3);
                object4.insertOption((Config$Option)object3, object5);
            }
            return;
        }
    }

    private /* synthetic */ Object c(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        c c10 = new c(this, callbackToFutureAdapter$Completer);
        executor.execute(c10);
        return "addCaptureRequestOptions";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void clearCaptureRequestOptionsInternal() {
        Object object = this.mLock;
        synchronized (object) {
            Camera2ImplConfig$Builder camera2ImplConfig$Builder;
            this.mBuilder = camera2ImplConfig$Builder = new Camera2ImplConfig$Builder();
            return;
        }
    }

    private /* synthetic */ void e(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.updateConfig(callbackToFutureAdapter$Completer);
    }

    public static Camera2CameraControl from(CameraControl cameraControl) {
        Preconditions.checkArgument(cameraControl instanceof Camera2CameraControlImpl, "CameraControl doesn't contain Camera2 implementation.");
        return ((Camera2CameraControlImpl)cameraControl).getCamera2CameraControl();
    }

    private /* synthetic */ Object g(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        a a10 = new a(this, callbackToFutureAdapter$Completer);
        executor.execute(a10);
        return "clearCaptureRequestOptions";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean i(TotalCaptureResult object) {
        Object object2 = this.mCompleter;
        if (object2 == null) return false;
        int n10 = (object = object.getRequest().getTag()) instanceof TagBundle;
        if (n10 == 0) return false;
        object = (TagBundle)object;
        object2 = TAG_KEY;
        if ((object = ((TagBundle)object).getTag((String)object2)) == null) return false;
        n10 = this.mCompleter.hashCode();
        object2 = n10;
        boolean bl2 = ((Integer)object).equals(object2);
        if (!bl2) return false;
        object = this.mCompleter;
        this.mCompleter = null;
        if (object == null) return false;
        ((CallbackToFutureAdapter$Completer)object).set(null);
        return false;
    }

    private /* synthetic */ void k(boolean bl2) {
        this.setActiveInternal(bl2);
    }

    private /* synthetic */ void m(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.updateConfig(callbackToFutureAdapter$Completer);
    }

    private /* synthetic */ Object o(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        b b10 = new b(this, callbackToFutureAdapter$Completer);
        executor.execute(b10);
        return "setCaptureRequestOptions";
    }

    private void setActiveInternal(boolean bl2) {
        boolean bl3 = this.mIsActive;
        if (bl3 == bl2) {
            return;
        }
        this.mIsActive = bl2;
        if (bl2) {
            bl2 = this.mPendingUpdate;
            if (bl2) {
                this.updateSession();
            }
        } else {
            this.clearCaptureRequestOptionsInternal();
            CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mCompleter;
            if (callbackToFutureAdapter$Completer != null) {
                String string2 = "The camera control has became inactive.";
                CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException(string2);
                callbackToFutureAdapter$Completer.setException(cameraControl$OperationCanceledException);
                bl2 = false;
                callbackToFutureAdapter$Completer = null;
                this.mCompleter = null;
            }
        }
    }

    private void updateConfig(CallbackToFutureAdapter$Completer object) {
        boolean bl2;
        this.mPendingUpdate = bl2 = true;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mCompleter;
        if (callbackToFutureAdapter$Completer == null) {
            bl2 = false;
            callbackToFutureAdapter$Completer = null;
        }
        this.mCompleter = object;
        boolean bl3 = this.mIsActive;
        if (bl3) {
            this.updateSession();
        }
        if (callbackToFutureAdapter$Completer != null) {
            String string2 = "Camera2CameraControl was updated with new options.";
            object = new CameraControl$OperationCanceledException(string2);
            callbackToFutureAdapter$Completer.setException((Throwable)object);
        }
    }

    private void updateSession() {
        this.mCamera2CameraControlImpl.updateSessionConfig();
        this.mPendingUpdate = false;
    }

    public ListenableFuture addCaptureRequestOptions(CaptureRequestOptions object) {
        this.addCaptureRequestOptionsInternal((CaptureRequestOptions)object);
        object = new h(this);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object));
    }

    public /* synthetic */ void b(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a(callbackToFutureAdapter$Completer);
    }

    public ListenableFuture clearCaptureRequestOptions() {
        this.clearCaptureRequestOptionsInternal();
        e e10 = new e(this);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(e10));
    }

    public /* synthetic */ Object d(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.c(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void f(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.e(callbackToFutureAdapter$Completer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Camera2ImplConfig getCamera2ImplConfig() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCompleter;
            if (object2 != null) {
                object2 = this.mBuilder;
                object2 = ((Camera2ImplConfig$Builder)object2).getMutableConfig();
                Config$Option config$Option = Camera2ImplConfig.CAPTURE_REQUEST_TAG_OPTION;
                Object object3 = this.mCompleter;
                int n10 = object3.hashCode();
                object3 = n10;
                object2.insertOption(config$Option, object3);
            }
            object2 = this.mBuilder;
            return ((Camera2ImplConfig$Builder)object2).build();
        }
    }

    public Camera2CameraControlImpl$CaptureResultListener getCaptureRequestListener() {
        return this.mCaptureResultListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CaptureRequestOptions getCaptureRequestOptions() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mBuilder;
            object2 = ((Camera2ImplConfig$Builder)object2).build();
            object2 = CaptureRequestOptions$Builder.from((Config)object2);
            return ((CaptureRequestOptions$Builder)object2).build();
        }
    }

    public /* synthetic */ Object h(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.g(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ boolean j(TotalCaptureResult totalCaptureResult) {
        return this.i(totalCaptureResult);
    }

    public /* synthetic */ void l(boolean bl2) {
        this.k(bl2);
    }

    public /* synthetic */ void n(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.m(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ Object p(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.o(callbackToFutureAdapter$Completer);
    }

    public void setActive(boolean bl2) {
        Executor executor = this.mExecutor;
        g g10 = new g(this, bl2);
        executor.execute(g10);
    }

    public ListenableFuture setCaptureRequestOptions(CaptureRequestOptions object) {
        this.clearCaptureRequestOptionsInternal();
        this.addCaptureRequestOptionsInternal((CaptureRequestOptions)object);
        object = new f(this);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object));
    }
}

