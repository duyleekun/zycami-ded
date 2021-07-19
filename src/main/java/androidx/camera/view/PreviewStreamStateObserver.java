/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal$State;
import androidx.camera.core.impl.Observable$Observer;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewStreamStateObserver$1;
import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.camera.view.PreviewView$StreamState;
import androidx.camera.view.PreviewViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.lifecycle.MutableLiveData;
import b.a.d.e;
import b.a.d.f;
import b.a.d.g;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class PreviewStreamStateObserver
implements Observable$Observer {
    private static final String TAG = "StreamStateObserver";
    private final CameraInfoInternal mCameraInfoInternal;
    public ListenableFuture mFlowFuture;
    private boolean mHasStartedPreviewStreamFlow = false;
    private PreviewView$StreamState mPreviewStreamState;
    private final MutableLiveData mPreviewStreamStateLiveData;
    private final PreviewViewImplementation mPreviewViewImplementation;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PreviewStreamStateObserver(CameraInfoInternal object, MutableLiveData mutableLiveData, PreviewViewImplementation previewViewImplementation) {
        this.mCameraInfoInternal = object;
        this.mPreviewStreamStateLiveData = mutableLiveData;
        this.mPreviewViewImplementation = previewViewImplementation;
        synchronized (this) {
            object = mutableLiveData.getValue();
            object = (PreviewView$StreamState)((Object)object);
            this.mPreviewStreamState = object;
            return;
        }
    }

    private /* synthetic */ ListenableFuture a(Void void_) {
        return this.mPreviewViewImplementation.waitForNextFrame();
    }

    private /* synthetic */ Void c(Void object) {
        object = PreviewView$StreamState.STREAMING;
        this.updatePreviewStreamState((PreviewView$StreamState)((Object)object));
        return null;
    }

    private void cancelFlow() {
        ListenableFuture listenableFuture = this.mFlowFuture;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            listenableFuture = null;
            this.mFlowFuture = null;
        }
    }

    private /* synthetic */ Object e(CameraInfo cameraInfo, List object, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        PreviewStreamStateObserver$2 previewStreamStateObserver$2 = new PreviewStreamStateObserver$2(this, callbackToFutureAdapter$Completer, cameraInfo);
        object.add(previewStreamStateObserver$2);
        cameraInfo = (CameraInfoInternal)cameraInfo;
        object = CameraXExecutors.directExecutor();
        cameraInfo.addSessionCaptureCallback((Executor)object, previewStreamStateObserver$2);
        return "waitForCaptureResult";
    }

    private void startPreviewStreamStateFlow(CameraInfo object) {
        Object object2 = PreviewView$StreamState.IDLE;
        this.updatePreviewStreamState((PreviewView$StreamState)((Object)object2));
        object2 = new ArrayList();
        FutureChain futureChain = FutureChain.from(this.waitForCaptureResult((CameraInfo)object, (List)object2));
        Object object3 = new g(this);
        Executor executor = CameraXExecutors.directExecutor();
        futureChain = futureChain.transformAsync((AsyncFunction)object3, executor);
        object3 = new e(this);
        executor = CameraXExecutors.directExecutor();
        futureChain = futureChain.transform((Function)object3, executor);
        this.mFlowFuture = futureChain;
        object3 = new PreviewStreamStateObserver$1(this, (List)object2, (CameraInfo)object);
        object = CameraXExecutors.directExecutor();
        Futures.addCallback(futureChain, (FutureCallback)object3, (Executor)object);
    }

    private ListenableFuture waitForCaptureResult(CameraInfo cameraInfo, List list) {
        f f10 = new f(this, cameraInfo, list);
        return CallbackToFutureAdapter.getFuture(f10);
    }

    public /* synthetic */ ListenableFuture b(Void void_) {
        return this.a(void_);
    }

    public void clear() {
        this.cancelFlow();
    }

    public /* synthetic */ Void d(Void void_) {
        return this.c(void_);
    }

    public /* synthetic */ Object f(CameraInfo cameraInfo, List list, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.e(cameraInfo, list, callbackToFutureAdapter$Completer);
    }

    public void onError(Throwable object) {
        this.clear();
        object = PreviewView$StreamState.IDLE;
        this.updatePreviewStreamState((PreviewView$StreamState)((Object)object));
    }

    public void onNewData(CameraInternal$State object) {
        CameraInternal$State cameraInternal$State = CameraInternal$State.CLOSING;
        if (object != cameraInternal$State && object != (cameraInternal$State = CameraInternal$State.CLOSED) && object != (cameraInternal$State = CameraInternal$State.RELEASING) && object != (cameraInternal$State = CameraInternal$State.RELEASED)) {
            boolean bl2;
            cameraInternal$State = CameraInternal$State.OPENING;
            if (!(object != cameraInternal$State && object != (cameraInternal$State = CameraInternal$State.OPEN) && object != (cameraInternal$State = CameraInternal$State.PENDING_OPEN) || (bl2 = this.mHasStartedPreviewStreamFlow))) {
                object = this.mCameraInfoInternal;
                this.startPreviewStreamStateFlow((CameraInfo)object);
                this.mHasStartedPreviewStreamFlow = bl2 = true;
            }
        } else {
            object = PreviewView$StreamState.IDLE;
            this.updatePreviewStreamState((PreviewView$StreamState)((Object)object));
            boolean bl3 = this.mHasStartedPreviewStreamFlow;
            if (bl3) {
                bl3 = false;
                object = null;
                this.mHasStartedPreviewStreamFlow = false;
                this.cancelFlow();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updatePreviewStreamState(PreviewView$StreamState previewView$StreamState) {
        synchronized (this) {
            PreviewView$StreamState previewView$StreamState2 = this.mPreviewStreamState;
            boolean bl2 = previewView$StreamState2.equals((Object)previewView$StreamState);
            if (bl2) {
                return;
            }
            this.mPreviewStreamState = previewView$StreamState;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Update Preview stream state to ");
        charSequence.append((Object)previewView$StreamState);
        charSequence = charSequence.toString();
        Logger.d(TAG, (String)charSequence);
        this.mPreviewStreamStateLiveData.postValue((Object)previewView$StreamState);
    }
}

