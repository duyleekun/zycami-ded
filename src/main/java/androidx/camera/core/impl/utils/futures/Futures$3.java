/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class Futures$3
implements FutureCallback {
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;
    public final /* synthetic */ Function val$function;

    public Futures$3(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, Function function) {
        this.val$completer = callbackToFutureAdapter$Completer;
        this.val$function = function;
    }

    public void onFailure(Throwable throwable) {
        this.val$completer.setException(throwable);
    }

    public void onSuccess(Object object) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$completer;
        Function function = this.val$function;
        object = function.apply(object);
        try {
            callbackToFutureAdapter$Completer.set(object);
        }
        catch (Throwable throwable) {
            callbackToFutureAdapter$Completer = this.val$completer;
            callbackToFutureAdapter$Completer.setException(throwable);
        }
    }
}

