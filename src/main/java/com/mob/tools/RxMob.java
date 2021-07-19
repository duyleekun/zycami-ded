/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.RxMob$1;
import com.mob.tools.RxMob$2;
import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscribable;
import java.util.Iterator;

public class RxMob {
    public static RxMob$Subscribable create(RxMob$OnSubscribe rxMob$OnSubscribe) {
        RxMob$Subscribable rxMob$Subscribable = new RxMob$Subscribable(null);
        RxMob$Subscribable.access$102(rxMob$Subscribable, rxMob$OnSubscribe);
        return rxMob$Subscribable;
    }

    public static RxMob$Subscribable from(Iterator iterator2) {
        RxMob$2 rxMob$2 = new RxMob$2(iterator2);
        return RxMob.create(rxMob$2);
    }

    public static RxMob$Subscribable just(Object ... objectArray) {
        RxMob$1 rxMob$1 = new RxMob$1(objectArray);
        return RxMob.create(rxMob$1);
    }
}

