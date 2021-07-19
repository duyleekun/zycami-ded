/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.b0;
import f.h2.t.f0;
import f.h2.t.n0;
import f.m2.c;
import f.m2.h;
import f.m2.i;
import kotlin.jvm.internal.CallableReference;

public class FunctionReference
extends CallableReference
implements b0,
i {
    private final int arity;
    private final int flags;

    public FunctionReference(int n10) {
        Object object = CallableReference.NO_RECEIVER;
        this(n10, object, null, null, null, 0);
    }

    public FunctionReference(int n10, Object object) {
        this(n10, object, null, null, null, 0);
    }

    public FunctionReference(int n10, Object object, Class clazz, String string2, String string3, int n11) {
        int n12;
        int n13 = n11 & 1;
        int n14 = 1;
        if (n13 == n14) {
            n12 = n14;
        } else {
            n13 = 0;
            n12 = 0;
        }
        super(object, clazz, string2, string3, n12 != 0);
        this.arity = n10;
        this.flags = n10 = n11 >> 1;
    }

    public c computeReflected() {
        return n0.c(this);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof FunctionReference;
        if (n10 != 0) {
            boolean bl3;
            int n11;
            Object object2;
            object = (FunctionReference)object;
            Object object3 = this.getOwner();
            n10 = f0.g(object3, object2 = ((CallableReference)object).getOwner());
            if (n10 == 0 || (n10 = ((String)(object3 = this.getName())).equals(object2 = ((CallableReference)object).getName())) == 0 || (n10 = ((String)(object3 = this.getSignature())).equals(object2 = ((CallableReference)object).getSignature())) == 0 || (n10 = this.flags) != (n11 = ((FunctionReference)object).flags) || (n10 = this.arity) != (n11 = ((FunctionReference)object).arity) || !(bl3 = f0.g(object3 = this.getBoundReceiver(), object = ((CallableReference)object).getBoundReceiver()))) {
                bl2 = false;
                Object var8_8 = null;
            }
            return bl2;
        }
        bl2 = object instanceof i;
        if (bl2) {
            c c10 = this.compute();
            return object.equals(c10);
        }
        return false;
    }

    public int getArity() {
        return this.arity;
    }

    public i getReflected() {
        return (i)super.getReflected();
    }

    public int hashCode() {
        int n10;
        h h10 = this.getOwner();
        if (h10 == null) {
            n10 = 0;
            h10 = null;
        } else {
            h10 = this.getOwner();
            n10 = h10.hashCode() * 31;
        }
        int n11 = this.getName().hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.getSignature().hashCode();
        return n10 + n11;
    }

    public boolean isExternal() {
        return this.getReflected().isExternal();
    }

    public boolean isInfix() {
        return this.getReflected().isInfix();
    }

    public boolean isInline() {
        return this.getReflected().isInline();
    }

    public boolean isOperator() {
        return this.getReflected().isOperator();
    }

    public boolean isSuspend() {
        return this.getReflected().isSuspend();
    }

    public String toString() {
        Object object = this.compute();
        if (object != this) {
            return object.toString();
        }
        String string2 = "<init>";
        object = this.getName();
        boolean bl2 = string2.equals(object);
        if (bl2) {
            object = "constructor (Kotlin reflection is not available)";
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("function ");
            string2 = this.getName();
            ((StringBuilder)object).append(string2);
            string2 = " (Kotlin reflection is not available)";
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        return object;
    }
}

