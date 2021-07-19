/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.core.provider;

import android.os.Handler;
import androidx.core.provider.RequestExecutor$ReplyRunnable$1;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;

public class RequestExecutor$ReplyRunnable
implements Runnable {
    private Callable mCallable;
    private Consumer mConsumer;
    private Handler mHandler;

    public RequestExecutor$ReplyRunnable(Handler handler, Callable callable, Consumer consumer) {
        this.mCallable = callable;
        this.mConsumer = consumer;
        this.mHandler = handler;
    }

    public void run() {
        Callable callable = this.mCallable;
        try {
            callable = callable.call();
        }
        catch (Exception exception) {
            callable = null;
        }
        Consumer consumer = this.mConsumer;
        Handler handler = this.mHandler;
        RequestExecutor$ReplyRunnable$1 requestExecutor$ReplyRunnable$1 = new RequestExecutor$ReplyRunnable$1(this, consumer, callable);
        handler.post((Runnable)requestExecutor$ReplyRunnable$1);
    }
}

