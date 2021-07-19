/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0.k;

import com.zhiyun.common.exception.ValueException$b;
import d.v.w.d0.k.j;

public final class d
extends j {
    private final boolean a;
    private final boolean b;
    private final String c;
    private final ValueException$b d;
    private final boolean e;
    private final String f;
    private final String g;
    private final String h;

    public d(boolean bl2, boolean bl3, String string2, ValueException$b valueException$b, boolean bl4, String string3, String string4, String string5) {
        this.a = bl2;
        this.b = bl3;
        this.c = string2;
        this.d = valueException$b;
        this.e = bl4;
        this.f = string3;
        this.g = string4;
        this.h = string5;
    }

    public String a() {
        return this.c;
    }

    public ValueException$b b() {
        return this.d;
    }

    public boolean c() {
        return this.a;
    }

    public String e() {
        return this.h;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof j;
        if (bl3) {
            boolean bl4;
            Object object2;
            Object object3;
            bl3 = this.a;
            boolean bl5 = (object = (j)object).c();
            if (!(bl3 == bl5 && (bl3 = this.b) == (bl5 = object.isSuccessful()) && ((object3 = this.c) == null ? (object3 = object.a()) == null : (bl3 = ((String)object3).equals(object2 = object.a()))) && ((object3 = this.d) == null ? (object3 = object.b()) == null : (bl3 = object3.equals(object2 = object.b()))) && (bl3 = this.e) == (bl5 = ((j)object).h()) && ((object3 = this.f) == null ? (object3 = ((j)object).f()) == null : (bl3 = ((String)object3).equals(object2 = ((j)object).f()))) && ((object3 = this.g) == null ? (object3 = ((j)object).g()) == null : (bl3 = ((String)object3).equals(object2 = ((j)object).g()))) && ((object3 = this.h) == null ? (object = ((j)object).e()) == null : (bl4 = ((String)object3).equals(object = ((j)object).e()))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public boolean h() {
        return this.e;
    }

    public int hashCode() {
        int n10 = this.a;
        int n11 = 1231;
        int n12 = 1237;
        float f10 = 1.733E-42f;
        n10 = n10 != 0 ? n11 : n12;
        int n13 = 1000003;
        n10 = (n10 ^ n13) * n13;
        int n14 = this.b;
        n14 = n14 != 0 ? n11 : n12;
        n10 = (n10 ^ n14) * n13;
        Object object = this.c;
        int n15 = 0;
        if (object == null) {
            n14 = 0;
            object = null;
        } else {
            n14 = ((String)object).hashCode();
        }
        n10 = (n10 ^ n14) * n13;
        object = this.d;
        if (object == null) {
            n14 = 0;
            object = null;
        } else {
            n14 = object.hashCode();
        }
        n10 = (n10 ^ n14) * n13;
        n14 = (int)(this.e ? 1 : 0);
        if (n14 == 0) {
            n11 = n12;
        }
        n10 = (n10 ^ n11) * n13;
        String string2 = this.f;
        if (string2 == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = string2.hashCode();
        }
        n10 = (n10 ^ n11) * n13;
        string2 = this.g;
        if (string2 == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = string2.hashCode();
        }
        n10 = (n10 ^ n11) * n13;
        string2 = this.h;
        if (string2 != null) {
            n15 = string2.hashCode();
        }
        return n10 ^ n15;
    }

    public boolean isSuccessful() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GooglePayPurchase{background=");
        boolean bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append(", successful=");
        bl2 = this.b;
        stringBuilder.append(bl2);
        stringBuilder.append(", orderSN=");
        Object object = this.c;
        stringBuilder.append((String)object);
        stringBuilder.append(", failPurchaseResult=");
        object = this.d;
        stringBuilder.append(object);
        stringBuilder.append(", needAcknowledged=");
        bl2 = this.e;
        stringBuilder.append(bl2);
        stringBuilder.append(", purchaseToken=");
        object = this.f;
        stringBuilder.append((String)object);
        stringBuilder.append(", signData=");
        object = this.g;
        stringBuilder.append((String)object);
        stringBuilder.append(", originalData=");
        object = this.h;
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

