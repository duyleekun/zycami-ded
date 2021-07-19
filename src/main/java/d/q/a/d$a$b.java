/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.d$a;
import d.q.a.j;
import d.q.a.u;
import e.a.s0.b;
import e.a.v0.a;
import e.a.v0.g;
import i.g.d;
import io.reactivex.subscribers.TestSubscriber;

public class d$a$b
implements u {
    public final /* synthetic */ e.a.j a;
    public final /* synthetic */ d$a b;

    public d$a$b(d$a d$a, e.a.j j10) {
        this.b = d$a;
        this.a = j10;
    }

    public b a() {
        e.a.j j10 = this.a;
        e.a.g g10 = this.b.a;
        j j11 = new j(j10, g10);
        return j11.a();
    }

    public TestSubscriber b() {
        TestSubscriber testSubscriber = new TestSubscriber();
        this.subscribe(testSubscriber);
        return testSubscriber;
    }

    public b c(g g10, g g11) {
        e.a.j j10 = this.a;
        e.a.g g12 = this.b.a;
        j j11 = new j(j10, g12);
        return j11.c(g10, g11);
    }

    public b d(g g10) {
        e.a.j j10 = this.a;
        e.a.g g11 = this.b.a;
        j j11 = new j(j10, g11);
        return j11.d(g10);
    }

    public b f(g g10, g g11, a a10) {
        e.a.j j10 = this.a;
        e.a.g g12 = this.b.a;
        j j11 = new j(j10, g12);
        return j11.f(g10, g11, a10);
    }

    public b h(g g10, g g11, a a10, g g12) {
        e.a.j j10 = this.a;
        e.a.g g13 = this.b.a;
        j j11 = new j(j10, g13);
        return j11.h(g10, g11, a10, g12);
    }

    public TestSubscriber i(long l10, boolean bl2) {
        TestSubscriber testSubscriber = new TestSubscriber(l10);
        if (bl2) {
            testSubscriber.cancel();
        }
        this.subscribe(testSubscriber);
        return testSubscriber;
    }

    public d j(d d10) {
        e.a.j j10 = this.a;
        e.a.g g10 = this.b.a;
        j j11 = new j(j10, g10);
        return j11.j(d10);
    }

    public TestSubscriber l(long l10) {
        TestSubscriber testSubscriber = new TestSubscriber(l10);
        this.subscribe(testSubscriber);
        return testSubscriber;
    }

    public void subscribe(d d10) {
        e.a.j j10 = this.a;
        e.a.g g10 = this.b.a;
        j j11 = new j(j10, g10);
        j11.subscribe(d10);
    }
}

