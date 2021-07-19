/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.b2.c;
import f.f;
import f.h2.s.q;
import kotlin.coroutines.CoroutineContext;

public final class f$a
implements c {
    public final /* synthetic */ CoroutineContext a;
    public final /* synthetic */ f b;
    public final /* synthetic */ q c;
    public final /* synthetic */ c d;

    public f$a(CoroutineContext coroutineContext, f f10, q q10, c c10) {
        this.a = coroutineContext;
        this.b = f10;
        this.c = q10;
        this.d = c10;
    }

    public CoroutineContext getContext() {
        return this.a;
    }

    public void resumeWith(Object object) {
        f f10 = this.b;
        Object object2 = this.c;
        f.h(f10, (q)object2);
        f10 = this.b;
        object2 = this.d;
        f.g(f10, (c)object2);
        f.i(this.b, object);
    }
}

