/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.b1.a;
import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.s0.c;
import e.a.v0.o;
import io.reactivex.internal.schedulers.SchedulerWhen$a;
import io.reactivex.internal.schedulers.SchedulerWhen$c;
import io.reactivex.internal.schedulers.SchedulerWhen$d;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;

public class SchedulerWhen
extends h0
implements b {
    public static final b e;
    public static final b f;
    private final h0 b;
    private final a c;
    private b d;

    static {
        SchedulerWhen$d schedulerWhen$d = new SchedulerWhen$d();
        e = schedulerWhen$d;
        f = e.a.s0.c.a();
    }

    public SchedulerWhen(o object, h0 object2) {
        this.b = object2;
        this.c = object2 = UnicastProcessor.Q8().O8();
        try {
            object = object.apply(object2);
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.f(throwable);
        }
        object = (e.a.a)object;
        object = ((e.a.a)object).a();
        this.d = object;
    }

    public h0$c c() {
        h0$c h0$c = this.b.c();
        a a10 = UnicastProcessor.Q8().O8();
        Object object = new SchedulerWhen$a(h0$c);
        object = a10.R3((o)object);
        SchedulerWhen$c schedulerWhen$c = new SchedulerWhen$c(a10, h0$c);
        this.c.onNext(object);
        return schedulerWhen$c;
    }

    public void dispose() {
        this.d.dispose();
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
    }
}

