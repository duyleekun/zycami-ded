/*
 * Decompiled with CFR 0.151.
 */
package d.k.b;

import d.k.b.d;
import e.a.v0.g;
import e.a.z;

public abstract class c
extends z
implements g {
    public abstract void accept(Object var1);

    public abstract boolean h8();

    public final c i8() {
        boolean bl2 = this instanceof d;
        if (bl2) {
            return this;
        }
        d d10 = new d(this);
        return d10;
    }
}

