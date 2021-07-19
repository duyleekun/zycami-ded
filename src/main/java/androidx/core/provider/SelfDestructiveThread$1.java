/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package androidx.core.provider;

import android.os.Handler;
import android.os.Message;
import androidx.core.provider.SelfDestructiveThread;

public class SelfDestructiveThread$1
implements Handler.Callback {
    public final /* synthetic */ SelfDestructiveThread this$0;

    public SelfDestructiveThread$1(SelfDestructiveThread selfDestructiveThread) {
        this.this$0 = selfDestructiveThread;
    }

    public boolean handleMessage(Message object) {
        boolean bl2 = ((Message)object).what;
        boolean bl3 = true;
        if (bl2) {
            if (bl2 != bl3) {
                return bl3;
            }
            SelfDestructiveThread selfDestructiveThread = this.this$0;
            object = (Runnable)((Message)object).obj;
            selfDestructiveThread.onInvokeRunnable((Runnable)object);
            return bl3;
        }
        this.this$0.onDestruction();
        return bl3;
    }
}

