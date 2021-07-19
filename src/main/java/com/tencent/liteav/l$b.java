/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tencent.liteav;

import com.tencent.liteav.basic.log.TXCLog;
import org.json.JSONException;
import org.json.JSONObject;

public class l$b {
    public String a;
    public String b;

    public l$b() {
        String string2;
        this.a = string2 = "";
        this.b = string2;
    }

    public l$b(String string2, String string3) {
        String string4;
        this.a = string4 = "";
        this.b = string4;
        this.a = string2;
        this.b = string3;
    }

    public void a(String string2) {
        String string3 = "";
        Object object = new JSONObject(string2);
        string2 = "appid";
        string2 = object.optString(string2, string3);
        this.a = string2;
        string2 = "eventid";
        string2 = object.optString(string2, string3);
        try {
            this.b = string2;
        }
        catch (JSONException jSONException) {
            object = new StringBuilder();
            String string4 = "parseFromString: ";
            ((StringBuilder)object).append(string4);
            String string5 = jSONException.toString();
            ((StringBuilder)object).append(string5);
            string5 = ((StringBuilder)object).toString();
            object = "TXCVodPlayReportControl";
            TXCLog.i((String)object, string5);
            this.a = string3;
            this.b = string3;
        }
    }
}

