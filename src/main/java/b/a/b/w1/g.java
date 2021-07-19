/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class g
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ DeferrableSurface a;

    public /* synthetic */ g(DeferrableSurface deferrableSurface) {
        this.a = deferrableSurface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.b(callbackToFutureAdapter$Completer);
    }
}

