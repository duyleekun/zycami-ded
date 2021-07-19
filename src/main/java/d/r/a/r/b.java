/*
 * Decompiled with CFR 0.151.
 */
package d.r.a.r;

public class b {
    public static final int d = 1;
    public static final int e = 2;
    private String a;
    private int b;
    private int c;

    public b(String string2, int n10, int n11) {
        this.a = string2;
        this.b = n10;
        this.c = n11;
    }

    public int a() {
        return this.c;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public void d(int n10) {
        this.c = n10;
    }

    public void e(String string2) {
        this.a = string2;
    }

    public boolean equals(Object object) {
        int n10;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object == null) {
            return false;
        }
        Object object3 = this.getClass();
        if (object3 != (object2 = object.getClass())) {
            return false;
        }
        object = (b)object;
        object3 = this.a;
        if (object3 == null ? (object3 = ((b)object).a) != null : (n10 = ((String)object3).equals(object2 = ((b)object).a)) == 0) {
            return false;
        }
        n10 = this.b;
        int n11 = ((b)object).b;
        if (n10 == n11) {
            return bl2;
        }
        return false;
    }

    public void f(int n10) {
        this.b = n10;
    }

    public int hashCode() {
        int n10;
        String string2 = this.a;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n10 = (n10 + 31) * 31;
        int n11 = this.b;
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubscribeAppInfo [mName=");
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append(", mTargetStatus=");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", mActualStatus=");
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

