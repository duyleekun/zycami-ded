/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.h2.t.f0;
import java.io.Serializable;

public final class Pair
implements Serializable {
    private final Object first;
    private final Object second;

    public Pair(Object object, Object object2) {
        this.first = object;
        this.second = object2;
    }

    public static /* synthetic */ Pair copy$default(Pair pair, Object object, Object object2, int n10, Object object3) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            object = pair.first;
        }
        if ((n10 &= 2) != 0) {
            object2 = pair.second;
        }
        return pair.copy(object, object2);
    }

    public final Object component1() {
        return this.first;
    }

    public final Object component2() {
        return this.second;
    }

    public final Pair copy(Object object, Object object2) {
        Pair pair = new Pair(object, object2);
        return pair;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                boolean bl2;
                if (this == object) break block2;
                boolean bl3 = object instanceof Pair;
                if (!bl3) break block3;
                object = (Pair)object;
                Object object2 = this.first;
                Object object3 = ((Pair)object).first;
                bl3 = f0.g(object2, object3);
                if (bl3 && (bl2 = f0.g(object2 = this.second, object = ((Pair)object).second))) break block2;
            }
            return false;
        }
        return true;
    }

    public final Object getFirst() {
        return this.first;
    }

    public final Object getSecond() {
        return this.second;
    }

    public int hashCode() {
        int n10;
        Object object = this.first;
        int n11 = 0;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        n10 *= 31;
        Object object2 = this.second;
        if (object2 != null) {
            n11 = object2.hashCode();
        }
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        Object object = this.first;
        stringBuilder.append(object);
        stringBuilder.append(", ");
        object = this.second;
        stringBuilder.append(object);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

