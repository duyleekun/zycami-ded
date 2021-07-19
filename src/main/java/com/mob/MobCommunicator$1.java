/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.MobCommunicator;
import com.mob.commons.b;
import com.mob.tools.RxMob$QuickSubscribe;
import com.mob.tools.RxMob$Subscriber;
import java.util.HashMap;

public class MobCommunicator$1
extends RxMob$QuickSubscribe {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ HashMap c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ MobCommunicator f;

    public MobCommunicator$1(MobCommunicator mobCommunicator, boolean bl2, HashMap hashMap, HashMap hashMap2, String string2, boolean bl3) {
        this.f = mobCommunicator;
        this.a = bl2;
        this.b = hashMap;
        this.c = hashMap2;
        this.d = string2;
        this.e = bl3;
    }

    public void doNext(RxMob$Subscriber rxMob$Subscriber) {
        Object object;
        boolean bl2 = com.mob.commons.b.aa();
        if (!bl2) {
            MobCommunicator mobCommunicator = this.f;
            boolean bl3 = this.a;
            HashMap hashMap = this.b;
            HashMap hashMap2 = this.c;
            String string2 = this.d;
            boolean bl4 = this.e;
            object = mobCommunicator.requestSynchronized(bl3, hashMap, hashMap2, string2, bl4);
        } else {
            bl2 = false;
            object = null;
        }
        rxMob$Subscriber.onNext(object);
    }
}

