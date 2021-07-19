/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0.k;

import d.v.w.d0.k.l;
import java.util.Objects;

public final class f
extends l {
    private final boolean a;
    private final String b;
    private final String c;
    private final boolean d;
    private final boolean e;

    public f(boolean bl2, String string2, String string3, boolean bl3, boolean bl4) {
        this.a = bl2;
        Objects.requireNonNull(string2, "Null payPlatformSkuId");
        this.b = string2;
        Objects.requireNonNull(string3, "Null payPlatformOrderId");
        this.c = string3;
        this.d = bl3;
        this.e = bl4;
    }

    public boolean a() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.e;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof l;
        if (bl3) {
            boolean bl4;
            String string2;
            String string3;
            bl3 = this.a;
            boolean bl5 = (object = (l)object).a();
            if (bl3 != bl5 || !(bl3 = (string3 = this.b).equals(string2 = ((l)object).d())) || !(bl3 = (string3 = this.c).equals(string2 = ((l)object).c())) || (bl3 = this.d) != (bl5 = ((l)object).f()) || (bl3 = this.e) != (bl4 = ((l)object).e())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean f() {
        return this.d;
    }

    public int hashCode() {
        int n10 = this.a;
        int n11 = 1231;
        int n12 = 1237;
        float f10 = 1.733E-42f;
        n10 = n10 != 0 ? n11 : n12;
        int n13 = 1000003;
        n10 = (n10 ^ n13) * n13;
        int n14 = this.b.hashCode();
        n10 = (n10 ^ n14) * n13;
        String string2 = this.c;
        n14 = string2.hashCode();
        n10 = (n10 ^ n14) * n13;
        n14 = (int)(this.d ? 1 : 0);
        n14 = n14 != 0 ? n11 : n12;
        n10 = (n10 ^ n14) * n13;
        n13 = (int)(this.e ? 1 : 0);
        if (n13 == 0) {
            n11 = n12;
        }
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GoogleVerifyPurchaseResult{renew=");
        boolean bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append(", payPlatformSkuId=");
        String string2 = this.b;
        stringBuilder.append(string2);
        stringBuilder.append(", payPlatformOrderId=");
        string2 = this.c;
        stringBuilder.append(string2);
        stringBuilder.append(", subscribe=");
        bl2 = this.d;
        stringBuilder.append(bl2);
        stringBuilder.append(", consume=");
        bl2 = this.e;
        stringBuilder.append(bl2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

