/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.heytap.mcssdk.f;

import android.text.TextUtils;
import com.heytap.mcssdk.f.b;
import com.heytap.mcssdk.f.c;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class a {
    public static final String a = "com.nearme.mcs";

    private static String a() {
        String string2;
        byte[] byArray = com.heytap.mcssdk.f.a.a(com.heytap.mcssdk.f.a.a(a));
        if (byArray != null) {
            Charset charset = Charset.forName("UTF-8");
            string2 = new String(byArray, charset);
        } else {
            string2 = "";
        }
        return string2;
    }

    public static byte[] a(String string2) {
        if (string2 == null) {
            return new byte[0];
        }
        String string3 = "UTF-8";
        try {
            return string2.getBytes(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] byArray) {
        int n10 = byArray.length % 2;
        n10 = n10 == 0 ? byArray.length : byArray.length + -1;
        for (int i10 = 0; i10 < n10; i10 += 2) {
            byte by2;
            byte by3 = byArray[i10];
            int n11 = i10 + 1;
            byArray[i10] = by2 = byArray[n11];
            byArray[n11] = by3;
        }
        return byArray;
    }

    public static String b(String string2) {
        block4: {
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                CharSequence charSequence = com.heytap.mcssdk.f.a.a();
                try {
                    string2 = b.a(string2, (String)charSequence);
                    break block4;
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    String string3 = "desDecrypt-";
                    ((StringBuilder)charSequence).append(string3);
                    string2 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string2);
                    string2 = ((StringBuilder)charSequence).toString();
                    c.e(string2);
                }
            }
            string2 = "";
        }
        return string2;
    }
}

