/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  org.apache.http.NameValuePair
 */
package com.xiaomi.push;

import android.util.Base64;
import com.xiaomi.push.cs;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import org.apache.http.NameValuePair;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cr {
    public static String a(String object) {
        if (object == null) {
            return "";
        }
        Object object2 = "MD5";
        try {
            object2 = MessageDigest.getInstance((String)object2);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object2 = new RuntimeException(noSuchAlgorithmException);
            throw object2;
        }
        object = cr.a((String)object);
        ((MessageDigest)object2).update((byte[])object);
        object2 = ((MessageDigest)object2).digest();
        int n10 = 1;
        object = new BigInteger(n10, (byte[])object2);
        object2 = "%1$032X";
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        return String.format((String)object2, objectArray);
    }

    public static String a(List object, String string2) {
        String string3;
        Object object2 = new cs();
        Collections.sort(object, object2);
        object2 = new StringBuilder();
        object = object.iterator();
        boolean bl2 = true;
        while (true) {
            boolean bl3 = object.hasNext();
            string3 = "&";
            if (!bl3) break;
            NameValuePair nameValuePair = (NameValuePair)object.next();
            if (!bl2) {
                ((StringBuilder)object2).append(string3);
            }
            String string4 = nameValuePair.getName();
            ((StringBuilder)object2).append(string4);
            ((StringBuilder)object2).append("=");
            string4 = nameValuePair.getValue();
            ((StringBuilder)object2).append(string4);
            bl2 = false;
            string4 = null;
        }
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(string2);
        object = cr.a(((StringBuilder)object2).toString());
        object = Base64.encode((byte[])object, (int)2);
        string2 = new String((byte[])object);
        return cr.a(string2);
    }

    public static void a(String string2) {
    }

    private static byte[] a(String string2) {
        String string3 = "UTF-8";
        try {
            return string2.getBytes(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string2.getBytes();
        }
    }
}

