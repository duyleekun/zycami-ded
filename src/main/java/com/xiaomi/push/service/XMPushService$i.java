/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.g$b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class XMPushService$i
extends g$b {
    public XMPushService$i(int n10) {
        super(n10);
    }

    public abstract String a();

    public abstract void a();

    public void run() {
        int n10 = this.a;
        int n11 = 4;
        if (n10 != n11 && n10 != (n11 = 8)) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("JOB: ");
            String string2 = this.a();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            b.a((String)charSequence);
        }
        this.a();
    }
}

