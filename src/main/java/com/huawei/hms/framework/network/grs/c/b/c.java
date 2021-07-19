/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.network.grs.c.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b.b;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private GrsBaseInfo a;
    private Context b;
    private Set c;

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        HashSet hashSet;
        this.c = hashSet = new HashSet();
        this.a = grsBaseInfo;
        this.b = context;
    }

    private String e() {
        boolean bl2;
        Object[] objectArray = this.b.getPackageName();
        GrsBaseInfo grsBaseInfo = this.a;
        objectArray = com.huawei.hms.framework.network.grs.b.b.a((String)objectArray, grsBaseInfo).b();
        boolean bl3 = objectArray.isEmpty();
        String string2 = "";
        if (bl3) {
            return string2;
        }
        grsBaseInfo = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        objectArray = objectArray.iterator();
        while (bl2 = objectArray.hasNext()) {
            String string3 = (String)objectArray.next();
            jSONArray.put((Object)string3);
        }
        objectArray = "services";
        try {
            grsBaseInfo.put((String)objectArray, jSONArray);
        }
        catch (JSONException jSONException) {
            return string2;
        }
        objectArray = new Object[1];
        string2 = grsBaseInfo.toString();
        objectArray[0] = string2;
        Logger.i("GrsRequestInfo", "post service list is:%s", objectArray);
        return grsBaseInfo.toString();
    }

    private String f() {
        boolean bl2;
        String string2 = "GrsRequestInfo";
        Logger.v(string2, "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        Object[] objectArray = new JSONArray();
        Object object = this.c.iterator();
        while (bl2 = object.hasNext()) {
            String string3 = (String)object.next();
            objectArray.put((Object)string3);
        }
        object = "services";
        try {
            jSONObject.put((String)object, (Object)objectArray);
        }
        catch (JSONException jSONException) {
            return "";
        }
        object = jSONObject.toString();
        objectArray = new Object[]{object};
        Logger.v(string2, "post query service list is:%s", objectArray);
        return jSONObject.toString();
    }

    public Context a() {
        return this.b;
    }

    public void a(String string2) {
        this.c.add(string2);
    }

    public GrsBaseInfo b() {
        return this.a;
    }

    public String c() {
        Set set = this.c;
        int n10 = set.size();
        if (n10 == 0) {
            return this.e();
        }
        return this.f();
    }

    public Set d() {
        return this.c;
    }
}

