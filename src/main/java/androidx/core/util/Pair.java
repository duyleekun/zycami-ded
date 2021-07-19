/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.util;

import androidx.core.util.ObjectsCompat;

public class Pair {
    public final Object first;
    public final Object second;

    public Pair(Object object, Object object2) {
        this.first = object;
        this.second = object2;
    }

    public static Pair create(Object object, Object object2) {
        Pair pair = new Pair(object, object2);
        return pair;
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
        bl3 = ObjectsCompat.equals(object2, object3);
        if (bl3 && (bl2 = ObjectsCompat.equals(object = ((Pair)object).second, object2 = this.second))) {
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        Object object = this.first;
        stringBuilder.append(object);
        stringBuilder.append(" ");
        object = this.second;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

