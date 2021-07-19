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
public class c
extends XMPushService$i {
    private XMPushService a;
    private fl[] a = null;

    public c(XMPushService xMPushService, fl[] flArray) {
        super(4);
        this.a = xMPushService;
        this.a = flArray;
    }

    public String a() {
        return "batch send message.";
    }

    public void a() {
        block4: {
            fl[] flArray = this.a;
            if (flArray == null) break block4;
            XMPushService xMPushService = this.a;
            try {
                xMPushService.a(flArray);
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

