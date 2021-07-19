/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

public class SkuDetails {
    private final String a;
    private final JSONObject b;

    public SkuDetails(String object) {
        JSONObject jSONObject;
        this.a = object;
        this.b = jSONObject = new JSONObject((String)object);
        object = this.n();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = this.q();
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                return;
            }
            object = new IllegalArgumentException("SkuType cannot be empty.");
            throw object;
        }
        object = new IllegalArgumentException("SKU cannot be empty.");
        throw object;
    }

    public String a() {
        return this.b.optString("description");
    }

    public String b() {
        return this.b.optString("freeTrialPeriod");
    }

    public String c() {
        return this.b.optString("iconUrl");
    }

    public String d() {
        return this.b.optString("introductoryPrice");
    }

    public long e() {
        return this.b.optLong("introductoryPriceAmountMicros");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof SkuDetails;
        if (!bl2) {
            return false;
        }
        object = (SkuDetails)object;
        String string2 = this.a;
        object = ((SkuDetails)object).a;
        return TextUtils.equals((CharSequence)string2, (CharSequence)object);
    }

    public int f() {
        return this.b.optInt("introductoryPriceCycles");
    }

    public String g() {
        return this.b.optString("introductoryPricePeriod");
    }

    public String h() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String i() {
        JSONObject jSONObject = this.b;
        String string2 = "original_price";
        boolean bl2 = jSONObject.has(string2);
        if (bl2) {
            return this.b.optString(string2);
        }
        return this.k();
    }

    public long j() {
        JSONObject jSONObject = this.b;
        String string2 = "original_price_micros";
        boolean bl2 = jSONObject.has(string2);
        if (bl2) {
            return this.b.optLong(string2);
        }
        return this.l();
    }

    public String k() {
        return this.b.optString("price");
    }

    public long l() {
        return this.b.optLong("price_amount_micros");
    }

    public String m() {
        return this.b.optString("price_currency_code");
    }

    public String n() {
        return this.b.optString("productId");
    }

    public String o() {
        return this.b.optString("subscriptionPeriod");
    }

    public String p() {
        return this.b.optString("title");
    }

    public String q() {
        return this.b.optString("type");
    }

    public final String r() {
        return this.b.optString("packageName");
    }

    public final String s() {
        return this.b.optString("skuDetailsToken");
    }

    public String toString() {
        String string2 = String.valueOf(this.a);
        int n10 = string2.length();
        String string3 = "SkuDetails: ";
        if (n10 != 0) {
            return string3.concat(string2);
        }
        string2 = new String(string3);
        return string2;
    }
}

