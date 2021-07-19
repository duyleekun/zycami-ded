/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.LiveDataObservable$1$1;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public class LiveDataObservable$1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ LiveDataObservable this$0;

    public LiveDataObservable$1(LiveDataObservable liveDataObservable) {
        this.this$0 = liveDataObservable;
    }

    public Object attachCompleter(CallbackToFutureAdapter$Completer object) {
        Object object2 = CameraXExecutors.mainThreadExecutor();
        LiveDataObservable$1$1 liveDataObservable$1$1 = new LiveDataObservable$1$1(this, (CallbackToFutureAdapter$Completer)object);
        object2.execute(liveDataObservable$1$1);
        object = new StringBuilder();
        object2 = this.this$0;
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(" [fetch@");
        long l10 = SystemClock.uptimeMillis();
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }
}

