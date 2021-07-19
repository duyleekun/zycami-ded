/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorMessage {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(int n10, String string2) {
        String string3;
        JSONObject jSONObject = new JSONObject();
        String string4 = "status";
        try {
            jSONObject.put(string4, n10);
            string3 = "message";
        }
        catch (JSONException jSONException) {
            return jSONObject.toString();
        }
        jSONObject.put(string3, (Object)string2);
        return jSONObject.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(String string2) {
        JSONObject jSONObject = new JSONObject();
        String string3 = "status";
        int n10 = -1;
        try {
            jSONObject.put(string3, n10);
            string3 = "message";
        }
        catch (JSONException jSONException) {
            return jSONObject.toString();
        }
        jSONObject.put(string3, (Object)string2);
        return jSONObject.toString();
    }
}

