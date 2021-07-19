/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ProcessingImageReader;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class x0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ProcessingImageReader a;

    public /* synthetic */ x0(ProcessingImageReader processingImageReader) {
        this.a = processingImageReader;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.b(callbackToFutureAdapter$Completer);
    }
}

