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
import retrofit2.HttpException;

public final class KotlinExtensions$b
implements f {
    public final /* synthetic */ CancellableContinuation a;

    public KotlinExtensions$b(CancellableContinuation cancellableContinuation) {
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
        Object object3 = "call";
        f0.q(object, (String)object3);
        object = "response";
        f0.q(object2, (String)object);
        boolean bl2 = ((r)object2).g();
        if (bl2) {
            object = (c)this.a;
            object2 = ((r)object2).a();
            object3 = Result.Companion;
            object2 = Result.constructor-impl(object2);
            object.resumeWith(object2);
        } else {
            object = (c)this.a;
            object3 = new HttpException((r)object2);
            object2 = Result.Companion;
            object2 = Result.constructor-impl(o0.a((Throwable)object3));
            object.resumeWith(object2);
        }
    }
}

