/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

import androidx.core.util.Pair;

public class MutablePair {
    public Object first;
    public Object second;

    private static boolean objectsEqual(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Pair;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        object = (Pair)object;
        Object object2 = ((Pair)object).first;
        Object object3 = this.first;
        bl3 = MutablePair.objectsEqual(object2, object3);
        if (bl3 && (bl2 = MutablePair.objectsEqual(object = ((Pair)object).second, object2 = this.second))) {
            bl4 = true;
        }
        return bl4;
    }

    public int hashCode() {
        int n10;
        Object object = this.first;
        int n11 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        Object object2 = this.second;
        if (object2 != null) {
            n11 = object2.hashCode();
        }
        return n10 ^ n11;
    }

    public void set(Object object, Object object2) {
        this.first = object;
        this.second = object2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        String string2 = String.valueOf(this.first);
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        string2 = String.valueOf(this.second);
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

