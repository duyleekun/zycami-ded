/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.n;

public class c0 {
    private String a;
    private String b;
    private String c;

    public c0() {
    }

    public c0(String string2, String string3, String string4) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public void d(String string2) {
        this.c = string2;
    }

    public void e(String string2) {
        this.b = string2;
    }

    public boolean equals(Object object) {
        String string2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof c0;
        if (!bl3) {
            return false;
        }
        object = (c0)object;
        String string3 = this.a;
        if (string3 != null ? !(bl3 = string3.equals(string2 = ((c0)object).a)) : (string3 = ((c0)object).a) != null) {
            return false;
        }
        string3 = this.b;
        if (string3 != null ? !(bl3 = string3.equals(string2 = ((c0)object).b)) : (string3 = ((c0)object).b) != null) {
            return false;
        }
        string3 = this.c;
        object = ((c0)object).c;
        if (string3 != null) {
            bl2 = string3.equals(object);
        } else if (object != null) {
            bl2 = false;
        }
        return bl2;
    }

    public void f(String string2) {
        this.a = string2;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.a;
        int n12 = 0;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        n11 *= 31;
        String string3 = this.b;
        if (string3 != null) {
            n10 = string3.hashCode();
        } else {
            n10 = 0;
            string3 = null;
        }
        n11 = (n11 + n10) * 31;
        string3 = this.c;
        if (string3 != null) {
            n12 = string3.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DownloadInfo{url='");
        String string2 = this.a;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", folder='");
        String string3 = this.b;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", fileName='");
        string3 = this.c;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

