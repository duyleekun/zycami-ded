/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscribable;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$SubscriberWarpper;

public class RxMob$Subscribable$2
extends Thread {
    public final /* synthetic */ RxMob$Subscribable this$0;
    public final /* synthetic */ RxMob$Subscriber val$subscriber;

    public RxMob$Subscribable$2(RxMob$Subscribable rxMob$Subscribable, RxMob$Subscriber rxMob$Subscriber) {
        this.this$0 = rxMob$Subscribable;
        this.val$subscriber = rxMob$Subscriber;
    }

    public void run() {
        RxMob$OnSubscribe rxMob$OnSubscribe = RxMob$Subscribable.access$100(this.this$0);
        RxMob$Subscribable rxMob$Subscribable = this.this$0;
        RxMob$Subscriber rxMob$Subscriber = this.val$subscriber;
        RxMob$SubscriberWarpper rxMob$SubscriberWarpper = new RxMob$SubscriberWarpper(rxMob$Subscribable, rxMob$Subscriber);
        rxMob$OnSubscribe.call(rxMob$SubscriberWarpper);
    }
}

