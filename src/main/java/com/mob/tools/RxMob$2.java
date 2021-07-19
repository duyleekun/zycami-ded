/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.RxMob$QuickSubscribe;
import com.mob.tools.RxMob$Subscriber;
import java.util.Iterator;

public final class RxMob$2
extends RxMob$QuickSubscribe {
    public final /* synthetic */ Iterator val$datas;

    public RxMob$2(Iterator iterator2) {
        this.val$datas = iterator2;
    }

    public void doNext(RxMob$Subscriber rxMob$Subscriber) {
        Iterator iterator2;
        boolean bl2;
        while (bl2 = (iterator2 = this.val$datas).hasNext()) {
            iterator2 = this.val$datas.next();
            rxMob$Subscriber.onNext(iterator2);
        }
    }
}

