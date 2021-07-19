/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.quvideo.mobile.external.platform.uploader.utils;

import android.text.TextUtils;
import java.io.File;

public class OooO00o {
    public static String OooO00o(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        string2 = n10 == 0 && (n10 = string2.lastIndexOf(46)) > 0 ? string2.substring(n10) : "";
        return string2;
    }

    public static String OooO0O0(String string2) {
        block11: {
            String string3 = "_";
            boolean bl2 = OooO00o.OooO0o0(string2);
            if (bl2) {
                File file;
                try {
                    file = new File(string2);
                }
                catch (Throwable throwable) {}
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(string3);
                long l10 = file.length();
                stringBuilder.append(l10);
                stringBuilder.append(string3);
                long l11 = file.lastModified();
                stringBuilder.append(l11);
                string2 = stringBuilder.toString();
                string2 = com.quvideo.mobile.external.platform.httpcore.util.OooO00o.OooO00o(string2);
                break block11;
            }
            string2 = "";
        }
        return string2;
    }

    public static String OooO0OO(String string2) {
        Object object = new File(string2);
        int n10 = TextUtils.isEmpty((CharSequence)(string2 = ((File)object).getName()));
        if (n10 == 0 && (n10 = string2.lastIndexOf((String)(object = "."))) > 0) {
            string2 = string2.substring(0, n10);
        }
        return string2;
    }

    public static String OooO0Oo(String string2) {
        if (string2 == null) {
            return null;
        }
        String string3 = File.separator;
        boolean bl2 = string2.endsWith(string3);
        if (bl2) {
            return "";
        }
        int n10 = string2.lastIndexOf(string3);
        if (n10 > 0) {
            string2 = string2.substring(++n10);
        }
        return string2;
    }

    public static boolean OooO0o0(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        File file = new File(string2);
        boolean bl4 = file.isFile();
        if (bl4 && (bl4 = file.exists())) {
            bl3 = true;
        }
        return bl3;
    }
}

