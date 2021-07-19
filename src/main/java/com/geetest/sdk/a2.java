/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.sdk.a4;
import com.geetest.sdk.a9;
import com.geetest.sdk.aw;
import com.geetest.sdk.az;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.model.beans.g;
import com.geetest.sdk.utils.q;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a2
extends aw {
    private b j;

    private a2(String string2, Context context) {
        super(string2, context);
    }

    public static a2 a(Context context, b b10) {
        String string2 = a2.a(b10);
        a2 a22 = new a2(string2, context);
        a22.a(0);
        a22.c("GetCoder");
        a22.j = b10;
        return a22;
    }

    private static String a(b object) {
        CharSequence charSequence;
        Object object2;
        CharSequence charSequence2;
        String string2;
        block12: {
            block11: {
                string2 = "&w=";
                charSequence2 = q.a();
                ((b)object).a((String)charSequence2);
                object2 = new JSONObject();
                charSequence = ((b)object).m();
                if (charSequence != null) break block11;
                charSequence = "";
                break block12;
            }
            charSequence = ((b)object).m();
        }
        String string3 = "lang";
        object2.put(string3, (Object)charSequence);
        object2 = object2.toString();
        object2 = a4.b((String)object2, (String)charSequence2);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append((String)object2);
        charSequence2 = a9.b((String)charSequence2);
        try {
            ((StringBuilder)charSequence).append((String)charSequence2);
            string2 = ((StringBuilder)charSequence).toString();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        charSequence2 = new StringBuilder();
        object2 = new Object[1];
        charSequence = ((b)object).b();
        object2[0] = charSequence;
        object2 = String.format("https://%s/get.php?gt=", object2);
        ((StringBuilder)charSequence2).append((String)object2);
        object2 = ((b)object).k();
        ((StringBuilder)charSequence2).append((String)object2);
        ((StringBuilder)charSequence2).append("&challenge=");
        object2 = ((b)object).c();
        ((StringBuilder)charSequence2).append((String)object2);
        ((StringBuilder)charSequence2).append("&client_type=android&lang=");
        object = ((b)object).m();
        ((StringBuilder)charSequence2).append((String)object);
        ((StringBuilder)charSequence2).append("&client_type=android");
        ((StringBuilder)charSequence2).append(string2);
        return ((StringBuilder)charSequence2).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(int n10, az az2, JSONObject jSONObject) {
        ArrayList<Object> arrayList;
        a2 a22 = this;
        az az3 = az2;
        Object object = jSONObject;
        Object object2 = "error_code";
        CharSequence charSequence = "user_error";
        Object object3 = jSONObject.optString((String)charSequence);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        String string2 = "";
        int n11 = 1;
        int n12 = 0;
        String string3 = null;
        if (!bl2) {
            Exception exception2;
            block15: {
                charSequence = "utf-8";
                try {
                    try {
                        object3 = URLDecoder.decode((String)object3, (String)charSequence);
                    }
                    catch (UnsupportedEncodingException unsupportedEncodingException) {
                        unsupportedEncodingException.printStackTrace();
                    }
                }
                catch (Exception exception2) {
                    break block15;
                }
                charSequence = object.optString((String)object2);
                if (charSequence != null) {
                    String string4 = "[a-zA-Z]";
                    charSequence = ((String)charSequence).replaceAll(string4, string2);
                }
                az3.a = object3;
                object3 = new JSONObject();
                object3.put((String)object2, (Object)charSequence);
                az3.b = object3;
                return n11 != 0;
            }
            exception2.printStackTrace();
            object2 = new StringBuilder();
            object = jSONObject.toString();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(": ");
            String string5 = exception2.toString();
            ((StringBuilder)object2).append(string5);
            string5 = ((StringBuilder)object2).toString();
            az3.a = string5;
            return false;
        }
        charSequence = "data";
        object2 = jSONObject.optJSONObject((String)charSequence);
        object3 = ":  ";
        if (object2 == null) {
            object2 = new StringBuilder();
            object = jSONObject.toString();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append((String)object3);
            charSequence = this.a((String)charSequence);
            ((StringBuilder)object2).append((String)charSequence);
            charSequence = ((StringBuilder)object2).toString();
            az2.a = charSequence;
            return false;
        }
        charSequence = object2.optString("s");
        String string6 = object2.optString("theme_version");
        String string7 = object2.optString("feedback");
        boolean bl3 = TextUtils.isEmpty((CharSequence)string7);
        if (!bl3) {
            string2 = string7;
        }
        string7 = "api_server";
        String string8 = object2.optString(string7);
        boolean bl4 = TextUtils.isEmpty((CharSequence)string8);
        if (bl4) {
            charSequence = new StringBuilder();
            object = jSONObject.toString();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append((String)object3);
            object = a22.a(string7);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            az3.a = charSequence;
            return false;
        }
        string7 = object2.optString("theme");
        String string9 = "logo";
        boolean bl5 = object2.has(string9);
        if (!bl5) {
            charSequence = new StringBuilder();
            object = jSONObject.toString();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append((String)object3);
            object = a22.a(string9);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            az3.a = charSequence;
            return false;
        }
        bl4 = object2.optBoolean(string9);
        com.geetest.sdk.model.beans.f.a(bl4);
        String string10 = "static_servers";
        JSONArray jSONArray = object2.optJSONArray(string10);
        ArrayList<String> arrayList2 = new ArrayList<String>();
        if (jSONArray != null) {
            arrayList = null;
            for (n11 = 0; (n12 = jSONArray.length()) > n11; ++n11) {
                string3 = jSONArray.optString(n11);
                boolean bl6 = TextUtils.isEmpty((CharSequence)string3);
                if (bl6) continue;
                arrayList2.add(string3);
            }
        }
        if ((n11 = arrayList2.size()) == 0) {
            charSequence = new StringBuilder();
            object = jSONObject.toString();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append((String)object3);
            object = a22.a(string10);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            az3.a = charSequence;
            return false;
        }
        int n13 = 0;
        object3 = null;
        arrayList = new ArrayList<Object>();
        string3 = "c";
        if ((object2 = object2.optJSONArray(string3)) != null) {
            string3 = null;
            for (n12 = 0; n12 < (n13 = object2.length()); ++n12) {
                n13 = object2.optInt(n12);
                object3 = n13;
                arrayList.add(object3);
            }
        }
        object2 = new g();
        ((g)object2).a(string8);
        ((g)object2).a(arrayList);
        ((g)object2).b(string2);
        ((g)object2).a(bl4);
        ((g)object2).b(arrayList2);
        ((g)object2).d(string7);
        ((g)object2).e(string6);
        ((g)object2).c((String)charSequence);
        a22.j.a((g)object2);
        az3.a = "OK";
        az3.b = object;
        return true;
    }

    public Map c() {
        int n10;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string2 = "application/x-www-form-urlencoded";
        hashMap.put("Content-Type", string2);
        Object object = this.j;
        if (object != null) {
            object = ((b)object).b();
            string2 = "Host";
            hashMap.put(string2, object);
        }
        if ((object = (Object)this.f) == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((Object)object).length;
        }
        object = String.valueOf(n10);
        hashMap.put("Content-Length", object);
        return hashMap;
    }

    public boolean e() {
        return false;
    }
}

