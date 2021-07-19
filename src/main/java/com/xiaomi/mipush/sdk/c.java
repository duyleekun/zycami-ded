/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.n;
import com.xiaomi.push.el;
import com.xiaomi.push.eq;
import com.xiaomi.push.eu;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.service.an;
import java.util.HashMap;

public class c
implements eu {
    public void a(Context context, HashMap hashMap) {
        il il2 = new il();
        Object object = eq.a(context).a();
        il2.b((String)object);
        object = eq.a(context).b();
        il2.d((String)object);
        object = hw.H.a;
        il2.c((String)object);
        object = an.a();
        il2.a((String)object);
        il2.a = hashMap;
        object = aq.a(context);
        hm hm2 = hm.i;
        ((aq)object).a(il2, hm2, true, null, true);
        b.a("MoleInfo\uff1a\u3000send data in app layer");
    }

    public void b(Context object, HashMap hashMap) {
        object = el.a(hashMap);
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, (String)object);
        b.a("MoleInfo\uff1a\u3000send data in app layer");
    }

    public void c(Context context, HashMap object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("MoleInfo\uff1a\u3000");
        String string2 = el.b((HashMap)object);
        charSequence.append(string2);
        b.a(charSequence.toString());
        charSequence = (String)((HashMap)object).get("event_type");
        object = (String)((HashMap)object).get("awake_info");
        int n10 = 1007;
        string2 = String.valueOf(n10);
        boolean bl2 = string2.equals(charSequence);
        if (bl2) {
            n.a(context, (String)object);
        }
    }
}

