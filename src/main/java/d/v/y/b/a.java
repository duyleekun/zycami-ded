/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.b;

public class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public a(int n10) {
        int n11 = n10 >>> 15;
        int n12 = (0xF000 & n10) >>> 12 & 7;
        int n13 = (n10 & 0xF00) >>> 8;
        int n14 = (n10 & 0xF0) >>> 4;
        int n15 = (n10 & 0xF) >>> 0;
        this.a = n11;
        this.b = n12;
        this.c = n13;
        this.d = n14;
        this.e = n15;
        this.f = n10;
    }

    public a(int n10, int n11, int n12, int n13) {
        int n14;
        this.a = 0;
        this.b = n14 = n10 & 0xF;
        this.c = n14 = n11 & 0xF;
        this.d = n14 = n12 & 0xF;
        this.e = n14 = n13 & 0xF;
        n13 = n13 << 0 | 0;
        n12 = n12 << 4 | n13;
        n11 = n11 << 8 | n12;
        this.f = n10 = n10 << 12 | n11 | 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{keyType=");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", keyGroup=");
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", keyEvent=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", keyValue=");
        n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

