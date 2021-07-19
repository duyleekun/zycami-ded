/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 */
package com.mob.tools;

import android.os.Handler;
import com.mob.tools.RxMob$1;
import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscribable$1;
import com.mob.tools.RxMob$Subscribable$2;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$SubscriberWarpper;
import com.mob.tools.RxMob$Thread;
import com.mob.tools.utils.UIHandler;

public final class RxMob$Subscribable {
    private RxMob$Thread observeThread;
    private RxMob$OnSubscribe onSubscribe;
    private RxMob$Thread subscribeThread;

    private RxMob$Subscribable() {
    }

    public /* synthetic */ RxMob$Subscribable(RxMob.1 var1_1) {
        this();
    }

    public static /* synthetic */ RxMob$OnSubscribe access$100(RxMob$Subscribable rxMob$Subscribable) {
        return rxMob$Subscribable.onSubscribe;
    }

    public static /* synthetic */ RxMob$OnSubscribe access$102(RxMob$Subscribable rxMob$Subscribable, RxMob$OnSubscribe rxMob$OnSubscribe) {
        rxMob$Subscribable.onSubscribe = rxMob$OnSubscribe;
        return rxMob$OnSubscribe;
    }

    public static /* synthetic */ RxMob$Thread access$300(RxMob$Subscribable rxMob$Subscribable) {
        return rxMob$Subscribable.observeThread;
    }

    public RxMob$Subscribable observeOn(RxMob$Thread rxMob$Thread) {
        this.observeThread = rxMob$Thread;
        return this;
    }

    public void subscribe(RxMob$Subscriber rxMob$Subscriber) {
        Object object = this.onSubscribe;
        if (object != null) {
            Object object2 = this.subscribeThread;
            RxMob$Thread rxMob$Thread = RxMob$Thread.UI_THREAD;
            if (object2 == rxMob$Thread) {
                object = null;
                object2 = new RxMob$Subscribable$1(this, rxMob$Subscriber);
                UIHandler.sendEmptyMessage(0, (Handler.Callback)object2);
            } else {
                rxMob$Thread = RxMob$Thread.NEW_THREAD;
                if (object2 == rxMob$Thread) {
                    object = new RxMob$Subscribable$2(this, rxMob$Subscriber);
                    ((Thread)object).start();
                } else {
                    object2 = new RxMob$SubscriberWarpper(this, rxMob$Subscriber);
                    object.call((RxMob$Subscriber)object2);
                }
            }
        }
    }

    public RxMob$Subscribable subscribeOn(RxMob$Thread rxMob$Thread) {
        this.subscribeThread = rxMob$Thread;
        return this;
    }

    public void subscribeOnNewThreadAndObserveOnUIThread(RxMob$Subscriber rxMob$Subscriber) {
        RxMob$Thread rxMob$Thread = RxMob$Thread.NEW_THREAD;
        this.subscribeOn(rxMob$Thread);
        rxMob$Thread = RxMob$Thread.UI_THREAD;
        this.observeOn(rxMob$Thread);
        this.subscribe(rxMob$Subscriber);
    }
}

