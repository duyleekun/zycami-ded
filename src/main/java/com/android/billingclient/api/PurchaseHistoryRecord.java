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

public class PurchaseHistoryRecord {
    private final String a;
    private final String b;
    private final JSONObject c;

    public PurchaseHistoryRecord(String string2, String string3) {
        this.a = string2;
        this.b = string3;
        super(string2);
        this.c = string3;
    }

    public String a() {
        return this.c.optString("developerPayload");
    }

    public String b() {
        return this.a;
    }

    public long c() {
        return this.c.optLong("purchaseTime");
    }

    public String d() {
        JSONObject jSONObject = this.c;
        String string2 = jSONObject.optString("purchaseToken");
        return jSONObject.optString("token", string2);
    }

    public String e() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof PurchaseHistoryRecord;
        if (!bl4) {
            return false;
        }
        String string2 = this.a;
        String string3 = ((PurchaseHistoryRecord)(object = (PurchaseHistoryRecord)object)).b();
        bl4 = TextUtils.equals((CharSequence)string2, (CharSequence)string3);
        if (bl4 && (bl2 = TextUtils.equals((CharSequence)(string2 = this.b), (CharSequence)(object = ((PurchaseHistoryRecord)object).e())))) {
            return bl3;
        }
        return false;
    }

    public String f() {
        return this.c.optString("productId");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        String string2 = String.valueOf(this.a);
        int n10 = string2.length();
        String string3 = "PurchaseHistoryRecord. Json: ";
        if (n10 != 0) {
            return string3.concat(string2);
        }
        string2 = new String(string3);
        return string2;
    }
}

