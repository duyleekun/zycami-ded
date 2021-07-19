/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.g;

import java.util.Objects;

public class g {
    private final String a;
    private String b;
    private String c;
    private String d;
    private String e;

    private g(String object) {
        String string2;
        this.b = string2 = "";
        this.c = string2;
        this.d = string2;
        this.e = string2;
        this.a = object;
        string2 = ",";
        object = object.split(string2);
        int n10 = ((String[])object).length;
        int n11 = 4;
        if (n10 >= n11) {
            string2 = object[0];
            this.j(string2);
            string2 = object[1];
            this.h(string2);
            string2 = object[2];
            this.g(string2);
            n10 = 3;
            object = object[n10];
            this.i((String)object);
        }
    }

    public static g a(String string2) {
        g g10 = new g(string2);
        return g10;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.a;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (g)object;
            object3 = this.a;
            object2 = ((g)object).a;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.b, object2 = ((g)object).b)) && (bl4 = Objects.equals(object3 = this.c, object2 = ((g)object).c)) && (bl4 = Objects.equals(object3 = this.d, object2 = ((g)object).d)) && (bl3 = Objects.equals(object3 = this.e, object = ((g)object).e)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String f() {
        return this.b;
    }

    public void g(String string2) {
        this.d = string2;
    }

    public void h(String string2) {
        this.c = string2;
    }

    public int hashCode() {
        Object[] objectArray = new Object[5];
        String string2 = this.a;
        objectArray[0] = string2;
        string2 = this.b;
        objectArray[1] = string2;
        string2 = this.c;
        objectArray[2] = string2;
        string2 = this.d;
        objectArray[3] = string2;
        string2 = this.e;
        objectArray[4] = string2;
        return Objects.hash(objectArray);
    }

    public void i(String string2) {
        this.e = string2;
    }

    public void j(String string2) {
        this.b = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.b;
        stringBuilder.append(string2);
        string2 = ",";
        stringBuilder.append(string2);
        String string3 = this.c;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string3 = this.d;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = this.e;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

