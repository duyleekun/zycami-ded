/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.AbstractPushManager;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.mipush.sdk.k$a;
import com.xiaomi.push.ba;

public class al {
    public static AbstractPushManager a(Context context, d d10) {
        return al.b(context, d10);
    }

    private static AbstractPushManager b(Context context, d object) {
        String string2;
        boolean bl2;
        if ((object = k.a(object)) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((k$a)object).a))) && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((k$a)object).b)))) {
            string2 = ((k$a)object).a;
            object = ((k$a)object).b;
            Object[] objectArray = new Object[]{context};
            return (AbstractPushManager)ba.a(string2, (String)object, objectArray);
        }
        return null;
    }
}

