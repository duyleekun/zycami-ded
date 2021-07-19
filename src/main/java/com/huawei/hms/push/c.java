/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

public class c {
    public static byte[] a(Bundle object, String charSequence) {
        block2: {
            try {
                object = object.getByteArray((String)charSequence);
                if (object != null) break block2;
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("getByteArray exception");
                String string2 = exception.getMessage();
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                HMSLog.i("BundleUtil", string2);
                return new byte[0];
            }
            object = new byte[0];
        }
        return object;
    }

    public static String b(Bundle bundle, String charSequence) {
        try {
            return bundle.getString((String)charSequence);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("getString exception");
            String string2 = exception.getMessage();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            HMSLog.i("BundleUtil", string2);
            return null;
        }
    }

    public static String c(Bundle object, String charSequence) {
        String string2 = "";
        try {
            object = object.getString((String)charSequence);
            if (object == null) {
                return string2;
            }
            return object;
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("getString exception");
            String string3 = exception.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            HMSLog.i("BundleUtil", string3);
            return string2;
        }
    }
}

