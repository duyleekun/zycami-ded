/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.view.TextureViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class o
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ TextureViewImplementation a;

    public /* synthetic */ o(TextureViewImplementation textureViewImplementation) {
        this.a = textureViewImplementation;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.h(callbackToFutureAdapter$Completer);
    }
}

