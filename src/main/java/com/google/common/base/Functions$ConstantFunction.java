/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.io.Serializable;

public class Functions$ConstantFunction
implements Function,
Serializable {
    private static final long serialVersionUID;
    private final Object value;

    public Functions$ConstantFunction(Object object) {
        this.value = object;
    }

    public Object apply(Object object) {
        return this.value;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Functions$ConstantFunction;
        if (bl2) {
            object = (Functions$ConstantFunction)object;
            Object object2 = this.value;
            object = ((Functions$ConstantFunction)object).value;
            return Objects.equal(object2, object);
        }
        return false;
    }

    public int hashCode() {
        int n10;
        Object object = this.value;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        return n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Functions.constant(");
        Object object = this.value;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

