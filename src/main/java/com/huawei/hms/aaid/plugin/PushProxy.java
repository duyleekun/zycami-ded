/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONObject
 */
package com.huawei.hms.aaid.plugin;

import android.content.Context;
import d.j.d.a.k;
import org.json.JSONObject;

public interface PushProxy {
    public void deleteAllToken(Context var1);

    public void deleteToken(Context var1, String var2, String var3);

    public JSONObject getPlatform();

    public String getProxyType();

    public void getToken(Context var1, String var2, String var3);

    public k subscribe(Context var1, String var2, String var3);

    public k turnOff(Context var1, String var2);

    public k turnOn(Context var1, String var2);

    public k unsubscribe(Context var1, String var2, String var3);
}

