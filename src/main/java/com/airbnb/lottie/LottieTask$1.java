/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;

public class LottieTask$1
implements Runnable {
    public final /* synthetic */ LottieTask this$0;

    public LottieTask$1(LottieTask lottieTask) {
        this.this$0 = lottieTask;
    }

    public void run() {
        Object object = LottieTask.access$000(this.this$0);
        if (object == null) {
            return;
        }
        object = LottieTask.access$000(this.this$0);
        Object object2 = ((LottieResult)object).getValue();
        if (object2 != null) {
            object2 = this.this$0;
            object = ((LottieResult)object).getValue();
            LottieTask.access$100((LottieTask)object2, object);
        } else {
            object2 = this.this$0;
            object = ((LottieResult)object).getException();
            LottieTask.access$200((LottieTask)object2, (Throwable)object);
        }
    }
}

