/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.n0;
import f.m2.c;
import f.m2.p;
import f.m2.p$a;
import kotlin.jvm.internal.PropertyReference;

public abstract class PropertyReference1
extends PropertyReference
implements p {
    public PropertyReference1() {
    }

    public PropertyReference1(Object object) {
        super(object);
    }

    public PropertyReference1(Object object, Class clazz, String string2, String string3, int n10) {
        super(object, clazz, string2, string3, n10);
    }

    public c computeReflected() {
        return n0.r(this);
    }

    public Object getDelegate(Object object) {
        return ((p)this.getReflected()).getDelegate(object);
    }

    public p$a getGetter() {
        return ((p)this.getReflected()).getGetter();
    }

    public Object invoke(Object object) {
        return this.get(object);
    }
}

