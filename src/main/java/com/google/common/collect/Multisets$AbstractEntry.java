/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Multiset$Entry;

public abstract class Multisets$AbstractEntry
implements Multiset$Entry {
    public boolean equals(Object object) {
        int n10 = object instanceof Multiset$Entry;
        boolean bl2 = false;
        if (n10 != 0) {
            Object object2;
            boolean bl3;
            int n11;
            object = (Multiset$Entry)object;
            n10 = this.getCount();
            if (n10 == (n11 = object.getCount()) && (bl3 = Objects.equal(object2 = this.getElement(), object = object.getElement()))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        Object object = this.getElement();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        int n11 = this.getCount();
        return n10 ^ n11;
    }

    public String toString() {
        int n10;
        String string2 = String.valueOf(this.getElement());
        int n11 = this.getCount();
        if (n11 != (n10 = 1)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" x ");
            stringBuilder.append(n11);
            string2 = stringBuilder.toString();
        }
        return string2;
    }
}

