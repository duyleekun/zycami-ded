/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.push;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.push.PushService;
import cn.leancloud.push.PushService$1;

public class PushService$1$1
extends AVCallback {
    public final /* synthetic */ PushService$1 this$1;

    public PushService$1$1(PushService$1 pushService$1) {
        this.this$1 = pushService$1;
    }

    public void internalDone0(Object object, AVException object2) {
        if (object2 != null) {
            object = PushService.access$000();
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "failed to start websocket connection, cause: ";
            stringBuilder.append(string2);
            object2 = ((Throwable)object2).getMessage();
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            ((AVLogger)object).w((String)object2);
        } else {
            object = PushService.access$000();
            object2 = "succeed to start websocket connection.";
            ((AVLogger)object).d((String)object2);
        }
    }
}

