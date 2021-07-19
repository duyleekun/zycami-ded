/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.geofence.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class a {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(String object) {
        String string2 = "";
        Object object2 = "MD5";
        try {
            object2 = MessageDigest.getInstance((String)object2);
            object = ((String)object).getBytes();
            ((MessageDigest)object2).update((byte[])object);
            object = ((MessageDigest)object2).digest();
            object2 = new StringBuffer();
            int n10 = 0;
            while (true) {
                Object object3;
                Object object4;
                if (n10 >= (object4 = ((Object)object).length)) {
                    string2 = ((StringBuffer)object2).toString();
                    return ((StringBuffer)object2).toString();
                }
                object4 = object[n10];
                if (object4 < 0) {
                    object4 += 256;
                }
                if (object4 < (object3 = 16)) {
                    String string3 = "0";
                    ((StringBuffer)object2).append(string3);
                }
                String string4 = Integer.toHexString(object4);
                ((StringBuffer)object2).append(string4);
                ++n10;
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            return string2;
        }
    }

    public static String a(HashMap object, String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        object = a.b((HashMap)object, string2);
        stringBuffer.append((String)object);
        object = new StringBuilder();
        string2 = stringBuffer.toString();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("99754106633f94d350db34d548d6091a");
        return a.a(((StringBuilder)object).toString());
    }

    /*
     * Unable to fully structure code
     */
    private static String b(HashMap var0, String var1_1) {
        var2_2 = var0.keySet().iterator();
        var3_3 = new ArrayList<K>();
        while ((var4_4 = var2_2.hasNext()) != 0) {
            var5_5 = var2_2.next();
            var3_3.add(var5_5);
        }
        Collections.sort(var3_3);
        var2_2 = new StringBuffer();
        var4_4 = 0;
        var5_5 = null;
        while (var4_4 < (var6_6 = var3_3.size())) {
            var7_7 = (String)var3_3.get(var4_4);
            var2_2.append(var7_7);
            var2_2.append("=");
            var8_10 = null;
            var9_11 = "UTF-8";
            if (var1_1 == null) {
                var7_7 = var0.get(var7_7);
                ** try [egrp 1[TRYBLOCK] [3, 2 : 124->129)] { 
lbl25:
                // 2 sources

                var8_10 = URLEncoder.encode(var7_7, var9_11);
            }
            var7_7 = var0.get(var7_7);
            ** try [egrp 4[TRYBLOCK] [9, 8 : 151->156)] { 
lbl31:
            // 2 sources

            var7_7 = URLEncoder.encode(var7_7, var9_11);
            var9_11 = "\\+";
            var10_12 = "%20";
            var7_7 = var7_7.replaceAll(var9_11, var10_12);
            var9_11 = "\\%7E";
            var10_12 = "~";
            try {
                var8_10 = var7_7.replaceAll(var9_11, var10_12);
            }
lbl41:
            // 8 sources

            catch (NullPointerException var7_8) {
                var7_8.printStackTrace();
            }
lbl44:
            // 8 sources

            catch (UnsupportedEncodingException var7_9) {
                var7_9.printStackTrace();
            }
            var2_2.append(var8_10);
            var6_6 = var3_3.size();
            if (++var4_4 >= var6_6 || var1_1 == null) continue;
            var2_2.append(var1_1);
        }
        return var2_2.toString();
    }
}

