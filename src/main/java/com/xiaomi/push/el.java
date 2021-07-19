/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Base64
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bf;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class el {
    public static Uri a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("content://");
        stringBuilder.append(string2);
        return Uri.parse((String)stringBuilder.toString()).buildUpon().appendPath(string3).build();
    }

    public static String a(String string2) {
        return Base64.encodeToString((byte[])bf.a(string2), (int)2);
    }

    public static String a(HashMap hashMap) {
        if (hashMap == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        Object object = hashMap.keySet();
        try {
            object = object.iterator();
        }
        catch (JSONException jSONException) {
            b.a(jSONException);
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object object2 = object.next();
            object2 = (String)object2;
            Object v10 = hashMap.get(object2);
            jSONObject.put(object2, v10);
            continue;
            break;
        }
        return jSONObject.toString();
    }

    public static String b(String string2) {
        return bf.a(Base64.decode((String)string2, (int)2));
    }

    public static String b(HashMap object) {
        Object object2 = "msg_id";
        String string2 = "jobkey";
        String string3 = "flow_id";
        String string4 = "__planId__";
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if (object != null) {
            CharSequence charSequence = new StringBuilder();
            String string5 = "event_type";
            String string6 = (String)((HashMap)object).get(string5);
            ((StringBuilder)charSequence).append(string6);
            string6 = "";
            ((StringBuilder)charSequence).append(string6);
            charSequence = ((StringBuilder)charSequence).toString();
            hashMap.put(string5, charSequence);
            charSequence = new StringBuilder();
            string5 = "description";
            String string7 = (String)((HashMap)object).get(string5);
            ((StringBuilder)charSequence).append(string7);
            ((StringBuilder)charSequence).append(string6);
            charSequence = ((StringBuilder)charSequence).toString();
            hashMap.put(string5, charSequence);
            charSequence = "awake_info";
            object = (String)((HashMap)object).get(charSequence);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                charSequence = new JSONObject((String)object);
                object = charSequence.opt(string4);
                object = String.valueOf(object);
                hashMap.put(string4, object);
                object = charSequence.opt(string3);
                object = String.valueOf(object);
                hashMap.put(string3, object);
                object = charSequence.opt(string2);
                object = String.valueOf(object);
                hashMap.put(string2, object);
                object = charSequence.opt((String)object2);
                object = String.valueOf(object);
                hashMap.put(object2, object);
                object = "A";
                object2 = "awake_app";
                object2 = charSequence.opt((String)object2);
                object2 = String.valueOf(object2);
                hashMap.put(object, object2);
                object = "B";
                object2 = "awakened_app";
                object2 = charSequence.opt((String)object2);
                object2 = String.valueOf(object2);
                hashMap.put(object, object2);
                object = "module";
                object2 = "awake_type";
                object2 = charSequence.opt((String)object2);
                object2 = String.valueOf(object2);
                try {
                    hashMap.put(object, object2);
                }
                catch (JSONException jSONException) {
                    b.a(jSONException);
                }
            }
        }
        return el.a(hashMap);
    }
}

