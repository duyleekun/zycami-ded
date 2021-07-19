/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs.d;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class c {
    private static final String a = "c";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(String string2, Context object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (bl2) {
            return string3;
        }
        bl2 = false;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int n10;
            int n11;
            object = object.getAssets();
            inputStream = object.open(string2);
            int n12 = 8192;
            object = new byte[n12];
            while ((n11 = inputStream.read((byte[])object)) != (n10 = -1)) {
                byteArrayOutputStream.write((byte[])object, 0, n11);
            }
            byteArrayOutputStream.flush();
            byte[] byArray = byteArrayOutputStream.toByteArray();
            String string4 = "UTF-8";
            object = new String(byArray, string4);
        }
        catch (IOException iOException) {
            try {
                object = a;
                String string5 = "local config file is not exist.filename is {%s}";
                int n13 = 1;
                Object[] objectArray = new Object[n13];
                objectArray[0] = string2;
                Logger.w((String)object, string5, objectArray);
            }
            catch (Throwable throwable) {
                IoUtils.closeSecure(byteArrayOutputStream);
                IoUtils.closeSecure(inputStream);
                throw throwable;
            }
            IoUtils.closeSecure(byteArrayOutputStream);
            IoUtils.closeSecure(inputStream);
            return string3;
        }
        IoUtils.closeSecure(byteArrayOutputStream);
        IoUtils.closeSecure(inputStream);
        return object;
    }
}

