/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ba
extends XMPushService$i {
    private fl a;
    private XMPushService a = null;

    public ba(XMPushService xMPushService, fl fl2) {
        super(4);
        this.a = xMPushService;
        this.a = fl2;
    }

    public String a() {
        return "send a message.";
    }

    public void a() {
        block4: {
            fl fl2 = this.a;
            if (fl2 == null) break block4;
            XMPushService xMPushService = this.a;
            try {
                xMPushService.a(fl2);
            }
            catch (gd gd2) {
                b.a(gd2);
                xMPushService = this.a;
                int n10 = 10;
                xMPushService.a(n10, (Exception)gd2);
            }
        }
    }
}

