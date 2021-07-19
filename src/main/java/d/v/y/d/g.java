/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

public class g {
    public final Object a;
    public final Object b;

    public g(Object object, Object object2) {
        this.a = object;
        this.b = object2;
    }

    public static g a(Object object, Object object2) {
        g g10 = new g(object, object2);
        return g10;
    }

    private static boolean b(Object object, Object object2) {
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
        boolean bl3 = object instanceof g;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        object = (g)object;
        Object object2 = ((g)object).a;
        Object object3 = this.a;
        bl3 = g.b(object2, object3);
        if (bl3 && (bl2 = g.b(object = ((g)object).b, object2 = this.b))) {
            bl4 = true;
        }
        return bl4;
    }

    public int hashCode() {
        int n10;
        Object object = this.a;
        int n11 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        Object object2 = this.b;
        if (object2 != null) {
            n11 = object2.hashCode();
        }
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        String string2 = String.valueOf(this.a);
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        string2 = String.valueOf(this.b);
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

