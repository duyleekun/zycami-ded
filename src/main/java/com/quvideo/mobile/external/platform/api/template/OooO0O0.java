/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  org.json.JSONObject
 */
package com.quvideo.mobile.external.platform.api.template;

import android.util.Log;
import com.quvideo.mobile.external.platform.httpcore.OooO;
import com.quvideo.mobile.external.platform.httpcore.OooO0OO;
import d.o.a.a.b.a.a.a;
import e.a.c1.b;
import e.a.h0;
import e.a.z;
import g.b0;
import org.json.JSONObject;

public class OooO0O0 {
    public static z OooO00o(JSONObject object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("TemplateApiProxy->api/rest/fs/template/getTemplateList->content=");
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        String string2 = "QuVideoHttpCore";
        Log.d((String)string2, (String)object2);
        object2 = "api/rest/fs/template/getTemplateList";
        Object object3 = a.class;
        try {
            object3 = OooO.OooO00o(object3, (String)object2);
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("TemplateApiProxy->api/rest/fs/template/getTemplateList->e=");
            object3 = exception.getMessage();
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            Log.e((String)string2, (String)object2, (Throwable)exception);
            return z.m2(exception);
        }
        object3 = (a)object3;
        object = OooO0OO.OooO00o((String)object2, (JSONObject)object);
        object = object3.OooO00o((b0)object);
        object2 = b.d();
        return ((z)object).L5((h0)object2);
    }
}

