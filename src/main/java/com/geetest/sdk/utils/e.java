/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Debug
 *  android.text.TextUtils
 */
package com.geetest.sdk.utils;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.geetest.sdk.utils.c;

public class e {
    private static boolean a() {
        try {
            return Debug.isDebuggerConnected();
        }
        catch (Exception exception) {
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(Context context) {
        boolean bl2 = false;
        try {
            context = context.getApplicationInfo();
        }
        catch (Exception exception) {
            return bl2;
        }
        int n10 = context.flags & 2;
        if (n10 == 0) return bl2;
        return true;
    }

    public static int b(Context context) {
        int n10;
        block5: {
            block4: {
                boolean bl2;
                n10 = 0;
                try {
                    bl2 = e.a(context);
                    if (bl2) break block4;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return 0;
                }
                bl2 = e.a();
                if (bl2) break block4;
                bl2 = e.b();
                if (!bl2) break block5;
            }
            n10 = 1;
        }
        return n10;
    }

    private static boolean b() {
        boolean bl2;
        Object object = c.a();
        String string2 = "getprop init.svc.adbd";
        boolean bl3 = TextUtils.isEmpty((CharSequence)(object = ((c)object).a(string2)));
        if (!bl3 && (bl2 = ((String)object).contains(string2 = "running"))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

