/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.h2.t.f0;
import java.io.Serializable;

public final class Triple
implements Serializable {
    private final Object first;
    private final Object second;
    private final Object third;

    public Triple(Object object, Object object2, Object object3) {
        this.first = object;
        this.second = object2;
        this.third = object3;
    }

    public static /* synthetic */ Triple copy$default(Triple triple, Object object, Object object2, Object object3, int n10, Object object4) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            object = triple.first;
        }
        if ((n11 = n10 & 2) != 0) {
            object2 = triple.second;
        }
        if ((n10 &= 4) != 0) {
            object3 = triple.third;
        }
        return triple.copy(object, object2, object3);
    }

    public final Object component1() {
        return this.first;
    }

    public final Object component2() {
        return this.second;
    }

    public final Object component3() {
        return this.third;
    }

    public final Triple copy(Object object, Object object2, Object object3) {
        Triple triple = new Triple(object, object2, object3);
        return triple;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                boolean bl2;
                if (this == object) break block2;
                boolean bl3 = object instanceof Triple;
                if (!bl3) break block3;
                object = (Triple)object;
                Object object2 = this.first;
                Object object3 = ((Triple)object).first;
                bl3 = f0.g(object2, object3);
                if (bl3 && (bl3 = f0.g(object2 = this.second, object3 = ((Triple)object).second)) && (bl2 = f0.g(object2 = this.third, object = ((Triple)object).third))) break block2;
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

    public final Object getThird() {
        return this.third;
    }

    public int hashCode() {
        int n10;
        int n11;
        Object object = this.first;
        int n12 = 0;
        if (object != null) {
            n11 = object.hashCode();
        } else {
            n11 = 0;
            object = null;
        }
        n11 *= 31;
        Object object2 = this.second;
        if (object2 != null) {
            n10 = object2.hashCode();
        } else {
            n10 = 0;
            object2 = null;
        }
        n11 = (n11 + n10) * 31;
        object2 = this.third;
        if (object2 != null) {
            n12 = object2.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        Object object = this.first;
        stringBuilder.append(object);
        object = ", ";
        stringBuilder.append((String)object);
        Object object2 = this.second;
        stringBuilder.append(object2);
        stringBuilder.append((String)object);
        object = this.third;
        stringBuilder.append(object);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

