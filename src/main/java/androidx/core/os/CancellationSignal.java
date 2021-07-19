/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 */
package androidx.core.os;

import android.os.Build;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.core.os.OperationCanceledException;

public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private CancellationSignal$OnCancelListener mOnCancelListener;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void waitForCancelFinishedLocked() {
        boolean bl2;
        while (bl2 = this.mCancelInProgress) {
            try {
                this.wait();
            }
            catch (InterruptedException interruptedException) {
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void cancel() {
        block14: {
            Throwable throwable2;
            block13: {
                int n10;
                // MONITORENTER : this
                int n11 = this.mIsCanceled;
                if (n11 != 0) {
                    // MONITOREXIT : this
                    return;
                }
                this.mIsCanceled = n11 = 1;
                this.mCancelInProgress = n11;
                CancellationSignal$OnCancelListener cancellationSignal$OnCancelListener = this.mOnCancelListener;
                Object object = this.mCancellationSignalObj;
                // MONITOREXIT : this
                if (cancellationSignal$OnCancelListener != null) {
                    try {
                        cancellationSignal$OnCancelListener.onCancel();
                    }
                    catch (Throwable throwable2) {
                        break block13;
                    }
                }
                if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 16)) {
                    object = (android.os.CancellationSignal)object;
                    object.cancel();
                }
                break block14;
            }
            // MONITORENTER : this
            this.mCancelInProgress = false;
            this.notifyAll();
            // MONITOREXIT : this
            throw throwable2;
        }
        // MONITORENTER : this
        this.mCancelInProgress = false;
        this.notifyAll();
        // MONITOREXIT : this
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getCancellationSignalObject() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 < n11) {
            return null;
        }
        synchronized (this) {
            Object object = this.mCancellationSignalObj;
            if (object != null) return this.mCancellationSignalObj;
            this.mCancellationSignalObj = object = new android.os.CancellationSignal();
            n11 = (int)(this.mIsCanceled ? 1 : 0);
            if (n11 == 0) return this.mCancellationSignalObj;
            object = (android.os.CancellationSignal)object;
            object.cancel();
            return this.mCancellationSignalObj;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isCanceled() {
        synchronized (this) {
            return this.mIsCanceled;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setOnCancelListener(CancellationSignal$OnCancelListener cancellationSignal$OnCancelListener) {
        synchronized (this) {
            this.waitForCancelFinishedLocked();
            CancellationSignal$OnCancelListener cancellationSignal$OnCancelListener2 = this.mOnCancelListener;
            if (cancellationSignal$OnCancelListener2 == cancellationSignal$OnCancelListener) {
                return;
            }
            this.mOnCancelListener = cancellationSignal$OnCancelListener;
            boolean bl2 = this.mIsCanceled;
            if (bl2 && cancellationSignal$OnCancelListener != null) {
                // MONITOREXIT @DISABLED, blocks:[3, 4] lbl10 : MonitorExitStatement: MONITOREXIT : this
                cancellationSignal$OnCancelListener.onCancel();
                return;
            }
            return;
        }
    }

    public void throwIfCanceled() {
        boolean bl2 = this.isCanceled();
        if (!bl2) {
            return;
        }
        OperationCanceledException operationCanceledException = new OperationCanceledException();
        throw operationCanceledException;
    }
}

