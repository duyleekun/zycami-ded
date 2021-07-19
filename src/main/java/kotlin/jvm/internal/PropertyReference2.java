/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.n0;
import f.m2.c;
import f.m2.q;
import f.m2.q$a;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference;

public abstract class PropertyReference2
extends PropertyReference
implements q {
    public PropertyReference2() {
    }

    public PropertyReference2(Class clazz, String string2, String string3, int n10) {
        Object object = CallableReference.NO_RECEIVER;
        super(object, clazz, string2, string3, n10);
    }

    public c computeReflected() {
        return n0.s(this);
    }

    public Object getDelegate(Object object, Object object2) {
        return ((q)this.getReflected()).getDelegate(object, object2);
    }

    public q$a getGetter() {
        return ((q)this.getReflected()).getGetter();
    }

    public Object invoke(Object object, Object object2) {
        return this.get(object, object2);
    }
}

