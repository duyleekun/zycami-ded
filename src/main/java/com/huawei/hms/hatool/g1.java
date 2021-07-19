/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.hatool;

import android.content.Context;
import com.huawei.hms.hatool.h0;
import com.huawei.hms.hatool.y;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g1 {
    public static g1 c;
    public Context a;
    public final Object b;

    public g1() {
        Object object;
        this.b = object = new Object();
    }

    public static g1 a() {
        g1 g12 = c;
        if (g12 == null) {
            g1.b();
        }
        return c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b() {
        Class<g1> clazz = g1.class;
        synchronized (clazz) {
            g1 g12 = c;
            if (g12 == null) {
                c = g12 = new g1();
            }
            return;
        }
    }

    public final JSONObject a(Map iterator2) {
        JSONObject jSONObject = new JSONObject();
        if (iterator2 != null) {
            Object object;
            iterator2 = iterator2.entrySet();
            try {
                iterator2 = iterator2.iterator();
            }
            catch (JSONException jSONException) {
                iterator2 = "hmsSdk";
                object = "Exception occured when transferring bundle to json";
                y.b(iterator2, (String)object);
            }
            while (true) {
                boolean bl2 = iterator2.hasNext();
                if (!bl2) break;
                object = iterator2.next();
                object = (Map.Entry)object;
                Object object2 = object.getKey();
                object2 = (String)object2;
                object = object.getValue();
                jSONObject.put(object2, object);
                continue;
                break;
            }
        }
        return jSONObject;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Context context) {
        Object object = this.b;
        synchronized (object) {
            Object object2 = this.a;
            if (object2 != null) {
                return;
            }
            this.a = context;
            object2 = h0.a();
            ((h0)object2).a(context);
            return;
        }
    }

    public void a(String string2, int n10) {
        h0.a().a(string2, n10);
    }

    public void a(String string2, int n10, String string3, LinkedHashMap linkedHashMap) {
        linkedHashMap = this.a(linkedHashMap);
        h0.a().a(string2, n10, string3, (JSONObject)linkedHashMap);
    }

    public void a(String string2, Context context, String string3, String string4) {
        context = new JSONObject();
        String string5 = "_constants";
        try {
            context.put(string5, (Object)string4);
            h0.a().a(string2, 0, string3, (JSONObject)context);
            return;
        }
        catch (JSONException jSONException) {
            y.f("hmsSdk", "onEvent():JSON structure Exception!");
            return;
        }
    }
}

