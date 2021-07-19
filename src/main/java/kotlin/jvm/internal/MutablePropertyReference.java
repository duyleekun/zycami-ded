/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.m2.j;
import kotlin.jvm.internal.PropertyReference;

public abstract class MutablePropertyReference
extends PropertyReference
implements j {
    public MutablePropertyReference() {
    }

    public MutablePropertyReference(Object object) {
        super(object);
    }

    public MutablePropertyReference(Object object, Class clazz, String string2, String string3, int n10) {
        super(object, clazz, string2, string3, n10);
    }
}

