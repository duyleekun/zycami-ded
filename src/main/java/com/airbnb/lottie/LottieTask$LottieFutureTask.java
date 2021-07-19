/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LottieTask$LottieFutureTask
extends FutureTask {
    public final /* synthetic */ LottieTask this$0;

    public LottieTask$LottieFutureTask(LottieTask lottieTask, Callable callable) {
        this.this$0 = lottieTask;
        super(callable);
    }

    /*
     * WARNING - void declaration
     */
    public void done() {
        block7: {
            void var2_5;
            boolean bl2 = this.isCancelled();
            if (bl2) {
                return;
            }
            LottieTask lottieTask = this.this$0;
            Object object = this.get();
            object = (LottieResult)object;
            try {
                LottieTask.access$300(lottieTask, (LottieResult)object);
                break block7;
            }
            catch (ExecutionException executionException) {
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            object = this.this$0;
            LottieResult lottieResult = new LottieResult((Throwable)var2_5);
            LottieTask.access$300((LottieTask)object, lottieResult);
        }
    }
}

