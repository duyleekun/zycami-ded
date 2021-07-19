/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.g;

import java.util.Objects;

public class h {
    private int a;
    private String b;
    private String c;

    public h(int n10, String string2, String string3) {
        this.a = n10;
        this.b = string2;
        this.c = string3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public h(String object) {
        String string2 = ",";
        String[] stringArray = ((String)object).split(string2);
        int n10 = 0;
        string2 = null;
        string2 = stringArray[0];
        n10 = Integer.parseInt(string2);
        this.a = n10;
        n10 = 1;
        string2 = stringArray[n10];
        this.b = string2;
        n10 = 2;
        String string3 = stringArray[n10];
        try {
            this.c = string3;
            return;
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException runtimeException) {
            return;
        }
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void d(int n10) {
        this.a = n10;
    }

    public void e(String string2) {
        this.b = string2;
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
            object = (h)object;
            int n10 = this.a;
            int n11 = ((h)object).a;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.b, object2 = ((h)object).b) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.c, object = ((h)object).c))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public void f(String string2) {
        this.c = string2;
    }

    public int hashCode() {
        Object object = this.a;
        Object[] objectArray = new Object[]{object, object = this.b, object = this.c};
        return Objects.hash(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewerInfo{control=");
        int c10 = this.a;
        stringBuilder.append(c10);
        stringBuilder.append(", deviceId='");
        String string2 = this.b;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", deviceName='");
        String string3 = this.c;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

