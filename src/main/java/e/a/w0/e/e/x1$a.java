/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.w0.e.e.x1$c;
import e.a.y0.d;
import io.reactivex.subjects.UnicastSubject;

public final class x1$a
extends d {
    public final x1$c b;
    public final UnicastSubject c;
    public boolean d;

    public x1$a(x1$c c10, UnicastSubject unicastSubject) {
        this.b = c10;
        this.c = unicastSubject;
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = true;
        this.b.i(this);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.b.m(throwable);
    }

    public void onNext(Object object) {
        this.dispose();
        this.onComplete();
    }
}

