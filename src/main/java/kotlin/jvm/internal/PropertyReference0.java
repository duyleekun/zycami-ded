/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.n0;
import f.m2.c;
import f.m2.o;
import f.m2.o$a;
import kotlin.jvm.internal.PropertyReference;

public abstract class PropertyReference0
extends PropertyReference
implements o {
    public PropertyReference0() {
    }

    public PropertyReference0(Object object) {
        super(object);
    }

    public PropertyReference0(Object object, Class clazz, String string2, String string3, int n10) {
        super(object, clazz, string2, string3, n10);
    }

    public c computeReflected() {
        return n0.q(this);
    }

    public Object getDelegate() {
        return ((o)this.getReflected()).getDelegate();
    }

    public o$a getGetter() {
        return ((o)this.getReflected()).getGetter();
    }

    public Object invoke() {
        return this.get();
    }
}

