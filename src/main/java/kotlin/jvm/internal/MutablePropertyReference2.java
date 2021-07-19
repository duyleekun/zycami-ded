/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.n0;
import f.m2.c;
import f.m2.m;
import f.m2.m$a;
import f.m2.q$a;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference;

public abstract class MutablePropertyReference2
extends MutablePropertyReference
implements m {
    public MutablePropertyReference2() {
    }

    public MutablePropertyReference2(Class clazz, String string2, String string3, int n10) {
        Object object = CallableReference.NO_RECEIVER;
        super(object, clazz, string2, string3, n10);
    }

    public c computeReflected() {
        return n0.k(this);
    }

    public Object getDelegate(Object object, Object object2) {
        return ((m)this.getReflected()).getDelegate(object, object2);
    }

    public q$a getGetter() {
        return ((m)this.getReflected()).getGetter();
    }

    public m$a getSetter() {
        return ((m)this.getReflected()).getSetter();
    }

    public Object invoke(Object object, Object object2) {
        return this.get(object, object2);
    }
}

