/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable$1;
import androidx.camera.core.impl.LiveDataObservable$Result;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Preconditions;

public class LiveDataObservable$1$1
implements Runnable {
    public final /* synthetic */ LiveDataObservable$1 this$1;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;

    public LiveDataObservable$1$1(LiveDataObservable$1 var1_1, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.this$1 = var1_1;
        this.val$completer = callbackToFutureAdapter$Completer;
    }

    public void run() {
        Object object = (LiveDataObservable$Result)this.this$1.this$0.mLiveData.getValue();
        if (object == null) {
            object = this.val$completer;
            String string2 = "Observable has not yet been initialized with a value.";
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            ((CallbackToFutureAdapter$Completer)object).setException(illegalStateException);
        } else {
            boolean bl2 = ((LiveDataObservable$Result)object).completedSuccessfully();
            if (bl2) {
                CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$completer;
                object = ((LiveDataObservable$Result)object).getValue();
                callbackToFutureAdapter$Completer.set(object);
            } else {
                Preconditions.checkNotNull(((LiveDataObservable$Result)object).getError());
                CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$completer;
                object = ((LiveDataObservable$Result)object).getError();
                callbackToFutureAdapter$Completer.setException((Throwable)object);
            }
        }
    }
}

