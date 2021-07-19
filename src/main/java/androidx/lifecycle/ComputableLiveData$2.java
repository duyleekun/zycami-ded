/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import java.util.concurrent.atomic.AtomicBoolean;

public class ComputableLiveData$2
implements Runnable {
    public final /* synthetic */ ComputableLiveData this$0;

    public ComputableLiveData$2(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        boolean bl2;
        boolean bl3;
        do {
            object = this.this$0.mComputing;
            bl3 = false;
            boolean bl4 = true;
            float f10 = Float.MIN_VALUE;
            bl2 = ((AtomicBoolean)object).compareAndSet(false, bl4);
            if (!bl2) continue;
            bl2 = false;
            object = null;
            boolean bl5 = false;
            try {
                while (true) {
                    Object object2 = this.this$0;
                    object2 = ((ComputableLiveData)object2).mInvalid;
                    boolean bl6 = ((AtomicBoolean)object2).compareAndSet(bl4, false);
                    if (!bl6) break;
                    object = this.this$0;
                    object = ((ComputableLiveData)object).compute();
                    bl5 = bl4;
                }
                if (bl5) {
                    Object object3 = this.this$0;
                    object3 = ((ComputableLiveData)object3).mLiveData;
                    ((LiveData)object3).postValue(object);
                }
                object = this.this$0.mComputing;
                ((AtomicBoolean)object).set(false);
                bl3 = bl5;
            }
            catch (Throwable throwable) {
                this.this$0.mComputing.set(false);
                throw throwable;
            }
        } while (bl3 && (bl2 = ((AtomicBoolean)(object = this.this$0.mInvalid)).get()));
    }
}

