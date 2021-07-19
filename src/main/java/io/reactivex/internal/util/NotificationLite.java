/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import e.a.g0;
import e.a.s0.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.util.NotificationLite$DisposableNotification;
import io.reactivex.internal.util.NotificationLite$ErrorNotification;
import io.reactivex.internal.util.NotificationLite$SubscriptionNotification;

public final class NotificationLite
extends Enum {
    public static final /* enum */ NotificationLite COMPLETE;
    private static final /* synthetic */ NotificationLite[] a;

    static {
        NotificationLite notificationLite;
        COMPLETE = notificationLite = new NotificationLite("COMPLETE", 0);
        NotificationLite[] notificationLiteArray = new NotificationLite[]{notificationLite};
        a = notificationLiteArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NotificationLite() {
        void var2_-1;
        void var1_-1;
    }

    public static boolean accept(Object object, g0 g02) {
        NotificationLite notificationLite = COMPLETE;
        boolean bl2 = true;
        if (object == notificationLite) {
            g02.onComplete();
            return bl2;
        }
        boolean bl3 = object instanceof NotificationLite$ErrorNotification;
        if (bl3) {
            object = ((NotificationLite$ErrorNotification)object).e;
            g02.onError((Throwable)object);
            return bl2;
        }
        g02.onNext(object);
        return false;
    }

    public static boolean accept(Object object, d d10) {
        NotificationLite notificationLite = COMPLETE;
        boolean bl2 = true;
        if (object == notificationLite) {
            d10.onComplete();
            return bl2;
        }
        boolean bl3 = object instanceof NotificationLite$ErrorNotification;
        if (bl3) {
            object = ((NotificationLite$ErrorNotification)object).e;
            d10.onError((Throwable)object);
            return bl2;
        }
        d10.onNext(object);
        return false;
    }

    public static boolean acceptFull(Object object, g0 g02) {
        NotificationLite notificationLite = COMPLETE;
        boolean bl2 = true;
        if (object == notificationLite) {
            g02.onComplete();
            return bl2;
        }
        boolean bl3 = object instanceof NotificationLite$ErrorNotification;
        if (bl3) {
            object = ((NotificationLite$ErrorNotification)object).e;
            g02.onError((Throwable)object);
            return bl2;
        }
        bl3 = object instanceof NotificationLite$DisposableNotification;
        bl2 = false;
        if (bl3) {
            object = ((NotificationLite$DisposableNotification)object).upstream;
            g02.onSubscribe((b)object);
            return false;
        }
        g02.onNext(object);
        return false;
    }

    public static boolean acceptFull(Object object, d d10) {
        NotificationLite notificationLite = COMPLETE;
        boolean bl2 = true;
        if (object == notificationLite) {
            d10.onComplete();
            return bl2;
        }
        boolean bl3 = object instanceof NotificationLite$ErrorNotification;
        if (bl3) {
            object = ((NotificationLite$ErrorNotification)object).e;
            d10.onError((Throwable)object);
            return bl2;
        }
        bl3 = object instanceof NotificationLite$SubscriptionNotification;
        bl2 = false;
        if (bl3) {
            object = ((NotificationLite$SubscriptionNotification)object).upstream;
            d10.onSubscribe((e)object);
            return false;
        }
        d10.onNext(object);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(b b10) {
        NotificationLite$DisposableNotification notificationLite$DisposableNotification = new NotificationLite$DisposableNotification(b10);
        return notificationLite$DisposableNotification;
    }

    public static Object error(Throwable throwable) {
        NotificationLite$ErrorNotification notificationLite$ErrorNotification = new NotificationLite$ErrorNotification(throwable);
        return notificationLite$ErrorNotification;
    }

    public static b getDisposable(Object object) {
        return ((NotificationLite$DisposableNotification)object).upstream;
    }

    public static Throwable getError(Object object) {
        return ((NotificationLite$ErrorNotification)object).e;
    }

    public static e getSubscription(Object object) {
        return ((NotificationLite$SubscriptionNotification)object).upstream;
    }

    public static Object getValue(Object object) {
        return object;
    }

    public static boolean isComplete(Object object) {
        boolean bl2;
        NotificationLite notificationLite = COMPLETE;
        if (object == notificationLite) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean isDisposable(Object object) {
        return object instanceof NotificationLite$DisposableNotification;
    }

    public static boolean isError(Object object) {
        return object instanceof NotificationLite$ErrorNotification;
    }

    public static boolean isSubscription(Object object) {
        return object instanceof NotificationLite$SubscriptionNotification;
    }

    public static Object next(Object object) {
        return object;
    }

    public static Object subscription(e e10) {
        NotificationLite$SubscriptionNotification notificationLite$SubscriptionNotification = new NotificationLite$SubscriptionNotification(e10);
        return notificationLite$SubscriptionNotification;
    }

    public static NotificationLite valueOf(String string2) {
        return Enum.valueOf(NotificationLite.class, string2);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[])a.clone();
    }

    public String toString() {
        return "NotificationLite.Complete";
    }
}

