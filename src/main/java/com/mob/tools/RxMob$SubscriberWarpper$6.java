/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.MobLog;
import com.mob.tools.RxMob$SubscriberWarpper;
import com.mob.tools.log.NLog;

public class RxMob$SubscriberWarpper$6
extends Thread {
    public final /* synthetic */ RxMob$SubscriberWarpper this$0;

    public RxMob$SubscriberWarpper$6(RxMob$SubscriberWarpper rxMob$SubscriberWarpper) {
        this.this$0 = rxMob$SubscriberWarpper;
    }

    public void run() {
        Object object = RxMob$SubscriberWarpper.access$400(this.this$0);
        if (object != null) {
            RxMob$SubscriberWarpper.access$400(this.this$0).onCompleted();
            object = this.this$0;
            ((RxMob$SubscriberWarpper)object).removeSubscriber();
        } else {
            object = MobLog.getInstance();
            String string2 = "[NewThread/onComplete] Network request interrupted as Subscriber is null";
            Throwable throwable = new Throwable(string2);
            ((NLog)object).crash(throwable);
        }
    }
}

