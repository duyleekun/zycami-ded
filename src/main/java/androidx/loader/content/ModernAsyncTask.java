/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.loader.content;

import android.os.Handler;
import androidx.loader.content.ModernAsyncTask$1;
import androidx.loader.content.ModernAsyncTask$3;
import androidx.loader.content.ModernAsyncTask$4;
import androidx.loader.content.ModernAsyncTask$AsyncTaskResult;
import androidx.loader.content.ModernAsyncTask$InternalHandler;
import androidx.loader.content.ModernAsyncTask$Status;
import androidx.loader.content.ModernAsyncTask$WorkerRunnable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ModernAsyncTask {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static ModernAsyncTask$InternalHandler sHandler;
    private static final BlockingQueue sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    public final AtomicBoolean mCancelled;
    private final FutureTask mFuture;
    private volatile ModernAsyncTask$Status mStatus;
    public final AtomicBoolean mTaskInvoked;
    private final ModernAsyncTask$WorkerRunnable mWorker;

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue;
        ModernAsyncTask$1 modernAsyncTask$1 = new ModernAsyncTask$1();
        sThreadFactory = modernAsyncTask$1;
        sPoolWorkQueue = linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(10);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, timeUnit, linkedBlockingQueue, modernAsyncTask$1);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        sDefaultExecutor = threadPoolExecutor;
    }

    public ModernAsyncTask() {
        Object object;
        this.mStatus = object = ModernAsyncTask$Status.PENDING;
        this.mCancelled = object;
        super();
        this.mTaskInvoked = object;
        super(this);
        this.mWorker = object;
        ModernAsyncTask$3 modernAsyncTask$3 = new ModernAsyncTask$3(this, (Callable)object);
        this.mFuture = modernAsyncTask$3;
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Handler getHandler() {
        Class<ModernAsyncTask> clazz = ModernAsyncTask.class;
        synchronized (clazz) {
            ModernAsyncTask$InternalHandler modernAsyncTask$InternalHandler = sHandler;
            if (modernAsyncTask$InternalHandler != null) return sHandler;
            sHandler = modernAsyncTask$InternalHandler = new ModernAsyncTask$InternalHandler();
            return sHandler;
        }
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean bl2) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(bl2);
    }

    public abstract Object doInBackground(Object ... var1);

    public final ModernAsyncTask execute(Object ... objectArray) {
        Executor executor = sDefaultExecutor;
        return this.executeOnExecutor(executor, objectArray);
    }

    public final ModernAsyncTask executeOnExecutor(Executor object, Object ... object2) {
        ModernAsyncTask$Status modernAsyncTask$Status = this.mStatus;
        ModernAsyncTask$Status modernAsyncTask$Status2 = ModernAsyncTask$Status.PENDING;
        if (modernAsyncTask$Status != modernAsyncTask$Status2) {
            object = ModernAsyncTask$4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status;
            object2 = this.mStatus;
            int n10 = ((Enum)object2).ordinal();
            Object object3 = object[n10];
            if (object3 != (n10 = 1)) {
                n10 = 2;
                if (object3 != n10) {
                    object = new IllegalStateException("We should never reach this state");
                    throw object;
                }
                object = new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                throw object;
            }
            object = new IllegalStateException("Cannot execute task: the task is already running.");
            throw object;
        }
        this.mStatus = modernAsyncTask$Status = ModernAsyncTask$Status.RUNNING;
        this.onPreExecute();
        this.mWorker.mParams = object2;
        object2 = this.mFuture;
        object.execute((Runnable)object2);
        return this;
    }

    public void finish(Object object) {
        boolean bl2 = this.isCancelled();
        if (bl2) {
            this.onCancelled(object);
        } else {
            this.onPostExecute(object);
        }
        object = ModernAsyncTask$Status.FINISHED;
        this.mStatus = object;
    }

    public final Object get() {
        return this.mFuture.get();
    }

    public final Object get(long l10, TimeUnit timeUnit) {
        return this.mFuture.get(l10, timeUnit);
    }

    public final ModernAsyncTask$Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public void onCancelled() {
    }

    public void onCancelled(Object object) {
        this.onCancelled();
    }

    public void onPostExecute(Object object) {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Object ... objectArray) {
    }

    public Object postResult(Object object) {
        Handler handler = ModernAsyncTask.getHandler();
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        ModernAsyncTask$AsyncTaskResult modernAsyncTask$AsyncTaskResult = new ModernAsyncTask$AsyncTaskResult(this, objectArray);
        handler.obtainMessage(n10, (Object)modernAsyncTask$AsyncTaskResult).sendToTarget();
        return object;
    }

    public void postResultIfNotInvoked(Object object) {
        AtomicBoolean atomicBoolean = this.mTaskInvoked;
        boolean bl2 = atomicBoolean.get();
        if (!bl2) {
            this.postResult(object);
        }
    }

    public final void publishProgress(Object ... message) {
        boolean bl2 = this.isCancelled();
        if (!bl2) {
            Handler handler = ModernAsyncTask.getHandler();
            int n10 = 2;
            ModernAsyncTask$AsyncTaskResult modernAsyncTask$AsyncTaskResult = new ModernAsyncTask$AsyncTaskResult(this, (Object[])message);
            message = handler.obtainMessage(n10, (Object)modernAsyncTask$AsyncTaskResult);
            message.sendToTarget();
        }
    }
}

