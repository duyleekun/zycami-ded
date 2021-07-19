/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package d.h.a.a.f0;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class j
implements Executor {
    public final /* synthetic */ Handler a;

    public /* synthetic */ j(Handler handler) {
        this.a = handler;
    }

    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}

