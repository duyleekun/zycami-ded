/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

public final class h {
    private HashMap r;

    public h() {
        HashMap hashMap;
        this.r = hashMap = new HashMap();
    }

    public final String k() {
        boolean bl2;
        String string2 = "UTF-8";
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator2 = this.r.keySet().iterator();
        boolean bl3 = true;
        while (bl2 = iterator2.hasNext()) {
            boolean bl4;
            String string3;
            String string4 = (String)iterator2.next();
            if (bl3) {
                bl3 = false;
            } else {
                string3 = "&";
                stringBuilder.append(string3);
            }
            if (bl4 = TextUtils.isEmpty((CharSequence)(string3 = (String)this.r.get(string4)))) continue;
            string4 = URLEncoder.encode(string4, string2);
            stringBuilder.append(string4);
            string4 = "=";
            stringBuilder.append(string4);
            string4 = URLEncoder.encode(string3, string2);
            try {
                stringBuilder.append(string4);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public final void put(String string2, String string3) {
        this.r.put(string2, string3);
    }
}

