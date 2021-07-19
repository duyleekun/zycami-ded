/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.camera.core.impl;

import android.util.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import b.a.b.w1.f;
import b.a.b.w1.g;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class DeferrableSurface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DeferrableSurface";
    private static final AtomicInteger TOTAL_COUNT;
    private static final AtomicInteger USED_COUNT;
    private boolean mClosed;
    private final Object mLock;
    private CallbackToFutureAdapter$Completer mTerminationCompleter;
    private final ListenableFuture mTerminationFuture;
    private int mUseCount;

    static {
        AtomicInteger atomicInteger;
        DEBUG = Logger.isDebugEnabled(TAG);
        USED_COUNT = atomicInteger = new AtomicInteger(0);
        TOTAL_COUNT = atomicInteger = new AtomicInteger(0);
    }

    public DeferrableSurface() {
        Object object;
        this.mLock = object = new Object();
        this.mUseCount = 0;
        this.mClosed = false;
        object = new g(this);
        this.mTerminationFuture = object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
        Object object2 = TAG;
        int n10 = Logger.isDebugEnabled((String)object2);
        if (n10 != 0) {
            n10 = TOTAL_COUNT.incrementAndGet();
            int n11 = USED_COUNT.get();
            String string2 = "Surface created";
            this.printGlobalDebugCounts(string2, n10, n11);
            object2 = new Exception();
            object2 = Log.getStackTraceString((Throwable)object2);
            f f10 = new f(this, (String)object2);
            object2 = CameraXExecutors.directExecutor();
            object.addListener(f10, (Executor)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ Object a(CallbackToFutureAdapter$Completer object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            this.mTerminationCompleter = object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("DeferrableSurface-termination(");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(")");
        return ((StringBuilder)object).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void c(String object) {
        try {
            Object object2 = this.mTerminationFuture;
            object2.get();
            object2 = "Surface terminated";
            AtomicInteger atomicInteger = TOTAL_COUNT;
            int n10 = atomicInteger.decrementAndGet();
            AtomicInteger atomicInteger2 = USED_COUNT;
            int n11 = atomicInteger2.get();
            this.printGlobalDebugCounts((String)object2, n10, n11);
            return;
        }
        catch (Exception exception) {
            Object object3 = TAG;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Unexpected surface termination for ");
            charSequence.append(this);
            Object[] objectArray = "\nStack Trace:\n";
            charSequence.append((String)objectArray);
            charSequence.append((String)object);
            object = charSequence.toString();
            Logger.e((String)object3, (String)object);
            object = this.mLock;
            synchronized (object) {
                charSequence = "DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.";
                int n12 = 3;
                objectArray = new Object[n12];
                int n13 = 0;
                objectArray[0] = this;
                n13 = 1;
                int n14 = this.mClosed;
                Comparable<Boolean> comparable = n14 != 0;
                objectArray[n13] = comparable;
                n13 = 2;
                n14 = this.mUseCount;
                comparable = n14;
                objectArray[n13] = comparable;
                charSequence = String.format((String)charSequence, objectArray);
                object3 = new IllegalArgumentException((String)charSequence, exception);
                throw object3;
            }
        }
    }

    private void printGlobalDebugCounts(String string2, int n10, int n11) {
        CharSequence charSequence;
        boolean bl2 = DEBUG;
        String string3 = TAG;
        if (!bl2 && (bl2 = Logger.isDebugEnabled(string3))) {
            charSequence = "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.";
            Logger.d(string3, (String)charSequence);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("[total_surfaces=");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(", used_surfaces=");
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append("](");
        ((StringBuilder)charSequence).append(this);
        ((StringBuilder)charSequence).append("}");
        string2 = ((StringBuilder)charSequence).toString();
        Logger.d(string3, string2);
    }

    public /* synthetic */ Object b(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a(callbackToFutureAdapter$Completer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void close() {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer;
        Object object = this.mLock;
        synchronized (object) {
            int n10 = this.mClosed;
            if (n10 != 0) return;
            this.mClosed = n10 = 1;
            n10 = this.mUseCount;
            if (n10 == 0) {
                callbackToFutureAdapter$Completer = this.mTerminationCompleter;
                this.mTerminationCompleter = null;
            } else {
                n10 = 0;
                callbackToFutureAdapter$Completer = null;
            }
            String string2 = TAG;
            boolean bl2 = Logger.isDebugEnabled(string2);
            if (bl2) {
                string2 = TAG;
                CharSequence charSequence = new StringBuilder();
                String string3 = "surface closed,  useCount=";
                charSequence.append(string3);
                int n11 = this.mUseCount;
                charSequence.append(n11);
                string3 = " closed=true ";
                charSequence.append(string3);
                charSequence.append(this);
                charSequence = charSequence.toString();
                Logger.d(string2, (String)charSequence);
            }
        }
        if (callbackToFutureAdapter$Completer == null) return;
        callbackToFutureAdapter$Completer.set(null);
    }

    public /* synthetic */ void d(String string2) {
        this.c(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void decrementUseCount() {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer;
        Object object = this.mLock;
        // MONITORENTER : object
        int n10 = this.mUseCount;
        if (n10 == 0) {
            String string2 = "Decrementing use count occurs more times than incrementing";
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        this.mUseCount = n10 += -1;
        Object var3_3 = null;
        if (n10 == 0 && (n10 = (int)(this.mClosed ? 1 : 0)) != 0) {
            callbackToFutureAdapter$Completer = this.mTerminationCompleter;
            this.mTerminationCompleter = null;
        } else {
            n10 = 0;
            callbackToFutureAdapter$Completer = null;
        }
        String string3 = TAG;
        int n11 = Logger.isDebugEnabled(string3);
        if (n11 != 0) {
            string3 = TAG;
            Object object2 = new StringBuilder();
            Object object3 = "use count-1,  useCount=";
            ((StringBuilder)object2).append((String)object3);
            int n12 = this.mUseCount;
            ((StringBuilder)object2).append(n12);
            object3 = " closed=";
            ((StringBuilder)object2).append((String)object3);
            n12 = this.mClosed ? 1 : 0;
            ((StringBuilder)object2).append(n12 != 0);
            object3 = " ";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(this);
            object2 = ((StringBuilder)object2).toString();
            Logger.d(string3, (String)object2);
            n11 = this.mUseCount;
            if (n11 == 0) {
                string3 = "Surface no longer in use";
                object2 = TOTAL_COUNT;
                int n13 = ((AtomicInteger)object2).get();
                object3 = USED_COUNT;
                n12 = ((AtomicInteger)object3).decrementAndGet();
                this.printGlobalDebugCounts(string3, n13, n12);
            }
        }
        // MONITOREXIT : object
        if (callbackToFutureAdapter$Completer == null) return;
        callbackToFutureAdapter$Completer.set(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ListenableFuture getSurface() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mClosed;
            if (!bl2) return this.provideSurface();
            String string2 = "DeferrableSurface already closed.";
            Object object2 = new DeferrableSurface$SurfaceClosedException(string2, this);
            return Futures.immediateFailedFuture((Throwable)object2);
        }
    }

    public ListenableFuture getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getUseCount() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mUseCount;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void incrementUseCount() {
        Object object = this.mLock;
        synchronized (object) {
            int n10;
            int n11 = this.mUseCount;
            if (n11 == 0 && (n10 = this.mClosed) != 0) {
                String string2 = "Cannot begin use on a closed surface.";
                DeferrableSurface$SurfaceClosedException deferrableSurface$SurfaceClosedException = new DeferrableSurface$SurfaceClosedException(string2, this);
                throw deferrableSurface$SurfaceClosedException;
            }
            n10 = 1;
            this.mUseCount = n11 += n10;
            String string3 = TAG;
            n11 = Logger.isDebugEnabled(string3) ? 1 : 0;
            if (n11 != 0) {
                int n12;
                Object object2;
                Object object3;
                n11 = this.mUseCount;
                if (n11 == n10) {
                    string3 = "New surface in use";
                    object3 = TOTAL_COUNT;
                    n10 = ((AtomicInteger)object3).get();
                    object2 = USED_COUNT;
                    n12 = ((AtomicInteger)object2).incrementAndGet();
                    this.printGlobalDebugCounts(string3, n10, n12);
                }
                string3 = TAG;
                object3 = new StringBuilder();
                object2 = "use count+1, useCount=";
                ((StringBuilder)object3).append((String)object2);
                n12 = this.mUseCount;
                ((StringBuilder)object3).append(n12);
                object2 = " ";
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(this);
                object3 = ((StringBuilder)object3).toString();
                Logger.d(string3, (String)object3);
            }
            return;
        }
    }

    public abstract ListenableFuture provideSurface();
}

