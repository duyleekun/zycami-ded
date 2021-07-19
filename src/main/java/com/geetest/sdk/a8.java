/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.geetest.sdk;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a8 {
    public static String a(String object) {
        String string2;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "";
        if (n10 != 0) {
            return string3;
        }
        Object object2 = "MD5";
        object2 = MessageDigest.getInstance((String)object2);
        object = ((String)object).getBytes();
        object = ((MessageDigest)object2).digest((byte[])object);
        try {
            n10 = ((Object)object).length;
            string2 = string3;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            return string3;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            StringBuilder stringBuilder;
            String string4;
            block18: {
                int n11 = object[i10] & 0xFF;
                string4 = Integer.toHexString(n11);
                int n12 = string4.length();
                int n13 = 1;
                if (n12 != n13) break block18;
                stringBuilder = new StringBuilder();
                String string5 = "0";
                stringBuilder.append(string5);
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string4);
            string2 = stringBuilder.toString();
            continue;
        }
        return string2;
    }
}

