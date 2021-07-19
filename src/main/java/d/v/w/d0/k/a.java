/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0.k;

import d.v.w.d0.k.g;
import java.util.Objects;

public final class a
extends g {
    private final boolean a;
    private final String b;

    public a(boolean bl2, String string2) {
        this.a = bl2;
        Objects.requireNonNull(string2, "Null payPlatformOrderId");
        this.b = string2;
    }

    public boolean a() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof g;
        if (bl3) {
            String string2;
            boolean bl4;
            bl3 = this.a;
            boolean bl5 = (object = (g)object).a();
            if (bl3 != bl5 || !(bl4 = (string2 = this.b).equals(object = ((g)object).c()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.a;
        n10 = n10 != 0 ? 1231 : 1237;
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.b.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GoogleAfterPurchaseSuccessParam{renew=");
        boolean bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append(", payPlatformOrderId=");
        String string2 = this.b;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

