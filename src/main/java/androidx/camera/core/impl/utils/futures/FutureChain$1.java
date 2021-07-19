/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;

public class FutureChain$1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ FutureChain this$0;

    public FutureChain$1(FutureChain futureChain) {
        this.this$0 = futureChain;
    }

    public Object attachCompleter(CallbackToFutureAdapter$Completer object) {
        boolean bl2;
        Object object2 = this.this$0.mCompleter;
        if (object2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        Preconditions.checkState(bl2, "The result can only set once!");
        this.this$0.mCompleter = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("FutureChain[");
        object2 = this.this$0;
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }
}

