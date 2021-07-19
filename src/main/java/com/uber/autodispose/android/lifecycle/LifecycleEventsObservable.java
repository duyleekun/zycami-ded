/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable$ArchLifecycleObserver;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable$a;
import d.q.a.f0.e.c;
import d.q.a.f0.e.d;
import e.a.d1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.z;

public class LifecycleEventsObservable
extends z {
    private final Lifecycle a;
    private final a b;

    public LifecycleEventsObservable(Lifecycle lifecycle) {
        a a10;
        this.b = a10 = e.a.d1.a.n8();
        this.a = lifecycle;
    }

    public void K5(g0 object) {
        Lifecycle lifecycle = this.a;
        a a10 = this.b;
        Object object2 = new LifecycleEventsObservable$ArchLifecycleObserver(lifecycle, (g0)object, a10);
        object.onSubscribe((b)object2);
        boolean bl2 = c.a();
        if (!bl2) {
            object2 = new IllegalStateException("Lifecycles can only be bound to on the main thread!");
            object.onError((Throwable)object2);
            return;
        }
        object = this.a;
        ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        boolean bl3 = ((d)object2).isDisposed();
        if (bl3) {
            object = this.a;
            ((Lifecycle)object).removeObserver((LifecycleObserver)object2);
        }
    }

    public void h8() {
        Object object = LifecycleEventsObservable$a.a;
        Lifecycle$State lifecycle$State = this.a.getCurrentState();
        int n10 = lifecycle$State.ordinal();
        int n11 = object[n10];
        object = n11 != (n10 = 1) ? (n11 != (n10 = 2) ? (n11 != (n10 = 3) && n11 != (n10 = 4) ? (Object)((Object)Lifecycle$Event.ON_DESTROY) : (Object)((Object)Lifecycle$Event.ON_RESUME)) : (Object)((Object)Lifecycle$Event.ON_START)) : (Object)((Object)Lifecycle$Event.ON_CREATE);
        this.b.onNext(object);
    }

    public Lifecycle$Event i8() {
        return (Lifecycle$Event)((Object)this.b.p8());
    }
}

