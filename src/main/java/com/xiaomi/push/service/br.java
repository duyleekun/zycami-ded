/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ek$b;
import com.xiaomi.push.ft;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.be;
import java.util.Map;

public class br
extends ft {
    public final /* synthetic */ XMPushService a;

    public br(XMPushService xMPushService, Map map, int n10, String string2, fw fw2) {
        this.a = xMPushService;
        super(map, n10, string2, fw2);
    }

    public byte[] a() {
        Object object;
        ek$b ek$b;
        try {
            ek$b = new ek$b();
            object = be.a();
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getOBBString err: ");
            String string2 = exception.toString();
            ((StringBuilder)object).append(string2);
            com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
            return null;
        }
        int n10 = ((be)object).a();
        ek$b.a(n10);
        return ek$b.a();
    }
}

