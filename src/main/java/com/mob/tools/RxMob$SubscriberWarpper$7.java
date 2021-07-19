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
import com.mob.tools.MobLog;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$SubscriberWarpper;
import com.mob.tools.log.NLog;

public class RxMob$SubscriberWarpper$7
implements Handler.Callback {
    public final /* synthetic */ RxMob$SubscriberWarpper this$0;
    public final /* synthetic */ Throwable val$t;

    public RxMob$SubscriberWarpper$7(RxMob$SubscriberWarpper rxMob$SubscriberWarpper, Throwable throwable) {
        this.this$0 = rxMob$SubscriberWarpper;
        this.val$t = throwable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean handleMessage(Message object) {
        if (object == null) return false;
        try {
            object = ((Message)object).obj;
            object = (RxMob$Subscriber)object;
            if (object != null) {
                Throwable throwable = this.val$t;
                ((RxMob$Subscriber)object).onError(throwable);
                object = this.this$0;
                ((RxMob$SubscriberWarpper)object).removeSubscriber();
                return false;
            }
            object = MobLog.getInstance();
            String string2 = "[UIThread/onError] Network request interrupted as Subscriber is null";
            Throwable throwable = new Throwable(string2);
            ((NLog)object).crash(throwable);
            return false;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.crash(throwable);
        }
        return false;
    }
}

