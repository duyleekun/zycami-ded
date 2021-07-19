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
public class XMPushService$q
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;
    public ap$b a;
    public String a;
    public int b;
    public String b;

    public XMPushService$q(XMPushService xMPushService, ap$b ap$b, int n10, String string2, String string3) {
        this.a = xMPushService;
        super(9);
        this.a = null;
        this.a = ap$b;
        this.b = n10;
        this.a = string2;
        this.b = string3;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unbind the channel. ");
        String string2 = this.a.g;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void a() {
        Object object = this.a.a;
        Object object2 = ap$c.a;
        if (object != object2 && (object = XMPushService.a(this.a)) != null) {
            object = this.a;
            object = XMPushService.a((XMPushService)object);
            object2 = this.a;
            String string2 = ((ap$b)object2).g;
            object2 = ((ap$b)object2).b;
            try {
                ((fs)object).a(string2, (String)object2);
            }
            catch (gd gd2) {
                com.xiaomi.channel.commonutils.logger.b.a(gd2);
                object2 = this.a;
                int n10 = 10;
                ((XMPushService)object2).a(n10, gd2);
            }
        }
        ap$b ap$b = this.a;
        ap$c ap$c = ap$c.a;
        int n11 = this.b;
        String string3 = this.b;
        String string4 = this.a;
        ap$b.a(ap$c, n11, 0, string3, string4);
    }
}

