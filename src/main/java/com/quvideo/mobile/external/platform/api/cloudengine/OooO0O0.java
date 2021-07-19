/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.quvideo.mobile.external.platform.api.cloudengine;

import android.util.Log;
import com.google.gson.Gson;
import com.quvideo.mobile.external.platform.api.cloudengine.OooO00o;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeMakeRequest;
import com.quvideo.mobile.external.platform.httpcore.OooO;
import com.quvideo.mobile.external.platform.httpcore.OooO0OO;
import e.a.c1.b;
import e.a.h0;
import e.a.z;
import g.b0;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class OooO0O0 {
    public static z OooO00o(int n10, int n11, int n12) {
        Object object;
        String string2;
        JSONObject jSONObject;
        String string3 = "QuVideoHttpCore";
        try {
            jSONObject = new JSONObject();
            string2 = "pageSize";
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("CloudCompositeApiProxy->api/rest/fs/cloud/queryFileList->e=");
            String string4 = exception.getMessage();
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)object, (Throwable)exception);
            return z.m2(exception);
        }
        jSONObject.put(string2, n10);
        Object object2 = "pageNum";
        jSONObject.put((String)object2, n11);
        object2 = "fileType";
        jSONObject.put((String)object2, n12);
        object2 = new StringBuilder();
        object = "CloudCompositeApiProxy->api/rest/fs/cloud/queryFileList->content=";
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(jSONObject);
        object2 = ((StringBuilder)object2).toString();
        Log.d((String)string3, (String)object2);
        object2 = "api/rest/fs/cloud/queryFileList";
        object = OooO00o.class;
        object = OooO.OooO00o((Class)object, (String)object2);
        object = (OooO00o)object;
        object2 = OooO0OO.OooO00o((String)object2, jSONObject);
        object2 = object.OooO00o((b0)object2);
        object = b.d();
        return ((z)object2).L5((h0)object);
    }

    public static z OooO00o(CloudCompositeMakeRequest object) {
        Object object2;
        Object object3;
        String string2 = "QuVideoHttpCore";
        try {
            object3 = new Gson();
        }
        catch (Exception exception) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("CloudCompositeApiProxy->api/rest/fs/cloud/preEdit->e=");
            object2 = exception.getMessage();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            Log.e((String)string2, (String)object3, (Throwable)exception);
            return z.m2(exception);
        }
        object = ((Gson)object3).toJson(object);
        object3 = new JSONObject((String)object);
        object = new StringBuilder();
        object2 = "CloudCompositeApiProxy->api/rest/fs/cloud/preEdit->content=";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(object3);
        object = ((StringBuilder)object).toString();
        Log.d((String)string2, (String)object);
        object = "api/rest/fs/cloud/preEdit";
        object2 = OooO00o.class;
        object2 = OooO.OooO00o((Class)object2, (String)object);
        object2 = (OooO00o)object2;
        object = OooO0OO.OooO00o((String)object, (JSONObject)object3);
        object = object2.OooO0OO((b0)object);
        object3 = b.d();
        return ((z)object).L5((h0)object3);
    }

    public static z OooO00o(String object, boolean bl2) {
        Object object2;
        String string2;
        Object object3;
        String string3 = "QuVideoHttpCore";
        try {
            object3 = new JSONObject();
            string2 = "businessId";
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("CloudCompositeApiProxy->api/rest/fs/cloud/queryResult->e=");
            object3 = exception.getMessage();
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            Log.e((String)string3, (String)object2, (Throwable)exception);
            return z.m2(exception);
        }
        object3.put(string2, object);
        object = "lastQuery";
        object3.put((String)object, bl2);
        object = new StringBuilder();
        object2 = "CloudCompositeApiProxy->api/rest/fs/cloud/queryResult->content=";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(object3);
        object = ((StringBuilder)object).toString();
        Log.d((String)string3, (String)object);
        object = "api/rest/fs/cloud/queryResult";
        object2 = OooO00o.class;
        object2 = OooO.OooO00o((Class)object2, (String)object);
        object2 = (OooO00o)object2;
        object = OooO0OO.OooO00o((String)object, object3);
        object = object2.OooO0Oo((b0)object);
        object2 = b.d();
        return ((z)object).L5((h0)object2);
    }

    public static z OooO00o(List object) {
        Object object2;
        Object object3;
        String string2 = "QuVideoHttpCore";
        try {
            object3 = new JSONObject();
            object2 = "fileIdList";
        }
        catch (Exception exception) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("CloudCompositeApiProxy->api/rest/fs/cloud/report->e=");
            object2 = exception.getMessage();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            Log.e((String)string2, (String)object3, (Throwable)exception);
            return z.m2(exception);
        }
        JSONArray jSONArray = new JSONArray((Collection)object);
        object3.put((String)object2, (Object)jSONArray);
        object = new StringBuilder();
        object2 = "CloudCompositeApiProxy->api/rest/fs/cloud/report->content=";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(object3);
        object = ((StringBuilder)object).toString();
        Log.d((String)string2, (String)object);
        object = "api/rest/fs/cloud/report";
        object2 = OooO00o.class;
        object2 = OooO.OooO00o((Class)object2, (String)object);
        object2 = (OooO00o)object2;
        object = OooO0OO.OooO00o((String)object, (JSONObject)object3);
        object = object2.OooO0O0((b0)object);
        object3 = b.d();
        return ((z)object).L5((h0)object3);
    }
}

