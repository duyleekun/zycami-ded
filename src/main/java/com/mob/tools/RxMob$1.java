/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.RxMob$QuickSubscribe;
import com.mob.tools.RxMob$Subscriber;

public final class RxMob$1
extends RxMob$QuickSubscribe {
    public final /* synthetic */ Object[] val$datas;

    public RxMob$1(Object[] objectArray) {
        this.val$datas = objectArray;
    }

    public void doNext(RxMob$Subscriber rxMob$Subscriber) {
        for (Object object : this.val$datas) {
            rxMob$Subscriber.onNext(object);
        }
    }
}

