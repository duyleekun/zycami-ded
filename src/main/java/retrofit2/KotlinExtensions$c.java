/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  kotlinx.coroutines.CancellableContinuation
 */
package retrofit2;

import f.b2.c;
import f.h2.t.f0;
import f.o0;
import k.d;
import k.f;
import k.r;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

public final class KotlinExtensions$c
implements f {
    public final /* synthetic */ CancellableContinuation a;

    public KotlinExtensions$c(CancellableContinuation cancellableContinuation) {
        this.a = cancellableContinuation;
    }

    public void onFailure(d object, Throwable object2) {
        f0.q(object, "call");
        f0.q(object2, "t");
        object = (c)this.a;
        object2 = Result.constructor-impl(o0.a((Throwable)object2));
        object.resumeWith(object2);
    }

    public void onResponse(d object, r object2) {
        f0.q(object, "call");
        f0.q(object2, "response");
        object = (c)this.a;
        object2 = Result.constructor-impl(object2);
        object.resumeWith(object2);
    }
}

