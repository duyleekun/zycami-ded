/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.n0;
import f.m2.c;
import f.m2.k;
import f.m2.k$a;
import f.m2.o$a;
import kotlin.jvm.internal.MutablePropertyReference;

public abstract class MutablePropertyReference0
extends MutablePropertyReference
implements k {
    public MutablePropertyReference0() {
    }

    public MutablePropertyReference0(Object object) {
        super(object);
    }

    public MutablePropertyReference0(Object object, Class clazz, String string2, String string3, int n10) {
        super(object, clazz, string2, string3, n10);
    }

    public c computeReflected() {
        return n0.i(this);
    }

    public Object getDelegate() {
        return ((k)this.getReflected()).getDelegate();
    }

    public o$a getGetter() {
        return ((k)this.getReflected()).getGetter();
    }

    public k$a getSetter() {
        return ((k)this.getReflected()).getSetter();
    }

    public Object invoke() {
        return this.get();
    }
}

