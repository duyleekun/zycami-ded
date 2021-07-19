/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bj;
import com.xiaomi.push.l;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public String clientInterfaceId;
    private String miuiVersion;
    private String os;
    private String pkgName;
    public int production;
    public int reportType;
    private String sdkVersion;

    public a() {
        String string2;
        this.os = string2 = bj.a();
        this.miuiVersion = string2 = l.a();
    }

    public String getPackageName() {
        return this.pkgName;
    }

    public void setAppPackageName(String string2) {
        this.pkgName = string2;
    }

    public void setSdkVersion(String string2) {
        this.sdkVersion = string2;
    }

    public JSONObject toJson() {
        int n10;
        JSONObject jSONObject = new JSONObject();
        String string2 = "production";
        try {
            n10 = this.production;
        }
        catch (JSONException jSONException) {
            b.a(jSONException);
            return null;
        }
        jSONObject.put(string2, n10);
        string2 = "reportType";
        n10 = this.reportType;
        jSONObject.put(string2, n10);
        string2 = "clientInterfaceId";
        String string3 = this.clientInterfaceId;
        jSONObject.put(string2, (Object)string3);
        string2 = "os";
        string3 = this.os;
        jSONObject.put(string2, (Object)string3);
        string2 = "miuiVersion";
        string3 = this.miuiVersion;
        jSONObject.put(string2, (Object)string3);
        string2 = "pkgName";
        string3 = this.pkgName;
        jSONObject.put(string2, (Object)string3);
        string2 = "sdkVersion";
        string3 = this.sdkVersion;
        jSONObject.put(string2, (Object)string3);
        return jSONObject;
    }

    public String toJsonString() {
        Object object = this.toJson();
        object = object == null ? "" : object.toString();
        return object;
    }
}

