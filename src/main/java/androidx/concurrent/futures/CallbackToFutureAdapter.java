/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import com.google.common.util.concurrent.ListenableFuture;

public final class CallbackToFutureAdapter {
    private CallbackToFutureAdapter() {
    }

    public static ListenableFuture getFuture(CallbackToFutureAdapter$Resolver object) {
        CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture;
        block3: {
            Class<?> clazz;
            CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = new CallbackToFutureAdapter$Completer();
            callbackToFutureAdapter$Completer.future = callbackToFutureAdapter$SafeFuture = new CallbackToFutureAdapter$SafeFuture(callbackToFutureAdapter$Completer);
            callbackToFutureAdapter$Completer.tag = clazz = object.getClass();
            object = object.attachCompleter(callbackToFutureAdapter$Completer);
            if (object == null) break block3;
            try {
                callbackToFutureAdapter$Completer.tag = object;
            }
            catch (Exception exception) {
                callbackToFutureAdapter$SafeFuture.setException(exception);
            }
        }
        return callbackToFutureAdapter$SafeFuture;
    }
}

