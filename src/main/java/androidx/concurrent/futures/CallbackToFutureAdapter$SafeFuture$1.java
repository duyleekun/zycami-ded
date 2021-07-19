/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;

public class CallbackToFutureAdapter$SafeFuture$1
extends AbstractResolvableFuture {
    public final /* synthetic */ CallbackToFutureAdapter$SafeFuture this$0;

    public CallbackToFutureAdapter$SafeFuture$1(CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture) {
        this.this$0 = callbackToFutureAdapter$SafeFuture;
    }

    public String pendingToString() {
        Object object = (CallbackToFutureAdapter$Completer)this.this$0.completerWeakReference.get();
        if (object == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=[");
        object = ((CallbackToFutureAdapter$Completer)object).tag;
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

