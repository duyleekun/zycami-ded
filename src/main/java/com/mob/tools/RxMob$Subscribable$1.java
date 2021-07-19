/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.RxMob$Subscribable;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$SubscriberWarpper;

public class RxMob$Subscribable$1
implements Handler.Callback {
    public final /* synthetic */ RxMob$Subscribable this$0;
    public final /* synthetic */ RxMob$Subscriber val$subscriber;

    public RxMob$Subscribable$1(RxMob$Subscribable rxMob$Subscribable, RxMob$Subscriber rxMob$Subscriber) {
        this.this$0 = rxMob$Subscribable;
        this.val$subscriber = rxMob$Subscriber;
    }

    public boolean handleMessage(Message object) {
        object = RxMob$Subscribable.access$100(this.this$0);
        RxMob$Subscribable rxMob$Subscribable = this.this$0;
        RxMob$Subscriber rxMob$Subscriber = this.val$subscriber;
        RxMob$SubscriberWarpper rxMob$SubscriberWarpper = new RxMob$SubscriberWarpper(rxMob$Subscribable, rxMob$Subscriber);
        object.call(rxMob$SubscriberWarpper);
        return false;
    }
}

