/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs.d;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b {
    private static final String a = "b";
    private static final Pattern b = Pattern.compile("[0-9]*[a-z|A-Z]*[\u4e00-\u9fa5]*");

    public static String a(String string2) {
        return com.huawei.hms.framework.network.grs.d.b.a(string2, "SHA-256");
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(String object, String object2) {
        String string2 = "UTF-8";
        object = ((String)object).getBytes(string2);
        try {
            object2 = MessageDigest.getInstance((String)object2);
            object = ((MessageDigest)object2).digest((byte[])object);
            return com.huawei.hms.framework.network.grs.d.b.a((byte[])object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            block4: {
                object = a;
                object2 = "encrypt NoSuchAlgorithmException";
                break block4;
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    object = a;
                    object2 = "encrypt UnsupportedEncodingException";
                }
            }
            Logger.w((String)object, object2);
            return null;
        }
    }

    private static String a(byte[] byArray) {
        int n10;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            int n11;
            n10 = byArray[i10] & 0xFF;
            String string2 = Integer.toHexString(n10);
            int n12 = string2.length();
            if (n12 == (n11 = 1)) {
                String string3 = "0";
                stringBuffer.append(string3);
            }
            stringBuffer.append(string2);
        }
        return stringBuffer.toString();
    }

    public static String b(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            return string2;
        }
        n11 = string2.length();
        String string3 = "*";
        int n12 = 1;
        if (n11 == n12) {
            return string3;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            CharSequence charSequence = new StringBuilder();
            int n13 = string2.charAt(i10);
            charSequence.append((char)n13);
            charSequence.append("");
            charSequence = charSequence.toString();
            Matcher matcher = b.matcher(charSequence);
            n13 = (int)(matcher.matches() ? 1 : 0);
            if (n13 != 0) {
                n13 = n12 % 2;
                if (n13 == 0) {
                    charSequence = string3;
                }
                ++n12;
            }
            stringBuffer.append((String)charSequence);
        }
        return stringBuffer.toString();
    }
}

