/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;

public final class ByFunctionOrdering
extends Ordering
implements Serializable {
    private static final long serialVersionUID;
    public final Function function;
    public final Ordering ordering;

    public ByFunctionOrdering(Function object, Ordering ordering) {
        object = (Function)Preconditions.checkNotNull(object);
        this.function = object;
        this.ordering = object = (Ordering)Preconditions.checkNotNull(ordering);
    }

    public int compare(Object object, Object object2) {
        Ordering ordering = this.ordering;
        object = this.function.apply(object);
        object2 = this.function.apply(object2);
        return ordering.compare(object, object2);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof ByFunctionOrdering;
        if (bl3) {
            boolean bl4;
            object = (ByFunctionOrdering)object;
            Object object2 = this.function;
            Function function = ((ByFunctionOrdering)object).function;
            bl3 = object2.equals(function);
            if (!bl3 || !(bl4 = (object2 = this.ordering).equals(object = ((ByFunctionOrdering)object).ordering))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.function;
        object = this.ordering;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.ordering;
        stringBuilder.append(object);
        stringBuilder.append(".onResultOf(");
        object = this.function;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

