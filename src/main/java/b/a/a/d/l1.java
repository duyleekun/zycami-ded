/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class l1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ZoomControl a;
    public final /* synthetic */ ZoomState b;

    public /* synthetic */ l1(ZoomControl zoomControl, ZoomState zoomState) {
        this.a = zoomControl;
        this.b = zoomState;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ZoomControl zoomControl = this.a;
        ZoomState zoomState = this.b;
        return zoomControl.d(zoomState, callbackToFutureAdapter$Completer);
    }
}

