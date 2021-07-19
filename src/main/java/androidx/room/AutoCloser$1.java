/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.AutoCloser;
import java.util.concurrent.Executor;

public class AutoCloser$1
implements Runnable {
    public final /* synthetic */ AutoCloser this$0;

    public AutoCloser$1(AutoCloser autoCloser) {
        this.this$0 = autoCloser;
    }

    public void run() {
        Object object = this.this$0;
        Executor executor = ((AutoCloser)object).mExecutor;
        object = ((AutoCloser)object).mAutoCloser;
        executor.execute((Runnable)object);
    }
}

