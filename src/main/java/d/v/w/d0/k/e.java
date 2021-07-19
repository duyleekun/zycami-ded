/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0.k;

import com.android.billingclient.api.SkuDetails;
import d.v.w.d0.k.k;
import java.util.Objects;

public final class e
extends k {
    private final String a;
    private final String b;
    private final String c;
    private final long d;
    private final String e;
    private final long f;
    private final String g;
    private final String h;
    private final SkuDetails i;

    public e(String string2, String string3, String string4, long l10, String string5, long l11, String string6, String string7, SkuDetails skuDetails) {
        Objects.requireNonNull(string2, "Null sku");
        this.a = string2;
        Objects.requireNonNull(string3, "Null skuType");
        this.b = string3;
        Objects.requireNonNull(string4, "Null price");
        this.c = string4;
        this.d = l10;
        Objects.requireNonNull(string5, "Null originalPrice");
        this.e = string5;
        this.f = l11;
        Objects.requireNonNull(string6, "Null priceCurrencyCode");
        this.g = string6;
        Objects.requireNonNull(string7, "Null purchases");
        this.h = string7;
        Objects.requireNonNull(skuDetails, "Null skuDetails");
        this.i = skuDetails;
    }

    public String a() {
        return this.g;
    }

    public String b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof k;
        if (bl3) {
            boolean bl4;
            long l10;
            long l11;
            long l12;
            long l13;
            Object object2 = this.a;
            String string2 = (object = (k)object).d();
            bl3 = ((String)object2).equals(string2);
            if (!(bl3 && (bl3 = ((String)(object2 = this.b)).equals(string2 = object.h())) && (bl3 = ((String)(object2 = this.c)).equals(string2 = object.b())) && !(bl3 = (l13 = (l12 = this.d) - (l11 = object.c())) == 0L ? 0 : (l13 < 0L ? -1 : 1)) && (bl3 = ((String)(object2 = this.e)).equals(string2 = object.e())) && !(bl3 = (l10 = (l12 = this.f) - (l11 = object.g())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) && (bl3 = ((String)(object2 = this.g)).equals(string2 = object.a())) && (bl3 = ((String)(object2 = this.h)).equals(string2 = object.f())) && (bl4 = ((SkuDetails)(object2 = this.i)).equals(object = ((k)object).k())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String f() {
        return this.h;
    }

    public long g() {
        return this.f;
    }

    public String h() {
        return this.b;
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.b.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.c.hashCode();
        n10 = (n10 ^ n12) * n11;
        long l10 = this.d;
        int n13 = 32;
        long l11 = l10 >>> n13;
        n12 = (int)(l10 ^ l11);
        n10 = (n10 ^ n12) * n11;
        n12 = this.e.hashCode();
        n10 = (n10 ^ n12) * n11;
        l10 = this.f;
        long l12 = l10 >>> n13;
        n12 = (int)(l10 ^ l12);
        n10 = (n10 ^ n12) * n11;
        n12 = this.g.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.h.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.i.hashCode();
        return n10 ^ n11;
    }

    public SkuDetails k() {
        return this.i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GoogleSku{sku=");
        Object object = this.a;
        stringBuilder.append((String)object);
        stringBuilder.append(", skuType=");
        object = this.b;
        stringBuilder.append((String)object);
        stringBuilder.append(", price=");
        object = this.c;
        stringBuilder.append((String)object);
        stringBuilder.append(", priceAmountMicros=");
        long l10 = this.d;
        stringBuilder.append(l10);
        stringBuilder.append(", originalPrice=");
        object = this.e;
        stringBuilder.append((String)object);
        stringBuilder.append(", originalPriceAmountMicros=");
        l10 = this.f;
        stringBuilder.append(l10);
        stringBuilder.append(", priceCurrencyCode=");
        object = this.g;
        stringBuilder.append((String)object);
        stringBuilder.append(", purchases=");
        object = this.h;
        stringBuilder.append((String)object);
        stringBuilder.append(", skuDetails=");
        object = this.i;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

