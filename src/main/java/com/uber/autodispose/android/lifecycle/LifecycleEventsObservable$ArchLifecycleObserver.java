/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import d.q.a.f0.e.d;
import e.a.d1.a;
import e.a.g0;

public final class LifecycleEventsObservable$ArchLifecycleObserver
extends d
implements LifecycleObserver {
    private final Lifecycle b;
    private final g0 c;
    private final a d;

    public LifecycleEventsObservable$ArchLifecycleObserver(Lifecycle lifecycle, g0 g02, a a10) {
        this.b = lifecycle;
        this.c = g02;
        this.d = a10;
    }

    public void b() {
        this.b.removeObserver(this);
    }

    public void onStateChange(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            object = Lifecycle$Event.ON_CREATE;
            if (lifecycle$Event != object || (object = this.d.p8()) != lifecycle$Event) {
                object = this.d;
                ((a)object).onNext((Object)lifecycle$Event);
            }
            object = this.c;
            object.onNext((Object)lifecycle$Event);
        }
    }
}

