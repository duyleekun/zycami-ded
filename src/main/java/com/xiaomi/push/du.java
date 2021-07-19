/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ag;
import com.xiaomi.push.bc;
import com.xiaomi.push.h;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;

public class du {
    private static void a(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 2;
        if (n10 >= n11) {
            byArray[0] = 99;
            n10 = 1;
            byArray[n10] = n11 = 100;
        }
    }

    public static boolean a(Context context, String string2, long l10) {
        boolean bl2;
        ak ak2 = ak.a(context);
        hr hr2 = hr.aY;
        int n10 = hr2.a();
        boolean bl3 = false;
        boolean bl4 = ak2.a(n10, false);
        if (bl4 && !(bl2 = ag.a(context, string2, l10))) {
            bl3 = true;
        }
        return bl3;
    }

    public static byte[] a(String object, byte[] byArray) {
        object = bc.a((String)object);
        du.a((byte[])object);
        try {
            object = h.a((byte[])object, byArray);
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
    }

    public static byte[] b(String object, byte[] byArray) {
        object = bc.a((String)object);
        du.a((byte[])object);
        try {
            object = h.b((byte[])object, byArray);
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
    }
}

