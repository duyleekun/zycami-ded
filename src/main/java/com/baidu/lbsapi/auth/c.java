/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.lbsapi.auth.c$a;
import com.baidu.lbsapi.auth.d;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private Context a;
    private HashMap b = null;
    private c$a c = null;

    public c(Context context) {
        this.a = context;
    }

    public static /* synthetic */ Context a(c c10) {
        return c10.a;
    }

    private HashMap a(HashMap hashMap) {
        boolean bl2;
        HashMap hashMap2 = new HashMap();
        Iterator iterator2 = hashMap.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = ((String)iterator2.next()).toString();
            Object v10 = hashMap.get(string2);
            hashMap2.put(string2, v10);
        }
        return hashMap2;
    }

    public static /* synthetic */ void a(c c10, String string2) {
        c10.a(string2);
    }

    private void a(String object) {
        JSONObject jSONObject;
        String string2;
        block9: {
            string2 = "status";
            if (object == null) {
                object = "";
            }
            int n10 = -1;
            jSONObject = new JSONObject((String)object);
            boolean bl2 = jSONObject.has(string2);
            if (bl2) break block9;
            try {
                jSONObject.put(string2, n10);
            }
            catch (JSONException jSONException) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(string2, n10);
                }
                catch (JSONException jSONException2) {
                    jSONException2.printStackTrace();
                }
            }
        }
        if ((object = this.c) != null) {
            string2 = jSONObject.toString();
            object.a(string2);
        }
    }

    public static /* synthetic */ HashMap b(c c10) {
        return c10.b;
    }

    public void a(HashMap object, c$a object2) {
        object = this.a((HashMap)object);
        this.b = object;
        this.c = object2;
        object2 = new d(this);
        object = new Thread((Runnable)object2);
        ((Thread)object).start();
    }
}

