/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.MapDifference$ValueDifference;

public class Maps$ValueDifferenceImpl
implements MapDifference$ValueDifference {
    private final Object left;
    private final Object right;

    private Maps$ValueDifferenceImpl(Object object, Object object2) {
        this.left = object;
        this.right = object2;
    }

    public static MapDifference$ValueDifference create(Object object, Object object2) {
        Maps$ValueDifferenceImpl maps$ValueDifferenceImpl = new Maps$ValueDifferenceImpl(object, object2);
        return maps$ValueDifferenceImpl;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3 = object instanceof MapDifference$ValueDifference;
        boolean bl4 = false;
        if (bl3 && (bl3 = Objects.equal(object3 = this.left, object2 = (object = (MapDifference$ValueDifference)object).leftValue())) && (bl2 = Objects.equal(object3 = this.right, object = object.rightValue()))) {
            bl4 = true;
        }
        return bl4;
    }

    public int hashCode() {
        Object object = this.left;
        object = this.right;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }

    public Object leftValue() {
        return this.left;
    }

    public Object rightValue() {
        return this.right;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        Object object = this.left;
        stringBuilder.append(object);
        stringBuilder.append(", ");
        object = this.right;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

