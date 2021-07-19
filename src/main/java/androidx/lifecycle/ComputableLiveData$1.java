/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Executor;

public class ComputableLiveData$1
extends LiveData {
    public final /* synthetic */ ComputableLiveData this$0;

    public ComputableLiveData$1(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    public void onActive() {
        Object object = this.this$0;
        Executor executor = ((ComputableLiveData)object).mExecutor;
        object = ((ComputableLiveData)object).mRefreshRunnable;
        executor.execute((Runnable)object);
    }
}

