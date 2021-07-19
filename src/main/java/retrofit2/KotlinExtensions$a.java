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
import g.a0;
import java.lang.reflect.Method;
import k.d;
import k.f;
import k.k;
import k.r;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;
import retrofit2.HttpException;

public final class KotlinExtensions$a
implements f {
    public final /* synthetic */ CancellableContinuation a;

    public KotlinExtensions$a(CancellableContinuation cancellableContinuation) {
        this.a = cancellableContinuation;
    }

    public void onFailure(d object, Throwable object2) {
        f0.q(object, "call");
        f0.q(object2, "t");
        object = (c)this.a;
        object2 = Result.constructor-impl(o0.a((Throwable)object2));
        object.resumeWith(object2);
    }

    public void onResponse(d object, r clazz) {
        f0.q(object, "call");
        Object object2 = "response";
        f0.q(clazz, (String)object2);
        boolean bl2 = ((r)((Object)clazz)).g();
        if (bl2) {
            if ((clazz = ((r)((Object)clazz)).a()) == null) {
                object = object.C();
                clazz = k.class;
                if ((object = ((a0)object).p(clazz)) == null) {
                    f0.L();
                }
                f0.h(object, "call.request().tag(Invocation::class.java)!!");
                object = ((k)object).b();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Response from ");
                f0.h(object, "method");
                Object object3 = ((Method)object).getDeclaringClass();
                String string2 = "method.declaringClass";
                f0.h(object3, string2);
                object3 = ((Class)object3).getName();
                ((StringBuilder)object2).append((String)object3);
                char c10 = '.';
                ((StringBuilder)object2).append(c10);
                object = ((Method)object).getName();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" was null but response body type was declared as non-null");
                object = ((StringBuilder)object2).toString();
                clazz = new KotlinNullPointerException((String)object);
                object = (c)this.a;
                object2 = Result.Companion;
                clazz = Result.constructor-impl(o0.a((Throwable)((Object)clazz)));
                object.resumeWith(clazz);
            } else {
                object = (c)this.a;
                object2 = Result.Companion;
                clazz = Result.constructor-impl(clazz);
                object.resumeWith(clazz);
            }
        } else {
            object = (c)this.a;
            object2 = new HttpException((r)((Object)clazz));
            clazz = Result.Companion;
            clazz = Result.constructor-impl(o0.a((Throwable)object2));
            object.resumeWith(clazz);
        }
    }
}

