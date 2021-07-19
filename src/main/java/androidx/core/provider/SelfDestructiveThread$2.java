/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.core.provider;

import android.os.Handler;
import androidx.core.provider.SelfDestructiveThread;
import androidx.core.provider.SelfDestructiveThread$2$1;
import androidx.core.provider.SelfDestructiveThread$ReplyCallback;
import java.util.concurrent.Callable;

public class SelfDestructiveThread$2
implements Runnable {
    public final /* synthetic */ SelfDestructiveThread this$0;
    public final /* synthetic */ Callable val$callable;
    public final /* synthetic */ Handler val$calleeHandler;
    public final /* synthetic */ SelfDestructiveThread$ReplyCallback val$reply;

    public SelfDestructiveThread$2(SelfDestructiveThread selfDestructiveThread, Callable callable, Handler handler, SelfDestructiveThread$ReplyCallback selfDestructiveThread$ReplyCallback) {
        this.this$0 = selfDestructiveThread;
        this.val$callable = callable;
        this.val$calleeHandler = handler;
        this.val$reply = selfDestructiveThread$ReplyCallback;
    }

    public void run() {
        Callable callable = this.val$callable;
        try {
            callable = callable.call();
        }
        catch (Exception exception) {
            callable = null;
        }
        Handler handler = this.val$calleeHandler;
        SelfDestructiveThread$2$1 selfDestructiveThread$2$1 = new SelfDestructiveThread$2$1(this, callable);
        handler.post((Runnable)selfDestructiveThread$2$1);
    }
}

