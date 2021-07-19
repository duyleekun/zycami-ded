/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import d.n.a.j0;
import d.n.a.q0.t.b;

public class m0 {
    private final j0 a;
    private final int b;
    private final byte[] c;

    public m0(j0 j02, int n10, byte[] byArray) {
        this.a = j02;
        this.b = n10;
        this.c = byArray;
    }

    public j0 a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxBleScanResult{bleDevice=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", rssi=");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", scanRecord=");
        object = d.n.a.q0.t.b.a(this.c);
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

