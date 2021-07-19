/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

public class h0 {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int h;

    public int a() {
        return this.g;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.h;
    }

    public String e() {
        return this.a;
    }

    public int f() {
        return this.f;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.b;
    }

    public void i(int n10) {
        this.g = n10;
    }

    public void j(String string2) {
        this.d = string2;
    }

    public void k(String string2) {
        this.c = string2;
    }

    public void l(int n10) {
        this.h = n10;
    }

    public void m(String string2) {
        this.a = string2;
    }

    public void n(int n10) {
        this.f = n10;
    }

    public void o(String string2) {
        this.e = string2;
    }

    public void p(String string2) {
        this.b = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CEUpLoadCloudLogInfo{startedAt='");
        String string2 = this.a;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", version='");
        String string3 = this.b;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", longitude='");
        string3 = this.c;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", latitude='");
        string3 = this.d;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", url='");
        string3 = this.e;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", status=");
        n10 = this.f;
        stringBuilder.append(n10);
        stringBuilder.append(", duration=");
        n10 = this.g;
        stringBuilder.append(n10);
        stringBuilder.append(", operation=");
        n10 = this.h;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

