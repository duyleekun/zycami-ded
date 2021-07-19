/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package androidx.room;

import android.os.SystemClock;
import androidx.room.AutoCloser;
import androidx.room.util.SneakyThrow;
import java.io.IOException;

public class AutoCloser$2
implements Runnable {
    public final /* synthetic */ AutoCloser this$0;

    public AutoCloser$2(AutoCloser autoCloser) {
        this.this$0 = autoCloser;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            long l10 = SystemClock.uptimeMillis();
            AutoCloser autoCloser = this.this$0;
            long l11 = autoCloser.mLastDecrementRefCountTimeStamp;
            l10 -= l11;
            l11 = autoCloser.mAutoCloseTimeoutInMs;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 < 0) {
                return;
            }
            l12 = autoCloser.mRefCount;
            if (l12 != false) {
                return;
            }
            Object object2 = autoCloser.mOnAutoCloseCallback;
            if (object2 == null) {
                String string2 = "mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568";
                object2 = new IllegalStateException(string2);
                throw object2;
            }
            object2.run();
            object2 = this.this$0;
            object2 = ((AutoCloser)object2).mDelegateDatabase;
            if (object2 != null && (l12 = (long)object2.isOpen()) != false) {
                try {
                    object2 = this.this$0;
                    object2 = ((AutoCloser)object2).mDelegateDatabase;
                    object2.close();
                }
                catch (IOException iOException) {
                    SneakyThrow.reThrow(iOException);
                }
                object2 = this.this$0;
                Object var9_8 = null;
                ((AutoCloser)object2).mDelegateDatabase = null;
            }
            return;
        }
    }
}

