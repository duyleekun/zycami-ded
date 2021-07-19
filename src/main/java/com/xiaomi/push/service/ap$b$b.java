/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap$b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ap$b$b
extends XMPushService$i {
    public final /* synthetic */ ap$b a;
    public String a;
    public int b;
    public String b;
    public int c;

    public ap$b$b(ap$b ap$b) {
        this.a = ap$b;
        super(0);
    }

    public XMPushService$i a(int n10, int n11, String string2, String string3) {
        this.b = n10;
        this.c = n11;
        this.b = string3;
        this.a = string2;
        return this;
    }

    public String a() {
        return "notify job";
    }

    public void a() {
        Object object = this.a;
        int n10 = this.b;
        int n11 = this.c;
        String string2 = this.b;
        boolean bl2 = ap$b.a((ap$b)object, n10, n11, string2);
        if (bl2) {
            object = this.a;
            n10 = this.b;
            n11 = this.c;
            string2 = this.a;
            String string3 = this.b;
            ap$b.a((ap$b)object, n10, n11, string2, string3);
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append(" ignore notify client :");
            String string4 = this.a.g;
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            com.xiaomi.channel.commonutils.logger.b.b((String)object);
        }
    }
}

