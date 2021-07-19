/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$RequestCancelledException;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;

public class SurfaceRequest$3
implements FutureCallback {
    public final /* synthetic */ SurfaceRequest this$0;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$sessionStatusCompleter;
    public final /* synthetic */ String val$surfaceRequestString;
    public final /* synthetic */ ListenableFuture val$terminationFuture;

    public SurfaceRequest$3(SurfaceRequest surfaceRequest, ListenableFuture listenableFuture, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, String string2) {
        this.this$0 = surfaceRequest;
        this.val$terminationFuture = listenableFuture;
        this.val$sessionStatusCompleter = callbackToFutureAdapter$Completer;
        this.val$surfaceRequestString = string2;
    }

    public void onFailure(Throwable object) {
        boolean bl2 = object instanceof CancellationException;
        if (bl2) {
            CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$sessionStatusCompleter;
            CharSequence charSequence = new StringBuilder();
            String string2 = this.val$surfaceRequestString;
            charSequence.append(string2);
            string2 = " cancelled.";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            SurfaceRequest$RequestCancelledException surfaceRequest$RequestCancelledException = new SurfaceRequest$RequestCancelledException((String)charSequence, (Throwable)object);
            boolean bl3 = callbackToFutureAdapter$Completer.setException(surfaceRequest$RequestCancelledException);
            Preconditions.checkState(bl3);
        } else {
            object = this.val$sessionStatusCompleter;
            bl2 = false;
            Object var3_4 = null;
            ((CallbackToFutureAdapter$Completer)object).set(null);
        }
    }

    public void onSuccess(Surface object) {
        object = this.val$terminationFuture;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$sessionStatusCompleter;
        Futures.propagate((ListenableFuture)object, callbackToFutureAdapter$Completer);
    }
}

