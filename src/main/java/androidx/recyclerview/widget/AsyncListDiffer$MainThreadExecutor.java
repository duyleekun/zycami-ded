/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class AsyncListDiffer$MainThreadExecutor
implements Executor {
    public final Handler mHandler;

    public AsyncListDiffer$MainThreadExecutor() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.mHandler = handler = new Handler(looper);
    }

    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }
}

