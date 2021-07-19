/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$b$c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ar
extends XMPushService$i {
    public final /* synthetic */ ap$b$c a;

    public ar(ap$b$c ap$b$c, int n10) {
        this.a = ap$b$c;
        super(n10);
    }

    public String a() {
        return "clear peer job";
    }

    public void a() {
        Object object = this.a;
        Object object2 = ((ap$b$c)object).a;
        object = object.a.a;
        if (object2 == object) {
            object = new StringBuilder();
            ((StringBuilder)object).append("clean peer, chid = ");
            object2 = this.a.a.g;
            ((StringBuilder)object).append((String)object2);
            b.b(((StringBuilder)object).toString());
            object = this.a.a;
            object2 = null;
            ((ap$b)object).a = null;
        }
    }
}

