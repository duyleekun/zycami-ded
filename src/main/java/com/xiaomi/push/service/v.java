/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gd;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.p;
import com.xiaomi.push.service.w;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class v
extends XMPushService$i {
    public final /* synthetic */ ii a;
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public v(int n10, XMPushService xMPushService, ii ii2, String string2, String string3) {
        this.a = xMPushService;
        this.a = ii2;
        this.a = string2;
        this.b = string3;
        super(n10);
    }

    public String a() {
        return "send wrong message ack for message.";
    }

    public void a() {
        Object object = this.a;
        Object object2 = this.a;
        object = p.a((Context)object, (ii)object2);
        object2 = ((ii)object).a;
        String string2 = "error";
        String string3 = this.a;
        ((hz)object2).a(string2, string3);
        object2 = ((ii)object).a;
        string2 = "reason";
        string3 = this.b;
        ((hz)object2).a(string2, string3);
        object2 = this.a;
        try {
            w.a((XMPushService)object2, (ii)object);
        }
        catch (gd gd2) {
            com.xiaomi.channel.commonutils.logger.b.a(gd2);
            object2 = this.a;
            int n10 = 10;
            ((XMPushService)object2).a(n10, (Exception)gd2);
        }
    }
}

