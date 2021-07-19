/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.upstream;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$LoadTask;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.Loader$ReleaseCallback;
import com.google.android.exoplayer2.upstream.Loader$ReleaseTask;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader
implements LoaderErrorThrower {
    private static final int ACTION_TYPE_DONT_RETRY = 2;
    private static final int ACTION_TYPE_DONT_RETRY_FATAL = 3;
    private static final int ACTION_TYPE_RETRY = 0;
    private static final int ACTION_TYPE_RETRY_AND_RESET_ERROR_COUNT = 1;
    public static final Loader$LoadErrorAction DONT_RETRY;
    public static final Loader$LoadErrorAction DONT_RETRY_FATAL;
    public static final Loader$LoadErrorAction RETRY;
    public static final Loader$LoadErrorAction RETRY_RESET_ERROR_COUNT;
    private Loader$LoadTask currentTask;
    private final ExecutorService downloadExecutorService;
    private IOException fatalError;

    static {
        Loader$LoadErrorAction loader$LoadErrorAction;
        long l10 = -9223372036854775807L;
        RETRY = Loader.createRetryAction(false, l10);
        RETRY_RESET_ERROR_COUNT = Loader.createRetryAction(true, l10);
        DONT_RETRY = loader$LoadErrorAction = new Loader$LoadErrorAction(2, l10, null);
        DONT_RETRY_FATAL = loader$LoadErrorAction = new Loader$LoadErrorAction(3, l10, null);
    }

    public Loader(String object) {
        this.downloadExecutorService = object = Util.newSingleThreadExecutor((String)object);
    }

    public static /* synthetic */ Loader$LoadTask access$100(Loader loader) {
        return loader.currentTask;
    }

    public static /* synthetic */ Loader$LoadTask access$102(Loader loader, Loader$LoadTask loader$LoadTask) {
        loader.currentTask = loader$LoadTask;
        return loader$LoadTask;
    }

    public static /* synthetic */ IOException access$202(Loader loader, IOException iOException) {
        loader.fatalError = iOException;
        return iOException;
    }

    public static /* synthetic */ ExecutorService access$500(Loader loader) {
        return loader.downloadExecutorService;
    }

    public static Loader$LoadErrorAction createRetryAction(boolean bl2, long l10) {
        Loader$LoadErrorAction loader$LoadErrorAction = new Loader$LoadErrorAction((int)(bl2 ? 1 : 0), l10, null);
        return loader$LoadErrorAction;
    }

    public void cancelLoading() {
        ((Loader$LoadTask)Assertions.checkStateNotNull(this.currentTask)).cancel(false);
    }

    public void clearFatalError() {
        this.fatalError = null;
    }

    public boolean hasFatalError() {
        boolean bl2;
        IOException iOException = this.fatalError;
        if (iOException != null) {
            bl2 = true;
        } else {
            bl2 = false;
            iOException = null;
        }
        return bl2;
    }

    public boolean isLoading() {
        boolean bl2;
        Loader$LoadTask loader$LoadTask = this.currentTask;
        if (loader$LoadTask != null) {
            bl2 = true;
        } else {
            bl2 = false;
            loader$LoadTask = null;
        }
        return bl2;
    }

    public void maybeThrowError() {
        this.maybeThrowError(-1 << -1);
    }

    public void maybeThrowError(int n10) {
        Object object = this.fatalError;
        if (object == null) {
            object = this.currentTask;
            if (object != null) {
                int n11 = -1 << -1;
                if (n10 == n11) {
                    n10 = ((Loader$LoadTask)object).defaultMinRetryCount;
                }
                ((Loader$LoadTask)object).maybeThrowError(n10);
            }
            return;
        }
        throw object;
    }

    public void release() {
        this.release(null);
    }

    public void release(Loader$ReleaseCallback loader$ReleaseCallback) {
        Object object = this.currentTask;
        if (object != null) {
            boolean bl2 = true;
            ((Loader$LoadTask)object).cancel(bl2);
        }
        if (loader$ReleaseCallback != null) {
            object = this.downloadExecutorService;
            Loader$ReleaseTask loader$ReleaseTask = new Loader$ReleaseTask(loader$ReleaseCallback);
            object.execute(loader$ReleaseTask);
        }
        this.downloadExecutorService.shutdown();
    }

    public long startLoading(Loader$Loadable loader$Loadable, Loader$Callback loader$Callback, int n10) {
        Object object;
        Object object2 = object = Assertions.checkStateNotNull(Looper.myLooper());
        object2 = (Looper)object;
        this.fatalError = null;
        long l10 = SystemClock.elapsedRealtime();
        object = new Loader$LoadTask(this, (Looper)object2, loader$Loadable, loader$Callback, n10, l10);
        ((Loader$LoadTask)object).start(0L);
        return l10;
    }
}

