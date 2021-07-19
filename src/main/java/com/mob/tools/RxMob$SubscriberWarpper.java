/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 */
package com.mob.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mob.tools.RxMob$Subscribable;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$SubscriberWarpper$1;
import com.mob.tools.RxMob$SubscriberWarpper$2;
import com.mob.tools.RxMob$SubscriberWarpper$3;
import com.mob.tools.RxMob$SubscriberWarpper$4;
import com.mob.tools.RxMob$SubscriberWarpper$5;
import com.mob.tools.RxMob$SubscriberWarpper$6;
import com.mob.tools.RxMob$SubscriberWarpper$7;
import com.mob.tools.RxMob$SubscriberWarpper$8;
import com.mob.tools.RxMob$Thread;
import com.mob.tools.utils.UIHandler;

public final class RxMob$SubscriberWarpper
extends RxMob$Subscriber {
    private RxMob$Subscribable subscribable;
    private RxMob$Subscriber subscriber;

    public RxMob$SubscriberWarpper(RxMob$Subscribable rxMob$Subscribable, RxMob$Subscriber rxMob$Subscriber) {
        this.subscribable = rxMob$Subscribable;
        this.subscriber = rxMob$Subscriber;
        RxMob$Subscriber.access$200(rxMob$Subscriber, this);
    }

    public static /* synthetic */ RxMob$Subscriber access$400(RxMob$SubscriberWarpper rxMob$SubscriberWarpper) {
        return rxMob$SubscriberWarpper.subscriber;
    }

    public void onCompleted() {
        Object object = this.subscriber;
        if (object != null) {
            Object object2;
            object = RxMob$Subscribable.access$300(this.subscribable);
            if (object == (object2 = RxMob$Thread.UI_THREAD)) {
                object = Looper.getMainLooper().getThread();
                long l10 = ((Thread)object).getId();
                Thread thread = Thread.currentThread();
                long l11 = thread.getId();
                long l12 = l11 - l10;
                Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 == false) {
                    object = this.subscriber;
                    object.onCompleted();
                    this.removeSubscriber();
                } else {
                    object = Message.obtain();
                    ((Message)object).what = 0;
                    object2 = this.subscriber;
                    ((Message)object).obj = object2;
                    object2 = new RxMob$SubscriberWarpper$5(this);
                    UIHandler.sendMessage((Message)object, (Handler.Callback)object2);
                }
            } else {
                object = RxMob$Subscribable.access$300(this.subscribable);
                if (object == (object2 = RxMob$Thread.NEW_THREAD)) {
                    object = new RxMob$SubscriberWarpper$6(this);
                    ((Thread)object).start();
                } else {
                    object = this.subscriber;
                    object.onCompleted();
                    this.removeSubscriber();
                }
            }
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.subscriber;
        if (object != null) {
            Object object2;
            object = RxMob$Subscribable.access$300(this.subscribable);
            if (object == (object2 = RxMob$Thread.UI_THREAD)) {
                object = Looper.getMainLooper().getThread();
                long l10 = ((Thread)object).getId();
                Thread thread = Thread.currentThread();
                long l11 = thread.getId();
                long l12 = l11 - l10;
                Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 == false) {
                    object = this.subscriber;
                    object.onError(throwable);
                    this.removeSubscriber();
                } else {
                    object = Message.obtain();
                    ((Message)object).what = 0;
                    object2 = this.subscriber;
                    ((Message)object).obj = object2;
                    object2 = new RxMob$SubscriberWarpper$7(this, throwable);
                    UIHandler.sendMessage((Message)object, (Handler.Callback)object2);
                }
            } else {
                object = RxMob$Subscribable.access$300(this.subscribable);
                if (object == (object2 = RxMob$Thread.NEW_THREAD)) {
                    object = new RxMob$SubscriberWarpper$8(this, throwable);
                    ((Thread)object).start();
                } else {
                    object = this.subscriber;
                    object.onError(throwable);
                    this.removeSubscriber();
                }
            }
        }
    }

    public void onNext(Object object) {
        Object object2 = this.subscriber;
        if (object2 != null) {
            Object object3;
            object2 = RxMob$Subscribable.access$300(this.subscribable);
            if (object2 == (object3 = RxMob$Thread.UI_THREAD)) {
                object2 = Looper.getMainLooper().getThread();
                long l10 = ((Thread)object2).getId();
                Thread thread = Thread.currentThread();
                long l11 = thread.getId();
                long l12 = l11 - l10;
                Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object4 == false) {
                    object2 = this.subscriber;
                    object2.onNext(object);
                } else {
                    object2 = Message.obtain();
                    ((Message)object2).what = 0;
                    object3 = this.subscriber;
                    ((Message)object2).obj = object3;
                    object3 = new RxMob$SubscriberWarpper$3(this, object);
                    UIHandler.sendMessage((Message)object2, (Handler.Callback)object3);
                }
            } else {
                object2 = RxMob$Subscribable.access$300(this.subscribable);
                if (object2 == (object3 = RxMob$Thread.NEW_THREAD)) {
                    object2 = new RxMob$SubscriberWarpper$4(this, object);
                    ((Thread)object2).start();
                } else {
                    object2 = this.subscriber;
                    object2.onNext(object);
                }
            }
        }
    }

    public void onStart() {
        Object object = this.subscriber;
        if (object != null) {
            Object object2;
            object = RxMob$Subscribable.access$300(this.subscribable);
            if (object == (object2 = RxMob$Thread.UI_THREAD)) {
                object = Looper.getMainLooper().getThread();
                long l10 = ((Thread)object).getId();
                Thread thread = Thread.currentThread();
                long l11 = thread.getId();
                long l12 = l11 - l10;
                Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 == false) {
                    object = this.subscriber;
                    object.onStart();
                } else {
                    object = Message.obtain();
                    ((Message)object).what = 0;
                    object2 = this.subscriber;
                    ((Message)object).obj = object2;
                    object2 = new RxMob$SubscriberWarpper$1(this);
                    UIHandler.sendMessage((Message)object, (Handler.Callback)object2);
                }
            } else {
                object = RxMob$Subscribable.access$300(this.subscribable);
                if (object == (object2 = RxMob$Thread.NEW_THREAD)) {
                    object = new RxMob$SubscriberWarpper$2(this);
                    ((Thread)object).start();
                } else {
                    object = this.subscriber;
                    object.onStart();
                }
            }
        }
    }

    public void removeSubscriber() {
        this.subscriber = null;
    }
}

