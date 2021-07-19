/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0.k;

import d.b.a.b.g;
import d.v.w.d0.k.i;
import java.util.Objects;

public final class c
extends i {
    private final String a;
    private final String b;
    private final String c;
    private final g d;

    public c(String string2, String string3, String string4, g g10) {
        Objects.requireNonNull(string2, "Null orderSn");
        this.a = string2;
        this.b = string3;
        Objects.requireNonNull(string4, "Null skuId");
        this.c = string4;
        Objects.requireNonNull(g10, "Null billingFlowParams");
        this.d = g10;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public g d() {
        return this.d;
    }

    public String e() {
        return this.c;
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
                    boolean bl4 = object instanceof i;
                    if (!bl4) break block4;
                    Object object2 = this.a;
                    String string2 = (object = (i)object).a();
                    bl4 = ((String)object2).equals(string2);
                    if (!bl4 || !((object2 = this.b) == null ? (object2 = object.b()) == null : (bl4 = ((String)object2).equals(string2 = object.b())))) break block5;
                    object2 = this.c;
                    string2 = ((i)object).e();
                    bl4 = ((String)object2).equals(string2);
                    if (bl4 && (bl3 = (object2 = this.d).equals(object = ((i)object).d()))) break block6;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.a;
        int n11 = string2.hashCode();
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        String string3 = this.b;
        if (string3 == null) {
            n10 = 0;
            string3 = null;
        } else {
            n10 = string3.hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        n10 = this.c.hashCode();
        n11 = (n11 ^ n10) * n12;
        n12 = this.d.hashCode();
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GooglePayFlowParams{orderSn=");
        Object object = this.a;
        stringBuilder.append((String)object);
        stringBuilder.append(", userId=");
        object = this.b;
        stringBuilder.append((String)object);
        stringBuilder.append(", skuId=");
        object = this.c;
        stringBuilder.append((String)object);
        stringBuilder.append(", billingFlowParams=");
        object = this.d;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

