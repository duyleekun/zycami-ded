/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.w;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bm
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ String a;
    public final /* synthetic */ byte[] a;

    public bm(XMPushService xMPushService, int n10, String string2, byte[] byArray) {
        this.a = xMPushService;
        this.a = string2;
        this.a = byArray;
        super(n10);
    }

    public String a() {
        return "send mi push message";
    }

    public void a() {
        XMPushService xMPushService = this.a;
        Object object = this.a;
        byte[] byArray = this.a;
        try {
            w.a(xMPushService, (String)object, byArray);
        }
        catch (gd gd2) {
            b.a(gd2);
            object = this.a;
            int n10 = 10;
            ((XMPushService)object).a(n10, (Exception)gd2);
        }
    }
}

