/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.geetest.sdk.model.beans;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class h {
    private Map a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private List h;
    private JSONObject i;

    public Map a() {
        return this.a;
    }

    public void a(String string2) {
        this.e = string2;
    }

    public void a(List list) {
        this.h = list;
    }

    public void a(Map map) {
        this.a = map;
    }

    public void a(JSONObject jSONObject) {
        this.i = jSONObject;
    }

    public JSONObject b() {
        return this.i;
    }

    public void b(String string2) {
        this.d = string2;
    }

    public void c(String string2) {
        this.g = string2;
    }

    public void d(String string2) {
        this.b = string2;
    }

    public void e(String string2) {
        this.c = string2;
    }

    public void f(String string2) {
        this.f = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GettypeBean{aspect_radio=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", type='");
        object = this.b;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", type_value='");
        String string2 = this.c;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", geetest='");
        string2 = this.d;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", click='");
        string2 = this.e;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", voice='");
        string2 = this.f;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", slide='");
        string2 = this.g;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", static_servers=");
        object = this.h;
        stringBuilder.append(object);
        stringBuilder.append(", jsonObject=");
        object = this.i;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

