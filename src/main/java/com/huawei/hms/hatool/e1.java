/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  org.json.JSONObject
 */
package com.huawei.hms.hatool;

import android.os.Build;
import com.huawei.hms.hatool.p;
import org.json.JSONObject;

public class e1
extends p {
    public String f;
    public String g;
    public String h;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String string2 = this.h;
        jSONObject.put("_rom_ver", (Object)string2);
        string2 = this.a;
        jSONObject.put("_emui_ver", (Object)string2);
        string2 = Build.MODEL;
        jSONObject.put("_model", (Object)string2);
        string2 = this.f;
        jSONObject.put("_mcc", (Object)string2);
        string2 = this.g;
        jSONObject.put("_mnc", (Object)string2);
        string2 = this.b;
        jSONObject.put("_package_name", (Object)string2);
        string2 = this.c;
        jSONObject.put("_app_ver", (Object)string2);
        jSONObject.put("_lib_ver", (Object)"2.2.0.308");
        string2 = this.d;
        jSONObject.put("_channel", (Object)string2);
        jSONObject.put("_lib_name", (Object)"hianalytics");
        string2 = this.e;
        jSONObject.put("_oaid_tracking_flag", (Object)string2);
        return jSONObject;
    }

    public void f(String string2) {
        this.f = string2;
    }

    public void g(String string2) {
        this.g = string2;
    }

    public void h(String string2) {
        this.h = string2;
    }
}

