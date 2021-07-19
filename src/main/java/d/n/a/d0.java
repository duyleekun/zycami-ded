/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import d.n.a.d0$b;

public class d0 {
    private final Integer a;
    private final Integer b;
    private final Integer c;
    private final Boolean d;
    private final Boolean e;
    private final d0$b f;

    public d0(Integer n10, Integer n11, Integer n12, Boolean bl2, Boolean bl3, d0$b d0$b) {
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = bl2;
        this.e = bl3;
        this.f = d0$b;
    }

    public Integer a() {
        return this.a;
    }

    public d0$b b() {
        return this.f;
    }

    public Integer c() {
        return this.b;
    }

    public Boolean d() {
        return this.d;
    }

    public Boolean e() {
        return this.e;
    }

    public Integer f() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogOptions{logLevel=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", macAddressLogSetting=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(", uuidLogSetting=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", shouldLogAttributeValues=");
        object = this.d;
        stringBuilder.append(object);
        stringBuilder.append(", shouldLogScannedPeripherals=");
        object = this.e;
        stringBuilder.append(object);
        stringBuilder.append(", logger=");
        object = this.f;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

