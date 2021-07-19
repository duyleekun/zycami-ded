/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.network.grs.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.b.d;
import com.huawei.hms.framework.network.grs.d.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static final String a = "a";
    private static d b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d a(Context object) {
        Class<a> clazz = a.class;
        synchronized (clazz) {
            Object object2 = b;
            if (object2 != null) {
                return object2;
            }
            object2 = "grs_sdk_server_config.json";
            String string2 = c.a((String)object2, object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            Object object3 = null;
            if (bl2) {
                return null;
            }
            try {
                int n10;
                object2 = new JSONObject(string2);
                String string3 = "grs_server";
                JSONObject jSONObject = object2.getJSONObject(string3);
                object2 = "grs_base_url";
                object2 = jSONObject.getJSONArray((String)object2);
                if (object2 != null && (n10 = object2.length()) > 0) {
                    int n11;
                    Object object4;
                    object3 = new ArrayList();
                    for (n10 = 0; n10 < (n11 = object2.length()); object4 = object4.toString(), ++n10) {
                        object4 = object2.get(n10);
                        object3.add(object4);
                    }
                }
                b = object2 = new d();
                ((d)object2).a((List)object3);
                object2 = "grs_query_endpoint_1.0";
                object2 = jSONObject.getString((String)object2);
                object3 = b;
                ((d)object3).b((String)object2);
                object2 = "grs_query_endpoint_2.0";
                object2 = jSONObject.getString((String)object2);
                object3 = b;
                ((d)object3).a((String)object2);
                object2 = "grs_query_timeout";
                int n12 = jSONObject.getInt((String)object2);
                object2 = b;
                ((d)object2).a(n12);
                return b;
            }
            catch (JSONException jSONException) {
                object2 = a;
                object3 = "getGrsServerBean catch JSONException";
                Logger.w((String)object2, (String)object3, jSONException);
            }
            return b;
        }
    }
}

