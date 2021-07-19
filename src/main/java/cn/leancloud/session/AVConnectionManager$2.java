/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.session.AVConnectionManager;

public class AVConnectionManager$2
implements Runnable {
    public final /* synthetic */ AVConnectionManager this$0;

    public AVConnectionManager$2(AVConnectionManager aVConnectionManager) {
        this.this$0 = aVConnectionManager;
    }

    public void run() {
        long l10 = 0x4000000000000000L;
        double d10 = 2.0;
        Object object = this.this$0;
        int n10 = AVConnectionManager.access$000((AVConnectionManager)object);
        double d11 = n10;
        d10 = Math.pow(d10, d11);
        l10 = (long)d10;
        long l11 = 1000L;
        d11 = 4.94E-321;
        l10 *= l11;
        Thread.sleep(l10);
        Object object2 = AVConnectionManager.access$100();
        Object object3 = new StringBuilder();
        object = "reConnect rtm server. count=";
        ((StringBuilder)object3).append((String)object);
        object = this.this$0;
        n10 = AVConnectionManager.access$000((AVConnectionManager)object);
        ((StringBuilder)object3).append(n10);
        object3 = ((StringBuilder)object3).toString();
        ((AVLogger)object2).d((String)object3);
        object2 = this.this$0;
        try {
            AVConnectionManager.access$200((AVConnectionManager)object2);
        }
        catch (InterruptedException interruptedException) {
            object3 = AVConnectionManager.access$100();
            object = "failed to start connection.";
            ((AVLogger)object3).w((String)object, interruptedException);
        }
    }
}

