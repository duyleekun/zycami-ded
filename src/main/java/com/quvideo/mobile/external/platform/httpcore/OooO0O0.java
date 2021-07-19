/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.quvideo.mobile.external.platform.httpcore;

import android.text.TextUtils;
import com.quvideo.mobile.external.platform.httpcore.provider.OooO0OO;
import com.quvideo.mobile.external.platform.log.OooO00o;
import com.quvideo.xiaoying.jni.XYSignJni;
import d.o.a.a.b.b.a;
import org.json.JSONObject;

public abstract class OooO0O0 {
    private static XYSignJni OooO00o;

    private static String OooO00o(String string2, String object, String string3, String string4) {
        CharSequence charSequence;
        Object object2 = "/";
        boolean bl2 = ((String)object).startsWith((String)object2);
        if (!bl2) {
            charSequence = new StringBuilder();
            charSequence.append((String)object2);
            charSequence.append((String)object);
            object = charSequence.toString();
        }
        String string5 = object;
        boolean bl3 = a.f;
        if (bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getSignOfRequest appKey=");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(",reqType=POST");
            ((StringBuilder)object).append(",apiPath=");
            ((StringBuilder)object).append(string5);
            ((StringBuilder)object).append(",timestamp=");
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            object2 = "QuVideoHttpCore";
            com.quvideo.mobile.external.platform.log.OooO00o.OooO00o((String)object2, (String)object);
        }
        if ((object = OooO00o) == null) {
            OooO00o = object = new XYSignJni();
        }
        object2 = OooO00o;
        charSequence = string2;
        return ((XYSignJni)object2).getReqSign(string2, string4, null, string5, string3);
    }

    private static StringBuilder OooO00o(StringBuilder stringBuilder, String string2) {
        if (stringBuilder == null) {
            String string3 = ">>>>>>params ";
            stringBuilder = new StringBuilder(string3);
        }
        stringBuilder.append(string2);
        return stringBuilder;
    }

    public static JSONObject OooO00o(String object, String string2) {
        Object object2 = a.g().a();
        if (object2 != null) {
            if ((object2 = object2.OooO00o((String)object)) != null) {
                String string3;
                boolean bl2;
                CharSequence charSequence;
                JSONObject jSONObject = new JSONObject();
                String string4 = ((OooO0OO)object2).OooO0OO();
                if (string4 != null) {
                    string4 = ((OooO0OO)object2).OooO0OO();
                    charSequence = "userId";
                    jSONObject.put((String)charSequence, (Object)string4);
                }
                if (!(bl2 = TextUtils.isEmpty((CharSequence)(string4 = ((OooO0OO)object2).OooO00o())))) {
                    object2 = ((OooO0OO)object2).OooO00o();
                    string4 = "deviceId";
                    jSONObject.put(string4, object2);
                }
                if ((object2 = a.g().e().OooO0OO()) != null) {
                    object2 = String.valueOf(a.g().e().OooO0OO());
                    string4 = "vestBag";
                    jSONObject.put(string4, object2);
                }
                object2 = a.g().e().OooO00o();
                boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                bl2 = false;
                string4 = null;
                charSequence = null;
                if (bl3) {
                    charSequence = OooO0O0.OooO00o(null, " appKey is empty,");
                    bl3 = false;
                    object2 = null;
                } else {
                    object2 = a.g().e().OooO00o();
                    string3 = "appKey";
                    jSONObject.put(string3, object2);
                    bl3 = true;
                }
                long l10 = System.currentTimeMillis();
                string3 = String.valueOf(l10);
                jSONObject.put("timestamp", (Object)string3);
                String string5 = a.g().e().OooO0O0();
                object = OooO0O0.OooO00o(string5, (String)object, string3, string2);
                boolean bl4 = TextUtils.isEmpty((CharSequence)object);
                if (bl4) {
                    object = "sign is empty,";
                    charSequence = OooO0O0.OooO00o((StringBuilder)charSequence, (String)object);
                } else {
                    string2 = "sign";
                    jSONObject.put(string2, object);
                    bl2 = bl3;
                }
                if (bl2) {
                    return jSONObject;
                }
                OooO0O0.OooO00o((StringBuilder)charSequence, " please check<<<<<<");
                string2 = ((StringBuilder)charSequence).toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            object = new IllegalArgumentException("buildRequestBody HttpParams == null");
            throw object;
        }
        object = new IllegalArgumentException("buildRequestBody HttpClientProvider == null");
        throw object;
    }
}

