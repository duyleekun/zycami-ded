/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.utils;

import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {
    public static String paramToQueryString(Map object, String string2) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            boolean bl3;
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl4 = true;
            object = object.entrySet().iterator();
            while (bl3 = object.hasNext()) {
                String string3;
                Object object2 = (Map.Entry)object.next();
                String string4 = (String)object2.getKey();
                object2 = (String)object2.getValue();
                if (!bl4) {
                    string3 = "&";
                    stringBuilder.append(string3);
                }
                string3 = HttpUtil.urlEncode(string4, string2);
                stringBuilder.append(string3);
                if (object2 != null) {
                    stringBuilder.append("=");
                    string3 = HttpUtil.urlEncode((String)object2, string2);
                    stringBuilder.append(string3);
                }
                bl4 = false;
                string3 = null;
            }
            return stringBuilder.toString();
        }
        return null;
    }

    public static String urlEncode(String string2, String object) {
        String string3;
        if (string2 == null) {
            return "";
        }
        try {
            string2 = URLEncoder.encode(string2, (String)object);
            object = "+";
            string3 = "%20";
        }
        catch (Exception exception) {
            object = new IllegalArgumentException("failed to encode url!", exception);
            throw object;
        }
        string2 = string2.replace((CharSequence)object, string3);
        object = "*";
        string3 = "%2A";
        string2 = string2.replace((CharSequence)object, string3);
        object = "%7E";
        string3 = "~";
        string2 = string2.replace((CharSequence)object, string3);
        object = "%2F";
        string3 = "/";
        return string2.replace((CharSequence)object, string3);
    }
}

