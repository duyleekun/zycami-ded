/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class r {
    public static String a(String object, String object2) {
        String string2;
        block7: {
            string2 = "SHACoder";
            String string3 = "UTF-8";
            object = ((String)object).getBytes(string3);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) break block7;
            object2 = "SHA-256";
        }
        object2 = MessageDigest.getInstance((String)object2);
        ((MessageDigest)object2).update((byte[])object);
        object = ((MessageDigest)object2).digest();
        object2 = null;
        try {
            return HEX.encodeHexString((byte[])object, false);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            HMSLog.e(string2, "trans failed .");
            return null;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            HMSLog.e(string2, "encrypt failed .");
            return null;
        }
    }
}

