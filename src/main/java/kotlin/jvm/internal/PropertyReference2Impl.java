/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.r;
import f.m2.d;
import f.m2.h;
import f.m2.n$c;
import kotlin.jvm.internal.PropertyReference2;

public class PropertyReference2Impl
extends PropertyReference2 {
    public PropertyReference2Impl(h h10, String string2, String string3) {
        Object object = h10;
        object = ((r)h10).o();
        int n10 = h10 instanceof d ^ 1;
        super((Class)object, string2, string3, n10);
    }

    public PropertyReference2Impl(Class clazz, String string2, String string3, int n10) {
        super(clazz, string2, string3, n10);
    }

    public Object get(Object object, Object object2) {
        n$c n$c = this.getGetter();
        Object[] objectArray = new Object[]{object, object2};
        return n$c.call(objectArray);
    }
}

