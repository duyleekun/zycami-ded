/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package d.v.e.l;

import android.os.Handler;
import android.os.Looper;
import d.v.e.l.c1$a;
import java.util.concurrent.Executor;

public class c1$b
implements Executor {
    private Handler a;

    private c1$b() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.a = handler = new Handler(looper);
    }

    public /* synthetic */ c1$b(c1$a c1$a) {
        this();
    }

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}

