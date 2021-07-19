/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.f0;
import f.m2.c;
import f.m2.n;
import kotlin.jvm.internal.CallableReference;

public abstract class PropertyReference
extends CallableReference
implements n {
    public PropertyReference() {
    }

    public PropertyReference(Object object) {
        super(object);
    }

    public PropertyReference(Object object, Class clazz, String string2, String string3, int n10) {
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            n11 = 0;
        }
        super(object, clazz, string2, string3, n11 != 0);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof PropertyReference;
        if (bl3) {
            boolean bl4;
            Object object2;
            object = (PropertyReference)object;
            Object object3 = this.getOwner();
            bl3 = object3.equals(object2 = ((CallableReference)object).getOwner());
            if (!(bl3 && (bl3 = ((String)(object3 = this.getName())).equals(object2 = ((CallableReference)object).getName())) && (bl3 = ((String)(object3 = this.getSignature())).equals(object2 = ((CallableReference)object).getSignature())) && (bl4 = f0.g(object3 = this.getBoundReceiver(), object = ((CallableReference)object).getBoundReceiver())))) {
                bl2 = false;
                Object var7_7 = null;
            }
            return bl2;
        }
        bl2 = object instanceof n;
        if (bl2) {
            c c10 = this.compute();
            return object.equals(c10);
        }
        return false;
    }

    public n getReflected() {
        return (n)super.getReflected();
    }

    public int hashCode() {
        int n10 = this.getOwner().hashCode() * 31;
        int n11 = this.getName().hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.getSignature().hashCode();
        return n10 + n11;
    }

    public boolean isConst() {
        return this.getReflected().isConst();
    }

    public boolean isLateinit() {
        return this.getReflected().isLateinit();
    }

    public String toString() {
        Object object = this.compute();
        if (object != this) {
            return object.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("property ");
        String string2 = this.getName();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" (Kotlin reflection is not available)");
        return ((StringBuilder)object).toString();
    }
}

