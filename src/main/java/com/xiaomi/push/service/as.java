/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$b$c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class as
extends XMPushService$i {
    public final /* synthetic */ ap$b$c a;

    public as(ap$b$c ap$b$c, int n10) {
        this.a = ap$b$c;
        super(n10);
    }

    public String a() {
        return "check peer job";
    }

    public void a() {
        Object object = ap.a();
        Object object2 = this.a.a;
        String string2 = ((ap$b)object2).g;
        object2 = ((ap$b)object2).b;
        object = object.a((String)string2, (String)object2).a;
        if (object == null) {
            object2 = ap$b.a(this.a.b);
            object = this.a.a;
            string2 = ((ap$b)object).g;
            String string3 = ((ap$b)object).b;
            int n10 = 2;
            ((XMPushService)object2).a(string2, string3, n10, null, null);
        }
    }
}

