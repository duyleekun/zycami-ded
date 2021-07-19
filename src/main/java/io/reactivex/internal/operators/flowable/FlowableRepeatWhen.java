/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen$RepeatWhenSubscriber;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenReceiver;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;

public final class FlowableRepeatWhen
extends a {
    public final o c;

    public FlowableRepeatWhen(j j10, o o10) {
        super(j10);
        this.c = o10;
    }

    public void m6(d object) {
        Object object2;
        e.a.e1.e e10 = new e.a.e1.e((d)object);
        int n10 = 8;
        e.a.b1.a a10 = UnicastProcessor.R8(n10).O8();
        try {
            object2 = this.c;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, (d)object);
            return;
        }
        object2 = object2.apply(a10);
        Object object3 = "handler returned a null Publisher";
        object2 = e.a.w0.b.a.g(object2, (String)object3);
        object2 = (c)object2;
        Object object4 = this.b;
        object3 = new FlowableRepeatWhen$WhenReceiver((c)object4);
        ((FlowableRepeatWhen$WhenReceiver)object3).subscriber = object4 = new FlowableRepeatWhen$RepeatWhenSubscriber(e10, a10, (e)object3);
        object.onSubscribe((e)object4);
        object2.subscribe((d)object3);
        object = 0;
        ((FlowableRepeatWhen$WhenReceiver)object3).onNext(object);
    }
}

