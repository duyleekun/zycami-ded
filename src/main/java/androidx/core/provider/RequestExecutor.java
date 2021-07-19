/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.core.provider;

import android.os.Handler;
import androidx.core.provider.CalleeHandler;
import androidx.core.provider.RequestExecutor$DefaultThreadFactory;
import androidx.core.provider.RequestExecutor$HandlerExecutor;
import androidx.core.provider.RequestExecutor$ReplyRunnable;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestExecutor {
    private RequestExecutor() {
    }

    public static ThreadPoolExecutor createDefaultExecutor(String object, int n10, int n11) {
        RequestExecutor$DefaultThreadFactory requestExecutor$DefaultThreadFactory = new RequestExecutor$DefaultThreadFactory((String)object, n10);
        long l10 = n11;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<Runnable>();
        object = new ThreadPoolExecutor(0, 1, l10, timeUnit, linkedBlockingDeque, requestExecutor$DefaultThreadFactory);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
        return object;
    }

    public static Executor createHandlerExecutor(Handler handler) {
        RequestExecutor$HandlerExecutor requestExecutor$HandlerExecutor = new RequestExecutor$HandlerExecutor(handler);
        return requestExecutor$HandlerExecutor;
    }

    public static void execute(Executor executor, Callable callable, Consumer consumer) {
        Handler handler = CalleeHandler.create();
        RequestExecutor$ReplyRunnable requestExecutor$ReplyRunnable = new RequestExecutor$ReplyRunnable(handler, callable, consumer);
        executor.execute(requestExecutor$ReplyRunnable);
    }

    public static Object submit(ExecutorService object, Callable object2, int n10) {
        object = object.submit(object2);
        long l10 = n10;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            return object.get(l10, timeUnit);
        }
        catch (TimeoutException timeoutException) {
            object = new InterruptedException("timeout");
            throw object;
        }
        catch (InterruptedException interruptedException) {
            throw interruptedException;
        }
        catch (ExecutionException executionException) {
            object2 = new RuntimeException(executionException);
            throw object2;
        }
    }
}

