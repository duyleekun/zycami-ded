/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.SystemClock
 */
package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.util.TimeUtils;
import androidx.loader.content.AsyncTaskLoader$LoadTask;
import androidx.loader.content.Loader;
import androidx.loader.content.ModernAsyncTask;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader
extends Loader {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncTaskLoader";
    public volatile AsyncTaskLoader$LoadTask mCancellingTask;
    private final Executor mExecutor;
    public Handler mHandler;
    public long mLastLoadCompleteTime;
    public volatile AsyncTaskLoader$LoadTask mTask;
    public long mUpdateThrottle;

    public AsyncTaskLoader(Context context) {
        Executor executor = ModernAsyncTask.THREAD_POOL_EXECUTOR;
        this(context, executor);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask, Object object) {
        this.onCanceled(object);
        object = this.mCancellingTask;
        if (object == asyncTaskLoader$LoadTask) {
            long l10;
            this.rollbackContentChanged();
            this.mLastLoadCompleteTime = l10 = SystemClock.uptimeMillis();
            asyncTaskLoader$LoadTask = null;
            this.mCancellingTask = null;
            this.deliverCancellation();
            this.executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask, Object object) {
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask2 = this.mTask;
        if (asyncTaskLoader$LoadTask2 != asyncTaskLoader$LoadTask) {
            this.dispatchOnCancelled(asyncTaskLoader$LoadTask, object);
        } else {
            boolean bl2 = this.isAbandoned();
            if (bl2) {
                this.onCanceled(object);
            } else {
                long l10;
                this.commitContentChanged();
                this.mLastLoadCompleteTime = l10 = SystemClock.uptimeMillis();
                bl2 = false;
                asyncTaskLoader$LoadTask = null;
                this.mTask = null;
                this.deliverResult(object);
            }
        }
    }

    public void dump(String string2, FileDescriptor object, PrintWriter printWriter, String[] object2) {
        long l10;
        long l11;
        long l12;
        long l13;
        super.dump(string2, (FileDescriptor)object, printWriter, (String[])object2);
        object = this.mTask;
        object2 = " waiting=";
        if (object != null) {
            printWriter.print(string2);
            printWriter.print("mTask=");
            object = this.mTask;
            printWriter.print(object);
            printWriter.print((String)object2);
            object = this.mTask;
            l13 = (long)((AsyncTaskLoader$LoadTask)object).waiting;
            printWriter.println((boolean)l13);
        }
        if ((object = this.mCancellingTask) != null) {
            printWriter.print(string2);
            printWriter.print("mCancellingTask=");
            object = this.mCancellingTask;
            printWriter.print(object);
            printWriter.print((String)object2);
            object = this.mCancellingTask;
            l13 = (long)((AsyncTaskLoader$LoadTask)object).waiting;
            printWriter.println((boolean)l13);
        }
        if ((l13 = (l12 = (l11 = this.mUpdateThrottle) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            printWriter.print(string2);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, printWriter);
            string2 = " mLastLoadCompleteTime=";
            printWriter.print(string2);
            long l14 = this.mLastLoadCompleteTime;
            l11 = SystemClock.uptimeMillis();
            TimeUtils.formatDuration(l14, l11, printWriter);
            printWriter.println();
        }
    }

    public void executePendingTask() {
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = this.mCancellingTask;
        if (asyncTaskLoader$LoadTask == null && (asyncTaskLoader$LoadTask = this.mTask) != null) {
            long l10;
            long l11;
            long l12;
            Object object;
            asyncTaskLoader$LoadTask = this.mTask;
            int n10 = asyncTaskLoader$LoadTask.waiting;
            if (n10 != 0) {
                this.mTask.waiting = false;
                asyncTaskLoader$LoadTask = this.mHandler;
                object = this.mTask;
                asyncTaskLoader$LoadTask.removeCallbacks((Runnable)object);
            }
            if ((n10 = (l12 = (l11 = this.mUpdateThrottle) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                l11 = SystemClock.uptimeMillis();
                l10 = this.mLastLoadCompleteTime;
                long l13 = this.mUpdateThrottle;
                long l14 = l11 - (l10 += l13);
                n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                if (n10 < 0) {
                    this.mTask.waiting = true;
                    asyncTaskLoader$LoadTask = this.mHandler;
                    object = this.mTask;
                    l10 = this.mLastLoadCompleteTime;
                    l13 = this.mUpdateThrottle;
                    asyncTaskLoader$LoadTask.postAtTime((Runnable)object, l10 += l13);
                    return;
                }
            }
            asyncTaskLoader$LoadTask = this.mTask;
            object = this.mExecutor;
            asyncTaskLoader$LoadTask.executeOnExecutor((Executor)object, null);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        boolean bl2;
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = this.mCancellingTask;
        if (asyncTaskLoader$LoadTask != null) {
            bl2 = true;
        } else {
            bl2 = false;
            asyncTaskLoader$LoadTask = null;
        }
        return bl2;
    }

    public abstract Object loadInBackground();

    public boolean onCancelLoad() {
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = this.mTask;
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask2 = null;
        if (asyncTaskLoader$LoadTask != null) {
            boolean bl2 = this.mStarted;
            if (!bl2) {
                this.mContentChanged = bl2 = true;
            }
            if ((asyncTaskLoader$LoadTask = this.mCancellingTask) != null) {
                asyncTaskLoader$LoadTask = this.mTask;
                bl2 = asyncTaskLoader$LoadTask.waiting;
                if (bl2) {
                    this.mTask.waiting = false;
                    asyncTaskLoader$LoadTask = this.mHandler;
                    AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask3 = this.mTask;
                    asyncTaskLoader$LoadTask.removeCallbacks(asyncTaskLoader$LoadTask3);
                }
                this.mTask = null;
                return false;
            }
            asyncTaskLoader$LoadTask = this.mTask;
            bl2 = asyncTaskLoader$LoadTask.waiting;
            if (bl2) {
                this.mTask.waiting = false;
                asyncTaskLoader$LoadTask = this.mHandler;
                AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask4 = this.mTask;
                asyncTaskLoader$LoadTask.removeCallbacks(asyncTaskLoader$LoadTask4);
                this.mTask = null;
                return false;
            }
            asyncTaskLoader$LoadTask = this.mTask;
            bl2 = asyncTaskLoader$LoadTask.cancel(false);
            if (bl2) {
                this.mCancellingTask = asyncTaskLoader$LoadTask2 = this.mTask;
                this.cancelLoadInBackground();
            }
            this.mTask = null;
            return bl2;
        }
        return false;
    }

    public void onCanceled(Object object) {
    }

    public void onForceLoad() {
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask;
        super.onForceLoad();
        this.cancelLoad();
        this.mTask = asyncTaskLoader$LoadTask = new AsyncTaskLoader$LoadTask(this);
        this.executePendingTask();
    }

    public Object onLoadInBackground() {
        return this.loadInBackground();
    }

    public void setUpdateThrottle(long l10) {
        this.mUpdateThrottle = l10;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            Handler handler;
            this.mHandler = handler = new Handler();
        }
    }

    public void waitForLoader() {
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = this.mTask;
        if (asyncTaskLoader$LoadTask != null) {
            asyncTaskLoader$LoadTask.waitForLoader();
        }
    }
}

