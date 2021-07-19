/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.quvideo.mobile.external.platform.api.device;

import android.util.Log;
import com.quvideo.mobile.external.platform.api.device.OooO00o;
import com.quvideo.mobile.external.platform.httpcore.OooO;
import com.quvideo.mobile.external.platform.httpcore.OooO0OO;
import e.a.c1.b;
import e.a.h0;
import e.a.z;
import g.b0;

public class OooO0O0 {
    public static z OooO00o() {
        String string2;
        Object object = "api/rest/fs/device/bind";
        Object object2 = OooO00o.class;
        try {
            object2 = OooO.OooO00o(object2, (String)object);
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("DeviceApiProxy->api/rest/fs/device/bind->e=");
            string2 = exception.getMessage();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            Log.e((String)"QuVideoHttpCore", (String)object2, (Throwable)exception);
            return z.m2(exception);
        }
        object2 = (OooO00o)object2;
        string2 = null;
        object = OooO0OO.OooO00o((String)object, null);
        object = object2.OooO00o((b0)object);
        object2 = b.d();
        return ((z)object).L5((h0)object2);
    }
}

