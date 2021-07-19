/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.el;
import com.xiaomi.push.eq;
import com.xiaomi.push.eu;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.w;
import java.util.HashMap;

public class av
implements eu {
    public void a(Context object, HashMap object2) {
        Object object3 = new il();
        CharSequence charSequence = eq.a((Context)object).a();
        ((il)object3).b((String)charSequence);
        charSequence = eq.a((Context)object).b();
        ((il)object3).d((String)charSequence);
        charSequence = hw.H.a;
        ((il)object3).c((String)charSequence);
        charSequence = an.a();
        ((il)object3).a((String)charSequence);
        ((il)object3).a = object2;
        object2 = ((il)object3).c();
        charSequence = ((il)object3).b();
        Object object4 = hm.i;
        object2 = iw.a(w.a((String)object2, (String)charSequence, (ix)object3, object4));
        boolean bl2 = object instanceof XMPushService;
        if (bl2) {
            charSequence = new StringBuilder();
            object4 = "MoleInfo : send data directly in pushLayer ";
            ((StringBuilder)charSequence).append((String)object4);
            object3 = ((il)object3).a();
            ((StringBuilder)charSequence).append((String)object3);
            b.a(((StringBuilder)charSequence).toString());
            object3 = object;
            object3 = (XMPushService)object;
            object = ((Context)object).getPackageName();
            bl2 = true;
            ((XMPushService)object3).a((String)object, (byte[])object2, bl2);
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("MoleInfo : context is not correct in pushLayer ");
            object2 = ((il)object3).a();
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            b.a((String)object);
        }
    }

    public void b(Context context, HashMap hashMap) {
        hk hk2 = hk.a(context);
        if (hk2 != null) {
            long l10 = 1L;
            String string2 = el.a(hashMap);
            String string3 = "category_awake_app";
            String string4 = "wake_up_app";
            hk2.a(string3, string4, l10, string2);
        }
    }

    public void c(Context object, HashMap object2) {
        object = new StringBuilder();
        ((StringBuilder)object).append("MoleInfo\uff1a\u3000");
        object2 = el.b((HashMap)object2);
        ((StringBuilder)object).append((String)object2);
        b.a(((StringBuilder)object).toString());
    }
}

