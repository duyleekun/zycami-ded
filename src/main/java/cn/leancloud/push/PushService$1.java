/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.push;

import cn.leancloud.push.PushService;
import cn.leancloud.push.PushService$1$1;
import cn.leancloud.session.AVConnectionManager;

public class PushService$1
implements Runnable {
    public final /* synthetic */ PushService this$0;

    public PushService$1(PushService pushService) {
        this.this$0 = pushService;
    }

    public void run() {
        AVConnectionManager aVConnectionManager = PushService.access$100(this.this$0);
        PushService$1$1 pushService$1$1 = new PushService$1$1(this);
        aVConnectionManager.startConnection(pushService$1$1);
    }
}

