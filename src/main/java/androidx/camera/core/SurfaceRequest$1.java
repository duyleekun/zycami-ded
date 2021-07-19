/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$RequestCancelledException;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

public class SurfaceRequest$1
implements FutureCallback {
    public final /* synthetic */ SurfaceRequest this$0;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$requestCancellationCompleter;
    public final /* synthetic */ ListenableFuture val$requestCancellationFuture;

    public SurfaceRequest$1(SurfaceRequest surfaceRequest, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ListenableFuture listenableFuture) {
        this.this$0 = surfaceRequest;
        this.val$requestCancellationCompleter = callbackToFutureAdapter$Completer;
        this.val$requestCancellationFuture = listenableFuture;
    }

    public void onFailure(Throwable object) {
        boolean bl2 = object instanceof SurfaceRequest$RequestCancelledException;
        if (bl2) {
            object = this.val$requestCancellationFuture;
            bl2 = object.cancel(false);
            Preconditions.checkState(bl2);
        } else {
            object = this.val$requestCancellationCompleter;
            bl2 = ((CallbackToFutureAdapter$Completer)object).set(null);
            Preconditions.checkState(bl2);
        }
    }

    public void onSuccess(Void void_) {
        Preconditions.checkState(this.val$requestCancellationCompleter.set(null));
    }
}

