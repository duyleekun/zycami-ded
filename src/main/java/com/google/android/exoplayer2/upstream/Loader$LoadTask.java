/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader$LoadTask
extends Handler
implements Runnable {
    private static final int MSG_FATAL_ERROR = 3;
    private static final int MSG_FINISH = 1;
    private static final int MSG_IO_EXCEPTION = 2;
    private static final int MSG_START = 0;
    private static final String TAG = "LoadTask";
    private Loader$Callback callback;
    private boolean canceled;
    private IOException currentError;
    public final int defaultMinRetryCount;
    private int errorCount;
    private Thread executorThread;
    private final Loader$Loadable loadable;
    private volatile boolean released;
    private final long startTimeMs;
    public final /* synthetic */ Loader this$0;

    public Loader$LoadTask(Loader loader, Looper looper, Loader$Loadable loader$Loadable, Loader$Callback loader$Callback, int n10, long l10) {
        this.this$0 = loader;
        super(looper);
        this.loadable = loader$Loadable;
        this.callback = loader$Callback;
        this.defaultMinRetryCount = n10;
        this.startTimeMs = l10;
    }

    private void execute() {
        this.currentError = null;
        ExecutorService executorService = Loader.access$500(this.this$0);
        Runnable runnable = (Runnable)Assertions.checkNotNull(Loader.access$100(this.this$0));
        executorService.execute(runnable);
    }

    private void finish() {
        Loader.access$102(this.this$0, null);
    }

    private long getRetryDelayMillis() {
        return Math.min((this.errorCount + -1) * 1000, 5000);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cancel(boolean bl2) {
        this.released = bl2;
        this.currentError = null;
        Object object = null;
        boolean bl3 = this.hasMessages(0);
        int n10 = 1;
        if (bl3) {
            this.canceled = n10;
            this.removeMessages(0);
            if (!bl2) {
                this.sendEmptyMessage(n10);
            }
        } else {
            synchronized (this) {
                this.canceled = n10;
                object = this.loadable;
                object.cancelLoad();
                object = this.executorThread;
                if (object != null) {
                    ((Thread)object).interrupt();
                }
            }
        }
        if (bl2) {
            Object object2;
            this.finish();
            long l10 = SystemClock.elapsedRealtime();
            object = object2 = Assertions.checkNotNull(this.callback);
            object = (Loader$Callback)object2;
            Loader$Loadable loader$Loadable = this.loadable;
            long l11 = this.startTimeMs;
            l11 = l10 - l11;
            boolean bl4 = true;
            object.onLoadCanceled(loader$Loadable, l10, l11, bl4);
            this.callback = null;
        }
    }

    public void handleMessage(Message object) {
        int n10 = this.released;
        if (n10 != 0) {
            return;
        }
        n10 = object.what;
        if (n10 == 0) {
            this.execute();
            return;
        }
        int n11 = 3;
        if (n10 != n11) {
            Object object2;
            this.finish();
            long l10 = SystemClock.elapsedRealtime();
            long l11 = this.startTimeMs;
            long l12 = l10 - l11;
            Object object3 = object2 = Assertions.checkNotNull(this.callback);
            object3 = (Loader$Callback)object2;
            n10 = (int)(this.canceled ? 1 : 0);
            if (n10 != 0) {
                Loader$Loadable loader$Loadable = this.loadable;
                object3.onLoadCanceled(loader$Loadable, l10, l12, false);
                return;
            }
            n10 = object.what;
            int n12 = 1;
            if (n10 != n12) {
                int n13 = 2;
                if (n10 == n13) {
                    int n14;
                    Object object4 = object = object.obj;
                    object4 = (IOException)object;
                    this.currentError = object4;
                    int n15 = this.errorCount;
                    this.errorCount = n14 = n15 + 1;
                    Loader$Loadable loader$Loadable = this.loadable;
                    object = object3.onLoadError(loader$Loadable, l10, l12, (IOException)object4, n14);
                    n10 = Loader$LoadErrorAction.access$300((Loader$LoadErrorAction)object);
                    if (n10 == n11) {
                        object = this.this$0;
                        object2 = this.currentError;
                        Loader.access$202((Loader)object, (IOException)object2);
                    } else {
                        n10 = Loader$LoadErrorAction.access$300((Loader$LoadErrorAction)object);
                        if (n10 != n13) {
                            long l13;
                            long l14;
                            n10 = Loader$LoadErrorAction.access$300((Loader$LoadErrorAction)object);
                            if (n10 == n12) {
                                this.errorCount = n12;
                            }
                            l13 = (n10 = (int)((l14 = (l13 = Loader$LoadErrorAction.access$400((Loader$LoadErrorAction)object)) - (l11 = -9223372036854775807L)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0 ? Loader$LoadErrorAction.access$400((Loader$LoadErrorAction)object) : this.getRetryDelayMillis();
                            this.start(l13);
                        }
                    }
                }
            } else {
                Loader$Loadable loader$Loadable = this.loadable;
                try {
                    object3.onLoadCompleted(loader$Loadable, l10, l12);
                }
                catch (RuntimeException runtimeException) {
                    Log.e(TAG, "Unexpected exception handling load completed", runtimeException);
                    object2 = this.this$0;
                    Loader$UnexpectedLoaderException loader$UnexpectedLoaderException = new Loader$UnexpectedLoaderException(runtimeException);
                    Loader.access$202((Loader)object2, loader$UnexpectedLoaderException);
                }
            }
            return;
        }
        throw (Error)object.obj;
    }

    public void maybeThrowError(int n10) {
        int n11;
        IOException iOException = this.currentError;
        if (iOException != null && (n11 = this.errorCount) > n10) {
            throw iOException;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        Object object;
        Object object2;
        int n10 = 2;
        int n11 = this.canceled;
        int n12 = 1;
        if (n11 == 0) {
            n11 = n12;
        } else {
            n11 = 0;
            object2 = null;
        }
        this.executorThread = object = Thread.currentThread();
        // MONITOREXIT : this
        if (n11 != 0) {
            object2 = "load:";
            object = this.loadable;
            object = object.getClass();
            object = ((Class)object).getSimpleName();
            object = String.valueOf(object);
            int n13 = ((String)object).length();
            object2 = n13 != 0 ? ((String)object2).concat((String)object) : (object = new String((String)object2));
            TraceUtil.beginSection((String)object2);
            object2 = this.loadable;
            object2.load();
            {
                catch (Throwable throwable) {
                    TraceUtil.endSection();
                    throw throwable;
                }
            }
            TraceUtil.endSection();
            // MONITORENTER : this
        }
        n11 = 0;
        object2 = null;
        this.executorThread = null;
        Thread.interrupted();
        // MONITOREXIT : this
        try {
            n11 = (int)(this.released ? 1 : 0);
            if (n11 != 0) return;
            this.sendEmptyMessage(n12);
            return;
        }
        catch (Error error) {
            object2 = TAG;
            String string2 = "Unexpected error loading stream";
            Log.e((String)object2, string2, error);
            n11 = this.released;
            if (n11 != 0) throw error;
            n11 = 3;
            object2 = this.obtainMessage(n11, error);
            object2.sendToTarget();
            throw error;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            Object object3 = TAG;
            object = "OutOfMemory error loading stream";
            Log.e((String)object3, (String)object, outOfMemoryError);
            n12 = this.released;
            if (n12 != 0) return;
            object3 = new Loader$UnexpectedLoaderException(outOfMemoryError);
            Message message = this.obtainMessage(n10, object3);
            message.sendToTarget();
            return;
        }
        catch (Exception exception) {
            Object object4 = TAG;
            object = "Unexpected exception loading stream";
            Log.e((String)object4, (String)object, exception);
            n12 = this.released;
            if (n12 != 0) return;
            object4 = new Loader$UnexpectedLoaderException(exception);
            Message message = this.obtainMessage(n10, object4);
            message.sendToTarget();
            return;
        }
        catch (IOException iOException) {
            n12 = this.released;
            if (n12 != 0) return;
            Message message = this.obtainMessage(n10, iOException);
            message.sendToTarget();
        }
    }

    public void start(long l10) {
        int n10;
        Object object = Loader.access$100(this.this$0);
        if (object == null) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        Assertions.checkState(n10 != 0);
        object = this.this$0;
        Loader.access$102((Loader)object, this);
        long l11 = 0L;
        n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (n10 > 0) {
            this.sendEmptyMessageDelayed(0, l10);
        } else {
            this.execute();
        }
    }
}

