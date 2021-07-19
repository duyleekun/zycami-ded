/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package d.r.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d.r.a.q;

public final class q$a
extends Handler {
    public final /* synthetic */ q a;

    public q$a(q q10, Looper looper) {
        this.a = q10;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.a.c(message);
    }
}

