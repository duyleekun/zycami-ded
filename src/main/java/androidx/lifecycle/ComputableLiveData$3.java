/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import java.util.concurrent.atomic.AtomicBoolean;

public class ComputableLiveData$3
implements Runnable {
    public final /* synthetic */ ComputableLiveData this$0;

    public ComputableLiveData$3(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    public void run() {
        Object object = this.this$0.mLiveData;
        boolean bl2 = ((LiveData)object).hasActiveObservers();
        Object object2 = this.this$0.mInvalid;
        boolean bl3 = true;
        boolean bl4 = ((AtomicBoolean)object2).compareAndSet(false, bl3);
        if (bl4 && bl2) {
            object = this.this$0;
            object2 = ((ComputableLiveData)object).mExecutor;
            object = ((ComputableLiveData)object).mRefreshRunnable;
            object2.execute((Runnable)object);
        }
    }
}

