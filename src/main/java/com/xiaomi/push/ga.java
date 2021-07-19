/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.fs;
import com.xiaomi.push.fz;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ga
extends XMPushService$i {
    public final /* synthetic */ long a;
    public final /* synthetic */ fz a;

    public ga(fz fz2, int n10, long l10) {
        this.a = fz2;
        this.a = l10;
        super(n10);
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("check the ping-pong.");
        long l10 = this.a;
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }

    public void a() {
        long l10;
        Thread.yield();
        Object object = this.a;
        boolean bl2 = ((fs)object).c();
        if (bl2 && !(bl2 = ((fs)(object = this.a)).a(l10 = this.a))) {
            object = this.a.b;
            int n10 = 22;
            ((XMPushService)object).a(n10, null);
        }
    }
}

