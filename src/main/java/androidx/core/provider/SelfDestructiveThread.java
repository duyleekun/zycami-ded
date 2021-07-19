/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.provider.CalleeHandler;
import androidx.core.provider.SelfDestructiveThread$1;
import androidx.core.provider.SelfDestructiveThread$2;
import androidx.core.provider.SelfDestructiveThread$3;
import androidx.core.provider.SelfDestructiveThread$ReplyCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback;
    private final int mDestructAfterMillisec;
    private int mGeneration;
    private Handler mHandler;
    private final Object mLock;
    private final int mPriority;
    private HandlerThread mThread;
    private final String mThreadName;

    public SelfDestructiveThread(String string2, int n10, int n11) {
        Object object;
        this.mLock = object = new Object();
        object = new SelfDestructiveThread$1(this);
        this.mCallback = object;
        this.mThreadName = string2;
        this.mPriority = n10;
        this.mDestructAfterMillisec = n11;
        this.mGeneration = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void post(Runnable runnable) {
        Object object = this.mLock;
        synchronized (object) {
            String string2;
            HandlerThread handlerThread = this.mThread;
            int n10 = 1;
            if (handlerThread == null) {
                int n11;
                string2 = this.mThreadName;
                int n12 = this.mPriority;
                this.mThread = handlerThread = new HandlerThread(string2, n12);
                handlerThread.start();
                string2 = this.mThread;
                string2 = string2.getLooper();
                Handler.Callback callback = this.mCallback;
                handlerThread = new Handler((Looper)string2, callback);
                this.mHandler = handlerThread;
                this.mGeneration = n11 = this.mGeneration + n10;
            }
            handlerThread = this.mHandler;
            string2 = null;
            handlerThread.removeMessages(0);
            handlerThread = this.mHandler;
            runnable = handlerThread.obtainMessage(n10, (Object)runnable);
            handlerThread.sendMessage((Message)runnable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getGeneration() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mGeneration;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isRunning() {
        Object object = this.mLock;
        synchronized (object) {
            HandlerThread handlerThread = this.mThread;
            if (handlerThread == null) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDestruction() {
        Object object = this.mLock;
        synchronized (object) {
            Handler handler = this.mHandler;
            int n10 = 1;
            boolean bl2 = handler.hasMessages(n10);
            if (bl2) {
                return;
            }
            handler = this.mThread;
            handler.quit();
            bl2 = false;
            handler = null;
            this.mThread = null;
            this.mHandler = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onInvokeRunnable(Runnable object) {
        object.run();
        object = this.mLock;
        synchronized (object) {
            Handler handler = this.mHandler;
            Message message = null;
            handler.removeMessages(0);
            handler = this.mHandler;
            message = handler.obtainMessage(0);
            int n10 = this.mDestructAfterMillisec;
            long l10 = n10;
            handler.sendMessageDelayed(message, l10);
            return;
        }
    }

    public void postAndReply(Callable callable, SelfDestructiveThread$ReplyCallback selfDestructiveThread$ReplyCallback) {
        Handler handler = CalleeHandler.create();
        SelfDestructiveThread$2 selfDestructiveThread$2 = new SelfDestructiveThread$2(this, callable, handler, selfDestructiveThread$ReplyCallback);
        this.post(selfDestructiveThread$2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object postAndWait(Callable object, int n10) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        int n11 = 1;
        AtomicBoolean atomicBoolean = new AtomicBoolean(n11 != 0);
        SelfDestructiveThread$3 selfDestructiveThread$3 = new SelfDestructiveThread$3(this, atomicReference, (Callable)object, reentrantLock, atomicBoolean, condition);
        this.post(selfDestructiveThread$3);
        reentrantLock.lock();
        try {
            long l10;
            boolean bl2 = atomicBoolean.get();
            if (!bl2) {
                object = atomicReference.get();
                reentrantLock.unlock();
                return object;
            }
            object = TimeUnit.MILLISECONDS;
            long l11 = n10;
            long l12 = ((TimeUnit)((Object)object)).toNanos(l11);
            do {
                try {
                    l12 = condition.awaitNanos(l12);
                }
                catch (InterruptedException interruptedException) {}
                if ((n11 = atomicBoolean.get()) != 0) continue;
                object = atomicReference.get();
                reentrantLock.unlock();
                return object;
            } while ((n11 = (l10 = l12 - (l11 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0);
            String string2 = "timeout";
            object = new InterruptedException(string2);
            throw object;
        }
        catch (Throwable throwable) {
            reentrantLock.unlock();
            throw throwable;
        }
    }
}

