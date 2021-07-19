/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 */
package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.arch.core.executor.DefaultTaskExecutor$1;
import androidx.arch.core.executor.TaskExecutor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DefaultTaskExecutor
extends TaskExecutor {
    private final ExecutorService mDiskIO;
    private final Object mLock;
    private volatile Handler mMainHandler;

    public DefaultTaskExecutor() {
        Object object;
        this.mLock = object = new Object();
        object = new DefaultTaskExecutor$1(this);
        this.mDiskIO = object = Executors.newFixedThreadPool(4, (ThreadFactory)object);
    }

    private static Handler createAsync(Looper looper) {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return Handler.createAsync((Looper)looper);
        }
        n11 = 16;
        if (n10 >= n11) {
            object = Handler.class;
            n11 = 3;
            Object object2 = new Class[n11];
            Class clazz = Looper.class;
            object2[0] = clazz;
            clazz = Handler.Callback.class;
            int n12 = 1;
            object2[n12] = clazz;
            clazz = Boolean.TYPE;
            int n13 = 2;
            object2[n13] = clazz;
            object = object.getDeclaredConstructor((Class<?>)object2);
            Object[] objectArray = new Object[n11];
            objectArray[0] = looper;
            object2 = null;
            objectArray[n12] = null;
            object2 = Boolean.TRUE;
            objectArray[n13] = object2;
            object = object.newInstance(objectArray);
            try {
                return object;
            }
            catch (InvocationTargetException invocationTargetException) {
                object = new Handler(looper);
                return object;
            }
            catch (IllegalAccessException | InstantiationException | NoSuchMethodException reflectiveOperationException) {}
        }
        object = new Handler(looper);
        return object;
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    public boolean isMainThread() {
        boolean bl2;
        Thread thread;
        Thread thread2 = Looper.getMainLooper().getThread();
        if (thread2 == (thread = Thread.currentThread())) {
            bl2 = true;
        } else {
            bl2 = false;
            thread2 = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void postToMainThread(Runnable runnable) {
        Object object = this.mMainHandler;
        if (object == null) {
            object = this.mLock;
            synchronized (object) {
                Handler handler = this.mMainHandler;
                if (handler == null) {
                    handler = Looper.getMainLooper();
                    this.mMainHandler = handler = DefaultTaskExecutor.createAsync((Looper)handler);
                }
            }
        }
        this.mMainHandler.post(runnable);
    }
}

