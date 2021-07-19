/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

import java.util.Objects;

public final class i {
    private final Comparable a;
    private final Comparable b;

    public i(Comparable object, Comparable comparable) {
        Objects.requireNonNull(object, "lower must not be null");
        Comparable comparable2 = object;
        this.a = comparable2 = object;
        Objects.requireNonNull(comparable, "upper must not be null");
        comparable2 = comparable;
        this.b = comparable2 = comparable;
        int n10 = object.compareTo(comparable);
        if (n10 <= 0) {
            return;
        }
        object = new IllegalArgumentException("lower must be less than or equal to upper");
        throw object;
    }

    public static i d(Comparable comparable, Comparable comparable2) {
        i i10 = new i(comparable, comparable2);
        return i10;
    }

    public Comparable a(Comparable comparable) {
        Objects.requireNonNull(comparable, "value must not be null");
        Comparable comparable2 = this.a;
        int n10 = comparable.compareTo(comparable2);
        if (n10 < 0) {
            return this.a;
        }
        comparable2 = this.b;
        n10 = comparable.compareTo(comparable2);
        if (n10 > 0) {
            comparable = this.b;
        }
        return comparable;
    }

    /*
     * WARNING - void declaration
     */
    public boolean b(i object) {
        void var7_13;
        void var4_7;
        Objects.requireNonNull(object, "value must not be null");
        Comparable comparable = ((i)object).a;
        Comparable comparable2 = this.a;
        int bl2 = comparable.compareTo(comparable2);
        boolean bl3 = true;
        if (bl2 >= 0) {
            boolean bl4 = bl3;
        } else {
            boolean bl5 = false;
            comparable = null;
        }
        object = ((i)object).b;
        Comparable comparable3 = this.b;
        int n10 = object.compareTo(comparable3);
        if (n10 <= 0) {
            boolean bl6 = bl3;
        } else {
            boolean bl7 = false;
            object = null;
        }
        if (var4_7 == false || var7_13 == false) {
            bl3 = false;
            comparable2 = null;
        }
        return bl3;
    }

    /*
     * WARNING - void declaration
     */
    public boolean c(Comparable comparable) {
        void var6_12;
        void var3_6;
        Objects.requireNonNull(comparable, "value must not be null");
        Comparable comparable2 = this.a;
        int bl2 = comparable.compareTo(comparable2);
        boolean bl3 = true;
        if (bl2 >= 0) {
            boolean bl4 = bl3;
        } else {
            boolean bl5 = false;
            comparable2 = null;
        }
        Comparable comparable3 = this.b;
        int n10 = comparable.compareTo(comparable3);
        if (n10 <= 0) {
            boolean bl6 = bl3;
        } else {
            boolean bl7 = false;
            comparable = null;
        }
        if (var3_6 == false || var6_12 == false) {
            bl3 = false;
        }
        return bl3;
    }

    public i e(i object) {
        Objects.requireNonNull(object, "range must not be null");
        Comparable comparable = ((i)object).a;
        Comparable comparable2 = this.a;
        int n10 = comparable.compareTo(comparable2);
        comparable2 = ((i)object).b;
        Comparable comparable3 = this.b;
        int n11 = comparable2.compareTo(comparable3);
        if (n10 <= 0 && n11 >= 0) {
            return object;
        }
        if (n10 >= 0 && n11 <= 0) {
            return this;
        }
        comparable = n10 >= 0 ? this.a : ((i)object).a;
        object = n11 <= 0 ? this.b : ((i)object).b;
        return i.d(comparable, (Comparable)object);
    }

    public boolean equals(Object object) {
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof i;
        if (bl4) {
            boolean bl5;
            object = (i)object;
            Comparable comparable = this.a;
            Comparable comparable2 = ((i)object).a;
            bl4 = comparable.equals(comparable2);
            if (bl4 && (bl5 = (comparable = this.b).equals(object = ((i)object).b))) {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    public i f(Comparable comparable) {
        Objects.requireNonNull(comparable, "value must not be null");
        return this.g(comparable, comparable);
    }

    public i g(Comparable comparable, Comparable comparable2) {
        Objects.requireNonNull(comparable, "lower must not be null");
        Objects.requireNonNull(comparable2, "upper must not be null");
        Comparable comparable3 = this.a;
        int n10 = comparable.compareTo(comparable3);
        Comparable comparable4 = this.b;
        int n11 = comparable2.compareTo(comparable4);
        if (n10 >= 0 && n11 <= 0) {
            return this;
        }
        if (n10 >= 0) {
            comparable = this.a;
        }
        if (n11 <= 0) {
            comparable2 = this.b;
        }
        return i.d(comparable, comparable2);
    }

    public Comparable h() {
        return this.a;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Comparable comparable = this.a;
        objectArray[0] = comparable;
        comparable = this.b;
        objectArray[1] = comparable;
        return Objects.hash(objectArray);
    }

    public Comparable i() {
        return this.b;
    }

    public i j(i object) {
        Objects.requireNonNull(object, "range must not be null");
        Comparable comparable = ((i)object).a;
        Comparable comparable2 = this.a;
        int n10 = comparable.compareTo(comparable2);
        comparable2 = ((i)object).b;
        Comparable comparable3 = this.b;
        int n11 = comparable2.compareTo(comparable3);
        if (n10 <= 0 && n11 >= 0) {
            return this;
        }
        if (n10 >= 0 && n11 <= 0) {
            return object;
        }
        comparable = n10 <= 0 ? this.a : ((i)object).a;
        object = n11 >= 0 ? this.b : ((i)object).b;
        return i.d(comparable, (Comparable)object);
    }

    public i k(Comparable comparable, Comparable comparable2) {
        Objects.requireNonNull(comparable, "lower must not be null");
        Objects.requireNonNull(comparable2, "upper must not be null");
        Comparable comparable3 = this.a;
        int n10 = comparable.compareTo(comparable3);
        Comparable comparable4 = this.b;
        int n11 = comparable2.compareTo(comparable4);
        if (n10 <= 0 && n11 >= 0) {
            return this;
        }
        if (n10 <= 0) {
            comparable = this.a;
        }
        if (n11 >= 0) {
            comparable2 = this.b;
        }
        return i.d(comparable, comparable2);
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        Comparable comparable = this.a;
        objectArray[0] = comparable;
        comparable = this.b;
        objectArray[1] = comparable;
        return String.format("[%s, %s]", objectArray);
    }
}

