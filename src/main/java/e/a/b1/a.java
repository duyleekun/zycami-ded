/*
 * Decompiled with CFR 0.151.
 */
package e.a.b1;

import e.a.b1.b;
import e.a.j;
import e.a.o;

public abstract class a
extends j
implements i.g.b,
o {
    public abstract Throwable K8();

    public abstract boolean L8();

    public abstract boolean M8();

    public abstract boolean N8();

    public final a O8() {
        boolean bl2 = this instanceof b;
        if (bl2) {
            return this;
        }
        b b10 = new b(this);
        return b10;
    }
}

