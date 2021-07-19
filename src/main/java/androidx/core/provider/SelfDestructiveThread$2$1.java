/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import androidx.core.provider.SelfDestructiveThread$2;
import androidx.core.provider.SelfDestructiveThread$ReplyCallback;

public class SelfDestructiveThread$2$1
implements Runnable {
    public final /* synthetic */ SelfDestructiveThread$2 this$1;
    public final /* synthetic */ Object val$result;

    public SelfDestructiveThread$2$1(SelfDestructiveThread$2 var1_1, Object object) {
        this.this$1 = var1_1;
        this.val$result = object;
    }

    public void run() {
        SelfDestructiveThread$ReplyCallback selfDestructiveThread$ReplyCallback = this.this$1.val$reply;
        Object object = this.val$result;
        selfDestructiveThread$ReplyCallback.onReply(object);
    }
}

