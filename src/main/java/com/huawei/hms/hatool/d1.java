/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.o;
import org.json.JSONObject;

public class d1
extends o {
    public String g = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String string2 = "1";
        jSONObject.put("protocol_version", (Object)string2);
        jSONObject.put("compress_mode", (Object)string2);
        String string3 = this.d;
        jSONObject.put("serviceid", (Object)string3);
        string3 = this.a;
        jSONObject.put("appid", (Object)string3);
        string3 = this.g;
        jSONObject.put("hmac", (Object)string3);
        string3 = this.f;
        jSONObject.put("chifer", (Object)string3);
        string3 = this.b;
        jSONObject.put("timestamp", (Object)string3);
        string3 = this.c;
        jSONObject.put("servicetag", (Object)string3);
        string3 = this.e;
        jSONObject.put("requestid", (Object)string3);
        return jSONObject;
    }

    public void g(String string2) {
        this.g = string2;
    }
}

