/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.an;

public class MiPushClient4VR {
    public static void uploadData(Context object, String object2) {
        il il2 = new il();
        String string2 = hw.N.a;
        il2.c(string2);
        string2 = b.a((Context)object).a();
        il2.b(string2);
        string2 = object.getPackageName();
        il2.d(string2);
        il2.a("data", (String)object2);
        object2 = an.a();
        il2.a((String)object2);
        object = aq.a((Context)object);
        object2 = hm.i;
        ((aq)object).a((ix)il2, (hm)((Object)object2), null);
    }
}

