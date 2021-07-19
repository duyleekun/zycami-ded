/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.service.RTMConnectionServerResponse;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVConnectionManager$3;
import e.a.g0;
import e.a.s0.b;

public class AVConnectionManager$3$1
implements g0 {
    public final /* synthetic */ AVConnectionManager$3 this$1;

    public AVConnectionManager$3$1(AVConnectionManager$3 var1_1) {
        this.this$1 = var1_1;
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        AVLogger aVLogger = AVConnectionManager.access$100();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to query RTM Connection Server. cause: ");
        object = ((Throwable)object).getMessage();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        aVLogger.e((String)object);
        AVConnectionManager.access$300(this.this$1.this$0);
    }

    public void onNext(RTMConnectionServerResponse object) {
        object = AVConnectionManager.access$400(this.this$1.this$0, (RTMConnectionServerResponse)object);
        AVConnectionManager.access$500(this.this$1.this$0, (String)object);
    }

    public void onSubscribe(b b10) {
    }
}

