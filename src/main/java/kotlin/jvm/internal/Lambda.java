/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.b0;
import f.h2.t.f0;
import f.h2.t.n0;
import java.io.Serializable;

public abstract class Lambda
implements b0,
Serializable {
    private final int arity;

    public Lambda(int n10) {
        this.arity = n10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String string2 = n0.u(this);
        f0.o(string2, "Reflection.renderLambdaToString(this)");
        return string2;
    }
}

