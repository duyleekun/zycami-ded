/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.push;

import cn.leancloud.AVLogger;
import cn.leancloud.push.PushService;
import cn.leancloud.push.PushService$2;
import cn.leancloud.session.AVConnectionManager;
import java.util.TimerTask;

public class PushService$2$1
extends TimerTask {
    public final /* synthetic */ PushService$2 this$1;

    public PushService$2$1(PushService$2 var1_1) {
        this.this$1 = var1_1;
    }

    public void run() {
        Object object = this.this$1;
        boolean bl2 = PushService$2.access$200((PushService$2)object);
        if (!bl2) {
            object = PushService.access$000();
            String string2 = "reset Connection now.";
            ((AVLogger)object).d(string2);
            object = PushService.access$100(this.this$1.this$0);
            ((AVConnectionManager)object).resetConnection();
        } else {
            object = PushService.access$000();
            String string3 = "Connection has been resumed";
            ((AVLogger)object).d(string3);
        }
    }
}

