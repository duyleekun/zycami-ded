/*
 * Decompiled with CFR 0.151.
 */
package e.a.d1;

import e.a.d1.b;
import e.a.g0;
import e.a.z;

public abstract class c
extends z
implements g0 {
    public abstract Throwable h8();

    public abstract boolean i8();

    public abstract boolean j8();

    public abstract boolean k8();

    public final c l8() {
        boolean bl2 = this instanceof b;
        if (bl2) {
            return this;
        }
        b b10 = new b(this);
        return b10;
    }
}

