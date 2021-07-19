/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.c;
import d.j.f.a.a.h.b.a;

public class PushEncrypter {
    public static String decrypter(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return "";
        }
        object = c.c(object);
        return a.k(string2, (String)object);
    }

    public static String encrypter(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return "";
        }
        object = c.c(object);
        return a.t(string2, (String)object);
    }

    public static String encrypterOld(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return "";
        }
        object = c.a(object);
        return a.v(string2, (byte[])object);
    }
}

