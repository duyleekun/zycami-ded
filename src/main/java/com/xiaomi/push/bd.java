/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class bd {
    public static String a(String object) {
        IllegalStateException illegalStateException;
        String string2 = "CloudCoder.hash4SHA1 ";
        Object object2 = "SHA1";
        object2 = MessageDigest.getInstance((String)object2);
        String string3 = "UTF-8";
        object = ((String)object).getBytes(string3);
        object = ((MessageDigest)object2).digest((byte[])object);
        object = bc.a((byte[])object);
        try {
            return String.valueOf((char[])object);
        }
        catch (Exception exception) {
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        b.a(string2, (Throwable)illegalStateException);
        illegalStateException = new IllegalStateException("failed to SHA1");
        throw illegalStateException;
    }

    public static String a(String object, String string2, Map iterator2, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            boolean bl3;
            Object object3 = new ArrayList();
            if (object != null) {
                object = ((String)object).toUpperCase();
                object3.add(object);
            }
            if (string2 != null) {
                object = Uri.parse((String)string2).getEncodedPath();
                object3.add(object);
            }
            object = null;
            char c10 = '\u0001';
            if (iterator2 != null && !(bl3 = iterator2.isEmpty())) {
                Object object4 = new TreeMap(iterator2);
                iterator2 = ((TreeMap)object4).entrySet().iterator();
                while (bl3 = iterator2.hasNext()) {
                    object4 = iterator2.next();
                    int n10 = 2;
                    Object[] objectArray = new Object[n10];
                    Object k10 = object4.getKey();
                    objectArray[0] = k10;
                    objectArray[c10] = object4 = object4.getValue();
                    object4 = String.format("%s=%s", objectArray);
                    object3.add(object4);
                }
            }
            object3.add(object2);
            iterator2 = new Iterator();
            object2 = object3.iterator();
            while (bl2 = object2.hasNext()) {
                object3 = (String)object2.next();
                if (c10 == '\u0000') {
                    c10 = '&';
                    ((StringBuilder)((Object)iterator2)).append(c10);
                }
                ((StringBuilder)((Object)iterator2)).append((String)object3);
                c10 = '\u0000';
                string2 = null;
            }
            return bd.a(((StringBuilder)((Object)iterator2)).toString());
        }
        object = new InvalidParameterException("security is not nullable");
        throw object;
    }
}

