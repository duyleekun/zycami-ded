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
import java.util.concurrent.Executor;

public final class l
implements Runnable {
    public final /* synthetic */ CameraX a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ CallbackToFutureAdapter$Completer d;
    public final /* synthetic */ long e;

    public /* synthetic */ l(CameraX cameraX, Context context, Executor executor, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, long l10) {
        this.a = cameraX;
        this.b = context;
        this.c = executor;
        this.d = callbackToFutureAdapter$Completer;
        this.e = l10;
    }

    public final void run() {
        CameraX cameraX = this.a;
        Context context = this.b;
        Executor executor = this.c;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.d;
        long l10 = this.e;
        cameraX.f(context, executor, callbackToFutureAdapter$Completer, l10);
    }
}

