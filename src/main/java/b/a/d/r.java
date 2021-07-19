/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package b.a.d;

import android.view.Surface;
import androidx.camera.view.TextureViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class r
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ TextureViewImplementation a;
    public final /* synthetic */ Surface b;

    public /* synthetic */ r(TextureViewImplementation textureViewImplementation, Surface surface) {
        this.a = textureViewImplementation;
        this.b = surface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        TextureViewImplementation textureViewImplementation = this.a;
        Surface surface = this.b;
        return textureViewImplementation.d(surface, callbackToFutureAdapter$Completer);
    }
}

