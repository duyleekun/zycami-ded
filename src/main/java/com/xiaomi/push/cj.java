/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cj {
    public int a;
    public long a;
    private String a;
    public int b;
    public long b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cj2) {
        int n10;
        String string2;
        int n11;
        long l10;
        this.a = l10 = cj2.a;
        this.a = n11 = cj2.a;
        this.h = string2 = cj2.h;
        this.b = n11 = cj2.b;
        this.c = n11 = cj2.c;
        this.b = l10 = cj2.b;
        this.d = n11 = cj2.d;
        this.a = string2 = cj2.a;
        this.e = n10 = cj2.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        long l10 = this.a;
        bundle.putLong("id", l10);
        int n10 = this.a;
        bundle.putInt("showType", n10);
        n10 = this.b;
        bundle.putInt("nonsense", n10);
        n10 = this.c;
        bundle.putInt("receiveUpperBound", n10);
        l10 = this.b;
        bundle.putLong("lastShowTime", l10);
        n10 = this.e;
        bundle.putInt("multi", n10);
        return bundle;
    }

    public String a() {
        return this.a;
    }

    public void a(String string2) {
        this.a = string2;
    }

    public void a(JSONObject jSONObject) {
        int n10;
        int n11;
        long l10;
        this.a = l10 = jSONObject.optLong("id");
        this.a = n11 = jSONObject.optInt("showType");
        this.b = n11 = jSONObject.optInt("nonsense");
        this.c = n11 = jSONObject.optInt("receiveUpperBound");
        this.b = l10 = jSONObject.optLong("lastShowTime");
        this.e = n10 = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}

