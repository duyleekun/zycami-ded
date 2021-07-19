/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package b.a.b;

import android.content.Context;
import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class d
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ CameraX a;
    public final /* synthetic */ Context b;

    public /* synthetic */ d(CameraX cameraX, Context context) {
        this.a = cameraX;
        this.b = context;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        CameraX cameraX = this.a;
        Context context = this.b;
        return cameraX.h(context, callbackToFutureAdapter$Completer);
    }
}

