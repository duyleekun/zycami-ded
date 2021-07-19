/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hms.hatool.d;
import com.huawei.hms.hatool.d0;
import com.huawei.hms.hatool.s;
import org.json.JSONObject;

public class q
implements s {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String string2 = this.a;
        jSONObject.put("type", (Object)string2);
        string2 = this.d;
        jSONObject.put("eventtime", (Object)string2);
        string2 = this.b;
        jSONObject.put("event", (Object)string2);
        string2 = this.e;
        jSONObject.put("event_session_name", (Object)string2);
        string2 = this.f;
        String string3 = "first_session_event";
        jSONObject.put(string3, (Object)string2);
        string2 = this.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        string3 = this.c;
        string2 = new JSONObject(string3);
        jSONObject.put("properties", (Object)string2);
        return jSONObject;
    }

    public void a(String string2) {
        this.c = string2;
    }

    public void a(JSONObject object) {
        String string2;
        if (object == null) {
            return;
        }
        this.b = string2 = object.optString("event");
        this.c = string2 = object.optString("properties");
        string2 = d0.f().a();
        this.c = string2 = com.huawei.hms.hatool.d.a(this.c, string2);
        this.a = string2 = object.optString("type");
        this.d = string2 = object.optString("eventtime");
        this.e = string2 = object.optString("event_session_name");
        object = object.optString("first_session_event");
        this.f = object;
    }

    public String b() {
        return this.d;
    }

    public void b(String string2) {
        this.b = string2;
    }

    public String c() {
        return this.a;
    }

    public void c(String string2) {
        this.d = string2;
    }

    public JSONObject d() {
        JSONObject jSONObject = this.a();
        String string2 = d0.f().a();
        string2 = com.huawei.hms.hatool.d.b(this.c, string2);
        jSONObject.put("properties", (Object)string2);
        return jSONObject;
    }

    public void d(String string2) {
        this.a = string2;
    }

    public void e(String string2) {
        this.f = string2;
    }

    public void f(String string2) {
        this.e = string2;
    }
}

