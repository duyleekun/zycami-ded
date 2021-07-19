/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package k;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class o$a$a
implements Executor {
    private final Handler a;

    public o$a$a() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.a = handler = new Handler(looper);
    }

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}

