/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap$b$a;
import com.xiaomi.push.service.ap$c;
import com.xiaomi.push.service.o;

public final class z
implements ap$b$a {
    public final /* synthetic */ XMPushService a;

    public z(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void a(ap$c object, ap$c ap$c, int n10) {
        object = ap$c.c;
        if (ap$c == object) {
            o.a(this.a);
            object = this.a;
            o.b((XMPushService)object);
        } else {
            object = ap$c.a;
            if (ap$c == object) {
                object = this.a;
                int n11 = 70000001;
                String string2 = " the push is not connected.";
                o.a((Context)object, n11, string2);
            }
        }
    }
}

