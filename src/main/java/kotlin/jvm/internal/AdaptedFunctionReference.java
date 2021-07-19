/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.b0;
import f.h2.t.f0;
import f.h2.t.n0;
import f.m2.h;
import java.io.Serializable;
import kotlin.jvm.internal.CallableReference;

public class AdaptedFunctionReference
implements b0,
Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    public final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int n10, Class clazz, String string2, String string3, int n11) {
        Object object = CallableReference.NO_RECEIVER;
        this(n10, object, clazz, string2, string3, n11);
    }

    public AdaptedFunctionReference(int n10, Object object, Class clazz, String string2, String string3, int n11) {
        this.receiver = object;
        this.owner = clazz;
        this.name = string2;
        this.signature = string3;
        int n12 = n11 & 1;
        int n13 = 1;
        if (n12 == n13) {
            n12 = n13;
        } else {
            n12 = 0;
            object = null;
        }
        this.isTopLevel = n12;
        this.arity = n10;
        this.flags = n10 = n11 >> 1;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        int n10 = object instanceof AdaptedFunctionReference;
        if (n10 == 0) {
            return false;
        }
        object = (AdaptedFunctionReference)object;
        n10 = this.isTopLevel;
        int n11 = ((AdaptedFunctionReference)object).isTopLevel;
        if (n10 != n11 || (n10 = this.arity) != (n11 = ((AdaptedFunctionReference)object).arity) || (n10 = this.flags) != (n11 = ((AdaptedFunctionReference)object).flags) || (n10 = (int)(f0.g(object3 = this.receiver, object2 = ((AdaptedFunctionReference)object).receiver) ? 1 : 0)) == 0 || (n10 = (int)(f0.g(object3 = this.owner, object2 = ((AdaptedFunctionReference)object).owner) ? 1 : 0)) == 0 || (n10 = (int)(((String)(object3 = this.name)).equals(object2 = ((AdaptedFunctionReference)object).name) ? 1 : 0)) == 0 || !(bl2 = ((String)(object3 = this.signature)).equals(object = ((AdaptedFunctionReference)object).signature))) {
            bl3 = false;
        }
        return bl3;
    }

    public int getArity() {
        return this.arity;
    }

    public h getOwner() {
        boolean bl2;
        Object object = this.owner;
        object = object == null ? null : ((bl2 = this.isTopLevel) ? n0.g((Class)object) : n0.d((Class)object));
        return object;
    }

    public int hashCode() {
        int n10;
        Object object = this.receiver;
        int n11 = 0;
        String string2 = null;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        n10 *= 31;
        Class clazz = this.owner;
        if (clazz != null) {
            n11 = clazz.hashCode();
        }
        n10 = (n10 + n11) * 31;
        n11 = this.name.hashCode();
        n10 = (n10 + n11) * 31;
        string2 = this.signature;
        n11 = string2.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.isTopLevel ? 1 : 0);
        n11 = n11 != 0 ? 1231 : 1237;
        n10 = (n10 + n11) * 31;
        n11 = this.arity;
        n10 = (n10 + n11) * 31;
        n11 = this.flags;
        return n10 + n11;
    }

    public String toString() {
        return n0.t(this);
    }
}

