/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.MobCommunicator;
import com.mob.MobCommunicator$Callback;
import com.mob.tools.RxMob$Subscriber;

public class MobCommunicator$2
extends RxMob$Subscriber {
    public final /* synthetic */ MobCommunicator$Callback a;
    public final /* synthetic */ MobCommunicator b;

    public MobCommunicator$2(MobCommunicator mobCommunicator, MobCommunicator$Callback callback) {
        this.b = mobCommunicator;
        this.a = callback;
    }

    public void onError(Throwable throwable) {
        this.a.onResultError(throwable);
    }

    public void onNext(Object object) {
        this.a.onResultOk(object);
    }
}

