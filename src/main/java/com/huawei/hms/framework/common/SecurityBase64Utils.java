/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.huawei.hms.framework.common;

import android.util.Base64;
import com.huawei.hms.framework.common.StringUtils;
import d.j.f.a.a.k.f;

public class SecurityBase64Utils {
    private static boolean IS_AEGIS_BASE64_LIBRARY_LOADED = false;
    private static final String SAFE_BASE64_PATH = "com.huawei.secure.android.common.util.SafeBase64";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean checkCompatible(String object) {
        boolean bl2;
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass((String)object);
            object = StringUtils.class;
            synchronized (object) {
                IS_AEGIS_BASE64_LIBRARY_LOADED = bl2 = true;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
        return bl2;
    }

    public static byte[] decode(String string2, int n10) {
        String string3;
        boolean bl2 = IS_AEGIS_BASE64_LIBRARY_LOADED;
        if (!bl2 && !(bl2 = SecurityBase64Utils.checkCompatible(string3 = SAFE_BASE64_PATH))) {
            try {
                return Base64.decode((String)string2, (int)n10);
            }
            catch (Exception exception) {
                return new byte[0];
            }
        }
        return f.a(string2, n10);
    }

    public static String encodeToString(byte[] byArray, int n10) {
        String string2;
        boolean bl2 = IS_AEGIS_BASE64_LIBRARY_LOADED;
        if (!bl2 && !(bl2 = SecurityBase64Utils.checkCompatible(string2 = SAFE_BASE64_PATH))) {
            try {
                return Base64.encodeToString((byte[])byArray, (int)n10);
            }
            catch (Exception exception) {
                return null;
            }
        }
        return f.f(byArray, n10);
    }
}

