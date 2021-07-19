/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.w;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class q
extends XMPushService$i {
    public final /* synthetic */ ii a;
    public final /* synthetic */ XMPushService a;

    public q(int n10, XMPushService xMPushService, ii ii2) {
        this.a = xMPushService;
        this.a = ii2;
        super(n10);
    }

    public String a() {
        return "send app absent message.";
    }

    public void a() {
        XMPushService xMPushService = this.a;
        Object object = this.a;
        object = ((ii)object).b();
        Object object2 = this.a;
        object2 = ((ii)object2).a();
        object = w.a((String)object, (String)object2);
        try {
            w.a(xMPushService, (ii)object);
        }
        catch (gd gd2) {
            b.a(gd2);
            object = this.a;
            int n10 = 10;
            ((XMPushService)object).a(n10, (Exception)gd2);
        }
    }
}

