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
import com.geetest.sdk.aw;
import com.geetest.sdk.az;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.h;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a3
extends aw {
    private b j;

    private a3(String string2, Context context) {
        super(string2, context);
    }

    public static a3 a(Context context, b b10) {
        CharSequence charSequence = new StringBuilder();
        Object object = new Object[1];
        String string2 = b10.b();
        object[0] = string2;
        object = String.format("https://%s/gettype.php?gt=", object);
        charSequence.append((String)object);
        object = b10.k();
        charSequence.append((String)object);
        charSequence.append("&t=");
        long l10 = System.currentTimeMillis();
        charSequence.append(l10);
        charSequence = charSequence.toString();
        a3 a32 = new a3((String)charSequence, context);
        a32.a(0);
        a32.c("Gettype");
        a32.j = b10;
        return a32;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(int n10, az az2, JSONObject jSONObject) {
        Object object;
        String string2;
        boolean bl2;
        a3 a32 = this;
        az az3 = az2;
        Object object2 = jSONObject;
        CharSequence charSequence = "error_code";
        CharSequence charSequence2 = "user_error";
        HashMap<String, Integer> hashMap = jSONObject.optString((String)charSequence2);
        boolean bl3 = TextUtils.isEmpty((CharSequence)((Object)hashMap));
        boolean bl4 = true;
        int n11 = 0;
        h h10 = null;
        if (!bl3) {
            Exception exception2;
            block12: {
                charSequence2 = "utf-8";
                try {
                    try {
                        hashMap = URLDecoder.decode((String)((Object)hashMap), (String)charSequence2);
                    }
                    catch (UnsupportedEncodingException unsupportedEncodingException) {
                        unsupportedEncodingException.printStackTrace();
                    }
                }
                catch (Exception exception2) {
                    break block12;
                }
                charSequence2 = object2.optString((String)charSequence);
                if (charSequence2 != null) {
                    String string3 = "[a-zA-Z]";
                    String string4 = "";
                    charSequence2 = ((String)charSequence2).replaceAll(string3, string4);
                }
                az3.a = hashMap;
                hashMap = new HashMap<String, Integer>();
                hashMap.put((String)charSequence, charSequence2);
                az3.b = hashMap;
                return bl4;
            }
            exception2.printStackTrace();
            charSequence = new StringBuilder();
            object2 = jSONObject.toString();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(": ");
            String string5 = exception2.toString();
            ((StringBuilder)charSequence).append(string5);
            string5 = ((StringBuilder)charSequence).toString();
            az3.a = string5;
            return false;
        }
        charSequence2 = "data";
        charSequence = jSONObject.optJSONObject((String)charSequence2);
        hashMap = ":  ";
        if (charSequence == null) {
            charSequence = new StringBuilder();
            object2 = jSONObject.toString();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append((String)((Object)hashMap));
            charSequence2 = this.a((String)charSequence2);
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence2 = ((StringBuilder)charSequence).toString();
            az2.a = charSequence2;
            return false;
        }
        charSequence2 = charSequence.optString("type");
        Object object3 = "aspect_radio";
        Object object4 = charSequence.optJSONObject((String)object3);
        if (object4 == null) {
            charSequence2 = new StringBuilder();
            object2 = jSONObject.toString();
            ((StringBuilder)charSequence2).append((String)object2);
            ((StringBuilder)charSequence2).append((String)((Object)hashMap));
            object2 = this.a((String)object3);
            ((StringBuilder)charSequence2).append((String)object2);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            az2.a = charSequence2;
            return false;
        }
        hashMap = new HashMap<String, Integer>();
        object3 = object4.keys();
        while (bl2 = object3.hasNext()) {
            string2 = (String)object3.next();
            int n12 = object4.optInt(string2);
            object = n12;
            hashMap.put(string2, (Integer)object);
        }
        object3 = charSequence.optString("fullpage");
        object4 = charSequence.optString("click");
        string2 = charSequence.optString("voice");
        object = charSequence.optString("slide");
        String string6 = charSequence.optString("geetest");
        JSONArray jSONArray = charSequence.optJSONArray("static_servers");
        ArrayList<String> arrayList = new ArrayList<String>();
        if (jSONArray != null) {
            int n13;
            while ((n13 = jSONArray.length()) > n11) {
                String string7 = jSONArray.optString(n11);
                boolean bl5 = TextUtils.isEmpty((CharSequence)string7);
                if (!bl5) {
                    arrayList.add(string7);
                }
                ++n11;
            }
        }
        h10 = new h();
        h10.a(hashMap);
        h10.a((String)object4);
        h10.b(string6);
        h10.c((String)object);
        h10.d((String)charSequence2);
        h10.e((String)object3);
        h10.f(string2);
        h10.a(arrayList);
        h10.a((JSONObject)charSequence);
        a32.j.a(h10);
        az3.a = "OK";
        az3.b = object2;
        return bl4;
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

