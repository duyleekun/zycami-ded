/*
 * Decompiled with CFR 0.151.
 */
package f.b2;

import f.b2.c;
import f.h2.s.l;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;

public final class e$a
implements c {
    public final /* synthetic */ CoroutineContext a;
    public final /* synthetic */ l b;

    public e$a(CoroutineContext coroutineContext, l l10) {
        this.a = coroutineContext;
        this.b = l10;
    }

    public CoroutineContext getContext() {
        return this.a;
    }

    public void resumeWith(Object object) {
        l l10 = this.b;
        object = Result.box-impl(object);
        l10.invoke(object);
    }
}

