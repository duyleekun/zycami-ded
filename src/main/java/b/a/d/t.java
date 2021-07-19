/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.SurfaceRequest$Result;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Consumer;

public final class t
implements Consumer {
    public final /* synthetic */ CallbackToFutureAdapter$Completer a;

    public /* synthetic */ t(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = callbackToFutureAdapter$Completer;
    }

    public final void accept(Object object) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.a;
        object = (SurfaceRequest$Result)object;
        callbackToFutureAdapter$Completer.set(object);
    }
}

