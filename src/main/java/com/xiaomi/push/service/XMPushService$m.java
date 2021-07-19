/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fs;
import com.xiaomi.push.gd;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$m
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;
    public boolean a;

    public XMPushService$m(XMPushService xMPushService, boolean bl2) {
        this.a = xMPushService;
        super(4);
        this.a = bl2;
    }

    public String a() {
        return "send ping..";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object = this.a;
        boolean bl2 = ((XMPushService)object).c();
        if (!bl2) return;
        try {
            bl2 = this.a;
            if (!bl2) {
                hg.a();
            }
            object = this.a;
            object = XMPushService.a((XMPushService)object);
            boolean bl3 = this.a;
            ((fs)object).b(bl3);
            return;
        }
        catch (gd gd2) {
            b.a(gd2);
            XMPushService xMPushService = this.a;
            int n10 = 10;
            xMPushService.a(n10, (Exception)gd2);
        }
    }
}

