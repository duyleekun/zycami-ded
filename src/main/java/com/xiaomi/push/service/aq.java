/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$b$a;
import com.xiaomi.push.service.ap$c;

public class aq
implements ap$b$a {
    public final /* synthetic */ ap$b a;

    public aq(ap$b ap$b) {
        this.a = ap$b;
    }

    public void a(ap$c object, ap$c object2, int n10) {
        object = ap$c.b;
        if (object2 == object) {
            object = ap$b.a(this.a);
            object2 = ap$b.a(this.a);
            long l10 = 60000L;
            ((XMPushService)object).a((XMPushService$i)object2, l10);
        } else {
            object = ap$b.a(this.a);
            object2 = ap$b.a(this.a);
            ((XMPushService)object).b((XMPushService$i)object2);
        }
    }
}

