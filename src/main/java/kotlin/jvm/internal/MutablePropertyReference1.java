/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.n0;
import f.m2.c;
import f.m2.l;
import f.m2.l$a;
import f.m2.p$a;
import kotlin.jvm.internal.MutablePropertyReference;

public abstract class MutablePropertyReference1
extends MutablePropertyReference
implements l {
    public MutablePropertyReference1() {
    }

    public MutablePropertyReference1(Object object) {
        super(object);
    }

    public MutablePropertyReference1(Object object, Class clazz, String string2, String string3, int n10) {
        super(object, clazz, string2, string3, n10);
    }

    public c computeReflected() {
        return n0.j(this);
    }

    public Object getDelegate(Object object) {
        return ((l)this.getReflected()).getDelegate(object);
    }

    public p$a getGetter() {
        return ((l)this.getReflected()).getGetter();
    }

    public l$a getSetter() {
        return ((l)this.getReflected()).getSetter();
    }

    public Object invoke(Object object) {
        return this.get(object);
    }
}

