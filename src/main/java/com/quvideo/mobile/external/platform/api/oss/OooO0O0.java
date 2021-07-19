/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  org.json.JSONObject
 */
package com.quvideo.mobile.external.platform.api.oss;

import android.util.Log;
import com.quvideo.mobile.external.platform.api.oss.OooO00o;
import com.quvideo.mobile.external.platform.httpcore.OooO;
import com.quvideo.mobile.external.platform.httpcore.OooO0OO;
import e.a.c1.b;
import e.a.h0;
import e.a.z;
import g.b0;
import org.json.JSONObject;

public class OooO0O0 {
    public static z OooO00o(JSONObject object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("OSSApiProxy->getOSSToken->content=");
        String string2 = object.toString();
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        string2 = "QuVideoHttpCore";
        Log.d((String)string2, (String)object2);
        object2 = "api/rest/fs/storage/getAccess";
        Object object3 = OooO00o.class;
        try {
            object3 = OooO.OooO00o(object3, (String)object2);
        }
        catch (Exception exception) {
            object2 = exception.getMessage();
            Log.e((String)string2, (String)object2);
            return z.m2(exception);
        }
        object3 = (OooO00o)object3;
        object = OooO0OO.OooO00o((String)object2, (JSONObject)object);
        object = object3.OooO00o((b0)object);
        object2 = b.d();
        return ((z)object).L5((h0)object2);
    }
}

