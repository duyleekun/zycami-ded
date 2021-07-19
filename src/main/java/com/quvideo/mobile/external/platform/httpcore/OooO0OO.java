/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.quvideo.mobile.external.platform.httpcore;

import com.quvideo.mobile.external.platform.httpcore.OooO0O0;
import g.b0;
import g.v;
import org.json.JSONObject;

public class OooO0OO
extends OooO0O0 {
    public static b0 OooO00o(String string2, JSONObject jSONObject) {
        return OooO0OO.OooO00o(string2, jSONObject, true);
    }

    public static b0 OooO00o(String object, JSONObject object2, boolean bl2) {
        String string2 = "POST";
        object = OooO0O0.OooO00o((String)object, string2);
        if (object2 != null) {
            string2 = "content";
            object.put(string2, object2);
        }
        object2 = new JSONObject();
        object2.put("business", object);
        object = v.j("application/json");
        object2 = object2.toString();
        return b0.create((v)object, (String)object2);
    }
}

