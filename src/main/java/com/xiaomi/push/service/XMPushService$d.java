/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$d
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;

    public XMPushService$d(XMPushService xMPushService) {
        this.a = xMPushService;
        super(1);
    }

    public String a() {
        return "do reconnect..";
    }

    public void a() {
        Object object = this.a;
        boolean bl2 = ((XMPushService)object).a();
        if (bl2) {
            object = this.a;
            XMPushService.c((XMPushService)object);
        } else {
            object = "should not connect. quit the job.";
            b.a((String)object);
        }
    }
}

