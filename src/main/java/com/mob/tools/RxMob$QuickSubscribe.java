/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscriber;

public abstract class RxMob$QuickSubscribe
implements RxMob$OnSubscribe {
    public final void call(RxMob$Subscriber rxMob$Subscriber) {
        rxMob$Subscriber.onStart();
        try {
            this.doNext(rxMob$Subscriber);
            rxMob$Subscriber.onCompleted();
        }
        catch (Throwable throwable) {
            rxMob$Subscriber.onError(throwable);
        }
    }

    public abstract void doNext(RxMob$Subscriber var1);
}

