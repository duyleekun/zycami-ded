/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

public class i2$a {
    public int a;
    public String b;
    public String c;

    public i2$a(int n10, String string2, String string3) {
        this.a = n10;
        this.b = string2;
        this.c = string3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("result: ");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append("\nsuccessMsg: ");
        String string2 = this.b;
        stringBuilder.append(string2);
        stringBuilder.append("\nerrorMsg: ");
        string2 = this.c;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

