/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package d.j.d.a.o;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class a$a
implements Executor {
    private a$a() {
    }

    public /* synthetic */ a$a(byte by2) {
        this();
    }

    public final void execute(Runnable runnable) {
        Looper looper = Looper.getMainLooper();
        Handler handler = new Handler(looper);
        handler.post(runnable);
    }
}

