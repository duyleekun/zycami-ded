/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.framework.network.grs.IQueryUrlsCallBack;
import com.huawei.hms.framework.network.grs.a$a;
import com.huawei.hms.framework.network.grs.a$b;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static final String a = "a";
    private GrsBaseInfo b;
    private com.huawei.hms.framework.network.grs.a.a c;
    private m d;
    private c e;

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.a a10, m m10, c c10) {
        this.b = grsBaseInfo;
        this.c = a10;
        this.d = m10;
        this.e = c10;
    }

    public static CountryCodeBean a(Context context, boolean bl2) {
        CountryCodeBean countryCodeBean = new CountryCodeBean(context, bl2);
        return countryCodeBean;
    }

    public static /* synthetic */ String a() {
        return a;
    }

    private String a(String object, String string2, com.huawei.hms.framework.network.grs.a.b object2, Context context) {
        Object object3 = this.c;
        Object object4 = this.b;
        Object object5 = string2;
        Object object6 = object2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((com.huawei.hms.framework.network.grs.a.a)object3).a((GrsBaseInfo)object4, (String)object, string2, (com.huawei.hms.framework.network.grs.a.b)object2, context)));
        if (!bl2) {
            Logger.i(a, "get url from sp is not empty.");
            object = this.b;
            com.huawei.hms.framework.network.grs.b.b.a(context, (GrsBaseInfo)object);
            return object2;
        }
        object2 = context.getPackageName();
        object3 = this.b;
        object4 = com.huawei.hms.framework.network.grs.b.b.a((String)object2, (GrsBaseInfo)object3);
        object5 = this.c;
        object6 = this.b;
        return ((b)object4).a(context, (com.huawei.hms.framework.network.grs.a.a)object5, (GrsBaseInfo)object6, (String)object, string2, false);
    }

    public static String a(String string2, String string3, String string4) {
        JSONObject jSONObject;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string5 = "";
        if (bl2) {
            return string5;
        }
        try {
            jSONObject = new JSONObject(string2);
        }
        catch (JSONException jSONException) {
            Logger.w(a, "Method{getServiceNameUrl} query url from SP occur an JSONException", jSONException);
            return string5;
        }
        string2 = jSONObject.getJSONObject(string3);
        return string2.getString(string4);
    }

    public static Map a(String object) {
        JSONObject jSONObject;
        HashMap hashMap = new HashMap(16);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            Logger.v(a, "isSpExpire jsonValue is null.");
            return hashMap;
        }
        try {
            jSONObject = new JSONObject((String)object);
            object = jSONObject.keys();
        }
        catch (JSONException jSONException) {
            Logger.w(a, "getServicesUrlsMap occur a JSONException", jSONException);
            return hashMap;
        }
        while (true) {
            boolean bl3 = object.hasNext();
            if (!bl3) break;
            Object object2 = object.next();
            object2 = object2.toString();
            Object object3 = jSONObject.getJSONObject(object2);
            object3 = com.huawei.hms.framework.network.grs.a.a(object3);
            hashMap.put(object2, (JSONObject)object3);
            continue;
            break;
        }
        return hashMap;
    }

    private Map a(String object, com.huawei.hms.framework.network.grs.a.b object2, Context context) {
        boolean bl2;
        Object object3 = this.c;
        Object object4 = this.b;
        if ((object2 = ((com.huawei.hms.framework.network.grs.a.a)object3).a((GrsBaseInfo)object4, (String)object, (com.huawei.hms.framework.network.grs.a.b)object2, context)) != null && !(bl2 = object2.isEmpty())) {
            Logger.i(a, "get url from sp is not empty.");
            object = this.b;
            com.huawei.hms.framework.network.grs.b.b.a(context, (GrsBaseInfo)object);
            return object2;
        }
        object2 = context.getPackageName();
        object3 = this.b;
        object4 = com.huawei.hms.framework.network.grs.b.b.a((String)object2, (GrsBaseInfo)object3);
        com.huawei.hms.framework.network.grs.a.a a10 = this.c;
        GrsBaseInfo grsBaseInfo = this.b;
        return ((b)object4).a(context, a10, grsBaseInfo, (String)object, false);
    }

    public static Map a(String string2, String object) {
        Object object2;
        boolean bl2;
        HashMap<Object, Object> hashMap;
        block15: {
            hashMap = new HashMap<Object, Object>();
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) {
                Logger.v(a, "isSpExpire jsonValue is null.");
                return hashMap;
            }
            object2 = new JSONObject(string2);
            string2 = object2.getJSONObject((String)object);
            if (string2 != null) break block15;
            string2 = a;
            object = "getServiceNameUrls jsObject null.";
            Logger.v(string2, object);
            return hashMap;
        }
        try {
            object = string2.keys();
        }
        catch (JSONException jSONException) {
            Logger.w(a, "Method{getServiceNameUrls} query url from SP occur an JSONException", jSONException);
            return hashMap;
        }
        while (true) {
            bl2 = object.hasNext();
            if (!bl2) break;
            object2 = object.next();
            object2 = object2.toString();
            Object object3 = string2.get((String)object2);
            object3 = object3.toString();
            hashMap.put(object2, object3);
            continue;
            break;
        }
        return hashMap;
    }

    public static Map a(JSONObject jSONObject) {
        Iterator iterator2;
        int n10 = 16;
        HashMap hashMap = new HashMap(n10);
        try {
            iterator2 = jSONObject.keys();
        }
        catch (JSONException jSONException) {
            Logger.w(a, "getServiceUrls occur a JSONException", jSONException);
            return hashMap;
        }
        while (true) {
            boolean bl2 = iterator2.hasNext();
            if (!bl2) break;
            Object object = iterator2.next();
            object = object.toString();
            Object object2 = jSONObject.get(object);
            object2 = object2.toString();
            hashMap.put(object, object2);
            continue;
            break;
        }
        return hashMap;
    }

    private void a(String string2, Map object, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        Object object2 = this.b;
        com.huawei.hms.framework.network.grs.c.b.c c10 = new com.huawei.hms.framework.network.grs.c.b.c((GrsBaseInfo)object2, context);
        object2 = this.d;
        GrsBaseInfo grsBaseInfo = this.b;
        com.huawei.hms.framework.network.grs.a.a a10 = this.c;
        a$a a$a = new a$a(string2, (Map)object, iQueryUrlsCallBack, context, grsBaseInfo, a10);
        object = this.e;
        ((m)object2).a(c10, a$a, string2, (c)object);
    }

    public String a(Context object, String string2) {
        m m10 = this.d;
        GrsBaseInfo grsBaseInfo = this.b;
        com.huawei.hms.framework.network.grs.c.b.c c10 = new com.huawei.hms.framework.network.grs.c.b.c(grsBaseInfo, (Context)object);
        object = this.e;
        object = (object = m10.a(c10, string2, (c)object)) == null ? "" : object.i();
        return object;
    }

    public String a(String object, String objectArray, Context context) {
        Object object2 = new com.huawei.hms.framework.network.grs.a.b();
        Object object3 = this.a((String)object, (String)objectArray, (com.huawei.hms.framework.network.grs.a.b)object2, context);
        boolean bl2 = ((com.huawei.hms.framework.network.grs.a.b)object2).a();
        if (bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object3))) {
            object = a;
            objectArray = new Object[]{object3};
            Logger.v((String)object, "get unexpired cache localUrl{%s}", objectArray);
            object = this.b;
            com.huawei.hms.framework.network.grs.b.b.a(context, (GrsBaseInfo)object);
            return object3;
        }
        object2 = com.huawei.hms.framework.network.grs.a.a(this.a(context, (String)object), (String)object, (String)objectArray);
        boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl3) {
            Logger.i(a, "get url is from remote server");
            object = this.b;
            com.huawei.hms.framework.network.grs.b.b.a(context, (GrsBaseInfo)object);
            return object2;
        }
        bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (bl2) {
            Logger.i(a, "access local config for return a domain.");
            object2 = context.getPackageName();
            object3 = this.b;
            b b10 = com.huawei.hms.framework.network.grs.b.b.a((String)object2, (GrsBaseInfo)object3);
            com.huawei.hms.framework.network.grs.a.a a10 = this.c;
            GrsBaseInfo grsBaseInfo = this.b;
            boolean bl4 = true;
            object3 = b10.a(context, a10, grsBaseInfo, (String)object, (String)objectArray, bl4);
        }
        return object3;
    }

    public Map a(String object, Context context) {
        Object object2 = new com.huawei.hms.framework.network.grs.a.b();
        Object object3 = this.a((String)object, (com.huawei.hms.framework.network.grs.a.b)object2, context);
        boolean bl2 = ((com.huawei.hms.framework.network.grs.a.b)object2).a();
        if (bl2 && object3 != null && !(bl2 = object3.isEmpty())) {
            object = this.b;
            com.huawei.hms.framework.network.grs.b.b.a(context, (GrsBaseInfo)object);
            return object3;
        }
        object2 = com.huawei.hms.framework.network.grs.a.a(this.a(context, (String)object), (String)object);
        boolean bl3 = object2.isEmpty();
        if (!bl3) {
            object = this.b;
            com.huawei.hms.framework.network.grs.b.b.a(context, (GrsBaseInfo)object);
            return object2;
        }
        if (object3 != null && (bl2 = object3.isEmpty())) {
            Logger.i(a, "access local config for return a domain.");
            object2 = context.getPackageName();
            object3 = this.b;
            b b10 = com.huawei.hms.framework.network.grs.b.b.a((String)object2, (GrsBaseInfo)object3);
            com.huawei.hms.framework.network.grs.a.a a10 = this.c;
            GrsBaseInfo grsBaseInfo = this.b;
            boolean bl4 = true;
            object3 = b10.a(context, a10, grsBaseInfo, (String)object, bl4);
        }
        return object3;
    }

    public void a(String object, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        com.huawei.hms.framework.network.grs.a.b b10 = new com.huawei.hms.framework.network.grs.a.b();
        Map map = this.a((String)object, b10, context);
        boolean bl2 = b10.a();
        if (bl2) {
            int n10;
            if (map != null && (n10 = (int)(map.isEmpty() ? 1 : 0)) == 0) {
                object = this.b;
                com.huawei.hms.framework.network.grs.b.b.a(context, (GrsBaseInfo)object);
                iQueryUrlsCallBack.onCallBackSuccess(map);
            } else {
                n10 = -5;
                iQueryUrlsCallBack.onCallBackFail(n10);
            }
            return;
        }
        this.a((String)object, map, iQueryUrlsCallBack, context);
    }

    public void a(String object, String object2, IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        a$b a$b;
        Object object3 = new com.huawei.hms.framework.network.grs.a.b();
        String string2 = this.a((String)object, (String)object2, (com.huawei.hms.framework.network.grs.a.b)object3, context);
        boolean bl2 = ((com.huawei.hms.framework.network.grs.a.b)object3).a();
        if (bl2) {
            int n10 = TextUtils.isEmpty((CharSequence)string2);
            if (n10 != 0) {
                n10 = -5;
                iQueryUrlCallBack.onCallBackFail(n10);
            } else {
                object = this.b;
                com.huawei.hms.framework.network.grs.b.b.a(context, (GrsBaseInfo)object);
                iQueryUrlCallBack.onCallBackSuccess(string2);
            }
            return;
        }
        Object object4 = this.b;
        object3 = new com.huawei.hms.framework.network.grs.c.b.c((GrsBaseInfo)object4, context);
        m m10 = this.d;
        GrsBaseInfo grsBaseInfo = this.b;
        com.huawei.hms.framework.network.grs.a.a a10 = this.c;
        object4 = a$b;
        a$b = new a$b((String)object, (String)object2, iQueryUrlCallBack, string2, context, grsBaseInfo, a10);
        object2 = this.e;
        m10.a((com.huawei.hms.framework.network.grs.c.b.c)object3, a$b, (String)object, (c)object2);
    }
}

