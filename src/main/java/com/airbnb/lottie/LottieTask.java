/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask$1;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LottieTask {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    private final Set failureListeners;
    private final Handler handler;
    private volatile LottieResult result;
    private final Set successListeners;

    public LottieTask(Callable callable) {
        this(callable, false);
    }

    public LottieTask(Callable object, boolean bl2) {
        Object object2;
        int n10 = 1;
        this.successListeners = object2 = new LinkedHashSet(n10);
        this.failureListeners = object2 = new LinkedHashSet(n10);
        Looper looper = Looper.getMainLooper();
        this.handler = object2 = new Handler(looper);
        object2 = null;
        this.result = null;
        if (bl2) {
            object = object.call();
            object = (LottieResult)object;
            try {
                this.setResult((LottieResult)object);
            }
            catch (Throwable throwable) {
                LottieResult lottieResult = new LottieResult(throwable);
                this.setResult(lottieResult);
            }
        } else {
            Executor executor = EXECUTOR;
            super(this, (Callable)object);
            executor.execute((Runnable)object2);
        }
    }

    public static /* synthetic */ LottieResult access$000(LottieTask lottieTask) {
        return lottieTask.result;
    }

    public static /* synthetic */ void access$100(LottieTask lottieTask, Object object) {
        lottieTask.notifySuccessListeners(object);
    }

    public static /* synthetic */ void access$200(LottieTask lottieTask, Throwable throwable) {
        lottieTask.notifyFailureListeners(throwable);
    }

    public static /* synthetic */ void access$300(LottieTask lottieTask, LottieResult lottieResult) {
        lottieTask.setResult(lottieResult);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void notifyFailureListeners(Throwable throwable) {
        synchronized (this) {
            Object object = this.failureListeners;
            Iterator iterator2 = new Iterator(object);
            boolean bl2 = iterator2.isEmpty();
            if (bl2) {
                iterator2 = "Lottie encountered an error but no failure listener was added:";
                Logger.warning(iterator2, throwable);
                return;
            }
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                object = iterator2.next();
                object = (LottieListener)object;
                object.onResult(throwable);
            }
            return;
        }
    }

    private void notifyListeners() {
        Handler handler = this.handler;
        LottieTask$1 lottieTask$1 = new LottieTask$1(this);
        handler.post((Runnable)lottieTask$1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void notifySuccessListeners(Object object) {
        synchronized (this) {
            Object object2 = this.successListeners;
            Object object3 = new ArrayList(object2);
            object3 = object3.iterator();
            boolean bl2;
            while (bl2 = object3.hasNext()) {
                object2 = object3.next();
                object2 = (LottieListener)object2;
                object2.onResult(object);
            }
            return;
        }
    }

    private void setResult(LottieResult object) {
        LottieResult lottieResult = this.result;
        if (lottieResult == null) {
            this.result = object;
            this.notifyListeners();
            return;
        }
        object = new IllegalStateException("A task may only be set once.");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LottieTask addFailureListener(LottieListener lottieListener) {
        synchronized (this) {
            Object object = this.result;
            if (object != null) {
                object = this.result;
                if ((object = ((LottieResult)object).getException()) != null) {
                    object = this.result;
                    object = ((LottieResult)object).getException();
                    lottieListener.onResult(object);
                }
            }
            object = this.failureListeners;
            object.add(lottieListener);
            return this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LottieTask addListener(LottieListener lottieListener) {
        synchronized (this) {
            Object object = this.result;
            if (object != null) {
                object = this.result;
                if ((object = ((LottieResult)object).getValue()) != null) {
                    object = this.result;
                    object = ((LottieResult)object).getValue();
                    lottieListener.onResult(object);
                }
            }
            object = this.successListeners;
            object.add(lottieListener);
            return this;
        }
    }

    public LottieTask removeFailureListener(LottieListener lottieListener) {
        synchronized (this) {
            Set set = this.failureListeners;
            set.remove(lottieListener);
            return this;
        }
    }

    public LottieTask removeListener(LottieListener lottieListener) {
        synchronized (this) {
            Set set = this.successListeners;
            set.remove(lottieListener);
            return this;
        }
    }
}

