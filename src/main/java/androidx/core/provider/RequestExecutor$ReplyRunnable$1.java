/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import androidx.core.provider.RequestExecutor$ReplyRunnable;
import androidx.core.util.Consumer;

public class RequestExecutor$ReplyRunnable$1
implements Runnable {
    public final /* synthetic */ RequestExecutor.ReplyRunnable this$0;
    public final /* synthetic */ Consumer val$consumer;
    public final /* synthetic */ Object val$result;

    public RequestExecutor$ReplyRunnable$1(RequestExecutor.ReplyRunnable replyRunnable, Consumer consumer, Object object) {
        this.this$0 = replyRunnable;
        this.val$consumer = consumer;
        this.val$result = object;
    }

    public void run() {
        Consumer consumer = this.val$consumer;
        Object object = this.val$result;
        consumer.accept(object);
    }
}

