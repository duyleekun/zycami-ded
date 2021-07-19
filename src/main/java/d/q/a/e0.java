/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.b0;
import e.a.a;
import e.a.g;
import io.reactivex.subjects.CompletableSubject;

public final class e0
implements b0 {
    private final CompletableSubject b;

    private e0(a a10) {
        CompletableSubject completableSubject;
        this.b = completableSubject = CompletableSubject.i1();
        a10.f(completableSubject);
    }

    public static e0 e() {
        return e0.f(CompletableSubject.i1());
    }

    public static e0 f(a a10) {
        e0 e02 = new e0(a10);
        return e02;
    }

    public g a() {
        return this.b;
    }

    public void g() {
        this.b.onComplete();
    }
}

