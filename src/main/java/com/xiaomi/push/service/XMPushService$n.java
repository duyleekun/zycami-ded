/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fs;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$n
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;
    public ap$b a;

    public XMPushService$n(XMPushService xMPushService, ap$b ap$b) {
        this.a = xMPushService;
        super(4);
        this.a = null;
        this.a = ap$b;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rebind the client. ");
        String string2 = this.a.g;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void a() {
        Object object = this.a;
        Object object2 = ap$c.a;
        int n10 = 1;
        int n11 = 16;
        ap$c ap$c = null;
        int n12 = 0;
        ((ap$b)object).a((ap$c)((Object)object2), n10, n11, null, null);
        object = this.a;
        object = XMPushService.a((XMPushService)object);
        object2 = this.a;
        String string2 = ((ap$b)object2).g;
        object2 = ((ap$b)object2).b;
        ((fs)object).a(string2, (String)object2);
        ap$b ap$b = this.a;
        ap$c = ap$c.b;
        n12 = 1;
        int n13 = 16;
        ap$b.a(ap$c, n12, n13, null, null);
        object = this.a;
        object = XMPushService.a((XMPushService)object);
        object2 = this.a;
        try {
            ((fs)object).a((ap$b)object2);
        }
        catch (gd gd2) {
            b.a(gd2);
            object2 = this.a;
            n10 = 10;
            ((XMPushService)object2).a(n10, (Exception)gd2);
        }
    }
}

