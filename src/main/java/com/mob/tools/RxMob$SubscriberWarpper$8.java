/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.MobLog;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$SubscriberWarpper;
import com.mob.tools.log.NLog;

public class RxMob$SubscriberWarpper$8
extends Thread {
    public final /* synthetic */ RxMob$SubscriberWarpper this$0;
    public final /* synthetic */ Throwable val$t;

    public RxMob$SubscriberWarpper$8(RxMob$SubscriberWarpper rxMob$SubscriberWarpper, Throwable throwable) {
        this.this$0 = rxMob$SubscriberWarpper;
        this.val$t = throwable;
    }

    public void run() {
        Object object = RxMob$SubscriberWarpper.access$400(this.this$0);
        if (object != null) {
            object = RxMob$SubscriberWarpper.access$400(this.this$0);
            Throwable throwable = this.val$t;
            ((RxMob$Subscriber)object).onError(throwable);
            object = this.this$0;
            ((RxMob$SubscriberWarpper)object).removeSubscriber();
        } else {
            object = MobLog.getInstance();
            String string2 = "[NewThread/onError] Network request interrupted as Subscriber is null";
            Throwable throwable = new Throwable(string2);
            ((NLog)object).crash(throwable);
        }
    }
}

