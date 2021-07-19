/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableMapNotification$MapNotificationSubscriber;
import java.util.concurrent.Callable;

public final class FlowableMapNotification
extends a {
    public final o c;
    public final o d;
    public final Callable e;

    public FlowableMapNotification(j j10, o o10, o o11, Callable callable) {
        super(j10);
        this.c = o10;
        this.d = o11;
        this.e = callable;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o o10 = this.c;
        o o11 = this.d;
        Callable callable = this.e;
        FlowableMapNotification$MapNotificationSubscriber flowableMapNotification$MapNotificationSubscriber = new FlowableMapNotification$MapNotificationSubscriber(d10, o10, o11, callable);
        j10.l6(flowableMapNotification$MapNotificationSubscriber);
    }
}

