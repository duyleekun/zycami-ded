/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult$StatusListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler;
import com.google.android.gms.common.api.internal.BasePendingResult$zaa;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.api.internal.zap;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasePendingResult
extends PendingResult {
    public static final ThreadLocal zadn;
    private BasePendingResult$zaa mResultGuardian;
    private Status mStatus;
    private Result zacj;
    private final Object zado;
    private final BasePendingResult$CallbackHandler zadp;
    private final WeakReference zadq;
    private final CountDownLatch zadr;
    private final ArrayList zads;
    private ResultCallback zadt;
    private final AtomicReference zadu;
    private volatile boolean zadv;
    private boolean zadw;
    private boolean zadx;
    private ICancelToken zady;
    private volatile zacm zadz;
    private boolean zaea;

    static {
        zap zap2 = new zap();
        zadn = zap2;
    }

    public BasePendingResult() {
        Object object = new Object();
        this.zado = object;
        object = new Object(1);
        this.zadr = object;
        this.zads = object = new Object();
        this.zadu = object;
        this.zaea = false;
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.zadp = object;
        super(null);
        this.zadq = object;
    }

    public BasePendingResult(Looper object) {
        Object object2 = new Object();
        this.zado = object2;
        object2 = new Object(1);
        this.zadr = object2;
        this.zads = object2 = new Object();
        this.zadu = object2;
        this.zaea = false;
        super((Looper)object);
        this.zadp = object2;
        super(null);
        this.zadq = object;
    }

    public BasePendingResult(GoogleApiClient googleApiClient) {
        BasePendingResult$CallbackHandler basePendingResult$CallbackHandler;
        Object object = new Object();
        this.zado = object;
        int n10 = 1;
        object = new CountDownLatch(n10);
        this.zadr = object;
        object = new ArrayList();
        this.zads = object;
        this.zadu = object;
        object = null;
        this.zaea = false;
        object = googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper();
        this.zadp = basePendingResult$CallbackHandler = new BasePendingResult$CallbackHandler((Looper)object);
        super(googleApiClient);
        this.zadq = object;
    }

    public BasePendingResult(BasePendingResult$CallbackHandler object) {
        Serializable serializable = new Serializable();
        this.zado = serializable;
        serializable = new Serializable(1);
        this.zadr = serializable;
        this.zads = serializable = new Serializable();
        this.zadu = serializable;
        this.zaea = false;
        this.zadp = object = (BasePendingResult$CallbackHandler)((Object)Preconditions.checkNotNull(object, "CallbackHandler must not be null"));
        super(null);
        this.zadq = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Result get() {
        Result result2;
        Object object = this.zado;
        synchronized (object) {
            boolean bl2 = this.zadv;
            boolean bl3 = true;
            if (!bl2) {
                bl2 = bl3;
            } else {
                bl2 = false;
                result2 = null;
            }
            String string2 = "Result has already been consumed.";
            Preconditions.checkState(bl2, string2);
            bl2 = this.isReady();
            string2 = "Result is not ready.";
            Preconditions.checkState(bl2, string2);
            result2 = this.zacj;
            string2 = null;
            this.zacj = null;
            this.zadt = null;
            this.zadv = bl3;
        }
        object = this.zadu.getAndSet(null);
        if (object != null) {
            object.zac(this);
        }
        return result2;
    }

    public static /* synthetic */ Result zaa(BasePendingResult basePendingResult) {
        return basePendingResult.zacj;
    }

    private final void zaa(Result object) {
        Result result2;
        this.zacj = object;
        object = null;
        this.zady = null;
        this.zadr.countDown();
        Object object2 = this.zacj.getStatus();
        this.mStatus = object2;
        int n10 = this.zadw;
        if (n10 != 0) {
            this.zadt = null;
        } else {
            object2 = this.zadt;
            if (object2 == null) {
                object2 = this.zacj;
                n10 = object2 instanceof Releasable;
                if (n10 != 0) {
                    this.mResultGuardian = object2 = new BasePendingResult$zaa(this, null);
                }
            } else {
                object = this.zadp;
                n10 = 2;
                object.removeMessages(n10);
                object = this.zadp;
                object2 = this.zadt;
                result2 = this.get();
                ((BasePendingResult$CallbackHandler)((Object)object)).zaa((ResultCallback)object2, result2);
            }
        }
        object = this.zads;
        n10 = ((ArrayList)object).size();
        result2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = ((ArrayList)object).get(i10);
            object3 = (PendingResult$StatusListener)object3;
            Status status = this.mStatus;
            object3.onComplete(status);
        }
        this.zads.clear();
    }

    public static void zab(Result object) {
        boolean bl2 = object instanceof Releasable;
        if (bl2) {
            Object object2 = object;
            object2 = (Releasable)object;
            try {
                object2.release();
                return;
            }
            catch (RuntimeException runtimeException) {
                object = String.valueOf(object);
                int n10 = String.valueOf(object).length() + 18;
                StringBuilder stringBuilder = new StringBuilder(n10);
                stringBuilder.append("Unable to release ");
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                String string2 = "BasePendingResult";
                Log.w((String)string2, (String)object, (Throwable)runtimeException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void addStatusListener(PendingResult$StatusListener pendingResult$StatusListener) {
        Object object;
        boolean bl2;
        if (pendingResult$StatusListener != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Object object2 = "Callback cannot be null.";
        Preconditions.checkArgument(bl2, object2);
        object = this.zado;
        synchronized (object) {
            boolean bl3 = this.isReady();
            if (bl3) {
                object2 = this.mStatus;
                pendingResult$StatusListener.onComplete((Status)object2);
            } else {
                object2 = this.zads;
                ((ArrayList)object2).add(pendingResult$StatusListener);
            }
            return;
        }
    }

    public final Result await() {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        boolean bl2 = this.zadv;
        boolean bl3 = true;
        String string2 = "Result has already been consumed";
        Preconditions.checkState(bl2 ^= bl3, string2);
        Object object = this.zadz;
        if (object != null) {
            bl3 = false;
        }
        object = "Cannot await if then() has been called.";
        Preconditions.checkState(bl3, object);
        object = this.zadr;
        try {
            ((CountDownLatch)object).await();
        }
        catch (InterruptedException interruptedException) {
            object = Status.RESULT_INTERRUPTED;
            this.zab((Status)object);
        }
        Preconditions.checkState(this.isReady(), "Result is not ready.");
        return this.get();
    }

    public final Result await(long l10, TimeUnit timeUnit) {
        block7: {
            Object object;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                object = "await must not be called on the UI thread when time is greater than zero.";
                Preconditions.checkNotMainThread((String)object);
            }
            object2 = this.zadv;
            int n10 = 1;
            object2 = object2 ^ n10;
            String string2 = "Result has already been consumed.";
            Preconditions.checkState((boolean)object2, string2);
            object = this.zadz;
            if (object != null) {
                n10 = 0;
            }
            object = "Cannot await if then() has been called.";
            Preconditions.checkState(n10 != 0, object);
            object = this.zadr;
            boolean bl2 = ((CountDownLatch)object).await(l10, timeUnit);
            if (bl2) break block7;
            Status status = Status.RESULT_TIMEOUT;
            try {
                this.zab(status);
            }
            catch (InterruptedException interruptedException) {
                status = Status.RESULT_INTERRUPTED;
                this.zab(status);
            }
        }
        Preconditions.checkState(this.isReady(), "Result is not ready.");
        return this.get();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cancel() {
        Object object = this.zado;
        synchronized (object) {
            Object object2;
            boolean bl2;
            block4: {
                block5: {
                    bl2 = this.zadw;
                    if (bl2 || (bl2 = this.zadv)) break block5;
                    object2 = this.zady;
                    if (object2 == null) break block4;
                    try {
                        object2.cancel();
                        break block4;
                    }
                    catch (RemoteException remoteException) {}
                }
                return;
            }
            object2 = this.zacj;
            BasePendingResult.zab((Result)object2);
            this.zadw = bl2 = true;
            object2 = Status.RESULT_CANCELED;
            object2 = this.createFailedResult((Status)object2);
            this.zaa((Result)object2);
            return;
        }
    }

    public abstract Result createFailedResult(Status var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isCanceled() {
        Object object = this.zado;
        synchronized (object) {
            return this.zadw;
        }
    }

    public final boolean isReady() {
        long l10;
        CountDownLatch countDownLatch = this.zadr;
        long l11 = countDownLatch.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object == false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void setCancelToken(ICancelToken iCancelToken) {
        Object object = this.zado;
        synchronized (object) {
            this.zady = iCancelToken;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void setResult(Result result2) {
        Object object = this.zado;
        synchronized (object) {
            boolean bl2 = this.zadx;
            if (!bl2 && !(bl2 = this.zadw)) {
                String string2;
                this.isReady();
                bl2 = this.isReady();
                boolean bl3 = true;
                if (!bl2) {
                    bl2 = bl3;
                } else {
                    bl2 = false;
                    string2 = null;
                }
                String string3 = "Results have already been set";
                Preconditions.checkState(bl2, string3);
                bl2 = this.zadv;
                if (bl2) {
                    bl3 = false;
                }
                string2 = "Result has already been consumed";
                Preconditions.checkState(bl3, string2);
                this.zaa(result2);
                return;
            }
            BasePendingResult.zab(result2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void setResultCallback(ResultCallback resultCallback) {
        Object object = this.zado;
        synchronized (object) {
            Result result2;
            Object object2;
            if (resultCallback == null) {
                resultCallback = null;
                this.zadt = null;
                return;
            }
            boolean bl2 = this.zadv;
            boolean bl3 = true;
            if (!bl2) {
                bl2 = bl3;
            } else {
                bl2 = false;
                object2 = null;
            }
            String string2 = "Result has already been consumed.";
            Preconditions.checkState(bl2, string2);
            object2 = this.zadz;
            if (object2 != null) {
                bl3 = false;
                result2 = null;
            }
            object2 = "Cannot set callbacks if then() has been called.";
            Preconditions.checkState(bl3, object2);
            bl2 = ((PendingResult)this).isCanceled();
            if (bl2) {
                return;
            }
            bl2 = this.isReady();
            if (bl2) {
                object2 = this.zadp;
                result2 = this.get();
                ((BasePendingResult$CallbackHandler)((Object)object2)).zaa(resultCallback, result2);
            } else {
                this.zadt = resultCallback;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void setResultCallback(ResultCallback object, long l10, TimeUnit timeUnit) {
        Object object2 = this.zado;
        synchronized (object2) {
            Object object3;
            if (object == null) {
                object = null;
                this.zadt = null;
                return;
            }
            boolean bl2 = this.zadv;
            boolean bl3 = true;
            if (!bl2) {
                bl2 = bl3;
            } else {
                bl2 = false;
                object3 = null;
            }
            String string2 = "Result has already been consumed.";
            Preconditions.checkState(bl2, string2);
            object3 = this.zadz;
            if (object3 != null) {
                bl3 = false;
            }
            object3 = "Cannot set callbacks if then() has been called.";
            Preconditions.checkState(bl3, object3);
            bl2 = ((PendingResult)this).isCanceled();
            if (bl2) {
                return;
            }
            bl2 = this.isReady();
            if (bl2) {
                BasePendingResult$CallbackHandler basePendingResult$CallbackHandler = this.zadp;
                Result result2 = this.get();
                basePendingResult$CallbackHandler.zaa((ResultCallback)object, result2);
            } else {
                this.zadt = object;
                object = this.zadp;
                l10 = timeUnit.toMillis(l10);
                int n10 = 2;
                timeUnit = object.obtainMessage(n10, this);
                object.sendMessageDelayed((Message)timeUnit, l10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TransformedResult then(ResultTransform object) {
        boolean bl2 = this.zadv;
        boolean bl3 = true;
        Object object2 = "Result has already been consumed.";
        Preconditions.checkState(bl2 ^= bl3, object2);
        Object object3 = this.zado;
        synchronized (object3) {
            boolean bl4;
            object2 = this.zadz;
            boolean bl5 = false;
            Result result2 = null;
            if (object2 == null) {
                bl4 = bl3;
            } else {
                bl4 = false;
                object2 = null;
            }
            String string2 = "Cannot call then() twice.";
            Preconditions.checkState(bl4, string2);
            object2 = this.zadt;
            if (object2 == null) {
                bl4 = bl3;
            } else {
                bl4 = false;
                object2 = null;
            }
            string2 = "Cannot call then() if callbacks are set.";
            Preconditions.checkState(bl4, string2);
            bl4 = this.zadw;
            if (!bl4) {
                bl5 = bl3;
            }
            object2 = "Cannot call then() if result was canceled.";
            Preconditions.checkState(bl5, object2);
            this.zaea = bl3;
            object2 = this.zadq;
            Object object4 = new zacm((WeakReference)object2);
            this.zadz = object4;
            object4 = this.zadz;
            object = ((TransformedResult)object4).then((ResultTransform)object);
            bl3 = this.isReady();
            if (bl3) {
                object4 = this.zadp;
                object2 = this.zadz;
                result2 = this.get();
                ((BasePendingResult$CallbackHandler)((Object)object4)).zaa((ResultCallback)object2, result2);
            } else {
                object4 = this.zadz;
                this.zadt = object4;
            }
            return object;
        }
    }

    public final void zaa(zacs zacs2) {
        this.zadu.set(zacs2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zab(Status result2) {
        Object object = this.zado;
        synchronized (object) {
            boolean bl2 = this.isReady();
            if (!bl2) {
                boolean bl3;
                result2 = this.createFailedResult((Status)result2);
                this.setResult(result2);
                this.zadx = bl3 = true;
            }
            return;
        }
    }

    public final Integer zam() {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean zat() {
        Object object = this.zado;
        synchronized (object) {
            Object object2 = this.zadq;
            object2 = ((Reference)object2).get();
            object2 = (GoogleApiClient)object2;
            if (object2 != null) {
                boolean bl2 = this.zaea;
                if (bl2) return ((PendingResult)this).isCanceled();
            }
            ((PendingResult)this).cancel();
            return ((PendingResult)this).isCanceled();
        }
    }

    public final void zau() {
        Boolean bl2;
        boolean bl3 = this.zaea;
        if (!bl3 && !(bl3 = (bl2 = (Boolean)zadn.get()).booleanValue())) {
            bl3 = false;
            bl2 = null;
        } else {
            bl3 = true;
        }
        this.zaea = bl3;
    }
}

