/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.quvideo.mobile.external.platform.httpcore;

import android.content.Context;
import com.quvideo.mobile.external.platform.httpcore.provider.OooO00o;
import com.quvideo.mobile.external.platform.httpcore.provider.OooO0O0;
import d.o.a.a.b.b.a;

public class OooO {
    public static Context OooO00o() {
        return a.g().f();
    }

    public static Object OooO00o(Class object, String string2) {
        Class<OooO> clazz = OooO.class;
        synchronized (clazz) {
            a a10 = a.g();
            boolean bl2 = true;
            object = a10.b((Class)object, string2, bl2);
            return object;
        }
    }

    public static void OooO00o(Context context, OooO0O0 oooO0O0) {
        a.g().c(context, oooO0O0);
    }

    public static void OooO00o(OooO00o oooO00o) {
        a.g().d(oooO00o);
    }
}

