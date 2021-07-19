/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.android.billingclient.api;

import android.text.TextUtils;
import d.b.a.b.a;
import org.json.JSONObject;

public class Purchase {
    private final String a;
    private final String b;
    private final JSONObject c;

    public Purchase(String string2, String string3) {
        this.a = string2;
        this.b = string3;
        super(string2);
        this.c = string3;
    }

    public a a() {
        String string2 = this.c.optString("obfuscatedAccountId");
        Object object = this.c;
        Object object2 = "obfuscatedProfileId";
        object = object.optString((String)object2);
        if (string2 == null && object == null) {
            return null;
        }
        object2 = new a(string2, (String)object);
        return object2;
    }

    public String b() {
        return this.c.optString("developerPayload");
    }

    public String c() {
        return this.c.optString("orderId");
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.c.optString("packageName");
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof Purchase;
        if (!bl4) {
            return false;
        }
        String string2 = this.a;
        String string3 = ((Purchase)(object = (Purchase)object)).d();
        bl4 = TextUtils.equals((CharSequence)string2, (CharSequence)string3);
        if (bl4 && (bl2 = TextUtils.equals((CharSequence)(string2 = this.b), (CharSequence)(object = ((Purchase)object).i())))) {
            return bl3;
        }
        return false;
    }

    public int f() {
        int n10;
        JSONObject jSONObject = this.c;
        String string2 = "purchaseState";
        int n11 = 1;
        int n12 = jSONObject.optInt(string2, n11);
        if (n12 != (n10 = 4)) {
            return n11;
        }
        return 2;
    }

    public long g() {
        return this.c.optLong("purchaseTime");
    }

    public String h() {
        JSONObject jSONObject = this.c;
        String string2 = jSONObject.optString("purchaseToken");
        return jSONObject.optString("token", string2);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String i() {
        return this.b;
    }

    public String j() {
        return this.c.optString("productId");
    }

    public boolean k() {
        return this.c.optBoolean("acknowledged", true);
    }

    public boolean l() {
        return this.c.optBoolean("autoRenewing");
    }

    public String toString() {
        String string2 = String.valueOf(this.a);
        int n10 = string2.length();
        String string3 = "Purchase. Json: ";
        if (n10 != 0) {
            return string3.concat(string2);
        }
        string2 = new String(string3);
        return string2;
    }
}

