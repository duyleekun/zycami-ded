/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.r;
import f.m2.d;
import f.m2.h;
import f.m2.j$a;
import f.m2.n$c;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference1;

public class MutablePropertyReference1Impl
extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(h h10, String string2, String string3) {
        Object object = CallableReference.NO_RECEIVER;
        Class clazz = ((r)h10).o();
        int n10 = h10 instanceof d ^ 1;
        super(object, clazz, string2, string3, n10);
    }

    public MutablePropertyReference1Impl(Class clazz, String string2, String string3, int n10) {
        Object object = CallableReference.NO_RECEIVER;
        super(object, clazz, string2, string3, n10);
    }

    public MutablePropertyReference1Impl(Object object, Class clazz, String string2, String string3, int n10) {
        super(object, clazz, string2, string3, n10);
    }

    public Object get(Object object) {
        n$c n$c = this.getGetter();
        Object[] objectArray = new Object[]{object};
        return n$c.call(objectArray);
    }

    public void set(Object object, Object object2) {
        j$a j$a = this.getSetter();
        Object[] objectArray = new Object[]{object, object2};
        j$a.call(objectArray);
    }
}

