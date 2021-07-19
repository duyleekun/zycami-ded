/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;

public class ListFuture$1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ListFuture this$0;

    public ListFuture$1(ListFuture listFuture) {
        this.this$0 = listFuture;
    }

    public Object attachCompleter(CallbackToFutureAdapter$Completer object) {
        boolean bl2;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.this$0.mResultNotifier;
        if (callbackToFutureAdapter$Completer == null) {
            bl2 = true;
        } else {
            bl2 = false;
            callbackToFutureAdapter$Completer = null;
        }
        Preconditions.checkState(bl2, "The result can only set once!");
        this.this$0.mResultNotifier = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("ListFuture[");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }
}

