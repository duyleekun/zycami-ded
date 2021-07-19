/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.n;
import org.json.JSONObject;

public class c1
extends n {
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public c1() {
        String string2;
        this.b = string2 = "";
        this.c = string2;
        this.d = string2;
        this.e = string2;
        this.f = string2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String string2 = this.a;
        jSONObject.put("androidid", (Object)string2);
        string2 = this.g;
        jSONObject.put("oaid", (Object)string2);
        string2 = this.f;
        jSONObject.put("uuid", (Object)string2);
        string2 = this.e;
        jSONObject.put("upid", (Object)string2);
        string2 = this.b;
        jSONObject.put("imei", (Object)string2);
        string2 = this.c;
        jSONObject.put("sn", (Object)string2);
        string2 = this.d;
        jSONObject.put("udid", (Object)string2);
        return jSONObject;
    }

    public void b(String string2) {
        this.b = string2;
    }

    public void c(String string2) {
        this.g = string2;
    }

    public void d(String string2) {
        this.c = string2;
    }

    public void e(String string2) {
        this.d = string2;
    }

    public void f(String string2) {
        this.e = string2;
    }

    public void g(String string2) {
        this.f = string2;
    }
}

