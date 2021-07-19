/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.jvm.internal;

import f.b2.j.b;
import f.b2.k.a.c;
import f.b2.k.a.e;
import f.b2.k.a.f;
import f.h2.t.f0;
import f.o0;
import java.io.Serializable;
import kotlin.Result;

public abstract class BaseContinuationImpl
implements f.b2.c,
c,
Serializable {
    private final f.b2.c completion;

    public BaseContinuationImpl(f.b2.c c10) {
        this.completion = c10;
    }

    public f.b2.c create(f.b2.c object) {
        f0.p(object, "completion");
        object = new UnsupportedOperationException("create(Continuation) has not been overridden");
        throw object;
    }

    public f.b2.c create(Object object, f.b2.c c10) {
        f0.p(c10, "completion");
        object = new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
        throw object;
    }

    public c getCallerFrame() {
        f.b2.c c10 = this.completion;
        boolean bl2 = c10 instanceof c;
        if (!bl2) {
            c10 = null;
        }
        return (c)((Object)c10);
    }

    public final f.b2.c getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return e.e(this);
    }

    public abstract Object invokeSuspend(Object var1);

    public void releaseIntercepted() {
    }

    public final void resumeWith(Object object) {
        f.b2.c c10;
        f.b2.c c11 = this;
        while (true) {
            Object object2;
            block6: {
                f.b(c11);
                c10 = c11.completion;
                f0.m(c10);
                object = c11.invokeSuspend(object);
                object2 = b.h();
                if (object != object2) break block6;
                return;
            }
            object2 = Result.Companion;
            try {
                object = Result.constructor-impl(object);
            }
            catch (Throwable throwable) {
                object2 = Result.Companion;
                object = Result.constructor-impl(o0.a(throwable));
            }
            c11.releaseIntercepted();
            boolean bl2 = c10 instanceof BaseContinuationImpl;
            if (!bl2) break;
            c11 = c10;
            c11 = (BaseContinuationImpl)c10;
        }
        c10.resumeWith(object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Continuation at ");
        Object object = this.getStackTraceElement();
        if (object == null) {
            object = this.getClass().getName();
        }
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

