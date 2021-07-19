/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0.k;

import d.v.w.d0.k.h;
import java.util.Objects;

public final class b
extends h {
    private final String a;
    private final String b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public b(String string2, String string3, String string4, boolean bl2, boolean bl3, boolean bl4) {
        Objects.requireNonNull(string2, "Null skuId");
        this.a = string2;
        Objects.requireNonNull(string3, "Null orderSN");
        this.b = string3;
        this.c = string4;
        this.d = bl2;
        this.e = bl3;
        this.f = bl4;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean equals(Object object) {
        block4: {
            boolean bl2;
            block6: {
                block5: {
                    boolean bl3;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    boolean bl4 = object instanceof h;
                    if (!bl4) break block4;
                    String string2 = this.a;
                    String string3 = (object = (h)object).c();
                    bl4 = string2.equals(string3);
                    if (!bl4 || !(bl4 = (string2 = this.b).equals(string3 = object.a())) || !((string2 = this.c) == null ? (string2 = object.b()) == null : (bl4 = string2.equals(string3 = object.b())))) break block5;
                    bl4 = this.d;
                    boolean bl5 = object.d();
                    if (bl4 == bl5 && (bl4 = this.e) == (bl5 = object.e()) && (bl4 = this.f) == (bl3 = ((h)object).g())) break block6;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean g() {
        return this.f;
    }

    public int hashCode() {
        String string2 = this.a;
        int n10 = string2.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.b.hashCode();
        n10 = (n10 ^ n12) * n11;
        String string3 = this.c;
        if (string3 == null) {
            n12 = 0;
            string3 = null;
        } else {
            n12 = string3.hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        n12 = (int)(this.d ? 1 : 0);
        int n13 = 1231;
        int n14 = 1237;
        float f10 = 1.733E-42f;
        n12 = n12 != 0 ? n13 : n14;
        n10 = (n10 ^ n12) * n11;
        n12 = (int)(this.e ? 1 : 0);
        n12 = n12 != 0 ? n13 : n14;
        n10 = (n10 ^ n12) * n11;
        n11 = (int)(this.f ? 1 : 0);
        if (n11 == 0) {
            n13 = n14;
        }
        return n10 ^ n13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GoogleOrderParam{skuId=");
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append(", orderSN=");
        string2 = this.b;
        stringBuilder.append(string2);
        stringBuilder.append(", userId=");
        string2 = this.c;
        stringBuilder.append(string2);
        stringBuilder.append(", subscribe=");
        boolean bl2 = this.d;
        stringBuilder.append(bl2);
        stringBuilder.append(", consume=");
        bl2 = this.e;
        stringBuilder.append(bl2);
        stringBuilder.append(", userSubscribePlatform=");
        bl2 = this.f;
        stringBuilder.append(bl2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

