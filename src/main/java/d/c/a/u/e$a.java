/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package d.c.a.u;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class e$a
implements Executor {
    private final Handler a;

    public e$a() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.a = handler = new Handler(looper);
    }

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}

