/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter;
import androidx.camera.core.impl.LiveDataObservable$Result;
import androidx.core.util.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;

public class LiveDataObservable$LiveDataObserverAdapter$1
implements Runnable {
    public final /* synthetic */ LiveDataObservable$LiveDataObserverAdapter this$0;
    public final /* synthetic */ LiveDataObservable$Result val$result;

    public LiveDataObservable$LiveDataObserverAdapter$1(LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter, LiveDataObservable$Result liveDataObservable$Result) {
        this.this$0 = liveDataObservable$LiveDataObserverAdapter;
        this.val$result = liveDataObservable$Result;
    }

    public void run() {
        Object object = this.this$0.mActive;
        boolean bl2 = ((AtomicBoolean)object).get();
        if (!bl2) {
            return;
        }
        object = this.val$result;
        bl2 = ((LiveDataObservable$Result)object).completedSuccessfully();
        if (bl2) {
            object = this.this$0.mObserver;
            Object object2 = this.val$result.getValue();
            object.onNewData(object2);
        } else {
            Preconditions.checkNotNull(this.val$result.getError());
            object = this.this$0.mObserver;
            Throwable throwable = this.val$result.getError();
            object.onError(throwable);
        }
    }
}

