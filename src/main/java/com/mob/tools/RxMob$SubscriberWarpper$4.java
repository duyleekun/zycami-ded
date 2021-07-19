/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.MobLog;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$SubscriberWarpper;
import com.mob.tools.log.NLog;

public class RxMob$SubscriberWarpper$4
extends Thread {
    public final /* synthetic */ RxMob$SubscriberWarpper this$0;
    public final /* synthetic */ Object val$data;

    public RxMob$SubscriberWarpper$4(RxMob$SubscriberWarpper rxMob$SubscriberWarpper, Object object) {
        this.this$0 = rxMob$SubscriberWarpper;
        this.val$data = object;
    }

    public void run() {
        Object object = RxMob$SubscriberWarpper.access$400(this.this$0);
        if (object != null) {
            object = RxMob$SubscriberWarpper.access$400(this.this$0);
            Object object2 = this.val$data;
            ((RxMob$Subscriber)object).onNext(object2);
        } else {
            object = MobLog.getInstance();
            String string2 = "[NewThread/onNext] Network request interrupted as Subscriber is null";
            Throwable throwable = new Throwable(string2);
            ((NLog)object).crash(throwable);
        }
    }
}

