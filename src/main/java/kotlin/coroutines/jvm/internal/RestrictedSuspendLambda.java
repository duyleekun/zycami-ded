/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.jvm.internal;

import f.b2.c;
import f.b2.k.a.j;
import f.h2.t.b0;
import f.h2.t.f0;
import f.h2.t.n0;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

public abstract class RestrictedSuspendLambda
extends RestrictedContinuationImpl
implements b0,
j {
    private final int arity;

    public RestrictedSuspendLambda(int n10) {
        this(n10, null);
    }

    public RestrictedSuspendLambda(int n10, c c10) {
        super(c10);
        this.arity = n10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        Object object = this.getCompletion();
        if (object == null) {
            object = n0.t(this);
            String string2 = "Reflection.renderLambdaToString(this)";
            f0.o(object, string2);
        } else {
            object = super.toString();
        }
        return object;
    }
}

