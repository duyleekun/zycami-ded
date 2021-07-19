/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.RxMob$SubscriberWarpper;

public class RxMob$Subscriber {
    private RxMob$SubscriberWarpper warpper;

    public static /* synthetic */ void access$200(RxMob$Subscriber rxMob$Subscriber, RxMob$SubscriberWarpper rxMob$SubscriberWarpper) {
        rxMob$Subscriber.setWarpper(rxMob$SubscriberWarpper);
    }

    private void setWarpper(RxMob$SubscriberWarpper rxMob$SubscriberWarpper) {
        this.warpper = rxMob$SubscriberWarpper;
    }

    public void onCompleted() {
    }

    public void onError(Throwable throwable) {
    }

    public void onNext(Object object) {
    }

    public void onStart() {
    }

    public final void unsubscribe() {
        RxMob$SubscriberWarpper rxMob$SubscriberWarpper = this.warpper;
        if (rxMob$SubscriberWarpper != null) {
            rxMob$SubscriberWarpper.removeSubscriber();
            rxMob$SubscriberWarpper = null;
            this.warpper = null;
        }
    }
}

